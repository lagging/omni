package com.creditsaison.omni.controllers;

import com.creditsaison.omni.pojos.FeedbackReq;
import com.creditsaison.omni.util.exception.CSException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/feedback")
public class FeedbackController extends BaseController {

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> submitFeedback(@RequestBody FeedbackReq feedbackReq) throws CSException {
        System.out.println("******** submit feedback request received ******");
        System.out.println("******** experience name ******" + feedbackReq.getExperienceName());
        System.out.println("******** experience value ******" + feedbackReq.getValue());
        return this.executeTask(() -> true);
    }
}
