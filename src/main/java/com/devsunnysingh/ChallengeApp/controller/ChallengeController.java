package com.devsunnysingh.ChallengeApp.controller;

import com.devsunnysingh.ChallengeApp.model.Challenge;
import com.devsunnysingh.ChallengeApp.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = {"http://localhost:3000", "http://10.0.0.109:3000"})
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;

    // GET all challenges
    @GetMapping
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    // GET challenge by ID
    @GetMapping("/{id}")
    public ResponseEntity<Challenge> getChallengeById(@PathVariable Long id) {
        return challengeService.getChallengeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CREATE a new challenge
    @PostMapping
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        return challengeService.createChallenge(challenge);
    }

    // UPDATE a challenge
    @PutMapping("/{id}")
    public ResponseEntity<Challenge> updateChallenge(@PathVariable Long id, @RequestBody Challenge challengeDetails) {
        try {
            Challenge updatedChallenge = challengeService.updateChallenge(id, challengeDetails);
            return ResponseEntity.ok(updatedChallenge);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a challenge
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChallenge(@PathVariable Long id) {
        try {
            challengeService.deleteChallenge(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
