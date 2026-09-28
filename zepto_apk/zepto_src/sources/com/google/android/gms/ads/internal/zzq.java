package com.google.android.gms.ads.internal;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.media.b;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzbhw;
import java.util.Objects;
import java.util.TreeMap;

/* loaded from: classes4.dex */
final class zzq extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzs f21663a;

    public /* synthetic */ zzq(zzs zzsVar) {
        Objects.requireNonNull(zzsVar);
        this.f21663a = zzsVar;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        zzs zzsVar = this.f21663a;
        zzsVar.getClass();
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzbhw.f25103d.c());
        zzr zzrVar = zzsVar.f21673d;
        builder.appendQueryParameter("query", zzrVar.f21667d);
        builder.appendQueryParameter("pubId", zzrVar.f21665b);
        builder.appendQueryParameter("mappver", zzrVar.f21669f);
        TreeMap treeMap = zzrVar.f21666c;
        for (String str : treeMap.keySet()) {
            builder.appendQueryParameter(str, (String) treeMap.get(str));
        }
        Uri uriBuild = builder.build();
        String strYb = zzsVar.Yb();
        String encodedQuery = uriBuild.getEncodedQuery();
        return b.s(new StringBuilder(strYb.length() + 1 + String.valueOf(encodedQuery).length()), strYb, "#", encodedQuery);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object obj) {
        WebView webView = this.f21663a.f21674e;
        String str = (String) obj;
        if (webView == null || str == null) {
            return;
        }
        webView.loadUrl(str);
    }
}
