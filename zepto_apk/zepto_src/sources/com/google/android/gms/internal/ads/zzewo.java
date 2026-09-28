package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
final class zzewo implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30489a;

    /* renamed from: b, reason: collision with root package name */
    public final String f30490b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f30491c;

    public /* synthetic */ zzewo(String str, String str2, Bundle bundle) {
        this.f30489a = str;
        this.f30490b = str2;
        this.f30491c = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        bundle.putString("consent_string", this.f30489a);
        bundle.putString("fc_consent", this.f30490b);
        Bundle bundle2 = this.f30491c;
        if (bundle2 != null) {
            bundle.putBundle("iab_consent_info", bundle2);
        }
    }
}
