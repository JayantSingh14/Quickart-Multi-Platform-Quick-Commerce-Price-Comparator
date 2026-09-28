package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzcqi implements zzcpq {

    /* renamed from: a, reason: collision with root package name */
    public final zzfhq f26894a;

    public zzcqi(zzfhq zzfhqVar) {
        this.f26894a = zzfhqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcpq
    public final void a(HashMap map) {
        String str = (String) map.get("render_in_browser");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f26894a.a(Boolean.parseBoolean(str));
        } catch (Exception e2) {
            throw new IllegalStateException("Invalid render_in_browser state", e2);
        }
    }
}
