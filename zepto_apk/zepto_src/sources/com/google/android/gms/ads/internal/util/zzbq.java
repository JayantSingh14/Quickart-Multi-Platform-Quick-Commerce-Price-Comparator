package com.google.android.gms.ads.internal.util;

import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzfxl;

/* loaded from: classes4.dex */
public final class zzbq {

    /* renamed from: a, reason: collision with root package name */
    public HandlerThread f21536a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzfxl f21537b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f21538c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final Object f21539d = new Object();

    public final Looper a() {
        Looper looper;
        Object obj = this.f21539d;
        synchronized (obj) {
            try {
                if (this.f21538c != 0) {
                    Preconditions.checkNotNull(this.f21536a, "Invalid state: handlerThread should already been initialized.");
                } else if (this.f21536a == null) {
                    zze.k("Starting the looper thread.");
                    HandlerThread handlerThread = new HandlerThread("LooperProvider");
                    this.f21536a = handlerThread;
                    handlerThread.start();
                    this.f21537b = new zzfxl(this.f21536a.getLooper());
                    zze.k("Looper thread started.");
                } else {
                    zze.k("Resuming the looper thread");
                    obj.notifyAll();
                }
                this.f21538c++;
                looper = this.f21536a.getLooper();
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }
}
