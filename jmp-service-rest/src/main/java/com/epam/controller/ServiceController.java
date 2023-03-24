package com.epam.controller;

import com.epam.dto.Subscription;
import com.epam.dto.SubscriptionRequestDto;
import com.epam.dto.SubscriptionResponseDto;
import com.epam.impl.SubscriptionService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("provides an interface for operations on the Subscription entity")
@RestController
@RequestMapping("subscription")
public class ServiceController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value = "/", produces = "application/json")
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto){
        Subscription subscription = subscriptionService.createSubscription(convertToSubscription(subscriptionRequestDto));
        return convertToSubscriptionResponseDto(subscription);
    }

    @PutMapping(value = "/", produces = "application/json")
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto){
        Subscription subscription = subscriptionService.updateSubscription(convertToSubscription(subscriptionRequestDto));
        return convertToSubscriptionResponseDto(subscription);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable Long id){
        subscriptionService.deleteSubscription(id);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public SubscriptionResponseDto getSubscription(@PathVariable Long id){
        Subscription subscription = subscriptionService.getSubscription(id);
        return convertToSubscriptionResponseDto(subscription);
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<SubscriptionResponseDto> getAllSubscription(){
        List<Subscription> allSubscription = subscriptionService.getAllSubscription();
        return allSubscription.stream().map(this::convertToSubscriptionResponseDto).toList();
    }

    private Subscription convertToSubscription(SubscriptionRequestDto requestDto){
        return modelMapper.map(requestDto, Subscription.class);
    }

    private SubscriptionResponseDto convertToSubscriptionResponseDto(Subscription subscription){
        return modelMapper.map(subscription, SubscriptionResponseDto.class);
    }
}
