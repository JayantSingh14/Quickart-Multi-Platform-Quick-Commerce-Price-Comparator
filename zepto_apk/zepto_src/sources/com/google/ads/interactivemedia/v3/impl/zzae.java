package com.google.ads.interactivemedia.v3.impl;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class zzae extends WebViewClient {
    final /* synthetic */ zzaf zza;

    public zzae(zzaf zzafVar) {
        this.zza = zzafVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!this.zza.zzb.zzb(str)) {
            return true;
        }
        Iterator it = this.zza.zzc.iterator();
        while (it.hasNext()) {
            ((CompanionAdSlot.ClickListener) it.next()).onCompanionAdClick();
        }
        return true;
    }
}
