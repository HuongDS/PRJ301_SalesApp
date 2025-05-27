/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 * Enum represent user roles (permission) in the system. ADMIN CUSTOMER STAFF
 *
 * @author ASUS
 */
public enum Role {

    ADMIN,
    CUSTOMER,
    STAFF;

    public static Role getADMIN() {
        return ADMIN;
    }

    public static Role getCUSTOMER() {
        return CUSTOMER;
    }

    public static Role getSTAFF() {
        return STAFF;
    }

    /**
     * Convert from String to Role Enum
     *
     * @param valueFromDb
     * @return
     */
    public static Role fromString(String valueFromDb) {
        return Role.valueOf(valueFromDb.toUpperCase());
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
