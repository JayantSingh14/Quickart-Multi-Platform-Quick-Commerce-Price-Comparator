package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzceu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f26032a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcey f26033b;

    public zzceu(zzcey zzceyVar, boolean z) {
        this.f26032a = z;
        this.f26033b = zzceyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26033b.c("windowVisibilityChanged", "isVisible", String.valueOf(this.f26032a));
    }
}
