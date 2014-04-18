package esarc.bts.ticketscan.model.user;

import junit.framework.TestCase;

public class UserTest extends TestCase {

    public void testGetId() {
        // Arrange
        User user = new User();

        // Act
        int id = user.getId();
        int idAttendu = -1;

        // Assert
        assertEquals(idAttendu, id);
    }

    public void testSetId() {
        // Arrange
        User user = new User();

        // Act
        int newId = 3;
        user.setId(newId);

        // Assert
        assertEquals(user.getId(), newId);
    }

    public void testGetNom() {
        // Arrange
        User user = new User();

        // Act
        user.setNom("toto");
        String nom = user.getNom();

        // Assert
        assertEquals("toto", nom);
    }

    public void testSetNom() {
        // Arrange
        User user = new User();

        // Act
        String nom = "toto";
        user.setNom(nom);

        // Assert
        assertEquals("toto", user.getNom());
    }

    public void testGetPrenom() {
        // Arrange
        User user = new User();

        // Act
        user.setPrenom("toto");
        String prenom = user.getPrenom();

        // Assert
        assertEquals("toto", prenom);
    }

    public void testSetPrenom() {
        // Arrange
        User user = new User();

        // Act
        String prenom = "toto";
        user.setPrenom(prenom);

        // Assert
        assertEquals("toto", user.getPrenom());
    }

    public void testGetMail() {
        // Arrange
        User user = new User();

        // Act
        user.setMail("toto@free.fr");
        String mail = user.getMail();

        // Assert
        assertEquals("toto@free.fr", mail);
    }

    public void testSetMail() {
        // Arrange
        User user = new User();

        // Act
        String mail = "toto@free.fr";
        user.setMail(mail);

        // Assert
        assertEquals("toto@free.fr", user.getMail());
    }

    public void testGetTelephone() {
        // Arrange
        User user = new User();

        // Act
        user.setTelephone("0556000203");
        String telephone = user.getTelephone();

        // Assert
        assertEquals("0556000203", telephone);
    }

    public void testSetTelephone() {
        // Arrange
        User user = new User();

        // Act
        String telephone = "0600000000";
        user.setTelephone(telephone);

        // Assert
        assertEquals("0600000000", user.getTelephone());
    }

    public void testGetLogin() {
        // Arrange
        User user = new User("toto", "mdp");

        // Act
        String login = user.getLogin();

        // Assert
        assertEquals("toto", login);
    }

    public void testSetLogin() {
        // Arrange
        User user = new User("toto", "mdp");

        // Act
        String login = "titi";
        user.setLogin(login);

        // Assert
        assertEquals("titi", user.getLogin());
    }

    public void testGetMdp() {
        // Arrange
        User user = new User("loggin", "toto");

        // Act
        String mdp = user.getMdp();

        // Assert
        assertEquals("toto", mdp);
    }

    public void testSetMdp() {
        // Arrange
        User user = new User("login", "toto");

        // Act
        String mdp = "titi";
        user.setMdp(mdp);

        // Assert
        assertEquals("titi", user.getMdp());
    }

    public void testToJSONFull() {
        // Arrange
        User user = new User(2, "nom", "prenom", "email@free.fr", "0600000000",
                "login", "mdp");

        // Act
        String json = user.toJSONFull();
        String jsonAttendu = "{\"id\":2,\"nom\":\"nom\",\"prenom\":\"prenom\",\"mail\":\"email@free.fr\",\"telephone\":\"0600000000\",\"login\":\"login\",\"mdp\":\"mdp\"}";

        // Assert
        assertEquals(json, jsonAttendu);
    }

    public void testToJSONLog() {
        // Arrange
        User user = new User("totoLog", "totoMdp");

        // Act
        String json = user.toJSONLog();
        String jsonAttendu = "{\"login\":\"totoLog\",\"mdp\":\"totoMdp\"}";

        // Assert
        assertEquals(json, jsonAttendu);
    }

}
