package androidx.media3.exoplayer;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Locale;

@UnstableApi
/* loaded from: classes3.dex */
public final class DecoderCounters {

    /* renamed from: a, reason: collision with root package name */
    public int f6125a;

    /* renamed from: b, reason: collision with root package name */
    public int f6126b;

    /* renamed from: c, reason: collision with root package name */
    public int f6127c;

    /* renamed from: d, reason: collision with root package name */
    public int f6128d;

    /* renamed from: e, reason: collision with root package name */
    public int f6129e;

    /* renamed from: f, reason: collision with root package name */
    public int f6130f;

    /* renamed from: g, reason: collision with root package name */
    public int f6131g;

    /* renamed from: h, reason: collision with root package name */
    public int f6132h;

    /* renamed from: i, reason: collision with root package name */
    public int f6133i;

    /* renamed from: j, reason: collision with root package name */
    public int f6134j;

    /* renamed from: k, reason: collision with root package name */
    public long f6135k;

    /* renamed from: l, reason: collision with root package name */
    public int f6136l;

    public final String toString() {
        int i2 = this.f6125a;
        int i3 = this.f6126b;
        int i4 = this.f6127c;
        int i5 = this.f6128d;
        int i6 = this.f6129e;
        int i7 = this.f6130f;
        int i8 = this.f6131g;
        int i9 = this.f6132h;
        int i10 = this.f6133i;
        int i11 = this.f6134j;
        long j2 = this.f6135k;
        int i12 = this.f6136l;
        int i13 = Util.f5744a;
        Locale locale = Locale.US;
        StringBuilder sbT = android.support.v4.media.b.t(i2, i3, "DecoderCounters {\n decoderInits=", ",\n decoderReleases=", "\n queuedInputBuffers=");
        android.support.v4.media.a.q(i4, i5, "\n skippedInputBuffers=", "\n renderedOutputBuffers=", sbT);
        android.support.v4.media.a.q(i6, i7, "\n skippedOutputBuffers=", "\n droppedBuffers=", sbT);
        android.support.v4.media.a.q(i8, i9, "\n droppedInputBuffers=", "\n maxConsecutiveDroppedBuffers=", sbT);
        android.support.v4.media.a.q(i10, i11, "\n droppedToKeyframeEvents=", "\n totalVideoFrameProcessingOffsetUs=", sbT);
        sbT.append(j2);
        sbT.append("\n videoFrameProcessingOffsetCount=");
        sbT.append(i12);
        sbT.append("\n}");
        return sbT.toString();
    }
}
