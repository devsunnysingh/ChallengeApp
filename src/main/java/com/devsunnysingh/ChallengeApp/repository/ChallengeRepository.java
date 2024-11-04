package com.devsunnysingh.ChallengeApp.repository;

import com.devsunnysingh.ChallengeApp.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge,Long> {
}
