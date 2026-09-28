package com.google.ads.interactivemedia.v3.impl;

import android.net.Uri;
import android.support.v4.media.b;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;

/* loaded from: classes3.dex */
final class zzay implements WebViewCompat.WebMessageListener {
    final /* synthetic */ zzbc zza;

    public zzay(zzbc zzbcVar) {
        this.zza = zzbcVar;
    }

    @Override // androidx.webkit.WebViewCompat.WebMessageListener
    public final void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
        int i2 = webMessageCompat.f12425b;
        if (i2 != 0) {
            throw new IllegalStateException(b.r(new StringBuilder("Wrong data accessor type detected. "), i2 != 0 ? i2 != 1 ? "Unknown" : "ArrayBuffer" : "String", " expected, but got String"));
        }
        this.zza.zzg(webMessageCompat.f12424a, "4");
    }
}
