public class Address {
    private String streetNum;
    private String streetName;
    private String apartmentNum;
    private String city;
    private String state;
    private String zipCode;

    public Address(String streetNum, String streetName, String city, String state, String zipCode, String apartmentNum) {
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.apartmentNum = apartmentNum;
    }

    public Address(Address address) {
        streetNum = address.getStreetNum();
        streetName = address.getStreetName();
        city = address.getCity();
        state = address.getState();
        zipCode = address.getZipCode();
        apartmentNum = address.getApartmentNum();
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNum() {
        return apartmentNum;
    }

    public void setApartmentNum(String apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString() {
        return streetNum + " " + streetName + " " + apartmentNum + ", " + city + ", " + state + zipCode;
    }
}
