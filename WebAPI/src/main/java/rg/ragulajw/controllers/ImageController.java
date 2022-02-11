package rg.ragulajw.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rg.ragulajw.data.domain.Image;
import rg.ragulajw.data.domain.User;
import rg.ragulajw.data.models.ImageCreate;
import rg.ragulajw.data.models.ResponseHandler;
import rg.ragulajw.data.models.UserCreate;
import rg.ragulajw.services.ImageServices;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("images")
public class ImageController {

    @Autowired
    ImageServices imageServices;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getImageById(@PathVariable long id)
    {
        try {
            //User user = userServices.getById(id);
            return ResponseHandler.generateResponse(
                    String.format("Got image info with id %d", id),
                    HttpStatus.OK,
                    null);
        } catch (Exception e){
            return ResponseHandler.generateErrorResponse(
                    1,
                    String.format("Cannot find image with id %d", id),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> getImageById(@RequestBody ImageCreate form, @PathVariable long id)
    {
        try {
            Image image = new Image();
            image.setName(form.getName());
            image.setDescription(form.getDescription());
            image.setImageUrl(form.getImageUrl());

            Image updated = imageServices.update(image, id);
            return ResponseHandler.generateResponse(
                    String.format("Got image info with id %d", id),
                    HttpStatus.OK,
                    updated);
        } catch (Exception e){
            return ResponseHandler.generateErrorResponse(
                    1,
                    String.format("Cannot find image with id %d", id),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Object> addImage(@RequestBody ImageCreate form)
    {
        try{
            Image image = new Image();
            image.setName(form.getName());
            image.setDescription(form.getDescription());
            image.setImageUrl(form.getImageUrl());

            imageServices.add(image);
            return ResponseHandler.generateResponse(
                    "Image added",
                    HttpStatus.OK,
                    null);
        }catch (Exception e){
            return ResponseHandler.generateErrorResponse(
                    1,
                    "Cannot add image",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String uploadImage()
    {
        return null;
    }
}
