package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzcei implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzceo f26008a;

    public zzcei(zzceo zzceoVar) {
        this.f26008a = zzceoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcey zzceyVar = this.f26008a.q;
        if (zzceyVar != null) {
            zzceyVar.e();
        }
    }
}
