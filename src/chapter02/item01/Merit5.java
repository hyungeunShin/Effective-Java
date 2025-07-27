package chapter02.item01;

import java.util.ServiceLoader;

//5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
public class Merit5 {
    public interface PaymentService {
        void pay(int amount);
    }

    public static class PaymentServiceFactory {
        public static PaymentService getPaymentService() {
            //나중에 실제 구현체가 로드될 수 있음
            ServiceLoader<PaymentService> loader = ServiceLoader.load(PaymentService.class);
            for(PaymentService service : loader) {
                return service;
            }
            throw new IllegalStateException("No PaymentService implementation found");
        }
    }
}
