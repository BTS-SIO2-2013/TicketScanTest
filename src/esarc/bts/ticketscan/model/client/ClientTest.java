package esarc.bts.ticketscan.model.client;

import junit.framework.TestCase;

import org.json.JSONException;

public class ClientTest extends TestCase {

    public final void testGetPrenom() {
        // Arrange
        Client client = new Client("nom", "toto");

        // Act
        String prenom = client.getPrenom();

        // Assert
        assertEquals("toto", prenom);

    }

    public final void testSetPrenom() {
        // Arrange
        Client client = new Client("nom", "toto");

        // Act
        client.setPrenom("tata");

        // Assert
        assertEquals(client.getPrenom(), "tata");
    }

    public final void testGetNom() {
        // Arrange
        Client client = new Client("toto", "prenom");

        // Act
        String nom = client.getNom();

        // Assert
        assertEquals("toto", nom);
    }

    public final void testSetNom() {
        // Arrange
        Client client = new Client("toto", "prenom");

        // Act
        client.setNom("tata");

        // Assert
        assertEquals(client.getNom(), "tata");
    }

    public final void testLoadJson() throws JSONException {
        // Arrange
        String json = "{\"nom\":\"Bon\",\"prenom\":\"Jean\"}";

        // Act
        Client clientjs = Client.loadJson(json);
        Client client = new Client("Bon", "Jean");

        // Assert
        assertEquals(client, clientjs);
    }

    public final void testEquals() {
        // Arrange
        Client client = new Client("Bon", "Jean");
        Client client2 = new Client("Bon", "Jean");

        // Act
        boolean test = client.equals(client2);

        // Assert
        assertTrue(test);
    }

}
