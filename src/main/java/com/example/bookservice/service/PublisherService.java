package com.example.bookservice.service;

import com.example.bookservice.model.Publisher;
import com.example.bookservice.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher savePubliser(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public List<Publisher> saveAllPublisher(List<Publisher> publishers) {
        return publisherRepository.saveAll(publishers);
    }

    public List<Publisher> getPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public Publisher getPublisherByName(String name) {
        return publisherRepository.findByName(name);
    }

    public List<Publisher> getPublishersByCountry(String country) {
        return publisherRepository.findAllByCountry(country);
    }

    public List<Publisher> getPublishersByCity(String city) {
        return publisherRepository.findAllByCity(city);
    }

    public Publisher getPublisherByAddress(String address) {
        return publisherRepository.findByAddress(address);
    }

    public Publisher updatePublisher(Publisher publisher) {
        Publisher updatedPublisher = publisherRepository.findById(publisher.getId()).orElse(null);
        updatedPublisher.setCity(publisher.getCity());
        updatedPublisher.setCountry(publisher.getCountry());
        updatedPublisher.setAddress(publisher.getAddress());
        updatedPublisher.setName(publisher.getName());
        updatedPublisher.setBooks(publisher.getBooks());
        return publisherRepository.save(updatedPublisher);
    }

    public String deletePublisher(Long id) {
        publisherRepository.deleteById(id);
        return "Publisher #" + id + " was deleted!";
    }

}
