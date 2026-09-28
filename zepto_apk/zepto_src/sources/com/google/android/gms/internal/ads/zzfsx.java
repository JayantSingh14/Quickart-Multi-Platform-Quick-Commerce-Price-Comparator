package com.google.android.gms.internal.ads;

import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfsx extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfsz f31814a;

    public zzfsx(zzfsz zzfszVar) {
        Objects.requireNonNull(zzfszVar);
        this.f31814a = zzfszVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        String string = renderProcessGoneDetail.toString();
        String strValueOf = String.valueOf(webView);
        Log.w("NativeBridge", android.support.v4.media.a.n(new StringBuilder(String.valueOf(string).length() + 36 + strValueOf.length()), "WebView renderer gone: ", string, "for WebView: ", strValueOf));
        zzfsz zzfszVar = this.f31814a;
        if (zzfszVar.c() == webView) {
            Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            zzfszVar.f31811b = new zzftx(null);
        }
        webView.destroy();
        return true;
    }
}
