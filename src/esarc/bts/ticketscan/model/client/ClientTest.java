package esarc.bts.ticketscan.model.client;

import junit.framework.TestCase;

public class ClientTest extends TestCase {

    public void testClient() {
        fail("Not yet implemented");
    }

    public void testGetPrenom() {
        // Arrange
        Client client = new Client("nom", "toto");

        // Act
        String prenom = client.getPrenom();

        // Assert
        assertEquals("toto", prenom);

    }

    public void testSetPrenom() {
        fail("Not yet implemented");
    }

    public void testGetNom() {
        fail("Not yet implemented");
    }

    public void testSetNom() {
        fail("Not yet implemented");
    }

    public void testLoadJson() {
        fail("Not yet implemented");
    }

}
