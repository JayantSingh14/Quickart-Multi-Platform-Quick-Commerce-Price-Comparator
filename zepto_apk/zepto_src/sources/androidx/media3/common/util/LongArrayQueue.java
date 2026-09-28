package androidx.media3.common.util;

import java.util.NoSuchElementException;

@UnstableApi
/* loaded from: classes3.dex */
public final class LongArrayQueue {

    /* renamed from: a, reason: collision with root package name */
    public int f5705a;

    /* renamed from: b, reason: collision with root package name */
    public int f5706b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f5707c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5708d;

    public LongArrayQueue() {
        int iHighestOneBit = Integer.bitCount(16) != 1 ? Integer.highestOneBit(15) << 1 : 16;
        this.f5705a = 0;
        this.f5706b = 0;
        this.f5707c = new long[iHighestOneBit];
        this.f5708d = iHighestOneBit - 1;
    }

    public final long a() {
        int i2 = this.f5706b;
        if (i2 == 0) {
            throw new NoSuchElementException();
        }
        int i3 = this.f5705a;
        long j2 = this.f5707c[i3];
        this.f5705a = (i3 + 1) & this.f5708d;
        this.f5706b = i2 - 1;
        return j2;
    }
}
