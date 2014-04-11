
package com.oneplus.sms.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pszMobis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pszMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iMobiCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pszSubPort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "userId",
    "password",
    "pszMobis",
    "pszMsg",
    "iMobiCount",
    "pszSubPort"
})
@XmlRootElement(name = "MongateCsSpSendSmsNew")
public class MongateCsSpSendSmsNew {

    protected String userId;
    protected String password;
    protected String pszMobis;
    protected String pszMsg;
    protected int iMobiCount;
    protected String pszSubPort;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the pszMobis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPszMobis() {
        return pszMobis;
    }

    /**
     * Sets the value of the pszMobis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPszMobis(String value) {
        this.pszMobis = value;
    }

    /**
     * Gets the value of the pszMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPszMsg() {
        return pszMsg;
    }

    /**
     * Sets the value of the pszMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPszMsg(String value) {
        this.pszMsg = value;
    }

    /**
     * Gets the value of the iMobiCount property.
     * 
     */
    public int getIMobiCount() {
        return iMobiCount;
    }

    /**
     * Sets the value of the iMobiCount property.
     * 
     */
    public void setIMobiCount(int value) {
        this.iMobiCount = value;
    }

    /**
     * Gets the value of the pszSubPort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPszSubPort() {
        return pszSubPort;
    }

    /**
     * Sets the value of the pszSubPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPszSubPort(String value) {
        this.pszSubPort = value;
    }

}
