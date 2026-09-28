package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes4.dex */
final class zzcqd implements zzcpq {
    @Override // com.google.android.gms.internal.ads.zzcpq
    public final void a(HashMap map) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ab)).booleanValue() || map.isEmpty()) {
            return;
        }
        String str = (String) map.get("is_topics_ad_personalization_allowed");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.C.f21684h.g().r(Boolean.parseBoolean(str));
    }
}
