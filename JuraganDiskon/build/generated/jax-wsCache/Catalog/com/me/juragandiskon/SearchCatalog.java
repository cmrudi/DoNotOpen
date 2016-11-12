
package com.me.juragandiskon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchCatalog complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchCatalog"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="textSearch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="searchMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchCatalog", propOrder = {
    "textSearch",
    "searchMethod",
    "id"
})
public class SearchCatalog {

    protected String textSearch;
    protected String searchMethod;
    protected int id;

    /**
     * Gets the value of the textSearch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextSearch() {
        return textSearch;
    }

    /**
     * Sets the value of the textSearch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextSearch(String value) {
        this.textSearch = value;
    }

    /**
     * Gets the value of the searchMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchMethod() {
        return searchMethod;
    }

    /**
     * Sets the value of the searchMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchMethod(String value) {
        this.searchMethod = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

}
