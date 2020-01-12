package Controllers; /**
 *
 */

import Models.Reservation;
import DataAccess.LibraryContext;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author mkretkow
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ReservationController extends BaseController<Reservation> {
    public ReservationController(LibraryContext ctx) {
        super(ctx, Reservation.class);
    }
}