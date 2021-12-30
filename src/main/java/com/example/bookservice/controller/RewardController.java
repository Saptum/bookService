package com.example.bookservice.controller;

import com.example.bookservice.model.Reward;

import com.example.bookservice.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @PostMapping("/saveReward")
    public Reward saveReward(@RequestBody Reward reward) {
        return rewardService.saveReward(reward);
    }

    @PostMapping("/saveRewards")
    public List<Reward> saveReward(@RequestBody List<Reward> rewards) {
        return rewardService.saveRewards(rewards);
    }

    @GetMapping("/rewards")
    public List<Reward> getRewards() {
        return rewardService.findAll();
    }

    @GetMapping("/rewardById/{id}")
    public Reward getRewardById(@PathVariable Long id) {
        return rewardService.getRewardById(id);
    }

    @GetMapping("/rewardByName/{name}")
    public List<Reward> getRewardByName(@PathVariable String name) {
        return rewardService.getRewardsByName(name);
    }

    @PutMapping("/updateReward")
    public Reward updateReward(@RequestBody Reward reward) {
        return rewardService.updateReward(reward);
    }

    @PutMapping("author/{author_id}/reward/{reward_id}")
    public Reward assignRewardToAuthor(@PathVariable Long author_id, @PathVariable Long reward_id) {
        return rewardService.addRewardToAuthor(author_id, reward_id);
    }

    @DeleteMapping("/deleteReward/{id}")
    public String deleteReward(@PathVariable Long id) {
        return rewardService.deleteReward(id);
    }
}
