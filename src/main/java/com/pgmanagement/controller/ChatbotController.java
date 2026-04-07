package com.pgmanagement.controller;

import com.pgmanagement.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/chatbot")
@CrossOrigin(origins = "*")
public class ChatbotController {

    // POST /api/chatbot/ask
    @PostMapping("/ask")
    public ApiResponse ask(
            @RequestBody Map<String, String> body) {

        String question = body.getOrDefault(
            "question", ""
        ).toLowerCase();

        String answer = getAnswer(question);

        return new ApiResponse(
            true, "Response", answer
        );
    }

    private String getAnswer(String q) {

        if (q.contains("rent")
                || q.contains("room charge")) {
            return "🏠 Rent Info:\n"
                 + "• AC Room: ₹5,500/month\n"
                 + "• Non-AC Room: ₹4,500/month\n"
                 + "Rent is fixed every month!";
        }
        if (q.contains("food")
                || q.contains("meal")
                || q.contains("breakfast")
                || q.contains("lunch")
                || q.contains("dinner")) {
            return "🍽️ Food Charges:\n"
                 + "• Breakfast: ₹40\n"
                 + "• Lunch: ₹60\n"
                 + "• Dinner: ₹65\n"
                 + "• Daily Total: ₹165";
        }
        if (q.contains("bill")
                || q.contains("payment")
                || q.contains("pay")) {
            return "💰 Bills:\n"
                 + "Monthly Bill = Rent + Food\n"
                 + "View and pay in Bills section!";
        }
        if (q.contains("complaint")
                || q.contains("issue")
                || q.contains("problem")) {
            return "📋 Complaints:\n"
                 + "Go to Complaints tab\n"
                 + "Fill title + description\n"
                 + "Owner will respond soon!";
        }
        if (q.contains("checkout")
                || q.contains("check out")
                || q.contains("leave")) {
            return "📦 Check-Out:\n"
                 + "Go to Requests tab\n"
                 + "Select Check-Out\n"
                 + "Enter date and time\n"
                 + "Wait for owner approval!";
        }
        if (q.contains("checkin")
                || q.contains("check in")) {
            return "🔑 Check-In:\n"
                 + "Go to Requests tab\n"
                 + "Select Check-In\n"
                 + "Choose room and date\n"
                 + "Owner will approve!";
        }
        if (q.contains("timing")
                || q.contains("time")
                || q.contains("gate")) {
            return "🕐 PG Timings:\n"
                 + "• Gate: 6AM - 11PM\n"
                 + "• Breakfast: 7-9 AM\n"
                 + "• Lunch: 12-2 PM\n"
                 + "• Dinner: 7-9 PM";
        }
        if (q.contains("wifi")
                || q.contains("internet")) {
            return "📡 WiFi Issues:\n"
                 + "Raise a complaint with\n"
                 + "category WiFi/Internet!\n"
                 + "We respond in 24 hours.";
        }
        if (q.contains("hi")
                || q.contains("hello")
                || q.contains("hey")) {
            return "👋 Hello! I am your PG Assistant!\n"
                 + "Ask me about rent, food,\n"
                 + "bills, complaints or timings!";
        }
        if (q.contains("thank")) {
            return "😊 You are welcome!\n"
                 + "Feel free to ask anything!";
        }

        return "🤔 I am not sure about that.\n"
             + "Try asking about:\n"
             + "• Rent or food charges\n"
             + "• Check-in or check-out\n"
             + "• Complaints\n"
             + "• PG timings";
    }
}