package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzclp;
import com.google.android.gms.internal.ads.zzcmg;
import com.google.android.gms.internal.ads.zzijg;

/* loaded from: classes4.dex */
public final class CsiParamDefaults_Factory implements zzijg<CsiParamDefaults> {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f21966a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f21967b;

    public CsiParamDefaults_Factory(zzclp zzclpVar, zzcmg zzcmgVar) {
        this.f21966a = zzclpVar;
        this.f21967b = zzcmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new CsiParamDefaults((Context) this.f21966a.zzb(), (VersionInfoParcel) this.f21967b.zzb());
    }
}
