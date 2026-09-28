package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.JsonWriter;
import com.google.android.gms.ads.admanager.AppEventListener;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzdyd implements AppEventListener, zzddq, com.google.android.gms.ads.internal.client.zza, zzdak, zzdbe, zzdbf, zzdby, zzdan, zzfmv {

    /* renamed from: a, reason: collision with root package name */
    public final List f28781a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdxr f28782b;

    /* renamed from: c, reason: collision with root package name */
    public long f28783c;

    public zzdyd(zzdxr zzdxrVar, zzclg zzclgVar) {
        this.f28782b = zzdxrVar;
        this.f28781a = Collections.singletonList(zzclgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void F(zzfic zzficVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void P(Context context) throws IOException {
        a0(zzdbf.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzddq
    public final void R(zzbza zzbzaVar) throws IOException {
        this.f28783c = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();
        a0(zzddq.class, "onAdRequest", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void S(Context context) throws IOException {
        a0(zzdbf.class, "onResume", context);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void T() throws IOException {
        a0(zzdak.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void Y(zzbzj zzbzjVar, String str, String str2) throws IOException {
        a0(zzdak.class, "onRewarded", zzbzjVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void a(Context context) throws IOException {
        a0(zzdbf.class, "onDestroy", context);
    }

    public final void a0(Class cls, String str, Object... objArr) throws IOException {
        String simpleName = cls.getSimpleName();
        List list = this.f28781a;
        String strConcat = "Event-".concat(simpleName);
        zzdxr zzdxrVar = this.f28782b;
        zzdxrVar.getClass();
        if (((Boolean) zzbim.f25191a.c()).booleanValue()) {
            long jCurrentTimeMillis = zzdxrVar.f28770a.currentTimeMillis();
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            try {
                jsonWriter.beginObject();
                jsonWriter.name("timestamp").value(jCurrentTimeMillis);
                jsonWriter.name("source").value(strConcat);
                jsonWriter.name("event").value(str);
                jsonWriter.name("components").beginArray();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jsonWriter.value(it.next().toString());
                }
                jsonWriter.endArray();
                jsonWriter.name("params").beginArray();
                int length = objArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = objArr[i2];
                    jsonWriter.value(obj != null ? obj.toString() : null);
                }
                jsonWriter.endArray();
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
            } catch (IOException e2) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("unable to log", e2);
            }
            String strValueOf = String.valueOf(stringWriter.toString());
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e("AD-DBG ".concat(strValueOf));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void b() throws IOException {
        a0(zzdak.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void c(zzfmo zzfmoVar, String str) throws IOException {
        a0(zzfmn.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzdbe
    public final void f() throws IOException {
        a0(zzdbe.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void g() throws IOException {
        a0(zzdak.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void h() throws IOException {
        a0(com.google.android.gms.ads.internal.client.zza.class, "onAdClicked", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void j(zzfmo zzfmoVar, String str, Throwable th) throws IOException {
        a0(zzfmn.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void m(String str) throws IOException {
        a0(zzfmn.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void m0(com.google.android.gms.ads.internal.client.zze zzeVar) throws IOException {
        a0(zzdan.class, "onAdFailedToLoad", Integer.valueOf(zzeVar.f21161a), zzeVar.f21162b, zzeVar.f21163c);
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void t(zzfmo zzfmoVar, String str) throws IOException {
        a0(zzfmn.class, "onTaskSucceeded", str);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void y(String str, String str2) throws IOException {
        a0(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zze() throws IOException {
        a0(zzdak.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zzf() throws IOException {
        a0(zzdak.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() throws IOException {
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - this.f28783c;
        StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime).length() + 21);
        sb.append("Ad Request Latency : ");
        sb.append(jElapsedRealtime);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        a0(zzdby.class, "onAdLoaded", new Object[0]);
    }
}
