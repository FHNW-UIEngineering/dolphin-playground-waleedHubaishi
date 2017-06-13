package myapp.presentationmodel.person;

import myapp.util.veneer.BooleanAttributeFX;
import myapp.util.veneer.IntegerAttributeFX;
import myapp.util.veneer.LongAttributeFX;
import myapp.util.veneer.StringAttributeFX;
import org.opendolphin.core.BasePresentationModel;

/**
 * Created by Julien on 13.06.2017.
 */
public class Mountain {
    public Mountain(BasePresentationModel pm) {
        super(pm);
    }

    public final LongAttributeFX id      = new LongAttributeFX(getPresentationModel()   , MountainAtt.ID);
    public final StringAttributeFX name    = new StringAttributeFX(getPresentationModel() , MountainAtt.NAME);
    public final IntegerAttributeFX altutude     = new IntegerAttributeFX(getPresentationModel(), MountainAtt.HEIGHT);
}
