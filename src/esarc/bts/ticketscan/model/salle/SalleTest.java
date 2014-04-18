package esarc.bts.ticketscan.model.salle;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.json.JSONException;

import esarc.bts.ticketscan.model.dateevent.DateEvent;
import esarc.bts.ticketscan.model.event.Event;

public class SalleTest extends TestCase {

    public void testGetNom() {
        // Arrange
        Salle salle = new Salle();

        // Act
        String nomAttendu = "toto";
        salle.setNom(nomAttendu);
        String nom = salle.getNom();

        // Assert
        assertEquals(nomAttendu, nom);
    }

    public void testSetNom() {
        // Arrange
        Salle salle = new Salle();

        // Act
        String nom = "toto";
        salle.setNom(nom);
        String nomAttendu = "titi";
        salle.setNom(nomAttendu);

        // Assert
        assertEquals(nomAttendu, salle.getNom());
    }

    public void testGetListeEvent() {
        // Arrange
        Salle salle = new Salle();
        List<Event> listeAttendu = new ArrayList<Event>();
        Event evt = new Event();
        evt.setLibelle("toto");
        listeAttendu.add(evt);

        // Act
        salle.setListeEvent(listeAttendu);
        List<Event> liste = salle.getListeEvent();

        // Assert
        assertEquals(listeAttendu, liste);
    }

    public void testSetListeEvent() {
        // Arrange
        Salle salle = new Salle();

        List<Event> listeAttendu = new ArrayList<Event>();
        Event evt = new Event();
        evt.setLibelle("toto");
        listeAttendu.add(evt);

        List<Event> listeAttendu2 = new ArrayList<Event>();
        Event evt2 = new Event();
        evt2.setLibelle("titi");
        listeAttendu2.add(evt2);

        // Act
        salle.setListeEvent(listeAttendu);
        salle.setListeEvent(listeAttendu2);
        List<Event> liste = salle.getListeEvent();

        // Assert
        assertEquals(listeAttendu2, liste);
    }

    public void testAddEvent() {
        // Assert
        Salle salle = new Salle();
        Event event = new Event();
        event.setLibelle("toto");

        // Act
        salle.addEvent(event);
        Boolean exist = salle.getListeEvent().contains(event);

        // Assert
        assertTrue(exist);
    }

    public void testRemoveEvent() {
        // Assert
        Salle salle = new Salle();
        Event event = new Event();
        event.setLibelle("toto");
        Event event2 = new Event();
        event2.setLibelle("titi");

        // Act
        salle.addEvent(event);
        salle.addEvent(event2);
        salle.removeEvent(event2);
        Boolean exist = salle.getListeEvent().contains(event2);

        // Assert
        assertFalse(exist);
    }

    public void testLoadJson() throws JSONException, ParseException {
        // Arrange
        String json = "{\"nom\":\"toto\",\"listeDesEvenements\":[]}";

        // Act
        Salle sallejs = Salle.loadJson(json);
        Salle salle = new Salle();
        salle.setNom("toto");

        // Assert
        assertEquals(salle, sallejs);
    }

    public void testListEventToJson() throws JSONException, ParseException {
        // Arrange
        Salle salle = new Salle();
        Event event = new Event();
        event.setLibelle("toto");
        event.setDateEvent(DateEvent.stringToDate("20/03/2014"));
        salle.addEvent(event);

        // Act
        String json = salle.listEventToJson();
        String jsonAttendu = "[{\"libelle\":\"toto\",\"date\":\"20/03/2014\",\"listeDesTickets\":[]}]";

        // Assert
        assertEquals(jsonAttendu, json);
    }

    public void testSalleListFromJSON() throws JSONException, ParseException {
        // Arrange
        String json = "[{\"nom\":\"toto\",\"listeDesEvenements\":[]},{\"nom\":\"titi\",\"listeDesEvenements\":[]}]";
        Salle salle = new Salle();
        salle.setNom("toto");
        Salle salle2 = new Salle();
        salle2.setNom("titi");
        List<Salle> lstSalle = new ArrayList<Salle>();
        lstSalle.add(salle);
        lstSalle.add(salle2);

        // Act
        List<Salle> sallejs = Salle.salleListFromJSON(json);

        // Assert
        assertEquals(lstSalle, sallejs);

    }

}
