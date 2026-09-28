package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.authorization.RegionUtil;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdwy {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f28712a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcdf f28713b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfik f28714c;

    /* renamed from: d, reason: collision with root package name */
    public final zzayq f28715d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f28716e = new Bundle();

    public zzdwy(Context context, zzdxj zzdxjVar, zzcdf zzcdfVar, zzfik zzfikVar, String str, String str2, zzayq zzayqVar) {
        ActivityManager.MemoryInfo memoryInfoJ;
        zzdxjVar.getClass();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzdxjVar.f28748a);
        this.f28712a = concurrentHashMap;
        this.f28713b = zzcdfVar;
        this.f28714c = zzfikVar;
        this.f28715d = zzayqVar;
        concurrentHashMap.put("ad_format", str2.toUpperCase(Locale.ROOT));
        c();
        zzbgb zzbgbVar = zzbgk.z2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if (zBooleanValue) {
            Runtime runtime = Runtime.getRuntime();
            b("rt_f", String.valueOf(runtime.freeMemory()));
            b("rt_m", String.valueOf(runtime.maxMemory()));
            b("rt_t", String.valueOf(runtime.totalMemory()));
            b("wv_c", String.valueOf(com.google.android.gms.ads.internal.zzt.C.f21684h.f25941k.get()));
            if (((Boolean) zzbgiVar.a(zzbgk.H2)).booleanValue() && (memoryInfoJ = com.google.android.gms.ads.internal.util.client.zzf.j(context)) != null) {
                b("mem_avl", String.valueOf(memoryInfoJ.availMem));
                b("mem_tt", String.valueOf(memoryInfoJ.totalMem));
                b("low_m", true != memoryInfoJ.lowMemory ? "0" : "1");
            }
        }
        if (((Boolean) zzbgiVar.a(zzbgk.J2)).booleanValue()) {
            b("ad_unit_id", zzfikVar.f31219g);
        }
        if (((Boolean) zzbgiVar.a(zzbgk.D7)).booleanValue()) {
            int iE = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.e(zzfikVar) - 1;
            if (iE == 0) {
                concurrentHashMap.put("request_id", str);
                concurrentHashMap.put("scar", "false");
                return;
            }
            if (iE == 1) {
                concurrentHashMap.put("request_id", str);
                concurrentHashMap.put("se", "query_g");
            } else if (iE == 2) {
                concurrentHashMap.put("se", "r_adinfo");
            } else if (iE != 3) {
                concurrentHashMap.put("se", "r_both");
            } else {
                concurrentHashMap.put("se", "r_adstring");
            }
            concurrentHashMap.put("scar", "true");
            com.google.android.gms.ads.internal.client.zzm zzmVar = zzfikVar.f31216d;
            b("ragent", zzmVar.p);
            b("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzaa.a(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.b(zzmVar)));
        }
    }

    public final void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("cnt")) {
            b("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            b("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f28712a.put(str, str2);
    }

    public final void c() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ha)).booleanValue()) {
            zzayl zzaylVar = this.f28715d.f24512b;
            boolean z = zzaylVar instanceof com.google.android.gms.ads.internal.zzk;
            ConcurrentHashMap concurrentHashMap = this.f28712a;
            if (z) {
                int i2 = ((com.google.android.gms.ads.internal.zzk) zzaylVar).o;
                int i3 = i2 - 1;
                if (i2 == 0) {
                    throw null;
                }
                concurrentHashMap.put("asv", i3 != 0 ? "2" : "1");
                return;
            }
            if (!(zzaylVar instanceof zzclf)) {
                concurrentHashMap.put("asv", RegionUtil.REGION_STRING_NA);
                return;
            }
            zzgct zzgctVar = (zzgct) ((zzclf) zzaylVar).f26503b.f32141a.f32122b.f32307f.get();
            int iZzg = (zzgctVar == null ? 1 : zzgctVar.zzg()) - 1;
            concurrentHashMap.put("asv", iZzg != 1 ? iZzg != 2 ? iZzg != 3 ? "uns" : "3.0" : "2.0" : CLConstants.ARQC_VERSION);
        }
    }
}
