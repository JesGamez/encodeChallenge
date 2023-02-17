package com.example.encodechallenge.repository;

import com.example.encodechallenge.model.Subscriber;

import java.util.List;
import java.util.concurrent.Flow;

public interface ISubscriberRepository {
    public List<Subscriber> findAll();
    public int save(Subscriber subscriber);
    public int update(Subscriber subscriber);
    public int deleteById(int id);

}
