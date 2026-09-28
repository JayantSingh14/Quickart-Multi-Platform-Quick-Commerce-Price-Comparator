package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzezi implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30664a;

    /* renamed from: b, reason: collision with root package name */
    public final String f30665b;

    /* renamed from: c, reason: collision with root package name */
    public final String f30666c;

    /* renamed from: d, reason: collision with root package name */
    public final String f30667d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f30668e;

    public zzezi(String str, String str2, String str3, String str4, Long l2) {
        this.f30664a = str;
        this.f30665b = str2;
        this.f30666c = str3;
        this.f30667d = str4;
        this.f30668e = l2;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        zzfiz.e("gmp_app_id", this.f30664a, bundle);
        zzfiz.e("fbs_aiid", this.f30665b, bundle);
        zzfiz.e("fbs_aeid", this.f30666c, bundle);
        zzfiz.e("apm_id_origin", this.f30667d, bundle);
        Long l2 = this.f30668e;
        if (l2 != null) {
            bundle.putLong("sai_timeout", l2.longValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfiz.e("fbs_aeid", this.f30666c, ((zzczm) obj).f27482b);
    }
}
