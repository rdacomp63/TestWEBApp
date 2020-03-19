package org.example.dao;

import org.example.model.Contact;

import java.util.List;

public interface ContactDao {
    public void addContact(Contact contact);

    public void deleteContact(int contactId);

    public void updateContact(Contact contact);

    public List<Contact> getAllContact();

    public Contact getContactById(int ContactId);
}
