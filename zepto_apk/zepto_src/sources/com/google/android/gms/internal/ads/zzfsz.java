package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.webkit.WebView;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfsz extends zzfsv {

    /* renamed from: e, reason: collision with root package name */
    public WebView f31816e;

    /* renamed from: f, reason: collision with root package name */
    public Long f31817f;

    /* renamed from: g, reason: collision with root package name */
    public final Map f31818g;

    public zzfsz(String str, Map map) {
        super(str);
        this.f31817f = null;
        this.f31818g = map;
    }

    @Override // com.google.android.gms.internal.ads.zzfsv
    public final void a() {
        WebView webView = new WebView(zzfsk.f31792b.f31793a);
        this.f31816e = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f31816e.getSettings().setAllowContentAccess(false);
        this.f31816e.getSettings().setAllowFileAccess(false);
        this.f31816e.setWebViewClient(new zzfsx(this));
        this.f31811b = new zzftx(this.f31816e);
        zzfsm.b(this.f31816e, null);
        Map map = this.f31818g;
        Iterator it = map.keySet().iterator();
        if (it.hasNext()) {
            throw null;
        }
        this.f31817f = Long.valueOf(System.nanoTime());
    }

    @Override // com.google.android.gms.internal.ads.zzfsv
    public final void b() {
        super.b();
        new Handler().postDelayed(new zzfsy(this), Math.max(4000 - (this.f31817f == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.f31817f.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f31816e = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfsv
    public final void d(zzfrl zzfrlVar, zzfrj zzfrjVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Map mapUnmodifiableMap = Collections.unmodifiableMap(zzfrjVar.f31710d);
        Iterator it = mapUnmodifiableMap.keySet().iterator();
        if (it.hasNext()) {
            throw null;
        }
        e(zzfrlVar, zzfrjVar, jSONObject);
    }
}
