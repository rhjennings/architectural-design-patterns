package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class HexArchTest {
    @DisplayName("domain should not depend on adapter package")
    @Test
    void domainMustNotDependOnAdapter() {
        JavaClasses importedClasses = 
            new ClassFileImporter().importPackages("com.jitterted.ebp.blackjack");
        
        ArchRule myRule = noClasses().that().resideInAPackage("..domain..")
            .should().dependOnClassesThat()
            .resideInAPackage("..adapter..");

        myRule.check(importedClasses);
    }

}
