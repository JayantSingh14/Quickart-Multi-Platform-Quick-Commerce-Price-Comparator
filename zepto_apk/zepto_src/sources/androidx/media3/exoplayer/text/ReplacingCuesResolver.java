package androidx.media3.exoplayer.text;

import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;

/* loaded from: classes3.dex */
final class ReplacingCuesResolver implements CuesResolver {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7955a = new ArrayList();

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final ImmutableList a(long j2) {
        int iF = f(j2);
        if (iF == 0) {
            return ImmutableList.r();
        }
        CuesWithTiming cuesWithTiming = (CuesWithTiming) this.f7955a.get(iF - 1);
        long j3 = cuesWithTiming.f9158d;
        return (j3 == -9223372036854775807L || j2 < j3) ? cuesWithTiming.f9155a : ImmutableList.r();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    @Override // androidx.media3.exoplayer.text.CuesResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(androidx.media3.extractor.text.CuesWithTiming r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.f9156b
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 0
            r6 = 1
            if (r4 == 0) goto Lf
            r4 = r6
            goto L10
        Lf:
            r4 = r5
        L10:
            androidx.media3.common.util.Assertions.a(r4)
            int r4 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r4 > 0) goto L23
            long r7 = r10.f9158d
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 == 0) goto L21
            int r2 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r2 >= 0) goto L23
        L21:
            r2 = r6
            goto L24
        L23:
            r2 = r5
        L24:
            java.util.ArrayList r3 = r9.f7955a
            int r4 = r3.size()
            int r4 = r4 - r6
        L2b:
            if (r4 < 0) goto L4e
            java.lang.Object r7 = r3.get(r4)
            androidx.media3.extractor.text.CuesWithTiming r7 = (androidx.media3.extractor.text.CuesWithTiming) r7
            long r7 = r7.f9156b
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 < 0) goto L3e
            int r4 = r4 + r6
            r3.add(r4, r10)
            return r2
        L3e:
            java.lang.Object r7 = r3.get(r4)
            androidx.media3.extractor.text.CuesWithTiming r7 = (androidx.media3.extractor.text.CuesWithTiming) r7
            long r7 = r7.f9156b
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 > 0) goto L4b
            r2 = r5
        L4b:
            int r4 = r4 + (-1)
            goto L2b
        L4e:
            r3.add(r5, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.text.ReplacingCuesResolver.b(androidx.media3.extractor.text.CuesWithTiming, long):boolean");
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final long c(long j2) {
        ArrayList arrayList = this.f7955a;
        if (arrayList.isEmpty() || j2 < ((CuesWithTiming) arrayList.get(0)).f9156b) {
            return -9223372036854775807L;
        }
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            long j3 = ((CuesWithTiming) arrayList.get(i2)).f9156b;
            if (j2 == j3) {
                return j3;
            }
            if (j2 < j3) {
                CuesWithTiming cuesWithTiming = (CuesWithTiming) arrayList.get(i2 - 1);
                long j4 = cuesWithTiming.f9158d;
                return (j4 == -9223372036854775807L || j4 > j2) ? cuesWithTiming.f9156b : j4;
            }
        }
        CuesWithTiming cuesWithTiming2 = (CuesWithTiming) Iterables.c(arrayList);
        long j5 = cuesWithTiming2.f9158d;
        return (j5 == -9223372036854775807L || j2 < j5) ? cuesWithTiming2.f9156b : j5;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final void clear() {
        this.f7955a.clear();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final long d(long j2) {
        ArrayList arrayList = this.f7955a;
        if (arrayList.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (j2 < ((CuesWithTiming) arrayList.get(0)).f9156b) {
            return ((CuesWithTiming) arrayList.get(0)).f9156b;
        }
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            CuesWithTiming cuesWithTiming = (CuesWithTiming) arrayList.get(i2);
            if (j2 < cuesWithTiming.f9156b) {
                long j3 = ((CuesWithTiming) arrayList.get(i2 - 1)).f9158d;
                long j4 = cuesWithTiming.f9156b;
                return (j3 == -9223372036854775807L || j3 <= j2 || j3 >= j4) ? j4 : j3;
            }
        }
        long j5 = ((CuesWithTiming) Iterables.c(arrayList)).f9158d;
        if (j5 == -9223372036854775807L || j2 >= j5) {
            return Long.MIN_VALUE;
        }
        return j5;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final void e(long j2) {
        int iF = f(j2);
        if (iF > 0) {
            this.f7955a.subList(0, iF).clear();
        }
    }

    public final int f(long j2) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f7955a;
            if (i2 >= arrayList.size()) {
                return arrayList.size();
            }
            if (j2 < ((CuesWithTiming) arrayList.get(i2)).f9156b) {
                return i2;
            }
            i2++;
        }
    }
}
