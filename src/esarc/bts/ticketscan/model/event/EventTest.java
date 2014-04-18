package esarc.bts.ticketscan.model.event;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.json.JSONException;

import esarc.bts.ticketscan.model.client.Client;
import esarc.bts.ticketscan.model.dateevent.DateEvent;
import esarc.bts.ticketscan.model.ticket.Ticket;

public class EventTest extends TestCase {

    public final void testGetLibelle() {

        // Attention: null par défaut

        // Arrange
        Event event = new Event();

        // Act
        event.setLibelle("toto");
        String evt = event.getLibelle();

        // Assert
        assertEquals("toto", evt);
    }

    public final void testSetLibelle() {
        // Arrange
        Event event = new Event();

        // Act
        event.setLibelle("toto");

        // Assert
        assertEquals("toto", event.getLibelle());
    }

    public final void testGetDateEvent() throws ParseException {
        // Arrange
        String dateJSON = "20/03/2014";
        Event event = new Event();
        DateEvent pDateEvent = DateEvent.stringToDate(dateJSON);
        event.setDateEvent(pDateEvent);

        // Act
        DateEvent evt = event.getDateEvent();

        // Assert
        assertEquals(pDateEvent, evt);
    }

    public final void testSetDateEvent() throws ParseException {
        // Arrange
        Event event = new Event();
        String date = "20/03/2014";
        DateEvent pDateEvent = DateEvent.stringToDate(date);

        // Act
        event.setDateEvent(pDateEvent);

        // Assert
        assertEquals(pDateEvent, event.getDateEvent());
    }

    public final void testGetListTicket() {
        // Arrange
        Event event = new Event();
        List<Ticket> liste = new ArrayList<Ticket>();
        Client monClient = new Client("Bon", "Jean");
        Ticket monTicket = new Ticket(monClient, 1, true);
        liste.add(monTicket);
        event.setListTicket(liste);

        // Act
        List<Ticket> listeRes = event.getListTicket();

        // Assert
        assertEquals(listeRes, liste);

    }

    public final void testSetListTicket() {
        // Arrange
        Event event = new Event();
        List<Ticket> pListTicket = new ArrayList<Ticket>();
        Client monClient = new Client("Bon", "Jean");
        Ticket monTicket = new Ticket(monClient, 1, true);
        pListTicket.add(monTicket);

        // Act
        event.setListTicket(pListTicket);

        // Assert
        assertEquals(pListTicket, event.getListTicket());
    }

    public final void testListTicketToJson() {
        // Arrange
        Event event = new Event();
        List<Ticket> pListTicket = new ArrayList<Ticket>();
        Client monClient = new Client("Bon", "Jean");
        Ticket monTicket = new Ticket(monClient, 1, true);
        pListTicket.add(monTicket);
        event.setListTicket(pListTicket);

        // Act
        String json = event.listTicketToJson();

        // Assert
        assertEquals(
                "[{\"client\":{\"nom\":Bon,\"prenom\":Jean},\"code\":1,\"valide\":true}]",
                json);
    }

    public final void testAddTicket() {
        // Arrange
        Event event = new Event();
        Client monClient = new Client("Bon", "Jean");
        Ticket monTicket = new Ticket(monClient, 1, true);

        // Act
        event.addTicket(monTicket);
        Boolean exist = event.getListTicket().contains(monTicket);

        // Assert
        assertTrue(exist);
    }

    public final void testRemoveTicket() {
        // Arrange
        Event event = new Event();
        Client monClient = new Client("Bon", "Jean");
        Ticket monTicket = new Ticket(monClient, 1, true);
        event.addTicket(monTicket);

        // Act
        event.removeTicket(monTicket);
        Boolean exist = event.getListTicket().contains(monTicket);

        // Assert
        assertFalse(exist);
    }

    public final void testLoadJson() throws JSONException, ParseException {
        // Arrange
        String json = "{\"libelle\":\"Concert\",\"date\":\"20/03/2014\",\"listeDesTickets\":[]}";

        // Act
        Event eventJSON = Event.loadJson(json);
        Event event = new Event();
        event.setLibelle("Concert");
        String date = "20/03/2014";
        DateEvent pDateEvent = DateEvent.stringToDate(date);
        event.setDateEvent(pDateEvent);

        // Assert
        assertEquals(event, eventJSON);
    }

    public final void testEventListFromJSON() throws JSONException,
            ParseException {
        // Arrange
        String json = "[{\"libelle\":\"Concert\",\"date\":\"20/03/2014\","
                + "\"listeDesTickets\":[]},{\"libelle\":\"Spectacle\",\"date\":\"21/03/2014\",\"listeDesTickets\":[]}]";

        Event event = new Event();
        event.setLibelle("Concert");
        String date = "20/03/2014";
        DateEvent pDateEvent = DateEvent.stringToDate(date);
        event.setDateEvent(pDateEvent);

        Event event2 = new Event();
        event2.setLibelle("Spectacle");
        String date2 = "21/03/2014";
        DateEvent pDateEvent2 = DateEvent.stringToDate(date2);
        event2.setDateEvent(pDateEvent2);

        List<Event> liste = new ArrayList<Event>();

        liste.add(event);
        liste.add(event2);

        // Act
        List<Event> listeJSON = Event.eventListFromJSON(json);

        // Assert
        assertEquals(listeJSON, liste);
    }

}
