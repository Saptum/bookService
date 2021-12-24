package com.example.bookservice.repository;

import com.example.bookservice.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<Reward,Long> {
}
