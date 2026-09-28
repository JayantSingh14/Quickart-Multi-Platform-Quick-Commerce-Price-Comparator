package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class zzcbx {

    /* renamed from: a, reason: collision with root package name */
    public static zzcbx f25872a;

    public static synchronized zzcbx b(Context context) {
        try {
            zzcbx zzcbxVar = f25872a;
            if (zzcbxVar != null) {
                return zzcbxVar;
            }
            Context applicationContext = context.getApplicationContext();
            zzbgk.a(applicationContext);
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            com.google.android.gms.ads.internal.util.zzj zzjVarG = zztVar.f21684h.g();
            zzjVarG.f(applicationContext);
            zzcbr zzcbrVar = new zzcbr();
            applicationContext.getClass();
            zzcbrVar.f25848a = applicationContext;
            Clock clock = zztVar.f21687k;
            clock.getClass();
            zzcbrVar.f25849b = clock;
            zzcbrVar.f25850c = zzjVarG;
            zzcbrVar.f25851d = zztVar.y;
            zzcbx zzcbxVarA = zzcbrVar.a();
            f25872a = zzcbxVarA;
            zzcbl zzcblVar = (zzcbl) ((zzcbs) zzcbxVarA).f25853c.zzb();
            SharedPreferences sharedPreferences = zzcblVar.f25834b;
            sharedPreferences.registerOnSharedPreferenceChangeListener(zzcblVar);
            zzcblVar.onSharedPreferenceChanged(sharedPreferences, "gad_has_consent_for_cookies");
            zzbgb zzbgbVar = zzbgk.W0;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                zzcblVar.onSharedPreferenceChanged(sharedPreferences, "IABTCF_TCString");
            } else {
                zzcblVar.onSharedPreferenceChanged(sharedPreferences, "IABTCF_PurposeConsents");
            }
            final zzccc zzcccVar = (zzccc) ((zzcbs) f25872a).f25855e.zzb();
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.Q0)).booleanValue()) {
                final HashMap mapT = com.google.android.gms.ads.internal.util.zzs.T((String) zzbdVar.f21153c.a(zzbgk.R0));
                Iterator it = mapT.keySet().iterator();
                while (it.hasNext()) {
                    zzcccVar.a((String) it.next());
                }
                zzcca zzccaVar = new zzcca() { // from class: com.google.android.gms.internal.ads.zzccb
                    @Override // com.google.android.gms.internal.ads.zzcca
                    public final void a(String str, String str2) {
                        zzccc zzcccVar2 = zzcccVar;
                        zzcccVar2.getClass();
                        HashMap map = mapT;
                        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
                            zzcbp zzcbpVar = zzcccVar2.f25880d;
                            zzcbpVar.f25845b.a(-1, zzcbpVar.f25844a.currentTimeMillis());
                        }
                    }
                };
                synchronized (zzcccVar) {
                    zzcccVar.f25878b.add(zzccaVar);
                }
            }
            return f25872a;
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract zzcbp a();
}
