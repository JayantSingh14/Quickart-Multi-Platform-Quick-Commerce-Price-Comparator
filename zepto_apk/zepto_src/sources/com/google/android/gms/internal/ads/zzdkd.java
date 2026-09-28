package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzdkd implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f27842a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f27843b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcwb f27844c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdab f27845d;

    public zzdkd(zzijf zzijfVar, zzcmg zzcmgVar, zzcwb zzcwbVar, zzdab zzdabVar) {
        this.f27842a = zzijfVar;
        this.f27843b = zzcmgVar;
        this.f27844c = zzcwbVar;
        this.f27845d = zzdabVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.f27842a.zzb();
        final VersionInfoParcel versionInfoParcelA = this.f27843b.a();
        final zzfhr zzfhrVarA = this.f27844c.a();
        final zzfik zzfikVarA = this.f27845d.a();
        return new zzdij(new zzdby() { // from class: com.google.android.gms.internal.ads.zzdjv
            @Override // com.google.android.gms.internal.ads.zzdby
            public final void zzg() {
                JSONObject jSONObject = zzfhrVarA.C;
                com.google.android.gms.ads.internal.zzt.C.o.d(context, versionInfoParcelA.f21400a, jSONObject.toString(), zzfikVarA.f31219g);
            }
        }, zzcdo.f25988g);
    }
}
