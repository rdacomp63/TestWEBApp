package org.example.servlet;

import org.example.dao.ContactDao;
import org.example.dao.ContactDaoImpl;
import org.example.model.Contact;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/ContactServlet.do")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String LIST_CONTACT = "/listContacts.jsp";
    public static final String INSERT_OR_EDIT = "/Contact.jsp";
    private ContactDao dao = new ContactDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = LIST_CONTACT;
            String sId = request.getParameter("id");
            int contactId = Integer.parseInt(sId);
            dao.deleteContact(contactId);
            request.setAttribute("Contact", dao.getAllContact());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int contactId = Integer.parseInt(request.getParameter("id"));
            Contact contact = dao.getContactById(contactId);
            request.setAttribute("Contact", contact);
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        } else {
            forward = LIST_CONTACT;
            request.setAttribute("Contact", dao.getAllContact());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        Contact contact = new Contact();
        contact.setName(request.getParameter("name"));
        contact.setFamily(request.getParameter("family"));
        contact.setPhoneNumber(request.getParameter("phoneNumber"));
        String contactId = request.getParameter("id");

        if (contactId == null || contactId.isEmpty())
            dao.addContact(contact);
        else {
            contact.setId(Integer.parseInt(contactId));
            dao.updateContact(contact);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CONTACT);
        request.setAttribute("Contact", dao.getAllContact());
        view.forward(request, response);
    }
}




