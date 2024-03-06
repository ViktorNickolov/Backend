package com.bms.clientmanagementsystem.service;

import com.bms.clientmanagementsystem.helper.DateHelper;
import com.bms.clientmanagementsystem.helper.message.BusinessLogMessage;
import com.bms.clientmanagementsystem.model.ClientCase;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
@Slf4j
public class PdfService {

    public ByteArrayInputStream generatePdf(final ClientCase clientCase) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);

        final String title = "Client Case" + " " + clientCase.getClient().getFirstName() + " "
                + clientCase.getClient().getLastName();
        final String fileName = clientCase.getClient().getFirstName() + "_" + clientCase.getClient().getLastName()
                + "_" + clientCase.getStartTime() + ".pdf";
        final String content = "Client Name: " + clientCase.getClient().getFirstName() + "\n "
                + clientCase.getClient().getLastName() + "\n"
                + "Client Case Start Time: " + clientCase.getStartTime();
        final String localTime = DateHelper.getCurrentDateTime().toString();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
        Font localTimeFont = FontFactory.getFont(FontFactory.HELVETICA, 8);

        Paragraph titleParagraph = new Paragraph(title, titleFont);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);

        Paragraph contentParagraph = new Paragraph(content, contentFont);

        Paragraph localTimeParagraph = new Paragraph(localTime, localTimeFont);
        localTimeParagraph.setAlignment(Element.ALIGN_RIGHT);

        document.open();
        document.addTitle(fileName);
        document.addAuthor("BMS");
        document.addCreator("BMS");
        document.add(localTimeParagraph);
        document.add(titleParagraph);
        document.add(contentParagraph);
        document.setPageSize(PageSize.A4);
        document.close();

        log.info(BusinessLogMessage.Pdf.PDF_GENERATED);
        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream generatePdf(final com.bms.clientmanagementsystem.model.Document fileDocument) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, out);

        final String title = fileDocument.getClient().getFirstName()
                + " " + fileDocument.getClient().getLastName();
        final String fileName = fileDocument.getClient().getFirstName() + "_"
                + fileDocument.getClient().getLastName() + "_"
                + fileDocument.getCreatedTime().toString() + ".pdf";
        final String content = "Client Name: " + fileDocument.getClient().getFirstName() + " "
                + fileDocument.getClient().getLastName() + "\n"
                + "Client Case Start Time: " + fileDocument.getCreatedTime() + "\n"
                + "Appointment Status: " + fileDocument.getAppointment().getStatus().getName();

        final String detailContent = "Detail: " + fileDocument.getDetail();
        final String localTime = DateHelper.getCurrentDateTime().toString();

        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
        Font localTimeFont = FontFactory.getFont(FontFactory.HELVETICA, 8);

        Paragraph titleParagraph = new Paragraph(title, titleFont);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);

        Paragraph contentParagraph = new Paragraph(content, contentFont);

        Paragraph detailParagraph = new Paragraph(detailContent, contentFont);

        Paragraph localTimeParagraph = new Paragraph(localTime, localTimeFont);
        localTimeParagraph.setAlignment(Element.ALIGN_RIGHT);

        document.open();
        document.addTitle(fileName);
        document.addAuthor("BMS");
        document.addCreator("BMS");
        document.add(localTimeParagraph);
        document.add(titleParagraph);
        document.add(contentParagraph);
        document.add(detailParagraph);
        document.setPageSize(PageSize.A4);
        document.close();

        log.info(BusinessLogMessage.Pdf.PDF_GENERATED);
        return new ByteArrayInputStream(out.toByteArray());
    }
}
