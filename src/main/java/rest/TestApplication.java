package rest;

import java.util.HashSet;
import java.util.Set;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource; // Assure-toi d'ajouter la dépendance Swagger dans ton projet.
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import rest.ressource.KahootResource; // Importez votre classe de ressource REST.

@ApplicationPath("/api") // Définit le chemin de base pour l'API
public class TestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();

        classes.add(KahootResource.class); // Ajoute ta ressource REST Kahoot
        System.out.println("Adding KahootRessource to classes");

        classes.add(OpenApiResource.class); // Ajoute la ressource OpenAPI pour Swagger

        // Ajoute d'autres ressources REST si nécessaire
        return classes;
    }
}

