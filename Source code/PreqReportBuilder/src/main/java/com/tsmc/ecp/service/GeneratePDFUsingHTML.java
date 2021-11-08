package com.tsmc.ecp.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.pdf.PdfWriter;

//import com.itextpdf.kernel.pdf.PdfAConformanceLevel;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfOutputIntent;
////import com.itextpdf.layout.Document;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.layout.font.FontProvider;
//
//import com.itextpdf.html2pdf.ConverterProperties;
//import com.itextpdf.html2pdf.HtmlConverter;
//import com.itextpdf.kernel.pdf.PdfReader;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.kernel.geom.PageSize;
//import com.itextpdf.kernel.utils.PdfMerger;
//import com.itextpdf.licensekey.LicenseKey;

import java.io.*;
import java.net.URL;

public class GeneratePDFUsingHTML {

    public static void main(String[] args) throws IOException {

    	OutputStream fileOutputStream = new FileOutputStream("string-output.pdf");

    	ConverterProperties properties = new ConverterProperties();
    	properties.setCreateAcroForm(true); //setBaseUri(baseUri);
    	
    	String htmlString = "<h1>Hello String Content!</h1>";  
    	
    	HtmlConverter.convertToPdf(htmlString, fileOutputStream);
    	
    	htmlString = readHtmlFileAsString();
    	
    	generatePDF(htmlString); 
    	/// Need style.css file for below method.
        //HtmlConverter.convertToPdf(new File("./src/main/resources/static/pdf-input.html"),new File("demo-html.pdf"));
    }

    public static String readHtmlFileAsString() {
    	
    	StringBuilder html = new StringBuilder();
        try {

            // Reading html file on local directory
        	String filePath = "src/main/resources/static/pdf-input.html"; 
            FileReader fr = new FileReader(filePath);
        	
            // Initialization of the buffered Reader to get the String append to the String Builder
            BufferedReader br = new BufferedReader(fr);
 
            String val;
            // Reading the String till we get the null string and appending to the string
            while ((val = br.readLine()) != null) {
                html.append(val);
            }
 
            // AtLast converting into the string
            String result = html.toString();
            //System.out.println(result);
 
            // Closing the file after all the completion of Extracting
            br.close();
            return result; 
        } catch (Exception ex) {
 
            /* Exception of not finding the location and
            string reading termination the function
            br.close(); */
            return ex.getMessage();
        }
    }
    
    
    public static void generatePDF(String htmlFile) {
        try {

            //HTML String
            String htmlString = htmlFile;
            //Setting destination
            OutputStream fileOutputStream = new FileOutputStream(new File("src/main/resources/static/USER-16-PF-Report.pdf"));
            		
            PdfDocument pdfDocument = new PdfDocument();
            //PdfWriter pdfWriter = new PdfWriter();
            ConverterProperties converterProperties = new ConverterProperties();


            //For setting the PAGE SIZE
            pdfDocument.setPageSize(PageSize.A3);
           
            //Document document = HtmlConverter.convertToDocument(htmlFile, pdfDocument, converterProperties);
            //Document document = 
            HtmlConverter.convertToPdf(htmlFile, fileOutputStream, converterProperties);
            ByteArrayOutputStream bos = (ByteArrayOutputStream)fileOutputStream;
            byte[] pdfBytes = bos.toByteArray(); 
            		
            //document.close();
        }
        catch (Exception e) {
             e.printStackTrace();
        }
    }
    
/*    
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
    //https://kb.itextpdf.com/home/it5kb/examples/page-size
    //https://www.itread01.com/content/1549591945.html
    //https://forums.asp.net/t/2171048.aspx?Converting+HTML+Panel+to+PDF
    public void createPdf(
    	    byte[] xml, byte[] html, String baseUri, String dest, String intent)
    	    throws IOException {
    	    PdfWriter writer = new PdfWriter(dest);
    	    
    	    PdfADocument pdf = new PdfADocument(writer,
    	            PdfAConformanceLevel.PDF_A_2B,
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
    
    public static ByteArrayOutputStream createPdf(String htmlSrc) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri(new File(htmlSrc).getParent());
        com.itextpdf.kernel.pdf.PdfWriter writer = new com.itextpdf.kernel.pdf.PdfWriter(output);
        PdfDocument pdfDocument = new PdfDocument(writer);
        pdfDocument.setDefaultPageSize(PageSize.A3);
        PdfMerger merger = new PdfMerger(pdfDocument);
        for(int x=0; x < 3; x++){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfDocument temp = new PdfDocument(new PdfWriter(baos));
            temp.setDefaultPageSize(PageSize.A3);
            HtmlConverter.convertToPdf(new FileInputStream(htmlSrc), temp, converterProperties);
            temp = new PdfDocument(new PdfReader(new ByteArrayInputStream(baos.toByteArray())));
            merger.merge(temp, 1, temp.getNumberOfPages());
            temp.close();
        }
        pdfDocument.close();

        return output;
    }
    
    public static void PrintPDFFromHTMLString(HttpServletResponse response, String docText) {

        try {
            float left = 30;
            float right = 30;
            float top = 60;
            float bottom = 0;
            Document document = new Document(PageSize.A4, left, right, top, bottom);
            PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();
            document.setMargins(left, right, 0, bottom);
            for (int i = 0; i < 60; i++) {
                document.add(new Paragraph("This is a test"));
            }
            document.close();
        }
        catch (Exception e) {
        	logger.error("Unexpected error", e);
        }
    }
//*/   
    
}
