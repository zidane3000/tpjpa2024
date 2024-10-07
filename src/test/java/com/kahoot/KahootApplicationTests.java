package com.kahoot;

import com.kahoot.service.KahootService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class KahootApplicationTests {

    @Autowired
    private KahootService kahootService;

    @Test
    void contextLoads() {
        assertNotNull(kahootService, "KahootService should be loaded in the application context");
    }

    @Test
    void testKahootServiceMessage() {
        // Vérifie que le service retourne le bon message
        String message = kahootService.getKahootMessage();
        assertEquals("Bienvenue sur Kahoot!", message, "Kahoot message should match");
    }

    @Test
    void testSecurityAspect() {
        // Test indirect des aspects AOP via le service, les aspects doivent apparaître dans la console
        // Les aspects de sécurité et de log devraient être déclenchés lors de l'appel du service
        String message = kahootService.getKahootMessage();
        assertEquals("Bienvenue sur Kahoot!", message, "Kahoot message should match");
        // Dans la console, tu devrais voir les logs des aspects de sécurité et de log
    }
}
