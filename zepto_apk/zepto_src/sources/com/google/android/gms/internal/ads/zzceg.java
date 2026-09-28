package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzceg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzceo f26004a;

    public zzceg(zzceo zzceoVar) {
        this.f26004a = zzceoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcey zzceyVar = this.f26004a.q;
        if (zzceyVar != null) {
            zzceyVar.i();
        }
    }
}
