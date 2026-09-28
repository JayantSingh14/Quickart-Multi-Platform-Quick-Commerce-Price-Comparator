package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbpu;
import com.google.android.gms.internal.ads.zzbpv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzex {

    /* renamed from: k, reason: collision with root package name */
    public static zzex f21213k;

    /* renamed from: a, reason: collision with root package name */
    public zzep f21214a;

    /* renamed from: b, reason: collision with root package name */
    public zzfb f21215b;

    /* renamed from: c, reason: collision with root package name */
    public zzeo f21216c;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f21218e;

    /* renamed from: i, reason: collision with root package name */
    public zzdb f21222i;

    /* renamed from: j, reason: collision with root package name */
    public final RequestConfiguration f21223j;

    /* renamed from: d, reason: collision with root package name */
    public final Object f21217d = new Object();

    /* renamed from: f, reason: collision with root package name */
    public boolean f21219f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21220g = false;

    /* renamed from: h, reason: collision with root package name */
    public final Object f21221h = new Object();

    static {
        new HashSet(Arrays.asList(AdFormat.APP_OPEN_AD, AdFormat.INTERSTITIAL, AdFormat.REWARDED));
    }

    public zzex() {
        RequestConfiguration.Builder builder = new RequestConfiguration.Builder();
        this.f21223j = new RequestConfiguration(builder.f21022a, builder.f21023b);
        this.f21218e = new ArrayList();
    }

    public static zzbpv a(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbpm zzbpmVar = (zzbpm) it.next();
            map.put(zzbpmVar.f25411a, new zzbpu(zzbpmVar.f25412b ? AdapterStatus.State.f21078b : AdapterStatus.State.f21077a, zzbpmVar.f25414d));
        }
        return new zzbpv(map);
    }

    public static zzex d() {
        zzex zzexVar;
        synchronized (zzex.class) {
            try {
                if (f21213k == null) {
                    f21213k = new zzex();
                }
                zzexVar = f21213k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzexVar;
    }

    public final void b(ReactApplicationContext reactApplicationContext) {
        if (this.f21222i == null) {
            this.f21222i = (zzdb) new zzau(zzbb.f21141g.f21143b, reactApplicationContext).d(reactApplicationContext, false);
        }
    }

    public final void c() {
        zzdb zzdbVar = this.f21222i;
        if (zzdbVar == null) {
            return;
        }
        try {
            zzdbVar.zze();
            this.f21222i.T1(new ObjectWrapper(null), null);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.g("MobileAdsSettingManager initialization failed", e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0089 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, RemoteException -> 0x0049, blocks: (B:21:0x002c, B:23:0x0033, B:28:0x004b, B:31:0x0056, B:33:0x0067, B:35:0x0079, B:42:0x00bc, B:43:0x00d7, B:36:0x0089, B:38:0x0097, B:40:0x00a9, B:41:0x00b4, B:30:0x0051), top: B:51:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b4 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, RemoteException -> 0x0049, blocks: (B:21:0x002c, B:23:0x0033, B:28:0x004b, B:31:0x0056, B:33:0x0067, B:35:0x0079, B:42:0x00bc, B:43:0x00d7, B:36:0x0089, B:38:0x0097, B:40:0x00a9, B:41:0x00b4, B:30:0x0051), top: B:51:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(com.facebook.react.bridge.ReactApplicationContext r3, bridges.a r4) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzex.e(com.facebook.react.bridge.ReactApplicationContext, bridges.a):void");
    }

    public final InitializationStatus f() {
        synchronized (this.f21221h) {
            Preconditions.checkState(this.f21222i != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            zzdb zzdbVar = this.f21222i;
            if (zzdbVar == null) {
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzet
                    @Override // com.google.android.gms.ads.initialization.InitializationStatus
                    public final Map a() {
                        HashMap map = new HashMap();
                        Objects.requireNonNull(this.f21210a);
                        map.put("com.google.android.gms.ads.MobileAds", new zzer());
                        return map;
                    }
                };
            }
            try {
                return a(zzdbVar.zzq());
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.c("Unable to get Initialization status.");
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzet
                    @Override // com.google.android.gms.ads.initialization.InitializationStatus
                    public final Map a() {
                        HashMap map = new HashMap();
                        Objects.requireNonNull(this.f21210a);
                        map.put("com.google.android.gms.ads.MobileAds", new zzer());
                        return map;
                    }
                };
            }
        }
    }
}
