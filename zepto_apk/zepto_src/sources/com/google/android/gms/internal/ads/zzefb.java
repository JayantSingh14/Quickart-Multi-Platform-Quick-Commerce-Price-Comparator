package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* loaded from: classes4.dex */
public final class zzefb {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f29204a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f29205b;

    /* renamed from: c, reason: collision with root package name */
    public final zzija f29206c;

    /* renamed from: d, reason: collision with root package name */
    public final VersionInfoParcel f29207d;

    /* renamed from: e, reason: collision with root package name */
    public final zzeex f29208e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdxe f29209f;

    public zzefb(Context context, zzgyw zzgywVar, zzgyw zzgywVar2, zzija zzijaVar, VersionInfoParcel versionInfoParcel, zzeex zzeexVar, zzdxe zzdxeVar) {
        this.f29204a = zzgywVar;
        this.f29205b = zzgywVar2;
        this.f29206c = zzijaVar;
        this.f29207d = versionInfoParcel;
        this.f29208e = zzeexVar;
        this.f29209f = zzdxeVar;
    }

    public final void a() {
        try {
            ((zzefw) this.f29206c.zzb()).zzi(this.f29207d.f21400a);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.kf)).booleanValue()) {
                zzdxd zzdxdVarA = this.f29209f.a();
                zzdxdVarA.b("action", "ptard");
                zzdxdVarA.b("ptard", "l");
                zzdxdVarA.c();
            }
        } catch (RemoteException | NullPointerException e2) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.lf)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("Preconnect Local", e2);
            }
        }
    }
}
