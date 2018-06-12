//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.06.11 a las 11:18:30 PM CDT 
//


package org.genericframework.schemas.reportes;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para columnaReporte complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="columnaReporte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipo" type="{http://genericframework.org/schemas/reportes}tipoCampo"/>
 *         &lt;element name="tamano" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="orden" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="patron" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="agrupador" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "columnaReporte", propOrder = {
    "titulo",
    "nombre",
    "tipo",
    "tamano",
    "orden",
    "patron",
    "agrupador"
})
public class ColumnaReporte {

    @XmlElement(required = true)
    protected String titulo;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected TipoCampo tipo;
    @XmlElement(required = true)
    protected BigInteger tamano;
    @XmlElement(required = true)
    protected BigInteger orden;
    @XmlElement(required = true)
    protected String patron;
    protected boolean agrupador;

    /**
     * Obtiene el valor de la propiedad titulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define el valor de la propiedad titulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link TipoCampo }
     *     
     */
    public TipoCampo getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCampo }
     *     
     */
    public void setTipo(TipoCampo value) {
        this.tipo = value;
    }

    /**
     * Obtiene el valor de la propiedad tamano.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTamano() {
        return tamano;
    }

    /**
     * Define el valor de la propiedad tamano.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTamano(BigInteger value) {
        this.tamano = value;
    }

    /**
     * Obtiene el valor de la propiedad orden.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrden() {
        return orden;
    }

    /**
     * Define el valor de la propiedad orden.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrden(BigInteger value) {
        this.orden = value;
    }

    /**
     * Obtiene el valor de la propiedad patron.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatron() {
        return patron;
    }

    /**
     * Define el valor de la propiedad patron.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatron(String value) {
        this.patron = value;
    }

    /**
     * Obtiene el valor de la propiedad agrupador.
     * 
     */
    public boolean isAgrupador() {
        return agrupador;
    }

    /**
     * Define el valor de la propiedad agrupador.
     * 
     */
    public void setAgrupador(boolean value) {
        this.agrupador = value;
    }

}
