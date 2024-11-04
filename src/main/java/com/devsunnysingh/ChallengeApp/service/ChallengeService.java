package com.devsunnysingh.ChallengeApp.service;

import com.devsunnysingh.ChallengeApp.model.Challenge;
import com.devsunnysingh.ChallengeApp.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ChallengeService {
    @Autowired
    private ChallengeRepository challengeRepository;

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public Optional<Challenge> getChallengeById(Long id) {
        return challengeRepository.findById(id);
    }

    public Challenge createChallenge(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    public Challenge updateChallenge(Long id, Challenge challengeDetails) {
        Challenge challenge = challengeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Challenge not found"));

        challenge.setMonth(challengeDetails.getMonth());
        challenge.setDescription(challengeDetails.getDescription());
        return challengeRepository.save(challenge);
    }

    public void deleteChallenge(Long id) {
        if (challengeRepository.existsById(id)) {
            challengeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Challenge not found");
        }
    }
}
