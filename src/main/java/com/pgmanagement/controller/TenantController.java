package com.pgmanagement.controller;

import com.pgmanagement.dto.*;
import com.pgmanagement.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenant")
@CrossOrigin(origins = "*")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    // GET /api/tenant/details/{userId}
    @GetMapping("/details/{userId}")
    public ApiResponse getDetails(
            @PathVariable int userId) {
        return tenantService.getTenantDetails(userId);
    }

    // GET /api/tenant/bills/{userId}
    @GetMapping("/bills/{userId}")
    public ApiResponse getBills(
            @PathVariable int userId) {
        return tenantService.getBills(userId);
    }

    // POST /api/tenant/pay
    @PostMapping("/pay")
    public ApiResponse payBill(
            @RequestBody PayBillRequest req) {
        return tenantService.payBill(req);
    }

    // GET /api/tenant/complaints/{userId}
    @GetMapping("/complaints/{userId}")
    public ApiResponse getComplaints(
            @PathVariable int userId) {
        return tenantService.getComplaints(userId);
    }

    // POST /api/tenant/complaint
    @PostMapping("/complaint")
    public ApiResponse addComplaint(
            @RequestBody ComplaintRequest req) {
        return tenantService.addComplaint(req);
    }

    // POST /api/tenant/request
    @PostMapping("/request")
    public ApiResponse submitRequest(
            @RequestBody CheckRequest req) {
        return tenantService.submitCheckRequest(req);
    }

    // GET /api/tenant/rooms
    @GetMapping("/rooms")
    public ApiResponse getAvailableRooms() {
        return tenantService.getAvailableRooms();
    }
}