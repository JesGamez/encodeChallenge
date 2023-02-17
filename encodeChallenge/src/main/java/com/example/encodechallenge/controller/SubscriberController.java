package com.example.encodechallenge.controller;

import com.example.encodechallenge.model.ServiceResponse;
import com.example.encodechallenge.model.Subscriber;
import com.example.encodechallenge.service.ISubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subscriber")
@CrossOrigin("*")
public class SubscriberController {

    @Autowired
    private ISubscriberService iSubscriberService;

    @GetMapping("/list")
    public ResponseEntity<List<Subscriber>> list(){
        var result = iSubscriberService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Subscriber subscriber){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iSubscriberService.save(subscriber);
        if (result == 1){
            serviceResponse.setMessage("Item saved success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Subscriber subscriber){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iSubscriberService.update(subscriber);
        if (result == 1){
            serviceResponse.setMessage("Item update success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iSubscriberService.deleteById(id);
        if (result == 1){
            serviceResponse.setMessage("Item removed success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
