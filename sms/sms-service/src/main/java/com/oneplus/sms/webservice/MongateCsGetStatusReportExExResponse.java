
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
 *         &lt;element name="MongateCsGetStatusReportExExResult" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/>
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
    "mongateCsGetStatusReportExExResult"
})
@XmlRootElement(name = "MongateCsGetStatusReportExExResponse")
public class MongateCsGetStatusReportExExResponse {

    @XmlElement(name = "MongateCsGetStatusReportExExResult")
    protected ArrayOfString mongateCsGetStatusReportExExResult;

    /**
     * Gets the value of the mongateCsGetStatusReportExExResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getMongateCsGetStatusReportExExResult() {
        return mongateCsGetStatusReportExExResult;
    }

    /**
     * Sets the value of the mongateCsGetStatusReportExExResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setMongateCsGetStatusReportExExResult(ArrayOfString value) {
        this.mongateCsGetStatusReportExExResult = value;
    }

}
