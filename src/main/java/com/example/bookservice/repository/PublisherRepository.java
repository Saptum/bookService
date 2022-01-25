package com.example.bookservice.repository;

import com.example.bookservice.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long> {
    Publisher findByName(String name);

    List<Publisher> findAllByCountry(String country);

    List<Publisher> findAllByCity(String city);

    Publisher findByAddress(String address);
}
