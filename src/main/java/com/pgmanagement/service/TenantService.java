package com.pgmanagement.service;

import com.pgmanagement.dto.*;
import com.pgmanagement.model.*;
import com.pgmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private BillRepository billRepo;

    @Autowired
    private ComplaintRepository complaintRepo;

    @Autowired
    private CheckoutRequestRepository checkoutReqRepo;

    // GET TENANT DETAILS
    public ApiResponse getTenantDetails(int userId) {

        Optional<User> userOpt = userRepo.findById(userId);
        
        if (userOpt.isEmpty()) {
            return new ApiResponse(false, "User not found!");
        }

        User user = userOpt.get();
        TenantDetailsDto dto = new TenantDetailsDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());

        // Find LATEST tenant record
        Optional<Tenant> tenantOpt = tenantRepo.findByUserId(userId);

        if (tenantOpt.isPresent()) {
            Tenant tenant = tenantOpt.get();

            //  Always get FRESH status from DB
            dto.setTenantId(tenant.getId());
            dto.setCheckinDate(tenant.getCheckinDate());
            dto.setStatus(tenant.getStatus()); // Fresh!

            // Get room details
            if (tenant.getRoomId() > 0) {
                Optional<Room> roomOpt = roomRepo.findById(tenant.getRoomId());
                
                if (roomOpt.isPresent()) {
                    Room room = roomOpt.get();
                    dto.setRoomNumber(room.getRoomNumber());
                    dto.setRoomType(room.getRoomType());
                    dto.setRent(room.getRent());
                    dto.setAc(room.isAc());
                }
            }
        } else {
            dto.setTenantId(-1);
            dto.setStatus("NOT_CHECKED_IN");
            dto.setRoomNumber("Not Assigned");
            dto.setRent(0);
        }

        return new ApiResponse(true, "Details fetched!", dto);
    }

    // GET BILLS
    public ApiResponse getBills(int userId) {

        Optional<Tenant> tenantOpt =
            tenantRepo.findByUserId(userId);

        if (tenantOpt.isEmpty()) {
            return new ApiResponse(
                false, "No active tenancy found!"
            );
        }

        List<Bill> bills = billRepo.findByTenantId(
            tenantOpt.get().getId()
        );

        return new ApiResponse(
            true, "Bills fetched!", bills
        );
    }

    // PAY BILL
    public ApiResponse payBill(PayBillRequest req) {

        Optional<Bill> billOpt =
            billRepo.findById(req.getBillId());

        if (billOpt.isEmpty()) {
            return new ApiResponse(
                false, "Bill not found!"
            );
        }

        Bill bill = billOpt.get();

        if ("PAID".equals(bill.getStatus())) {
            return new ApiResponse(
                false, "Bill already paid!"
            );
        }

        bill.setPaidAmount(bill.getTotalAmount());
        bill.setStatus("PAID");
        bill.setPaidAt(
            java.time.LocalDateTime.now().toString()
        );

        billRepo.save(bill);

        return new ApiResponse(
            true, "Payment successful! ✅"
        );
    }

    // GET MY COMPLAINTS
    public ApiResponse getComplaints(int userId) {

        Optional<Tenant> tenantOpt =
            tenantRepo.findByUserId(userId);

        if (tenantOpt.isEmpty()) {
            return new ApiResponse(
                false, "No tenancy found!"
            );
        }

        List<Complaint> list =
            complaintRepo.findByTenantId(
                tenantOpt.get().getId()
            );

        return new ApiResponse(
            true, "Complaints fetched!", list
        );
    }

    // ADD COMPLAINT
    public ApiResponse addComplaint(
            ComplaintRequest req) {

        Complaint c = new Complaint();
        c.setTenantId(req.getTenantId());
        c.setTitle(req.getTitle());
        c.setDescription(req.getDescription());
        c.setCategory(req.getCategory());
        c.setPriority(req.getPriority());
        c.setStatus("OPEN");
        c.setCreatedAt(
            java.time.LocalDateTime.now().toString()
        );

        complaintRepo.save(c);

        return new ApiResponse(
            true, "Complaint submitted successfully!"
        );
    }

    // SUBMIT CHECK REQUEST
    public ApiResponse submitCheckRequest(
            CheckRequest req) {

        CheckoutRequest cr = new CheckoutRequest();

        // For checkin — find tenant or create
        if ("CHECKIN".equals(req.getRequestType())) {

            // Create new tenant record
            Tenant t = new Tenant();
            t.setUserId(req.getUserId());
            t.setRoomId(req.getRoomId());
            t.setCheckinDate(req.getRequestDate());
            t.setCheckinTime(req.getRequestTime());
            t.setStatus("PENDING");
            Tenant saved = tenantRepo.save(t);

            cr.setTenantId(saved.getId());

        } else {
            // Checkout — find existing tenant
            Optional<Tenant> tenantOpt =
                tenantRepo.findByUserId(req.getUserId());

            if (tenantOpt.isEmpty()) {
                return new ApiResponse(
                    false, "No active tenancy found!"
                );
            }
            cr.setTenantId(tenantOpt.get().getId());
        }

        cr.setRequestType(req.getRequestType());
        cr.setRequestedDate(req.getRequestDate());
        cr.setRequestedTime(req.getRequestTime());
        cr.setReason(req.getReason());
        cr.setStatus("PENDING");
        cr.setCreatedAt(
            java.time.LocalDateTime.now().toString()
        );

        checkoutReqRepo.save(cr);

        return new ApiResponse(
            true,
            "Request submitted! Waiting for owner approval."
        );
    }

    // GET AVAILABLE ROOMS
    public ApiResponse getAvailableRooms() {
        // NEW - correct
        List<Room> rooms = roomRepo.findAvailableRooms();

        return new ApiResponse(
            true, "Rooms fetched!", rooms
        );
    }
}