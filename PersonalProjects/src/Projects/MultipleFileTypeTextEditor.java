package Projects;


import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.pdfbox.text.PDFTextStripper;

import javafx.application.Application;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
public class MultipleFileTypeTextEditor extends Application {
	String pathtext="";
	public MultipleFileTypeTextEditor() {
		pathtext=this.pathtext;
	}
	public void getString(File filepath) {
		this.pathtext=filepath.getPath();
	}
	public void start(Stage GUI) {
		GridPane editpane=new GridPane();
		FileChooser filedialog=new FileChooser();
		filedialog.setTitle("Open File");
		filedialog.getExtensionFilters().addAll(new ExtensionFilter("Text Document", "*.txt"));
		filedialog.getExtensionFilters().addAll(new ExtensionFilter("JAVA File", "*.java"));
		filedialog.getExtensionFilters().addAll(new ExtensionFilter("Visual C# Source File", "*.cs"));
		filedialog.getExtensionFilters().addAll(new ExtensionFilter("Chrome HTML Document", "*.html"));
		filedialog.getExtensionFilters().addAll(new ExtensionFilter("JavaScript File", "*.js"));
		filedialog.getExtensionFilters().addAll(new ExtensionFilter("Word Document", "*.docx"));
		filedialog.getExtensionFilters().addAll(new ExtensionFilter("PDF Document", "*.pdf"));
		
		Button openfile=new Button("Open File");
		Button savefile=new Button("Save File");
		Button saveasfile=new Button("Save File As");
		TextField filenamefield=new TextField();
		TextArea editarea=new TextArea();
		HBox buttons=new HBox();
		openfile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				File chosenfile=filedialog.showOpenDialog(GUI);
				if(chosenfile.getName().contains(".txt")||chosenfile.getName().contains(".java")||chosenfile.getName().contains(".cs")
						||chosenfile.getName().contains(".html")||chosenfile.getName().contains(".js")) {
					System.out.println("Text File");
					getString(chosenfile);
					try {
						String File_text="";
						BufferedReader reader=new BufferedReader(new FileReader(chosenfile));
						StringBuilder buildstring1=new StringBuilder();
						while((File_text=reader.readLine())!=null) {
							buildstring1.append(File_text+"\n");
						}
						editarea.clear();
						editarea.appendText(buildstring1.toString());
						reader.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(chosenfile.getName().contains(".docx")) {
					System.out.println("Docx File");
					getString(chosenfile);
					FileInputStream input;
					try {
						input = new FileInputStream(chosenfile);
						XWPFDocument worddocument=new XWPFDocument(input);
						List<XWPFParagraph> paragraphs=worddocument.getParagraphs();
						StringBuilder buildstring2=new StringBuilder();
						for(XWPFParagraph paragraph:paragraphs) {
							buildstring2.append(paragraph.getText());
						}
						editarea.clear();
						editarea.appendText(buildstring2.toString());
						worddocument.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(chosenfile.getName().contains(".pdf")) {
					System.out.println("PDF File");
					System.out.println(chosenfile.getPath());
					getString(chosenfile);
					System.out.println("Chosen file: "+pathtext);
					try {
						PDDocument pdfdoc=PDDocument.load(chosenfile);
						PDFTextStripper striptext=new PDFTextStripper();
						String pdftext=striptext.getText(pdfdoc);
						editarea.clear();
						editarea.appendText(pdftext);
						pdfdoc.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				filenamefield.clear();
				filenamefield.appendText(pathtext);
			}
		});
		savefile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					System.out.println(pathtext);
					File saveeditedfile=new File(pathtext);
					if(saveeditedfile.getName().contains(".docx")){
						System.out.println("Docx Save");
						if(saveeditedfile.exists()) {
							FileInputStream docfile=new FileInputStream(saveeditedfile);
							XWPFDocument worddocument=new XWPFDocument(docfile);
							List<XWPFParagraph> paragraphs=worddocument.getParagraphs();
							for(XWPFParagraph paragraph:paragraphs) {
								for(XWPFRun runs: paragraph.getRuns()) {
									String documenttext=runs.getText(0);
									documenttext=documenttext.replace(runs.getText(0), editarea.getText());
									runs.setText(documenttext,0);
								}
							}
							FileOutputStream output=new FileOutputStream(saveeditedfile);
							worddocument.write(output);
							output.close();
						}
					}else if(saveeditedfile.getName().contains(".txt")||saveeditedfile.getName().contains(".java")||saveeditedfile.getName().contains(".cs")
							||saveeditedfile.getName().contains(".html")||saveeditedfile.getName().contains(".js")) {
						System.out.println("Text Save");
						System.out.println(pathtext);
						FileWriter writefile=new FileWriter(saveeditedfile,false);
						writefile.write(editarea.getText());
						writefile.close();
					}else if(saveeditedfile.getName().contains(".pdf")){
						if(saveeditedfile.delete()) {
							System.out.println("Original File deleted, new one will be created");
						}else {
							System.out.println("File is not deleted");
						}
						Document pdfdoc=new Document();
						File Tempfile=new File("temppdf.pdf");
						FileOutputStream editedpage=new FileOutputStream(Tempfile);
						PdfWriter overwrite=PdfWriter.getInstance(pdfdoc, editedpage);
						overwrite.open();
						pdfdoc.open();
						pdfdoc.add(new Paragraph(editarea.getText()));
						pdfdoc.close();
						overwrite.close();
						PdfReader read=new PdfReader(Tempfile.getPath());
						String filetext="";
						for(int i=1;i<=read.getNumberOfPages();i++) {
							filetext+=PdfTextExtractor.getTextFromPage(read,i);
						}
						File originalfile = new File(pathtext);
						Document newpdfdoc=new Document();
						FileOutputStream neworiginalfile=new FileOutputStream(originalfile);
						PdfWriter appendtext=PdfWriter.getInstance(newpdfdoc, neworiginalfile);
						appendtext.open();
						newpdfdoc.open();
						newpdfdoc.add(new Paragraph(filetext));
						newpdfdoc.close();
						appendtext.close();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		saveasfile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					File saveeditedfile=filedialog.showSaveDialog(GUI);
					if(saveeditedfile.getName().contains(".docx")){
						System.out.println("Docx Save");
						if(saveeditedfile.exists()) {
							FileInputStream docfile=new FileInputStream(saveeditedfile);
							XWPFDocument worddocument=new XWPFDocument(docfile);
							List<XWPFParagraph> paragraphs=worddocument.getParagraphs();
							for(XWPFParagraph paragraph:paragraphs) {
								for(XWPFRun runs: paragraph.getRuns()) {
									String documenttext=runs.getText(0);
									documenttext=documenttext.replace(runs.getText(0), editarea.getText());
									runs.setText(documenttext,0);
								}
							}
							FileOutputStream output=new FileOutputStream(saveeditedfile);
							worddocument.write(output);
							output.close();
						}else {
							XWPFDocument newdocument=new XWPFDocument();
							XWPFParagraph newparagraph=newdocument.createParagraph();
							XWPFRun newrun=newparagraph.createRun();
							FileOutputStream output=new FileOutputStream(saveeditedfile);
							newrun.setText(editarea.getText());
							newdocument.write(output);
							output.close();
							newdocument.close();
						}
					}else if(saveeditedfile.getName().contains(".txt")||saveeditedfile.getName().contains(".java")||saveeditedfile.getName().contains(".cs")
							||saveeditedfile.getName().contains(".html")||saveeditedfile.getName().contains(".js")) {
						System.out.println("Text Save");
						FileWriter writefile=new FileWriter(saveeditedfile,false);
						writefile.write(editarea.getText());
						writefile.close();
					}else if(saveeditedfile.getName().contains(".pdf")){
							Document newdoc=new Document();
							FileOutputStream editedfile=new FileOutputStream(saveeditedfile);
							PdfWriter writetopdf=PdfWriter.getInstance(newdoc, editedfile);
							writetopdf.open();
							newdoc.open();
							newdoc.add(new Paragraph(editarea.getText()));
							newdoc.close();
							writetopdf.close();
							editedfile.close();
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttons.getChildren().addAll(openfile,savefile,saveasfile);
		editpane.add(filenamefield, 0, 0);
		editpane.add(editarea, 0, 1);
		editpane.add(buttons, 0, 2);
		Scene mainscene=new Scene(editpane);
		GUI.setScene(mainscene);
		GUI.show();
		GUI.setTitle("Multi-File Type Text Editor");
	}
	public static void main(String[]args) throws IOException {
		launch(args);
	}
}
