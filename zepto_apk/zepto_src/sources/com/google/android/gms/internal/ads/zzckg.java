package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;

@TargetApi(26)
/* loaded from: classes4.dex */
public final class zzckg extends zzckf {
    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean zDidCrash = renderProcessGoneDetail.didCrash();
        return this.f26369a.X(renderProcessGoneDetail.rendererPriorityAtExit(), zDidCrash);
    }
}
