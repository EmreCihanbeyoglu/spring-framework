package com.cydeo.spring14ormcinemalab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserAccount extends BaseEntity  {

    private String email;

    private String password;

    private String username;

    @OneToOne
    @JoinColumn(name = "account_details_id")
    private AccountDetails accountDetails;

    @Override
    public String toString() {
        return "UserAccount{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
