package org.example.model;

public class Contact {
    private int id;
    private String name;
    private String family;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String lastName) {
        this.family = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact [Id=" + id + ", Name=" + name + ", Family=" + family + ", phoneNumber="
                + phoneNumber + "]";
    }
}
