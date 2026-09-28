package com.google.android.gms.internal.ads;

import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import androidx.collection.CircularIntArray;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zztr implements zzug {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f35596a;

    /* renamed from: b, reason: collision with root package name */
    public final zztw f35597b;

    /* renamed from: c, reason: collision with root package name */
    public final zztu f35598c;

    /* renamed from: d, reason: collision with root package name */
    public final zzuc f35599d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f35600e;

    /* renamed from: f, reason: collision with root package name */
    public int f35601f = 0;

    public /* synthetic */ zztr(MediaCodec mediaCodec, HandlerThread handlerThread, zztu zztuVar, zzuc zzucVar) {
        this.f35596a = mediaCodec;
        this.f35597b = new zztw(handlerThread);
        this.f35598c = zztuVar;
        this.f35599d = zzucVar;
    }

    public static String b(int i2, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i2 == 1) {
            sb.append("Audio");
        } else if (i2 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i2);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final ByteBuffer A(int i2) {
        return this.f35596a.getOutputBuffer(i2);
    }

    public final void a(MediaFormat mediaFormat, Surface surface, int i2) {
        zzuc zzucVar;
        LoudnessCodecController loudnessCodecController;
        zztw zztwVar = this.f35597b;
        zzgqa.f(zztwVar.f35619c == null);
        HandlerThread handlerThread = zztwVar.f35618b;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        MediaCodec mediaCodec = this.f35596a;
        mediaCodec.setCallback(zztwVar, handler);
        zztwVar.f35619c = handler;
        Trace.beginSection("configureCodec");
        mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, i2);
        Trace.endSection();
        zztu zztuVar = this.f35598c;
        if (!zztuVar.f35615f) {
            HandlerThread handlerThread2 = zztuVar.f35611b;
            handlerThread2.start();
            zztuVar.f35612c = new zzts(zztuVar, handlerThread2.getLooper());
            zztuVar.f35615f = true;
        }
        Trace.beginSection("startCodec");
        mediaCodec.start();
        Trace.endSection();
        if (Build.VERSION.SDK_INT >= 35 && (zzucVar = this.f35599d) != null && ((loudnessCodecController = zzucVar.f35638b) == null || loudnessCodecController.addMediaCodec(mediaCodec))) {
            zzgqa.f(zzucVar.f35637a.add(mediaCodec));
        }
        this.f35601f = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void a0(int i2) {
        this.f35596a.setVideoScalingMode(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void b0(int i2, long j2) {
        this.f35596a.releaseOutputBuffer(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void c0(Bundle bundle) {
        zztu zztuVar = this.f35598c;
        zztuVar.b();
        Handler handler = zztuVar.f35612c;
        String str = zzfj.f31254a;
        handler.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void d0(Surface surface) {
        this.f35596a.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final int e0(MediaCodec.BufferInfo bufferInfo) {
        this.f35598c.b();
        zztw zztwVar = this.f35597b;
        synchronized (zztwVar.f35617a) {
            try {
                zztwVar.b();
                boolean z = true;
                if (zztwVar.f35628l > 0 || zztwVar.f35629m) {
                    return -1;
                }
                CircularIntArray circularIntArray = zztwVar.f35621e;
                if (circularIntArray.f1407b != circularIntArray.f1408c) {
                    z = false;
                }
                if (z) {
                    return -1;
                }
                int iB = circularIntArray.b();
                if (iB >= 0) {
                    if (zztwVar.f35624h == null) {
                        throw null;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) zztwVar.f35622f.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (iB == -2) {
                    zztwVar.f35624h = (MediaFormat) zztwVar.f35623g.remove();
                    iB = -2;
                }
                return iB;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void f0(int i2, zzie zzieVar, long j2, int i3) {
        int length;
        int length2;
        int length3;
        int length4;
        zztu zztuVar = this.f35598c;
        zztuVar.b();
        zztt zzttVarC = zztu.c();
        zzttVarC.f35603a = i2;
        zzttVarC.f35604b = 0;
        zzttVarC.f35606d = j2;
        zzttVarC.f35607e = i3;
        int i4 = zzieVar.f34803f;
        MediaCodec.CryptoInfo cryptoInfo = zzttVarC.f35605c;
        cryptoInfo.numSubSamples = i4;
        int[] iArr = zzieVar.f34801d;
        int[] iArrCopyOf = cryptoInfo.numBytesOfClearData;
        if (iArr != null) {
            if (iArrCopyOf == null || iArrCopyOf.length < (length4 = iArr.length)) {
                iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            } else {
                System.arraycopy(iArr, 0, iArrCopyOf, 0, length4);
            }
        }
        cryptoInfo.numBytesOfClearData = iArrCopyOf;
        int[] iArr2 = zzieVar.f34802e;
        int[] iArrCopyOf2 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr2 != null) {
            if (iArrCopyOf2 == null || iArrCopyOf2.length < (length3 = iArr2.length)) {
                iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length);
            } else {
                System.arraycopy(iArr2, 0, iArrCopyOf2, 0, length3);
            }
        }
        cryptoInfo.numBytesOfEncryptedData = iArrCopyOf2;
        byte[] bArr = zzieVar.f34799b;
        byte[] bArrCopyOf = cryptoInfo.key;
        if (bArr != null) {
            if (bArrCopyOf == null || bArrCopyOf.length < (length2 = bArr.length)) {
                bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            } else {
                System.arraycopy(bArr, 0, bArrCopyOf, 0, length2);
            }
        }
        bArrCopyOf.getClass();
        cryptoInfo.key = bArrCopyOf;
        byte[] bArr2 = zzieVar.f34798a;
        byte[] bArrCopyOf2 = cryptoInfo.iv;
        if (bArr2 != null) {
            if (bArrCopyOf2 == null || bArrCopyOf2.length < (length = bArr2.length)) {
                bArrCopyOf2 = Arrays.copyOf(bArr2, bArr2.length);
            } else {
                System.arraycopy(bArr2, 0, bArrCopyOf2, 0, length);
            }
        }
        bArrCopyOf2.getClass();
        cryptoInfo.iv = bArrCopyOf2;
        cryptoInfo.mode = zzieVar.f34800c;
        cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(zzieVar.f34804g, zzieVar.f34805h));
        Handler handler = zztuVar.f35612c;
        String str = zzfj.f31254a;
        handler.obtainMessage(2, zzttVarC).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void g0(final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.google.android.gms.internal.ads.zztn
            @Override // java.lang.Runnable
            public final void run() {
                zztr zztrVar = this.f35590a;
                zztrVar.f35598c.b();
                zztw zztwVar = zztrVar.f35597b;
                Runnable runnable3 = runnable;
                synchronized (zztwVar.f35617a) {
                    zztwVar.b();
                    ((zzun) runnable3).run();
                }
            }
        };
        zztw zztwVar = this.f35597b;
        synchronized (zztwVar.f35617a) {
            zztwVar.b();
            runnable2.run();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void h0(int i2, int i3, long j2, int i4) {
        zztu zztuVar = this.f35598c;
        zztuVar.b();
        zztt zzttVarC = zztu.c();
        zzttVarC.f35603a = i2;
        zzttVarC.f35604b = i3;
        zzttVarC.f35606d = j2;
        zzttVarC.f35607e = i4;
        Handler handler = zztuVar.f35612c;
        String str = zzfj.f31254a;
        handler.obtainMessage(1, zzttVarC).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final boolean i0(zzuf zzufVar) {
        zztw zztwVar = this.f35597b;
        synchronized (zztwVar.f35617a) {
            zztwVar.o = zzufVar;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void l(int i2) {
        this.f35596a.releaseOutputBuffer(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final int zze() {
        this.f35598c.b();
        zztw zztwVar = this.f35597b;
        synchronized (zztwVar.f35617a) {
            try {
                zztwVar.b();
                boolean z = true;
                int iB = -1;
                if (zztwVar.f35628l > 0 || zztwVar.f35629m) {
                    return -1;
                }
                CircularIntArray circularIntArray = zztwVar.f35620d;
                if (circularIntArray.f1407b != circularIntArray.f1408c) {
                    z = false;
                }
                if (!z) {
                    iB = circularIntArray.b();
                }
                return iB;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final MediaFormat zzg() {
        MediaFormat mediaFormat;
        zztw zztwVar = this.f35597b;
        synchronized (zztwVar.f35617a) {
            try {
                mediaFormat = zztwVar.f35624h;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final ByteBuffer zzh(int i2) {
        return this.f35596a.getInputBuffer(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzk() {
        this.f35598c.a();
        MediaCodec mediaCodec = this.f35596a;
        mediaCodec.flush();
        final zztw zztwVar = this.f35597b;
        synchronized (zztwVar.f35617a) {
            zztwVar.f35628l++;
            Handler handler = zztwVar.f35619c;
            String str = zzfj.f31254a;
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zztv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zztw zztwVar2 = zztwVar;
                    Object obj = zztwVar2.f35617a;
                    synchronized (obj) {
                        try {
                            if (zztwVar2.f35629m) {
                                return;
                            }
                            long j2 = zztwVar2.f35628l - 1;
                            zztwVar2.f35628l = j2;
                            if (j2 > 0) {
                                return;
                            }
                            if (j2 >= 0) {
                                zztwVar2.a();
                                return;
                            }
                            IllegalStateException illegalStateException = new IllegalStateException();
                            synchronized (obj) {
                                zztwVar2.n = illegalStateException;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            });
        }
        mediaCodec.start();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzl() {
        zzuc zzucVar;
        zzuc zzucVar2;
        zzuc zzucVar3;
        try {
            try {
                if (this.f35601f == 1) {
                    zztu zztuVar = this.f35598c;
                    if (zztuVar.f35615f) {
                        zztuVar.a();
                        zztuVar.f35611b.quit();
                    }
                    zztuVar.f35615f = false;
                    zztw zztwVar = this.f35597b;
                    synchronized (zztwVar.f35617a) {
                        zztwVar.f35629m = true;
                        zztwVar.f35618b.quit();
                        zztwVar.a();
                    }
                }
                this.f35601f = 2;
                if (this.f35600e) {
                    return;
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 30 && i2 < 33) {
                    this.f35596a.stop();
                }
                if (i2 >= 35 && (zzucVar3 = this.f35599d) != null) {
                    zzucVar3.b(this.f35596a);
                }
                this.f35596a.release();
                this.f35600e = true;
            } catch (Throwable th) {
                if (!this.f35600e) {
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 30 && i3 < 33) {
                        this.f35596a.stop();
                    }
                    if (i3 >= 35 && (zzucVar2 = this.f35599d) != null) {
                        zzucVar2.b(this.f35596a);
                    }
                    this.f35596a.release();
                    this.f35600e = true;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (Build.VERSION.SDK_INT >= 35 && (zzucVar = this.f35599d) != null) {
                zzucVar.b(this.f35596a);
            }
            this.f35596a.release();
            this.f35600e = true;
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzo() {
        this.f35596a.detachOutputSurface();
    }
}
