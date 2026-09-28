package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcgn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcgp f26169a;

    public zzcgn(zzcgp zzcgpVar) {
        Objects.requireNonNull(zzcgpVar);
        this.f26169a = zzcgpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzt.C.A.f26175a.remove(this.f26169a);
    }
}
