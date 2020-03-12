package com.mzy.drools.controller;

import com.mzy.drools.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mzyupc@163.com
 * @date 2020/3/11 13:57:49
 */
@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("test/{num}")
    public void test(@PathVariable Integer num) {
        addressService.test(num);
    }
}
