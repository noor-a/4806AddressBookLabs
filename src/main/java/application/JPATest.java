package application;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JPATest {

    public void performJPA(){
        //Instances of BuddyInfo
        /*BuddyInfo b1 = new BuddyInfo("Noor", "Ottawa", "613");
        b1.setId(1);
        BuddyInfo b2 = new BuddyInfo("Ncho", "Hamilton", "289");
        b2.setId(2);*/

        //Creating an entity Manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();

        //Entity Transaction
        EntityTransaction et = em.getTransaction();
        et.begin();

        //Persist Buddies
        /*for(BuddyInfo b: buddies){
            em.persist(b);
        }
        System.out.println("Persisted BuddyInfos.....\n");*/

        AddressBook addressBk = new AddressBook();
        //Add Buddies to Address Book
        for(BuddyInfo b:buddies){
            addressBk.addBuddy(b);
        }
        Collection<BuddyInfo> bb = addressBk.getBuddyBook();
        for(BuddyInfo b: bb){
            System.out.println(b.toString());
        }

        //Persist Address Book
        em.persist(addressBk);
        System.out.println("Persisted AddressBook.....\n");

        //Persist instance of class(BuddyInfo)
        //em.persist(b1);
        //em.persist(b2);
        et.commit();

        //Query Table
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        //Retrieve Objects
        List<BuddyInfo> result = q.getResultList();
        System.out.println("List of Buddies\n .......................");
        for(BuddyInfo b:result){
            System.out.println(b.toString());
        }
        System.out.println("Finished.......\n\n");

        //Close Connections
        em.close();
        emf.close();

    }

    private static BuddyInfo[]buddies = new BuddyInfo[]{
            new BuddyInfo("Noor", "Ottawa", "613"),
            new BuddyInfo("Ncho", "Hamilton", "289"),
            new BuddyInfo("Sarfo", "London", "01438")
    };
}
