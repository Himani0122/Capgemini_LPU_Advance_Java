package Assignment;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passport {

    @Id
    private int passportNo;
    private String name;
    private String gender;
    private String address;
    private int noOfTravel;

    public int getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfTravel() {
        return noOfTravel;
    }

    public void setNoOfTravel(int noOfTravel) {
        this.noOfTravel = noOfTravel;
    }

    @Override
    public String toString() {
        return "Passport [passportNo=" + passportNo + ", name=" + name +
                ", gender=" + gender + ", address=" + address +
                ", noOfTravel=" + noOfTravel + "]";
    }
}