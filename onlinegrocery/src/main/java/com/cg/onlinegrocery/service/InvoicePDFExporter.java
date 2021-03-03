package com.cg.onlinegrocery.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.cg.onlinegrocery.domain.Item;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class InvoicePDFExporter {

	private List<Item> itemList;

	public InvoicePDFExporter(List<Item> itemList) {
		this.itemList = itemList;
	}

	private void writeTableHeader(PdfPTable table) {
		
		PdfPCell cell = new PdfPCell();
		
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(4);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Item ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Item Model", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Cost", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Company", font));
		table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) {
		for (Item item : itemList) {
			table.addCell(String.valueOf(item.getId()));
			table.addCell(item.getModel());
			table.addCell(String.valueOf(item.getCost()));
			table.addCell(item.getCompany());
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Vehicles", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 2.5f, 2.0f, 2.0f});
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}