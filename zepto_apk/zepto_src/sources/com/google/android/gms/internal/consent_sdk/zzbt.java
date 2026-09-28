package com.google.android.gms.internal.consent_sdk;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes4.dex */
final class zzbt extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        int i2 = zzbv.f36522b;
        if (str != null && str.startsWith("consent://")) {
            throw null;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        throw null;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        throw null;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String string = webResourceRequest.getUrl().toString();
        int i2 = zzbv.f36522b;
        if (string == null || !string.startsWith("consent://")) {
            return false;
        }
        throw null;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        int i2 = zzbv.f36522b;
        if (str == null || !str.startsWith("consent://")) {
            return false;
        }
        throw null;
    }
}
