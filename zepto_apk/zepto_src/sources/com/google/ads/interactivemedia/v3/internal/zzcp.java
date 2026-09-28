package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes3.dex */
final class zzcp extends WebViewClient {
    final /* synthetic */ zzcr zza;

    public zzcp(zzcr zzcrVar) {
        this.zza = zzcrVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + String.valueOf(webView));
        if (this.zza.zza() == webView) {
            Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            this.zza.zzm(null);
        }
        webView.destroy();
        return true;
    }
}
