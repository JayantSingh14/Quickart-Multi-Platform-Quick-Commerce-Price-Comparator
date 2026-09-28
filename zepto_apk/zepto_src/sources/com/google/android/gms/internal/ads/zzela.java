package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
final class zzela implements zzdlh {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29598a;

    /* renamed from: b, reason: collision with root package name */
    public final VersionInfoParcel f29599b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcdt f29600c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfhr f29601d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcir f29602e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfik f29603f;

    /* renamed from: g, reason: collision with root package name */
    public final zzbnq f29604g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f29605h;

    /* renamed from: i, reason: collision with root package name */
    public final zzeif f29606i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdxe f29607j;

    public zzela(Context context, VersionInfoParcel versionInfoParcel, zzcdt zzcdtVar, zzfhr zzfhrVar, zzcir zzcirVar, zzfik zzfikVar, boolean z, zzbnq zzbnqVar, zzeif zzeifVar, zzdxe zzdxeVar) {
        this.f29598a = context;
        this.f29599b = versionInfoParcel;
        this.f29600c = zzcdtVar;
        this.f29601d = zzfhrVar;
        this.f29602e = zzcirVar;
        this.f29603f = zzfikVar;
        this.f29604g = zzbnqVar;
        this.f29605h = z;
        this.f29606i = zzeifVar;
        this.f29607j = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final void a(boolean z, Context context, zzdax zzdaxVar) {
        float f2;
        boolean z2;
        zzdjt zzdjtVar = (zzdjt) zzgym.m(this.f29600c);
        zzcir zzcirVar = this.f29602e;
        zzcirVar.g0(true);
        zzbnq zzbnqVar = this.f29604g;
        boolean z3 = this.f29605h;
        boolean z4 = false;
        boolean zA = z3 ? zzbnqVar.a(false) : false;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        boolean zI = com.google.android.gms.ads.internal.util.zzs.i(this.f29598a);
        if (z3) {
            synchronized (zzbnqVar) {
                z2 = zzbnqVar.f25353b;
            }
            if (z2) {
                z4 = true;
            }
        }
        if (z3) {
            synchronized (zzbnqVar) {
                f2 = zzbnqVar.f25354c;
            }
        } else {
            f2 = 0.0f;
        }
        float f3 = f2;
        zzfhr zzfhrVar = this.f29601d;
        com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zA, zI, z4, f3, z, zzfhrVar.O, false);
        if (zzdaxVar != null) {
            zzdaxVar.w0();
        }
        zzdkw zzdkwVarH = zzdjtVar.h();
        zzfhw zzfhwVar = zzfhrVar.s;
        com.google.android.gms.ads.internal.overlay.zzn.a(context, new AdOverlayInfoParcel(zzdkwVarH, zzcirVar, zzfhrVar.Q, this.f29599b, zzfhrVar.B, zzlVar, zzfhwVar.f31180b, zzfhwVar.f31179a, this.f29603f.f31219g, zzdaxVar, zzfhrVar.b() ? this.f29606i : null, zzcirVar.zzn()), true, this.f29607j);
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final zzfhr zzb() {
        return this.f29601d;
    }
}
