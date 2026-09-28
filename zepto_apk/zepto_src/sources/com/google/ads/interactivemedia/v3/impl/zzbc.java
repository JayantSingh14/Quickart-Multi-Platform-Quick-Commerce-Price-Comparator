package com.google.ads.interactivemedia.v3.impl;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.media.b;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.google.ads.interactivemedia.v3.internal.zzen;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import com.google.ads.interactivemedia.v3.internal.zzqk;

@SuppressLint({"SetJavaScriptEnabled", "NewApi"})
/* loaded from: classes3.dex */
public final class zzbc {

    @Nullable
    private WebView zza;
    private final Handler zzb;
    private final Uri zzc;

    @Nullable
    private zzaz zzd;

    @Nullable
    private zzen zze = new zzen();

    @UiThread
    private zzbc(Handler handler, WebView webView, Uri uri) {
        this.zzb = handler;
        this.zza = webView;
        this.zzc = uri;
    }

    public static zzbc zzb(Handler handler, WebView webView, Uri uri) {
        zzbc zzbcVar = new zzbc(handler, webView, uri);
        webView.setBackgroundColor(0);
        webView.getSettings().setMixedContentMode(0);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        if (WebViewFeature.a("WEB_MESSAGE_LISTENER")) {
            Uri uri2 = zzbcVar.zzc;
            String strL = b.l(uri2.getScheme(), "://", uri2.getHost());
            if (uri2.getPort() != -1) {
                strL = strL + ":" + uri2.getPort();
            }
            WebViewCompat.a(zzbcVar.zza, "androidWebViewCompatSender", zzqk.zzm(strL), new zzay(zzbcVar));
        }
        webView.setWebViewClient(new zzbb(zzbcVar));
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(webView, true);
        return zzbcVar;
    }

    @Nullable
    public final WebView zza() {
        return this.zza;
    }

    public final void zzc() {
        this.zzb.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.impl.zzaw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
    }

    public final /* synthetic */ void zzd() {
        WebView webView = this.zza;
        if (webView != null) {
            webView.destroy();
            this.zza = null;
        }
        this.zzd = null;
        this.zze = null;
    }

    public final /* synthetic */ void zze(JavaScriptMessage javaScriptMessage) {
        zzen zzenVar;
        if (this.zza == null || (zzenVar = this.zze) == null) {
            zzeo.zzd("Attempted to send bridge message after cleanup: ".concat(javaScriptMessage.toString()));
            return;
        }
        String strZzc = zzenVar.zzc(javaScriptMessage);
        zzeo.zzc("Sending Javascript msg: " + javaScriptMessage.toString() + "; URL: " + strZzc);
        WebView webView = this.zza;
        if (webView == null) {
            zzeo.zzd("WebView not available at evaluateJavascript");
            return;
        }
        try {
            webView.evaluateJavascript(strZzc, null);
        } catch (IllegalStateException unused) {
            this.zza.loadUrl(strZzc);
        }
    }

    @UiThread
    public final void zzf(String str) {
        WebView webView = this.zza;
        if (webView == null) {
            zzeo.zza("WebView not available at loadHostPage");
        } else {
            webView.loadUrl(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzg(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = ", Message Type: "
            java.lang.String r1 = "Received Javascript msg: "
            com.google.ads.interactivemedia.v3.internal.zzen r2 = r6.zze
            if (r2 == 0) goto L85
            int r3 = r8.hashCode()     // Catch: java.lang.Exception -> L36 java.lang.IllegalArgumentException -> L6d
            r4 = 48
            r5 = 1
            if (r3 == r4) goto L20
            r4 = 52
            if (r3 == r4) goto L16
            goto L2a
        L16:
            java.lang.String r3 = "4"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L2a
            r3 = r5
            goto L2b
        L20:
            java.lang.String r3 = "0"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L2a
            r3 = 0
            goto L2b
        L2a:
            r3 = -1
        L2b:
            if (r3 == 0) goto L38
            if (r3 == r5) goto L31
            r2 = 0
            goto L3c
        L31:
            com.google.ads.interactivemedia.v3.impl.JavaScriptMessage r2 = r2.zzb(r7)     // Catch: java.lang.Exception -> L36 java.lang.IllegalArgumentException -> L6d
            goto L3c
        L36:
            r1 = move-exception
            goto L55
        L38:
            com.google.ads.interactivemedia.v3.impl.JavaScriptMessage r2 = r2.zza(r7)     // Catch: java.lang.Exception -> L36 java.lang.IllegalArgumentException -> L6d
        L3c:
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L36 java.lang.IllegalArgumentException -> L6d
            java.lang.String r1 = r1.concat(r3)     // Catch: java.lang.Exception -> L36 java.lang.IllegalArgumentException -> L6d
            com.google.ads.interactivemedia.v3.internal.zzeo.zzc(r1)     // Catch: java.lang.Exception -> L36 java.lang.IllegalArgumentException -> L6d
            com.google.ads.interactivemedia.v3.impl.zzaz r7 = r6.zzd
            if (r7 != 0) goto L51
            java.lang.String r7 = "Received JS Message after destroyed."
            com.google.ads.interactivemedia.v3.internal.zzeo.zzd(r7)
            return
        L51:
            r7.zzl(r2)
            return
        L55:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid internal message. Message could not be be parsed: "
            r2.<init>(r3)
            r2.append(r7)
            r2.append(r0)
            r2.append(r8)
            java.lang.String r7 = r2.toString()
            com.google.ads.interactivemedia.v3.internal.zzeo.zzb(r7, r1)
            return
        L6d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid internal message. Make sure the Google IMA SDK library is up to date. Message: "
            r1.<init>(r2)
            r1.append(r7)
            r1.append(r0)
            r1.append(r8)
            java.lang.String r7 = r1.toString()
            com.google.ads.interactivemedia.v3.internal.zzeo.zzd(r7)
            return
        L85:
            java.lang.String r7 = "Received JS Message after JavaScriptWebView destroyed"
            com.google.ads.interactivemedia.v3.internal.zzeo.zzd(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.impl.zzbc.zzg(java.lang.String, java.lang.String):void");
    }

    public final void zzh(zzaz zzazVar) {
        this.zzd = zzazVar;
    }

    public final void zzi(final JavaScriptMessage javaScriptMessage) {
        this.zzb.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.impl.zzax
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze(javaScriptMessage);
            }
        });
    }
}
