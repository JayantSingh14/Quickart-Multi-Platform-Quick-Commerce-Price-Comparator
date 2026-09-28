package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzeyg implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f30573a;

    public zzeyg(HashMap map) {
        this.f30573a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) throws JSONException {
        zzczm zzczmVar = (zzczm) obj;
        HashMap map = this.f30573a;
        if (map.isEmpty()) {
            return;
        }
        Bundle bundle = zzczmVar.f27481a;
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : map.entrySet()) {
            ArrayDeque arrayDeque = (ArrayDeque) entry.getValue();
            if (!arrayDeque.isEmpty()) {
                zzdyk zzdykVar = (zzdyk) entry.getKey();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, zzdykVar.a());
                    jSONObject.put("event_type", zzdykVar.b());
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put((Long) it.next());
                    }
                    jSONObject.put("timestamps", jSONArray2);
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    com.google.android.gms.ads.internal.util.zze.l("Failed putting the on-device storage record.", e2);
                }
            }
        }
        if (jSONArray.length() > 0) {
            bundle.putString("on_device_storage_records", jSONArray.toString());
        }
    }
}
