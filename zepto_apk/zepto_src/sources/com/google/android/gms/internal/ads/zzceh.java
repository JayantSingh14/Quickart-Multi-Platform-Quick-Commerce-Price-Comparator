package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzceh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f26005a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f26006b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzceo f26007c;

    public zzceh(zzceo zzceoVar, String str, String str2) {
        this.f26005a = str;
        this.f26006b = str2;
        this.f26007c = zzceoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcey zzceyVar = this.f26007c.q;
        if (zzceyVar != null) {
            zzceyVar.j(this.f26005a, this.f26006b);
        }
    }
}
