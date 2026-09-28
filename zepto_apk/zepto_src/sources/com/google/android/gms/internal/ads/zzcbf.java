package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzcbf implements zzcbk {

    /* renamed from: l, reason: collision with root package name */
    public static final List f25813l = Collections.synchronizedList(new ArrayList());

    /* renamed from: a, reason: collision with root package name */
    public final zziev f25814a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f25815b;

    /* renamed from: e, reason: collision with root package name */
    public final Context f25818e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f25819f;

    /* renamed from: g, reason: collision with root package name */
    public final zzcbh f25820g;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f25816c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f25817d = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final Object f25821h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f25822i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public boolean f25823j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f25824k = false;

    public zzcbf(Context context, VersionInfoParcel versionInfoParcel, zzcbh zzcbhVar, String str) {
        Preconditions.checkNotNull(zzcbhVar, "SafeBrowsing config is not present.");
        this.f25818e = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.f25815b = new LinkedHashMap();
        this.f25820g = zzcbhVar;
        Iterator it = zzcbhVar.f25829e.iterator();
        while (it.hasNext()) {
            this.f25822i.add(((String) it.next()).toLowerCase(Locale.ENGLISH));
        }
        this.f25822i.remove("cookie".toLowerCase(Locale.ENGLISH));
        zziev zzievVarF = zzigz.F();
        zzievVarF.j();
        ((zzigz) zzievVarF.f34638b).Q(9);
        if (str != null) {
            zzievVarF.j();
            ((zzigz) zzievVarF.f34638b).G(str);
            zzievVarF.j();
            ((zzigz) zzievVarF.f34638b).H(str);
        }
        zziew zziewVarC = zziex.C();
        String str2 = this.f25820g.f25825a;
        if (str2 != null) {
            zziewVarC.j();
            ((zziex) zziewVarC.f34638b).D(str2);
        }
        zziex zziexVar = (zziex) zziewVarC.l();
        zzievVarF.j();
        ((zzigz) zzievVarF.f34638b).I(zziexVar);
        zzigl zziglVarC = zzigm.C();
        boolean zIsCallerInstantApp = Wrappers.packageManager(this.f25818e).isCallerInstantApp();
        zziglVarC.j();
        ((zzigm) zziglVarC.f34638b).F(zIsCallerInstantApp);
        String str3 = versionInfoParcel.f21400a;
        if (str3 != null) {
            zziglVarC.j();
            ((zzigm) zziglVarC.f34638b).D(str3);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.f25818e);
        if (apkVersion > 0) {
            zziglVarC.j();
            ((zzigm) zziglVarC.f34638b).E(apkVersion);
        }
        zzigm zzigmVar = (zzigm) zziglVarC.l();
        zzievVarF.j();
        ((zzigz) zzievVarF.f34638b).N(zzigmVar);
        this.f25814a = zzievVarF;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void a(String str, Map map, int i2) {
        synchronized (this.f25821h) {
            if (i2 == 3) {
                try {
                    this.f25824k = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            LinkedHashMap linkedHashMap = this.f25815b;
            if (linkedHashMap.containsKey(str)) {
                if (i2 == 3) {
                    zzigj zzigjVar = (zzigj) linkedHashMap.get(str);
                    zzigjVar.j();
                    ((zzigk) zzigjVar.f34638b).J(4);
                }
                return;
            }
            zzigj zzigjVarE = zzigk.E();
            int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : 4 : 3 : 2 : 1;
            if (i3 != 0) {
                zzigjVarE.j();
                ((zzigk) zzigjVarE.f34638b).J(i3);
            }
            int size = linkedHashMap.size();
            zzigjVarE.j();
            ((zzigk) zzigjVarE.f34638b).F(size);
            zzigjVarE.j();
            ((zzigk) zzigjVarE.f34638b).G(str);
            zzifi zzifiVarC = zzifl.C();
            if (!this.f25822i.isEmpty() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = entry.getKey() != null ? (String) entry.getKey() : "";
                    String str3 = entry.getValue() != null ? (String) entry.getValue() : "";
                    if (this.f25822i.contains(str2.toLowerCase(Locale.ENGLISH))) {
                        zzifg zzifgVarC = zzifh.C();
                        Charset charset = zzibe.f34660a;
                        zzhzj zzhzjVar = new zzhzj(str2.getBytes(charset));
                        zzifgVarC.j();
                        ((zzifh) zzifgVarC.f34638b).D(zzhzjVar);
                        zzhzj zzhzjVar2 = new zzhzj(str3.getBytes(charset));
                        zzifgVarC.j();
                        ((zzifh) zzifgVarC.f34638b).E(zzhzjVar2);
                        zzifh zzifhVar = (zzifh) zzifgVarC.l();
                        zzifiVarC.j();
                        ((zzifl) zzifiVarC.f34638b).D(zzifhVar);
                    }
                }
            }
            zzifl zziflVar = (zzifl) zzifiVarC.l();
            zzigjVarE.j();
            ((zzigk) zzigjVarE.f34638b).H(zziflVar);
            linkedHashMap.put(str, zzigjVarE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void b(String str) {
        synchronized (this.f25821h) {
            try {
                if (str == null) {
                    zziev zzievVar = this.f25814a;
                    zzievVar.j();
                    ((zzigz) zzievVar.f34638b).L();
                } else {
                    zziev zzievVar2 = this.f25814a;
                    zzievVar2.j();
                    ((zzigz) zzievVar2.f34638b).K(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzcbk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.view.View r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzcbh r0 = r7.f25820g
            boolean r0 = r0.f25827c
            if (r0 != 0) goto L8
            goto L9f
        L8:
            boolean r0 = r7.f25823j
            if (r0 != 0) goto L9f
            com.google.android.gms.ads.internal.zzt r0 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.ads.internal.util.zzs r0 = r0.f21679c
            r0 = 1
            r1 = 0
            if (r8 != 0) goto L16
            goto L77
        L16:
            boolean r2 = r8.isDrawingCacheEnabled()     // Catch: java.lang.RuntimeException -> L28
            r8.setDrawingCacheEnabled(r0)     // Catch: java.lang.RuntimeException -> L28
            android.graphics.Bitmap r3 = r8.getDrawingCache()     // Catch: java.lang.RuntimeException -> L28
            if (r3 == 0) goto L2a
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3)     // Catch: java.lang.RuntimeException -> L28
            goto L2b
        L28:
            r2 = move-exception
            goto L31
        L2a:
            r3 = r1
        L2b:
            r8.setDrawingCacheEnabled(r2)     // Catch: java.lang.RuntimeException -> L2f
            goto L39
        L2f:
            r2 = move-exception
            goto L32
        L31:
            r3 = r1
        L32:
            int r4 = com.google.android.gms.ads.internal.util.zze.f21576b
            java.lang.String r4 = "Fail to capture the web view"
            com.google.android.gms.ads.internal.util.client.zzo.d(r4, r2)
        L39:
            if (r3 != 0) goto L76
            int r2 = r8.getWidth()     // Catch: java.lang.RuntimeException -> L64
            int r3 = r8.getHeight()     // Catch: java.lang.RuntimeException -> L64
            if (r2 == 0) goto L66
            if (r3 != 0) goto L48
            goto L66
        L48:
            int r4 = r8.getWidth()     // Catch: java.lang.RuntimeException -> L64
            int r5 = r8.getHeight()     // Catch: java.lang.RuntimeException -> L64
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch: java.lang.RuntimeException -> L64
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch: java.lang.RuntimeException -> L64
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch: java.lang.RuntimeException -> L64
            r5.<init>(r4)     // Catch: java.lang.RuntimeException -> L64
            r6 = 0
            r8.layout(r6, r6, r2, r3)     // Catch: java.lang.RuntimeException -> L64
            r8.draw(r5)     // Catch: java.lang.RuntimeException -> L64
            r1 = r4
            goto L77
        L64:
            r8 = move-exception
            goto L6e
        L66:
            java.lang.String r8 = "Width or height of view is zero"
            int r2 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.RuntimeException -> L64
            com.google.android.gms.ads.internal.util.client.zzo.f(r8)     // Catch: java.lang.RuntimeException -> L64
            goto L77
        L6e:
            int r2 = com.google.android.gms.ads.internal.util.zze.f21576b
            java.lang.String r2 = "Fail to capture the webview"
            com.google.android.gms.ads.internal.util.client.zzo.d(r2, r8)
            goto L77
        L76:
            r1 = r3
        L77:
            if (r1 != 0) goto L7f
            java.lang.String r8 = "Failed to capture the webview bitmap."
            com.google.android.gms.internal.ads.zzcbj.a(r8)
            return
        L7f:
            r7.f25823j = r0
            com.google.android.gms.internal.ads.zzcbe r8 = new com.google.android.gms.internal.ads.zzcbe
            r8.<init>()
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            java.lang.Thread r0 = r0.getThread()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            if (r0 == r1) goto L98
            r8.run()
            goto L9f
        L98:
            com.google.android.gms.internal.ads.zzgyw r0 = com.google.android.gms.internal.ads.zzcdo.f25982a
            com.google.android.gms.internal.ads.zzcdn r0 = (com.google.android.gms.internal.ads.zzcdn) r0
            r0.execute(r8)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbf.c(android.view.View):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final zzcbh zza() {
        return this.f25820g;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final boolean zzc() {
        return this.f25820g.f25827c && !this.f25823j;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzf() {
        synchronized (this.f25821h) {
            this.f25815b.keySet();
            ListenableFuture listenableFutureA = zzgym.a(Collections.EMPTY_MAP);
            zzgxu zzgxuVar = new zzgxu() { // from class: com.google.android.gms.internal.ads.zzcbb
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final ListenableFuture zza(Object obj) {
                    int length;
                    zzigj zzigjVar;
                    ListenableFuture listenableFutureI;
                    zzcbf zzcbfVar = this.f25808a;
                    Map map = (Map) obj;
                    zzcbfVar.getClass();
                    if (map != null) {
                        try {
                            for (String str : map.keySet()) {
                                JSONArray jSONArrayOptJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                                if (jSONArrayOptJSONArray != null) {
                                    Object obj2 = zzcbfVar.f25821h;
                                    synchronized (obj2) {
                                        try {
                                            length = jSONArrayOptJSONArray.length();
                                            synchronized (obj2) {
                                                zzigjVar = (zzigj) zzcbfVar.f25815b.get(str);
                                            }
                                        } finally {
                                        }
                                    }
                                    if (zzigjVar == null) {
                                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 50);
                                        sb.append("Cannot find the corresponding resource object for ");
                                        sb.append(str);
                                        zzcbj.a(sb.toString());
                                    } else {
                                        for (int i2 = 0; i2 < length; i2++) {
                                            String string = jSONArrayOptJSONArray.getJSONObject(i2).getString("threat_type");
                                            zzigjVar.j();
                                            ((zzigk) zzigjVar.f34638b).I(string);
                                        }
                                        zzcbfVar.f25819f = (length > 0) | zzcbfVar.f25819f;
                                    }
                                }
                            }
                        } catch (JSONException e2) {
                            if (((Boolean) zzbis.f25212a.c()).booleanValue()) {
                                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                com.google.android.gms.ads.internal.util.client.zzo.b("Failed to get SafeBrowsing metadata", e2);
                            }
                            return zzgym.b(new Exception("Safebrowsing report transmission failed."));
                        }
                    }
                    if (zzcbfVar.f25819f) {
                        synchronized (zzcbfVar.f25821h) {
                            zziev zzievVar = zzcbfVar.f25814a;
                            zzievVar.j();
                            ((zzigz) zzievVar.f34638b).Q(10);
                        }
                    }
                    boolean z = zzcbfVar.f25819f;
                    if (!(z && zzcbfVar.f25820g.f25831g) && (!(zzcbfVar.f25824k && zzcbfVar.f25820g.f25830f) && (z || !zzcbfVar.f25820g.f25828d))) {
                        return zzgyq.f33377b;
                    }
                    synchronized (zzcbfVar.f25821h) {
                        try {
                            for (zzigj zzigjVar2 : zzcbfVar.f25815b.values()) {
                                zziev zzievVar2 = zzcbfVar.f25814a;
                                zzigk zzigkVar = (zzigk) zzigjVar2.l();
                                zzievVar2.j();
                                ((zzigz) zzievVar2.f34638b).J(zzigkVar);
                            }
                            zziev zzievVar3 = zzcbfVar.f25814a;
                            ArrayList arrayList = zzcbfVar.f25816c;
                            zzievVar3.j();
                            ((zzigz) zzievVar3.f34638b).O(arrayList);
                            ArrayList arrayList2 = zzcbfVar.f25817d;
                            zzievVar3.j();
                            ((zzigz) zzievVar3.f34638b).P(arrayList2);
                            if (((Boolean) zzbis.f25212a.c()).booleanValue()) {
                                String strC = ((zzigz) zzievVar3.f34638b).C();
                                String strE = ((zzigz) zzievVar3.f34638b).E();
                                StringBuilder sb2 = new StringBuilder(String.valueOf(strC).length() + 38 + String.valueOf(strE).length() + 15);
                                sb2.append("Sending SB report\n  url: ");
                                sb2.append(strC);
                                sb2.append("\n  clickUrl: ");
                                sb2.append(strE);
                                sb2.append("\n  resources: \n");
                                StringBuilder sb3 = new StringBuilder(sb2.toString());
                                for (zzigk zzigkVar2 : Collections.unmodifiableList(((zzigz) zzievVar3.f34638b).D())) {
                                    sb3.append("    [");
                                    sb3.append(zzigkVar2.D());
                                    sb3.append("] ");
                                    sb3.append(zzigkVar2.C());
                                }
                                zzcbj.a(sb3.toString());
                            }
                            ListenableFuture listenableFutureA2 = new com.google.android.gms.ads.internal.util.zzbl(zzcbfVar.f25818e).a(1, zzcbfVar.f25820g.f25826b, null, ((zzigz) zzievVar3.l()).g());
                            if (((Boolean) zzbis.f25212a.c()).booleanValue()) {
                                ((zzcdt) listenableFutureA2).f25992a.q(zzcbd.f25810a, zzcdo.f25982a);
                            }
                            listenableFutureI = zzgym.i(listenableFutureA2, zzcbc.f25809a, zzcdo.f25988g);
                        } finally {
                        }
                    }
                    return listenableFutureI;
                }
            };
            zzgyw zzgywVar = zzcdo.f25988g;
            ListenableFuture listenableFutureH = zzgym.h(listenableFutureA, zzgxuVar, zzgywVar);
            ListenableFuture listenableFutureG = zzgym.g(listenableFutureH, 10L, TimeUnit.SECONDS, zzcdo.f25985d);
            ((zzgxf) listenableFutureH).q(new zzgyk(listenableFutureH, new zzcba(this, listenableFutureG)), zzgywVar);
            f25813l.add(listenableFutureG);
        }
    }
}
