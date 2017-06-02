package myapp;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.application.Platform;


/**
 * Created by Hubaishi on 28/12/15.
 */

public class LeftTable extends VBox  {

    static TableView<Mountains> tableView;

    public static  WahlPM model;

    public static int selectedMountainID = 0 ;

    public static CenterData centerData = new CenterData();

    public static Label countLbl = new Label();

    public LeftTable(WahlPM model) {
        this.model = model;
    }

    public static Mountains oldSelection;
    public static Mountains newSelection;

    public TableView<Mountains> initializeTable(ObservableList<Mountains> list) {

        tableView = new TableView<>(list);

        TableColumn<Mountains, Number> IDcol   = new TableColumn<>("ID");
        TableColumn<Mountains, String> mountainNameCol          = new TableColumn<>("Mountain Name");
        TableColumn<Mountains, String> heightCol = new TableColumn<>("Height");


        IDcol.setCellValueFactory(cell -> cell.getValue().IDProperty());



        mountainNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        mountainNameCol.setCellValueFactory(cell -> cell.getValue().mountainNameProperty());

        heightCol.setCellFactory(TextFieldTableCell.forTableColumn());
        heightCol.setCellValueFactory(cell -> cell.getValue().heightProperty());

        IDcol.getStyleClass().add("foo");
        IDcol.getStyleClass().add("yoo");


        mountainNameCol.getStyleClass().add("foo");
        mountainNameCol.getStyleClass().add("yoo");


        heightCol.getStyleClass().add("foo");
        heightCol.getStyleClass().add("yoo");


        tableView.setId("lightHighlightTable");


        tableView.setStyle("-fx-table-cell-border-color: transparent");


        tableView.getColumns().addAll(IDcol, mountainNameCol, heightCol);


        if (oldSelection == null)
        {

            Platform.runLater(new Runnable()
            {
                @Override
                public void run()
                {
                    tableView.getSelectionModel().selectFirst();
                    newSelection = tableView.getSelectionModel().getSelectedItem();
                }
            });

        }


        tableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            //Check whether item is selected and set value of selected item to Label

            selectedMountainID = newValue.getID();

            oldSelection = oldValue;
            newSelection = newValue;

            countLbl.setText(String.valueOf(newSelection.getID()+1)+"/"+model.getResulate().size());


            if (oldSelection != null) {



                centerData.mountainName.textProperty().unbindBidirectional(oldSelection.mountainNameProperty());
                centerData.heightField.textProperty().unbindBidirectional(oldSelection.heightProperty());
                centerData.gebietOfMountain.textProperty().unbindBidirectional(oldSelection.bergketteProperty());
                if(oldSelection.kantonProperty().getValue() != null || oldSelection.getID() > 26 || oldSelection.getID() == 0) {
                    centerData.kantonField.textProperty().unbindBidirectional(oldSelection.kantonProperty());
                }
                else if(oldSelection.kantonProperty().getValue() == null)
                {

                    centerData.kantonField.textProperty().unbindBidirectional(oldSelection.kantonProperty());
                }
                centerData.heightOfMountain.textProperty().unbindBidirectional(oldSelection.heightProperty());
                centerData.nameField.textProperty().unbindBidirectional(oldSelection.mountainNameProperty());
                centerData.KmBisField.textProperty().unbindBidirectional(oldSelection.mountain1Property());
                centerData.typField.textProperty().unbindBidirectional(oldSelection.gipfelProperty());
                centerData.schratenField.textProperty().unbindBidirectional(oldSelection.num2Property());
                centerData.schratenPunktField.textProperty().unbindBidirectional(oldSelection.besch1Property());
                centerData.regionField.textProperty().unbindBidirectional(oldSelection.ortProperty());
                centerData.dominanzField.textProperty().unbindBidirectional(oldSelection.num1Property());
                centerData.gebietField.textProperty().unbindBidirectional(oldSelection.bergketteProperty());
                centerData.bildunterschreibungField.textProperty().unbindBidirectional(oldSelection.besch2Property());

            }


            if (newSelection != null) {

                selectedMountainID = newSelection.getID();

                centerData.mountainName.textProperty().bindBidirectional(newSelection.mountainNameProperty());
                centerData.heightOfMountain.textProperty().bindBidirectional(newSelection.heightProperty());
                centerData.gebietOfMountain.textProperty().bindBidirectional(newSelection.bergketteProperty());
                if(newSelection.kantonProperty().getValue() != null || newSelection.getID() > 26 || newSelection.getID() == 0) {
                    centerData.kantonField.textProperty().bindBidirectional(newSelection.kantonProperty());
                }
                else if(newSelection.kantonProperty().getValue() == null)
                {
                    Canton can = model.getKanton(newSelection.getID());
                    newSelection.setKanton(can.kantonNameProperty().getValue());
                    centerData.kantonField.textProperty().bindBidirectional(newSelection.kantonProperty());
                }

                centerData.heightField.textProperty().bindBidirectional(newSelection.heightProperty());
                centerData.nameField.textProperty().bindBidirectional(newSelection.mountainNameProperty());
                centerData.KmBisField.textProperty().bindBidirectional(newSelection.mountain1Property());
                centerData.typField.textProperty().bindBidirectional(newSelection.gipfelProperty());
                centerData.schratenField.textProperty().bindBidirectional(newSelection.num2Property());
                centerData.schratenPunktField.textProperty().bindBidirectional(newSelection.besch1Property());
                centerData.regionField.textProperty().bindBidirectional(newSelection.ortProperty());
                centerData.dominanzField.textProperty().bindBidirectional(newSelection.num1Property());
                centerData.gebietField.textProperty().bindBidirectional(newSelection.bergketteProperty());
                centerData.bildunterschreibungField.textProperty().bindBidirectional(newSelection.besch2Property());

                int id = newSelection.getID();
                String imageName = "/Photos/"+String.valueOf(id) + "-1.jpg";



                if(model.createdItems.isEmpty() == false ) {
                    for(int i=0;i<model.createdItems.size();i++)
                    {
                        if(model.createdItems.get(i).getID() == id )
                        {
                            imageName = "/Photos/image_not_avalible.png";
                            break;
                        }
                    }
                }

                if(newSelection.getID() > 231)
                {
                    imageName = "/Photos/image_not_avalible.png";

                }


                Image image = new Image(String.valueOf(this.getClass().getResource(imageName)));
                centerData.mountainImg.setImage((image));

            }



            if (tableView.getSelectionModel().getSelectedItem() != null) {


            }


        });

        tableView.setStyle("-fx-box-border: white;");
        return tableView;
    }



}
