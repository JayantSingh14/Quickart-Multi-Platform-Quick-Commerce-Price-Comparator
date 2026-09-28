package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.google.ads.interactivemedia.v3.internal.zzfl;
import java.util.List;

/* loaded from: classes3.dex */
final class zzaf extends WebChromeClient {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzfl zzb;
    final /* synthetic */ List zzc;

    public zzaf(Context context, zzfl zzflVar, List list) {
        this.zza = context;
        this.zzb = zzflVar;
        this.zzc = list;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(this.zza);
        webViewTransport.setWebView(webView2);
        webView2.setWebViewClient(new zzae(this));
        message.sendToTarget();
        return true;
    }
}
