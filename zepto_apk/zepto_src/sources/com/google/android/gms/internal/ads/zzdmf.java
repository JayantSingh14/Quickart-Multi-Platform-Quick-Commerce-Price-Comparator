package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzdmf implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f27933a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfpi f27934b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.client.zzv f27935c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfno f27936d;

    public /* synthetic */ zzdmf(zzdmg zzdmgVar, zzfpi zzfpiVar, com.google.android.gms.ads.internal.util.client.zzv zzvVar, zzfno zzfnoVar) {
        this.f27933a = new WeakReference(zzdmgVar);
        this.f27934b = zzfpiVar;
        this.f27935c = zzvVar;
        this.f27936d = zzfnoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzdmg zzdmgVar = (zzdmg) this.f27933a.get();
        String str = (String) map.get("u");
        if (zzdmgVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f27934b.b(str, this.f27935c, this.f27936d, zzdmgVar.D);
    }
}
