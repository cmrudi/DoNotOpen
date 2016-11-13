
package com.me.juragandiskon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getEditingProdInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getEditingProdInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="prod_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEditingProdInfo", propOrder = {
    "prodId"
})
public class GetEditingProdInfo {

    @XmlElement(name = "prod_id")
    protected int prodId;

    /**
     * Gets the value of the prodId property.
     * 
     */
    public int getProdId() {
        return prodId;
    }

    /**
     * Sets the value of the prodId property.
     * 
     */
    public void setProdId(int value) {
        this.prodId = value;
    }

}
