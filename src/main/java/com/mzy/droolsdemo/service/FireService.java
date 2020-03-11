package com.mzy.droolsdemo.service;

import com.mzy.droolsdemo.entity.Fire;
import com.mzy.droolsdemo.entity.Room;
import com.mzy.droolsdemo.entity.Sprinkler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mzyupc@163.com
 * @date 2020/3/11 14:34:03
 *
 * 有状态kiesession
 */
@Service
public class FireService {

    public void test () {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession();

        String[] names = new String[]{"kitchen", "bedroom", "office", "livingroom"};
        Map<String, Room> name2room = new HashMap<String,Room>();
        for( String name: names ){
            Room room = new Room( name );
            name2room.put( name, room );
            ksession.insert( room );
            Sprinkler sprinkler = new Sprinkler( room );
            ksession.insert( sprinkler );
        }

        ksession.fireAllRules();
        ksession.dispose();
    }

    public void test2 () {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession();

        String[] names = new String[]{"kitchen", "bedroom", "office", "livingroom"};
        Map<String, Room> name2room = new HashMap<String,Room>();
        for( String name: names ){
            Room room = new Room( name );
            name2room.put( name, room );
            ksession.insert( room );
            Sprinkler sprinkler = new Sprinkler( room );
            ksession.insert( sprinkler );
        }
        Fire kitchenFire = new Fire( name2room.get( "kitchen" ) );
        Fire officeFire = new Fire( name2room.get( "office" ) );

        FactHandle kitchenFireHandle = ksession.insert( kitchenFire );
        FactHandle officeFireHandle = ksession.insert( officeFire );

        ksession.fireAllRules();
        ksession.dispose();
    }
}
