package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final /* synthetic */ class zzcti implements zzdby {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f27113a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VersionInfoParcel f27114b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfhr f27115c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfik f27116d;

    public /* synthetic */ zzcti(Context context, VersionInfoParcel versionInfoParcel, zzfhr zzfhrVar, zzfik zzfikVar) {
        this.f27113a = context;
        this.f27114b = versionInfoParcel;
        this.f27115c = zzfhrVar;
        this.f27116d = zzfikVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() {
        JSONObject jSONObject = this.f27115c.C;
        com.google.android.gms.ads.internal.zzt.C.o.d(this.f27113a, this.f27114b.f21400a, jSONObject.toString(), this.f27116d.f31219g);
    }
}
