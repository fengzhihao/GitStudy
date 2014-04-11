
package com.oneplus.sms.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MongateGetDeliverResult" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/>
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
    "mongateGetDeliverResult"
})
@XmlRootElement(name = "MongateGetDeliverResponse")
public class MongateGetDeliverResponse {

    @XmlElement(name = "MongateGetDeliverResult")
    protected ArrayOfString mongateGetDeliverResult;

    /**
     * Gets the value of the mongateGetDeliverResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getMongateGetDeliverResult() {
        return mongateGetDeliverResult;
    }

    /**
     * Sets the value of the mongateGetDeliverResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setMongateGetDeliverResult(ArrayOfString value) {
        this.mongateGetDeliverResult = value;
    }

}
