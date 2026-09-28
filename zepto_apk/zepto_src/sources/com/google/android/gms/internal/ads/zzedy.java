package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
final class zzedy implements zzddq {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29163a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcbw f29164b;

    public zzedy(Context context, zzcbw zzcbwVar) {
        this.f29163a = context;
        this.f29164b = zzcbwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void F(zzfic zzficVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String str = zzficVar.f31194b.f31190b.f31170e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzcbw zzcbwVar = this.f29164b;
        Context context = this.f29163a;
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzficVar.f31193a.f31185a.f31216d;
        zzcbwVar.getClass();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.N0)).booleanValue() && zzcbwVar.a(context) && zzcbw.g(context)) {
            synchronized (zzcbwVar.f25871i) {
            }
        }
        zzcbwVar.h(context, "_aq", str, null);
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void R(zzbza zzbzaVar) {
    }
}
