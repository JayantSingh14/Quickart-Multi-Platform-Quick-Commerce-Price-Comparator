package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class zzfas implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30770a;

    /* renamed from: b, reason: collision with root package name */
    public final int f30771b;

    public /* synthetic */ zzfas(String str, int i2) {
        this.f30770a = str;
        this.f30771b = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final void zza(Object obj) {
        zzczm zzczmVar = (zzczm) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ab)).booleanValue()) {
            String str = this.f30770a;
            boolean zIsEmpty = TextUtils.isEmpty(str);
            Bundle bundle = zzczmVar.f27481a;
            if (!zIsEmpty) {
                bundle.putString("topics", str);
            }
            int i2 = this.f30771b;
            if (i2 != -1) {
                bundle.putInt("atps", i2);
            }
        }
    }
}
