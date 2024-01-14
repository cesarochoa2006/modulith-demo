package com.cesarochoa.modulith;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class ModulithSampleApplicationTests {

	@Test
	void createApplicationModuleModel() {
		ApplicationModules modules = ApplicationModules.of(Application.class);
		modules.forEach(System.out::println);
	}

}
