package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class zzfqh {

    /* renamed from: c, reason: collision with root package name */
    public final zzfqz f31629c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfqd f31630d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f31631e;

    /* renamed from: f, reason: collision with root package name */
    public volatile ConnectivityManager f31632f;

    /* renamed from: h, reason: collision with root package name */
    public final Clock f31634h;

    /* renamed from: i, reason: collision with root package name */
    public AtomicInteger f31635i;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f31633g = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f31627a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f31628b = new ConcurrentHashMap();

    public zzfqh(zzfqz zzfqzVar, zzfqd zzfqdVar, Context context, Clock clock) {
        this.f31629c = zzfqzVar;
        this.f31630d = zzfqdVar;
        this.f31631e = context;
        this.f31634h = clock;
    }

    public static String a(String str, AdFormat adFormat) {
        String strName = adFormat == null ? "NULL" : adFormat.name();
        return android.support.v4.media.b.s(new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(strName).length()), str, "#", strName);
    }

    public final void b(boolean z) {
        synchronized (this) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.y)).booleanValue()) {
                c(z);
            }
        }
    }

    public final synchronized void c(boolean z) {
        try {
            if (z) {
                Iterator it = this.f31627a.values().iterator();
                while (it.hasNext()) {
                    ((zzfqy) it.next()).l();
                }
            } else {
                Iterator it2 = this.f31627a.values().iterator();
                while (it2.hasNext()) {
                    ((zzfqy) it2.next()).f31673g.set(false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00fe A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #0 {all -> 0x0048, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0015, B:8:0x0034, B:10:0x003c, B:13:0x004b, B:14:0x0051, B:16:0x0059, B:18:0x0067, B:19:0x0076, B:20:0x007a, B:21:0x007e, B:22:0x0088, B:24:0x008e, B:26:0x00a0, B:27:0x00b5, B:28:0x00bf, B:30:0x00c5, B:32:0x00ee, B:37:0x0105, B:39:0x010b, B:34:0x00fe, B:36:0x0104, B:43:0x0111, B:35:0x00ff), top: B:48:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized java.util.ArrayList d(java.util.ArrayList r9) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfqh.d(java.util.ArrayList):java.util.ArrayList");
    }

    public final synchronized boolean e(String str, AdFormat adFormat) {
        boolean z;
        try {
            Clock clock = this.f31634h;
            long jCurrentTimeMillis = clock.currentTimeMillis();
            zzfqy zzfqyVarG = g(str, adFormat);
            int iP = 0;
            z = zzfqyVarG != null && zzfqyVarG.j();
            Long lValueOf = z ? Long.valueOf(clock.currentTimeMillis()) : null;
            zzfqk zzfqkVar = new zzfqk(new zzfqj(str, adFormat));
            zzfqd zzfqdVar = this.f31630d;
            int i2 = zzfqyVarG == null ? 0 : zzfqyVarG.f31671e.f21242d;
            if (zzfqyVarG != null) {
                iP = zzfqyVarG.p();
            }
            zzfqdVar.c(i2, iP, jCurrentTimeMillis, lValueOf, zzfqyVarG != null ? zzfqyVarG.m() : null, zzfqkVar, "1");
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public final synchronized Object f(AdFormat adFormat, Class cls, String str) {
        zzfqk zzfqkVar = new zzfqk(new zzfqj(str, adFormat));
        zzfqd zzfqdVar = this.f31630d;
        Clock clock = this.f31634h;
        zzfqdVar.g("poll_ad", "ppac_ts", clock.currentTimeMillis(), -1, -1, null, zzfqkVar, "1");
        zzfqy zzfqyVarG = g(str, adFormat);
        if (zzfqyVarG == null) {
            return null;
        }
        try {
            String strM = zzfqyVarG.m();
            Object objK = zzfqyVarG.k();
            Object objCast = objK == null ? null : cls.cast(objK);
            if (objCast != null) {
                zzfqdVar.d(clock.currentTimeMillis(), zzfqyVarG.f31671e.f21242d, zzfqyVarG.p(), strM, zzfqkVar, "1");
            }
            return objCast;
        } catch (ClassCastException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("PreloadAdManager.pollAd", e2);
            com.google.android.gms.ads.internal.util.zze.l("Unable to cast ad to the requested type:".concat(cls.getName()), e2);
            return null;
        }
    }

    public final synchronized zzfqy g(String str, AdFormat adFormat) {
        return (zzfqy) this.f31627a.get(a(str, adFormat));
    }
}
