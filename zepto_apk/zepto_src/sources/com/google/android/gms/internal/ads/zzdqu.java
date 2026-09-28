package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzdqu {

    /* renamed from: a, reason: collision with root package name */
    public final Context f28276a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdqa f28277b;

    /* renamed from: c, reason: collision with root package name */
    public final zzayq f28278c;

    /* renamed from: d, reason: collision with root package name */
    public final VersionInfoParcel f28279d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.zza f28280e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbfj f28281f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgyw f28282g;

    /* renamed from: h, reason: collision with root package name */
    public final zzbjn f28283h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdrm f28284i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdua f28285j;

    /* renamed from: k, reason: collision with root package name */
    public final ScheduledExecutorService f28286k;

    /* renamed from: l, reason: collision with root package name */
    public final zzdsv f28287l;

    /* renamed from: m, reason: collision with root package name */
    public final zzdxe f28288m;
    public final zzfpi n;
    public final zzehu o;
    public final zzeif p;
    public final zzfio q;
    public final zzdwy r;
    public final zzdyh s;

    public zzdqu(Context context, zzdqa zzdqaVar, zzayq zzayqVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbfj zzbfjVar, zzgyw zzgywVar, zzfik zzfikVar, zzdrm zzdrmVar, zzdua zzduaVar, ScheduledExecutorService scheduledExecutorService, zzdxe zzdxeVar, zzfpi zzfpiVar, zzehu zzehuVar, zzdsv zzdsvVar, zzeif zzeifVar, zzfio zzfioVar, zzdwy zzdwyVar, zzdyh zzdyhVar) {
        this.f28276a = context;
        this.f28277b = zzdqaVar;
        this.f28278c = zzayqVar;
        this.f28279d = versionInfoParcel;
        this.f28280e = zzaVar;
        this.f28281f = zzbfjVar;
        this.f28282g = zzgywVar;
        this.f28283h = zzfikVar.f31222j;
        this.f28284i = zzdrmVar;
        this.f28285j = zzduaVar;
        this.f28286k = scheduledExecutorService;
        this.f28288m = zzdxeVar;
        this.n = zzfpiVar;
        this.o = zzehuVar;
        this.f28287l = zzdsvVar;
        this.p = zzeifVar;
        this.q = zzfioVar;
        this.r = zzdwyVar;
        this.s = zzdyhVar;
    }

    public static Integer c(String str, JSONObject jSONObject) throws JSONException {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static final com.google.android.gms.ads.internal.client.zzez e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new com.google.android.gms.ads.internal.client.zzez(strOptString, strOptString2);
    }

    public final ListenableFuture a(JSONArray jSONArray, boolean z, boolean z2, zzdwm zzdwmVar) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgym.a(Collections.EMPTY_LIST);
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.G2)).booleanValue()) {
            this.r.f28716e.putLong(zzdwmVar.f28699a, com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
        for (int i2 = 0; i2 < length; i2++) {
            arrayList.add(b(jSONArray.optJSONObject(i2), z, null));
        }
        return zzgym.i(zzgym.j(arrayList), zzdqt.f28275a, this.f28282g);
    }

    public final ListenableFuture b(JSONObject jSONObject, boolean z, zzdwm zzdwmVar) {
        if (jSONObject == null) {
            return zzgyq.f33377b;
        }
        zzbgb zzbgbVar = zzbgk.D4;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        HashMap map = null;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzbgb zzbgbVar2 = zzbgk.E4;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            if (jSONObject.has((String) zzbgiVar.a(zzbgbVar2))) {
                map = new HashMap();
                for (String str : ((String) zzbgiVar.a(zzbgk.F4)).split(",")) {
                    try {
                        map.put(str, jSONObject.getString(str));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        HashMap map2 = map;
        final String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString) && map2 == null) {
            return zzgyq.f33377b;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.G2)).booleanValue() && zzdwmVar != null) {
            this.r.f28716e.putLong(zzdwmVar.f28699a, com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        final boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        final int iOptInt = jSONObject.optInt(Snapshot.WIDTH, -1);
        final int iOptInt2 = jSONObject.optInt(Snapshot.HEIGHT, -1);
        if (z || map2 != null) {
            return zzgym.a(new zzbjj(null, Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2, map2));
        }
        final zzdqa zzdqaVar = this.f28277b;
        zzdqaVar.f28220a.getClass();
        zzcdt zzcdtVar = new zzcdt();
        com.google.android.gms.ads.internal.util.zzbl.f21534a.b(new com.google.android.gms.ads.internal.util.zzbk(strOptString, zzcdtVar));
        ListenableFuture listenableFutureI = zzgym.i(zzgym.i(zzcdtVar, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzdpz
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) {
                zzdqa zzdqaVar2 = zzdqaVar;
                zzdqaVar2.getClass();
                byte[] bArr = ((zzarg) obj).f24206b;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inDensity = (int) (dOptDouble * 160.0d);
                if (!zOptBoolean) {
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                zzbgb zzbgbVar3 = zzbgk.O6;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar2 = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                if (((Boolean) zzbdVar2.f21153c.a(zzbgbVar3)).booleanValue()) {
                    options.inJustDecodeBounds = true;
                    zzdqaVar2.a(bArr, options);
                    options.inJustDecodeBounds = false;
                    int i2 = options.outWidth * options.outHeight;
                    if (i2 > 0) {
                        options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros((i2 - 1) / ((Integer) zzbdVar2.f21153c.a(zzbgk.P6)).intValue())) / 2);
                    }
                }
                return zzdqaVar2.a(bArr, options);
            }
        }, zzdqaVar.f28222c), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzdqj
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final /* synthetic */ Object apply(Object obj) {
                return new zzbjj(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2, null);
            }
        }, this.f28282g);
        return jSONObject.optBoolean("require") ? zzgym.h(listenableFutureI, new zzdqq(listenableFutureI), zzcdo.f25988g) : zzgym.f(listenableFutureI, Exception.class, new zzdqp(), zzcdo.f25988g);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.common.util.concurrent.ListenableFuture d(org.json.JSONObject r11, final com.google.android.gms.internal.ads.zzfhr r12, final com.google.android.gms.internal.ads.zzfhu r13, final com.google.android.gms.ads.internal.zzb r14, final com.google.android.gms.internal.ads.zzcbf r15) {
        /*
            r10 = this;
            java.lang.String r0 = "base_url"
            java.lang.String r8 = r11.optString(r0)
            java.lang.String r0 = "html"
            java.lang.String r9 = r11.optString(r0)
            java.lang.String r0 = "width"
            r1 = 0
            int r0 = r11.optInt(r0, r1)
            java.lang.String r2 = "height"
            int r11 = r11.optInt(r2, r1)
            if (r0 != 0) goto L24
            if (r11 == 0) goto L1e
            goto L25
        L1e:
            com.google.android.gms.ads.internal.client.zzr r11 = com.google.android.gms.ads.internal.client.zzr.b()
            r3 = r11
            goto L32
        L24:
            r1 = r0
        L25:
            com.google.android.gms.ads.internal.client.zzr r0 = new com.google.android.gms.ads.internal.client.zzr
            com.google.android.gms.ads.AdSize r2 = new com.google.android.gms.ads.AdSize
            r2.<init>(r1, r11)
            android.content.Context r11 = r10.f28276a
            r0.<init>(r11, r2)
            r3 = r0
        L32:
            com.google.android.gms.internal.ads.zzdrm r2 = r10.f28284i
            r2.getClass()
            com.google.android.gms.internal.ads.zzbgb r11 = com.google.android.gms.internal.ads.zzbgk.G2
            com.google.android.gms.ads.internal.client.zzbd r0 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r0 = r0.f21153c
            java.lang.Object r11 = r0.a(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L5a
            com.google.android.gms.internal.ads.zzdwy r11 = r2.f28350i
            android.os.Bundle r11 = r11.f28716e
            com.google.android.gms.ads.internal.zzt r0 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.common.util.Clock r0 = r0.f21687k
            long r0 = r0.currentTimeMillis()
            java.lang.String r4 = "native-assets-loading-video-composition-start"
            r11.putLong(r4, r0)
        L5a:
            com.google.common.util.concurrent.ListenableFuture r11 = com.google.android.gms.internal.ads.zzgyq.f33377b
            com.google.android.gms.internal.ads.zzdrg r1 = new com.google.android.gms.internal.ads.zzdrg
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r1.<init>()
            java.util.concurrent.Executor r12 = r2.f28343b
            com.google.common.util.concurrent.ListenableFuture r11 = com.google.android.gms.internal.ads.zzgym.h(r11, r1, r12)
            com.google.android.gms.internal.ads.zzdqo r12 = new com.google.android.gms.internal.ads.zzdqo
            r12.<init>()
            com.google.android.gms.internal.ads.zzgyw r13 = com.google.android.gms.internal.ads.zzcdo.f25988g
            com.google.common.util.concurrent.ListenableFuture r11 = com.google.android.gms.internal.ads.zzgym.h(r11, r12, r13)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdqu.d(org.json.JSONObject, com.google.android.gms.internal.ads.zzfhr, com.google.android.gms.internal.ads.zzfhu, com.google.android.gms.ads.internal.zzb, com.google.android.gms.internal.ads.zzcbf):com.google.common.util.concurrent.ListenableFuture");
    }
}
