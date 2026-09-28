package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.SeekMap;

@UnstableApi
/* loaded from: classes3.dex */
public class ForwardingSeekMap implements SeekMap {

    /* renamed from: a, reason: collision with root package name */
    public final SeekMap f8566a;

    public ForwardingSeekMap(SeekMap seekMap) {
        this.f8566a = seekMap;
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints d(long j2) {
        return this.f8566a.d(j2);
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return this.f8566a.g();
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.f8566a.l();
    }
}
