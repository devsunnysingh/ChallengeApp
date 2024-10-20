package com.devsunnysingh.ChallengeApp.controller;

import com.devsunnysingh.ChallengeApp.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    public ChallengeController(){
//        Challenge challenge1=new Challenge(1L,"January","Learn a new language");
//        challengeService.addChallenges(challenge1);
    }

    @GetMapping("/health")
    public String hello() {
        System.out.println("App is running healthy!!");
        return "App is running healthy!!";
    }
    @GetMapping("/listallchallenges")
    public List<Challenge> listChallenges() {
        System.out.println("this is the controller");
        return challengeService.getAllChallenges();
    }
    @GetMapping("/{month}")
    public List<Challenge> getChallengeByMonth(@PathVariable String month) {
        return challengeService.getChallengesByMonth(month);
    }

    @PostMapping("")
    public String addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded=challengeService.addChallenges(challenge);
        if(isChallengeAdded){
            return "Challneege added";
        }else{
            return "Challenge not added successfully";
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
        boolean isUpdated=challengeService.updateChallenge(id, updatedChallenge);
        if(isUpdated){
            return new ResponseEntity<>("Challenge updated success", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Challenge updated failure", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isDeleted=challengeService.deleteChallenge(id);
        if(isDeleted){
            return new ResponseEntity<>("Challenge deletion success", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Challenge deletion failure", HttpStatus.NOT_FOUND);
        }
    }

}
