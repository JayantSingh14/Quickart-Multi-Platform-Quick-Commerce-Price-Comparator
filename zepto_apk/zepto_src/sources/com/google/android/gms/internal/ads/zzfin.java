package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfin {

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f31227a;

    public zzfin(JSONObject jSONObject) {
        this.f31227a = jSONObject;
    }

    public final int a() {
        int iOptInt = this.f31227a.optInt("media_type", -1);
        if (iOptInt != 0) {
            return iOptInt != 1 ? 3 : 1;
        }
        return 2;
    }
}
