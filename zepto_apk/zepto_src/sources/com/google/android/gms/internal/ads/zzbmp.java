package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzbmp implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzcir zzcirVar = (zzcir) obj;
        try {
            zzfzj.f(zzcirVar.getContext()).h();
            zzfzk.f(zzcirVar.getContext()).h();
            zzfzl.a(zzcirVar.getContext()).b();
        } catch (IOException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("DefaultGmsgHandlers.ResetPaid", e2);
        }
    }
}
