package com.epam.impl;

import com.epam.dto.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription createSubscription(Subscription subscription);

    Subscription updateSubscription(Subscription subscription);

    void deleteSubscription(Long id);

    Subscription getSubscription(Long id);

    List<Subscription> getAllSubscription();
}
