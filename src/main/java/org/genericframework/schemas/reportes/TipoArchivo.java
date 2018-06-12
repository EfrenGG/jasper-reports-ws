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
 * <p>Clase Java para tipoArchivo.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoArchivo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TXT"/>
 *     &lt;enumeration value="CSV"/>
 *     &lt;enumeration value="PDF"/>
 *     &lt;enumeration value="XLSX"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoArchivo")
@XmlEnum
public enum TipoArchivo {

    TXT,
    CSV,
    PDF,
    XLSX;

    public String value() {
        return name();
    }

    public static TipoArchivo fromValue(String v) {
        return valueOf(v);
    }

}
