package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzdyr {

    /* renamed from: a, reason: collision with root package name */
    public final zzbon f28801a;

    public zzdyr(zzbon zzbonVar) {
        this.f28801a = zzbonVar;
    }

    public final void a(long j2) {
        zzdyq zzdyqVar = new zzdyq("creation");
        zzdyqVar.f28795a = Long.valueOf(j2);
        zzdyqVar.f28797c = "nativeObjectNotCreated";
        b(zzdyqVar);
    }

    public final void b(zzdyq zzdyqVar) {
        String strA = zzdyqVar.a();
        String strConcat = "Dispatching AFMA event on publisher webview: ".concat(strA);
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.e(strConcat);
        this.f28801a.b(strA);
    }
}
