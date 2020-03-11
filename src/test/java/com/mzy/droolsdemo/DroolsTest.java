package com.mzy.droolsdemo;

import com.mzy.droolsdemo.entity.stateless.Applicant;
import com.mzy.droolsdemo.service.ApplicantService;
import com.mzy.droolsdemo.service.FireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DroolsTest {
    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private FireService fireService;
//    @Test
//    public void statelessKieSessionTest() throws InterruptedException {
//
//        Applicant tom = new Applicant("Tom", 16, true);
//
//        assert !applicantService.valid(tom);
//
//    }

    @Test
    public void statelessKieSessionTest2(){
        applicantService.validCollection();
    }

    @Test
    public void statefulKieSessionTest () {
        fireService.test();
    }

    @Test
    public void statefulKieSessionTest2 () {
        fireService.test2();
    }
}
