package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbdi implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final ValueCallback f24779a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebView f24780b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbdk f24781c;

    public zzbdi(zzbdk zzbdkVar, zzbda zzbdaVar, WebView webView, boolean z) {
        this.f24780b = webView;
        Objects.requireNonNull(zzbdkVar);
        this.f24781c = zzbdkVar;
        this.f24779a = new zzbdh(this, zzbdaVar, webView, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ValueCallback<String> valueCallback = this.f24779a;
        WebView webView = this.f24780b;
        if (webView.getSettings().getJavaScriptEnabled()) {
            try {
                webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", valueCallback);
            } catch (Throwable unused) {
                ((zzbdh) valueCallback).onReceiveValue("");
            }
        }
    }
}
