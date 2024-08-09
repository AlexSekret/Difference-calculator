package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Difference<T> {
    private String typeDiff; //can take values: ?changed?, not-changed, added, removed
    private T oldValue;   //store value of (key, value) pairs from first json-files
    private T newValue;    //store value of (key, value) pairs from second json-files

    Difference(String typeDiff, T oldValue) {
        this.typeDiff = typeDiff;
        this.oldValue = oldValue;
    }
}
