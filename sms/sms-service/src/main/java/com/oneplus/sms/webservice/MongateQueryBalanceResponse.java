
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
 *         &lt;element name="MongateQueryBalanceResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "mongateQueryBalanceResult"
})
@XmlRootElement(name = "MongateQueryBalanceResponse")
public class MongateQueryBalanceResponse {

    @XmlElement(name = "MongateQueryBalanceResult")
    protected int mongateQueryBalanceResult;

    /**
     * Gets the value of the mongateQueryBalanceResult property.
     * 
     */
    public int getMongateQueryBalanceResult() {
        return mongateQueryBalanceResult;
    }

    /**
     * Sets the value of the mongateQueryBalanceResult property.
     * 
     */
    public void setMongateQueryBalanceResult(int value) {
        this.mongateQueryBalanceResult = value;
    }

}
