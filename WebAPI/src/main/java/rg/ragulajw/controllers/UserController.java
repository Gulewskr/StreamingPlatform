package rg.ragulajw.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rg.ragulajw.data.domain.User;
import rg.ragulajw.data.models.ResponseHandler;
import rg.ragulajw.data.models.UserCreate;
import rg.ragulajw.data.models.UserLogin;
import rg.ragulajw.services.UserServices;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping()
    public ResponseEntity<Object> getUserList()
    {
        try {
            List<User> users = userServices.getAll();
            return ResponseHandler.generateResponse(
                    "Successful got list of users.",
                    HttpStatus.OK,
                    users);
        } catch (Exception e){
            return ResponseHandler.generateErrorResponse(
                    1,
                    "Cannot get list of users.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable long id)
    {
        try {
            User user = userServices.getById(id);
            return ResponseHandler.generateResponse(
                    String.format("Got user info with id %d", id),
                    HttpStatus.OK,
                    user);
        } catch (Exception e){
            return ResponseHandler.generateErrorResponse(
                    1,
                    String.format("Cannot find user with id %d", id),
                    HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody UserCreate userForm, @PathVariable long id)
    {
        try {
            User user = new User();
            user.setName(userForm.getName());
            user.setEmail(userForm.getEmail());
            user.setPassword(userForm.getPassword());

            User updated = userServices.update(user, id);
            return ResponseHandler.generateResponse(
                    String.format("Got user info with id %d", id),
                    HttpStatus.OK,
                    updated);
        } catch (Exception e){
            return ResponseHandler.generateErrorResponse(
                    1,
                    String.format("Cannot find user with id %d", id),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> addUser(@RequestBody UserCreate userForm)
    {
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        userServices.add(user);
        return ResponseHandler.generateResponse(
                "User registered",
                HttpStatus.OK,
                null);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLogin form)
    {
        try{
            User user = userServices.getByLoginAndPassword(form.getEmail(), form.getPassword());
            Long now = System.currentTimeMillis();
            String token = Jwts.builder()
                    .setSubject(user.getName())
                    .claim("id", user.getId())
                    .claim("email", user.getEmail())
                    .setIssuedAt(new Date(now))
                    .setExpiration(new Date(now + 10000))
                    .signWith(SignatureAlgorithm.HS512, "secretKeyHidden").compact();
            return ResponseHandler.generateResponse("User logged in", HttpStatus.OK, token);
        } catch (NullPointerException e){
            return ResponseHandler.generateErrorResponse(1, "Bad email or password", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean userFormValidation()
    {
        return true;
    }
}
