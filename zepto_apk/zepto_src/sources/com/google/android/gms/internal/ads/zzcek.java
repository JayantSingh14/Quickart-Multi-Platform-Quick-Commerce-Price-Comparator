package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzcek implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzceo f26012a;

    public zzcek(zzceo zzceoVar) {
        this.f26012a = zzceoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzceo zzceoVar = this.f26012a;
        zzcey zzceyVar = zzceoVar.q;
        if (zzceyVar != null) {
            zzceyVar.h();
            zzceoVar.q.k();
        }
    }
}
