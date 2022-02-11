package rg.ragulajw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rg.ragulajw.data.domain.Description;
import rg.ragulajw.data.domain.SingleDescription;
import rg.ragulajw.data.models.ResponseHandler;
import rg.ragulajw.data.models.SingleDescriptionCreate;
import rg.ragulajw.services.DescriptionServices;
import rg.ragulajw.services.ImageServices;
import rg.ragulajw.services.SingleDescriptionServices;
import rg.ragulajw.services.UserServices;

import java.util.List;

@RestController
@RequestMapping("description")
public class SingleDescriptionController {

    @Autowired
    DescriptionServices services;
    @Autowired
    SingleDescriptionServices sDescServices;
    @Autowired
    UserServices userServices;
    @Autowired
    ImageServices imageServices;

    @PostMapping("/mini")
    public ResponseEntity<Object> createNewDescription(@RequestBody SingleDescriptionCreate singleDesc)
    {
        SingleDescription sg = new SingleDescription();
        sg.setImage(singleDesc.getImage());
        sg.setImageRef(singleDesc.getImageRef());
        sg.setText(singleDesc.getText());
        sg.setColumn(singleDesc.get_column());
        sg.setPlaceInColumn(singleDesc.getPlaceInColumn());
        sg = sDescServices.add(sg);
        return ResponseHandler.generateResponse("Succesfull created", HttpStatus.OK, sg);
    }

    @GetMapping("/mini")
    public ResponseEntity<Object> getListOfMiniDescriptions()
    {
        List<SingleDescription> sg = sDescServices.getAll();
        return ResponseHandler.generateResponse("List", HttpStatus.OK, sg);
    }

    @GetMapping("/mini/{id}")
    public ResponseEntity<Object> getMiniDescriptionById(@PathVariable long id)
    {
        SingleDescription sg = sDescServices.getById(id);
        return ResponseHandler.generateResponse("List", HttpStatus.OK, sg);
    }

    @DeleteMapping("/mini/{id}")
    public ResponseEntity<Object> deleteMiniDescriptionById(@PathVariable long id)
    {
        sDescServices.deleteById(id);
        return ResponseHandler.generateResponse("Deleted successfully", HttpStatus.OK, null);
    }

    @PostMapping("/main={id}/mini")
    public ResponseEntity<Object> createAndAddNewDescription(@RequestBody SingleDescriptionCreate singleDesc, @PathVariable long id)
    {
        SingleDescription description = new SingleDescription();
        description.setColumn(singleDesc.get_column());
        description.setPlaceInColumn(singleDesc.getPlaceInColumn());
        SingleDescription d = sDescServices.add(description);

        Description desc = services.getById(id);
        if(desc != null)
            services.addDescriptionToDescription(desc, d);

        if(d != null){
            return ResponseHandler.generateResponse("Successfully created new description field", HttpStatus.OK, d);
        }else{
            return ResponseHandler.generateErrorResponse(1, "Description field not created try again", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user/{userID}/mini")
    public ResponseEntity<Object> createAndAddNewDescriptionByUser(@RequestBody SingleDescriptionCreate singleDesc, @PathVariable long userID)
    {
        SingleDescription description = new SingleDescription();
        description.setColumn(singleDesc.get_column());
        description.setPlaceInColumn(singleDesc.getPlaceInColumn());
        SingleDescription d = sDescServices.add(description);


        Description desc = services.getByUserId(userID);
        if(desc != null)
            services.addDescriptionToDescription(desc, d);

        if(d != null){
            return ResponseHandler.generateResponse("Successfully created new description field", HttpStatus.OK, d);
        }else{
            return ResponseHandler.generateErrorResponse(1, "Description field not created try again", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/mini/{id}")
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

    //Usuwanie mini opisu
    @DeleteMapping("/main/{id}/mini/{miniId}")
    public ResponseEntity<Object> removeMiniDescriptionFromList(@PathVariable long id, @PathVariable long miniId)
    {
        Description d = services.getById(id);
        if(d == null)
        {
            return ResponseHandler.generateErrorResponse(1, "Cannot get descriptions by userID's try again", HttpStatus.BAD_REQUEST);
        }else{
            d = services.removeDescriptionFromDescription(d, miniId);
            deleteMiniDescriptionById(miniId);
            return ResponseHandler.generateResponse("Successfully", HttpStatus.OK, d);
        }
    }
}
