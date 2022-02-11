package rg.ragulajw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rg.ragulajw.data.domain.Description;
import rg.ragulajw.data.domain.Image;
import rg.ragulajw.data.domain.SingleDescription;
import rg.ragulajw.data.domain.User;
import rg.ragulajw.data.models.DescriptionCreate;
import rg.ragulajw.data.models.DescriptionUpdate;
import rg.ragulajw.data.models.ResponseHandler;
import rg.ragulajw.data.models.SingleDescriptionCreate;
import rg.ragulajw.services.DescriptionServices;
import rg.ragulajw.services.ImageServices;
import rg.ragulajw.services.SingleDescriptionServices;
import rg.ragulajw.services.UserServices;

import java.util.List;

@RestController
@RequestMapping("description")
public class DescriptionController {

    @Autowired
    DescriptionServices services;
    @Autowired
    SingleDescriptionServices sDescServices;
    @Autowired
    UserServices userServices;
    @Autowired
    ImageServices imageServices;

    @GetMapping()
    public ResponseEntity<Object> getAllDescriptions()
    {
        List<Description> d = services.getAll();
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getDescriptionById(@PathVariable Long id)
    {
        Description d = services.getById(id);
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateDescriptionById(@RequestBody DescriptionUpdate description, @PathVariable Long id)
    {
        Image image = imageServices.getById(description.getImageId());
        User user = userServices.getById(description.getUserId());
        Description d = new Description();
        d.setUser(user);
        d.setProfileImage(image);
        d.setText(description.getText());
        d = services.update(d, id);
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteDescriptionById(@PathVariable Long id)
    {
        services.deleteById(id);
        return ResponseHandler.generateResponse("Deleted description", HttpStatus.OK, null);
    }


    //Po użytkowniku

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getDescriptionByUserId(@PathVariable Long userId)
    {
        Description d = services.getByUserId(userId);
        if(d == null)
            return addNewDescription(userId);
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Object> addNewDescription(@PathVariable Long userId)
    {
        User user = userServices.getById(userId);

        if(user != null)
        {
            Description d = new Description();
            d.setUser(user);
            Description addedDescription = services.add(d);
            return ResponseHandler.generateResponse("Updated Description", HttpStatus.OK, addedDescription);
        }else{
            return ResponseHandler.generateErrorResponse(1, "Not Implemented", HttpStatus.NOT_IMPLEMENTED);
        }
    }


    @PutMapping("/user/{userId}")
    public ResponseEntity<Object> updateDescriptionByUser(@RequestBody DescriptionCreate description, @PathVariable Long userId)
    {
        Description d = services.getByUserId(userId);
        Image image = imageServices.getById(description.getImageId());

        if(d == null)
        {
            User user = userServices.getById(userId);

            if(user != null)
            {
                d = new Description();
                d.setUser(user);
                d.setText(description.getText());
                d.setProfileImage(image);
                d = services.add(d);
                return ResponseHandler.generateResponse("Successfully updated description field", HttpStatus.OK, d);
            }
            return ResponseHandler.generateErrorResponse(1, "No user with ID", HttpStatus.BAD_REQUEST);
        }else{
            d.setText(description.getText());
            d.setProfileImage(image);
            d.setDescriptions(description.getDescriptions());
            d = services.update(d, d.getId());
        }
        return ResponseHandler.generateResponse("Successfully updated description field", HttpStatus.OK, d);
    }
}