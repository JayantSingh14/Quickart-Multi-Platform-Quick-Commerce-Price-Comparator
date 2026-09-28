package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zztu implements zzuh {

    /* renamed from: g, reason: collision with root package name */
    public static final ArrayDeque f35608g = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    public static final Object f35609h = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodec f35610a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f35611b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f35612c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f35613d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdq f35614e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f35615f;

    public zztu(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzdq zzdqVar = new zzdq();
        this.f35610a = mediaCodec;
        this.f35611b = handlerThread;
        this.f35614e = zzdqVar;
        this.f35613d = new AtomicReference();
    }

    public static zztt c() {
        ArrayDeque arrayDeque = f35608g;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new zztt();
                }
                return (zztt) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        if (this.f35615f) {
            try {
                Handler handler = this.f35612c;
                if (handler == null) {
                    throw null;
                }
                handler.removeCallbacksAndMessages(null);
                zzdq zzdqVar = this.f35614e;
                synchronized (zzdqVar) {
                    zzdqVar.f28219a = false;
                }
                Handler handler2 = this.f35612c;
                if (handler2 == null) {
                    throw null;
                }
                handler2.obtainMessage(3).sendToTarget();
                synchronized (zzdqVar) {
                    while (!zzdqVar.f28219a) {
                        zzdqVar.wait();
                    }
                }
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e2);
            }
        }
    }

    public final void b() {
        RuntimeException runtimeException = (RuntimeException) this.f35613d.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }
}
