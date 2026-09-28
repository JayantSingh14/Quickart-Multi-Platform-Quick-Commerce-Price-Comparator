package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzear implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f28964a = new JSONObject();

    /* renamed from: b, reason: collision with root package name */
    public List f28965b;

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) throws JSONException {
        if (str != null && this.f28965b.contains(str)) {
            try {
                Object obj = sharedPreferences.getAll().get(str);
                JSONObject jSONObject = this.f28964a;
                if (obj == null) {
                    jSONObject.remove(str);
                } else {
                    jSONObject.put(str, obj);
                }
            } catch (JSONException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.e("InspectorSharedPreferenceCollector.onSharedPreferenceChanged", e2);
            }
        }
    }
}
