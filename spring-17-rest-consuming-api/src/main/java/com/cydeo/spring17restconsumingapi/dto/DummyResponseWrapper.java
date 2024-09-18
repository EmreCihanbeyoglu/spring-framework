package com.cydeo.spring17restconsumingapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DummyResponseWrapper {
    private List<DummyUser> data;
    private Integer total;
    private Integer page;
    private Integer limit;
}
