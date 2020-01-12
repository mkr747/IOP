package Controllers; /**
 * 
 */

import Models.Rent;
import DataAccess.LibraryContext;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author mkretkow
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class RentController extends BaseController<Rent> {
    public RentController(LibraryContext ctx) {
        super(ctx, Rent.class);
    }
}