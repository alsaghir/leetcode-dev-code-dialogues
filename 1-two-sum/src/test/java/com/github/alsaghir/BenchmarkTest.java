package com.github.alsaghir;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"squid:S5786", "squid:S2699"})
public class BenchmarkTest {

    @Test
    void launchBenchmark() throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(SolutionBenchmark.class.getSimpleName())
                .measurementIterations(5)
                .mode(Mode.AverageTime)
                .forks(1)
                .threads(10)
                .timeUnit(TimeUnit.MILLISECONDS)
                .timeout(TimeValue.seconds(10))
                .warmupTime(TimeValue.seconds(5))
                .warmupIterations(1)
                .measurementTime(TimeValue.seconds(5))
                .resultFormat(ResultFormatType.TEXT)
                .build();

        new Runner(opt).run();

    }

    @State(Scope.Thread)
    public static class SolutionBenchmark {

        private int[] nums;
        private Solution solution;

        @Setup(Level.Iteration)
        public void setup() {
            solution = new Solution();
            nums = getInput();
        }

        private int[] getInput() {
            int[] numsArray = new int[10_000];
            for (int i = 0; i < numsArray.length; i++) {
                numsArray[i] = i;
            }
            List<Integer> listShuffle = new ArrayList<>(numsArray.length);
            for (int num : numsArray) {
                listShuffle.add(num);
            }
            Collections.shuffle(listShuffle);
            return listShuffle.stream().mapToInt((i) -> i.intValue()).toArray();
        }

        @Group
        @Benchmark
        public int[] twoSumBruteForce() {
            return solution.twoSum1(nums, 9);
        }

        @Group
        @Benchmark
        public int[] twiSumHashMap() {
            return solution.twoSum2(nums, 9);
        }
    }

}
