package web;

import domain.Kahoot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.KahootDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class KahootController {

    @Autowired
    private KahootDao kahootDao;

    /**
     * GET /kahoots  --> Retourne tous les Kahoots dans la base de données.
     */
    @GetMapping
    @ResponseBody
    public List<Kahoot> getAllKahoots() {
        return kahootDao.findAll(); // Assure-toi que cette méthode existe dans ton KahootDao
    }


    /**
     * GET /create  --> Crée un nouveau Kahoot et le sauvegarde dans la base de données.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(int score, int classement, String type, String question) {
        String kahootId = "";
        try {
            Kahoot.Type kahootType = Kahoot.Type.valueOf(type.toUpperCase());
            Kahoot kahoot = new Kahoot(score, classement, kahootType, null);
            kahoot.setQuestion(question);
            kahootDao.save(kahoot);
            kahootId = String.valueOf(kahoot.getId());
        } catch (Exception ex) {
            return "Erreur lors de la création du Kahoot: " + ex.toString();
        }
        return "Kahoot créé avec succès avec l'ID = " + kahootId;
    }

    /**
     * GET /delete  --> Supprime le Kahoot ayant l'ID passé en paramètre.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Kahoot kahoot = new Kahoot();
            kahoot.setId(id);
            kahootDao.delete(kahoot);
        } catch (Exception ex) {
            return "Erreur lors de la suppression du Kahoot: " + ex.toString();
        }
        return "Kahoot supprimé avec succès!";
    }

    /**
     * GET /get-by-question/{question}  --> Retourne l'ID du Kahoot ayant la question passée en paramètre.
     */
    @RequestMapping("/get-by-question/{question}")
    @ResponseBody
    public String getByQuestion(@PathVariable("question") String question) {
        String kahootId = "";
        try {
            Kahoot kahoot = kahootDao.findByQuestion(question);
            kahootId = String.valueOf(kahoot.getId());
        } catch (Exception ex) {
            return "Kahoot non trouvé";
        }
        return "L'ID du Kahoot est: " + kahootId;
    }

    /**
     * GET /update  --> Met à jour le score, le classement et la question pour le Kahoot dans la base de données.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateKahoot(long id, int score, int classement, String question) {
        try {
            Kahoot kahoot = kahootDao.findById(id).get();
            kahoot.setScore(score);
            kahoot.setClassement(classement);
            kahoot.setQuestion(question);
            kahootDao.save(kahoot);
        } catch (Exception ex) {
            return "Erreur lors de la mise à jour du Kahoot: " + ex.toString();
        }
        return "Kahoot mis à jour avec succès!";
    }
}

