package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Build;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzj f21900a;

    public /* synthetic */ zzh(zzj zzjVar) {
        this.f21900a = zzjVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        WebViewClient webViewClientE;
        zzj zzjVar = this.f21900a;
        zzjVar.getClass();
        try {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            int i2 = Build.VERSION.SDK_INT;
            WebView webView = zzjVar.f21902a;
            if (i2 < 26) {
                if (WebViewFeature.a("GET_WEB_VIEW_CLIENT")) {
                    try {
                        webViewClientE = WebViewCompat.e(webView);
                    } catch (RuntimeException e2) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdUtil.getWebViewClient", e2);
                    }
                }
                throw new IllegalStateException("getWebViewClient not supported");
            }
            webViewClientE = webView.getWebViewClient();
            if (webViewClientE == zzjVar) {
                return;
            }
            if (webViewClientE != null) {
                zzjVar.f21905d = webViewClientE;
            }
            webView.setWebViewClient(zzjVar);
            zzjVar.b();
        } catch (IllegalStateException unused) {
        }
    }
}
