//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.06 at 12:55:39 PM CEST 
//


package hr.siemens.cvc.labsensors.configuration.sensorConfiguration;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="Sensor" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Name">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Protocal">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Topic">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="QPS">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="MaxQ">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DataElements" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ElementName">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ElementType">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="valid">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                   &lt;minInclusive value="0"/>
 *                                   &lt;maxInclusive value="100"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="invalid">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                                   &lt;minInclusive value="0"/>
 *                                   &lt;maxInclusive value="100"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "sensor"
})
@XmlRootElement(name = "SensorConfiguration")
public class SensorConfiguration {

    @XmlElement(name = "Sensor", required = true)
    protected List<SensorConfiguration.Sensor> sensor;

    /**
     * Gets the value of the sensor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sensor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSensor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SensorConfiguration.Sensor }
     * 
     * 
     */
    public List<SensorConfiguration.Sensor> getSensor() {
        if (sensor == null) {
            sensor = new ArrayList<SensorConfiguration.Sensor>();
        }
        return this.sensor;
    }


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
     *         &lt;element name="Name">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Protocal">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Topic">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="QPS">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="MaxQ">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DataElements" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ElementName">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ElementType">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="valid">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *                         &lt;minInclusive value="0"/>
     *                         &lt;maxInclusive value="100"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="invalid">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *                         &lt;minInclusive value="0"/>
     *                         &lt;maxInclusive value="100"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "name",
        "protocal",
        "topic",
        "qps",
        "maxQ",
        "dataElements"
    })
    public static class Sensor {

        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "Protocal", required = true)
        protected String protocal;
        @XmlElement(name = "Topic", required = true)
        protected String topic;
        @XmlElement(name = "QPS")
        protected int qps;
        @XmlElement(name = "MaxQ")
        protected long maxQ;
        @XmlElement(name = "DataElements", required = true)
        protected List<SensorConfiguration.Sensor.DataElements> dataElements;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the protocal property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProtocal() {
            return protocal;
        }

        /**
         * Sets the value of the protocal property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProtocal(String value) {
            this.protocal = value;
        }

        /**
         * Gets the value of the topic property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTopic() {
            return topic;
        }

        /**
         * Sets the value of the topic property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTopic(String value) {
            this.topic = value;
        }

        /**
         * Gets the value of the qps property.
         * 
         */
        public int getQPS() {
            return qps;
        }

        /**
         * Sets the value of the qps property.
         * 
         */
        public void setQPS(int value) {
            this.qps = value;
        }

        /**
         * Gets the value of the maxQ property.
         * 
         */
        public long getMaxQ() {
            return maxQ;
        }

        /**
         * Sets the value of the maxQ property.
         * 
         */
        public void setMaxQ(long value) {
            this.maxQ = value;
        }

        /**
         * Gets the value of the dataElements property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dataElements property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDataElements().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SensorConfiguration.Sensor.DataElements }
         * 
         * 
         */
        public List<SensorConfiguration.Sensor.DataElements> getDataElements() {
            if (dataElements == null) {
                dataElements = new ArrayList<SensorConfiguration.Sensor.DataElements>();
            }
            return this.dataElements;
        }


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
         *         &lt;element name="ElementName">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ElementType">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="valid">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
         *               &lt;minInclusive value="0"/>
         *               &lt;maxInclusive value="100"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="invalid">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
         *               &lt;minInclusive value="0"/>
         *               &lt;maxInclusive value="100"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
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
            "elementName",
            "elementType",
            "valid",
            "invalid"
        })
        public static class DataElements {

            @XmlElement(name = "ElementName", required = true)
            protected String elementName;
            @XmlElement(name = "ElementType", required = true)
            protected String elementType;
            protected int valid;
            protected int invalid;

            /**
             * Gets the value of the elementName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getElementName() {
                return elementName;
            }

            /**
             * Sets the value of the elementName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setElementName(String value) {
                this.elementName = value;
            }

            /**
             * Gets the value of the elementType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getElementType() {
                return elementType;
            }

            /**
             * Sets the value of the elementType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setElementType(String value) {
                this.elementType = value;
            }

            /**
             * Gets the value of the valid property.
             * 
             */
            public int getValid() {
                return valid;
            }

            /**
             * Sets the value of the valid property.
             * 
             */
            public void setValid(int value) {
                this.valid = value;
            }

            /**
             * Gets the value of the invalid property.
             * 
             */
            public int getInvalid() {
                return invalid;
            }

            /**
             * Sets the value of the invalid property.
             * 
             */
            public void setInvalid(int value) {
                this.invalid = value;
            }

        }

    }

}
