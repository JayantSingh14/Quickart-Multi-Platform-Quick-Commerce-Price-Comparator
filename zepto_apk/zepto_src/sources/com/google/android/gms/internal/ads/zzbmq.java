package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzbmq implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzcir zzcirVar = (zzcir) obj;
        try {
            String str = (String) map.get("enabled");
            zzbnn zzbnnVar = zzbnm.f25337a;
            if (!zzgpj.d(str, "true") && !zzgpj.d(str, "false")) {
                return;
            }
            zzfzg zzfzgVarA = zzfzg.a(zzcirVar.getContext());
            boolean z = Boolean.parseBoolean(str);
            zzfzgVarA.getClass();
            synchronized (zzfzg.class) {
                zzfzgVarA.f32090a.a(Boolean.valueOf(z), "paidv2_user_option");
            }
        } catch (IOException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled", e2);
        }
    }
}
