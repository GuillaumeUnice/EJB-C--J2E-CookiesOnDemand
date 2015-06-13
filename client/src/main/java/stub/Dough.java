
package stub;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dough.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dough">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Plain"/>
 *     &lt;enumeration value="Chocolate"/>
 *     &lt;enumeration value="PeanutButter"/>
 *     &lt;enumeration value="Oatmeal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dough")
@XmlEnum
public enum Dough {

    @XmlEnumValue("Plain")
    PLAIN("Plain"),
    @XmlEnumValue("Chocolate")
    CHOCOLATE("Chocolate"),
    @XmlEnumValue("PeanutButter")
    PEANUT_BUTTER("PeanutButter"),
    @XmlEnumValue("Oatmeal")
    OATMEAL("Oatmeal");
    private final String value;

    Dough(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Dough fromValue(String v) {
        for (Dough c: Dough.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
