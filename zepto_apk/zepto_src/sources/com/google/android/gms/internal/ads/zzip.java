package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import coil3.util.UtilsKt;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzip implements zzlg {
    public static final zzgtd p;

    /* renamed from: a, reason: collision with root package name */
    public final zzbe f34947a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbd f34948b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaan f34949c;

    /* renamed from: d, reason: collision with root package name */
    public final long f34950d;

    /* renamed from: e, reason: collision with root package name */
    public final long f34951e;

    /* renamed from: f, reason: collision with root package name */
    public final long f34952f;

    /* renamed from: g, reason: collision with root package name */
    public final long f34953g;

    /* renamed from: h, reason: collision with root package name */
    public final long f34954h;

    /* renamed from: i, reason: collision with root package name */
    public final long f34955i;

    /* renamed from: j, reason: collision with root package name */
    public final long f34956j;

    /* renamed from: k, reason: collision with root package name */
    public final long f34957k;

    /* renamed from: l, reason: collision with root package name */
    public final long f34958l;

    /* renamed from: m, reason: collision with root package name */
    public final zzgtg f34959m;
    public final ConcurrentHashMap n;
    public long o;

    static {
        zzgvs zzgvsVar = zzgtd.f33183b;
        Object[] objArr = {UtilsKt.SCHEME_FILE, "content", "data", "android.resource", "rawresource", "asset"};
        zzguw.a(6, objArr);
        p = zzgtd.t(6, objArr);
    }

    public zzip() {
        zzaan zzaanVar = new zzaan();
        zzgtg zzgtgVar = zzgvd.f33244g;
        j(1000, 0, "bufferForPlaybackMs", "0");
        j(1000, 0, "bufferForPlaybackForLocalPlaybackMs", "0");
        j(2000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        j(1000, 0, "bufferForPlaybackAfterRebufferForLocalPlaybackMs", "0");
        j(50000, 1000, "minBufferMs", "bufferForPlaybackMs");
        j(1000, 1000, "minBufferForLocalPlaybackMs", "bufferForPlaybackForLocalPlaybackMs");
        j(50000, 2000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        j(1000, 1000, "minBufferForLocalPlaybackMs", "bufferForPlaybackAfterRebufferForLocalPlaybackMs");
        j(50000, 50000, "maxBufferMs", "minBufferMs");
        j(50000, 1000, "maxBufferForLocalPlaybackMs", "minBufferForLocalPlaybackMs");
        j(0, 0, "backBufferDurationMs", "0");
        this.f34947a = new zzbe();
        this.f34948b = new zzbd();
        this.f34949c = zzaanVar;
        long jS = zzfj.s(50000L);
        this.f34950d = jS;
        long jS2 = zzfj.s(1000L);
        this.f34951e = jS2;
        this.f34952f = jS;
        this.f34953g = jS;
        this.f34954h = jS2;
        this.f34955i = jS2;
        this.f34956j = zzfj.s(2000L);
        this.f34957k = jS2;
        this.f34958l = zzfj.s(0L);
        this.n = new ConcurrentHashMap();
        this.f34959m = zzgtg.a(zzgtgVar);
        this.o = -1L;
    }

    public static void j(int i2, int i3, String str, String str2) {
        if (!(i2 >= i3)) {
            throw new IllegalArgumentException(zzgqr.b("%s cannot be less than %s", str, str2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void a(zzpn zzpnVar) {
        ConcurrentHashMap concurrentHashMap = this.n;
        zzio zzioVar = (zzio) concurrentHashMap.get(zzpnVar);
        if (zzioVar != null) {
            int i2 = zzioVar.f34943a - 1;
            zzioVar.f34943a = i2;
            if (i2 == 0) {
                concurrentHashMap.remove(zzpnVar);
                h();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final zzaah b(zzpn zzpnVar) {
        return new zzin(this, zzpnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void c(zzpn zzpnVar) {
        ConcurrentHashMap concurrentHashMap = this.n;
        zzio zzioVar = (zzio) concurrentHashMap.get(zzpnVar);
        if (zzioVar != null) {
            int i2 = zzioVar.f34943a - 1;
            zzioVar.f34943a = i2;
            if (i2 == 0) {
                concurrentHashMap.remove(zzpnVar);
                h();
            }
        }
        if (concurrentHashMap.isEmpty()) {
            this.o = -1L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void d(zzpn zzpnVar) {
        long id = Thread.currentThread().getId();
        long j2 = this.o;
        zzgqa.g("Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).", j2 == -1 || j2 == id);
        this.o = id;
        ConcurrentHashMap concurrentHashMap = this.n;
        zzio zzioVar = (zzio) concurrentHashMap.get(zzpnVar);
        if (zzioVar == null) {
            concurrentHashMap.put(zzpnVar, new zzio());
        } else {
            zzioVar.f34943a++;
        }
        zzio zzioVar2 = (zzio) concurrentHashMap.get(zzpnVar);
        zzioVar2.getClass();
        Integer num = (Integer) this.f34959m.get(zzpnVar.f35326a);
        int iIntValue = (num == null || num.intValue() == -1) ? -1 : num.intValue();
        if (iIntValue == -1) {
            iIntValue = 13107200;
        }
        zzioVar2.f34945c = iIntValue;
        zzioVar2.f34944b = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void e(zzlf zzlfVar, zzzw[] zzzwVarArr) {
        ConcurrentHashMap concurrentHashMap = this.n;
        zzpn zzpnVar = zzlfVar.f35083a;
        Integer num = (Integer) this.f34959m.get(zzpnVar.f35326a);
        int iIntValue = (num == null || num.intValue() == -1) ? -1 : num.intValue();
        zzio zzioVar = (zzio) concurrentHashMap.get(zzpnVar);
        zzioVar.getClass();
        if (iIntValue == -1) {
            boolean zI = i(zzlfVar);
            int length = zzzwVarArr.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = 13107200;
                if (i2 >= length) {
                    break;
                }
                zzzw zzzwVar = zzzwVarArr[i2];
                if (zzzwVar != null) {
                    int i5 = zzzwVar.zza().f24985c;
                    if (i5 != -1) {
                        if (i5 == 0) {
                            i4 = 144310272;
                        } else if (i5 != 1) {
                            i4 = i5 != 2 ? i5 != 4 ? 131072 : 26214400 : zI ? 19660800 : 131072000;
                        }
                    }
                    i3 += i4;
                }
                i2++;
            }
            iIntValue = Math.max(13107200, i3);
        }
        zzioVar.f34945c = iIntValue;
        h();
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final boolean f(zzlf zzlfVar) {
        long jMin;
        boolean z;
        int i2;
        boolean z2 = zzlfVar.f35088f;
        boolean zI = i(zzlfVar);
        long jRound = zzlfVar.f35086d;
        float f2 = zzlfVar.f35087e;
        String str = zzfj.f31254a;
        if (f2 != 1.0f) {
            jRound = Math.round(jRound / f2);
        }
        if (z2) {
            if (zI) {
                jMin = this.f34957k;
                z = true;
            } else {
                jMin = this.f34956j;
                z = false;
            }
        } else if (zI) {
            jMin = this.f34955i;
            z = true;
        } else {
            jMin = this.f34954h;
            z = false;
        }
        long j2 = zzlfVar.f35089g;
        if (j2 != -9223372036854775807L) {
            jMin = Math.min(j2 / 2, jMin);
        }
        if (jMin > 0 && jRound < jMin) {
            if (!z) {
                zzpn zzpnVar = zzlfVar.f35083a;
                zzio zzioVar = (zzio) this.n.get(zzpnVar);
                zzioVar.getClass();
                synchronized (zzioVar) {
                    i2 = zzioVar.f34946d;
                }
                int i3 = i2 * 65536;
                zzio zzioVar2 = (zzio) this.n.get(zzpnVar);
                zzioVar2.getClass();
                if (i3 >= zzioVar2.f34945c) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final boolean g(zzlf zzlfVar) {
        int i2;
        ConcurrentHashMap concurrentHashMap = this.n;
        zzpn zzpnVar = zzlfVar.f35083a;
        zzio zzioVar = (zzio) concurrentHashMap.get(zzpnVar);
        zzioVar.getClass();
        zzio zzioVar2 = (zzio) this.n.get(zzpnVar);
        zzioVar2.getClass();
        synchronized (zzioVar2) {
            i2 = zzioVar2.f34946d;
        }
        int i3 = i2 * 65536;
        zzio zzioVar3 = (zzio) this.n.get(zzpnVar);
        zzioVar3.getClass();
        int i4 = zzioVar3.f34945c;
        if (zzpnVar.equals(zzpn.f35325c)) {
            return i3 < i4;
        }
        boolean zI = i(zzlfVar);
        long jMin = zI ? this.f34951e : this.f34950d;
        long j2 = zI ? this.f34953g : this.f34952f;
        float f2 = zzlfVar.f35087e;
        if (f2 > 1.0f) {
            jMin = Math.min(zzfj.w(jMin, f2), j2);
        }
        long jMax = Math.max(jMin, 500000L);
        long j3 = zzlfVar.f35086d;
        if (j3 < jMax) {
            boolean z = zI || i3 < i4;
            zzioVar.f34944b = z;
            if (!z && j3 < 500000) {
                zzee.c("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= j2 || i3 >= i4) {
            zzioVar.f34944b = false;
        }
        return zzioVar.f34944b;
    }

    public final void h() {
        ConcurrentHashMap concurrentHashMap = this.n;
        boolean zIsEmpty = concurrentHashMap.isEmpty();
        zzaan zzaanVar = this.f34949c;
        int i2 = 0;
        if (zIsEmpty) {
            synchronized (zzaanVar) {
                zzaanVar.c(0);
            }
        } else {
            Iterator it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                i2 += ((zzio) it.next()).f34945c;
            }
            zzaanVar.c(i2);
        }
    }

    public final boolean i(zzlf zzlfVar) {
        Object obj = zzlfVar.f35085c.f35758a;
        zzbd zzbdVar = this.f34948b;
        zzbf zzbfVar = zzlfVar.f35084b;
        zzag zzagVar = zzbfVar.b(zzbfVar.o(obj, zzbdVar).f24739c, this.f34947a, 0L).f24824b.f23332b;
        if (zzagVar == null) {
            return false;
        }
        String scheme = zzagVar.f22978a.getScheme();
        return TextUtils.isEmpty(scheme) || p.contains(scheme);
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final long zzf() {
        return this.f34958l;
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final boolean zzj() {
        Iterator it = this.n.values().iterator();
        while (it.hasNext()) {
            if (((zzio) it.next()).f34944b) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlg
    public final void zzg() {
    }
}
