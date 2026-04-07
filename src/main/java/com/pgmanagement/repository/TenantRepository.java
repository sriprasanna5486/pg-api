package com.pgmanagement.repository;

import com.pgmanagement.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TenantRepository
        extends JpaRepository<Tenant, Integer> {

    Optional<Tenant> findByUserId(int userId);

    boolean existsByUserId(int userId);
}