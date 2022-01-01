package com.example.bookservice.service;

import com.example.bookservice.model.Author;
import com.example.bookservice.model.Reward;
import com.example.bookservice.repository.AuthorRepository;
import com.example.bookservice.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;
    @Autowired
    private AuthorRepository authorRepository;


    public Reward saveReward(Reward reward) {
        return rewardRepository.save(reward);
    }


    public List<Reward> saveRewards(List<Reward> rewards) {
        return  rewardRepository.saveAll(rewards);
    }

    public List<Reward> findAll() {
        return rewardRepository.findAll();
    }

    public List<Reward> getRewardsByName(String name) {
        return rewardRepository.findAllByName(name);
    }

    public Reward getRewardById(Long id) {
        return rewardRepository.findById(id).orElse(null);
    }

    public Reward updateReward(Reward reward) {
        Reward updatedReward = rewardRepository.findById(reward.getId()).orElse(null);
        updatedReward.setName(reward.getName());
        updatedReward.setDescription(reward.getDescription());
        updatedReward.setAuthor(reward.getAuthor());
        return rewardRepository.save(updatedReward);
    }

    public String deleteReward(Long id) {
       rewardRepository.deleteById(id);
        return "Reward " + id + " was deleted!";
    }

    public Reward addRewardToAuthor(Long author_id, Long reward_id) {
        Reward reward = rewardRepository.findById(reward_id).orElse(null);
        Author author = authorRepository.findById(author_id).orElse(null);
        reward.assignAuthor(author);
        return rewardRepository.save(reward);
    }
}
