import EX1.ContactManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ContactManagerTest {

    private ContactManager contactManager;


    @BeforeEach
    public void setup() {
        contactManager = new ContactManager();
    }

    @ParameterizedTest
    @CsvSource({
            "John, Doe, 0123456789",
            "Jane, Doe, 0123456780",
            "John, Smith, 0123457890",
            "Jane, Smith, 0123404290",
    })
    @DisplayName("Should add contact to contact list")
    public void testAddContact(String firstName, String lastName, String phoneNumber) {
        contactManager.addContact(firstName, lastName, phoneNumber);
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }

    @ParameterizedTest
    @CsvSource({
            ", Doe, 0123456789",
            ", Doe, 0123456780",
            ", Smith, 0123457890",
            ", Smith, 0123404290",
    })
    @DisplayName("Should throw exception when first name is null or empty")
    public void testAddContactNull(String firstName, String lastName, String phoneNumber) {
        Assertions.assertThrows(RuntimeException.class, () -> contactManager.addContact(firstName, lastName, phoneNumber));
    }

    @ParameterizedTest
    @CsvSource({
            "DASa, , 0123456789",
            "Jane, , 0123456780",
            "asdfa, , 0123457890",
            "Jane, , 0123404290",
    })
    @DisplayName("Should throw exception when last name is null or empty")
    public void testAddContactNullLastName(String firstName, String lastName, String phoneNumber) {
        Assertions.assertThrows(RuntimeException.class, () -> contactManager.addContact(firstName, lastName, phoneNumber));
    }

    @ParameterizedTest
    @CsvSource({
            "ADSFAS, Doe, ",
            "Jane, Doe, ",
            "sadfas, Smith, ",
            "Jane, Smith, ",
    })
    @DisplayName("Should throw exception when number is null or empty")
    public void testAddContactNullNumber(String firstName, String lastName, String phoneNumber) {
        Assertions.assertThrows(RuntimeException.class, () -> contactManager.addContact(firstName, lastName, phoneNumber));
    }


}
