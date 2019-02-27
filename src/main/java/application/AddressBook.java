package application;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private List<BuddyInfo> buddyBook;

    public AddressBook(int id) {
        this.id = id;
        buddyBook = new ArrayList<BuddyInfo>();
    }

    public AddressBook() {
        this.buddyBook = buddyBook;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @OneToMany(cascade= CascadeType.ALL)
    public List<BuddyInfo> getBuddyBook() {
        return buddyBook;
    }

    public void setBuddyBook(List<BuddyInfo> buddyBook) {
        this.buddyBook = buddyBook;
    }

}
