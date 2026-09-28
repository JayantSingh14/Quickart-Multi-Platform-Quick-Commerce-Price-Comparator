package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes4.dex */
final class zzbmt implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzcir zzcirVar = (zzcir) obj;
        try {
            JSONArray jSONArray = new JSONArray((String) map.get("args"));
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(zzcirVar.getContext()).edit();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                editorEdit.remove(jSONArray.getString(i2));
            }
            editorEdit.apply();
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("GMSG clear local storage keys handler", e2);
        }
    }
}
