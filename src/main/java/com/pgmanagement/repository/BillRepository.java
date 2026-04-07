package com.pgmanagement.repository;

import com.pgmanagement.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BillRepository
        extends JpaRepository<Bill, Integer> {

    List<Bill> findByTenantId(int tenantId);

    List<Bill> findByTenantIdAndStatus(
        int tenantId, String status
    );
}