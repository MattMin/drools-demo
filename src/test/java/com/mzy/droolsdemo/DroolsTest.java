package com.mzy.droolsdemo;

import com.mzy.droolsdemo.entity.Applicant;
import com.mzy.droolsdemo.service.ApplicantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DroolsTest {
    @Autowired
    private ApplicantService applicantService;

    @Test
    public void statelessKieSessionTest() throws InterruptedException {

        Applicant tom = new Applicant("Tom", 16, true);

        assert !applicantService.valid(tom);

    }

    @Test
    public void statelessKieSessionTest2(){
        applicantService.validCollection();
    }

}
