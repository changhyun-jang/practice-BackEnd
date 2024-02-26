package OOP.core.data.movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;

    private int sequence;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountConditionType getType() {
        return type;
    }
//
//    public int getSequence() {
//        return sequence;
//    }
//
//    public DayOfWeek getDayOfWeek() {
//        return dayOfWeek;
//    }
//
//    public LocalTime getStartTime() {
//        return startTime;
//    }
//
//    public LocalTime getEndTime() {
//        return endTime;
//    }

    //책임 갖게 하기
    //type 값을 이용해 할인 조건 타입에 맞는 적절한 메서드가 호출이 되었는지 판단
    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }
        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime.compareTo(time) <= 0 &&
                this.endTime.compareTo(time) >= 0;
    }

    public boolean isDiscountable(int sequence) {
        if(type != DiscountConditionType.SEQUENCE) {
            throw new IllegalArgumentException();
        }
        return this.sequence == sequence;
    }
}
