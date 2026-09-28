package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzcqo implements zzcpq {

    /* renamed from: a, reason: collision with root package name */
    public final zzeak f26900a;

    public zzcqo(zzeak zzeakVar) {
        this.f26900a = zzeakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcpq
    public final void a(HashMap map) throws JSONException {
        String str = (String) map.get("test_mode_enabled");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f26900a.b(str.equals("true"));
    }
}
