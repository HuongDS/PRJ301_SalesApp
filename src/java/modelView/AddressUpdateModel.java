/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

/**
 *
 * @author ASUS
 */
public class AddressUpdateModel {

    private int id;
    private String addressLine;
    private String city;
    private boolean isDefault;

    public AddressUpdateModel() {
    }

    public AddressUpdateModel(int id, String addressLine, String city, boolean isDefault) {
        this.id = id;
        this.addressLine = addressLine;
        this.city = city;
        this.isDefault = isDefault;
    }

    public int getId() {
        return id;
    }

    public void setId(int customerId) {
        this.id = customerId;
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

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

}
