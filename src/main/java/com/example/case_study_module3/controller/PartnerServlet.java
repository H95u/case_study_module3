package com.example.case_study_module3.controller;

import com.example.case_study_module3.DAO.PartnerDAO;
import com.example.case_study_module3.model.Partner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PartnerServlet", value = "/partners")
public class PartnerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                break;
            case "update":

                break;
            case "partnerInfo":
                showPartnerInfo(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                break;
            case "update":

                break;
            case "login":

                break;
            default:
                break;
        }
    }

    private void showPartnerInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Partner partner = PartnerDAO.getInstance().findById(id);
        request.setAttribute("user", partner);
        request.getRequestDispatcher("/partner/partner-info.jsp").forward(request, response);
    }
}