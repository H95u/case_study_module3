package com.example.case_study_module3.controller;

import com.example.case_study_module3.DAO.PartnerDAO;
import com.example.case_study_module3.DAO.UserDAO;
import com.example.case_study_module3.model.Partner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@MultipartConfig
@WebServlet(name = "PartnerServlet", value = "/home")
public class HomeServlet extends HttpServlet {
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
                findAll(request, response);
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
            case "upload":
                uploadImage(request, response);
                break;
            default:

                break;
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Partner> partnerList = PartnerDAO.getInstance().findAll();
        request.setAttribute("partnerList", partnerList);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    private void showPartnerInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Partner partner = PartnerDAO.getInstance().findById(id);
        request.setAttribute("user", partner);
        HttpSession session = request.getSession();
        if (session.getAttribute("userRole") != null) {
            int userRole = (int) session.getAttribute("userRole");
            if (userRole == 1) {
                request.getRequestDispatcher("/partner/partner-info-admin.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/partner/partner-info.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/partner/partner-info.jsp").forward(request, response);
        }
    }

    private static void uploadImage(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        int id = Integer.parseInt(request.getParameter("id"));
        PartnerDAO.getInstance().uploadImage(fileContent, id);
        response.sendRedirect("/home?action=partnerInfo&id=" + id);
    }
}