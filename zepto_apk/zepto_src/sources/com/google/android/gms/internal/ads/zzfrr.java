package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
final class zzfrr implements WebViewCompat.WebMessageListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfrt f31747a;

    public zzfrr(zzfrt zzfrtVar) {
        Objects.requireNonNull(zzfrtVar);
        this.f31747a = zzfrtVar;
    }

    @Override // androidx.webkit.WebViewCompat.WebMessageListener
    public final void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) throws JSONException {
        int i2 = webMessageCompat.f12425b;
        if (i2 != 0) {
            throw new IllegalStateException(android.support.v4.media.b.r(new StringBuilder("Wrong data accessor type detected. "), i2 != 0 ? i2 != 1 ? "Unknown" : "ArrayBuffer" : "String", " expected, but got String"));
        }
        try {
            JSONObject jSONObject = new JSONObject(webMessageCompat.f12424a);
            String string = jSONObject.getString("method");
            String string2 = jSONObject.getJSONObject("data").getString("adSessionId");
            boolean zEquals = string.equals("startSession");
            zzfrt zzfrtVar = this.f31747a;
            if (zEquals) {
                zzfrtVar.a(string2);
                return;
            }
            if (string.equals("finishSession")) {
                HashMap map = zzfrtVar.f31751d;
                zzfrh zzfrhVar = (zzfrh) map.get(string2);
                if (zzfrhVar != null) {
                    zzfrhVar.b();
                    map.remove(string2);
                }
            }
        } catch (JSONException e2) {
            zzftc.a("Error parsing JS message in JavaScriptSessionService.", e2);
        }
    }
}
