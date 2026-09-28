package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public final class zzchd extends zzcgx implements zzhz {
    public static final AtomicInteger o = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    public String f26229d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcfj f26230e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f26231f;

    /* renamed from: g, reason: collision with root package name */
    public final zzchc f26232g;

    /* renamed from: h, reason: collision with root package name */
    public final zzcgg f26233h;

    /* renamed from: i, reason: collision with root package name */
    public ByteBuffer f26234i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f26235j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f26236k;

    /* renamed from: l, reason: collision with root package name */
    public final String f26237l;

    /* renamed from: m, reason: collision with root package name */
    public final int f26238m;
    public boolean n;

    public zzchd(zzcfk zzcfkVar, zzcfj zzcfjVar) {
        super(zzcfkVar);
        this.f26230e = zzcfjVar;
        this.f26232g = new zzchc();
        this.f26233h = new zzcgg();
        this.f26236k = new Object();
        String strZzn = zzcfkVar.zzn();
        this.f26237l = (String) (strZzn == null ? zzgph.f33051a : new zzgqf(strZzn)).a();
        this.f26238m = zzcfkVar.zzp();
        o.incrementAndGet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v12, types: [com.google.android.gms.internal.ads.zzcge] */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.google.android.gms.internal.ads.zzcgx, com.google.android.gms.internal.ads.zzchd, com.google.android.gms.internal.ads.zzhz] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v9, types: [boolean] */
    @Override // com.google.android.gms.internal.ads.zzcgx
    public final boolean e(String str) throws IOException {
        String str2;
        ?? r6;
        zzhm zzhmVar;
        Clock clock;
        String str3 = str;
        this.f26229d = str3;
        String str4 = "error";
        String strConcat = "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.d(str3, MessageDigestAlgorithms.MD5)));
        try {
            zzhi zzhiVar = new zzhi();
            zzhiVar.f33843c = this.f26216b;
            zzcfj zzcfjVar = this.f26230e;
            zzhiVar.f33844d = zzcfjVar.f26088d;
            zzhiVar.f33845e = zzcfjVar.f26089e;
            zzhiVar.f33846f = true;
            zzhiVar.f33842b = this;
            zzhm zzhmVarZza = zzhiVar.zza();
            if (zzcfjVar.f26093i) {
                zzhmVarZza = new zzcge(this.f26215a, zzhmVarZza, this.f26237l, this.f26238m);
            }
            zzhmVarZza.a(new zzhf(Uri.parse(str3), 0L, -1L));
            zzcfk zzcfkVar = (zzcfk) this.f26217c.get();
            if (zzcfkVar != null) {
                zzcfkVar.T(strConcat, this);
            }
            Clock clock2 = com.google.android.gms.ads.internal.zzt.C.f21687k;
            long jCurrentTimeMillis = clock2.currentTimeMillis();
            zzbgb zzbgbVar = zzbgk.X;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            long jLongValue = ((Long) zzbdVar.f21153c.a(zzbgbVar)).longValue();
            long jLongValue2 = ((Long) zzbdVar.f21153c.a(zzbgk.W)).longValue();
            this.f26234i = ByteBuffer.allocate(zzcfjVar.f26087c);
            byte[] bArr = new byte[KEYRecord.Flags.FLAG2];
            long j2 = jCurrentTimeMillis;
            while (true) {
                try {
                    int iB = zzhmVarZza.b(0, bArr, Math.min(this.f26234i.remaining(), KEYRecord.Flags.FLAG2));
                    if (iB == -1) {
                        this.n = true;
                        str3 = str;
                        com.google.android.gms.ads.internal.util.client.zzf.f21413b.post(new zzcgv(this, str3, strConcat, (int) this.f26233h.a(this.f26234i)));
                        return true;
                    }
                    str3 = str;
                    str2 = str4;
                    try {
                        synchronized (this.f26236k) {
                            zzhmVar = zzhmVarZza;
                            try {
                                if (this.f26231f) {
                                    clock = clock2;
                                } else {
                                    clock = clock2;
                                    this.f26234i.put(bArr, 0, iB);
                                }
                            } finally {
                            }
                        }
                        if (this.f26234i.remaining() <= 0) {
                            s();
                            return true;
                        }
                        r6 = this.f26231f;
                        try {
                            if (r6 != 0) {
                                int iLimit = this.f26234i.limit();
                                StringBuilder sb = new StringBuilder(String.valueOf(iLimit).length() + 24);
                                sb.append("Precache abort at ");
                                sb.append(iLimit);
                                sb.append(" bytes");
                                throw new IOException(sb.toString());
                            }
                            long jCurrentTimeMillis2 = clock.currentTimeMillis();
                            if (jCurrentTimeMillis2 - j2 >= jLongValue) {
                                s();
                                j2 = jCurrentTimeMillis2;
                            }
                            if (jCurrentTimeMillis2 - jCurrentTimeMillis > 1000 * jLongValue2) {
                                StringBuilder sb2 = new StringBuilder(String.valueOf(jLongValue2).length() + 29);
                                sb2.append("Timeout exceeded. Limit: ");
                                sb2.append(jLongValue2);
                                sb2.append(" sec");
                                throw new IOException(sb2.toString());
                            }
                            str4 = str2;
                            zzhmVarZza = zzhmVar;
                            clock2 = clock;
                        } catch (Exception e2) {
                            e = e2;
                            String canonicalName = e.getClass().getCanonicalName();
                            String message = e.getMessage();
                            String strS = android.support.v4.media.b.s(new StringBuilder(String.valueOf(canonicalName).length() + 1 + String.valueOf(message).length()), canonicalName, ":", message);
                            String strN = android.support.v4.media.a.n(new StringBuilder(strS.length() + String.valueOf(str3).length() + 34), "Failed to preload url ", str3, " Exception: ", strS);
                            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.f(strN);
                            q(str3, strConcat, r6, strS);
                            return false;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        r6 = str2;
                        String canonicalName2 = e.getClass().getCanonicalName();
                        String message2 = e.getMessage();
                        String strS2 = android.support.v4.media.b.s(new StringBuilder(String.valueOf(canonicalName2).length() + 1 + String.valueOf(message2).length()), canonicalName2, ":", message2);
                        String strN2 = android.support.v4.media.a.n(new StringBuilder(strS2.length() + String.valueOf(str3).length() + 34), "Failed to preload url ", str3, " Exception: ", strS2);
                        int i22 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.f(strN2);
                        q(str3, strConcat, r6, strS2);
                        return false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    str3 = str;
                    str2 = str4;
                    r6 = str2;
                    String canonicalName22 = e.getClass().getCanonicalName();
                    String message22 = e.getMessage();
                    String strS22 = android.support.v4.media.b.s(new StringBuilder(String.valueOf(canonicalName22).length() + 1 + String.valueOf(message22).length()), canonicalName22, ":", message22);
                    String strN22 = android.support.v4.media.a.n(new StringBuilder(strS22.length() + String.valueOf(str3).length() + 34), "Failed to preload url ", str3, " Exception: ", strS22);
                    int i222 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f(strN22);
                    q(str3, strConcat, r6, strS22);
                    return false;
                }
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void l(zzgt zzgtVar, zzhf zzhfVar, boolean z) {
        if (zzgtVar instanceof zzhm) {
            this.f26232g.f26227a.add((zzhm) zzgtVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgx
    public final void p() {
        this.f26231f = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcgx, com.google.android.gms.common.api.Releasable
    public final void release() {
        o.decrementAndGet();
    }

    public final void s() {
        zzchc zzchcVar = this.f26232g;
        Iterator it = zzchcVar.f26227a.iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : ((zzhm) it.next()).zzj().entrySet()) {
                try {
                    if ("content-length".equalsIgnoreCase((String) entry.getKey())) {
                        zzchcVar.f26228b = Math.max(zzchcVar.f26228b, Long.parseLong((String) ((List) entry.getValue()).get(0)));
                    }
                } catch (RuntimeException unused) {
                }
            }
            it.remove();
        }
        int i2 = (int) zzchcVar.f26228b;
        int iA = (int) this.f26233h.a(this.f26234i);
        int iPosition = this.f26234i.position();
        int iRound = Math.round((iPosition / i2) * iA);
        int i3 = zzcfb.f26058a.get();
        int i4 = zzcfb.f26059b.get();
        String str = this.f26229d;
        com.google.android.gms.ads.internal.util.client.zzf.f21413b.post(new zzcgt(this, str, "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.d(str, MessageDigestAlgorithms.MD5))), iPosition, i2, iRound, iA, iRound > 0, i3, i4));
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void g(zzhf zzhfVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void m(zzhf zzhfVar, boolean z, int i2) {
    }
}
