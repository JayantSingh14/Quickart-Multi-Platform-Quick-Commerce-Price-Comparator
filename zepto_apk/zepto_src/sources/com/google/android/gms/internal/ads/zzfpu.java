package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class zzfpu {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f31590a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfqz f31591b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfqd f31592c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f31593d;

    /* renamed from: e, reason: collision with root package name */
    public volatile ConnectivityManager f31594e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f31595f = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    public final Clock f31596g;

    /* renamed from: h, reason: collision with root package name */
    public AtomicInteger f31597h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfpp f31598i;

    public zzfpu(zzfqz zzfqzVar, zzfqd zzfqdVar, Context context, Clock clock, zzfpp zzfppVar) {
        HashMap map = new HashMap();
        this.f31590a = map;
        map.put(AdFormat.APP_OPEN_AD, new HashMap());
        map.put(AdFormat.INTERSTITIAL, new HashMap());
        map.put(AdFormat.REWARDED, new HashMap());
        this.f31591b = zzfqzVar;
        this.f31592c = zzfqdVar;
        this.f31593d = context;
        this.f31596g = clock;
        this.f31598i = zzfppVar;
    }

    public final void a(boolean z) {
        synchronized (this) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.y)).booleanValue()) {
                b(z);
            }
        }
    }

    public final synchronized void b(boolean z) {
        try {
            Iterator it = this.f31590a.values().iterator();
            while (it.hasNext()) {
                for (zzfqy zzfqyVar : ((Map) it.next()).values()) {
                    if (z) {
                        zzfqyVar.l();
                    } else {
                        zzfqyVar.f31673g.set(false);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Object c(AdFormat adFormat, Class cls, String str) {
        zzfqd zzfqdVar = this.f31592c;
        Clock clock = this.f31596g;
        zzfqdVar.g("poll_ad", "ppacwe_ts", clock.currentTimeMillis(), -1, -1, null, null, "2");
        HashMap map = this.f31590a;
        if (!map.containsKey(adFormat)) {
            return null;
        }
        zzfqy zzfqyVar = (zzfqy) ((Map) map.get(adFormat)).get(str);
        if (zzfqyVar != null && adFormat.equals(zzfqyVar.o())) {
            zzfqj zzfqjVar = new zzfqj(zzfqyVar.f31671e.f21239a, zzfqyVar.o());
            zzfqjVar.f31642c = str;
            zzfqk zzfqkVar = new zzfqk(zzfqjVar);
            zzfqdVar.g("poll_ad", "ppac_ts", clock.currentTimeMillis(), zzfqyVar.f31671e.f21242d, zzfqyVar.p(), null, zzfqkVar, "2");
            try {
                String strM = zzfqyVar.m();
                Object objK = zzfqyVar.k();
                Object objCast = objK == null ? null : cls.cast(objK);
                if (objCast != null) {
                    zzfqdVar.d(clock.currentTimeMillis(), zzfqyVar.f31671e.f21242d, zzfqyVar.p(), strM, zzfqkVar, "2");
                }
                return objCast;
            } catch (ClassCastException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("PreloadAdManager.pollAd", e2);
                com.google.android.gms.ads.internal.util.zze.l("Unable to cast ad to the requested type:".concat(cls.getName()), e2);
                return null;
            }
        }
        return null;
    }

    public final synchronized boolean d(AdFormat adFormat) {
        int size;
        int iOrdinal;
        try {
            HashMap map = this.f31590a;
            size = map.containsKey(adFormat) ? ((Map) map.get(adFormat)).size() : 0;
            iOrdinal = adFormat.ordinal();
        } finally {
        }
        return size < (iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 5 ? 0 : Math.max(((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.j5)).intValue(), 1) : Math.max(((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.i5)).intValue(), 1) : Math.max(((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h5)).intValue(), 1));
    }
}
