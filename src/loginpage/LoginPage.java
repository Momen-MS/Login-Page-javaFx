/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

/**
 *
 * @author MOMEN
 */
public class LoginPage extends Application {

    String x, cheack;
    boolean found;
    GridPane all, inputSD;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, NoSuchAlgorithmException {
        Label welcomL = new Label("Welcome");
        welcomL.setStyle(" -fx-font-size:18px ; -fx-text-fill: #434e52 ;");
        welcomL.setAlignment(Pos.TOP_LEFT);

        Label userL = new Label("User Name");
        TextField userTF = new TextField();
        userTF.setPromptText("Your name");

        HBox userBox = new HBox(10, userL, userTF);
        userBox.setAlignment(Pos.CENTER_LEFT);

        Label passL = new Label("Password  ");
        PasswordField passTF = new PasswordField();
        passTF.setPromptText("Your password");

        HBox passBox = new HBox(10, passL, passTF);
        passBox.setAlignment(Pos.CENTER_LEFT);

        Button sgininB = new Button("Sgin In");
        sgininB.setStyle("-fx-background-color : #434e52; -fx-text-fill: #b0a160;");
        Button exitB = new Button("Exit");
        exitB.setStyle("-fx-background-color : #434e52;-fx-text-fill: #b0a160;");

        exitB.setOnAction(s -> {
            primaryStage.close();
        });

        HBox butons = new HBox(10, sgininB, exitB);
        butons.setAlignment(Pos.CENTER_RIGHT);
        Label checkL = new Label();

        File file = new File("user.txt");
        PrintWriter output = new PrintWriter(file);
        output.println("Ahamd " + hash("123456"));
        output.println("marwa " + hash("199167"));
        output.println("soso " + hash("761485"));
        output.println("Momen " + hash("761485"));
        output.println("Hany " + hash("761485"));
        output.close();

        checkL.setAlignment(Pos.BOTTOM_RIGHT);
        all = new GridPane();
        all.add(welcomL, 0, 1);
        all.add(userBox, 0, 2);
        all.add(passBox, 0, 3);
        all.add(butons, 0, 4);
        all.add(checkL, 0, 5);
        all.setAlignment(Pos.CENTER);
        all.setVgap(20);
        all.setHgap(15);
        all.setStyle("-fx-background-color : #5b8c85 ; ");
        all.setPadding(new Insets(10));

        Scene scene = new Scene(all, 250, 250);

        //page2
        Button addS = new Button("Add Student");
        addS.setStyle("-fx-background-color : #434e52;-fx-text-fill: #b0a160;");
        Button viewS = new Button("View Student");
        viewS.setStyle("-fx-background-color : #434e52;-fx-text-fill: #b0a160;");
        VBox dd = new VBox(10, addS, viewS);
        dd.setAlignment(Pos.CENTER);
        dd.setStyle("-fx-background-color : #5b8c85 ;");

        sgininB.setOnAction(e -> {
            x = userTF.getText() + " " + hash(passTF.getText());
            if (check(file, x)) {
                scene.setRoot(dd);
                primaryStage.setTitle("Options");
            } else {
                passTF.clear();
                userTF.clear();
                x = null;
                checkL.setText("Username or password is not correct");
            }
        });

        //add student page
        Label studD = new Label("Student Data");
        studD.setStyle(" -fx-font-size:22px ; -fx-text-fill: #434e52 ;");
        HBox titleB = new HBox(studD);
//        titleB.setMaxWidth(650);
        titleB.setAlignment(Pos.TOP_LEFT);
//        titleB.setPadding(new Insets(10));

        Label idL = new Label("id :");
        TextField idTF = new TextField();

        Label nameL = new Label("Name :");
        TextField nameTF = new TextField();

        Label majerL = new Label("Majer :");
        TextField majerTF = new TextField();

        Label gradeL = new Label("Grade :");
        TextField gradeTF = new TextField();

        Button AddB = new Button("Add");
        AddB.setStyle("-fx-background-color : #434e52;-fx-text-fill: #b0a160;");
        Button resetB = new Button("Reset");
        resetB.setStyle("-fx-background-color : #434e52;-fx-text-fill: #b0a160;");
        Button exitBb = new Button("Exit");
        exitBb.setStyle("-fx-background-color : #434e52;-fx-text-fill: #b0a160;");

        HBox Buttons1 = new HBox(8, AddB, resetB, exitBb);
        Buttons1.setAlignment(Pos.CENTER_RIGHT);

        ArrayList<Student> StudentList = new ArrayList<Student>();

        ListView<String> list1 = new ListView<>();
        VBox viewB = new VBox(10, list1);
        viewB.setMaxHeight(320);
        viewB.setMaxWidth(360);
        viewB.setAlignment(Pos.TOP_CENTER);
        viewB.setPadding(new Insets(10));

        Label mass = new Label("");

        inputSD = new GridPane();
        inputSD.add(idL, 0, 1);
        inputSD.add(idTF, 1, 1);
        inputSD.add(nameL, 0, 2);
        inputSD.add(nameTF, 1, 2);
        inputSD.add(majerL, 0, 3);
        inputSD.add(majerTF, 1, 3);
        inputSD.add(gradeL, 0, 4);
        inputSD.add(gradeTF, 1, 4);
        inputSD.add(Buttons1, 1, 5);
        inputSD.add(mass, 1, 6);
        inputSD.setAlignment(Pos.CENTER);
        inputSD.setVgap(10);
        inputSD.setHgap(10);
        inputSD.setStyle("-fx-background-color : #5b8c85 ; ");
        inputSD.setMaxHeight(350);
        inputSD.setMaxWidth(320);
        inputSD.setAlignment(Pos.TOP_CENTER);


           GridPane c = new GridPane();
           c.add(titleB, 0, 1);
           c.add(inputSD, 0, 2);
           c.add(viewB, 1, 2);
           c.setStyle("-fx-background-color : #5b8c85 ;");
        c.setPadding(new Insets(7));
        c.setAlignment(Pos.CENTER);
        Scene addStudent = new Scene(c, 570, 550);

        addS.setOnAction(f -> {
            primaryStage.setTitle("Student Entry Page");
            primaryStage.setScene(addStudent);
        });
        
        
        
        
        
        AddB.setOnAction(r -> {
            if (idTF.getText().equals("") || nameTF.getText().equals("") || majerTF.getText().equals("") || gradeTF.getText().equals("")) {
                mass.setText("Pleas check your inputs");
            } else {
                boolean found = false;
                for (int i = 0; i < StudentList.size(); i++) {
                    if (StudentList.get(i).getId() == Integer.parseInt(idTF.getText())) {
                        found = true;
                        mass.setText("the student is allordy exsit");
                    }
                }
                if (!found) {
                    int id = Integer.parseInt(idTF.getText());
                    double grade = Double.parseDouble(gradeTF.getText());
                    Student newStudent = new Student(id, nameTF.getText(), majerTF.getText(), grade);
                    StudentList.add(newStudent);
                    StudentList.sort(Comparator.comparing(Student::getGrade).reversed());
                    
//                       Collections.sort(StudentList, new Comparator<Student>() {
//                        @Override
//                        public int compare(Student o1, Student o2) {
//                            return Double.compare(o1.getGrade() , o2.getGrade());
//                        }
//                    });

                    list1.getItems().clear();
                    for (int i = 0; i <StudentList.size() ; i++) {
                    list1.getItems().add(" "+StudentList.get(i).getId() + "     "+ StudentList.get(i).getName()+"      " + StudentList.get(i).getMajer()+"      " + StudentList.get(i).getGrade());
                    }
                    idTF.setText("");
                    nameTF.setText("");
                    majerTF.setText("");
                    gradeTF.setText("");
                    mass.setText("Add succssfully");
                }
            }
        });
        
        resetB.setOnAction(v -> {
            if (idTF.getText().equals("") || nameTF.getText().equals("") || majerTF.getText().equals("") || gradeTF.getText().equals("")) {
                mass.setText("the inputs can't be empty");
            } else {
                boolean found = false;
                int index = 0 ;
                for (int i = 0; i < StudentList.size(); i++) {
                    if (StudentList.get(i).getId() == Integer.parseInt(idTF.getText()) ) {
                        found = true;
                         index = i ;
                        break;
                    }
                }
                if (found) {
                    double grade = Double.parseDouble(gradeTF.getText());
                    StudentList.get(index).setName(nameTF.getText());
                    StudentList.get(index).setMajer(majerTF.getText());
                    StudentList.get(index).setGrade(grade);
                    StudentList.sort(Comparator.comparing(Student::getGrade).reversed());
//                    Collections.sort(StudentList, new Comparator<Student>() {
//                        @Override
//                        public int compare(Student o1, Student o2) {
//                            return Double.compare(o1.getGrade() , o2.getGrade());
//                        }
//                    });
                    list1.getItems().clear();
                    for (int i = 0; i <StudentList.size() ; i++) {
                    list1.getItems().add(StudentList.get(i).getId() + "    " + StudentList.get(i).getName() + "         " + StudentList.get(i).getMajer() + "       " + StudentList.get(i).getGrade() + "   ");
                    }
                    
                    idTF.setText("");
                    nameTF.setText("");
                    majerTF.setText("");
                    gradeTF.setText("");
                    mass.setText("Edit done succssfully");
                }else{
                mass.setText("there is no student with this id");
                }
            }

        });
        
        
        
        
        exitBb.setOnAction(v -> {
            primaryStage.close();
        });

        primaryStage.setTitle("Login page ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public String hash(String pass) {

        String passwordToHash = pass;
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public boolean check(File x, String s) {
        try {
            Scanner input = new Scanner(x);

            found = false;
            String get = s;
            while (input.hasNext()) {
                cheack = input.nextLine();
                if (get.equals(cheack)) {
                    found = true;
                    input.close();
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return found;
    }

}
