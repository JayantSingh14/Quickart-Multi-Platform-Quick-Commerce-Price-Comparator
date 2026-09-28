package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzedg {
    public static final Pattern p = Pattern.compile("\\?");

    /* renamed from: a, reason: collision with root package name */
    public final zzclg f29115a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f29116b;

    /* renamed from: c, reason: collision with root package name */
    public final VersionInfoParcel f29117c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfik f29118d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgyw f29119e;

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f29120f;

    /* renamed from: g, reason: collision with root package name */
    public final String f29121g;

    /* renamed from: h, reason: collision with root package name */
    public final zzfno f29122h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdwy f29123i;

    /* renamed from: j, reason: collision with root package name */
    public final zzfpi f29124j;

    /* renamed from: k, reason: collision with root package name */
    public final zzddo f29125k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f29126l = new Object();

    /* renamed from: m, reason: collision with root package name */
    public String f29127m;
    public List n;
    public Bundle o;

    public zzedg(zzclg zzclgVar, Context context, VersionInfoParcel versionInfoParcel, zzfik zzfikVar, zzgyw zzgywVar, String str, zzfno zzfnoVar, zzdwy zzdwyVar, zzbzi zzbziVar, ScheduledExecutorService scheduledExecutorService, zzfpi zzfpiVar, zzddo zzddoVar) {
        this.f29115a = zzclgVar;
        this.f29116b = context;
        this.f29117c = versionInfoParcel;
        this.f29118d = zzfikVar;
        this.f29119e = zzgywVar;
        this.f29121g = str;
        this.f29122h = zzfnoVar;
        zzclgVar.b();
        this.f29123i = zzdwyVar;
        this.f29120f = scheduledExecutorService;
        this.f29124j = zzfpiVar;
        this.f29125k = zzddoVar;
    }

    public static final String d(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzgxf a(java.lang.String r19, final java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzedg.a(java.lang.String, java.lang.String):com.google.android.gms.internal.ads.zzgxf");
    }

    public final void b(zzdwm zzdwmVar) {
        Bundle bundle = this.f29123i.f28716e;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R7)).booleanValue()) {
            bundle.putLong(zzdwmVar.f28699a, com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
    }

    public final String c(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && com.google.ads.interactivemedia.v3.impl.data.zzck.UNKNOWN_CONTENT_TYPE.equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.f29121g));
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            String strConcat = "Failed to update the ad types for rendering. ".concat(e2.toString());
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
            return str;
        }
    }
}
