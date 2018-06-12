//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.06.11 a las 11:18:30 PM CDT 
//


package org.genericframework.schemas.reportes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoCampo.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoCampo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="string"/>
 *     &lt;enumeration value="integer"/>
 *     &lt;enumeration value="bigDecimal"/>
 *     &lt;enumeration value="date"/>
 *     &lt;enumeration value="long"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoCampo")
@XmlEnum
public enum TipoCampo {

    @XmlEnumValue("string")
    STRING("string"),
    @XmlEnumValue("integer")
    INTEGER("integer"),
    @XmlEnumValue("bigDecimal")
    BIG_DECIMAL("bigDecimal"),
    @XmlEnumValue("date")
    DATE("date"),
    @XmlEnumValue("long")
    LONG("long");
    private final String value;

    TipoCampo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoCampo fromValue(String v) {
        for (TipoCampo c: TipoCampo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
