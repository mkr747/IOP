package Controllers; /**
 * 
 */

import Models.Reader;
import DataAccess.LibraryContext;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author mkretkow
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ReaderController extends BaseController<Reader> {

    public ReaderController(LibraryContext ctx) {
        super(ctx, Reader.class);
    }
}