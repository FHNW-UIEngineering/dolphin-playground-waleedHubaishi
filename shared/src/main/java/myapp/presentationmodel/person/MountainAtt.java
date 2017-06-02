package myapp.presentationmodel.person;

import myapp.presentationmodel.PMDescription;
import myapp.util.AttributeDescription;
import myapp.util.ValueType;

/**
 * Created by Hubaishi on 02.06.17.
 */
public enum class MountainAtt implements AttributeDescription {



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
        return PMDescription.PERSON;
    }
}



