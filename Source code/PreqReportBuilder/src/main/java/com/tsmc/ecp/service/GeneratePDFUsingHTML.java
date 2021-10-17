package com.tsmc.ecp.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.font.FontProvider;

import java.io.*;

public class GeneratePDFUsingHTML {

    public static void main(String[] args) throws IOException {

    	OutputStream fileOutputStream = new FileOutputStream("string-output.pdf");

    	ConverterProperties properties = new ConverterProperties();
    	properties.setCreateAcroForm(true); //setBaseUri(baseUri);
    	
    	HtmlConverter.convertToPdf("<h1>Hello String Content!</h1>", , fileOutputStream);
    	
    	/// Need style.css file for below method.
        //HtmlConverter.convertToPdf(new File("./src/main/resources/static/pdf-input.html"),new File("demo-html.pdf"));
    }
    
    public void generatePdf( ) throws IOException {
    	
        File src = new File("source_html_file.html");
        File dest = new File("target_pdf_file.pdf");

        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdf, PageSize.A3); 
        InputStream stream = new FileInputStream(src);

        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider dfp = new DefaultFontProvider(true, true, true);
        converterProperties.setFontProvider(dfp);

        HtmlConverter.convertToPdf(stream, pdf, converterProperties);
    	
    }
    
    //https://forums.asp.net/t/2171048.aspx?Converting+HTML+Panel+to+PDF
    
    //https://www.itread01.com/content/1549591945.html
    public void createPdf(
    	    byte[] xml, byte[] html, String baseUri, String dest, String intent)
    	    throws IOException {
    	    PdfWriter writer = new PdfWriter(dest);
    	    PdfDocument pdf = new PdfDocument(writer, 
    	        PdfConformanceLevel.PDF_A_3A,
    	        new PdfOutputIntent("Custom", "", "https://www.color.org",
    	        "sRGB IEC61966-2.1", new FileInputStream(intent)));
    	    pdf.setTagged();
    	    pdf.addFileAttachment(
    	        "Movie info", xml, "movies.xml",
    	        PdfName.ApplicationXml, new PdfDictionary(), PdfName.Data);
    	    ConverterProperties properties = new ConverterProperties();
    	    properties.setBaseUri(baseUri);
    	    HtmlConverter.convertToPdf(new ByteArrayInputStream(html), pdf, properties);
    	}
    
}
