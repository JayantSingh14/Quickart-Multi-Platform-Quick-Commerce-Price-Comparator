package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.lang3.ClassUtils;

@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes4.dex */
public final class zzbgz {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f25048a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f25049b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f25050c;

    public zzbgz(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f25049b = linkedHashMap;
        this.f25050c = new Object();
        linkedHashMap.put("action", "make_wv");
        linkedHashMap.put("ad_format", str);
    }

    public final void a(zzbgw zzbgwVar, long j2, String... strArr) {
        synchronized (this.f25050c) {
            this.f25048a.add(new zzbgw(j2, strArr[0], zzbgwVar));
        }
    }

    public final zzbgy b() {
        zzbgy zzbgyVar;
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l2)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap map = new HashMap();
        synchronized (this.f25050c) {
            try {
                LinkedList<zzbgw> linkedList = this.f25048a;
                for (zzbgw zzbgwVar : linkedList) {
                    long j2 = zzbgwVar.f25041a;
                    String str = zzbgwVar.f25042b;
                    zzbgw zzbgwVar2 = zzbgwVar.f25043c;
                    if (zzbgwVar2 != null && j2 > 0) {
                        long j3 = j2 - zzbgwVar2.f25041a;
                        sb.append(str);
                        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                        sb.append(j3);
                        sb.append(',');
                        if (zBooleanValue) {
                            if (map.containsKey(Long.valueOf(zzbgwVar2.f25041a))) {
                                StringBuilder sb2 = (StringBuilder) map.get(Long.valueOf(zzbgwVar2.f25041a));
                                sb2.append('+');
                                sb2.append(str);
                            } else {
                                map.put(Long.valueOf(zzbgwVar2.f25041a), new StringBuilder(str));
                            }
                        }
                    }
                }
                linkedList.clear();
                String string = null;
                if (!TextUtils.isEmpty(null)) {
                    sb.append((String) null);
                } else if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
                StringBuilder sb3 = new StringBuilder();
                if (zBooleanValue) {
                    for (Map.Entry entry : map.entrySet()) {
                        sb3.append((CharSequence) entry.getValue());
                        sb3.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                        long jLongValue = ((Long) entry.getKey()).longValue();
                        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                        sb3.append(zztVar.f21687k.currentTimeMillis() + (jLongValue - zztVar.f21687k.elapsedRealtime()));
                        sb3.append(',');
                    }
                    if (sb3.length() > 0) {
                        sb3.setLength(sb3.length() - 1);
                    }
                    string = sb3.toString();
                }
                zzbgyVar = new zzbgy(sb.toString(), string);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbgyVar;
    }

    public final void c(String str, String str2) {
        zzbgp zzbgpVarA;
        if (TextUtils.isEmpty(str2) || (zzbgpVarA = com.google.android.gms.ads.internal.zzt.C.f21684h.a()) == null) {
            return;
        }
        synchronized (this.f25050c) {
            zzbgv zzbgvVar = (zzbgv) zzbgpVarA.f25031c.get(str);
            if (zzbgvVar == null) {
                zzbgvVar = zzbgv.f25038a;
            }
            LinkedHashMap linkedHashMap = this.f25049b;
            linkedHashMap.put(str, zzbgvVar.a((String) linkedHashMap.get(str), str2));
        }
    }
}
