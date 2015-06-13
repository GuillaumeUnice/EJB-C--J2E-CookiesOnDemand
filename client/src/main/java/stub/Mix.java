
package stub;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mix.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="mix">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Mixed"/>
 *     &lt;enumeration value="Topped"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "mix")
@XmlEnum
public enum Mix {

    @XmlEnumValue("Mixed")
    MIXED("Mixed"),
    @XmlEnumValue("Topped")
    TOPPED("Topped");
    private final String value;

    Mix(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Mix fromValue(String v) {
        for (Mix c: Mix.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
