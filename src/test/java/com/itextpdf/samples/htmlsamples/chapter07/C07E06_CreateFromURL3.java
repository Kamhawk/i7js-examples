package com.itextpdf.samples.htmlsamples.chapter07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.css.media.MediaDeviceDescription;
import com.itextpdf.html2pdf.css.media.MediaType;
import com.itextpdf.licensekey.LicenseKey;

/**
 * Converts a simple HTML file to PDF using an InputStream and an OutputStream
 * as arguments for the convertToPdf() method.
 */
public class C07E06_CreateFromURL3 {
	
	/** The target folder for the result. */
	public static final String ADDRESS = "https://stackoverflow.com/help/on-topic";
	/** The target folder for the result. */
	public static final String TARGET = "target/results/ch07/";
	/** The path to the resulting PDF file. */
	public static final String DEST = String.format("%surl2pdf_3.pdf", TARGET);
	
	/**
	 * The main method of this example.
	 *
	 * @param args no arguments are needed to run this example.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
    public static void main(String[] args) throws IOException {
        LicenseKey.loadLicenseFile(System.getenv("ITEXT7_LICENSEKEY") + "/itextkey-html2pdf_typography.xml");
        File file = new File(TARGET);
        file.mkdirs();
        new C07E06_CreateFromURL3().createPdf(new URL(ADDRESS), DEST);
    }

    /**
     * Creates the PDF file.
     *
     * @param url the URL object for the web page
     * @param dest the path to the resulting PDF
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void createPdf(URL url, String dest) throws IOException {
        ConverterProperties properties = new ConverterProperties();
        MediaDeviceDescription mediaDeviceDescription = new MediaDeviceDescription(MediaType.PRINT);
        properties.setMediaDeviceDescription(mediaDeviceDescription);
        HtmlConverter.convertToPdf(url.openStream(), new FileOutputStream(dest), properties);
    }
}