package com.cesarochoa.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    @Test
    void createApplicationModuleModel() {
        ApplicationModules modules = ApplicationModules.of(Application.class);
        assertNotNull(modules);
        modules.forEach(System.out::println);
        assertEquals(2, modules.stream().count());
    }

    @Test
    void verifiesModularStructure() {
        ApplicationModules modules = ApplicationModules.of(Application.class);
        modules.verify();
    }

    @Test
    void createModuleDocumentation() {
        ApplicationModules modules = ApplicationModules.of(Application.class);
        assertTrue(modules.stream().findAny().isPresent());
        new Documenter(modules)
                .writeDocumentation()
                .writeIndividualModulesAsPlantUml();
    }

}
