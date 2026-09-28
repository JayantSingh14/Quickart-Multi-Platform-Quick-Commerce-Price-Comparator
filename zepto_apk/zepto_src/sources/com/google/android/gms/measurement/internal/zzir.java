package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
final class zzir implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbg f39140a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39141b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzjc f39142c;

    public zzir(zzjc zzjcVar, zzbg zzbgVar, String str) {
        this.f39140a = zzbgVar;
        this.f39141b = str;
        this.f39142c = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzjc zzjcVar = this.f39142c;
        zzjcVar.f39177a.A();
        zzjcVar.f39177a.h(this.f39140a, this.f39141b);
    }
}
