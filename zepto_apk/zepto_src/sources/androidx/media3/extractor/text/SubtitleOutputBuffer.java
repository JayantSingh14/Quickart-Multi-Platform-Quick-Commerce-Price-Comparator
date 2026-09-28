package androidx.media3.extractor.text;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderOutputBuffer;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {

    /* renamed from: e, reason: collision with root package name */
    public Subtitle f9177e;

    /* renamed from: f, reason: collision with root package name */
    public long f9178f;

    @Override // androidx.media3.extractor.text.Subtitle
    public final int a(long j2) {
        Subtitle subtitle = this.f9177e;
        subtitle.getClass();
        return subtitle.a(j2 - this.f9178f);
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final List b(long j2) {
        Subtitle subtitle = this.f9177e;
        subtitle.getClass();
        return subtitle.b(j2 - this.f9178f);
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final long c(int i2) {
        Subtitle subtitle = this.f9177e;
        subtitle.getClass();
        return subtitle.c(i2) + this.f9178f;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int d() {
        Subtitle subtitle = this.f9177e;
        subtitle.getClass();
        return subtitle.d();
    }

    @Override // androidx.media3.decoder.DecoderOutputBuffer
    public final void h() {
        super.h();
        this.f9177e = null;
    }
}
