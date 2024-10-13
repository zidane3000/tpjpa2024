package kahoot;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import kahoot.rest.KahootResource;
import kahoot.rest.QuestionResource;
import kahoot.rest.UtilisateurResource;

import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/")
public class TestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
            final Set<Class<?>> classes = new HashSet<>();

        classes.add(OpenApiResource.class); // Ajoute la ressource OpenAPI pour Swagger

        classes.add(KahootResource.class);

        classes.add(QuestionResource.class);

        classes.add(UtilisateurResource.class);


        // Ajoute d'autres ressources REST si nécessaire

        return classes;
    }
}

