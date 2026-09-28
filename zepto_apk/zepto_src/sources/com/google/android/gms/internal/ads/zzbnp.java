package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbnp implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final zzbnq f25351a;

    public zzbnp(zzbnq zzbnqVar) {
        this.f25351a = zzbnqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws NumberFormatException {
        zzcir zzcirVar = (zzcir) obj;
        boolean zEquals = "1".equals(map.get("transparentBackground"));
        boolean zEquals2 = "1".equals(map.get("blur"));
        float f2 = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f2 = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Fail to parse float", e2);
        }
        zzbnq zzbnqVar = this.f25351a;
        synchronized (zzbnqVar) {
            zzbnqVar.f25352a = zEquals;
            zzbnqVar.f25355d.set(true);
        }
        synchronized (zzbnqVar) {
            zzbnqVar.f25353b = zEquals2;
            zzbnqVar.f25354c = f2;
        }
        zzcirVar.f0(zEquals);
    }
}
