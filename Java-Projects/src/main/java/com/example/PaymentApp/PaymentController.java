package com.example.PaymentApp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PaymentController {
 
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public String showPaymentForm(Model model) {
        // Add model attributes if needed
        return "paymentForm";
    }

    @PostMapping("/process-payment")
    public String processPayment(@RequestParam Long userId, @RequestParam BigDecimal amount, Model model) {
        Payment payment = paymentService.processPayment(userId, amount);
        model.addAttribute("payment", payment);
        return "paymentSuccess";
    }
}