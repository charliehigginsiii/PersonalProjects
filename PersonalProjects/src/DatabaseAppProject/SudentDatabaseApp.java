package DatabaseAppProject;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.application.Application;
public class SudentDatabaseApp extends Application {
		SudentDatabaseApp obj;
		Object com;
		Stage window;
		Scene newscene;
		GridPane gpagrid;
		GridPane mygrid;
		TextField idfield1;
		TextField namefield1;
		TextField classificationfield1;
		TextField agefield1;
		TextField majorfield1;
		TextField gpafield1;
		TextField residencefield1;
		TextField idfield2;
		TextField namefield2;
		TextField classificationfield2;
		TextField agefield2;
		TextField majorfield2;
		TextField gpafield2;
		TextField residencefield2;
		TextField idfield3;
		TextField idfield4;
		TextArea displayfield;
		Button Add1;
		Button Add2;
		Button Add3;
		Button Remove;
		Button Search;
		Button Showall;
		Button Show;
		Button Clear;
		Button Save;
		String studentinfo;
		Node first;
		Node last;
		Node temp;
		int r;
		int e;
		public SudentDatabaseApp(){
			this.e=1;
			this.temp=null;
			this.first=null;
			this.last=null;
			this.r=0;
		}
		public class Node{
			Node next;
			Node previous;
			Student student;
			public Node(Student student){
				this.next=null;
				this.previous=null;
				this.student=student;
			}
		}
		public void adds(Student student){
			Node newnode=new Node(student);
			if(first==null){
				first=last=newnode;
				first.previous=null;
				last.next=null;
			}else{
				first.previous=newnode;
				newnode.next=first;
				newnode.previous=null;
				first=newnode;
			}
			
		}
		public void adde(Student student){
			Node newnode=new Node(student);
			if(first==null){
				first=last=newnode;
				first.previous=null;
				last.next=null;
			}else{
				last.next=newnode;
				newnode.previous=last;
				last=newnode;
				last.next=null;
			}
			
		}
		public void adda(Student student){
			Node newnode=new Node(student);
			if(e==1){
				newnode.next=first;
				first=newnode;
			}else{
				Node n=first;
				while(--e>1){
					n=n.next;
				}
				newnode.next=n.next;
				n.next=newnode;
			}
			
		}
		public void search(String someCharacteristic){
			Node elem=this.first;
			boolean check=false;
	 		int e=1;
				while(elem!=null){
					if(elem.student.getName().contentEquals(someCharacteristic)||elem.student.classification.contentEquals(someCharacteristic)||elem.student.age.contentEquals(someCharacteristic)||
							elem.student.major.contentEquals(someCharacteristic)||elem.student.gpa.contentEquals(someCharacteristic)||elem.student.residence.contentEquals(someCharacteristic)){
						check=true;
						studentinfo+="Student Id: "+elem.student.id+", Student Name: "+elem.student.name+", Classification: "+elem.student.classification+", Age: "+elem.student.age+
								", Major: "+elem.student.major+", GPA: "+elem.student.gpa+", Residence: "+elem.student.residence+", Position: "+e+"\n";
						studentinfo.replaceAll("nullStudent","Student");
					}
					e++;
					elem=elem.next;
				}
					if(!check)
						studentinfo="Student not found";
				
		}
		public void remove(String id){
			Node current=first;
			Node pcurrent=null;
			while(current!=null){
				if(Integer.parseInt(id)==current.student.id){
					if(pcurrent==null){
						first=current.next;
					}else{
						pcurrent.next=current.next;
					}
					r--;
				}else{
					pcurrent=current;
				}
				current=current.next;
			}
		}
		public void info(){
			temp=first;
			if(temp!=null){
				displayfield.appendText("Student Id: "+temp.student.id+", Student Name: "+temp.student.getName()+", Classification: "+temp.student.getClassification()+", Age: "+
			temp.student.getAge()+", Major: "+temp.student.getMajor()+", GPA: "+temp.student.getGpa()+", Residence: "+temp.student.getResidence()+"\n");
				temp=temp.next;
			}
		}
		public void infoall(){
			temp=first;
			while(temp!=null){
				displayfield.appendText("Student Id: "+temp.student.id+", Student Name: "+temp.student.name+", Classification: "+temp.student.getClassification()+", Age: "+
			temp.student.age+", Major: "+temp.student.major+", GPA: "+temp.student.gpa+", Residence: "+temp.student.residence+"\n");
				temp=temp.next;
			}
		}
		public void infoo(){
			temp=first;
			while(temp!=null){
				System.out.println("Student Id: "+temp.student.id+", Student Name: "+temp.student.name+", Classification: "+temp.student.classification+", Age: "+temp.student.age+"\n");
				temp=temp.next;
			}
		}
		public void start(Stage prime){
			window=prime;
			obj=new SudentDatabaseApp();
			mygrid=new GridPane();
			namefield1=new TextField();
			idfield1=new TextField();
			idfield2=new TextField();
			classificationfield1=new TextField();
			agefield1=new TextField();
			namefield2=new TextField();
			classificationfield2=new TextField();
			agefield2=new TextField();
			idfield3=new TextField();
			idfield4=new TextField();
			displayfield=new TextArea();
			majorfield1=new TextField();
			gpafield1=new TextField();
			residencefield1=new TextField();
			majorfield2=new TextField();
			gpafield2=new TextField();
			residencefield2=new TextField();
			displayfield.setEditable(false);
			Label lab1=new Label("Student Name:");
			Label lab2=new Label("Classification:");
			Label lab3=new Label("Age:");
			Label lab4=new Label("Student Name:");
			Label lab5=new Label("Classification:");
			Label lab6=new Label("Age:");
			Label lab7=new Label("Student Id:");
			Label lab8=new Label("Student Id:");
			Label lab10=new Label("Student Id:");
			Label lab14=new Label("Student Id:");
			Label lab13=new Label("Clear text area when you\nadd new elements to list.");
			Label lab18=new Label("Major: ");
			Label lab19=new Label("GPA: ");
			Label lab20=new Label("Residence: ");
			Label lab21=new Label("Major: ");
			Label lab22=new Label("GPA: ");
			Label lab23=new Label("Residence: ");
			
			Add1=new Button("Add at start");
			Add2=new Button("Add at end");
			Add3=new Button("Add at position");
			Remove=new Button("Remove");
			Search=new Button("Search");
			Show=new Button("Show");
			Showall=new Button("Show all");
			Clear=new Button("Clear");
			displayfield.setPrefHeight(250);
			displayfield.setPrefWidth(600);
			Add1.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					obj.adds(new Student(Integer.parseInt(idfield1.getText()),namefield1.getText(), classificationfield1.getText(), agefield1.getText(),
							majorfield1.getText(), gpafield1.getText(), residencefield1.getText()));
							idfield1.setText("");
							namefield1.setText("");
							classificationfield1.setText("");
							agefield1.setText("");
							majorfield1.setText("");
							gpafield1.setText("");
							residencefield1.setText("");
				}
			});
			Add2.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					obj.adde(new Student(Integer.parseInt(idfield2.getText()),namefield2.getText(), classificationfield2.getText(), agefield2.getText(),
							majorfield2.getText(), gpafield2.getText(), residencefield2.getText()));
							idfield2.setText("");
							namefield2.setText("");
							classificationfield2.setText("");
							agefield2.setText("");
							residencefield1.setText("");
							majorfield2.setText("");
							gpafield2.setText("");
							residencefield2.setText("");
				}
			});
			
			Remove.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					obj.remove(idfield3.getText());
							idfield3.setText("");
				}
			});
			Search.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					obj.search(idfield4.getText());
					idfield4.setText("");
					displayfield.setText(studentinfo.replaceAll("nullStudent","Student"));
				}
			});
			Show.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
						obj.info();
				}
			});
			Showall.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
						obj.infoall();
						
				}
			});
			Clear.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
						displayfield.setText("");
				}
			});
			displayfield.setPrefHeight(250);
			displayfield.setPrefWidth(900);
			mygrid.setVgap(10);
			mygrid.setHgap(10);
			mygrid.setPadding(new Insets(10,10,10,10));
			HBox hb1=new HBox();
			HBox hb2=new HBox();
			HBox hb3=new HBox();
			HBox hb4=new HBox();
			HBox hb7=new HBox();
			HBox hb8=new HBox();
			HBox hb9=new HBox();
			HBox hb10=new HBox();
			HBox hb11=new HBox();
			HBox hb12=new HBox();
			hb1.getChildren().addAll(lab7,idfield1,lab1,namefield1,lab2, classificationfield1,lab3,agefield1,lab18,majorfield1,lab19,gpafield1,lab20,residencefield1);
			hb2.getChildren().add(Add1);
			hb3.getChildren().addAll(lab8,idfield2,lab4,namefield2,lab5, classificationfield2,lab6, agefield2,lab21,majorfield2,lab22,gpafield2,lab23,residencefield2);
			hb4.getChildren().add(Add2);
			hb7.getChildren().addAll(lab10,idfield3);
			hb8.getChildren().add(Remove);
			hb9.getChildren().addAll(lab14,idfield4);
			hb10.getChildren().add(Search);
			hb11.getChildren().addAll(lab13,Showall,Show,Clear);
			hb12.getChildren().add(displayfield);
			mygrid.add(hb1, 0, 0);
			mygrid.add(hb2, 0, 1);
			mygrid.add(hb3, 0, 2);
			mygrid.add(hb4, 0, 3);
			mygrid.add(hb7, 0, 4);
			mygrid.add(hb8, 0, 5);
			mygrid.add(hb9, 0, 6);
			mygrid.add(hb10, 0, 7);
			mygrid.add(hb11, 0, 8);
			mygrid.add(hb12, 0, 9);
			mygrid.setAlignment(Pos.CENTER);
			newscene=new Scene(mygrid);
			window.setTitle("Student Information System");
			window.setScene(newscene);
			window.show();
		}
		public void main(String[]args){
			launch(args);
		}
	}

