package com.google.android.gms.internal.ads;

import android.view.View;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzfrt {

    /* renamed from: a, reason: collision with root package name */
    public final zzfrv f31748a;

    /* renamed from: b, reason: collision with root package name */
    public final WebView f31749b;

    /* renamed from: c, reason: collision with root package name */
    public final zzftw f31750c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f31751d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfsj f31752e;

    /* JADX WARN: Multi-variable type inference failed */
    public zzfrt(zzfrv zzfrvVar, WebView webView) {
        HashMap map = new HashMap();
        this.f31751d = map;
        this.f31752e = new zzfsj();
        if (!zzfrf.f31700a.f31701a) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
        this.f31748a = zzfrvVar;
        this.f31749b = webView;
        zzftw zzftwVar = this.f31750c;
        if ((zzftwVar == null ? null : (View) zzftwVar.get()) != webView) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((zzfrh) it.next()).a(webView);
            }
            this.f31750c = new zzftw(webView);
        }
        if (!WebViewFeature.a("WEB_MESSAGE_LISTENER")) {
            throw new UnsupportedOperationException("The JavaScriptSessionService cannot be supported in this WebView version.");
        }
        int i2 = WebViewCompat.f12427a;
        if (!WebViewFeatureInternal.f12457k.d()) {
            throw WebViewFeatureInternal.a();
        }
        WebViewCompat.c(this.f31749b).f12463a.removeWebMessageListener("omidJsSessionService");
        WebViewCompat.a(this.f31749b, "omidJsSessionService", new HashSet(Arrays.asList("*")), new zzfrr(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str) {
        zzfrm zzfrmVar = zzfrm.DEFINED_BY_JAVASCRIPT;
        zzfrp zzfrpVar = zzfrp.DEFINED_BY_JAVASCRIPT;
        zzfru zzfruVar = zzfru.JAVASCRIPT;
        zzfrl zzfrlVar = new zzfrl(zzfri.a(zzfrmVar, zzfrpVar, zzfruVar, zzfruVar, false), new zzfrj(this.f31748a, this.f31749b, null, null, zzfrk.HTML), str);
        this.f31751d.put(str, zzfrlVar);
        zzftw zzftwVar = this.f31750c;
        zzfrlVar.a(zzftwVar == null ? null : (View) zzftwVar.get());
        Iterator it = this.f31752e.f31791a.iterator();
        while (it.hasNext()) {
            zzfsi zzfsiVar = (zzfsi) it.next();
            zzfrlVar.c((View) zzfsiVar.f31786a.get(), zzfsiVar.f31788c);
        }
        zzfrlVar.d();
    }
}
