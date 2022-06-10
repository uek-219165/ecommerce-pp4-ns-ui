package pl.bsolga.sales.payment;

public interface PaymentGateway {
    RegisterPaymentResponse register(RegisterPaymentRequest registerPaymentRequest);
}
