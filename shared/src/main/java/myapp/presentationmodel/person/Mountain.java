package myapp.presentationmodel.person;

import myapp.util.veneer.*;
import org.opendolphin.core.BasePresentationModel;

/**
 * Created by Julien on 14.06.2017.
 */
public class Mountain extends PresentationModelVeneer {
    public Mountain(BasePresentationModel pm) {
        super(pm);
    }

    public final LongAttributeFX mountainId      = new LongAttributeFX(getPresentationModel()   , MountainAtt.MOUNTAIN_ID);
    public final StringAttributeFX mountainName    = new StringAttributeFX(getPresentationModel() ,MountainAtt.MOUNTAIN_NAME);
    public final StringAttributeFX mountainHeight     = new StringAttributeFX(getPresentationModel(), MountainAtt.MOUNTAIN_HEIGHT);
}
