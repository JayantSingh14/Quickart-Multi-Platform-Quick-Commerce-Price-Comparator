package androidx.media3.extractor.text;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.p;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class CuesWithTimingSubtitle implements Subtitle {

    /* renamed from: c, reason: collision with root package name */
    public static final Ordering f9159c = Ordering.c().f(new p(18));

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f9160a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f9161b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CuesWithTimingSubtitle(java.util.List r20) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.CuesWithTimingSubtitle.<init>(java.util.List):void");
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int a(long j2) {
        int iB = Util.b(this.f9161b, j2, false);
        if (iB < this.f9160a.size()) {
            return iB;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.extractor.text.Subtitle
    public final List b(long j2) {
        int iF = Util.f(this.f9161b, j2, false);
        return iF == -1 ? ImmutableList.r() : (ImmutableList) this.f9160a.get(iF);
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final long c(int i2) {
        Assertions.a(i2 < this.f9160a.size());
        return this.f9161b[i2];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int d() {
        return this.f9160a.size();
    }
}
