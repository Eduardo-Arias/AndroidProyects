package com.jjsoluciones.examdef;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

/**
 * Created by eduardoarias on 26/04/17.
 */

public class ExamDef implements KvmSerializable {
    private int id;
    private String name;
    private String description;
    private int mininumCorr;
    private int duration;
    private String examTake;
    private String questionDef;

    public ExamDef(int id, String name, String description, int mininumCorr, int duration, String examTake, String questionDef) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mininumCorr = mininumCorr;
        this.duration = duration;
        this.examTake = examTake;
        this.questionDef = questionDef;
    }

    public ExamDef() {
        this(0,"","",0,0,"","");
    }

    @Override
    public Object getProperty(int i) {
        switch (i) {
            case 0:
                return id;
            case 1:
                return name;
            case 2:
                return description;
            case 3:
                return mininumCorr;
            case 4:
                return duration;
            case 5:
                return examTake;
            case 6:
                return questionDef;
        }

        return  null;
    }

    @Override
    public int getPropertyCount() {
        return 7;
    }

    @Override
    public void setProperty(int i, Object o) {
        switch (i){
            case 0:
                id =Integer.parseInt(o.toString());
                break;
            case 1:
                name = o.toString();
                break;
            case 2:
                description = o.toString();
                break;
            case 3:
                mininumCorr = Integer.parseInt(o.toString());
                break;
            case 4:
                duration = Integer.parseInt(o.toString());
                break;
            case 5:
                examTake = o.toString();
                break;
            case 6:
                questionDef = o.toString();
            default:
                break;
        }
    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {
        switch (i) {
            case 0:
                propertyInfo.type = PropertyInfo.INTEGER_CLASS;
                propertyInfo.name = "id";
                break;
            case 1:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "name";
                break;
            case 2:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "description";
                break;
            case 3:
                propertyInfo.type = PropertyInfo.INTEGER_CLASS;
                propertyInfo.name = "mininumCorr";
                break;
            case 4:
                propertyInfo.type = PropertyInfo.INTEGER_CLASS;
                propertyInfo.name = "duration";
                break;
            case 5:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "examTake";
                break;
            case 6:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name = "questionDef";
            default:
                break;
        }
    }
}
