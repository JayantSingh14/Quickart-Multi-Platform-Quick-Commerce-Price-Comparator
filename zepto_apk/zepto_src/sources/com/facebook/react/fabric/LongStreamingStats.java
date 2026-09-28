package com.facebook.react.fabric;

import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class LongStreamingStats {
    private double average;
    private int len;
    private long max;

    @NotNull
    private final Queue<Long> minHeap = new PriorityQueue(11);

    @NotNull
    private final Queue<Long> maxHeap = new PriorityQueue(11, ComparisonsKt.d());

    public final void add(long j2) {
        if (j2 != 0) {
            if (this.minHeap.size() == this.maxHeap.size()) {
                this.maxHeap.offer(Long.valueOf(j2));
                this.minHeap.offer(this.maxHeap.poll());
            } else {
                this.minHeap.offer(Long.valueOf(j2));
                this.maxHeap.offer(this.minHeap.poll());
            }
        }
        int i2 = this.len + 1;
        this.len = i2;
        if (i2 == 1) {
            this.average = j2;
        } else {
            this.average = (this.average / (i2 / r0)) + (j2 / i2);
        }
        long j3 = this.max;
        if (j2 <= j3) {
            j2 = j3;
        }
        this.max = j2;
    }

    public final double getAverage() {
        return this.average;
    }

    public final long getMax() {
        return this.max;
    }

    public final double getMedian() {
        long jLongValue;
        Long lValueOf;
        if (this.minHeap.size() == 0 && this.maxHeap.size() == 0) {
            return 0.0d;
        }
        if (this.minHeap.size() > this.maxHeap.size()) {
            lValueOf = this.minHeap.peek();
        } else {
            Long lPeek = this.minHeap.peek();
            if (lPeek != null) {
                jLongValue = lPeek.longValue();
            } else {
                Long lPeek2 = this.maxHeap.peek();
                Intrinsics.c(lPeek2);
                jLongValue = lPeek2.longValue();
            }
            lValueOf = Long.valueOf(jLongValue / 2);
        }
        return lValueOf.longValue();
    }
}
