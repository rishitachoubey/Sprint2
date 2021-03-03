package com.cg.onlinegrocery.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinegrocery.domain.Item;
import com.cg.onlinegrocery.service.MockInvoiceService;
import com.cg.onlinegrocery.service.InvoicePDFExporter;

@RestController
@RequestMapping("/api")
public class InvoiceController {

	@Autowired
	MockInvoiceService service;

	@GetMapping("/getAllitems")
	public ResponseEntity<String> getitems(HttpServletResponse response) throws Exception {
		
		//response.setContentType("application/pdf"); //MIME type
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=item_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Item> itemList = service.getAllitems();

		
		InvoicePDFExporter exporter = new InvoicePDFExporter(itemList);
		exporter.export(response);
		
		return new ResponseEntity<String>("The response couldn't be previewed",HttpStatus.OK);
	}

}
