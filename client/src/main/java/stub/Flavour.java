
package stub;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flavour.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="flavour">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Vanilla"/>
 *     &lt;enumeration value="Cinnamon"/>
 *     &lt;enumeration value="Chili"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "flavour")
@XmlEnum
public enum Flavour {

    @XmlEnumValue("Vanilla")
    VANILLA("Vanilla"),
    @XmlEnumValue("Cinnamon")
    CINNAMON("Cinnamon"),
    @XmlEnumValue("Chili")
    CHILI("Chili");
    private final String value;

    Flavour(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Flavour fromValue(String v) {
        for (Flavour c: Flavour.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
