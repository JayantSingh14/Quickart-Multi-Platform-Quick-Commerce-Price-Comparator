package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzesx implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30257a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f30258b;

    public zzesx(String str, boolean z) {
        this.f30257a = str;
        this.f30258b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzczm zzczmVar = (zzczm) obj;
        String str = this.f30257a;
        if (str != null) {
            Bundle bundleA = zzfiz.a(zzczmVar.f27481a, "pii");
            bundleA.putString("afai", str);
            bundleA.putBoolean("is_afai_lat", this.f30258b);
        }
    }
}
