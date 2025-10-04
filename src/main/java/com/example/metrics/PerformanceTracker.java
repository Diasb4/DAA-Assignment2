package com.example.metrics;

import java.util.concurrent.TimeUnit;

public class PerformanceTracker {
    public long comparisons, swaps, accesses;
    private long t0;
    private long timeNs;

    public void reset() {
        comparisons = swaps = accesses = 0;
        timeNs = 0;
    }

    // Метрики
    public void addComparison() {
        comparisons++;
    }

    public void addSwap() {
        swaps++;
    }

    public void addAccess(long k) {
        accesses += k;
    }

    // Таймер
    public void startTimer() {
        t0 = System.nanoTime();
    }

    public void stopTimer() {
        timeNs = System.nanoTime() - t0;
    }

    // Время
    public long getTimeNs() {
        return timeNs;
    }

    public long getTimeMs() {
        return TimeUnit.NANOSECONDS.toMillis(timeNs);
    }

    public double getTimeSec() {
        return timeNs / 1_000_000_000.0;
    }

    // Красивый вывод
    @Override
    public String toString() {
        return String.format("Comparisons: %d, Swaps: %d, Accesses: %d, Time: %d ms",
                comparisons, swaps, accesses, getTimeMs());
    }

    // CSV строка (для анализа в Excel / pandas)
    public String toCSV() {
        return String.format("%d,%d,%d,%d",
                comparisons, swaps, accesses, getTimeMs());
    }
}
