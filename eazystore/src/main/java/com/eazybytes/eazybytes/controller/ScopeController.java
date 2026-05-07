package com.eazybytes.eazybytes.controller;


import com.eazybytes.eazybytes.scope.ApplicationScopeBean;
import com.eazybytes.eazybytes.scope.RequestScopeBean;
import com.eazybytes.eazybytes.scope.SessionScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/scope")

public class ScopeController {


    private final RequestScopeBean requestScopeBean;
    private final SessionScopeBean sessionScopeBean;
    private final ApplicationScopeBean applicationScopeBean;

    @Autowired
    public ScopeController(RequestScopeBean requestScopeBean, SessionScopeBean sessionScopeBean, ApplicationScopeBean applicationScopeBean) {
        this.requestScopeBean = requestScopeBean;
        this.sessionScopeBean = sessionScopeBean;
        this.applicationScopeBean = applicationScopeBean;
    }

    @GetMapping("/request")
    public ResponseEntity<String> testRequestScope()
    {
        requestScopeBean.setUsername("hima Ali");
        return ResponseEntity.ok().body(requestScopeBean.getUsername());
    }
    @GetMapping("/application")
    public ResponseEntity<Integer> testAppScope()
    {
        applicationScopeBean.incrementVisitorCount();

        return ResponseEntity.ok().body(applicationScopeBean.getVisitorCount());
    }

    @GetMapping("/session")
    public ResponseEntity<String> testSessionScope()
    {
        sessionScopeBean.setUsername("asmaa Ali");
        return ResponseEntity.ok().body(sessionScopeBean.getUsername());
    }

    @GetMapping("/test")
    public ResponseEntity<Integer> testScope()
    {
        return ResponseEntity.ok().body(applicationScopeBean.getVisitorCount());
    }
}
