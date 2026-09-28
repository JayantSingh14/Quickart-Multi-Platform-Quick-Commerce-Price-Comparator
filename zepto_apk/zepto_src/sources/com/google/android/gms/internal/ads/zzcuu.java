package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzcuu implements zzbck {

    /* renamed from: a, reason: collision with root package name */
    public final zzcir f27179a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f27180b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f27181c = new AtomicReference();

    public zzcuu(zzcir zzcirVar, Executor executor) {
        this.f27179a = zzcirVar;
        this.f27180b = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final synchronized void u0(zzbcj zzbcjVar) {
        final zzcir zzcirVar = this.f27179a;
        if (zzcirVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Kd)).booleanValue()) {
                if (zzbcjVar.f24707j) {
                    AtomicReference atomicReference = this.f27181c;
                    Boolean bool = Boolean.TRUE;
                    if (!bool.equals(atomicReference.getAndSet(bool))) {
                        this.f27180b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcut
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzcirVar.onResume();
                            }
                        });
                    }
                } else {
                    AtomicReference atomicReference2 = this.f27181c;
                    Boolean bool2 = Boolean.FALSE;
                    if (!bool2.equals(atomicReference2.getAndSet(bool2))) {
                        this.f27180b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcus
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzcirVar.onPause();
                            }
                        });
                    }
                }
            }
        }
    }
}
