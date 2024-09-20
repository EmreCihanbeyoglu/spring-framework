package com.cydeo.spring17restconsumingapi.client;

import com.cydeo.spring17restconsumingapi.dto.DummyResponseWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(url = "https://dummyapi.io", name = "DUMMY-USER-CLIENT")
public interface DummyUserClient {

    @GetMapping("/data/v1/user?limit=5")
    DummyResponseWrapper getAllDummyUsers(@RequestHeader("app-id") String appId);

}


// "https://dummyapi.io/data/v1/user?limit=5