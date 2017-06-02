package myapp;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;


/**
 * Created by Hubaishi on 08/12/15.
 */
public class CenterData extends GridPane {

    Text mountainName;
    Text heightOfMountain;
    Text gebietOfMountain;

    Image mountainImageName;
    TextField nameField;
    Text dominanzLbl;
    TextField dominanzField;
    Text KmBisLbl;
    TextField KmBisField;
    Text TypLbl;
    TextField typField;
    Text kantonLbl;
    TextField kantonField;
    Text bildunterschreibungLbl;
    TextField bildunterschreibungField;
    Text heightLbl;
    TextField heightField;
    Text schratenLbl;
    TextField schratenField;
    Text schratenPunktLbl;
    TextField schratenPunktField;
    Text regionLbl;
    TextField regionField;
    Text gebietLbl;
    TextField gebietField;
    Text nameLbl;


    ImageView mountainImg;

    final Circle clip = new Circle(80, 80, 80);

    GridPane grid = new GridPane();


    public CenterData()
    {
        getStyleClass().add("border");
        grid.setMaxHeight(Double.MAX_VALUE);
        grid.setMaxWidth(Double.MAX_VALUE);
        grid.setStyle("-fx-border-color: lightgray;");




    }

    public void processKeyEvent(KeyEvent ev) {
        String c = ev.getCharacter();
        if("1234567890".contains(c)) {}
        else {
            ev.consume();
        }
    }


    public void fillData()
    {

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        // grid.setPadding(new Insets(top,right,bottom,left));

        //grid.getStyleClass().add("border");


        mountainName = new Text("Aletschhorn");
        mountainName.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(mountainName, 0, 0,2,1);

        heightOfMountain = new Text();
        heightOfMountain.setFont(Font.font("Arial", FontWeight.LIGHT, 15));
        grid.add(heightOfMountain, 0, 2,2,1);



        gebietOfMountain = new Text();
        gebietOfMountain.setFont(Font.font("Arial", FontWeight.LIGHT, 15));
        grid.add(gebietOfMountain, 0, 4,4,1);



        mountainImageName = new Image("Photos/0-1.jpg");


        mountainImg = new ImageView();
        mountainImg.setClip(clip);

        mountainImg.setImage(mountainImageName);


        mountainImg.setFitHeight(160.0);
        mountainImg.setFitWidth(160.0);


        grid.add(mountainImg, 8,0,2,5);

        nameLbl = new Text("Name");
        nameLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(nameLbl, 0, 7, 1,1 );



        nameField = new TextField("Aletschhorn");
        nameField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(nameField, 1, 7,4,1);
        nameField.setMaxWidth(Double.MAX_VALUE);
        nameField.setMaxHeight(Double.MAX_VALUE);


        dominanzLbl = new Text("Dominanz");
        dominanzLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(dominanzLbl, 0, 8,1,1);

        dominanzField = new TextField(){
            @Override public void replaceText(int start, int end, String text) {
                // If the replaced text would end up being invalid, then simply
                // ignore this call!
                if (!text.matches("[a-z]")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override public void replaceSelection(String text) {
                if (!text.matches("[a-z]")) {
                    super.replaceSelection(text);
                }
            }
        };

        dominanzField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(dominanzField, 1, 8,4,1);

        KmBisLbl = new Text("KmBisLbl");
        KmBisLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(KmBisLbl, 0, 9,1,1);

        KmBisField = new TextField("Finsteraarhorn");
        KmBisField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(KmBisField, 1, 9,4,1);

        TypLbl = new Text("Typ");
        TypLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(TypLbl, 0, 10,1,1);

        typField = new TextField("Hauptgipfel");
        typField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(typField, 1, 10,4,1);

        kantonLbl = new Text("Kanton");
        kantonLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(kantonLbl, 0, 11,1,1);

        kantonField = new TextField("Kanton");
        kantonField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(kantonField, 1, 11,4,1);

        bildunterschreibungLbl = new Text("Bildunterschreibung");
        bildunterschreibungLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(bildunterschreibungLbl, 0, 12,1,1);

        bildunterschreibungField = new TextField("Aletschhorn von Süden");
        bildunterschreibungField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(bildunterschreibungField, 1, 12, 10, 1);

        heightLbl = new Text("Höhe (m)");
        heightLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(heightLbl, 7, 7,1,1);

        heightField = new TextField(){
            @Override public void replaceText(int start, int end, String text) {
                // If the replaced text would end up being invalid, then simply
                // ignore this call!
                if (!text.matches("[a-z]")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override public void replaceSelection(String text) {
                if (!text.matches("[a-z]")) {
                    super.replaceSelection(text);
                }
            }
        };
        heightField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(heightField, 8, 7,3,1);



        schratenLbl = new Text("scharten");
        schratenLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(schratenLbl, 7, 8,1,1);

        schratenField = new TextField(){
            @Override public void replaceText(int start, int end, String text) {
                // If the replaced text would end up being invalid, then simply
                // ignore this call!
                if (!text.matches("[a-z]")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override public void replaceSelection(String text) {
                if (!text.matches("[a-z]")) {
                    super.replaceSelection(text);
                }
            }
        };

        schratenField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(schratenField, 8, 8,3,1);

        schratenPunktLbl = new Text("Schartenpunkt");
        schratenPunktLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(schratenPunktLbl, 7, 9,1,1);

        schratenPunktField = new TextField("Lötschenlücke");
        schratenPunktField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(schratenPunktField, 8, 9,3,1);

        regionLbl = new Text("Region");
        regionLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(regionLbl, 7, 10,1,1);

        regionField = new TextField("etwas field");
        regionField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(regionField, 8, 10,3,1);

        gebietLbl = new Text("Gebiet");
        gebietLbl.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(gebietLbl, 7, 11,1,1);

        gebietField = new TextField("Aletschgebiet");
        gebietField.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        grid.add(gebietField, 8, 11,3,1);

    }




}





