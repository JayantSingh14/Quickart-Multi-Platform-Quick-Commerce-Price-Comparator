package com.google.android.gms.internal.pal;

import android.os.Handler;

/* loaded from: classes4.dex */
final class zzdz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzeb f37665a;

    public zzdz(zzeb zzebVar) {
        this.f37665a = zzebVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = zzeb.f37668m;
        this.f37665a.c();
    }
}
