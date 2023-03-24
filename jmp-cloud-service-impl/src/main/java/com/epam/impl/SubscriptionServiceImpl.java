package com.epam.impl;

import com.epam.dto.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteSubscription(Long id) {
        subscriptionRepository.delete(id);
    }

    @Override
    public Subscription getSubscription(Long id) {
        return subscriptionRepository.findOne(id);
    }

    @Override
    public List<Subscription> getAllSubscription() {
        return subscriptionRepository.findAll();
    }

    public SubscriptionServiceImpl() {}
}
