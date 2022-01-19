package Projects;
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
public class StudentDataBaseApp extends Application {
		StudentDataBaseApp obj;
		Object com;
		Stage window;
		Scene newscene;
		static GridPane gpagrid;
		static GridPane mygrid;
		static TextField field1;
		static TextField field2;
		static TextField field3;
		static TextField field04;
		static TextField field05;
		static TextField field06;
		static TextField field4;
		static TextField field5;
		static TextField field6;
		static TextField field07;
		static TextField field08;
		static TextField field09;
		static TextField field7;
		static TextField field8;
		static TextField field9;
		static TextField field010;
		static TextField field011;
		static TextField field012;
		static TextField field10;
		static TextField field11;
		static TextField field12;
		static TextField field013;
		static TextField field014;
		static TextField field015;
		static TextArea field16;
		static TextField field14;
		static TextField field15;
		static TextField field17;
		static TextField field13;
		static TextField field18;
		static TextField field19;
		static TextField field20;
		static TextField field21;
		static TextField field22;
		static TextField field23;
		static TextField field016;
		static TextField field017;
		static TextField field018;
		static Button Add1;
		static Button Add2;
		static Button Add3;
		static Button Remove;
		static Button Search;
		static Button Showall;
		static Button Show;
		static Button Clear;
		static Button Save;
		static String studentinfo;
		Node first;
		Node last;
		Node temp;
		int r;
		int e;
		public StudentDataBaseApp(){
			this.e=1;
			this.temp=null;
			this.first=null;
			this.last=null;
			this.r=0;
		}
		public class Node{
			Node next;
			Node previous;
			String name;
			String classification;
			String age;
			String gpa;
			String residence;
			String major;
			public Node(String name,String classification,String age,String major,String gpa,String residence){
				this.next=null;
				this.previous=null;
				this.name=name;
				this.classification=classification;
				this.age=age;
				this.gpa=gpa;
				this.major=major;
				this.residence=residence;
			}
		}
		public void adds(String name,String classification,String age,String major,String gpa,String residence){
			Node newnode=new Node(name,classification,age,major,gpa,residence);
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
		public void adde(String name,String Classification,String age,String major,String gpa,String residence){
			Node newnode=new Node(name,Classification,age,major,gpa,residence);
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
		public void adda(String name,String classification,String age,String major,String gpa,String residence,int e){
			Node newnode=new Node(name,classification,age,major,gpa,residence);
			if(first==null||e==1){
				newnode.next=first;
				first=newnode;
			}else{
				Node nextpresent=first;
				while(e-->1){
					nextpresent=nextpresent.next;
				}
				newnode.next=nextpresent.next;
				nextpresent.next=newnode;
			}
			
		}
		public void search(String randomcharacteristic){
			Node elem=this.first;
			boolean check=false;
	 		int e=1;
				while(elem!=null){
					if(elem.name.contentEquals(randomcharacteristic)||elem.classification.contentEquals(randomcharacteristic)||elem.age.contentEquals(randomcharacteristic)||
							elem.major.contentEquals(randomcharacteristic)||elem.gpa.contentEquals(randomcharacteristic)||elem.residence.contentEquals(randomcharacteristic)){
						check=true;
						studentinfo+="Student Name: "+elem.name+", Classification: "+elem.classification+", Age: "+elem.age+
								", Major: "+elem.major+", GPA: "+elem.gpa+", Residence: "+elem.residence+", Position: "+e+"\n";
						studentinfo.replaceAll("nullStudent","Student");
					}
					e++;
					elem=elem.next;
				}
					if(!check)
						studentinfo="Student not found";
				
		}
		public void remove(String name,String classification,String age,String major,String gpa,String residence){
			Node current=first;
			Node pcurrent=null;
			while(current!=null){
				if(name.equals(current.name)&&classification.equals(current.classification)
						&&age.equals(current.age)&&major.equals(current.major)&&gpa.equals(current.gpa)&&residence.equals(current.residence)){
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
				field16.appendText("Student Name: "+temp.name+", Classification: "+temp.classification+", Age: "+
			temp.age+", Major: "+temp.major+", GPA: "+temp.gpa+", Residence: "+temp.residence+"\n");
				temp=temp.next;
			}
		}
		public void infoall(){
			temp=first;
			while(temp!=null){
				field16.appendText("Student Name: "+temp.name+", Classification: "+temp.classification+", Age: "+
			temp.age+", Major: "+temp.major+", GPA: "+temp.gpa+", Residence: "+temp.residence+"\n");
				temp=temp.next;
			}
		}
		public void infoo(){
			temp=first;
			while(temp!=null){
				System.out.println("Student Name: "+temp.name+", Classification: "+temp.classification+", Age: "+temp.age+"\n");
				temp=temp.next;
			}
		}
		public void start(Stage prime){
			window=prime;
			obj=new StudentDataBaseApp();
			mygrid=new GridPane();
			field1=new TextField();
			field2=new TextField();
			field3=new TextField();
			field4=new TextField();
			field5=new TextField();
			field6=new TextField();
			field7=new TextField();
			field8=new TextField();
			field9=new TextField();
			field10=new TextField();
			field11=new TextField();
			field12=new TextField();
			field14=new TextField();
			field15=new TextField();
			field17=new TextField();
			field18=new TextField();
			field16=new TextArea();
			field04=new TextField();
			field05=new TextField();
			field06=new TextField();
			field07=new TextField();
			field08=new TextField();
			field09=new TextField();
			field010=new TextField();
			field011=new TextField();
			field012=new TextField();
			field013=new TextField();
			field014=new TextField();
			field015=new TextField();
			field016=new TextField();
			field017=new TextField();
			field018=new TextField();
			field16.setEditable(false);
			Label lab1=new Label("Student Name:");
			Label lab2=new Label("Classification:");
			Label lab3=new Label("Age:");
			Label lab4=new Label("Student Name:");
			Label lab5=new Label("Classification:");
			Label lab6=new Label("Age:");
			Label lab7=new Label("Student Name:");
			Label lab8=new Label("Classification:");
			Label lab9=new Label("Age:");
			Label lab10=new Label("Student Name:");
			Label lab11=new Label("Classification:");
			Label lab12=new Label("Age:");
			Label lab14=new Label("Characteristic:");
			Label lab15=new Label("Classification:");
			Label lab16=new Label("Age:");
			Label lab17=new Label("Position in list:");
			Label lab13=new Label("Clear text area when you\nadd new elements to list.");
			Label lab18=new Label("Major: ");
			Label lab19=new Label("GPA: ");
			Label lab20=new Label("Residence: ");
			Label lab21=new Label("Major: ");
			Label lab22=new Label("GPA: ");
			Label lab23=new Label("Residence: ");
			Label lab24=new Label("Major: ");
			Label lab25=new Label("GPA: ");
			Label lab26=new Label("Residence: ");
			Label lab27=new Label("Major: ");
			Label lab28=new Label("GPA: ");
			Label lab29=new Label("Residence: ");
			Label lab30=new Label("Major: ");
			Label lab31=new Label("GPA: ");
			Label lab32=new Label("Residence: ");
			
			Add1=new Button("Add at start");
			Add2=new Button("Add at end");
			Add3=new Button("Add at position");
			Remove=new Button("Remove");
			Search=new Button("Search");
			Show=new Button("Show");
			Showall=new Button("Show all");
			Clear=new Button("Clear");
			field16.setPrefHeight(250);
			field16.setPrefWidth(600);
			Add1.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					obj.adds(field1.getText(), field2.getText(), field3.getText(),
							field04.getText(), field05.getText(), field06.getText());
					
							field1.setText("");
							field2.setText("");
							field3.setText("");
							field04.setText("");
							field05.setText("");
							field06.setText("");
				}
			});
			Add2.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					obj.adde(field4.getText(), field5.getText(), field6.getText(),
							field07.getText(), field08.getText(), field09.getText());
					
							field4.setText("");
							field5.setText("");
							field6.setText("");
							field06.setText("");
							field07.setText("");
							field08.setText("");
							field09.setText("");
				}
			});
			Add3.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					obj.adda(field14.getText(), field15.getText(),field17.getText(),
							field010.getText(), field011.getText(), 
							field012.getText(),Integer.parseInt(field18.getText()));
							field14.setText("");
							field15.setText("");
							field17.setText("");
							field010.setText("");
							field011.setText("");
							field012.setText("");
							field18.setText("");
				}
			});
			Remove.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					obj.remove(field7.getText(), field8.getText(), field9.getText(),
							field013.getText(), field014.getText(), field015.getText());
							field7.setText("");
							field8.setText("");
							field9.setText("");
							field013.setText("");
							field014.setText("");
							field015.setText("");
				}
			});
			Search.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e){
					obj.search(field10.getText());
					field10.setText("");
					field16.setText("");
					field16.setText(studentinfo.replaceAll("nullStudent","Student"));
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
						field16.setText("");
				}
			});
			field16.setPrefHeight(250);
			field16.setPrefWidth(900);
			mygrid.setVgap(10);
			mygrid.setHgap(10);
			mygrid.setPadding(new Insets(10,10,10,10));
			HBox hb1=new HBox();
			HBox hb2=new HBox();
			HBox hb3=new HBox();
			HBox hb4=new HBox();
			HBox hb5=new HBox();
			HBox hb6=new HBox();
			HBox hb7=new HBox();
			HBox hb8=new HBox();
			HBox hb9=new HBox();
			HBox hb10=new HBox();
			HBox hb11=new HBox();
			HBox hb12=new HBox();
			hb1.getChildren().addAll(lab1,field1,lab2, field2,lab3,field3,lab18,field04,lab19,field05,lab20,field06);
			hb2.getChildren().add(Add1);
			hb3.getChildren().addAll(lab4,field4,lab5, field5,lab6, field6,lab21,field07,lab22,field08,lab23,field09);
			hb4.getChildren().add(Add2);
			hb5.getChildren().addAll(lab7,field14,lab8, field15,lab9, field17, lab24,field010,lab25,field011,lab26,field012);
			hb6.getChildren().addAll(lab17,field18,Add3);
			hb7.getChildren().addAll(lab10,field7,lab11, field8,lab12, field9,lab27,field013,lab28,field014,lab29,field015);
			hb8.getChildren().add(Remove);
			hb9.getChildren().addAll(lab14,field10);
			hb10.getChildren().add(Search);
			hb11.getChildren().addAll(lab13,Showall,Show,Clear);
			hb12.getChildren().add(field16);
			mygrid.add(hb1, 0, 0);
			mygrid.add(hb2, 0, 1);
			mygrid.add(hb3, 0, 2);
			mygrid.add(hb4, 0, 3);
			mygrid.add(hb5, 0, 4);
			mygrid.add(hb6, 0, 5);
			mygrid.add(hb7, 0, 6);
			mygrid.add(hb8, 0, 7);
			mygrid.add(hb9, 0, 8);
			mygrid.add(hb10, 0, 9);
			mygrid.add(hb11, 0, 10);
			mygrid.add(hb12, 0, 11);
			mygrid.setAlignment(Pos.CENTER);
			newscene=new Scene(mygrid);
			window.setTitle("Student Information System");
			window.setScene(newscene);
			window.show();
		}
		public static void main(String[]args){
			launch(args);
		}
	}

