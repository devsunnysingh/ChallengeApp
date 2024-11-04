package com.devsunnysingh.ChallengeApp.model;

import jakarta.persistence.*;



@Entity
@Table(name = "challenge")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;
    private String description;

    // Default constructor
    public Challenge() {
    }

    // Parameterized constructor
    public Challenge(Long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
