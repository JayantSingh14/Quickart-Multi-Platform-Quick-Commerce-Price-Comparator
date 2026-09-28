package androidx.media3.exoplayer.text;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.util.ArrayList;

/* loaded from: classes3.dex */
final class MergingCuesResolver implements CuesResolver {

    /* renamed from: b, reason: collision with root package name */
    public static final Ordering f7953b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7954a = new ArrayList();

    static {
        final int i2 = 0;
        final int i3 = 1;
        f7953b = Ordering.c().f(new Function() { // from class: androidx.media3.exoplayer.text.a
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                CuesWithTiming cuesWithTiming = (CuesWithTiming) obj;
                switch (i2) {
                    case 0:
                        Ordering ordering = MergingCuesResolver.f7953b;
                        return Long.valueOf(cuesWithTiming.f9156b);
                    default:
                        Ordering ordering2 = MergingCuesResolver.f7953b;
                        return Long.valueOf(cuesWithTiming.f9157c);
                }
            }
        }).a(Ordering.c().g().f(new Function() { // from class: androidx.media3.exoplayer.text.a
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                CuesWithTiming cuesWithTiming = (CuesWithTiming) obj;
                switch (i3) {
                    case 0:
                        Ordering ordering = MergingCuesResolver.f7953b;
                        return Long.valueOf(cuesWithTiming.f9156b);
                    default:
                        Ordering ordering2 = MergingCuesResolver.f7953b;
                        return Long.valueOf(cuesWithTiming.f9157c);
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final ImmutableList a(long j2) {
        ArrayList arrayList = this.f7954a;
        if (!arrayList.isEmpty()) {
            if (j2 >= ((CuesWithTiming) arrayList.get(0)).f9156b) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    CuesWithTiming cuesWithTiming = (CuesWithTiming) arrayList.get(i2);
                    if (j2 >= cuesWithTiming.f9156b && j2 < cuesWithTiming.f9158d) {
                        arrayList2.add(cuesWithTiming);
                    }
                    if (j2 < cuesWithTiming.f9156b) {
                        break;
                    }
                }
                ImmutableList immutableListY = ImmutableList.y(f7953b, arrayList2);
                ImmutableList.Builder builder = new ImmutableList.Builder();
                for (int i3 = 0; i3 < immutableListY.size(); i3++) {
                    builder.f(((CuesWithTiming) immutableListY.get(i3)).f9155a);
                }
                return builder.j();
            }
        }
        return ImmutableList.r();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final boolean b(CuesWithTiming cuesWithTiming, long j2) {
        long j3 = cuesWithTiming.f9156b;
        Assertions.a(j3 != -9223372036854775807L);
        Assertions.a(cuesWithTiming.f9157c != -9223372036854775807L);
        boolean z = j3 <= j2 && j2 < cuesWithTiming.f9158d;
        ArrayList arrayList = this.f7954a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (j3 >= ((CuesWithTiming) arrayList.get(size)).f9156b) {
                arrayList.add(size + 1, cuesWithTiming);
                return z;
            }
        }
        arrayList.add(0, cuesWithTiming);
        return z;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final long c(long j2) {
        ArrayList arrayList = this.f7954a;
        if (arrayList.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j2 < ((CuesWithTiming) arrayList.get(0)).f9156b) {
            return -9223372036854775807L;
        }
        long jMax = ((CuesWithTiming) arrayList.get(0)).f9156b;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            long j3 = ((CuesWithTiming) arrayList.get(i2)).f9156b;
            long j4 = ((CuesWithTiming) arrayList.get(i2)).f9158d;
            if (j4 > j2) {
                if (j3 > j2) {
                    break;
                }
                jMax = Math.max(jMax, j3);
            } else {
                jMax = Math.max(jMax, j4);
            }
        }
        return jMax;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final void clear() {
        this.f7954a.clear();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final long d(long j2) {
        int i2 = 0;
        long jMin = -9223372036854775807L;
        while (true) {
            ArrayList arrayList = this.f7954a;
            if (i2 >= arrayList.size()) {
                break;
            }
            long j3 = ((CuesWithTiming) arrayList.get(i2)).f9156b;
            long j4 = ((CuesWithTiming) arrayList.get(i2)).f9158d;
            if (j2 < j3) {
                jMin = jMin == -9223372036854775807L ? j3 : Math.min(jMin, j3);
            } else {
                if (j2 < j4) {
                    jMin = jMin == -9223372036854775807L ? j4 : Math.min(jMin, j4);
                }
                i2++;
            }
        }
        if (jMin != -9223372036854775807L) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public final void e(long j2) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f7954a;
            if (i2 >= arrayList.size()) {
                return;
            }
            long j3 = ((CuesWithTiming) arrayList.get(i2)).f9156b;
            if (j2 > j3 && j2 > ((CuesWithTiming) arrayList.get(i2)).f9158d) {
                arrayList.remove(i2);
                i2--;
            } else if (j2 < j3) {
                return;
            }
            i2++;
        }
    }
}
