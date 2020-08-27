package com.ynding.cloud.common.model.dict;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * @author dyn
 * @version 2020/1/12
 */
public enum Phase {
    /**
     * 固体，液体，气体
     */
    SOLID, LIQUID, GAS;

    /**
     * 转换
     */
    public enum Transition {
        /**
         * 熔化，凝固
         */
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        /**
         * 蒸发，液化
         */
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        /**
         * 气化，固化
         */
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        /**
         * Initialize the phase transition map
         */
        private static final Map<Phase, Map<Phase, Transition>>
                m = Stream.of(values()).collect(groupingBy(t -> t.from,
                () -> new EnumMap<>(Phase.class),
                toMap(t -> t.to, t -> t,
                        (x, y) -> y, () -> new EnumMap<>(Phase.class))));

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }

    public static void main(String[] args) {
        System.out.println(Transition.from(SOLID, GAS));
    }
}
