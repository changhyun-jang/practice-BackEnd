package OOP.core.data.movie;

import OOP.core.responsibility.movie.DiscountCondition;
import OOP.core.responsibility.movie.Money;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;
}
