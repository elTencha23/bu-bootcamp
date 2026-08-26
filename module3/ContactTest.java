import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 

     private Contact contact; 
     @BeforeEach
        void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
  }
  @Test
  void getName_returnsCorrectName() {
    assertEquals("Ada Lovelace", contact.getName());
  } 
 
  @Test
  void getPhone_returnsCorrectPhone() {
    assertEquals("+1 617 555 0101", contact.getPhone());
  } 
 
  @Test
  void toString_containsBothFields() {
    assertTrue(contact.toString().contains("Ada Lovelace"));
    assertTrue(contact.toString().contains("+1 617 555 0101"));
  }
 
  @Test 
  void constructor_setsNameCorrectly() { 
    Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("Ada Lovelace", c.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("+1 617 555 0101", c.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    Contact c = new Contact("Grace Hopper", "555-0000"); 
    assertEquals("Grace Hopper", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    Contact c = new Contact("Alan Turing", "555-0001"); 
    assertTrue(c.toString().contains("Alan Turing"));
  } 
 
  @Test
  void toString_containsPhone() {
    Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c.toString().contains("555-0001"));
  }

  @Test
  void contactsWithSameName_keepIndependentPhoneValues() {
    Contact firstContact = new Contact("Ada Lovelace", "555-0001");
    Contact secondContact = new Contact("Ada Lovelace", "555-0002");

    assertNotSame(firstContact, secondContact);
    assertEquals("Ada Lovelace", firstContact.getName());
    assertEquals("Ada Lovelace", secondContact.getName());
    assertEquals("555-0001", firstContact.getPhone());
    assertEquals("555-0002", secondContact.getPhone());
  }

  @Test
  void constructor_keepsNameAndPhoneInCorrectFields_whenValuesAreSwitched() {
    Contact normalContact = new Contact("Ada Lovelace", "555-0001");
    Contact switchedContact = new Contact("555-0001", "Ada Lovelace");

    assertEquals("Ada Lovelace", normalContact.getName());
    assertEquals("555-0001", normalContact.getPhone());
    assertEquals("555-0001", switchedContact.getName());
    assertEquals("Ada Lovelace", switchedContact.getPhone());
  }

  @Test
  void constructor_allowsContactWithEmptyName() {
    Contact contactWithoutName = new Contact("", "555-0003");

    assertEquals("", contactWithoutName.getName());
    assertEquals("555-0003", contactWithoutName.getPhone());
  }
} 
