package application;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddyBook = new ArrayList<BuddyInfo>();

    public AddressBook() {

    }

    public AddressBook(List<BuddyInfo>buddyBook) {
        this.buddyBook = buddyBook;
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
