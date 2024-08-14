package hexlet.code;

import lombok.Getter;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Difference<T> {
    private final String typeDiff; //can take values: ?changed?, not-changed, added, removed
    private final List<T> values;   //store value of (key, value) pairs from first json-files
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
