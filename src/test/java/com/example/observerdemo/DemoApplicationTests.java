package com.example.observerdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private SystemComponent systemComponent;
    
	@Test
	void contextLoads() {		
		SystemInfo systemInfo = new SystemInfo();
		systemInfo.setSomeId("someId");
		systemComponent.enterSomeApplicationPhase(systemInfo);
	}

}
