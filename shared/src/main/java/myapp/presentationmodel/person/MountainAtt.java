package myapp.presentationmodel.person;

import myapp.presentationmodel.PMDescription;
import myapp.util.AttributeDescription;
import myapp.util.ValueType;

/**
 * Created by Julien on 13.06.2017.
 */
public enum MountainAtt implements AttributeDescription{
    ID(ValueType.ID),
    NAME(ValueType.STRING),
    HEIGHT(ValueType.INT);

    private final ValueType valueType;

    MountainAtt(ValueType type) {
        valueType = type;
    }

    @Override
    public ValueType getValueType() {
        return valueType;
    }

    @Override
    public PMDescription getPMDescription() {
        return PMDescription.Mountain;
    }
    
}
