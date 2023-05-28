package com.jonas.payrollapi.resources;

import com.jonas.payrollapi.domain.PayRoll;
import com.jonas.payrollapi.domain.User;
import com.jonas.payrollapi.feignClients.UserFeign;
import com.jonas.payrollapi.services.PayrollService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/payments")
@AllArgsConstructor
public class PayrollResource {


    private final UserFeign userFeign;
    private final PayrollService service;


    @GetMapping(value = "/{workerid}")
    public ResponseEntity<PayRoll> getPayment(@PathVariable Long workerid, @RequestBody PayRoll payment) {
        return ResponseEntity.ok().body(service.getPayment(workerid, payment));
    }
}
