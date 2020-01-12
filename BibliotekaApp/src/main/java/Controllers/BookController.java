package Controllers; /**
 * 
 */

import Models.Book;
import DataAccess.LibraryContext;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author mkretkow
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class BookController extends BaseController<Book> {

    public BookController(LibraryContext ctx) {
        super(ctx, Book.class);
    }
}