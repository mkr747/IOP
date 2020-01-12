package Controllers; /**
 * 
 */

import Models.Librarian;
import DataAccess.LibraryContext;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author mkretkow
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class LibrarianController extends BaseController<Librarian> {

    public LibrarianController(LibraryContext ctx) {
        super(ctx, Librarian.class);
    }
}