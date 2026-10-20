package com.dnery.hexagonal.application.ports.out;

import com.dnery.hexagonal.application.core.domain.Custumer;

public interface InsertCustumerOutputPort {

    void insertCustumer(Custumer custumer);

}
