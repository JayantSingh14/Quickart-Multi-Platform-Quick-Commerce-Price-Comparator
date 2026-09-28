package com.google.ads.interactivemedia.v3.impl;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
final class zzbb extends WebViewClient {
    final /* synthetic */ zzbc zza;

    public zzbb(zzbc zzbcVar) {
        this.zza = zzbcVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        zzeo.zzc("Finished loading WebView".concat(String.valueOf(str)));
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzeo.zzc("Started loading WebView".concat(String.valueOf(str)));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        zzeo.zzc("Error: " + i2 + StringUtils.SPACE + str + StringUtils.SPACE + str2);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("gmsg://")) {
            return false;
        }
        this.zza.zzg(str, "0");
        return true;
    }
}
