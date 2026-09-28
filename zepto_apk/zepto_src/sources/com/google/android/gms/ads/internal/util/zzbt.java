package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzfoz;

/* loaded from: classes4.dex */
public final class zzbt extends zzb {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.client.zzu f21541b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21542c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.client.zzv f21543d;

    public zzbt(Context context, String str, String str2, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.f21541b = new com.google.android.gms.ads.internal.util.client.zzu(context, com.google.android.gms.ads.internal.zzt.C.f21679c.E(context, str));
        this.f21542c = str2;
        this.f21543d = zzvVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void a() {
        String str = this.f21542c;
        com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.f21543d;
        if (zzvVar == null) {
            this.f21541b.b(str, null);
        } else {
            new zzfoz(zzvVar.f21451a, this.f21541b, zzcdo.f25986e, null, null).a(str);
        }
    }
}
