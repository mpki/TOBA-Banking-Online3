/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Account;
import static Beans.Account.BankAccount.Checking;
import static Beans.Account.BankAccount.Savings;
import Beans.User;
import db.AccountDB;
import db.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matt
 */
public class NewCustomerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            HttpSession session = request.getSession(true);
        
            String Firstname = request.getParameter("FirstName");
            String Lastname = request.getParameter("LastName");
            String Phone = request.getParameter("Phone");
            String Address = request.getParameter("Address");
            String City = request.getParameter("City");
            String State = request.getParameter("State");
            String Zipcode = request.getParameter("Zipcode");
            String Email = request.getParameter("Email");
        
            String Username = Lastname + Zipcode;
            String Password = "welcome1";
            
            
            User user = new User(Firstname, Lastname, Email, Phone, Address, State, City, Zipcode, Username, Password);
            Account account = new Account(user, (float) 25.0);
            
            session.setAttribute("User", user);
            
            try {
                UserDB.insert(user);
            } catch (SQLException ex) {
                Logger.getLogger(NewCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Account savingsAccount = new Account(user, 25);
            savingsAccount.setAccountType(Savings);
            Account checkingAccount = new Account(user, 0);
            checkingAccount.setAccountType(Checking);
            
            AccountDB.insert(savingsAccount);
            AccountDB.insert(checkingAccount);
            
            request.getRequestDispatcher("Success.jsp").forward(request, response); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
