package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzeyl implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30582a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f30583b;

    /* renamed from: c, reason: collision with root package name */
    public final String f30584c;

    /* renamed from: d, reason: collision with root package name */
    public final String f30585d;

    /* renamed from: e, reason: collision with root package name */
    public final String f30586e;

    /* renamed from: f, reason: collision with root package name */
    public final String f30587f;

    public zzeyl(String str, Integer num, String str2, String str3, String str4, String str5) {
        this.f30582a = str;
        this.f30583b = num;
        this.f30584c = str2;
        this.f30585d = str3;
        this.f30586e = str4;
        this.f30587f = str5;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        zzfiz.e("pn", this.f30582a, bundle);
        Integer num = this.f30583b;
        if (num != null) {
            bundle.putInt("vc", num.intValue());
        }
        zzfiz.e("vnm", this.f30584c, bundle);
        zzfiz.e("dl", this.f30585d, bundle);
        zzfiz.e("ins_pn", this.f30586e, bundle);
        zzfiz.e("ini_pn", this.f30587f, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzczm) obj).f27482b;
        zzfiz.e("pn", this.f30582a, bundle);
        zzfiz.e("dl", this.f30585d, bundle);
    }
}
