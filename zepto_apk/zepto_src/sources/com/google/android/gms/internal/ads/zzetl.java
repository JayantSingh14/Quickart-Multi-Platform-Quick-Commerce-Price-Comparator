package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class zzetl implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30282a;

    /* renamed from: b, reason: collision with root package name */
    public final int f30283b;

    public zzetl(String str, int i2) {
        this.f30282a = str;
        this.f30283b = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        int i2;
        Bundle bundle = ((zzczm) obj).f27481a;
        String str = this.f30282a;
        if (TextUtils.isEmpty(str) || (i2 = this.f30283b) == -1) {
            return;
        }
        Bundle bundleA = zzfiz.a(bundle, "pii");
        bundle.putBundle("pii", bundleA);
        bundleA.putString("pvid", str);
        bundleA.putInt("pvid_s", i2);
    }
}
