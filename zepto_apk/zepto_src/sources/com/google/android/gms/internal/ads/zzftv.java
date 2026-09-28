package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzftv extends zzftq {
    @Override // com.google.android.gms.internal.ads.zzftr, android.os.AsyncTask
    /* renamed from: a */
    public final void onPostExecute(String str) {
        zzfsf zzfsfVar;
        if (!TextUtils.isEmpty(str) && (zzfsfVar = zzfsf.f31780c) != null) {
            for (zzfrl zzfrlVar : Collections.unmodifiableCollection(zzfsfVar.f31781a)) {
                if (this.f31851c.contains(zzfrlVar.f31724g)) {
                    zzfsv zzfsvVar = zzfrlVar.f31721d;
                    if (this.f31853e >= zzfsvVar.f31812c) {
                        zzfsvVar.f31813d = 2;
                        zzfsm.f31796a.a(zzfsvVar.c(), "setNativeViewHierarchy", str, zzfsvVar.f31810a);
                    }
                }
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        zzftj zzftjVar = this.f31855b;
        JSONObject jSONObject = zzftjVar.f31837a;
        JSONObject jSONObject2 = this.f31852d;
        if (zzftb.e(jSONObject2, jSONObject)) {
            return null;
        }
        zzftjVar.f31837a = jSONObject2;
        return jSONObject2.toString();
    }
}
