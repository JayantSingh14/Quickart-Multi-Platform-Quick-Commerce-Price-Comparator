package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.collection.CircularIntArray;
import java.util.ArrayDeque;

/* loaded from: classes4.dex */
final class zztw extends MediaCodec.Callback {

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f35618b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f35619c;

    /* renamed from: h, reason: collision with root package name */
    public MediaFormat f35624h;

    /* renamed from: i, reason: collision with root package name */
    public MediaFormat f35625i;

    /* renamed from: j, reason: collision with root package name */
    public MediaCodec.CodecException f35626j;

    /* renamed from: k, reason: collision with root package name */
    public MediaCodec.CryptoException f35627k;

    /* renamed from: l, reason: collision with root package name */
    public long f35628l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f35629m;
    public IllegalStateException n;
    public zzuf o;

    /* renamed from: a, reason: collision with root package name */
    public final Object f35617a = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final CircularIntArray f35620d = new CircularIntArray();

    /* renamed from: e, reason: collision with root package name */
    public final CircularIntArray f35621e = new CircularIntArray();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f35622f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f35623g = new ArrayDeque();

    public zztw(HandlerThread handlerThread) {
        this.f35618b = handlerThread;
    }

    public final void a() {
        ArrayDeque arrayDeque = this.f35623g;
        if (!arrayDeque.isEmpty()) {
            this.f35625i = (MediaFormat) arrayDeque.getLast();
        }
        CircularIntArray circularIntArray = this.f35620d;
        circularIntArray.f1408c = circularIntArray.f1407b;
        CircularIntArray circularIntArray2 = this.f35621e;
        circularIntArray2.f1408c = circularIntArray2.f1407b;
        this.f35622f.clear();
        arrayDeque.clear();
    }

    public final void b() {
        IllegalStateException illegalStateException = this.n;
        if (illegalStateException != null) {
            this.n = null;
            throw illegalStateException;
        }
        MediaCodec.CodecException codecException = this.f35626j;
        if (codecException != null) {
            this.f35626j = null;
            throw codecException;
        }
        MediaCodec.CryptoException cryptoException = this.f35627k;
        if (cryptoException == null) {
            return;
        }
        this.f35627k = null;
        throw cryptoException;
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f35617a) {
            this.f35627k = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f35617a) {
            this.f35626j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
        zzmh zzmhVar;
        synchronized (this.f35617a) {
            try {
                this.f35620d.a(i2);
                zzuf zzufVar = this.o;
                if (zzufVar != null && (zzmhVar = ((zzuo) zzufVar).f35663a.H) != null) {
                    zzmhVar.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
        zzmh zzmhVar;
        synchronized (this.f35617a) {
            try {
                MediaFormat mediaFormat = this.f35625i;
                if (mediaFormat != null) {
                    this.f35621e.a(-2);
                    this.f35623g.add(mediaFormat);
                    this.f35625i = null;
                }
                this.f35621e.a(i2);
                this.f35622f.add(bufferInfo);
                zzuf zzufVar = this.o;
                if (zzufVar != null && (zzmhVar = ((zzuo) zzufVar).f35663a.H) != null) {
                    zzmhVar.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f35617a) {
            this.f35621e.a(-2);
            this.f35623g.add(mediaFormat);
            this.f35625i = null;
        }
    }
}
