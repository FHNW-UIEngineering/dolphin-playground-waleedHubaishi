package myapp.presentationmodel.person;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringAttributeFX;
import javafx.beans.property.StringAttributeFX;
import myapp.util.veneer.LongAttributeFX;
import myapp.util.veneer.PresentationModelVeneer;
import myapp.util.veneer.StringAttributeFX;

/**
 * Created by Hubaishi on 02.06.17.
 */
public class Mountain extends PresentationModelVeneer {


    private final IntegerProperty selectedMountainId = new SimpleIntegerProperty(-1);


    private final LongAttributeFX mountainID      = new LongAttributeFX(getPresentationModel()   ,);
    private final StringAttributeFX mountainName   = new  StringAttributeFX(getPresentationModel()   ,);
    private final StringAttributeFX  height          = new StringAttributeFX(getPresentationModel()   ,);
    private final StringAttributeFX  gipfel             = new StringAttributeFX(getPresentationModel()   ,);
    private final StringAttributeFX  ort             = new StringAttributeFX(getPresentationModel()   ,);
    private final StringAttributeFX  kanton             = new StringAttributeFX(getPresentationModel()   ,);
    private final StringAttributeFX  bergkette             = new StringAttributeFX(getPresentationModel()   ,);


}
