/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

/**
 *
 * @author ASUS
 */
public class AddressViewModel {

    private int customerId;
    private String addressLine;
    private String city;

    public AddressViewModel() {
    }

    public AddressViewModel(int customerId, String addressLine, String city) {
        this.customerId = customerId;
        this.addressLine = addressLine;
        this.city = city;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressViewModel{" + "customerId=" + customerId + ", addressLine=" + addressLine + ", city=" + city + '}';
    }

}
