package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzhja {

    /* renamed from: b, reason: collision with root package name */
    public static final zzhja f33878b = new zzhja();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f33879a = new HashMap();

    public final synchronized void a(String str, zzhan zzhanVar) {
        try {
            HashMap map = this.f33879a;
            if (!map.containsKey(str)) {
                map.put(str, zzhanVar);
                return;
            }
            if (((zzhan) map.get(str)).equals(zzhanVar)) {
                return;
            }
            String strValueOf = String.valueOf(map.get(str));
            String strValueOf2 = String.valueOf(zzhanVar);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45 + strValueOf.length() + 17 + strValueOf2.length());
            sb.append("Parameters object with name ");
            sb.append(str);
            sb.append(" already exists (");
            sb.append(strValueOf);
            sb.append("), cannot insert ");
            sb.append(strValueOf2);
            throw new GeneralSecurityException(sb.toString());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            a((String) entry.getKey(), (zzhan) entry.getValue());
        }
    }
}
