package com.ynding.cloud.common.model.dict;

/**
 * 发薪日（策略枚举模式：一些（但不是全部）枚举常量共享共同行为）
 *
 * @author dyn
 * @version 2020/1/12
 */
public enum PayrollDay {
    /**
     * 星期
     */
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    PayrollDay() {
        this(PayType.WEEKDAY);
    } // Default

    /**
     * 付薪策略
     */
    private enum PayType {

        /**
         * 工作日
         */
        WEEKDAY {
            @Override
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 :
                        (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        /**
         * 休息日
         */
        WEEKEND {
            @Override
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);

        /**
         * 基础工作时长（分钟）
         */
        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }

    public static void main(String[] args) {
        System.out.println(MONDAY.payType.pay(4 * 60, 100));
        System.out.println(SATURDAY.payType.pay(4 * 60, 100));
    }
}
