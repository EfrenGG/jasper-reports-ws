//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.06.11 a las 11:18:30 PM CDT 
//


package org.genericframework.schemas.reportes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreReporte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="columnas" type="{http://genericframework.org/schemas/reportes}columnaReporte" maxOccurs="unbounded"/>
 *         &lt;element name="tamanoMargen" type="{http://genericframework.org/schemas/reportes}tamanoReporte"/>
 *         &lt;element name="tamanoFuente" type="{http://genericframework.org/schemas/reportes}tamanoReporte"/>
 *         &lt;element name="horizontal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="tipoArchivo" type="{http://genericframework.org/schemas/reportes}tipoArchivo"/>
 *         &lt;element name="datos" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nombreReporte",
    "columnas",
    "tamanoMargen",
    "tamanoFuente",
    "horizontal",
    "tipoArchivo",
    "datos"
})
@XmlRootElement(name = "generaReporteRequest")
public class GeneraReporteRequest {

    @XmlElement(required = true)
    protected String nombreReporte;
    @XmlElement(required = true)
    protected List<ColumnaReporte> columnas;
    @XmlElement(required = true)
    protected TamanoReporte tamanoMargen;
    @XmlElement(required = true)
    protected TamanoReporte tamanoFuente;
    protected boolean horizontal;
    @XmlElement(required = true)
    protected TipoArchivo tipoArchivo;
    @XmlElement(required = true)
    protected byte[] datos;

    /**
     * Obtiene el valor de la propiedad nombreReporte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreReporte() {
        return nombreReporte;
    }

    /**
     * Define el valor de la propiedad nombreReporte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreReporte(String value) {
        this.nombreReporte = value;
    }

    /**
     * Gets the value of the columnas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the columnas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumnas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColumnaReporte }
     * 
     * 
     */
    public List<ColumnaReporte> getColumnas() {
        if (columnas == null) {
            columnas = new ArrayList<ColumnaReporte>();
        }
        return this.columnas;
    }

    /**
     * Obtiene el valor de la propiedad tamanoMargen.
     * 
     * @return
     *     possible object is
     *     {@link TamanoReporte }
     *     
     */
    public TamanoReporte getTamanoMargen() {
        return tamanoMargen;
    }

    /**
     * Define el valor de la propiedad tamanoMargen.
     * 
     * @param value
     *     allowed object is
     *     {@link TamanoReporte }
     *     
     */
    public void setTamanoMargen(TamanoReporte value) {
        this.tamanoMargen = value;
    }

    /**
     * Obtiene el valor de la propiedad tamanoFuente.
     * 
     * @return
     *     possible object is
     *     {@link TamanoReporte }
     *     
     */
    public TamanoReporte getTamanoFuente() {
        return tamanoFuente;
    }

    /**
     * Define el valor de la propiedad tamanoFuente.
     * 
     * @param value
     *     allowed object is
     *     {@link TamanoReporte }
     *     
     */
    public void setTamanoFuente(TamanoReporte value) {
        this.tamanoFuente = value;
    }

    /**
     * Obtiene el valor de la propiedad horizontal.
     * 
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Define el valor de la propiedad horizontal.
     * 
     */
    public void setHorizontal(boolean value) {
        this.horizontal = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoArchivo.
     * 
     * @return
     *     possible object is
     *     {@link TipoArchivo }
     *     
     */
    public TipoArchivo getTipoArchivo() {
        return tipoArchivo;
    }

    /**
     * Define el valor de la propiedad tipoArchivo.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoArchivo }
     *     
     */
    public void setTipoArchivo(TipoArchivo value) {
        this.tipoArchivo = value;
    }

    /**
     * Obtiene el valor de la propiedad datos.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDatos() {
        return datos;
    }

    /**
     * Define el valor de la propiedad datos.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDatos(byte[] value) {
        this.datos = value;
    }

}
