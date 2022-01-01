package com.example.bookservice.controller;

import com.example.bookservice.model.Publisher;
import com.example.bookservice.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @PostMapping("/savePublisher")
    public Publisher savePublisher(@RequestBody Publisher publisher) {
        return publisherService.savePubliser(publisher);
    }

    @PostMapping("/savePublishers")
    public List<Publisher> savePublishers(@RequestBody List<Publisher> publishers) {
        return publisherService.saveAllPublisher(publishers);
    }

    @GetMapping("/publishers")
    public List<Publisher> getPublishers() {
        return publisherService.getPublishers();
    }

    @GetMapping("/publisherById/{id}")
    public Publisher getPublisherById(@PathVariable Long id) {
        return publisherService.getPublisherById(id);
    }

    @GetMapping("/publisherByName/{name}")
    public Publisher getPublishersByName(@PathVariable String name) {
        return publisherService.getPublisherByName(name);
    }

    @GetMapping("/publishersByCountry/{country}")
    public List<Publisher> getPublishersByCountry(@PathVariable String country) {
        return publisherService.getPublishersByCountry(country);
    }

    @GetMapping("/publishersByCity/{city}")
    public List<Publisher> getPublishersByCity(@PathVariable String city) {
        return publisherService.getPublishersByCity(city);
    }

    @GetMapping("/publisherByAddress/{address}")
    public Publisher getPublishersByAddress(@PathVariable String address) {
        return publisherService.getPublisherByAddress(address);
    }

    @PutMapping("/updatePublisher")
    public Publisher updatePublisher(@RequestBody Publisher publisher) {
        return publisherService.updatePublisher(publisher);
    }

    @DeleteMapping("/deletePublisher/{id}")
    public String deletePublisher(@PathVariable Long id) {
        return publisherService.deletePublisher(id);
    }

}
