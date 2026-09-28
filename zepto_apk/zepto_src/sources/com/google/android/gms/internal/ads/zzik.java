package com.google.android.gms.internal.ads;

import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzik {

    /* renamed from: a, reason: collision with root package name */
    public int f34911a;

    /* renamed from: b, reason: collision with root package name */
    public int f34912b;

    /* renamed from: c, reason: collision with root package name */
    public int f34913c;

    /* renamed from: d, reason: collision with root package name */
    public int f34914d;

    /* renamed from: e, reason: collision with root package name */
    public int f34915e;

    /* renamed from: f, reason: collision with root package name */
    public int f34916f;

    /* renamed from: g, reason: collision with root package name */
    public int f34917g;

    /* renamed from: h, reason: collision with root package name */
    public int f34918h;

    /* renamed from: i, reason: collision with root package name */
    public int f34919i;

    /* renamed from: j, reason: collision with root package name */
    public int f34920j;

    /* renamed from: k, reason: collision with root package name */
    public long f34921k;

    /* renamed from: l, reason: collision with root package name */
    public int f34922l;

    public final synchronized void a() {
    }

    public final String toString() {
        int i2 = this.f34911a;
        int i3 = this.f34912b;
        int i4 = this.f34913c;
        int i5 = this.f34914d;
        int i6 = this.f34915e;
        int i7 = this.f34916f;
        int i8 = this.f34917g;
        int i9 = this.f34918h;
        int i10 = this.f34919i;
        int i11 = this.f34920j;
        long j2 = this.f34921k;
        int i12 = this.f34922l;
        String str = zzfj.f31254a;
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
