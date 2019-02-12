package application;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private Long id;

    private List<BuddyInfo> buddyBook;

    public AddressBook(Long id) {
        this.id = id;
        this.buddyBook = buddyBook;
    }

    public AddressBook() {
        this.buddyBook = new ArrayList<BuddyInfo>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo buddy) {
        if (buddy != null) {
            buddyBook.add(buddy);
        }
    }

    public void removeBuddy(int index) {
        if (index >= 0 && index < buddyBook.size()) {
            buddyBook.remove(index);
        }
    }

    public List<BuddyInfo> getBuddyBook() {
        return buddyBook;
    }

    public void setBuddyBook(List<BuddyInfo> buddyBook) {
        this.buddyBook = buddyBook;
    }

}
