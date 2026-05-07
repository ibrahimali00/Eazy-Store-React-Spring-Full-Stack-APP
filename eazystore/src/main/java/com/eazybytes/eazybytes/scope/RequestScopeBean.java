package com.eazybytes.eazybytes.scope;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
@Getter @Setter
@Slf4j
public class RequestScopeBean {

    private String username;

    public RequestScopeBean() {
        log.info("RequestScopeBean : Initialized");
    }


}
