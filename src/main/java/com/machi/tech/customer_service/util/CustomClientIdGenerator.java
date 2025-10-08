package com.machi.tech.customer_service.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class CustomClientIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "FFC-";
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMM"));

        String todayPrefix = prefix + datePart;
        String query = "SELECT MAX(c.id) FROM Client c WHERE c.id LIKE :prefix";
        String maxId = (String) session.createQuery(query)
            .setParameter("prefix", todayPrefix + "%")
            .uniqueResult();

        int sequence = 1;
        if (maxId != null) {
            String sequenceStr = maxId.substring(todayPrefix.length());
            sequence = Integer.parseInt(sequenceStr) + 1;
        }

        String formattedSequence = String.format("%03d", sequence);
        return todayPrefix + formattedSequence;
    }

}
