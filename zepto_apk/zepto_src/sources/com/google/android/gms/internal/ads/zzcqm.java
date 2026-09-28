package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzcqm implements zzcpq {

    /* renamed from: a, reason: collision with root package name */
    public final CookieManager f26898a = com.google.android.gms.ads.internal.zzt.C.f21682f.h();

    public zzcqm(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcpq
    public final void a(HashMap map) {
        CookieManager cookieManager = this.f26898a;
        if (cookieManager == null) {
            return;
        }
        if (((String) map.get("clear")) == null) {
            String str = (String) map.get("cookie");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            cookieManager.setCookie((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.j1), str);
            return;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.j1);
        String cookie = cookieManager.getCookie(str2);
        if (cookie != null) {
            List listD = zzgqp.a(new zzgpl(';')).d(cookie);
            for (int i2 = 0; i2 < listD.size(); i2++) {
                Iterator it = ((zzgqj) zzgqp.a(new zzgpl('=')).c((String) listD.get(i2))).iterator();
                if (!it.hasNext()) {
                    StringBuilder sb = new StringBuilder(String.valueOf(0).length() + 70);
                    sb.append("position (0) must be less than the number of elements that remained (0)");
                    throw new IndexOutOfBoundsException(sb.toString());
                }
                cookieManager.setCookie(str2, String.valueOf((String) it.next()).concat(String.valueOf((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.V0))));
            }
        }
    }
}
