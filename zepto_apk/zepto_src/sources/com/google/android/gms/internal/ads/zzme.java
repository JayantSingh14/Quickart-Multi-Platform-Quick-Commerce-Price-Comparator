package com.google.android.gms.internal.ads;

import android.os.Looper;

/* loaded from: classes4.dex */
public final class zzme {

    /* renamed from: a, reason: collision with root package name */
    public final zzmi f35196a;

    /* renamed from: b, reason: collision with root package name */
    public final zzmc f35197b;

    /* renamed from: c, reason: collision with root package name */
    public int f35198c;

    /* renamed from: d, reason: collision with root package name */
    public Object f35199d;

    /* renamed from: e, reason: collision with root package name */
    public final Looper f35200e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f35201f;

    public zzme(zzmc zzmcVar, zzmi zzmiVar, Looper looper) {
        this.f35197b = zzmcVar;
        this.f35196a = zzmiVar;
        this.f35200e = looper;
    }

    public final synchronized void a(boolean z) {
        notifyAll();
    }
}
