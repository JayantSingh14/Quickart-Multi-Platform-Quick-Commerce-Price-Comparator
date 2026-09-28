package com.google.android.gms.internal.ads;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public final class zzciq extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    public final zzcjn f26342a;

    public zzciq(zzcjn zzcjnVar) {
        this.f26342a = zzcjnVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Context b(WebView webView) {
        if (!(webView instanceof zzcir)) {
            return webView.getContext();
        }
        zzcir zzcirVar = (zzcir) webView;
        Activity activityZzj = zzcirVar.zzj();
        return activityZzj != null ? activityZzj : zzcirVar.getContext();
    }

    public final boolean a(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        com.google.android.gms.ads.internal.zzb zzbVar;
        try {
            zzcjn zzcjnVar = this.f26342a;
            if (zzcjnVar != null && zzcjnVar.e0() != null && zzcjnVar.e0().w != null && (zzbVar = zzcjnVar.e0().w) != null && !zzbVar.a()) {
                StringBuilder sb = new StringBuilder(str.length() + 9 + String.valueOf(str3).length() + 2);
                sb.append("window.");
                sb.append(str);
                sb.append("('");
                sb.append(str3);
                sb.append("')");
                zzbVar.b(sb.toString());
                return false;
            }
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            AlertDialog.Builder builderK = com.google.android.gms.ads.internal.util.zzs.k(context);
            builderK.setTitle(str2);
            if (!z) {
                builderK.setMessage(str3).setPositiveButton(R.string.ok, new zzcil(jsResult)).setNegativeButton(R.string.cancel, new zzcik(jsResult)).setOnCancelListener(new zzcij(jsResult)).create().show();
                return true;
            }
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(context);
            textView.setText(str3);
            EditText editText = new EditText(context);
            editText.setText(str4);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            builderK.setView(linearLayout).setPositiveButton(R.string.ok, new zzcio(jsPromptResult, editText)).setNegativeButton(R.string.cancel, new zzcin(jsPromptResult)).setOnCancelListener(new zzcim(jsPromptResult)).create().show();
            return true;
        } catch (WindowManager.BadTokenException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Fail to display Dialog.", e2);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcir)) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZ = ((zzcir) webView).z();
        if (zzmVarZ != null) {
            zzmVarZ.zzb();
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Tried to close an AdWebView not associated with an overlay.");
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String strMessage = consoleMessage.message();
        String strSourceId = consoleMessage.sourceId();
        int iLineNumber = consoleMessage.lineNumber();
        int length = String.valueOf(strMessage).length();
        StringBuilder sb = new StringBuilder(android.support.v4.media.b.b(length + 6 + String.valueOf(strSourceId).length(), 1, String.valueOf(iLineNumber).length(), 1));
        android.support.v4.media.b.B(sb, "JS: ", strMessage, " (", strSourceId);
        String strU = androidx.fragment.app.e.u(sb, ":", iLineNumber, ")");
        if (strU.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i2 = zzcip.f26341a[consoleMessage.messageLevel().ordinal()];
        if (i2 == 1) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c(strU);
        } else if (i2 == 2) {
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f(strU);
        } else if (i2 == 3 || i2 == 4 || i2 != 5) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.e(strU);
        } else {
            int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.a(strU);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        zzcjn zzcjnVar = this.f26342a;
        if (((zzcju) zzcjnVar.f26410a).E0() != null) {
            webView2.setWebViewClient(((zzcju) zzcjnVar.f26410a).E0());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
        long j5 = 5242880 - j4;
        if (j5 <= 0) {
            quotaUpdater.updateQuota(j2);
            return;
        }
        if (j2 == 0) {
            if (j3 > j5 || j3 > 1048576) {
                j3 = 0;
            }
        } else if (j3 == 0) {
            j3 = Math.min(Math.min(131072L, j5) + j2, 1048576L);
        } else {
            if (j3 <= Math.min(1048576 - j2, j5)) {
                j2 += j3;
            }
            j3 = j2;
        }
        quotaUpdater.updateQuota(j3);
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (callback != null) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            zzcjn zzcjnVar = this.f26342a;
            boolean z = com.google.android.gms.ads.internal.util.zzs.d(zzcjnVar.getContext(), "android.permission.ACCESS_FINE_LOCATION") || com.google.android.gms.ads.internal.util.zzs.d(zzcjnVar.getContext(), "android.permission.ACCESS_COARSE_LOCATION");
            zzbgb zzbgbVar = zzbgk.qe;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                callback.invoke(str, false, true);
            } else {
                callback.invoke(str, z, true);
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.re)).booleanValue()) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("AdWebChromeClient.onGeolocationPermissionsShowPrompt()");
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZ = ((zzcju) this.f26342a.f26410a).z();
        if (zzmVarZ != null) {
            zzmVarZ.zzc();
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not get ad overlay when hiding custom view.");
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return a(b(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return a(b(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return a(b(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return a(b(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZ = ((zzcju) this.f26342a.f26410a).z();
        if (zzmVarZ == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        Activity activity = zzmVarZ.f21360b;
        FrameLayout frameLayout = new FrameLayout(activity);
        zzmVarZ.f21366h = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        zzmVarZ.f21366h.addView(view, -1, -1);
        activity.setContentView(zzmVarZ.f21366h);
        zzmVarZ.r = true;
        zzmVarZ.f21367i = customViewCallback;
        zzmVarZ.f21365g = true;
        zzmVarZ.fc(i2);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
