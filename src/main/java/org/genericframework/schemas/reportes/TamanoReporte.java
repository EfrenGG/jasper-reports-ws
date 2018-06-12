//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.06.11 a las 11:18:30 PM CDT 
//


package org.genericframework.schemas.reportes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tamanoReporte.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tamanoReporte">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SM"/>
 *     &lt;enumeration value="MD"/>
 *     &lt;enumeration value="LG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tamanoReporte")
@XmlEnum
public enum TamanoReporte {

    SM,
    MD,
    LG;

    public String value() {
        return name();
    }

    public static TamanoReporte fromValue(String v) {
        return valueOf(v);
    }

}
