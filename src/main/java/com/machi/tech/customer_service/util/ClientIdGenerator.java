package com.machi.tech.customer_service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ClientIdGenerator {

    @Autowired
    private ClientSequenceRepository sequenceRepo;

    public String generateClientId() {
        String monthKey = LocalDate.now().format(DateTimeFormatter.ofPattern("MMyy"));
        ClientSequence seq = sequenceRepo.findById(monthKey).orElseGet(() -> {
            ClientSequence newSeq = new ClientSequence();
            newSeq.setMonthKey(monthKey);
            newSeq.setSequence(0);
            return newSeq;
        });

        int nextSeq = seq.getSequence() + 1;
        seq.setSequence(nextSeq);
        sequenceRepo.save(seq);

        return String.format("%sC%03d", monthKey, nextSeq);
    }
}