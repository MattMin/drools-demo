package com.mzy.droolsdemo.service;

import com.mzy.droolsdemo.entity.stateless.Applicant;
import com.mzy.droolsdemo.entity.stateless.Application;
import com.mzy.droolsdemo.entity.stateless.Person;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 无状态 kiesession
 */
@Service
public class ApplicantService {

//    /**
//     * 对于单个对象执行规则
//     *
//     * @param applicant
//     * @return
//     */
//    public boolean valid(Applicant applicant){
//        // 创建Kie容器
//        KieServices kieServices = KieServices.Factory.get();
//        // 从resources目录中获取Drool配置文件
//        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
//
//        // 实例化无状态 kie session
//        StatelessKieSession statelessKieSession = kieClasspathContainer.newStatelessKieSession("ksession1");
//
//        statelessKieSession.execute(applicant);
//
//        return applicant.isValid();
//    }

    public void validCollection(){
        // 创建Kie容器
        KieServices kieServices = KieServices.Factory.get();
        // 从resources目录中获取Drool配置文件
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();

        // 实例化无状态 kie session
        StatelessKieSession ksession = kieClasspathContainer.newStatelessKieSession("ksession1");

        Applicant applicant = new Applicant("Mr John Smith", 16, true);
        Application application = new Application();

        assert !application.isValid();
        ksession.execute(Arrays.asList(new Object[] { application, applicant }));
        assert application.isValid();

        ksession.execute
                (CommandFactory.newInsertElements(Arrays.asList(new Object[] { application, applicant })));

        List<Command> cmds = new ArrayList<Command>();
        cmds.add(CommandFactory.newInsert(new Person("Mr John Smith"), "mrSmith"));
        cmds.add(CommandFactory.newInsert(new Person("Mr John Doe"), "mrDoe"));

        ExecutionResults results = ksession.execute(CommandFactory.newBatchExecution(cmds));
        assert new Person("Mr John Smith").equals(results.getValue("mrSmith"));
    }
}
