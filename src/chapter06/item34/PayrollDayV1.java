package chapter06.item34;

//34-8
//값에 따라 분기하여 코드를 공유하는 열거 타입 - 좋은 방법인가?
//217P
enum PayrollDayV1 {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked * payRate;

        int overtimePay;
        switch(this) {
            case SATURDAY:
            case SUNDAY:
                overtimePay = basePay / 2;
                break;
            default:
                overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }

        return basePay + overtimePay;
    }

    public static void main(String[] args) {
        for(PayrollDayV1 day : values()) {
            System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1));
        }
    }
}