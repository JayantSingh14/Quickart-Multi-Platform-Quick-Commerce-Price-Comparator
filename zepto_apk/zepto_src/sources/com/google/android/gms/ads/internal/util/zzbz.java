package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzbz {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f21551a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f21552b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final Context f21553c;

    public zzbz(Context context) {
        this.f21553c = context;
    }

    public final void a() {
        zzbgb zzbgbVar = zzbgk.Ab;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            final HashMap mapT = zzs.T((String) zzbdVar.f21153c.a(zzbgk.Fb));
            for (String str : mapT.keySet()) {
                synchronized (this) {
                    try {
                        HashMap map = this.f21551a;
                        if (!map.containsKey(str)) {
                            SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.f21553c) : this.f21553c.getSharedPreferences(str, 0);
                            zzbw zzbwVar = new zzbw(this, str);
                            map.put(str, zzbwVar);
                            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzbwVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            zzbx zzbxVar = new zzbx() { // from class: com.google.android.gms.ads.internal.util.zzby
                @Override // com.google.android.gms.ads.internal.util.zzbx
                public final void a(String str2, String str3) {
                    HashMap map2 = mapT;
                    if (map2.containsKey(str2) && ((Set) map2.get(str2)).contains(str3)) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.g().r(false);
                    }
                }
            };
            synchronized (this) {
                this.f21552b.add(zzbxVar);
            }
        }
    }
}
