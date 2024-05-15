package org.example.injectionByField;

import org.springframework.stereotype.Component;

@Component
public class OfficeHours {
    public int getHours() {
        return 10;
    }
}
