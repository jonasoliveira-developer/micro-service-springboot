package com.jonas.payrollapi.services;

import com.jonas.payrollapi.domain.PayRoll;
import com.jonas.payrollapi.feignClients.UserFeign;
import com.jonas.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {

    private final Environment env;
    private final UserFeign feign;

    public PayRoll getPayment(Long workerId , PayRoll payRoll) {
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");

        try {
            var user = feign.findById(workerId).getBody();
            if(Objects.nonNull(user)) {
                return new PayRoll(
                        user.getName(),
                        payRoll.getDescription(),
                        user.getHourlyPrice(),
                        payRoll.getWorkedHours(),
                        payRoll.getWorkedHours() * user.getHourlyPrice()

                );
            }
        }catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found");
        }catch (Exception ex) {
            throw new IllegalArgumentException("Ilegal argument exception");
        }
        return null;
    }
}
