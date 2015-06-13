
package stub;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for topping.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="topping">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WhiteChocolate"/>
 *     &lt;enumeration value="MilkChocolate"/>
 *     &lt;enumeration value="MMS"/>
 *     &lt;enumeration value="ReeseButtercup"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "topping")
@XmlEnum
public enum Topping {

    @XmlEnumValue("WhiteChocolate")
    WHITE_CHOCOLATE("WhiteChocolate"),
    @XmlEnumValue("MilkChocolate")
    MILK_CHOCOLATE("MilkChocolate"),
    MMS("MMS"),
    @XmlEnumValue("ReeseButtercup")
    REESE_BUTTERCUP("ReeseButtercup");
    private final String value;

    Topping(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Topping fromValue(String v) {
        for (Topping c: Topping.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
