package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzbmn implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzgnu zzgnuVar;
        com.google.android.gms.ads.internal.overlay.zzz zzzVar = com.google.android.gms.ads.internal.zzt.C.s;
        if (!zzzVar.f21398e || (zzgnuVar = zzzVar.f21397d) == null) {
            com.google.android.gms.ads.internal.util.zze.k("LastMileDelivery not connected");
        } else {
            ((zzgnw) zzgnuVar).f33001a.a(zzzVar.e(), zzzVar.f21399f, 2);
            zzzVar.d("onLMDOverlayCollapse", new HashMap());
        }
    }
}
