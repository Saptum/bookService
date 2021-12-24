package com.example.bookservice.service;

import com.example.bookservice.model.Reward;
import com.example.bookservice.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;


    public Reward saveReward(Reward reward) {
        return rewardRepository.save(reward);
    }

    public List<Reward> findAll() {
        return rewardRepository.findAll();
    }

    public List<Reward> getRewardsByName(String name) {
        return rewardRepository.findAllByName(name);
    }
}
