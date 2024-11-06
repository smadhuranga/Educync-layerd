package lk.edusync.util;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.paint.Paint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static  boolean isTextFieldValied(TextField textField, String text){
        String field = "";
        switch (textField) {
            case ID:
                field = "^([U\\d{3}\n])$";
                break;
            case NIC:
                field = "^([0-9]{9}[x|X|v|V]|[0-9]{12})$";
                break;
            case SID:
                field = "^([S\\d{3}\n])$";
                break;
            case EID:
                field = "^([E\\d{3}\n])$";
                break;
            case EMAIL:
                field = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
                break;
            case NFC:
                field = "^([0-9{3}])$";
                break;
            case SHID:
                field = "^([sh\\d{3}\n])$";
                break;
            case NUMBER:
                field = "^([0-9{10}])$";
                break;

        }
        Pattern pattern = Pattern.compile(field);
        if (text !=null){
            if (text.trim().isEmpty()){
                return false;
            }
        }else{
            return true;
        }
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()){
            return true;}
        return false;

    }
    public static boolean setTextColour(TextField location, JFXTextField field){
        if (Regex.isTextFieldValied(location,field.getText())){
            field.setFocusColor(Paint.valueOf("Blue"));
            field.setUnFocusColor(Paint.valueOf("Red"));
            return true;
        }else {
            field.setFocusColor(Paint.valueOf("Green"));
            field.setUnFocusColor(Paint.valueOf("Red"));
            return false;
        }

    }

}
