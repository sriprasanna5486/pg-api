package com.pgmanagement.repository;

import com.pgmanagement.model.CheckoutRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRequestRepository
        extends JpaRepository<CheckoutRequest, Integer> {
}