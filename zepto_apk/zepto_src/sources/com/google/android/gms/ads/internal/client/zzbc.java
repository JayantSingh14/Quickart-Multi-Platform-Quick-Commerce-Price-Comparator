package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* loaded from: classes4.dex */
public class zzbc extends AdListener {

    /* renamed from: a, reason: collision with root package name */
    public final Object f21148a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public AdListener f21149b;

    @Override // com.google.android.gms.ads.AdListener
    public final void f() {
        synchronized (this.f21148a) {
            try {
                AdListener adListener = this.f21149b;
                if (adListener != null) {
                    adListener.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void g(LoadAdError loadAdError) {
        synchronized (this.f21148a) {
            try {
                AdListener adListener = this.f21149b;
                if (adListener != null) {
                    adListener.g(loadAdError);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
    public final void h() {
        synchronized (this.f21148a) {
            try {
                AdListener adListener = this.f21149b;
                if (adListener != null) {
                    adListener.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void j() {
        synchronized (this.f21148a) {
            try {
                AdListener adListener = this.f21149b;
                if (adListener != null) {
                    adListener.j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void m() {
        synchronized (this.f21148a) {
            try {
                AdListener adListener = this.f21149b;
                if (adListener != null) {
                    adListener.m();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void t() {
        synchronized (this.f21148a) {
            try {
                AdListener adListener = this.f21149b;
                if (adListener != null) {
                    adListener.t();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
