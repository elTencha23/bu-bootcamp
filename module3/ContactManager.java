import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Alice", new Contact("Alice", "123-456-7890"));
        contacts.put("Bob", new Contact("Bob", "234-567-8901"));
        contacts.put("Charlie", new Contact("Charlie", "345-678-9012"));
        contacts.put("Paul", new Contact("Paul", "312-654-1234"));
        contacts.put("Mike", new Contact("Mike", "773-657-2296"));
 
        // Step 5: look up a contact 
        Contact found = contacts.get("Tristan");
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Contact not found.");
        }
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values()); 
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("=== All Contacts === ");
        for (Contact contact : sorted) {
            System.out.println("Contact: " + contact.getName() + "- Phone: " + contact.getPhone());
        }

        // Step 7: remove a contact
        removeContact(contacts, "Bob");
        System.out.println("=== All Contacts After Removal === ");
        ArrayList<Contact> sortedAfterRemoval = new ArrayList<>(contacts.values()); 
        sortedAfterRemoval.sort((a, b) -> a.getName().compareTo(b.getName()));
        for (Contact contact : sortedAfterRemoval) {
            System.out.println("Contact: " + contact.getName() + "- Phone: " + contact.getPhone());
        }

    } 

    public static void removeContact(HashMap<String, Contact> contacts, String name) {
        contacts.remove(name);
    }
}
