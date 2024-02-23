package com.example.exam.controller;

import com.example.exam.DAO.IProductDAO;
import com.example.exam.DAO.IShoppingCartDAO;
import com.example.exam.model.ShoppingCart;
import com.example.exam.service.IProductService;
import com.example.exam.service.IShoppingCartService;
import com.example.exam.service.impl.ProductService;
import com.example.exam.service.impl.ShoppingCartService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "CartServlet", urlPatterns = "/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {
    IShoppingCartService shoppingCartService = new ShoppingCartService();
    IProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "addProductToCart":
                addProductToCart(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "addProductToCart":
                addProductToCart(request, response);
                listCart(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            default:
                listCart(request, response);
                break;
        }
    }

    private void listCart(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/shoppingCart/cart.jsp");
        request.setAttribute("shoppingCarts", shoppingCartService.findAll());
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addProductToCart(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("product", productService.findAll());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1);
        shoppingCart.setProductId(1);
        shoppingCart.setQuantity(1);

        boolean check = shoppingCartService.update(shoppingCart);
        String message = "Update successfully!";
        if (!check) {
            message = "Update failed!";
        }
        request.setAttribute("message", message);
        request.setAttribute("check", check);

        try {
            response.sendRedirect(request.getContextPath() + "/shoppingCart");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.remove(id);
        request.setAttribute("product", productService.findAll());
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
