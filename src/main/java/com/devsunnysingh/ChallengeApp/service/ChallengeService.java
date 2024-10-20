package com.devsunnysingh.ChallengeApp.service;

import com.devsunnysingh.ChallengeApp.controller.Challenge;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges=new ArrayList<>();
    private Long nextId=1L;

    public ChallengeService(List<Challenge> challenges) {
        Challenge challenge1=new Challenge(1L,"January","Learn a new language");
        challenges.add(challenge1);
    }
    public List<Challenge> getAllChallenges(){
        return challenges;
    }
    public boolean addChallenges(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        } else {
            return false;
        }
    }
    public List<Challenge> getChallengesByMonth(String month) {
        List<Challenge> challengeInMonth = new ArrayList<>();
        for (Challenge ch : challenges) {
            // Normalize case for comparison
            if (ch.getMonth().equalsIgnoreCase(month)) {
                challengeInMonth.add(ch);
            }
        }
        // Return an empty list if no challenges found
        return challengeInMonth;
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        for(Challenge c: challenges){
            if(c.getId().equals(id)){
                c.setDescription(updatedChallenge.getDescription());
                c.setMonth(updatedChallenge.getMonth());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        for(Challenge c: challenges){
            if(c.getId().equals(id)){
                challenges.remove(c);
                return true;
            }
        }
        return false;

    }
}
