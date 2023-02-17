package com.example.encodechallenge.service;

import com.example.encodechallenge.model.Subscriber;
import com.example.encodechallenge.repository.ISubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService implements ISubscriberService{

    @Autowired
    private ISubscriberRepository iSubscriberRepository;


    @Override
    public List<Subscriber> findAll() {
        List<Subscriber> list;
        try {
            list = iSubscriberRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Subscriber subscriber) {
        int row;
        try {
            row = iSubscriberRepository.save(subscriber);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Subscriber subscriber) {
        int row;
        try {
            row = iSubscriberRepository.update(subscriber);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try {
            row = iSubscriberRepository.deleteById(id);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
