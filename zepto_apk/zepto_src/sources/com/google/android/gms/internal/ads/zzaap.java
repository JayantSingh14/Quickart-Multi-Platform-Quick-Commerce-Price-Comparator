package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzaap implements zzaam, zzhz {
    public static final zzgtd n = zzgtd.p(4300000L, 3200000L, 2400000L, 1700000L, 860000L);
    public static final zzgtd o = zzgtd.p(1500000L, 980000L, 750000L, 520000L, 290000L);
    public static final zzgtd p = zzgtd.p(2000000L, 1300000L, 1000000L, 860000L, 610000L);
    public static final zzgtd q = zzgtd.p(2500000L, 1700000L, 1200000L, 970000L, 680000L);
    public static final zzgtd r = zzgtd.p(4700000L, 2800000L, 2100000L, 1700000L, 980000L);
    public static final zzgtd s = zzgtd.p(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);
    public static zzaap t;

    /* renamed from: a, reason: collision with root package name */
    public final Context f22597a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgtg f22598b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaak f22599c;

    /* renamed from: d, reason: collision with root package name */
    public final zzabd f22600d;

    /* renamed from: e, reason: collision with root package name */
    public int f22601e;

    /* renamed from: f, reason: collision with root package name */
    public long f22602f;

    /* renamed from: g, reason: collision with root package name */
    public long f22603g;

    /* renamed from: h, reason: collision with root package name */
    public long f22604h;

    /* renamed from: i, reason: collision with root package name */
    public long f22605i;

    /* renamed from: j, reason: collision with root package name */
    public long f22606j;

    /* renamed from: k, reason: collision with root package name */
    public long f22607k;

    /* renamed from: l, reason: collision with root package name */
    public int f22608l;

    /* renamed from: m, reason: collision with root package name */
    public String f22609m;

    public zzaap(Context context, HashMap map) {
        boolean z;
        this.f22597a = context == null ? null : context.getApplicationContext();
        this.f22598b = zzgtg.a(map);
        this.f22599c = new zzaak();
        this.f22600d = new zzabd();
        if (context == null) {
            this.f22608l = 0;
            this.f22606j = 1000000L;
            return;
        }
        zzep zzepVarA = zzep.a(context);
        int iB = zzepVarA.b();
        this.f22608l = iB;
        this.f22606j = d(iB);
        zzej zzejVar = new zzej() { // from class: com.google.android.gms.internal.ads.zzaao
            /* JADX WARN: Removed duplicated region for block: B:26:0x003f A[Catch: all -> 0x000c, TryCatch #0 {all -> 0x000c, blocks: (B:4:0x0003, B:6:0x0007, B:11:0x0010, B:17:0x001c, B:19:0x0020, B:21:0x0026, B:23:0x0030, B:25:0x003a, B:27:0x004b, B:26:0x003f, B:28:0x004d, B:30:0x005c, B:32:0x0064), top: B:39:0x0003 }] */
            @Override // com.google.android.gms.internal.ads.zzej
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void zza(int r10) {
                /*
                    r9 = this;
                    com.google.android.gms.internal.ads.zzaap r1 = r9.f22596a
                    monitor-enter(r1)
                    int r0 = r1.f22608l     // Catch: java.lang.Throwable -> Lc
                    if (r0 != r10) goto L10
                    java.lang.String r0 = r1.f22609m     // Catch: java.lang.Throwable -> Lc
                    if (r0 != 0) goto L85
                    goto L10
                Lc:
                    r0 = move-exception
                    r10 = r0
                    goto L87
                L10:
                    r1.f22608l = r10     // Catch: java.lang.Throwable -> Lc
                    r0 = 1
                    if (r10 == r0) goto L85
                    if (r10 == 0) goto L85
                    r0 = 8
                    if (r10 != r0) goto L1c
                    goto L85
                L1c:
                    java.lang.String r0 = r1.f22609m     // Catch: java.lang.Throwable -> Lc
                    if (r0 != 0) goto L4d
                    android.content.Context r0 = r1.f22597a     // Catch: java.lang.Throwable -> Lc
                    java.lang.String r2 = com.google.android.gms.internal.ads.zzfj.f31254a     // Catch: java.lang.Throwable -> Lc
                    if (r0 == 0) goto L3f
                    java.lang.String r2 = "phone"
                    java.lang.Object r0 = r0.getSystemService(r2)     // Catch: java.lang.Throwable -> Lc
                    android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Throwable -> Lc
                    if (r0 == 0) goto L3f
                    java.lang.String r0 = r0.getNetworkCountryIso()     // Catch: java.lang.Throwable -> Lc
                    boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lc
                    if (r2 != 0) goto L3f
                    java.lang.String r0 = com.google.android.gms.internal.ads.zzgpj.b(r0)     // Catch: java.lang.Throwable -> Lc
                    goto L4b
                L3f:
                    java.util.Locale r0 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> Lc
                    java.lang.String r0 = r0.getCountry()     // Catch: java.lang.Throwable -> Lc
                    java.lang.String r0 = com.google.android.gms.internal.ads.zzgpj.b(r0)     // Catch: java.lang.Throwable -> Lc
                L4b:
                    r1.f22609m = r0     // Catch: java.lang.Throwable -> Lc
                L4d:
                    long r2 = r1.d(r10)     // Catch: java.lang.Throwable -> Lc
                    r1.f22606j = r2     // Catch: java.lang.Throwable -> Lc
                    long r7 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> Lc
                    int r10 = r1.f22601e     // Catch: java.lang.Throwable -> Lc
                    r0 = 0
                    if (r10 <= 0) goto L63
                    long r2 = r1.f22602f     // Catch: java.lang.Throwable -> Lc
                    long r2 = r7 - r2
                    int r10 = (int) r2     // Catch: java.lang.Throwable -> Lc
                    r6 = r10
                    goto L64
                L63:
                    r6 = r0
                L64:
                    long r2 = r1.f22603g     // Catch: java.lang.Throwable -> Lc
                    long r4 = r1.f22606j     // Catch: java.lang.Throwable -> Lc
                    r1.c(r2, r4, r6)     // Catch: java.lang.Throwable -> Lc
                    r1.f22602f = r7     // Catch: java.lang.Throwable -> Lc
                    r2 = 0
                    r1.f22603g = r2     // Catch: java.lang.Throwable -> Lc
                    r1.f22605i = r2     // Catch: java.lang.Throwable -> Lc
                    r1.f22604h = r2     // Catch: java.lang.Throwable -> Lc
                    com.google.android.gms.internal.ads.zzabd r10 = r1.f22600d     // Catch: java.lang.Throwable -> Lc
                    java.util.ArrayList r2 = r10.f22634a     // Catch: java.lang.Throwable -> Lc
                    r2.clear()     // Catch: java.lang.Throwable -> Lc
                    r2 = -1
                    r10.f22636c = r2     // Catch: java.lang.Throwable -> Lc
                    r10.f22637d = r0     // Catch: java.lang.Throwable -> Lc
                    r10.f22638e = r0     // Catch: java.lang.Throwable -> Lc
                    monitor-exit(r1)
                    return
                L85:
                    monitor-exit(r1)
                    return
                L87:
                    monitor-exit(r1)     // Catch: java.lang.Throwable -> Lc
                    throw r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaao.zza(int):void");
            }
        };
        Executor executorA = zzdh.a();
        CopyOnWriteArrayList copyOnWriteArrayList = zzepVarA.f30017b;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzel zzelVar = (zzel) it.next();
            if (zzelVar.f29595a.get() == null) {
                copyOnWriteArrayList.remove(zzelVar);
            }
        }
        zzel zzelVar2 = new zzel(zzepVarA, zzejVar, executorA);
        synchronized (zzepVarA.f30018c) {
            zzepVarA.f30017b.add(zzelVar2);
            z = zzepVarA.f30020e;
        }
        if (z) {
            zzelVar2.f29596b.execute(new zzek(zzelVar2));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0130, code lost:
    
        if (r3.equals("AQ") != false) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0148, code lost:
    
        if (r3.equals("GQ") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x016e, code lost:
    
        if (r3.equals("GM") != false) goto L345;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0178, code lost:
    
        if (r3.equals("GL") != false) goto L600;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0182, code lost:
    
        if (r3.equals("GI") != false) goto L722;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01d2, code lost:
    
        if (r3.equals("FK") != false) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0214, code lost:
    
        if (r3.equals("ER") != false) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x023a, code lost:
    
        if (r3.equals("CX") != false) goto L908;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0244, code lost:
    
        if (r3.equals("CW") != false) goto L900;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x025c, code lost:
    
        if (r3.equals("CU") != false) goto L669;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0282, code lost:
    
        if (r3.equals("CM") != false) goto L551;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x028c, code lost:
    
        if (r3.equals("CL") != false) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0296, code lost:
    
        if (r3.equals("CK") != false) goto L892;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x02a0, code lost:
    
        if (r3.equals("ZW") != false) goto L393;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x02c6, code lost:
    
        if (r3.equals("YT") != false) goto L513;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x02d0, code lost:
    
        if (r3.equals("YE") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x02e8, code lost:
    
        if (r3.equals("WS") != false) goto L521;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x02f2, code lost:
    
        if (r3.equals("WF") != false) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x02fc, code lost:
    
        if (r3.equals("VU") != false) goto L665;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0330, code lost:
    
        if (r3.equals("VE") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x033a, code lost:
    
        if (r3.equals("VC") != false) goto L900;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0344, code lost:
    
        if (r3.equals("VA") != false) goto L908;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0386, code lost:
    
        if (r3.equals("UA") != false) goto L815;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x03ac, code lost:
    
        if (r3.equals("TV") != false) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x03c4, code lost:
    
        if (r3.equals("TR") != false) goto L904;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x03ea, code lost:
    
        if (r3.equals("TM") != false) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x03f4, code lost:
    
        if (r3.equals("TL") != false) goto L669;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x03fe, code lost:
    
        if (r3.equals("TJ") != false) goto L792;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0408, code lost:
    
        if (r3.equals("TH") != false) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x040f, code lost:
    
        return new int[]{0, 1, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0424, code lost:
    
        if (r3.equals("TD") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x043c, code lost:
    
        if (r3.equals("SZ") != false) goto L881;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0446, code lost:
    
        if (r3.equals("SY") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0450, code lost:
    
        if (r3.equals("SX") != false) goto L900;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0476, code lost:
    
        if (r3.equals("SS") != false) goto L345;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x047d, code lost:
    
        return new int[]{4, 3, 2, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x04ae, code lost:
    
        if (r3.equals("SM") != false) goto L908;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x04b8, code lost:
    
        if (r3.equals("SL") != false) goto L873;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x04d0, code lost:
    
        if (r3.equals("SJ") != false) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x04da, code lost:
    
        if (r3.equals("SI") != false) goto L835;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x04e4, code lost:
    
        if (r3.equals("SH") != false) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x04fc, code lost:
    
        if (r3.equals("SE") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0506, code lost:
    
        if (r3.equals("SD") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x0510, code lost:
    
        if (r3.equals("SC") != false) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x051a, code lost:
    
        if (r3.equals("SB") != false) goto L393;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0521, code lost:
    
        return new int[]{4, 2, 4, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0064, code lost:
    
        if (r3.equals("CI") != false) goto L877;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x058a, code lost:
    
        if (r3.equals("PY") != false) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x05a2, code lost:
    
        if (r3.equals("PT") != false) goto L835;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x05c8, code lost:
    
        if (r3.equals("PM") != false) goto L908;
     */
    /* JADX WARN: Code restructure failed: missing block: B:457:0x05fc, code lost:
    
        if (r3.equals("PG") != false) goto L622;
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x0622, code lost:
    
        if (r3.equals("PA") != false) goto L916;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x0648, code lost:
    
        if (r3.equals("NU") != false) goto L480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x064f, code lost:
    
        return new int[]{4, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x0656, code lost:
    
        if (r3.equals("NR") != false) goto L669;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007c, code lost:
    
        if (r3.equals("CG") != false) goto L780;
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x068a, code lost:
    
        if (r3.equals("NI") != false) goto L807;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x06a2, code lost:
    
        if (r3.equals("NF") != false) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:0x06a9, code lost:
    
        return new int[]{3, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:509:0x06b0, code lost:
    
        if (r3.equals("NE") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x06ba, code lost:
    
        if (r3.equals("NC") != false) goto L513;
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x06c1, code lost:
    
        return new int[]{2, 3, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:520:0x06d6, code lost:
    
        if (r3.equals("MZ") != false) goto L521;
     */
    /* JADX WARN: Code restructure failed: missing block: B:522:0x06dd, code lost:
    
        return new int[]{3, 1, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x072a, code lost:
    
        if (r3.equals("MT") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0734, code lost:
    
        if (r3.equals("MS") != false) goto L908;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x073e, code lost:
    
        if (r3.equals("MR") != false) goto L551;
     */
    /* JADX WARN: Code restructure failed: missing block: B:552:0x0745, code lost:
    
        return new int[]{4, 3, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:558:0x075a, code lost:
    
        if (r3.equals("MP") != false) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x0761, code lost:
    
        return new int[]{1, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:570:0x0784, code lost:
    
        if (r3.equals("MM") != false) goto L629;
     */
    /* JADX WARN: Code restructure failed: missing block: B:573:0x078e, code lost:
    
        if (r3.equals("ML") != false) goto L811;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x07a6, code lost:
    
        if (r3.equals("MH") != false) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:582:0x07ad, code lost:
    
        return new int[]{4, 2, 2, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x07b4, code lost:
    
        if (r3.equals("MG") != false) goto L780;
     */
    /* JADX WARN: Code restructure failed: missing block: B:599:0x07e8, code lost:
    
        if (r3.equals("MC") != false) goto L600;
     */
    /* JADX WARN: Code restructure failed: missing block: B:601:0x07ef, code lost:
    
        return new int[]{1, 2, 2, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:607:0x0804, code lost:
    
        if (r3.equals("LY") != false) goto L873;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x080e, code lost:
    
        if (r3.equals("LV") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:621:0x0834, code lost:
    
        if (r3.equals("LS") != false) goto L622;
     */
    /* JADX WARN: Code restructure failed: missing block: B:623:0x083b, code lost:
    
        return new int[]{4, 3, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:625:0x0842, code lost:
    
        if (r3.equals("LR") != false) goto L796;
     */
    /* JADX WARN: Code restructure failed: missing block: B:628:0x084c, code lost:
    
        if (r3.equals("LK") != false) goto L629;
     */
    /* JADX WARN: Code restructure failed: missing block: B:630:0x0853, code lost:
    
        return new int[]{3, 2, 3, 3, 4, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:632:0x085a, code lost:
    
        if (r3.equals("LI") != false) goto L908;
     */
    /* JADX WARN: Code restructure failed: missing block: B:651:0x089c, code lost:
    
        if (r3.equals("KY") != false) goto L900;
     */
    /* JADX WARN: Code restructure failed: missing block: B:654:0x08a6, code lost:
    
        if (r3.equals("KW") != false) goto L744;
     */
    /* JADX WARN: Code restructure failed: missing block: B:661:0x08be, code lost:
    
        if (r3.equals("KN") != false) goto L900;
     */
    /* JADX WARN: Code restructure failed: missing block: B:664:0x08c8, code lost:
    
        if (r3.equals("KM") != false) goto L665;
     */
    /* JADX WARN: Code restructure failed: missing block: B:666:0x08cf, code lost:
    
        return new int[]{4, 3, 3, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:668:0x08d6, code lost:
    
        if (r3.equals("KI") != false) goto L669;
     */
    /* JADX WARN: Code restructure failed: missing block: B:670:0x08dd, code lost:
    
        return new int[]{4, 2, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00be, code lost:
    
        if (r3.equals("BQ") != false) goto L900;
     */
    /* JADX WARN: Code restructure failed: missing block: B:688:0x091c, code lost:
    
        if (r3.equals("JO") != false) goto L904;
     */
    /* JADX WARN: Code restructure failed: missing block: B:695:0x0934, code lost:
    
        if (r3.equals("JE") != false) goto L722;
     */
    /* JADX WARN: Code restructure failed: missing block: B:702:0x094b, code lost:
    
        if (r3.equals("IS") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:721:0x098d, code lost:
    
        if (r3.equals("IM") != false) goto L722;
     */
    /* JADX WARN: Code restructure failed: missing block: B:723:0x0994, code lost:
    
        return new int[]{0, 2, 0, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:737:0x09c5, code lost:
    
        if (r3.equals("HU") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:740:0x09cf, code lost:
    
        if (r3.equals("HT") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x09d9, code lost:
    
        if (r3.equals("HR") != false) goto L744;
     */
    /* JADX WARN: Code restructure failed: missing block: B:745:0x09e0, code lost:
    
        return new int[]{1, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:779:0x0a57, code lost:
    
        if (r3.equals("EG") != false) goto L780;
     */
    /* JADX WARN: Code restructure failed: missing block: B:781:0x0a5e, code lost:
    
        return new int[]{3, 4, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:783:0x0a65, code lost:
    
        if (r3.equals("EE") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:785:0x0a6c, code lost:
    
        return new int[]{0, 0, 0, 0, 0, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:791:0x0a81, code lost:
    
        if (r3.equals("DZ") != false) goto L792;
     */
    /* JADX WARN: Code restructure failed: missing block: B:793:0x0a88, code lost:
    
        return new int[]{3, 3, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:795:0x0a8f, code lost:
    
        if (r3.equals("DO") != false) goto L796;
     */
    /* JADX WARN: Code restructure failed: missing block: B:797:0x0a96, code lost:
    
        return new int[]{3, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:799:0x0a9d, code lost:
    
        if (r3.equals("DM") != false) goto L900;
     */
    /* JADX WARN: Code restructure failed: missing block: B:806:0x0ab5, code lost:
    
        if (r3.equals("CR") != false) goto L807;
     */
    /* JADX WARN: Code restructure failed: missing block: B:808:0x0abc, code lost:
    
        return new int[]{2, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:810:0x0ac3, code lost:
    
        if (r3.equals("CD") != false) goto L811;
     */
    /* JADX WARN: Code restructure failed: missing block: B:812:0x0aca, code lost:
    
        return new int[]{3, 3, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:814:0x0ad1, code lost:
    
        if (r3.equals("CA") != false) goto L815;
     */
    /* JADX WARN: Code restructure failed: missing block: B:816:0x0ad8, code lost:
    
        return new int[]{0, 2, 1, 2, 3, 3};
     */
    /* JADX WARN: Code restructure failed: missing block: B:826:0x0afb, code lost:
    
        if (r3.equals("BI") != false) goto L827;
     */
    /* JADX WARN: Code restructure failed: missing block: B:828:0x0b02, code lost:
    
        return new int[]{4, 4, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f2, code lost:
    
        if (r3.equals("BL") != false) goto L559;
     */
    /* JADX WARN: Code restructure failed: missing block: B:834:0x0b17, code lost:
    
        if (r3.equals("BG") != false) goto L835;
     */
    /* JADX WARN: Code restructure failed: missing block: B:836:0x0b1e, code lost:
    
        return new int[]{0, 0, 0, 0, 1, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:838:0x0b25, code lost:
    
        if (r3.equals("BF") != false) goto L839;
     */
    /* JADX WARN: Code restructure failed: missing block: B:840:0x0b2c, code lost:
    
        return new int[]{4, 3, 4, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:850:0x0b4f, code lost:
    
        if (r3.equals("AZ") != false) goto L873;
     */
    /* JADX WARN: Code restructure failed: missing block: B:857:0x0b66, code lost:
    
        if (r3.equals("AI") != false) goto L900;
     */
    /* JADX WARN: Code restructure failed: missing block: B:872:0x0b9a, code lost:
    
        if (r3.equals("DJ") != false) goto L873;
     */
    /* JADX WARN: Code restructure failed: missing block: B:874:0x0ba1, code lost:
    
        return new int[]{4, 2, 3, 3, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:876:0x0ba8, code lost:
    
        if (r3.equals("AG") != false) goto L877;
     */
    /* JADX WARN: Code restructure failed: missing block: B:878:0x0baf, code lost:
    
        return new int[]{2, 4, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:880:0x0bb6, code lost:
    
        if (r3.equals("AF") != false) goto L881;
     */
    /* JADX WARN: Code restructure failed: missing block: B:882:0x0bbd, code lost:
    
        return new int[]{4, 4, 3, 4, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:888:0x0bd2, code lost:
    
        if (r3.equals("AD") != false) goto L900;
     */
    /* JADX WARN: Code restructure failed: missing block: B:891:0x0bdb, code lost:
    
        if (r3.equals("BZ") != false) goto L892;
     */
    /* JADX WARN: Code restructure failed: missing block: B:893:0x0be2, code lost:
    
        return new int[]{2, 2, 2, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:899:0x0bf7, code lost:
    
        if (r3.equals("BB") != false) goto L900;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x010a, code lost:
    
        if (r3.equals("AT") != false) goto L784;
     */
    /* JADX WARN: Code restructure failed: missing block: B:901:0x0bfe, code lost:
    
        return new int[]{1, 2, 0, 0, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:903:0x0c05, code lost:
    
        if (r3.equals("BA") != false) goto L904;
     */
    /* JADX WARN: Code restructure failed: missing block: B:905:0x0c0c, code lost:
    
        return new int[]{1, 1, 1, 1, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:907:0x0c13, code lost:
    
        if (r3.equals("AX") != false) goto L908;
     */
    /* JADX WARN: Code restructure failed: missing block: B:909:0x0c1a, code lost:
    
        return new int[]{0, 2, 2, 2, 2, 2};
     */
    /* JADX WARN: Code restructure failed: missing block: B:915:0x0c2f, code lost:
    
        if (r3.equals("AM") != false) goto L916;
     */
    /* JADX WARN: Code restructure failed: missing block: B:917:0x0c36, code lost:
    
        return new int[]{2, 3, 2, 3, 2, 2};
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] e(java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 6662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaap.e(java.lang.String):int[]");
    }

    @Override // com.google.android.gms.internal.ads.zzaam
    public final void a(zzoz zzozVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f22599c.f22591a;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzaaj zzaajVar = (zzaaj) it.next();
            if (zzaajVar.f22589b == zzozVar) {
                zzaajVar.f22590c = true;
                copyOnWriteArrayList.remove(zzaajVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaam
    public final void b(Handler handler, zzoz zzozVar) {
        zzozVar.getClass();
        zzaak zzaakVar = this.f22599c;
        CopyOnWriteArrayList copyOnWriteArrayList = zzaakVar.f22591a;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzaaj zzaajVar = (zzaaj) it.next();
            if (zzaajVar.f22589b == zzozVar) {
                zzaajVar.f22590c = true;
                copyOnWriteArrayList.remove(zzaajVar);
            }
        }
        zzaakVar.f22591a.add(new zzaaj(handler, zzozVar));
    }

    public final void c(long j2, final long j3, int i2) {
        final long j4;
        final int i3;
        if (i2 == 0) {
            if (j2 != 0) {
                j4 = j2;
            } else if (j3 == this.f22607k) {
                return;
            } else {
                j4 = 0;
            }
            i3 = 0;
        } else {
            j4 = j2;
            i3 = i2;
        }
        this.f22607k = j3;
        Iterator it = this.f22599c.f22591a.iterator();
        while (it.hasNext()) {
            final zzaaj zzaajVar = (zzaaj) it.next();
            if (!zzaajVar.f22590c) {
                zzaajVar.f22588a.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaai
                    @Override // java.lang.Runnable
                    public final void run() {
                        Object next;
                        Object objLast;
                        zzwg zzwgVar;
                        zzoz zzozVar = zzaajVar.f22589b;
                        zzoy zzoyVar = zzozVar.f35271d;
                        if (zzoyVar.f35263b.isEmpty()) {
                            zzwgVar = null;
                        } else {
                            List list = zzoyVar.f35263b;
                            if (list != null) {
                                if (list.isEmpty()) {
                                    throw new NoSuchElementException();
                                }
                                objLast = list.get(list.size() - 1);
                            } else if (list instanceof SortedSet) {
                                objLast = ((SortedSet) list).last();
                            } else {
                                Iterator it2 = list.iterator();
                                do {
                                    next = it2.next();
                                } while (it2.hasNext());
                                objLast = next;
                            }
                            zzwgVar = (zzwg) objLast;
                        }
                        final zzmv zzmvVarN = zzozVar.n(zzwgVar);
                        final int i4 = i3;
                        final long j5 = j4;
                        final long j6 = j3;
                        zzozVar.k(zzmvVarN, 1006, new zzdy(i4, j5, j6) { // from class: com.google.android.gms.internal.ads.zzoq

                            /* renamed from: b, reason: collision with root package name */
                            public final /* synthetic */ int f35257b;

                            /* renamed from: c, reason: collision with root package name */
                            public final /* synthetic */ long f35258c;

                            @Override // com.google.android.gms.internal.ads.zzdy
                            public final /* synthetic */ void zza(Object obj) {
                                ((zzmx) obj).f(this.f35256a, this.f35257b, this.f35258c);
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long d(int r10) {
        /*
            r9 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
            com.google.android.gms.internal.ads.zzgtg r1 = r9.f22598b
            java.lang.Object r0 = r1.get(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            r2 = 1000000(0xf4240, double:4.940656E-318)
            r4 = 0
            if (r0 != 0) goto L1f
            java.lang.Integer r10 = java.lang.Integer.valueOf(r4)
            java.lang.Object r10 = r1.get(r10)
            r0 = r10
            java.lang.Long r0 = (java.lang.Long) r0
            goto Lb9
        L1f:
            long r5 = r0.longValue()
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 != 0) goto Lb9
            java.lang.String r0 = r9.f22609m
            if (r0 != 0) goto L32
            java.lang.String r0 = ""
        L32:
            int[] r0 = e(r0)
            r1 = 2
            if (r10 == r1) goto La5
            r5 = 3
            if (r10 == r5) goto L93
            r6 = 4
            if (r10 == r6) goto L82
            r1 = 5
            if (r10 == r1) goto L71
            r5 = 7
            if (r10 == r5) goto La5
            r4 = 9
            if (r10 == r4) goto L60
            r1 = 10
            if (r10 == r1) goto L4f
            r0 = r2
            goto Lb5
        L4f:
            com.google.android.gms.internal.ads.zzgtd r10 = com.google.android.gms.internal.ads.zzaap.r
            r0 = r0[r6]
            com.google.android.gms.internal.ads.zzguy r10 = (com.google.android.gms.internal.ads.zzguy) r10
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            goto Lb5
        L60:
            com.google.android.gms.internal.ads.zzgtd r10 = com.google.android.gms.internal.ads.zzaap.s
            r0 = r0[r1]
            com.google.android.gms.internal.ads.zzguy r10 = (com.google.android.gms.internal.ads.zzguy) r10
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            goto Lb5
        L71:
            com.google.android.gms.internal.ads.zzgtd r10 = com.google.android.gms.internal.ads.zzaap.q
            r0 = r0[r5]
            com.google.android.gms.internal.ads.zzguy r10 = (com.google.android.gms.internal.ads.zzguy) r10
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            goto Lb5
        L82:
            com.google.android.gms.internal.ads.zzgtd r10 = com.google.android.gms.internal.ads.zzaap.p
            r0 = r0[r1]
            com.google.android.gms.internal.ads.zzguy r10 = (com.google.android.gms.internal.ads.zzguy) r10
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            goto Lb5
        L93:
            com.google.android.gms.internal.ads.zzgtd r10 = com.google.android.gms.internal.ads.zzaap.o
            r1 = 1
            r0 = r0[r1]
            com.google.android.gms.internal.ads.zzguy r10 = (com.google.android.gms.internal.ads.zzguy) r10
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
            goto Lb5
        La5:
            com.google.android.gms.internal.ads.zzgtd r10 = com.google.android.gms.internal.ads.zzaap.n
            r0 = r0[r4]
            com.google.android.gms.internal.ads.zzguy r10 = (com.google.android.gms.internal.ads.zzguy) r10
            java.lang.Object r10 = r10.get(r0)
            java.lang.Long r10 = (java.lang.Long) r10
            long r0 = r10.longValue()
        Lb5:
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        Lb9:
            if (r0 != 0) goto Lbf
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
        Lbf:
            long r0 = r0.longValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaap.d(int):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0058 A[Catch: all -> 0x0071, TRY_ENTER, TryCatch #0 {all -> 0x0071, blocks: (B:12:0x0012, B:15:0x0017, B:17:0x0032, B:27:0x005f, B:26:0x0058), top: B:40:0x0012 }] */
    @Override // com.google.android.gms.internal.ads.zzhz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void g(com.google.android.gms.internal.ads.zzhf r11, boolean r12) throws java.lang.Throwable {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            r1 = 1
            if (r12 == 0) goto Ld
            r11.getClass()     // Catch: java.lang.Throwable -> L55
            r11 = r1
            goto Le
        La:
            r4 = r10
            goto L7d
        Ld:
            r11 = r0
        Le:
            if (r11 != 0) goto L12
            monitor-exit(r10)
            return
        L12:
            int r11 = r10.f22601e     // Catch: java.lang.Throwable -> L71
            if (r11 <= 0) goto L17
            r0 = r1
        L17:
            com.google.android.gms.internal.ads.zzgqa.f(r0)     // Catch: java.lang.Throwable -> L71
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L71
            long r0 = r10.f22602f     // Catch: java.lang.Throwable -> L71
            long r0 = r11 - r0
            long r2 = r10.f22604h     // Catch: java.lang.Throwable -> L71
            int r9 = (int) r0     // Catch: java.lang.Throwable -> L71
            long r0 = (long) r9     // Catch: java.lang.Throwable -> L71
            long r2 = r2 + r0
            r10.f22604h = r2     // Catch: java.lang.Throwable -> L71
            long r0 = r10.f22605i     // Catch: java.lang.Throwable -> L71
            long r2 = r10.f22603g     // Catch: java.lang.Throwable -> L71
            long r0 = r0 + r2
            r10.f22605i = r0     // Catch: java.lang.Throwable -> L71
            if (r9 <= 0) goto L74
            float r0 = (float) r2     // Catch: java.lang.Throwable -> L71
            com.google.android.gms.internal.ads.zzabd r1 = r10.f22600d     // Catch: java.lang.Throwable -> L71
            double r2 = (double) r2     // Catch: java.lang.Throwable -> L71
            double r2 = java.lang.Math.sqrt(r2)     // Catch: java.lang.Throwable -> L71
            int r2 = (int) r2     // Catch: java.lang.Throwable -> L71
            r3 = 1174011904(0x45fa0000, float:8000.0)
            float r0 = r0 * r3
            float r3 = (float) r9     // Catch: java.lang.Throwable -> L71
            float r0 = r0 / r3
            r1.a(r0, r2)     // Catch: java.lang.Throwable -> L71
            long r2 = r10.f22604h     // Catch: java.lang.Throwable -> L71
            r4 = 2000(0x7d0, double:9.88E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L58
            long r2 = r10.f22605i     // Catch: java.lang.Throwable -> L55
            r4 = 524288(0x80000, double:2.590327E-318)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 < 0) goto L5f
            goto L58
        L55:
            r0 = move-exception
            r11 = r0
            goto La
        L58:
            float r0 = r1.b()     // Catch: java.lang.Throwable -> L71
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L71
            r10.f22606j = r0     // Catch: java.lang.Throwable -> L71
        L5f:
            long r5 = r10.f22603g     // Catch: java.lang.Throwable -> L71
            long r7 = r10.f22606j     // Catch: java.lang.Throwable -> L71
            r4 = r10
            r4.c(r5, r7, r9)     // Catch: java.lang.Throwable -> L6e
            r4.f22602f = r11     // Catch: java.lang.Throwable -> L6e
            r11 = 0
            r4.f22603g = r11     // Catch: java.lang.Throwable -> L6e
            goto L75
        L6e:
            r0 = move-exception
        L6f:
            r11 = r0
            goto L7d
        L71:
            r0 = move-exception
            r4 = r10
            goto L6f
        L74:
            r4 = r10
        L75:
            int r11 = r4.f22601e     // Catch: java.lang.Throwable -> L6e
            int r11 = r11 + (-1)
            r4.f22601e = r11     // Catch: java.lang.Throwable -> L6e
            monitor-exit(r10)
            return
        L7d:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L6e
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaap.g(com.google.android.gms.internal.ads.zzhf, boolean):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final synchronized void l(zzgt zzgtVar, zzhf zzhfVar, boolean z) {
        boolean z2;
        if (z) {
            try {
                zzhfVar.getClass();
                z2 = true;
            } catch (Throwable th) {
                throw th;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            if (this.f22601e == 0) {
                this.f22602f = SystemClock.elapsedRealtime();
            }
            this.f22601e++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final synchronized void m(zzhf zzhfVar, boolean z, int i2) {
        boolean z2;
        if (z) {
            zzhfVar.getClass();
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f22603g += i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaam
    public final zzaap zze() {
        return this;
    }
}
