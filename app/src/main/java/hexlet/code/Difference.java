package hexlet.code;

import lombok.Getter;


import java.util.ArrayList;
import java.util.List;

@Getter
public class Difference<T> {
    private String typeDiff; //can take values: ?changed?, not-changed, added, removed
    private List<T> values;   //store value of (key, value) pairs from first json-files
//    private T newValue;    //store value of (key, value) pairs from second json-files

    Difference(String typeDiff, T value) {
        var tmp = new ArrayList<T>();
        this.typeDiff = typeDiff;
        tmp.add(value);
        this.values = tmp;
    }

    Difference(String typeDiff, T oldValue, T newValue) {
        var tmp = new ArrayList<T>();
        this.typeDiff = typeDiff;
        tmp.add(oldValue);
        tmp.add(newValue);
        this.values = tmp;
    }
}
