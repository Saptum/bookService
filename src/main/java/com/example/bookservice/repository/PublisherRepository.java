package com.example.bookservice.repository;

import com.example.bookservice.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    Publisher findByName(String name);

    List<Publisher> findAllByCountry(String country);

    List<Publisher> findAllByCity(String city);

    Publisher findByAddress(String address);
}
