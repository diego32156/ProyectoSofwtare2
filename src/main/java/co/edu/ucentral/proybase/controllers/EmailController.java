package co.edu.ucentral.proybase.controllers;

import co.edu.ucentral.proybase.entity.EmailRequest;
import co.edu.ucentral.proybase.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmailController {


    private EmailService emailService;



    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody EmailRequest request) {
        emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody());
    }
}
