package androidx.media3.common.util;

import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class LongArray {

    /* renamed from: a, reason: collision with root package name */
    public int f5703a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f5704b = new long[32];

    public final void a(long j2) {
        int i2 = this.f5703a;
        long[] jArr = this.f5704b;
        if (i2 == jArr.length) {
            this.f5704b = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.f5704b;
        int i3 = this.f5703a;
        this.f5703a = i3 + 1;
        jArr2[i3] = j2;
    }

    public final long b(int i2) {
        if (i2 >= 0 && i2 < this.f5703a) {
            return this.f5704b[i2];
        }
        StringBuilder sbU = android.support.v4.media.b.u(i2, "Invalid index ", ", size is ");
        sbU.append(this.f5703a);
        throw new IndexOutOfBoundsException(sbU.toString());
    }

    public final int c() {
        return this.f5703a;
    }
}
