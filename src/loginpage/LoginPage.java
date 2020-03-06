/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    String x, cheack ;
    boolean found ;
     GridPane all ;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, NoSuchAlgorithmException {
        Label welcomL = new Label("Welcome");
        welcomL.setStyle(" -fx-font-size:18px ; -fx-text-fill: #434e52 ;");
        welcomL.setAlignment(Pos.TOP_LEFT);
        
        Label userL = new Label("User Name");
        TextField userTF = new TextField();
        userTF.setPromptText("Your name");

        HBox userBox = new HBox( 10 ,userL , userTF);
        userBox.setAlignment(Pos.CENTER_LEFT);
        
        Label passL = new Label("Password  ");
        PasswordField passTF = new PasswordField();
        passTF.setPromptText("Your password");

        HBox passBox = new HBox(10 ,passL , passTF);
        passBox.setAlignment(Pos.CENTER_LEFT);
        
        Button sgininB = new Button("Sgin In");
        sgininB.setStyle("-fx-background-color : #434e52; -fx-text-fill: #b0a160;");
        Button exitB = new Button("Exit");
        exitB.setStyle("-fx-background-color : #434e52;-fx-text-fill: #b0a160;");
        
        exitB.setOnAction(s -> {
        primaryStage.close();
        });
        
        HBox butons = new HBox(10 , sgininB , exitB);
        butons.setAlignment(Pos.CENTER_RIGHT);
        Label checkL = new Label ();

        File file = new File("user.txt");
        PrintWriter output = new PrintWriter(file);
        output.println("Ahamd "+hash("123456"));
        output.println("marwa "+hash("199167"));
        output.println("soso "+hash("761485"));
        output.println("Momen "+hash("761485"));
        output.println("Hany "+hash("761485"));
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
          VBox dd = new VBox(10 , addS , viewS);
          dd.setAlignment(Pos.CENTER);
          dd.setStyle("-fx-background-color : #5b8c85 ;");
          
          sgininB.setOnAction(e -> {
          x = userTF.getText()+" "+hash(passTF.getText());
         if(check(file, x)){
         scene.setRoot(dd);
         }else{
          passTF.clear();
        userTF.clear();
        x = null;
           checkL.setText("Username or password is not correct");
         }
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
    public String hash( String pass){
        
     String passwordToHash = pass;
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return generatedPassword ;
    }
    public boolean check (File x , String s  ){
        try {
            Scanner input = new Scanner(x);
            
            
            found = false ;
            String get =  s ;
            while(input.hasNext()){
                cheack = input.nextLine();
                if(get.equals(cheack)){
                    found = true ;
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
