package com.mzy.drools.service;

import com.mzy.drools.entity.Address;
import com.mzy.drools.entity.fact.AddressCheckResult;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mzyupc@163.com
 * @date 2020/3/11 13:50:42
 */
@Service
@Slf4j
public class AddressService {
    @Resource
    private KieContainer kieContainer;

    public void test(int num){
        Address address = new Address();
        address.setPostcode(generateRandom(num));
        AddressCheckResult result = new AddressCheckResult();

        // 有状态kie session
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(result);
        kieSession.insert(address);
        int ruleFiredCount = kieSession.fireAllRules();
        kieSession.destroy();

        // 无状态 kie session 调用
//        StatelessKieSession session = kieContainer.newStatelessKieSession();
//        session.execute(Arrays.asList(address, result));

        log.info("触发了" + ruleFiredCount + "条规则");

        if(result.isPass()){
            log.info("规则校验通过");
        }

    }

    /**
     * 生成随机数
     * @param num
     * @return
     */
    public String generateRandom(int num) {
        String chars = "0123456789";
        StringBuffer number=new StringBuffer();
        for (int i = 0; i < num; i++) {
            int rand = (int) (Math.random() * 10);
            number=number.append(chars.charAt(rand));
        }
        return number.toString();
    }
}
