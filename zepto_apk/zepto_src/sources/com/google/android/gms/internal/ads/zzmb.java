package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public final class zzmb {

    /* renamed from: a, reason: collision with root package name */
    public final Object f35192a;

    /* renamed from: b, reason: collision with root package name */
    public Looper f35193b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f35194c;

    /* renamed from: d, reason: collision with root package name */
    public int f35195d;

    public zzmb() {
        throw null;
    }

    public final void a() {
        HandlerThread handlerThread;
        synchronized (this.f35192a) {
            try {
                zzgqa.f(this.f35195d > 0);
                int i2 = this.f35195d - 1;
                this.f35195d = i2;
                if (i2 == 0 && (handlerThread = this.f35194c) != null) {
                    handlerThread.quit();
                    this.f35194c = null;
                    this.f35193b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zzmb(int i2) {
        this.f35192a = new Object();
        this.f35193b = null;
        this.f35194c = null;
        this.f35195d = 0;
    }
}
