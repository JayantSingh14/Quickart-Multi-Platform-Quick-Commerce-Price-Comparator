package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes4.dex */
final class zzkp extends zzf implements zzje {
    public static final /* synthetic */ int b0 = 0;
    public final zzdm A;
    public final zzfa B;
    public final zzko C;
    public int D;
    public int E;
    public boolean F;
    public final zzmp G;
    public final zzmq H;
    public final zzjd I;
    public zzax J;
    public zzan K;
    public Surface L;
    public Surface M;
    public final int N;
    public zzes O;
    public final zzd P;
    public float Q;
    public boolean R;
    public final boolean S;
    public boolean T;
    public final int U;
    public boolean V;
    public zzan W;
    public zzma X;
    public int Y;
    public long Z;
    public zzxz a0;

    /* renamed from: b, reason: collision with root package name */
    public final zzaae f35035b;

    /* renamed from: c, reason: collision with root package name */
    public final zzax f35036c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdq f35037d = new zzdq();

    /* renamed from: e, reason: collision with root package name */
    public final Context f35038e;

    /* renamed from: f, reason: collision with root package name */
    public final zzms f35039f;

    /* renamed from: g, reason: collision with root package name */
    public final zzmi[] f35040g;

    /* renamed from: h, reason: collision with root package name */
    public final zzmi[] f35041h;

    /* renamed from: i, reason: collision with root package name */
    public final zzaad f35042i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdx f35043j;

    /* renamed from: k, reason: collision with root package name */
    public final zzla f35044k;

    /* renamed from: l, reason: collision with root package name */
    public final zzlc f35045l;

    /* renamed from: m, reason: collision with root package name */
    public final zzed f35046m;
    public final CopyOnWriteArraySet n;
    public final zzbd o;
    public final ArrayList p;
    public final boolean q;
    public final zzoz r;
    public final Looper s;
    public final zzaam t;
    public final zzfc u;
    public final zzjl v;
    public final zzkk w;
    public final zzfo x;
    public final zzfp y;
    public final long z;

    static {
        zzal.a("media3.exoplayer");
    }

    public zzkp(zzjc zzjcVar, zzms zzmsVar) {
        try {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            String str = zzfj.f31254a;
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 38 + String.valueOf(str).length() + 1);
            sb.append("Init ");
            sb.append(hexString);
            sb.append(" [AndroidXMedia3/1.9.0-alpha01] [");
            sb.append(str);
            sb.append("]");
            zzee.b("ExoPlayerImpl", sb.toString());
            Context context = zzjcVar.f34982a;
            Looper looper = zzjcVar.f34990i;
            this.f35038e = context.getApplicationContext();
            zzfc zzfcVar = zzjcVar.f34983b;
            this.r = new zzoz(zzfcVar);
            this.U = zzjcVar.f34991j;
            this.P = zzjcVar.f34992k;
            this.N = zzjcVar.f34993l;
            this.R = false;
            this.z = zzjcVar.q;
            zzjl zzjlVar = new zzjl(this);
            this.v = zzjlVar;
            this.w = new zzkk();
            this.f35040g = ((zzchu) ((zzjb) zzjcVar.f34984c).f34981a).a(new Handler(looper), zzjlVar, zzjlVar);
            this.f35041h = new zzmi[2];
            int i2 = 0;
            while (true) {
                zzmi[] zzmiVarArr = this.f35041h;
                int length = zzmiVarArr.length;
                if (i2 >= 2) {
                    break;
                }
                zzmi zzmiVar = this.f35040g[i2];
                zzmiVarArr[i2] = null;
                i2++;
            }
            this.f35042i = (zzaad) zzjcVar.f34986e.zza();
            ((zziw) zzjcVar.f34985d).zza();
            this.t = (zzaam) ((zziy) zzjcVar.f34988g).zza();
            this.q = zzjcVar.f34994m;
            this.H = zzjcVar.n;
            this.G = zzjcVar.o;
            Looper looper2 = zzjcVar.f34990i;
            this.s = looper2;
            this.u = zzfcVar;
            this.f35039f = zzmsVar;
            this.f35046m = new zzed(new CopyOnWriteArraySet(), looper2, zzfcVar, new zzdz() { // from class: com.google.android.gms.internal.ads.zzkj
                @Override // com.google.android.gms.internal.ads.zzdz
                public final /* synthetic */ void a(Object obj, zzs zzsVar) {
                    this.f35027a.getClass();
                    ((zzaz) obj).zza();
                }
            }, true);
            this.n = new CopyOnWriteArraySet();
            this.p = new ArrayList();
            this.a0 = new zzxz();
            this.I = zzjd.f34995a;
            int length2 = this.f35040g.length;
            this.f35035b = new zzaae(new zzml[2], new zzzw[2], zzbn.f25323b, null);
            this.o = new zzbd();
            zzaw zzawVar = new zzaw();
            zzr zzrVar = zzawVar.f24424a;
            int[] iArr = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32};
            int i3 = 0;
            for (int i4 = 20; i3 < i4; i4 = 20) {
                zzrVar.a(iArr[i3]);
                i3++;
            }
            this.f35042i.b();
            zzawVar.a(29, true);
            zzs zzsVarB = zzrVar.b();
            this.f35036c = new zzax(zzsVarB);
            zzr zzrVar2 = new zzaw().f24424a;
            int i5 = 0;
            while (true) {
                SparseBooleanArray sparseBooleanArray = zzsVarB.f35478a;
                if (i5 >= sparseBooleanArray.size()) {
                    break;
                }
                zzgqa.i(i5, sparseBooleanArray.size());
                zzrVar2.a(sparseBooleanArray.keyAt(i5));
                i5++;
            }
            zzrVar2.a(4);
            zzrVar2.a(10);
            this.J = new zzax(zzrVar2.b());
            this.f35043j = this.u.a(this.s, null);
            zzjm zzjmVar = new zzjm(this);
            this.f35044k = zzjmVar;
            this.X = zzma.a(this.f35035b);
            this.r.q(this.f35039f, this.s);
            final zzpn zzpnVar = new zzpn(zzjcVar.x);
            zzlc zzlcVar = new zzlc(this.f35038e, this.f35040g, this.f35041h, this.f35042i, this.f35035b, (zzlg) zzjcVar.f34987f.zza(), this.t, this.r, this.H, zzjcVar.y, zzjcVar.p, this.s, this.u, zzjmVar, zzpnVar, this.I, this.w);
            Looper looper3 = zzlcVar.f35077j;
            zzdx zzdxVar = zzlcVar.f35075h;
            this.f35045l = zzlcVar;
            this.Q = 1.0f;
            zzan zzanVar = zzan.B;
            this.K = zzanVar;
            this.W = zzanVar;
            this.Y = -1;
            zzgux zzguxVar = zzcz.f27441a;
            this.S = true;
            zzoz zzozVar = this.r;
            zzozVar.getClass();
            this.f35046m.a(zzozVar);
            this.t.b(new Handler(this.s), this.r);
            this.n.add(this.v);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 31) {
                final Context context2 = this.f35038e;
                final boolean z = zzjcVar.v;
                ((zzfe) this.u.a(looper3, null)).e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjf
                    @Override // java.lang.Runnable
                    public final void run() {
                        Context context3 = context2;
                        MediaMetricsManager mediaMetricsManagerF = androidx.core.os.a.f(context3.getSystemService("media_metrics"));
                        zzpj zzpjVar = mediaMetricsManagerF == null ? null : new zzpj(context3, mediaMetricsManagerF.createPlaybackSession());
                        if (zzpjVar == null) {
                            zzee.c("ExoPlayerImpl", "MediaMetricsService unavailable.");
                            return;
                        }
                        if (z) {
                            this.c(zzpjVar);
                        }
                        zzpn zzpnVar2 = zzpnVar;
                        LogSessionId sessionId = zzpjVar.f35314d.getSessionId();
                        synchronized (zzpnVar2) {
                            zzpm zzpmVar = zzpnVar2.f35327b;
                            if (zzpmVar == null) {
                                throw null;
                            }
                            LogSessionId logSessionId = zzpmVar.f35324a;
                            LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
                            zzgqa.f(logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE));
                            zzpmVar.f35324a = sessionId;
                        }
                    }
                });
            }
            zzdm zzdmVar = new zzdm(looper3, this.s, this.u, new zzjx(this));
            this.A = zzdmVar;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzkc
                @Override // java.lang.Runnable
                public final void run() {
                    zzkp zzkpVar = this.f35020a;
                    zzkpVar.getClass();
                    String str2 = zzfj.f31254a;
                    int iGenerateAudioSessionId = zzcj.a(zzkpVar.f35038e).generateAudioSessionId();
                    if (iGenerateAudioSessionId == -1) {
                        iGenerateAudioSessionId = 0;
                    }
                    final Integer numValueOf = Integer.valueOf(iGenerateAudioSessionId);
                    final zzdm zzdmVar2 = zzkpVar.A;
                    zzdmVar2.f27921e = numValueOf;
                    Runnable runnable2 = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdi
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdm zzdmVar3 = zzdmVar2;
                            if (zzdmVar3.f27922f == 0) {
                                Integer num = numValueOf;
                                Object obj = zzdmVar3.f27920d;
                                zzdmVar3.f27920d = num;
                                if (obj.equals(num)) {
                                    return;
                                }
                                zzjx zzjxVar = (zzjx) zzdmVar3.f27919c;
                                zzjxVar.getClass();
                                int iIntValue = num.intValue();
                                zzkp zzkpVar2 = zzjxVar.f35015a;
                                zzkpVar2.o();
                                zzkpVar2.p(1, 10, num);
                                zzkpVar2.p(2, 10, num);
                                zzka zzkaVar = new zzka(iIntValue);
                                zzed zzedVar = zzkpVar2.f35046m;
                                zzedVar.c(21, zzkaVar);
                                zzedVar.d();
                            }
                        }
                    };
                    zzdx zzdxVar2 = zzdmVar2.f27918b;
                    if (zzdxVar2.zza().getThread().isAlive()) {
                        zzdxVar2.e(runnable2);
                    }
                }
            };
            zzdx zzdxVar2 = zzdmVar.f27917a;
            if (zzdxVar2.zza().getThread().isAlive()) {
                zzdxVar2.e(runnable);
            }
            zzfc zzfcVar2 = this.u;
            zzbz zzbzVar = new zzbz();
            context.getApplicationContext();
            zzfcVar2.a(looper3, null);
            new zzbx(zzbzVar, zzfcVar2.a(looper, null));
            boolean z2 = (zzjcVar.s == Integer.MAX_VALUE || zzjcVar.t == Integer.MAX_VALUE) ? false : true;
            zzfo zzfoVar = new zzfo(context, looper3, this.u);
            this.x = zzfoVar;
            if (zzfoVar.f31517d != z2) {
                zzfoVar.f31517d = z2;
                zzfoVar.b(z2, zzfoVar.f31518e);
            }
            zzfc zzfcVar3 = this.u;
            zzfp zzfpVar = new zzfp();
            context.getApplicationContext();
            zzfcVar3.a(looper3, null);
            zzfcVar3.a(Looper.getMainLooper(), null);
            this.y = zzfpVar;
            int i7 = zzm.f35178a;
            zzbv zzbvVar = zzbv.f25577d;
            this.O = zzes.f30200c;
            this.C = i6 >= 34 ? new zzko(this, context) : null;
            this.B = new zzfa(this, this.v, this.u, zzjcVar.r, zzjcVar.s, zzjcVar.t, zzjcVar.u);
            ((zzfd) zzdxVar.g(38, this.G)).a();
            ((zzfd) zzdxVar.zzf(this.P)).a();
            p(1, 3, this.P);
            p(2, 4, Integer.valueOf(this.N));
            p(2, 5, 0);
            p(1, 9, Boolean.valueOf(this.R));
            p(6, 8, this.w);
            p(-1, 16, Integer.valueOf(this.U));
            this.f35037d.a();
        } catch (Throwable th) {
            this.f35037d.a();
            throw th;
        }
    }

    public static long i(zzma zzmaVar) {
        zzbe zzbeVar = new zzbe();
        zzbd zzbdVar = new zzbd();
        zzbf zzbfVar = zzmaVar.f35179a;
        zzbfVar.o(zzmaVar.f35180b.f35758a, zzbdVar);
        long j2 = zzmaVar.f35181c;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        zzbfVar.b(zzbdVar.f24739c, zzbeVar, 0L).getClass();
        return 0L;
    }

    public static zzma k(zzma zzmaVar, int i2) {
        zzma zzmaVarD = zzmaVar.d(i2);
        return (i2 == 1 || i2 == 4) ? zzmaVarD.f(false) : zzmaVarD;
    }

    public final void b(float f2) {
        o();
        String str = zzfj.f31254a;
        float fMax = Math.max(0.0f, Math.min(f2, 1.0f));
        if (this.Q == fMax) {
            return;
        }
        this.Q = fMax;
        ((zzfd) this.f35045l.f35075h.g(32, Float.valueOf(fMax))).a();
        zzke zzkeVar = new zzke();
        zzed zzedVar = this.f35046m;
        zzedVar.c(22, zzkeVar);
        zzedVar.d();
    }

    public final void c(zzmx zzmxVar) {
        this.r.f35273f.a(zzmxVar);
    }

    public final void d(zzit zzitVar) {
        zzma zzmaVar = this.X;
        zzma zzmaVarG = zzmaVar.g(zzmaVar.f35180b);
        zzmaVarG.p = zzmaVarG.r;
        zzmaVarG.q = 0L;
        zzma zzmaVarK = k(zzmaVarG, 1);
        if (zzitVar != null) {
            zzmaVarK = zzmaVarK.e(zzitVar);
        }
        this.D++;
        ((zzfd) this.f35045l.f35075h.l(6)).a();
        h(zzmaVarK, 0, false, 5, -9223372036854775807L, -1);
    }

    public final int e(zzma zzmaVar) {
        zzbf zzbfVar = zzmaVar.f35179a;
        return zzbfVar.g() ? this.Y : zzbfVar.o(zzmaVar.f35180b.f35758a, this.o).f24739c;
    }

    public final long f(zzma zzmaVar) {
        zzwg zzwgVar = zzmaVar.f35180b;
        if (!zzwgVar.b()) {
            return zzfj.r(g(zzmaVar));
        }
        Object obj = zzwgVar.f35758a;
        zzbd zzbdVar = this.o;
        zzbf zzbfVar = zzmaVar.f35179a;
        zzbfVar.o(obj, zzbdVar);
        long j2 = zzmaVar.f35181c;
        if (j2 == -9223372036854775807L) {
            zzbfVar.b(e(zzmaVar), this.f30704a, 0L).getClass();
            return zzfj.r(0L);
        }
        return zzfj.r(j2) + zzfj.r(0L);
    }

    public final long g(zzma zzmaVar) {
        zzbf zzbfVar = zzmaVar.f35179a;
        if (zzbfVar.g()) {
            return zzfj.s(this.Z);
        }
        long j2 = zzmaVar.r;
        zzwg zzwgVar = zzmaVar.f35180b;
        if (zzwgVar.b()) {
            return j2;
        }
        zzbfVar.o(zzwgVar.f35758a, this.o);
        return j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:142:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0530 A[LOOP:0: B:264:0x0528->B:266:0x0530, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x054e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0559 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0564 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0578 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0585 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x059e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0545 A[EDGE_INSN: B:316:0x0545->B:267:0x0545 BREAK  A[LOOP:0: B:264:0x0528->B:266:0x0530], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(final com.google.android.gms.internal.ads.zzma r32, final int r33, boolean r34, int r35, long r36, int r38) {
        /*
            Method dump skipped, instructions count: 1503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkp.h(com.google.android.gms.internal.ads.zzma, int, boolean, int, long, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzma j(com.google.android.gms.internal.ads.zzma r23, com.google.android.gms.internal.ads.zzbf r24, android.util.Pair r25) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkp.j(com.google.android.gms.internal.ads.zzma, com.google.android.gms.internal.ads.zzbf, android.util.Pair):com.google.android.gms.internal.ads.zzma");
    }

    public final Pair l(zzbf zzbfVar, int i2, long j2) {
        if (zzbfVar.g()) {
            this.Y = i2;
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            this.Z = j2;
            return null;
        }
        if (i2 == -1 || i2 >= zzbfVar.a()) {
            i2 = zzbfVar.k(false);
            zzbfVar.b(i2, this.f30704a, 0L).getClass();
            j2 = zzfj.r(0L);
        }
        return zzbfVar.m(this.f30704a, this.o, i2, zzfj.s(j2));
    }

    public final void m(Surface surface) {
        Surface surface2 = this.L;
        boolean z = false;
        boolean zC = true;
        if (surface2 != null && surface2 != surface) {
            z = true;
        }
        long j2 = z ? this.z : -9223372036854775807L;
        zzlc zzlcVar = this.f35045l;
        if (!zzlcVar.H && zzlcVar.f35077j.getThread().isAlive()) {
            zzdq zzdqVar = new zzdq();
            ((zzfd) zzlcVar.f35075h.g(30, new Pair(surface, zzdqVar))).a();
            if (j2 != -9223372036854775807L) {
                zC = zzdqVar.c(j2);
            }
        }
        if (z) {
            Surface surface3 = this.L;
            Surface surface4 = this.M;
            if (surface3 == surface4) {
                surface4.release();
                this.M = null;
            }
        }
        this.L = surface;
        if (zC) {
            return;
        }
        d(new zzit(2, new zzld("Detaching surface timed out."), 1003));
    }

    public final void n(int i2, int i3) {
        zzes zzesVar = this.O;
        if (i2 == zzesVar.f30201a && i3 == zzesVar.f30202b) {
            return;
        }
        this.O = new zzes(i2, i3);
        zzjz zzjzVar = new zzjz();
        zzed zzedVar = this.f35046m;
        zzedVar.c(24, zzjzVar);
        zzedVar.d();
        p(2, 14, new zzes(i2, i3));
    }

    public final void o() {
        this.f35037d.b();
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.s;
        if (threadCurrentThread != looper.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = looper.getThread().getName();
            String str = zzfj.f31254a;
            Locale locale = Locale.US;
            String strM = android.support.v4.media.b.m("Player is accessed on the wrong thread.\nCurrent thread: '", name, "'\nExpected thread: '", name2, "'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread");
            if (this.S) {
                throw new IllegalStateException(strM);
            }
            zzee.d("ExoPlayerImpl", strM, this.T ? null : new IllegalStateException());
            this.T = true;
        }
    }

    public final void p(int i2, int i3, Object obj) {
        zzlc zzlcVar;
        zzmi[] zzmiVarArr = this.f35040g;
        int length = zzmiVarArr.length;
        int i4 = 0;
        while (true) {
            zzlcVar = this.f35045l;
            if (i4 >= 2) {
                break;
            }
            zzmi zzmiVar = zzmiVarArr[i4];
            if (i2 == -1 || zzmiVar.zza() == i2) {
                e(this.X);
                zzbf zzbfVar = this.X.f35179a;
                zzme zzmeVar = new zzme(zzlcVar, zzmiVar, zzlcVar.f35077j);
                zzgqa.f(!zzmeVar.f35201f);
                zzmeVar.f35198c = i3;
                zzgqa.f(!zzmeVar.f35201f);
                zzmeVar.f35199d = obj;
                zzgqa.f(!zzmeVar.f35201f);
                zzmeVar.f35201f = true;
                zzlcVar.b(zzmeVar);
            }
            i4++;
        }
        zzmi[] zzmiVarArr2 = this.f35041h;
        int length2 = zzmiVarArr2.length;
        for (int i5 = 0; i5 < 2; i5++) {
            zzmi zzmiVar2 = zzmiVarArr2[i5];
            if (zzmiVar2 != null && (i2 == -1 || zzmiVar2.zza() == i2)) {
                e(this.X);
                zzbf zzbfVar2 = this.X.f35179a;
                zzme zzmeVar2 = new zzme(zzlcVar, zzmiVar2, zzlcVar.f35077j);
                zzgqa.f(!zzmeVar2.f35201f);
                zzmeVar2.f35198c = i3;
                zzgqa.f(!zzmeVar2.f35201f);
                zzmeVar2.f35199d = obj;
                zzgqa.f(!zzmeVar2.f35201f);
                zzmeVar2.f35201f = true;
                zzlcVar.b(zzmeVar2);
            }
        }
    }

    public final int q() {
        o();
        if (this.X.f35179a.g()) {
            return 0;
        }
        zzma zzmaVar = this.X;
        return zzmaVar.f35179a.e(zzmaVar.f35180b.f35758a);
    }

    public final long r() {
        o();
        if (!v()) {
            zzbf zzbfVarZzq = zzq();
            if (zzbfVarZzq.g()) {
                return -9223372036854775807L;
            }
            return zzfj.r(zzbfVarZzq.b(zzs(), this.f30704a, 0L).f24832j);
        }
        zzma zzmaVar = this.X;
        zzwg zzwgVar = zzmaVar.f35180b;
        Object obj = zzwgVar.f35758a;
        zzbf zzbfVar = zzmaVar.f35179a;
        zzbd zzbdVar = this.o;
        zzbfVar.o(obj, zzbdVar);
        return zzfj.r(zzbdVar.b(zzwgVar.f35759b, zzwgVar.f35760c));
    }

    public final long s() {
        o();
        return zzfj.r(g(this.X));
    }

    public final long t() {
        o();
        if (v()) {
            zzma zzmaVar = this.X;
            return zzmaVar.f35189k.equals(zzmaVar.f35180b) ? zzfj.r(this.X.p) : r();
        }
        o();
        if (this.X.f35179a.g()) {
            return this.Z;
        }
        zzma zzmaVar2 = this.X;
        long j2 = 0;
        if (zzmaVar2.f35189k.f35761d != zzmaVar2.f35180b.f35761d) {
            return zzfj.r(zzmaVar2.f35179a.b(zzs(), this.f30704a, 0L).f24832j);
        }
        long j3 = zzmaVar2.p;
        if (this.X.f35189k.b()) {
            zzma zzmaVar3 = this.X;
            zzmaVar3.f35179a.o(zzmaVar3.f35189k.f35758a, this.o).f24742f.a(this.X.f35189k.f35759b).getClass();
        } else {
            j2 = j3;
        }
        zzma zzmaVar4 = this.X;
        zzmaVar4.f35179a.o(zzmaVar4.f35189k.f35758a, this.o);
        return zzfj.r(j2);
    }

    public final long u() {
        o();
        return zzfj.r(this.X.q);
    }

    public final boolean v() {
        o();
        return this.X.f35180b.b();
    }

    public final int w() {
        o();
        if (v()) {
            return this.X.f35180b.f35759b;
        }
        return -1;
    }

    public final int x() {
        o();
        if (v()) {
            return this.X.f35180b.f35760c;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzh() {
        o();
        return this.X.f35183e;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzi() {
        o();
        return this.X.n;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzk() {
        o();
        return this.X.f35190l;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzl() {
        o();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzm() {
        o();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbf zzq() {
        o();
        return this.X.f35179a;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzs() {
        o();
        int iE = e(this.X);
        if (iE == -1) {
            return 0;
        }
        return iE;
    }
}
