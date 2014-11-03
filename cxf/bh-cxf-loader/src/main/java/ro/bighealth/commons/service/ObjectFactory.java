
package ro.bighealth.commons.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ro.bighealth.commons.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindByEmailEmail_QNAME = new QName("http://service.commons.bighealth.ro", "email");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ro.bighealth.commons.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindByEmailResponse }
     * 
     */
    public FindByEmailResponse createFindByEmailResponse() {
        return new FindByEmailResponse();
    }

    /**
     * Create an instance of {@link FindByEmail }
     * 
     */
    public FindByEmail createFindByEmail() {
        return new FindByEmail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.commons.bighealth.ro", name = "email", scope = FindByEmail.class)
    public JAXBElement<String> createFindByEmailEmail(String value) {
        return new JAXBElement<String>(_FindByEmailEmail_QNAME, String.class, FindByEmail.class, value);
    }

}
