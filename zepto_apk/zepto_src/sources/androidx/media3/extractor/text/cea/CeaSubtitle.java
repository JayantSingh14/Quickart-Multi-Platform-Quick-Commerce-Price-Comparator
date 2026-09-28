package androidx.media3.extractor.text.cea;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.Subtitle;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class CeaSubtitle implements Subtitle {

    /* renamed from: a, reason: collision with root package name */
    public final List f9255a;

    public CeaSubtitle(List list) {
        this.f9255a = list;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final List b(long j2) {
        return j2 >= 0 ? this.f9255a : Collections.EMPTY_LIST;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final long c(int i2) {
        Assertions.a(i2 == 0);
        return 0L;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int d() {
        return 1;
    }
}
