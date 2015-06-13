
package stub;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cooking.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="cooking">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Crunchy"/>
 *     &lt;enumeration value="Chewy"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "cooking")
@XmlEnum
public enum Cooking {

    @XmlEnumValue("Crunchy")
    CRUNCHY("Crunchy"),
    @XmlEnumValue("Chewy")
    CHEWY("Chewy");
    private final String value;

    Cooking(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Cooking fromValue(String v) {
        for (Cooking c: Cooking.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
