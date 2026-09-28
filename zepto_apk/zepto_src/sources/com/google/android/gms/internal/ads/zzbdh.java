package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final /* synthetic */ class zzbdh implements ValueCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbdi f24775a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbda f24776b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WebView f24777c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f24778d;

    public /* synthetic */ zzbdh(zzbdi zzbdiVar, zzbda zzbdaVar, WebView webView, boolean z) {
        this.f24775a = zzbdiVar;
        this.f24776b = zzbdaVar;
        this.f24777c = webView;
        this.f24778d = z;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        zzbdk zzbdkVar = this.f24775a.f24781c;
        zzbda zzbdaVar = this.f24776b;
        WebView webView = this.f24777c;
        String str = (String) obj;
        boolean z = this.f24778d;
        zzbdkVar.getClass();
        synchronized (zzbdaVar.f24749g) {
            zzbdaVar.f24755m--;
        }
        try {
            boolean z2 = true;
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("text");
                if (zzbdkVar.n || TextUtils.isEmpty(webView.getTitle())) {
                    zzbdaVar.a(strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(strOptString).length());
                    sb.append(title);
                    sb.append(StringUtils.LF);
                    sb.append(strOptString);
                    zzbdaVar.a(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            synchronized (zzbdaVar.f24749g) {
                if (zzbdaVar.f24755m != 0) {
                    z2 = false;
                }
            }
            if (z2) {
                zzbdkVar.f24787d.a(zzbdaVar);
            }
        } catch (JSONException unused) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Json string may be malformed.");
        } catch (Throwable th) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("ContentFetchTask.processWebViewContent", th);
        }
    }
}
