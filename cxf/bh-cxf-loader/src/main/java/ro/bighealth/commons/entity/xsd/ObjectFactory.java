
package ro.bighealth.commons.entity.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ro.bighealth.commons.entity.xsd package. 
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

    private final static QName _UserEmail_QNAME = new QName("http://entity.commons.bighealth.ro/xsd", "email");
    private final static QName _UserUsername_QNAME = new QName("http://entity.commons.bighealth.ro/xsd", "username");
    private final static QName _UserPassword_QNAME = new QName("http://entity.commons.bighealth.ro/xsd", "password");
    private final static QName _UserFirstName_QNAME = new QName("http://entity.commons.bighealth.ro/xsd", "firstName");
    private final static QName _UserLastName_QNAME = new QName("http://entity.commons.bighealth.ro/xsd", "lastName");
    private final static QName _UserDoctors_QNAME = new QName("http://entity.commons.bighealth.ro/xsd", "doctors");
    private final static QName _UserPatients_QNAME = new QName("http://entity.commons.bighealth.ro/xsd", "patients");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ro.bighealth.commons.entity.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entity.commons.bighealth.ro/xsd", name = "email", scope = User.class)
    public JAXBElement<String> createUserEmail(String value) {
        return new JAXBElement<String>(_UserEmail_QNAME, String.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entity.commons.bighealth.ro/xsd", name = "username", scope = User.class)
    public JAXBElement<String> createUserUsername(String value) {
        return new JAXBElement<String>(_UserUsername_QNAME, String.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entity.commons.bighealth.ro/xsd", name = "password", scope = User.class)
    public JAXBElement<String> createUserPassword(String value) {
        return new JAXBElement<String>(_UserPassword_QNAME, String.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entity.commons.bighealth.ro/xsd", name = "firstName", scope = User.class)
    public JAXBElement<String> createUserFirstName(String value) {
        return new JAXBElement<String>(_UserFirstName_QNAME, String.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entity.commons.bighealth.ro/xsd", name = "lastName", scope = User.class)
    public JAXBElement<String> createUserLastName(String value) {
        return new JAXBElement<String>(_UserLastName_QNAME, String.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entity.commons.bighealth.ro/xsd", name = "doctors", scope = User.class)
    public JAXBElement<Object> createUserDoctors(Object value) {
        return new JAXBElement<Object>(_UserDoctors_QNAME, Object.class, User.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://entity.commons.bighealth.ro/xsd", name = "patients", scope = User.class)
    public JAXBElement<Object> createUserPatients(Object value) {
        return new JAXBElement<Object>(_UserPatients_QNAME, Object.class, User.class, value);
    }

}
