package rg.ragulajw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rg.ragulajw.data.domain.Description;
import rg.ragulajw.data.domain.SingleDescription;
import rg.ragulajw.data.models.ResponseHandler;
import rg.ragulajw.services.DescriptionServices;
import rg.ragulajw.services.ImageServices;
import rg.ragulajw.services.SingleDescriptionServices;
import rg.ragulajw.services.UserServices;

@RestController
@RequestMapping("description")
public class DescriptionUserController {

    @Autowired
    DescriptionServices services;
    @Autowired
    SingleDescriptionServices sDescServices;
    @Autowired
    UserServices userServices;
    @Autowired
    ImageServices imageServices;

    //Dodawanie mini opisu do głównego
    @PostMapping("/main={id}/mini={miniId}")
    public ResponseEntity<Object> addMiniDescriptionToList(@PathVariable long id, @PathVariable long miniId)
    {
        Description d = services.getById(id);
        SingleDescription sg = sDescServices.getById(miniId);
        if(d == null || sg == null)
        {
            return ResponseHandler.generateErrorResponse(1, "Cannot get descriptions by id's try again", HttpStatus.BAD_REQUEST);
        }else{
            d = services.addDescriptionToDescription(d, sg);
            return ResponseHandler.generateResponse("Successfully", HttpStatus.OK, d);
        }
    }

    @PostMapping("/user={id}/mini={miniId}")
    public ResponseEntity<Object> addMiniDescriptionToListByUser(@PathVariable long id, @PathVariable long miniId)
    {
        Description d = services.getByUserId(id);
        SingleDescription sg = sDescServices.getById(miniId);
        if(d == null || sg == null)
        {
            return ResponseHandler.generateErrorResponse(1, "Cannot get descriptions by id's try again", HttpStatus.BAD_REQUEST);
        }else{
            d = services.addDescriptionToDescription(d, sg);
            return ResponseHandler.generateResponse("Successfully", HttpStatus.OK, d);
        }
    }
}
