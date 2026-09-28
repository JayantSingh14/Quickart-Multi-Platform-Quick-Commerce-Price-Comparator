package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class zzfqb extends com.google.android.gms.ads.internal.client.zzcj {

    /* renamed from: a, reason: collision with root package name */
    public final zzfqh f31618a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfpu f31619b;

    public zzfqb(zzfqh zzfqhVar, zzfpu zzfpuVar) {
        this.f31618a = zzfqhVar;
        this.f31619b = zzfpuVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e4, code lost:
    
        r6 = 0;
        r8 = com.google.android.gms.ads.internal.util.client.zzf.f21413b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ef, code lost:
    
        if (r0.containsKey(r5) == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f1, code lost:
    
        r6 = r0.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
    
        r0.put((java.util.EnumMap) r5, (com.google.android.gms.ads.AdFormat) java.lang.Integer.valueOf(((java.lang.Integer) r6).intValue() + 1));
        r3.a(r3.f21242d, r1.f31634h.currentTimeMillis(), new com.google.android.gms.internal.ads.zzfqk(new com.google.android.gms.internal.ads.zzfqj(r4, r5)), "1");
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:4:0x0003, B:35:0x0090, B:36:0x009f, B:38:0x00a5, B:41:0x00bd, B:43:0x00c1, B:44:0x00c8, B:45:0x00d1, B:50:0x00e3, B:51:0x00e4, B:53:0x00f1, B:54:0x00f5, B:63:0x0124, B:64:0x0125, B:7:0x000e, B:9:0x0012, B:21:0x0032, B:24:0x0037, B:26:0x003d, B:29:0x0042, B:34:0x0084, B:32:0x004e, B:33:0x006d, B:10:0x0013, B:12:0x0017, B:18:0x002f, B:17:0x0028, B:46:0x00d2, B:48:0x00dd, B:49:0x00de, B:61:0x0122), top: B:69:0x0003, inners: #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:4:0x0003, B:35:0x0090, B:36:0x009f, B:38:0x00a5, B:41:0x00bd, B:43:0x00c1, B:44:0x00c8, B:45:0x00d1, B:50:0x00e3, B:51:0x00e4, B:53:0x00f1, B:54:0x00f5, B:63:0x0124, B:64:0x0125, B:7:0x000e, B:9:0x0012, B:21:0x0032, B:24:0x0037, B:26:0x003d, B:29:0x0042, B:34:0x0084, B:32:0x004e, B:33:0x006d, B:10:0x0013, B:12:0x0017, B:18:0x002f, B:17:0x0028, B:46:0x00d2, B:48:0x00dd, B:49:0x00de, B:61:0x0122), top: B:69:0x0003, inners: #1, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Xb(java.util.ArrayList r12, com.google.android.gms.ads.internal.client.zzce r13) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfqb.Xb(java.util.ArrayList, com.google.android.gms.ads.internal.client.zzce):void");
    }

    public final boolean Yb(String str) {
        boolean zE;
        zzfqh zzfqhVar = this.f31618a;
        synchronized (zzfqhVar) {
            zE = zzfqhVar.e(str, AdFormat.REWARDED);
        }
        return zE;
    }

    public final zzcaf Zb(String str) {
        zzcaf zzcafVar;
        zzfqh zzfqhVar = this.f31618a;
        synchronized (zzfqhVar) {
            zzcafVar = (zzcaf) zzfqhVar.f(AdFormat.REWARDED, zzcaf.class, str);
        }
        return zzcafVar;
    }

    public final boolean ac(String str) {
        boolean zE;
        zzfqh zzfqhVar = this.f31618a;
        synchronized (zzfqhVar) {
            zE = zzfqhVar.e(str, AdFormat.APP_OPEN_AD);
        }
        return zE;
    }

    public final zzbed bc(String str) {
        zzbed zzbedVar;
        zzfqh zzfqhVar = this.f31618a;
        synchronized (zzfqhVar) {
            zzbedVar = (zzbed) zzfqhVar.f(AdFormat.APP_OPEN_AD, zzbed.class, str);
        }
        return zzbedVar;
    }

    public final boolean cc(String str) {
        boolean zE;
        zzfqh zzfqhVar = this.f31618a;
        synchronized (zzfqhVar) {
            zE = zzfqhVar.e(str, AdFormat.INTERSTITIAL);
        }
        return zE;
    }

    public final com.google.android.gms.ads.internal.client.zzbx dc(String str) {
        com.google.android.gms.ads.internal.client.zzbx zzbxVar;
        zzfqh zzfqhVar = this.f31618a;
        synchronized (zzfqhVar) {
            zzbxVar = (com.google.android.gms.ads.internal.client.zzbx) zzfqhVar.f(AdFormat.INTERSTITIAL, com.google.android.gms.ads.internal.client.zzbx.class, str);
        }
        return zzbxVar;
    }

    public final boolean ec(String str, com.google.android.gms.ads.internal.client.zzft zzftVar, com.google.android.gms.ads.internal.client.zzch zzchVar) {
        zzfqy zzfqyVarB;
        zzfpu zzfpuVar = this.f31619b;
        synchronized (zzfpuVar) {
            try {
                if (!zzfpuVar.f31595f.getAndSet(true)) {
                    if (zzfpuVar.f31594e == null) {
                        synchronized (zzfpuVar) {
                            if (zzfpuVar.f31594e == null) {
                                try {
                                    zzfpuVar.f31594e = (ConnectivityManager) zzfpuVar.f31593d.getSystemService("connectivity");
                                } catch (ClassCastException e2) {
                                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                    com.google.android.gms.ads.internal.util.client.zzo.g("Failed to get connectivity manager", e2);
                                }
                            }
                        }
                    }
                    if (!PlatformVersion.isAtLeastO() || zzfpuVar.f31594e == null) {
                        zzfpuVar.f31597h = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.I)).intValue());
                    } else {
                        try {
                            zzfpuVar.f31594e.registerDefaultNetworkCallback(new zzfps(zzfpuVar));
                        } catch (RuntimeException e3) {
                            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.g("Failed to register network callback", e3);
                            zzfpuVar.f31597h = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.I)).intValue());
                        }
                    }
                    com.google.android.gms.ads.internal.zzt.C.f21683g.b(new zzfpt(zzfpuVar));
                }
                AdFormat adFormatA = AdFormat.a(zzftVar.f21240b);
                if (adFormatA != null) {
                    HashMap map = zzfpuVar.f31590a;
                    if (map.containsKey(adFormatA) && !((Map) map.get(adFormatA)).containsKey(str) && zzfpuVar.d(adFormatA) && (zzfqyVarB = zzfpuVar.f31591b.b(str, zzftVar, zzchVar)) != null) {
                        AtomicInteger atomicInteger = zzfpuVar.f31597h;
                        if (atomicInteger != null) {
                            zzfqyVarB.n(atomicInteger.get());
                        }
                        zzfqd zzfqdVar = zzfpuVar.f31592c;
                        zzfqyVarB.r = zzfqdVar;
                        zzfpp zzfppVar = zzfpuVar.f31598i;
                        if (zzfppVar != null) {
                            zzfppVar.d(str, adFormatA, zzfqyVarB);
                        } else {
                            synchronized (zzfqyVarB) {
                                zzfqyVarB.n.submit(new zzfqo(zzfqyVarB));
                            }
                        }
                        ((Map) map.get(adFormatA)).put(str, zzfqyVarB);
                        zzfqj zzfqjVar = new zzfqj(zzftVar.f21239a, adFormatA);
                        zzfqjVar.f31642c = str;
                        zzfqdVar.a(zzftVar.f21242d, zzfpuVar.f31596g.currentTimeMillis(), new zzfqk(zzfqjVar), "2");
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean fc(int i2, String str) {
        AdFormat adFormatA = AdFormat.a(i2);
        if (adFormatA == null) {
            return false;
        }
        zzfpu zzfpuVar = this.f31619b;
        synchronized (zzfpuVar) {
            try {
                Clock clock = zzfpuVar.f31596g;
                long jCurrentTimeMillis = clock.currentTimeMillis();
                HashMap map = zzfpuVar.f31590a;
                if (!map.containsKey(adFormatA)) {
                    return false;
                }
                zzfqy zzfqyVar = (zzfqy) ((Map) map.get(adFormatA)).get(str);
                zzfqk zzfqkVar = null;
                String strM = zzfqyVar == null ? null : zzfqyVar.m();
                boolean z = strM != null && adFormatA.equals(zzfqyVar.o());
                Long lValueOf = z ? Long.valueOf(clock.currentTimeMillis()) : null;
                if (zzfqyVar != null) {
                    zzfqj zzfqjVar = new zzfqj(zzfqyVar.f31671e.f21239a, adFormatA);
                    zzfqjVar.f31642c = str;
                    zzfqkVar = new zzfqk(zzfqjVar);
                }
                zzfpuVar.f31592c.c(zzfqyVar == null ? 0 : zzfqyVar.f31671e.f21242d, zzfqyVar != null ? zzfqyVar.p() : 0, jCurrentTimeMillis, lValueOf, strM, zzfqkVar, "2");
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final com.google.android.gms.ads.internal.client.zzbx gc(String str) {
        com.google.android.gms.ads.internal.client.zzbx zzbxVar;
        zzfpu zzfpuVar = this.f31619b;
        synchronized (zzfpuVar) {
            zzbxVar = (com.google.android.gms.ads.internal.client.zzbx) zzfpuVar.c(AdFormat.INTERSTITIAL, com.google.android.gms.ads.internal.client.zzbx.class, str);
        }
        return zzbxVar;
    }

    public final zzbed hc(String str) {
        zzbed zzbedVar;
        zzfpu zzfpuVar = this.f31619b;
        synchronized (zzfpuVar) {
            zzbedVar = (zzbed) zzfpuVar.c(AdFormat.APP_OPEN_AD, zzbed.class, str);
        }
        return zzbedVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void i0(int i2) {
        zzfpu zzfpuVar = this.f31619b;
        synchronized (zzfpuVar) {
            try {
                AdFormat adFormatA = AdFormat.a(i2);
                if (adFormatA != null) {
                    HashMap map = zzfpuVar.f31590a;
                    if (map.containsKey(adFormatA)) {
                        Map map2 = (Map) map.get(adFormatA);
                        int size = map2.size();
                        for (String str : map2.keySet()) {
                            zzfqy zzfqyVar = (zzfqy) map2.get(str);
                            if (zzfqyVar != null) {
                                zzfqyVar.f31673g.set(false);
                                zzfqyVar.p.set(false);
                                zzfpp zzfppVar = zzfpuVar.f31598i;
                                if (zzfppVar != null) {
                                    zzfppVar.e(str, adFormatA);
                                }
                                synchronized (zzfqyVar) {
                                    zzfqyVar.f31676j.clear();
                                }
                                String strValueOf = String.valueOf(str);
                                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                com.google.android.gms.ads.internal.util.client.zzo.e("Destroyed ad preloader for preloadId: ".concat(strValueOf));
                            }
                        }
                        map2.clear();
                        String strConcat = "Destroyed all ad preloaders for ad format: ".concat(adFormatA.toString());
                        int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.e(strConcat);
                        zzfpuVar.f31592c.f("pda", zzfpuVar.f31596g.currentTimeMillis(), null, null, adFormatA, -1, -1, size);
                    }
                }
            } finally {
            }
        }
    }

    public final zzcaf ic(String str) {
        zzcaf zzcafVar;
        zzfpu zzfpuVar = this.f31619b;
        synchronized (zzfpuVar) {
            zzcafVar = (zzcaf) zzfpuVar.c(AdFormat.REWARDED, zzcaf.class, str);
        }
        return zzcafVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void W9(zzbsv zzbsvVar) {
    }
}
