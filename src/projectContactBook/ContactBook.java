package projectContactBook;


public class ContactBook {

    // total contacts in the Contact book
    private static final int MAX_CONTACTS = 5;

    // array to hold the contacts
    private Contact[] contacts;

    // counter to track number of contacts currently stored in array
    private int numberOfContacts;


    public ContactBook() {
        // no contacts are stored as yet
        // -1 because there are no elements
        numberOfContacts = 0;

        // allocate memory for the array
        contacts = new Contact[MAX_CONTACTS];
    }

    // returns the number of contacts
    public int getNumberOfContacts() {
        // this is used to track the number or entries made in the array.
        // if we use contacts.length, it will always return the size of
        // the array and not number of items

        return  numberOfContacts;
    }


    // returns true if contact with same number already exists
    public boolean contactWithSameNumberExists(Contact contact) {
        boolean contactExists = false;

        for(int i=1; i<=numberOfContacts; i++) {
            if(contacts[i-1].getPhoneNumber().equalsIgnoreCase(contact.getPhoneNumber())) {
                contactExists = true;
                break;
            }
        }

        return contactExists;
    }
    public boolean addContact(Contact addContact){
        if(numberOfContacts+1<=MAX_CONTACTS){
            if(contactWithSameNumberExists(addContact)){
                throw new IllegalArgumentException("Phone number already exists.");
            }
        }else {
            return false;
        }
        contacts[numberOfContacts++] = addContact;
        return true;
    }

    public Contact searchContactByPhone(String phoneNumber) {
        Contact returnContact = null;
        for(Contact contact:contacts){

            if(contact!=null && contact.getPhoneNumber().equals(phoneNumber)){
                returnContact = contact;
            }
        }
        return returnContact;
    }

    public boolean deleteContactByPhone(String phoneNumber) {
        boolean recordFound = false;

        for(int i=1; i<=numberOfContacts; i++) {
            if(contacts[i-1].getPhoneNumber().equalsIgnoreCase(phoneNumber)) {

                System.arraycopy(contacts, i, contacts, i, numberOfContacts - i);
                contacts[--numberOfContacts] = null;

                recordFound = true;
                return  recordFound;
            }
        }
        throw new IllegalArgumentException("The Record was not found.");
    }
}

