package com.example.graphqldemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
public class BalanceService {

    public Map<UUID, BigDecimal> getBalanceFor(Set<UUID> bankAccountIds, String userId) {
        log.info("Requesting bank account ids {}", bankAccountIds);
        //mockup
        return Map.of(
                UUID.fromString("a418a904-351c-4f32-b763-96e15515d7c4"), BigDecimal.TEN,
                UUID.fromString("f835d1a3-012a-4224-8621-346bc38f1d51"), BigDecimal.ONE,
                UUID.fromString("24cd7105-0608-4fc1-bd15-131185f24407"), BigDecimal.ZERO
                );
    }
}
