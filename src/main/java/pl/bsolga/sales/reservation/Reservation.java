package pl.bsolga.sales.reservation;

import pl.bsolga.sales.CustomerData;
import pl.bsolga.sales.payment.PaymentGateway;
import pl.bsolga.sales.payment.RegisterPaymentRequest;
import pl.bsolga.sales.payment.RegisterPaymentResponse;

import java.math.BigDecimal;

public class Reservation {
    private final String id;
    private final BigDecimal totalAmount;
    private final String fname;
    private final String lname;
    private final String email;
    private String paymentId;
    private String paymentUrl;

    public Reservation(String id, BigDecimal totalAmount, String fname, String lname, String email) {

        this.id = id;
        this.totalAmount = totalAmount;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public static Reservation of(String reservationId, BigDecimal totalAmount, CustomerData customerData) {
        return new Reservation(reservationId, totalAmount, customerData.getFname(), customerData.getLname(), customerData.getEmail());
    }

    public void registerPayment(PaymentGateway paymentGateway) {
        RegisterPaymentResponse registerPaymentResponse = paymentGateway.register(new RegisterPaymentRequest(
                id,
                totalAmount,
                fname,
                lname,
                email
        ));

        this.paymentId = registerPaymentResponse.getPaymentId();
        this.paymentUrl = registerPaymentResponse.getPaymentUrl();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getTotal() {
        return totalAmount;
    }
}
