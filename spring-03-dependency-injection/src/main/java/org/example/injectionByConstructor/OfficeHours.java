package org.example.injectionByConstructor;

import org.springframework.stereotype.Component;

@Component
public class OfficeHours {
    public int getHours() {
        return 10;
    }
}
