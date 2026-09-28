package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import androidx.collection.internal.LruHashMap;
import com.google.android.gms.common.internal.Preconditions;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class zzhs extends zzor implements zzak {

    /* renamed from: d, reason: collision with root package name */
    public final ArrayMap f39050d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayMap f39051e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayMap f39052f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayMap f39053g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayMap f39054h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayMap f39055i;

    /* renamed from: j, reason: collision with root package name */
    public final LruCache f39056j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzr f39057k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayMap f39058l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayMap f39059m;
    public final ArrayMap n;

    public zzhs(zzpf zzpfVar) {
        super(zzpfVar);
        this.f39050d = new ArrayMap();
        this.f39051e = new ArrayMap();
        this.f39052f = new ArrayMap();
        this.f39053g = new ArrayMap();
        this.f39054h = new ArrayMap();
        this.f39058l = new ArrayMap();
        this.f39059m = new ArrayMap();
        this.n = new ArrayMap();
        this.f39055i = new ArrayMap();
        this.f39056j = new zzhl(this);
        this.f39057k = new zzhm(this);
    }

    public static final ArrayMap q(com.google.android.gms.internal.measurement.zzgl zzglVar) {
        ArrayMap arrayMap = new ArrayMap();
        for (com.google.android.gms.internal.measurement.zzgt zzgtVar : zzglVar.w()) {
            arrayMap.put(zzgtVar.s(), zzgtVar.t());
        }
        return arrayMap;
    }

    public static final zzjj r(int i2) {
        int i3 = i2 - 1;
        if (i3 == 1) {
            return zzjj.AD_STORAGE;
        }
        if (i3 == 2) {
            return zzjj.ANALYTICS_STORAGE;
        }
        if (i3 == 3) {
            return zzjj.AD_USER_DATA;
        }
        if (i3 != 4) {
            return null;
        }
        return zzjj.AD_PERSONALIZATION;
    }

    public final boolean A(String str, zzjj zzjjVar) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarB = B(str);
        if (zzgfVarB == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzgfVarB.s()) {
            if (zzjjVar == r(zzfuVar.s())) {
                return zzfuVar.t() == 2;
            }
        }
        return false;
    }

    public final com.google.android.gms.internal.measurement.zzgf B(String str) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.zzgl zzglVarS = s(str);
        if (zzglVarS == null || !zzglVarS.E()) {
            return null;
        }
        return zzglVarS.F();
    }

    @Override // com.google.android.gms.measurement.internal.zzak
    public final String a(String str, String str2) {
        g();
        m(str);
        Map map = (Map) this.f39050d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final zzjh k(String str, zzjj zzjjVar) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarB = B(str);
        zzjh zzjhVar = zzjh.UNINITIALIZED;
        if (zzgfVarB != null) {
            Iterator it = zzgfVarB.x().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.google.android.gms.internal.measurement.zzfu zzfuVar = (com.google.android.gms.internal.measurement.zzfu) it.next();
                if (r(zzfuVar.s()) == zzjjVar) {
                    int iT = zzfuVar.t() - 1;
                    if (iT == 1) {
                        return zzjh.GRANTED;
                    }
                    if (iT == 2) {
                        return zzjh.DENIED;
                    }
                }
            }
        }
        return zzjhVar;
    }

    public final boolean l(String str) {
        g();
        m(str);
        com.google.android.gms.internal.measurement.zzgf zzgfVarB = B(str);
        if (zzgfVarB == null) {
            return false;
        }
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzgfVarB.s()) {
            if (zzfuVar.s() == 3 && zzfuVar.u() == 3) {
                return true;
            }
        }
        return false;
    }

    public final void m(String str) {
        h();
        g();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = this.f39054h;
        if (arrayMap.get(str) == null) {
            zzav zzavVar = this.f39551b.f39596c;
            zzpf.S(zzavVar);
            zzaq zzaqVarO0 = zzavVar.o0(str);
            ArrayMap arrayMap2 = this.n;
            ArrayMap arrayMap3 = this.f39059m;
            ArrayMap arrayMap4 = this.f39058l;
            ArrayMap arrayMap5 = this.f39050d;
            if (zzaqVarO0 != null) {
                com.google.android.gms.internal.measurement.zzgk zzgkVar = (com.google.android.gms.internal.measurement.zzgk) p(str, zzaqVarO0.f38705a).m();
                n(str, zzgkVar);
                arrayMap5.put(str, q((com.google.android.gms.internal.measurement.zzgl) zzgkVar.l()));
                arrayMap.put(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.l());
                o(str, (com.google.android.gms.internal.measurement.zzgl) zzgkVar.l());
                arrayMap4.put(str, zzgkVar.x());
                arrayMap3.put(str, zzaqVarO0.f38706b);
                arrayMap2.put(str, zzaqVarO0.f38707c);
                return;
            }
            arrayMap5.put(str, null);
            this.f39052f.put(str, null);
            this.f39051e.put(str, null);
            this.f39053g.put(str, null);
            arrayMap.put(str, null);
            arrayMap4.put(str, null);
            arrayMap3.put(str, null);
            arrayMap2.put(str, null);
            this.f39055i.put(str, null);
        }
    }

    public final void n(String str, com.google.android.gms.internal.measurement.zzgk zzgkVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Iterator it = zzgkVar.w().iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.zzgh) it.next()).s());
        }
        for (int i2 = 0; i2 < zzgkVar.o(); i2++) {
            com.google.android.gms.internal.measurement.zzgi zzgiVar = (com.google.android.gms.internal.measurement.zzgi) zzgkVar.p(i2).m();
            boolean zIsEmpty = zzgiVar.o().isEmpty();
            zzib zzibVar = this.f39180a;
            if (zIsEmpty) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38961i.a("EventConfig contained null event name");
            } else {
                String strO = zzgiVar.o();
                String strB = zzls.b(zzgiVar.o(), zzjl.f39201a, zzjl.f39203c);
                if (!TextUtils.isEmpty(strB)) {
                    zzgiVar.p(strB);
                    zzgkVar.q(i2, zzgiVar);
                }
                if (zzgiVar.q() && zzgiVar.t()) {
                    arrayMap.put(strO, Boolean.TRUE);
                }
                if (zzgiVar.u() && zzgiVar.v()) {
                    arrayMap2.put(zzgiVar.o(), Boolean.TRUE);
                }
                if (zzgiVar.w()) {
                    if (zzgiVar.x() < 2 || zzgiVar.x() > 65535) {
                        zzgt zzgtVar2 = zzibVar.f39089f;
                        zzib.l(zzgtVar2);
                        zzgtVar2.f38961i.c("Invalid sampling rate. Event name, sample rate", zzgiVar.o(), Integer.valueOf(zzgiVar.x()));
                    } else {
                        arrayMap3.put(zzgiVar.o(), Integer.valueOf(zzgiVar.x()));
                    }
                }
            }
        }
        this.f39051e.put(str, hashSet);
        this.f39052f.put(str, arrayMap);
        this.f39053g.put(str, arrayMap2);
        this.f39055i.put(str, arrayMap3);
    }

    public final void o(final String key, com.google.android.gms.internal.measurement.zzgl zzglVar) {
        Object objRemove;
        if (zzglVar.B() == 0) {
            LruCache lruCache = this.f39056j;
            lruCache.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            synchronized (lruCache.f1483c) {
                try {
                    LruHashMap lruHashMap = lruCache.f1482b;
                    lruHashMap.getClass();
                    Intrinsics.checkNotNullParameter(key, "key");
                    objRemove = lruHashMap.f1613a.remove(key);
                    if (objRemove != null) {
                        lruCache.f1484d -= lruCache.e(key, objRemove);
                    }
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objRemove != null) {
                lruCache.b(key, objRemove);
                return;
            }
            return;
        }
        zzib zzibVar = this.f39180a;
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.n.b(Integer.valueOf(zzglVar.B()), "EES programs found");
        com.google.android.gms.internal.measurement.zzja zzjaVar = (com.google.android.gms.internal.measurement.zzja) zzglVar.A().get(0);
        try {
            com.google.android.gms.internal.measurement.zzc zzcVar = new com.google.android.gms.internal.measurement.zzc();
            zzcVar.f36813a.f36941d.a("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhr
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return new com.google.android.gms.internal.measurement.zzn(new zzhn(this.f39048a, key));
                }
            });
            zzcVar.f36813a.f36941d.a("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzho
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    final zzhs zzhsVar = this.f39043a;
                    final String str = key;
                    return new com.google.android.gms.internal.measurement.zzu(new Callable() { // from class: com.google.android.gms.measurement.internal.zzhq
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            zzhs zzhsVar2 = zzhsVar;
                            zzav zzavVar = zzhsVar2.f39551b.f39596c;
                            zzpf.S(zzavVar);
                            String str2 = str;
                            zzh zzhVarK0 = zzavVar.k0(str2);
                            HashMap map = new HashMap();
                            map.put("platform", LogSubCategory.LifeCycle.ANDROID);
                            map.put("package_name", str2);
                            zzhsVar2.f39180a.f39087d.l();
                            map.put("gmp_version", 130000L);
                            if (zzhVarK0 != null) {
                                String strN = zzhVarK0.N();
                                if (strN != null) {
                                    map.put("app_version", strN);
                                }
                                map.put("app_version_int", Long.valueOf(zzhVarK0.P()));
                                map.put("dynamite_version", Long.valueOf(zzhVarK0.b()));
                            }
                            return map;
                        }
                    });
                }
            });
            zzcVar.f36813a.f36941d.a("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzhp
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return new com.google.android.gms.internal.measurement.zzt(this.f39045a.f39057k);
                }
            });
            zzcVar.b(zzjaVar);
            this.f39056j.d(key, zzcVar);
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.n.c("EES program loaded for appId, activities", key, Integer.valueOf(zzjaVar.t().t()));
            for (com.google.android.gms.internal.measurement.zziy zziyVar : zzjaVar.t().s()) {
                zzgt zzgtVar3 = zzibVar.f39089f;
                zzib.l(zzgtVar3);
                zzgtVar3.n.b(zziyVar.s(), "EES program activity");
            }
        } catch (com.google.android.gms.internal.measurement.zzd unused) {
            zzgt zzgtVar4 = this.f39180a.f39089f;
            zzib.l(zzgtVar4);
            zzgtVar4.f38958f.b(key, "Failed to load EES program. appId");
        }
    }

    public final com.google.android.gms.internal.measurement.zzgl p(String str, byte[] bArr) {
        zzib zzibVar = this.f39180a;
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzgl.J();
        }
        try {
            com.google.android.gms.internal.measurement.zzgl zzglVar = (com.google.android.gms.internal.measurement.zzgl) ((com.google.android.gms.internal.measurement.zzgk) zzpj.O(com.google.android.gms.internal.measurement.zzgl.I(), bArr)).l();
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.c("Parsed config. version, gmp_app_id", zzglVar.s() ? Long.valueOf(zzglVar.t()) : null, zzglVar.u() ? zzglVar.v() : null);
            return zzglVar;
        } catch (com.google.android.gms.internal.measurement.zzmq e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38961i.c("Unable to merge remote config. appId", zzgt.o(str), e2);
            return com.google.android.gms.internal.measurement.zzgl.J();
        } catch (RuntimeException e3) {
            zzgt zzgtVar3 = zzibVar.f39089f;
            zzib.l(zzgtVar3);
            zzgtVar3.f38961i.c("Unable to merge remote config. appId", zzgt.o(str), e3);
            return com.google.android.gms.internal.measurement.zzgl.J();
        }
    }

    public final com.google.android.gms.internal.measurement.zzgl s(String str) {
        h();
        g();
        Preconditions.checkNotEmpty(str);
        m(str);
        return (com.google.android.gms.internal.measurement.zzgl) this.f39054h.get(str);
    }

    public final String t(String str) {
        g();
        m(str);
        return (String) this.f39058l.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0398, code lost:
    
        r4 = java.lang.Integer.valueOf(r8.t());
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x03a1, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x03a2, code lost:
    
        r7.put(r0, r4);
        r28 = r0;
        r7.put("property_name", r8.u());
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x03b4, code lost:
    
        if (r8.y() == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x03b6, code lost:
    
        r0 = java.lang.Boolean.valueOf(r8.z());
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x03bf, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x03c0, code lost:
    
        r7.put("session_scoped", r0);
        r7.put("data", r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x03d2, code lost:
    
        if (r9.X().insertWithOnConflict("property_filters", null, r7, 5) != (-1)) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x03d4, code lost:
    
        r0 = r6.f39089f;
        com.google.android.gms.measurement.internal.zzib.l(r0);
        r0.f38958f.b(com.google.android.gms.measurement.internal.zzgt.o(r30), "Failed to insert property filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x03e5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x03e7, code lost:
    
        r7 = r23;
        r4 = r27;
        r0 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x03ef, code lost:
    
        r3 = r6.f39089f;
        com.google.android.gms.measurement.internal.zzib.l(r3);
        r3.f38958f.c("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzgt.o(r30), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x03ff, code lost:
    
        r9.h();
        r9.g();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30);
        r0 = r9.X();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r30, java.lang.String.valueOf(r26)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r30, java.lang.String.valueOf(r26)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0422, code lost:
    
        r3 = r24;
        r4 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0204, code lost:
    
        r8 = r0.u().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0210, code lost:
    
        if (r8.hasNext() == false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x021c, code lost:
    
        if (((com.google.android.gms.internal.measurement.zzfn) r8.next()).s() != false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x021e, code lost:
    
        r0 = r6.f39089f;
        com.google.android.gms.measurement.internal.zzib.l(r0);
        r0.f38961i.c("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzgt.o(r30), java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0234, code lost:
    
        r8 = r0.x().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0240, code lost:
    
        r23 = r0;
        r0 = "filter_id";
        r24 = r3;
        r25 = r4;
        r4 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0252, code lost:
    
        if (r8.hasNext() == false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0254, code lost:
    
        r14 = (com.google.android.gms.internal.measurement.zzff) r8.next();
        r9.h();
        r9.g();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x026e, code lost:
    
        if (r14.u().isEmpty() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0270, code lost:
    
        r0 = r6.f39089f;
        com.google.android.gms.measurement.internal.zzib.l(r0);
        r0 = r0.f38961i;
        r4 = com.google.android.gms.measurement.internal.zzgt.o(r30);
        r5 = java.lang.Integer.valueOf(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0285, code lost:
    
        if (r14.s() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0287, code lost:
    
        r6 = java.lang.Integer.valueOf(r14.t());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0293, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0294, code lost:
    
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r4, r5, java.lang.String.valueOf(r6));
        r26 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x029f, code lost:
    
        r26 = r7;
        r7 = r14.f();
        r27 = r8;
        r8 = new android.content.ContentValues();
        r8.put("app_id", r30);
        r8.put("audience_id", java.lang.Integer.valueOf(r26));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02ba, code lost:
    
        if (r14.s() == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02bc, code lost:
    
        r3 = java.lang.Integer.valueOf(r14.t());
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02c5, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x02c6, code lost:
    
        r8.put("filter_id", r3);
        r8.put("event_name", r14.u());
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x02d6, code lost:
    
        if (r14.C() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02d8, code lost:
    
        r0 = java.lang.Boolean.valueOf(r14.D());
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02e1, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02e2, code lost:
    
        r8.put("session_scoped", r0);
        r8.put("data", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02f4, code lost:
    
        if (r9.X().insertWithOnConflict("event_filters", null, r8, 5) != (-1)) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02f6, code lost:
    
        r0 = r6.f39089f;
        com.google.android.gms.measurement.internal.zzib.l(r0);
        r0.f38958f.b(com.google.android.gms.measurement.internal.zzgt.o(r30), "Failed to insert event filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0306, code lost:
    
        r0 = r23;
        r3 = r24;
        r4 = r25;
        r7 = r26;
        r8 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0312, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0313, code lost:
    
        r3 = r6.f39089f;
        com.google.android.gms.measurement.internal.zzib.l(r3);
        r3.f38958f.c("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzgt.o(r30), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0325, code lost:
    
        r26 = r7;
        r7 = r23.u().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0333, code lost:
    
        if (r7.hasNext() == false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0335, code lost:
    
        r8 = (com.google.android.gms.internal.measurement.zzfn) r7.next();
        r9.h();
        r9.g();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x034f, code lost:
    
        if (r8.u().isEmpty() == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0351, code lost:
    
        r0 = r6.f39089f;
        com.google.android.gms.measurement.internal.zzib.l(r0);
        r0 = r0.f38961i;
        r4 = com.google.android.gms.measurement.internal.zzgt.o(r30);
        r5 = java.lang.Integer.valueOf(r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0366, code lost:
    
        if (r8.s() == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0368, code lost:
    
        r6 = java.lang.Integer.valueOf(r8.t());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0371, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0372, code lost:
    
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r4, r5, java.lang.String.valueOf(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x037b, code lost:
    
        r14 = r8.f();
        r23 = r7;
        r7 = new android.content.ContentValues();
        r7.put(r4, r30);
        r27 = r4;
        r7.put("audience_id", java.lang.Integer.valueOf(r26));
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0396, code lost:
    
        if (r8.s() == false) goto L101;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(java.lang.String r30, java.lang.String r31, java.lang.String r32, byte[] r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhs.u(java.lang.String, java.lang.String, java.lang.String, byte[]):void");
    }

    public final boolean v(String str, String str2) {
        Boolean bool;
        g();
        m(str);
        if ("1".equals(a(str, "measurement.upload.blacklist_internal")) && zzpo.D(str2)) {
            return true;
        }
        if ("1".equals(a(str, "measurement.upload.blacklist_public")) && zzpo.d0(str2)) {
            return true;
        }
        Map map = (Map) this.f39052f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean w(String str, String str2) {
        Boolean bool;
        g();
        m(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f39053g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final int x(String str, String str2) {
        Integer num;
        g();
        m(str);
        Map map = (Map) this.f39055i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final boolean y(String str) {
        g();
        m(str);
        ArrayMap arrayMap = this.f39051e;
        if (arrayMap.get(str) != null) {
            return ((Set) arrayMap.get(str)).contains("os_version") || ((Set) arrayMap.get(str)).contains("device_info");
        }
        return false;
    }

    public final boolean z(String str) {
        g();
        m(str);
        ArrayMap arrayMap = this.f39051e;
        return arrayMap.get(str) != null && ((Set) arrayMap.get(str)).contains("app_instance_id");
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    public final void j() {
    }
}
