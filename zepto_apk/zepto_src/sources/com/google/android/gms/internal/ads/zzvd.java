package com.google.android.gms.internal.ads;

import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class zzvd implements zzug {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f35694a;

    /* renamed from: b, reason: collision with root package name */
    public final zzuc f35695b;

    public zzvd(MediaCodec mediaCodec, zzuc zzucVar) {
        this.f35694a = mediaCodec;
        this.f35695b = zzucVar;
        if (Build.VERSION.SDK_INT < 35 || zzucVar == null) {
            return;
        }
        LoudnessCodecController loudnessCodecController = zzucVar.f35638b;
        if (loudnessCodecController == null || loudnessCodecController.addMediaCodec(mediaCodec)) {
            zzgqa.f(zzucVar.f35637a.add(mediaCodec));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final ByteBuffer A(int i2) {
        return this.f35694a.getOutputBuffer(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void a0(int i2) {
        this.f35694a.setVideoScalingMode(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void b0(int i2, long j2) {
        this.f35694a.releaseOutputBuffer(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void c0(Bundle bundle) {
        this.f35694a.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void d0(Surface surface) {
        this.f35694a.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final int e0(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f35694a.dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void f0(int i2, zzie zzieVar, long j2, int i3) throws MediaCodec.CryptoException {
        this.f35694a.queueSecureInputBuffer(i2, 0, zzieVar.f34806i, j2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void h0(int i2, int i3, long j2, int i4) throws MediaCodec.CryptoException {
        this.f35694a.queueInputBuffer(i2, 0, i3, j2, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void l(int i2) {
        this.f35694a.releaseOutputBuffer(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final int zze() {
        return this.f35694a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final MediaFormat zzg() {
        return this.f35694a.getOutputFormat();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final ByteBuffer zzh(int i2) {
        return this.f35694a.getInputBuffer(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzk() {
        this.f35694a.flush();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzl() {
        zzuc zzucVar = this.f35695b;
        MediaCodec mediaCodec = this.f35694a;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && i2 < 33) {
                mediaCodec.stop();
            }
            if (i2 >= 35 && zzucVar != null) {
                zzucVar.b(mediaCodec);
            }
            mediaCodec.release();
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 35 && zzucVar != null) {
                zzucVar.b(mediaCodec);
            }
            mediaCodec.release();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzo() {
        this.f35694a.detachOutputSurface();
    }
}
