package st.evora.engenharia;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.model.Georreferencia;
import st.evora.engenharia.model.Role;
import st.evora.engenharia.model.User;

public class GeorreferenciaPDFExporter {
	private List<Georreferencia> listGeorreferencia;

	public GeorreferenciaPDFExporter(List<Georreferencia> listGeorreferencia) {
		this.listGeorreferencia = listGeorreferencia;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.orange);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.black);

		cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Latitude", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Longitude", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Descrição", font));
        table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) {
		for (Georreferencia georreferencia : listGeorreferencia) {
			table.addCell(String.valueOf(georreferencia.getIdgeorreferencia()));
            table.addCell(georreferencia.getLatitude());
            table.addCell(georreferencia.getLongitude());
            table.addCell(georreferencia.getDescricao());
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.darkGray);

		Paragraph p = new Paragraph("Lista das Coordenadas", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		//table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);
		

		document.add(table);

		document.close();

	}
}