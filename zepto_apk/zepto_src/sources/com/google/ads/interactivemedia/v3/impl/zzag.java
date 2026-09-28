package com.google.ads.interactivemedia.v3.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.media.b;
import android.util.Base64;
import android.webkit.WebView;
import com.google.ads.interactivemedia.v3.internal.zzfl;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class zzag extends WebView {
    private zzag(Context context) {
        super(context);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static zzag zza(Context context, zzav zzavVar, com.google.ads.interactivemedia.v3.impl.data.zzbk zzbkVar, List list, zzfl zzflVar) {
        zzag zzagVar = new zzag(context);
        zzagVar.getSettings().setJavaScriptEnabled(true);
        zzagVar.getSettings().setSupportMultipleWindows(true);
        zzagVar.setWebChromeClient(new zzaf(context, zzflVar, list));
        if (zzbkVar.type() == com.google.ads.interactivemedia.v3.impl.data.zzbj.Html) {
            zzagVar.loadData(Base64.encodeToString(zzbkVar.src().getBytes(), 1), "text/html", "base64");
            return zzagVar;
        }
        if (zzbkVar.type() != com.google.ads.interactivemedia.v3.impl.data.zzbj.IFrame) {
            throw new IllegalArgumentException(b.D("Companion type ", String.valueOf(zzbkVar.type()), " is not valid for a CompanionWebView"));
        }
        zzagVar.loadUrl(zzbkVar.src());
        return zzagVar;
    }
}
