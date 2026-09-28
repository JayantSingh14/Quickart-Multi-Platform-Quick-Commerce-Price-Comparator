package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzbmc implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final zzbmd f25318a;

    public zzbmc(zzbmd zzbmdVar) {
        this.f25318a = zzbmdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzbmd zzbmdVar = this.f25318a;
        if (zzbmdVar == null) {
            return;
        }
        String str = (String) map.get(CLConstants.FIELD_PAY_INFO_NAME);
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundleH = null;
        if (map.containsKey("info")) {
            try {
                bundleH = com.google.android.gms.ads.internal.util.zzbp.h(new JSONObject((String) map.get("info")));
            } catch (JSONException e2) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Failed to convert ad metadata to JSON.", e2);
            }
        }
        if (bundleH != null) {
            zzbmdVar.T(bundleH, str);
        } else {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Failed to convert ad metadata to Bundle.");
        }
    }
}
