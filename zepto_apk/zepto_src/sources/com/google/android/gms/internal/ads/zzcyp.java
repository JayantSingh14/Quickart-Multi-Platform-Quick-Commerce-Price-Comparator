package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzcyp implements zzddq, zzdjd {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27415a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfik f27416b;

    /* renamed from: c, reason: collision with root package name */
    public final VersionInfoParcel f27417c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f27418d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdzp f27419e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfnr f27420f;

    /* renamed from: g, reason: collision with root package name */
    public final zzeak f27421g;

    public zzcyp(Context context, zzfik zzfikVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.util.zzj zzjVar, zzdzp zzdzpVar, zzfnr zzfnrVar, zzeak zzeakVar) {
        this.f27415a = context;
        this.f27416b = zzfikVar;
        this.f27417c = versionInfoParcel;
        this.f27418d = zzjVar;
        this.f27419e = zzdzpVar;
        this.f27420f = zzfnrVar;
        this.f27421g = zzeakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void F(zzfic zzficVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void R(zzbza zzbzaVar) throws JSONException {
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzdjd
    public final void a(com.google.android.gms.ads.nonagon.signalgeneration.zzbj zzbjVar) throws JSONException {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.I4)).booleanValue()) {
            b();
        }
    }

    public final void b() throws JSONException {
        String str;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.H4)).booleanValue()) {
            zzfik zzfikVar = this.f27416b;
            zzccv zzccvVarI = this.f27418d.i();
            com.google.android.gms.ads.internal.zzf zzfVar = com.google.android.gms.ads.internal.zzt.C.f21688l;
            boolean zF = this.f27421g.f();
            if (zzccvVarI != null) {
                zzfVar.getClass();
                str = zzccvVarI.f25910d;
            } else {
                str = null;
            }
            zzfVar.a(this.f27415a, this.f27417c, false, zzccvVarI, str, zzfikVar.f31219g, null, this.f27420f, null, null, zF);
        }
        this.f27419e.a();
    }

    @Override // com.google.android.gms.internal.ads.zzdjd
    public final void q(String str) {
    }
}
