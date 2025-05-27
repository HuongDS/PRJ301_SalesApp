/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enums;

/**
 * Order's status. CANCELLED, DELIVERED, SHIPPING, PENDING, CONFIRMED
 *
 * @author ASUS
 */
public enum OrderStatus {

    CANCELLED,
    DELIVERED,
    SHIPPING,
    PENDING,
    CONFIRMED;

    /**
     * Convert from String to OrderStatus Enum
     *
     * @param valueFromDb
     * @return
     */
    public static OrderStatus fromString(String valueFromDb) {
        return OrderStatus.valueOf(valueFromDb.toUpperCase());
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
