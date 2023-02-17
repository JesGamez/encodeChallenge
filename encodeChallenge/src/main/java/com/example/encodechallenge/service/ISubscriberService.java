package com.example.encodechallenge.service;

import com.example.encodechallenge.model.Subscriber;

import java.util.List;

public interface ISubscriberService {
    public List<Subscriber> findAll();
    public int save(Subscriber subscriber);
    public int update(Subscriber subscriber);
    public int deleteById(int id);
}
