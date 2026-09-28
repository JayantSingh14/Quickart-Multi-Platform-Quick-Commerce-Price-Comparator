package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzbnv implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final zzdyh f25363a;

    public zzbnv(zzdyh zzdyhVar) {
        this.f25363a = zzdyhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) throws NumberFormatException {
        if (map == null || !map.containsKey(CLConstants.SHARED_PREFERENCE_ITEM_ID) || TextUtils.isEmpty((CharSequence) map.get(CLConstants.SHARED_PREFERENCE_ITEM_ID)) || !map.containsKey("event_type") || TextUtils.isEmpty((CharSequence) map.get("event_type"))) {
            com.google.android.gms.ads.internal.util.zze.k("Ignoring onDeviceStorageEvent GMSG: missing required parameters.");
            return;
        }
        try {
            long j2 = Long.parseLong((String) map.get(CLConstants.SHARED_PREFERENCE_ITEM_ID));
            int i2 = Integer.parseInt((String) map.get("event_type"));
            this.f25363a.a(j2, com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis(), i2);
        } catch (NumberFormatException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Ignoring onDeviceStorageEvent GMSG: invalid number format for ID or eventType.", e2);
        }
    }
}
