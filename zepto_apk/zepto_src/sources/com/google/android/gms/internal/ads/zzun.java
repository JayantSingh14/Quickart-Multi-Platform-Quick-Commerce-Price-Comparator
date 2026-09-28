package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzun implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzuq f35661a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzle f35662b;

    public /* synthetic */ zzun(zzuq zzuqVar, zzle zzleVar) {
        this.f35661a = zzuqVar;
        this.f35662b = zzleVar;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        zzuq zzuqVar = this.f35661a;
        zzuqVar.C.set(zzuqVar.G(this.f35662b, zzuqVar.w, 0));
    }
}
