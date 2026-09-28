package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzcej implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f26009a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f26010b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzceo f26011c;

    public zzcej(zzceo zzceoVar, int i2, int i3) {
        this.f26009a = i2;
        this.f26010b = i3;
        this.f26011c = zzceoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcey zzceyVar = this.f26011c.q;
        if (zzceyVar != null) {
            zzceyVar.l(this.f26009a, this.f26010b);
        }
    }
}
