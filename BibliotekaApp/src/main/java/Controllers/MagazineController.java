package Controllers; /**
 * 
 */

import Models.Magazine;
import DataAccess.LibraryContext;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author mkretkow
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class MagazineController extends BaseController<Magazine> {
    public MagazineController(LibraryContext ctx) {
        super(ctx, Magazine.class);
    }
}