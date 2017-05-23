
package main;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the main package. 
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

    private final static QName _RemoveResponse_QNAME = new QName("http://main/", "removeResponse");
    private final static QName _Update_QNAME = new QName("http://main/", "update");
    private final static QName _Remove_QNAME = new QName("http://main/", "remove");
    private final static QName _UpdateResponse_QNAME = new QName("http://main/", "updateResponse");
    private final static QName _AddCarResponse_QNAME = new QName("http://main/", "addCarResponse");
    private final static QName _AddCar_QNAME = new QName("http://main/", "addCar");
    private final static QName _DisplayCars_QNAME = new QName("http://main/", "displayCars");
    private final static QName _DisplayCarsResponse_QNAME = new QName("http://main/", "displayCarsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: main
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCarResponse }
     * 
     */
    public AddCarResponse createAddCarResponse() {
        return new AddCarResponse();
    }

    /**
     * Create an instance of {@link AddCar }
     * 
     */
    public AddCar createAddCar() {
        return new AddCar();
    }

    /**
     * Create an instance of {@link DisplayCars }
     * 
     */
    public DisplayCars createDisplayCars() {
        return new DisplayCars();
    }

    /**
     * Create an instance of {@link DisplayCarsResponse }
     * 
     */
    public DisplayCarsResponse createDisplayCarsResponse() {
        return new DisplayCarsResponse();
    }

    /**
     * Create an instance of {@link RemoveResponse }
     * 
     */
    public RemoveResponse createRemoveResponse() {
        return new RemoveResponse();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link Car }
     * 
     */
    public Car createCar() {
        return new Car();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://main/", name = "removeResponse")
    public JAXBElement<RemoveResponse> createRemoveResponse(RemoveResponse value) {
        return new JAXBElement<RemoveResponse>(_RemoveResponse_QNAME, RemoveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://main/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://main/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://main/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://main/", name = "addCarResponse")
    public JAXBElement<AddCarResponse> createAddCarResponse(AddCarResponse value) {
        return new JAXBElement<AddCarResponse>(_AddCarResponse_QNAME, AddCarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://main/", name = "addCar")
    public JAXBElement<AddCar> createAddCar(AddCar value) {
        return new JAXBElement<AddCar>(_AddCar_QNAME, AddCar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayCars }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://main/", name = "displayCars")
    public JAXBElement<DisplayCars> createDisplayCars(DisplayCars value) {
        return new JAXBElement<DisplayCars>(_DisplayCars_QNAME, DisplayCars.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayCarsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://main/", name = "displayCarsResponse")
    public JAXBElement<DisplayCarsResponse> createDisplayCarsResponse(DisplayCarsResponse value) {
        return new JAXBElement<DisplayCarsResponse>(_DisplayCarsResponse_QNAME, DisplayCarsResponse.class, null, value);
    }

}
