package com.procurement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.procurement.model.Delivery;
import com.procurement.model.Payment;
import com.procurement.service.DeliveryService;
import com.procurement.service.PaymentService;

/**
 * Servlet implementation class AddDelivery
 */
@WebServlet("/AddDelivery")
public class AddDelivery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDelivery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
		
		PrintWriter out = response.getWriter();

		// get values for the variables from Register form

		String grn = request.getParameter("grn");
		String orderID = request.getParameter("orderID");
		String itemID = request.getParameter("itemID");
		String itemName = request.getParameter("itemName");
		String ppUnit = request.getParameter("ppUnit");
		String qty = request.getParameter("qty");
		String totAmount = request.getParameter("totAmount");
		String deliveryDate = request.getParameter("deliveryDate");
		
	

		// set values
		Delivery d = new Delivery();
		
		d.setGrn(grn);
		d.setOrderID(orderID);
		d.setItemID(itemID);
		d.setItemName(itemName);
		d.setPpUnit(ppUnit);
		d.setQty(qty);
		d.setTotAmount(totAmount);
		d.setDeliveryDate(deliveryDate);
		
		
	
		int status = DeliveryService.saveDelivery(d);
		if (status > 0) {
			out.print("<p>Record saved successfully!</p>");
			ArrayList<Delivery> deliveries =  DeliveryService.getAllDeliveries();
			
			request.setAttribute("deliveries", deliveries);
			
			RequestDispatcher rd = request.getRequestDispatcher("AddDelivery.jsp");
			rd.forward(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}
	}


