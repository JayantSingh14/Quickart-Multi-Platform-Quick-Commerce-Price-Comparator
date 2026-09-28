package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.SparseBooleanArray;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class zzchz extends zzcfb implements zzhz, zzmx {
    public static final /* synthetic */ int w = 0;

    /* renamed from: c, reason: collision with root package name */
    public final Context f26303c;

    /* renamed from: d, reason: collision with root package name */
    public final zzchj f26304d;

    /* renamed from: e, reason: collision with root package name */
    public final zzzu f26305e;

    /* renamed from: f, reason: collision with root package name */
    public final zzcfj f26306f;

    /* renamed from: g, reason: collision with root package name */
    public final WeakReference f26307g;

    /* renamed from: h, reason: collision with root package name */
    public final zzxn f26308h;

    /* renamed from: i, reason: collision with root package name */
    public zzms f26309i;

    /* renamed from: j, reason: collision with root package name */
    public ByteBuffer f26310j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f26311k;

    /* renamed from: l, reason: collision with root package name */
    public zzcfa f26312l;

    /* renamed from: m, reason: collision with root package name */
    public int f26313m;
    public int n;
    public long o;
    public final String p;
    public final int q;
    public Integer s;
    public final ArrayList t;
    public volatile zzchm u;
    public final Object r = new Object();
    public final HashSet v = new HashSet();

    /* JADX WARN: Removed duplicated region for block: B:24:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzchz(android.content.Context r6, com.google.android.gms.internal.ads.zzcfj r7, com.google.android.gms.internal.ads.zzcfk r8, java.lang.Integer r9) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchz.<init>(android.content.Context, com.google.android.gms.internal.ads.zzcfj, com.google.android.gms.internal.ads.zzcfk, java.lang.Integer):void");
    }

    public final void A() {
        String str;
        boolean zC;
        Context context;
        zzms zzmsVar = this.f26309i;
        if (zzmsVar != null) {
            zzmsVar.f35227c.b();
            zzkp zzkpVar = zzmsVar.f35226b;
            zzkpVar.o();
            zzkpVar.r.f35273f.b(this);
            zzms zzmsVar2 = this.f26309i;
            zzmsVar2.f35227c.b();
            zzkp zzkpVar2 = zzmsVar2.f35226b;
            zzkpVar2.getClass();
            String hexString = Integer.toHexString(System.identityHashCode(zzkpVar2));
            String str2 = zzfj.f31254a;
            HashSet hashSet = zzal.f23451a;
            synchronized (zzal.class) {
                str = zzal.f23452b;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 41 + String.valueOf(str2).length() + 3 + String.valueOf(str).length() + 1);
            android.support.v4.media.b.B(sb, "Release ", hexString, " [AndroidXMedia3/1.9.0-alpha01] [", str2);
            sb.append("] [");
            sb.append(str);
            sb.append("]");
            zzee.b("ExoPlayerImpl", sb.toString());
            zzkpVar2.o();
            zzkpVar2.x.a(false);
            zzfp zzfpVar = zzkpVar2.y;
            if (zzfpVar.f31532a) {
                zzfpVar.f31532a = false;
            }
            zzko zzkoVar = zzkpVar2.C;
            if (zzkoVar != null && Build.VERSION.SDK_INT >= 34 && (context = (Context) zzkoVar.f35032a.get()) != null) {
                context.unregisterDeviceIdChangeListener(zzkoVar.f35033b);
            }
            zzfa zzfaVar = zzkpVar2.B;
            zzfaVar.f30709e.zzm();
            zzaz zzazVar = zzfaVar.f30706b;
            zzkp zzkpVar3 = (zzkp) zzfaVar.f30705a;
            zzkpVar3.o();
            zzazVar.getClass();
            zzkpVar3.f35046m.b(zzazVar);
            zzlc zzlcVar = zzkpVar2.f35045l;
            if (zzlcVar.H || !zzlcVar.f35077j.getThread().isAlive()) {
                zC = true;
            } else {
                zzlcVar.H = true;
                zzdq zzdqVar = new zzdq();
                ((zzfd) zzlcVar.f35075h.g(7, zzdqVar)).a();
                zC = zzdqVar.c(zzlcVar.t);
            }
            if (!zC) {
                zzed zzedVar = zzkpVar2.f35046m;
                zzedVar.c(10, zzkd.f35021a);
                zzedVar.d();
            }
            zzkpVar2.f35046m.e();
            zzkpVar2.f35043j.zzm();
            zzaam zzaamVar = zzkpVar2.t;
            final zzoz zzozVar = zzkpVar2.r;
            zzaamVar.a(zzozVar);
            zzkpVar2.X.getClass();
            zzma zzmaVarK = zzkp.k(zzkpVar2.X, 1);
            zzkpVar2.X = zzmaVarK;
            zzma zzmaVarG = zzmaVarK.g(zzmaVarK.f35180b);
            zzkpVar2.X = zzmaVarG;
            zzmaVarG.p = zzmaVarG.r;
            zzkpVar2.X.q = 0L;
            zzdx zzdxVar = zzozVar.f35275h;
            zzdxVar.getClass();
            zzdxVar.e(new Runnable() { // from class: com.google.android.gms.internal.ads.zzmy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzoz zzozVar2 = zzozVar;
                    zzozVar2.k(zzozVar2.l(), 1028, new zzor());
                    zzozVar2.f35273f.e();
                }
            });
            Surface surface = zzkpVar2.M;
            if (surface != null) {
                surface.release();
                zzkpVar2.M = null;
            }
            zzgux zzguxVar = zzcz.f27441a;
            zzkpVar2.V = true;
            this.f26309i = null;
            zzcfb.f26059b.decrementAndGet();
        }
    }

    public final void B() {
        zzms zzmsVar = this.f26309i;
        zzmsVar.f35227c.b();
        zzkp zzkpVar = zzmsVar.f35226b;
        zzkpVar.o();
        zzkpVar.d(null);
        zzgtd zzgtdVar = zzguy.f33232e;
        long j2 = zzkpVar.X.r;
        new zzcz(zzgtdVar);
    }

    public final void C(int i2) {
        zzchj zzchjVar = this.f26304d;
        synchronized (zzchjVar) {
            zzchjVar.f26264d = i2 * 1000;
        }
    }

    public final void D(int i2) {
        zzchj zzchjVar = this.f26304d;
        synchronized (zzchjVar) {
            zzchjVar.f26265e = i2 * 1000;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void b(zzbv zzbvVar) {
        zzcfa zzcfaVar = this.f26312l;
        if (zzcfaVar != null) {
            zzcfaVar.b(zzbvVar.f25578a, zzbvVar.f25579b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void c(int i2) {
        zzcfa zzcfaVar = this.f26312l;
        if (zzcfaVar != null) {
            zzcfaVar.K(i2);
        }
    }

    public final void finalize() {
        zzcfb.f26058a.decrementAndGet();
        if (com.google.android.gms.ads.internal.util.zze.m()) {
            com.google.android.gms.ads.internal.util.zze.k("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void h(IOException iOException) {
        zzcfa zzcfaVar = this.f26312l;
        if (zzcfaVar != null) {
            if (this.f26306f.f26094j) {
                zzcfaVar.d(iOException);
            } else {
                zzcfaVar.c("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void j(int i2) {
        this.n += i2;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void k(zzv zzvVar) {
        zzcfk zzcfkVar = (zzcfk) this.f26307g.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l2)).booleanValue() || zzcfkVar == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = zzvVar.f35690l;
        if (str != null) {
            map.put("audioMime", str);
        }
        String str2 = zzvVar.f35691m;
        if (str2 != null) {
            map.put("audioSampleMime", str2);
        }
        String str3 = zzvVar.f35688j;
        if (str3 != null) {
            map.put("audioCodec", str3);
        }
        zzcfkVar.g("onMetadataEvent", map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzhz
    public final void l(zzgt zzgtVar, zzhf zzhfVar, boolean z) {
        if (zzgtVar instanceof zzhu) {
            synchronized (this.r) {
                this.t.add((zzhu) zzgtVar);
            }
        } else if (zzgtVar instanceof zzchm) {
            this.u = (zzchm) zzgtVar;
            final zzcfk zzcfkVar = (zzcfk) this.f26307g.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l2)).booleanValue() && zzcfkVar != null && this.u.o) {
                final HashMap map = new HashMap();
                map.put("gcacheHit", String.valueOf(this.u.q));
                map.put("gcacheDownloaded", String.valueOf(this.u.r));
                com.google.android.gms.ads.internal.util.zzs.f21608l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchy
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        int i2 = zzchz.w;
                        zzcfkVar.g("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void m(zzhf zzhfVar, boolean z, int i2) {
        this.f26313m += i2;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void n(zzau zzauVar) {
        zzcfa zzcfaVar = this.f26312l;
        if (zzcfaVar != null) {
            zzcfaVar.c("onPlayerError", zzauVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void o(zzv zzvVar) {
        zzcfk zzcfkVar = (zzcfk) this.f26307g.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.l2)).booleanValue() || zzcfkVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("frameRate", String.valueOf(zzvVar.x));
        map.put("bitRate", String.valueOf(zzvVar.f35687i));
        int i2 = zzvVar.t;
        int length = String.valueOf(i2).length();
        int i3 = zzvVar.u;
        StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(i3).length());
        sb.append(i2);
        sb.append("x");
        sb.append(i3);
        map.put("resolution", sb.toString());
        String str = zzvVar.f35690l;
        if (str != null) {
            map.put("videoMime", str);
        }
        String str2 = zzvVar.f35691m;
        if (str2 != null) {
            map.put("videoSampleMime", str2);
        }
        String str3 = zzvVar.f35688j;
        if (str3 != null) {
            map.put("videoCodec", str3);
        }
        zzcfkVar.g("onMetadataEvent", map);
    }

    public final boolean p() {
        return this.f26309i != null;
    }

    public final void q(boolean z) {
        zzms zzmsVar = this.f26309i;
        zzmsVar.f35227c.b();
        zzkp zzkpVar = zzmsVar.f35226b;
        zzkpVar.o();
        zzma zzmaVar = zzkpVar.X;
        int i2 = zzmaVar.n;
        int i3 = 0;
        if (i2 == 1) {
            if (z) {
                i2 = 1;
            } else {
                i2 = 1;
                i3 = 1;
            }
        }
        if (zzmaVar.f35190l == z && i2 == i3 && zzmaVar.f35191m == 1) {
            return;
        }
        zzkpVar.D++;
        zzma zzmaVarH = zzmaVar.h(1, i3, z);
        ((zzfd) zzkpVar.f35045l.f35075h.b(1, z ? 1 : 0, (i3 << 4) | 1)).a();
        zzkpVar.h(zzmaVarH, 0, false, 5, -9223372036854775807L, -1);
    }

    public final void r(int i2) {
        zzchj zzchjVar = this.f26304d;
        synchronized (zzchjVar) {
            zzchjVar.f26262b = i2 * 1000;
        }
    }

    public final void s(int i2) {
        zzchj zzchjVar = this.f26304d;
        synchronized (zzchjVar) {
            zzchjVar.f26263c = i2 * 1000;
        }
    }

    public final long t() {
        if (this.u == null || !this.u.p) {
            return this.f26313m;
        }
        return 0L;
    }

    public final long u() {
        if (this.u != null && this.u.p && this.u.q) {
            return Math.min(this.f26313m, this.u.s);
        }
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long v() {
        if (this.u != null && this.u.p) {
            final zzchm zzchmVar = this.u;
            if (zzchmVar.n != null) {
                AtomicLong atomicLong = zzchmVar.u;
                if (atomicLong.get() != -1) {
                    return atomicLong.get();
                }
                synchronized (zzchmVar) {
                    try {
                        if (zzchmVar.t == null) {
                            zzchmVar.t = ((zzgxi) zzcdo.f25982a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzchl
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    long j2;
                                    zzchm zzchmVar2 = zzchmVar;
                                    zzchmVar2.getClass();
                                    zzber zzberVar = com.google.android.gms.ads.internal.zzt.C.f21686j;
                                    zzbev zzbevVar = zzchmVar2.n;
                                    synchronized (zzberVar.f24848c) {
                                        try {
                                            j2 = -2;
                                            if (zzberVar.f24851f != null) {
                                                if (zzberVar.f24849d.c()) {
                                                    try {
                                                        zzbex zzbexVar = zzberVar.f24851f;
                                                        Parcel parcelG = zzbexVar.g();
                                                        zzbcd.c(parcelG, zzbevVar);
                                                        Parcel parcelZ0 = zzbexVar.z0(3, parcelG);
                                                        long j3 = parcelZ0.readLong();
                                                        parcelZ0.recycle();
                                                        j2 = j3;
                                                    } catch (RemoteException e2) {
                                                        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                                        com.google.android.gms.ads.internal.util.client.zzo.d("Unable to call into cache service.", e2);
                                                    }
                                                }
                                            }
                                        } finally {
                                        }
                                    }
                                    return Long.valueOf(j2);
                                }
                            });
                        }
                    } finally {
                    }
                }
                if (zzchmVar.t.isDone()) {
                    try {
                        zzchmVar.u.compareAndSet(-1L, ((Long) zzchmVar.t.get()).longValue());
                        return zzchmVar.u.get();
                    } catch (InterruptedException | ExecutionException unused) {
                    }
                }
            }
            return -1L;
        }
        synchronized (this.r) {
            while (true) {
                ArrayList arrayList = this.t;
                if (!arrayList.isEmpty()) {
                    long j2 = this.o;
                    Map mapZzj = ((zzhu) arrayList.remove(0)).zzj();
                    long j3 = 0;
                    if (mapZzj != null) {
                        Iterator it = mapZzj.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            if (entry != null) {
                                try {
                                    if (entry.getKey() != null && zzgpj.d((CharSequence) entry.getKey(), "content-length") && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                        j3 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                        break;
                                    }
                                } catch (NumberFormatException unused2) {
                                    continue;
                                }
                            }
                        }
                    }
                    this.o = j2 + j3;
                }
            }
        }
        return this.o;
    }

    public final void w(boolean z) {
        zzzf zzzfVar;
        boolean zEquals;
        if (this.f26309i == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            zzms zzmsVar = this.f26309i;
            zzmsVar.f35227c.b();
            zzkp zzkpVar = zzmsVar.f35226b;
            zzkpVar.o();
            int length = zzkpVar.f35040g.length;
            if (i2 >= 2) {
                return;
            }
            zzzu zzzuVar = this.f26305e;
            synchronized (zzzuVar.f35989c) {
                zzzfVar = zzzuVar.f35991e;
            }
            zzzfVar.getClass();
            zzze zzzeVar = new zzze(zzzfVar);
            boolean z2 = !z;
            SparseBooleanArray sparseBooleanArray = zzzeVar.E;
            if (sparseBooleanArray.get(i2) != z2) {
                if (z) {
                    sparseBooleanArray.delete(i2);
                } else {
                    sparseBooleanArray.put(i2, true);
                }
            }
            zzzf zzzfVar2 = new zzzf(zzzeVar);
            synchronized (zzzuVar.f35989c) {
                zEquals = zzzuVar.f35991e.equals(zzzfVar2);
                zzzuVar.f35991e = zzzfVar2;
            }
            if (!zEquals) {
                if (zzzfVar2.A && zzzuVar.f35990d == null) {
                    zzee.c("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
                }
                zzaac zzaacVar = zzzuVar.f22576a;
                if (zzaacVar != null) {
                    ((zzlc) zzaacVar).f35075h.zzh(10);
                }
            }
            i2++;
        }
    }

    public final zzxo x(Uri uri) {
        zzz zzzVar = new zzz();
        zzzVar.f35942b = uri;
        zzak zzakVarA = zzzVar.a();
        int i2 = this.f26306f.f26090f;
        zzxn zzxnVar = this.f26308h;
        zzxnVar.f35847c = i2;
        zzakVarA.f23332b.getClass();
        return new zzxo(zzakVarA, zzxnVar.f35845a, zzxnVar.f35846b, zzxnVar.f35848d, zzxnVar.f35847c);
    }

    public final void y(Uri[] uriArr, String str) {
        z(uriArr, ByteBuffer.allocate(0), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(android.net.Uri[] r19, java.nio.ByteBuffer r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchz.z(android.net.Uri[], java.nio.ByteBuffer, boolean):void");
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zzo() {
        zzcfa zzcfaVar = this.f26312l;
        if (zzcfaVar != null) {
            zzcfaVar.k();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void g(zzhf zzhfVar, boolean z) {
    }
}
