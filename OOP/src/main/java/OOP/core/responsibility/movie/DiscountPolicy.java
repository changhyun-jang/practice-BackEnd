package OOP.core.responsibility.movie;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
