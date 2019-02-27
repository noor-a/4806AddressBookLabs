package application;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    private String name;

    private String address;
    private String phonenumber;
    private int age;
    private String greeting;

    public BuddyInfo(){
        this(null, null, null);
    }

    //Added for lab 07
    public BuddyInfo(String name, String address, String phonenumber, int age, String greeting) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.age = age;
        this.greeting = greeting;
    }

    public BuddyInfo(String name, String address, String phonenumber) {
        this(name, address, phonenumber, -1, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }


    /***********************************
     * 			Lab 07
     **********************************/
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isOver18() {
        if(this.age >= 18) {
            return true;
        }else {
            return false;
        }
    }

    public String getGreeting() {
        return greeting;
    }


    /***********************************
     * 			Lab 08
     *
     **********************************/
    public String toString() {
        String str = this.getName()+" "+this.getAddress()+" "+this.getPhoneNumber();
        return str;
    }

    public static BuddyInfo importData(String str) {
        String[]info = str.split("\\p{Punct}");
        return new BuddyInfo(info[0],info[1], info[2]);
    }
}
