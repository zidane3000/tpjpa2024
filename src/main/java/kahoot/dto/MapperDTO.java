package kahoot.dto;

import kahoot.domain.Kahoot;
import kahoot.domain.Utilisateur;

public class MapperDTO {
    public static KahootDTO toKahootDTO(Kahoot kahoot) {
        KahootDTO kahootDTO = new KahootDTO();
        kahootDTO.setId(kahoot.getId());
        kahootDTO.setTitre(kahoot.getTitre());
        kahootDTO.setCreateurId(kahoot.getCreateur().getId());
        kahootDTO.setPin(kahoot.getPIN());
        kahootDTO.setType(kahoot.getType());
        return kahootDTO;
    }

    public static UtilisateurDTO toUtilisateurDTO(Utilisateur utilisateur) {
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        utilisateurDTO.setId(utilisateur.getId());
        utilisateurDTO.setSurnom(utilisateur.getSurnom());
        return utilisateurDTO;
    }

}
