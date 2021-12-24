package com.example.bookservice.repository;

import com.example.bookservice.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardRepository extends JpaRepository<Reward,Long> {
    List<Reward> findAllByName(String name);
}
