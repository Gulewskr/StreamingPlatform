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
import rg.ragulajw.data.models.ResponseHandler;
import rg.ragulajw.data.models.SingleDescriptionCreate;
import rg.ragulajw.services.DescriptionServices;
import rg.ragulajw.services.ImageServices;
import rg.ragulajw.services.SingleDescriptionServices;
import rg.ragulajw.services.UserServices;

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

    @PostMapping("/newSingleDescription")
    public ResponseEntity<Object> createNewDescription(@RequestBody SingleDescriptionCreate singleDesc)
    {
        //zwraca id utworzonego
        SingleDescription description = new SingleDescription();
        description.setColumn(singleDesc.get_column());
        description.setPlaceInColumn(singleDesc.getPlaceInColumn());
        SingleDescription d = sDescServices.add(description);
        if(d != null){
            return ResponseHandler.generateResponse("Succesfull created new description field", HttpStatus.OK, d);
        }else{
            return ResponseHandler.generateErrorResponse(1, "Description field not created try again", HttpStatus.BAD_REQUEST);
        }
        //HATEOAS:
        //Link do usunięcia
        //Link do zapisu
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateSingleDescription(@RequestBody SingleDescriptionCreate singleDesc, @PathVariable Long id)
    {
        SingleDescription description = new SingleDescription();
        SingleDescription d = sDescServices.update(description, id);
        if(d != null){
            return ResponseHandler.generateResponse("Successfully updated description field", HttpStatus.OK, d);
        }else{
            return ResponseHandler.generateErrorResponse(1, "Description field not updated try again", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/main/id={id}")
    public ResponseEntity<Object> getDescriptionById(@PathVariable Long id)
    {
        Description d = services.getById(id);
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @GetMapping("/user={userId}")
    public ResponseEntity<Object> getDescriptionByUserId(@PathVariable Long userId)
    {
        Description d = services.getByUserId(userId);
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @PutMapping()
    public ResponseEntity<Object> addNewDescription(@RequestBody DescriptionCreate description, @RequestParam(name = "id", required = false, defaultValue = "-1") Long id)
    {
        User user = userServices.getById(description.getUserId());
        Image img = imageServices.getById(description.getImageId());

        if(user != null)
        {
            Description d = new Description();
            d.setUser(user);
            d.setProfileImage(img);
            d.setText(description.getText());
            d.setDescriptions(description.getDescriptions());
            Description addedDescription;
            if(id == -1)
            {
                addedDescription = services.add(d);
            }else{
                addedDescription = services.update(d, id);
            }
            return ResponseHandler.generateResponse("Updated Description", HttpStatus.OK, addedDescription);
        }else{
            return ResponseHandler.generateErrorResponse(1, "Not Implemented", HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
