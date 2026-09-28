package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfrl extends zzfrh {

    /* renamed from: a, reason: collision with root package name */
    public final zzfrj f31718a;

    /* renamed from: d, reason: collision with root package name */
    public zzfsv f31721d;

    /* renamed from: g, reason: collision with root package name */
    public final String f31724g;

    /* renamed from: b, reason: collision with root package name */
    public final zzfsj f31719b = new zzfsj();

    /* renamed from: e, reason: collision with root package name */
    public boolean f31722e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f31723f = false;

    /* renamed from: c, reason: collision with root package name */
    public zzftw f31720c = new zzftw(null);

    public zzfrl(zzfri zzfriVar, zzfrj zzfrjVar, String str) throws JSONException {
        this.f31718a = zzfrjVar;
        this.f31724g = str;
        zzfrk zzfrkVar = zzfrk.HTML;
        zzfrk zzfrkVar2 = zzfrjVar.f31713g;
        if (zzfrkVar2 == zzfrkVar || zzfrkVar2 == zzfrk.JAVASCRIPT) {
            zzfsw zzfswVar = new zzfsw(str);
            WebView webView = zzfrjVar.f31708b;
            if (!webView.getSettings().getJavaScriptEnabled()) {
                webView.getSettings().setJavaScriptEnabled(true);
            }
            zzfswVar.f31811b = new zzftx(webView);
            this.f31721d = zzfswVar;
        } else {
            this.f31721d = new zzfsz(str, Collections.unmodifiableMap(zzfrjVar.f31710d));
        }
        this.f31721d.a();
        zzfsf.f31780c.f31781a.add(this);
        zzfsv zzfsvVar = this.f31721d;
        zzfsm zzfsmVar = zzfsm.f31796a;
        WebView webViewC = zzfsvVar.c();
        JSONObject jSONObject = new JSONObject();
        zzftb.b(jSONObject, "impressionOwner", zzfriVar.f31702a);
        zzftb.b(jSONObject, "mediaEventsOwner", zzfriVar.f31703b);
        zzftb.b(jSONObject, "creativeType", zzfriVar.f31705d);
        zzftb.b(jSONObject, "impressionType", zzfriVar.f31706e);
        zzftb.b(jSONObject, "isolateVerificationScripts", Boolean.valueOf(zzfriVar.f31704c));
        zzfsmVar.a(webViewC, "init", jSONObject, zzfsvVar.f31810a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzfrh
    public final void a(View view) {
        if (this.f31723f || ((View) this.f31720c.get()) == view) {
            return;
        }
        this.f31720c = new zzftw(view);
        zzfsv zzfsvVar = this.f31721d;
        zzfsvVar.getClass();
        zzfsvVar.f31812c = System.nanoTime();
        zzfsvVar.f31813d = 1;
        Collection<zzfrl> collectionUnmodifiableCollection = Collections.unmodifiableCollection(zzfsf.f31780c.f31781a);
        if (collectionUnmodifiableCollection == null || collectionUnmodifiableCollection.isEmpty()) {
            return;
        }
        for (zzfrl zzfrlVar : collectionUnmodifiableCollection) {
            if (zzfrlVar != this && ((View) zzfrlVar.f31720c.get()) == view) {
                zzfrlVar.f31720c.clear();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfrh
    public final void b() {
        if (this.f31723f) {
            return;
        }
        this.f31720c.clear();
        if (!this.f31723f) {
            this.f31719b.f31791a.clear();
        }
        this.f31723f = true;
        zzfsv zzfsvVar = this.f31721d;
        zzfsm.f31796a.a(zzfsvVar.c(), "finishSession", zzfsvVar.f31810a);
        zzfsf zzfsfVar = zzfsf.f31780c;
        ArrayList arrayList = zzfsfVar.f31781a;
        ArrayList arrayList2 = zzfsfVar.f31782b;
        boolean z = arrayList2.size() > 0;
        arrayList.remove(this);
        arrayList2.remove(this);
        if (z && arrayList2.size() <= 0) {
            zzfsn zzfsnVarB = zzfsn.b();
            zzfsnVarB.getClass();
            zzftp zzftpVar = zzftp.f31840g;
            zzftpVar.getClass();
            Handler handler = zzftp.f31842i;
            if (handler != null) {
                handler.removeCallbacks(zzftp.f31844k);
                zzftp.f31842i = null;
            }
            zzftpVar.f31845a.clear();
            zzftp.f31841h.post(new zzftk(zzftpVar));
            zzfse zzfseVar = zzfse.f31779d;
            zzfseVar.f31783a = false;
            zzfseVar.f31785c = null;
            zzfsb zzfsbVar = zzfsnVarB.f31799b;
            zzfsbVar.f31768b.getContentResolver().unregisterContentObserver(zzfsbVar);
        }
        this.f31721d.b();
        this.f31721d = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfrh
    public final void c(View view, zzfro zzfroVar) {
        if (this.f31723f) {
            return;
        }
        this.f31719b.a(view, zzfroVar);
    }

    public final void d() {
        if (this.f31722e || this.f31721d == null) {
            return;
        }
        this.f31722e = true;
        ArrayList arrayList = zzfsf.f31780c.f31782b;
        boolean z = arrayList.size() > 0;
        arrayList.add(this);
        if (!z) {
            zzfsn zzfsnVarB = zzfsn.b();
            zzfsnVarB.getClass();
            zzfse zzfseVar = zzfse.f31779d;
            zzfseVar.f31785c = zzfsnVarB;
            zzfseVar.f31783a = true;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            boolean z2 = runningAppProcessInfo.importance == 100 || zzfseVar.a();
            zzfseVar.f31784b = z2;
            zzfseVar.b(z2);
            zzftp.f31840g.getClass();
            zzftp.b();
            zzfsb zzfsbVar = zzfsnVarB.f31799b;
            zzfsbVar.getClass();
            zzfsbVar.f31772f.submit(new zzfsa(zzfsbVar));
            zzfsbVar.f31768b.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, zzfsbVar);
        }
        float f2 = zzfsn.b().f31798a;
        zzfsv zzfsvVar = this.f31721d;
        zzfsm.f31796a.a(zzfsvVar.c(), "setDeviceVolume", Float.valueOf(f2), zzfsvVar.f31810a);
        zzfsv zzfsvVar2 = this.f31721d;
        Date date = zzfsd.f31774e.f31775a;
        zzfsvVar2.f(date != null ? (Date) date.clone() : null);
        this.f31721d.d(this, this.f31718a);
    }
}
