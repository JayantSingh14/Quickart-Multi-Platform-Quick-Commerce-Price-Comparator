package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbog implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final zzdja f25387a;

    public zzbog(zzdja zzdjaVar) {
        this.f25387a = zzdjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws NumberFormatException {
        String str = (String) map.get("action");
        boolean zEquals = "grant".equals(str);
        zzdja zzdjaVar = this.f25387a;
        if (!zEquals) {
            if ("video_start".equals(str)) {
                zzdjaVar.g();
                return;
            } else {
                if ("video_complete".equals(str)) {
                    zzdjaVar.zzc();
                    return;
                }
                return;
            }
        }
        zzbzy zzbzyVar = null;
        try {
            int i2 = Integer.parseInt((String) map.get(PaymentConstants.AMOUNT));
            String str2 = (String) map.get("type");
            if (!TextUtils.isEmpty(str2)) {
                zzbzyVar = new zzbzy(str2, i2);
            }
        } catch (NumberFormatException e2) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Unable to parse reward amount.", e2);
        }
        zzdjaVar.P(zzbzyVar);
    }
}
