package testProjectContactBook;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import projectContactBook.Contact;
import projectContactBook.ContactBook;

import static org.junit.jupiter.api.Assertions.*;

class ContactBookTest {

    // common object for ContactBook
    static ContactBook contactBook;

    @BeforeAll
    static void setUp() {
        contactBook = new ContactBook();
    }

    @Test
    public void testAddContact() {
        Contact testContact = new Contact("AmazonStudent","1111122334");
        int currentNumOfContacts = contactBook.getNumberOfContacts();
        contactBook.addContact(testContact);
        assertEquals(currentNumOfContacts+1,contactBook.getNumberOfContacts());
    }

    @ParameterizedTest
    @CsvSource({
            "Alex, 1239292",
            "Taylor, 23939258",
            "Alice, 33939252 ",
            "Clark, 43939251",
            "Toni, 53939257",
            "Casey, 63939258"
    })
    public void testAddContact_onSizeLimitExceed_returnsFalseAndNotException(String name, String phone) {
        Contact testContact = new Contact(name, phone);
        assertTrue(contactBook.addContact(testContact));
    }

    @Test
    public void testAddContact_onSameNumber_ThrowsIllegalArgumentException() {

        Contact testContact1 = new Contact("Alex","11111");
        Contact testContact2 = new Contact("Toni","11111");

        // first contact
        contactBook.addContact(testContact1);

        // second contact with same phone number
        //check if exception is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            contactBook.addContact(testContact2);
        });

    }


    @Test
    public void testSearchContactByPhone() {
        Contact testContactForPhone = new Contact("Toni","184048");
        contactBook.addContact(testContactForPhone);
        Contact testContact = contactBook.searchContactByPhone("184048");
        assertNotNull(testContact);
        assertEquals(testContact.getName(),testContactForPhone.getName());
        assertEquals(testContact.getPhoneNumber(),testContactForPhone.getPhoneNumber());
    }

    @Test
    public void testRemoveContactByPhone_found_returnsTrue() {

        Contact testContactForPhone = new Contact("Wills","939503");
        contactBook.addContact(testContactForPhone);
        assertTrue(contactBook.deleteContactByPhone("939503"));
    }

    @Test
    public void testRemoveContactByPhone_notFound_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,()->{
            contactBook.deleteContactByPhone("923746439503");
        });
    }
}


