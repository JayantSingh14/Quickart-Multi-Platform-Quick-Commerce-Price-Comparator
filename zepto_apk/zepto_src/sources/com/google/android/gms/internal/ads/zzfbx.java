package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfbx implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f30826a;

    public zzfbx(ArrayList arrayList) {
        this.f30826a = arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) throws JSONException {
        try {
            ((JSONObject) obj).put("eid", TextUtils.join(",", this.f30826a));
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zze.k("Failed putting experiment ids.");
        }
    }
}
