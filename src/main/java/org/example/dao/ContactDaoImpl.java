package org.example.dao;

import org.example.model.Contact;
import org.example.util.DBConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl implements ContactDao{
    @Override
    public void addContact(Contact contact) {
        try(Connection conn = DBConnectionUtility.getDBConnection()) {
            String query = "insert into Contact (name, family, phoneNumber) values (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getFamily());
            preparedStatement.setString(3, contact.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContact(int contactId) {
        try(Connection conn = DBConnectionUtility.getDBConnection()) {
            String query = "delete from Contact where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, contactId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateContact(Contact contact) {
        try(Connection conn = DBConnectionUtility.getDBConnection()) {
            String query = "update Contact set name=?, family=?, phoneNumber=? where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getFamily());
            preparedStatement.setString(3, contact.getPhoneNumber());
            preparedStatement.setInt(4, contact.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> getAllContact() {
        List<Contact> contacts = new ArrayList<Contact>();
        try(Connection conn = DBConnectionUtility.getDBConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Contact");
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("name"));
                contact.setFamily(resultSet.getString("family"));
                contact.setPhoneNumber(resultSet.getString("phoneNumber"));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public Contact getContactById(int contactId) {
        Contact contact = new Contact();
        try(Connection conn = DBConnectionUtility.getDBConnection()) {
            String query = "select * from Contact where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, contactId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("name"));
                contact.setFamily(resultSet.getString("family"));
                contact.setPhoneNumber(resultSet.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }
}
