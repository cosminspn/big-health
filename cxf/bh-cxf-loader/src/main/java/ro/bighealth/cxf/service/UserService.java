package ro.bighealth.cxf.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2014-11-03T14:33:10.640+02:00
 * Generated source version: 3.0.2
 * 
 */
@WebServiceClient(name = "UserService", 
                  wsdlLocation = "file:/D:/Workspaces/MyStuff/bighealth-master/cxf/bh-cxf-loader/src/main/resources/wsdl/userCXFService.wsdl",
                  targetNamespace = "http://service.cxf.bighealth.ro/") 
public class UserService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.cxf.bighealth.ro/", "UserService");
    public final static QName UserServicePort = new QName("http://service.cxf.bighealth.ro/", "UserServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/Workspaces/MyStuff/bighealth-master/cxf/bh-cxf-loader/src/main/resources/wsdl/userCXFService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UserService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/D:/Workspaces/MyStuff/bighealth-master/cxf/bh-cxf-loader/src/main/resources/wsdl/userCXFService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public UserService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public UserService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public UserService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public UserService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns UserServicePortType
     */
    @WebEndpoint(name = "UserServicePort")
    public UserServicePortType getUserServicePort() {
        return super.getPort(UserServicePort, UserServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserServicePortType
     */
    @WebEndpoint(name = "UserServicePort")
    public UserServicePortType getUserServicePort(WebServiceFeature... features) {
        return super.getPort(UserServicePort, UserServicePortType.class, features);
    }

}
