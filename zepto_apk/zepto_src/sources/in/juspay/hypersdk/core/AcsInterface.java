package in.juspay.hypersdk.core;

import android.util.Base64;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class AcsInterface {

    @NonNull
    private final DynamicUI dui;

    @Nullable
    private final DuiInterface duiInterface;

    public AcsInterface(JuspayServices juspayServices) {
        this.dui = juspayServices.getDynamicUI();
        this.duiInterface = juspayServices.getJBridge();
    }

    private boolean isFunctionAllowedToInvoke(String str) {
        return str.matches("^[a-zA-Z0-9]*$");
    }

    @JavascriptInterface
    public String getDataFromSharedPrefs(String str) {
        DuiInterface duiInterface = this.duiInterface;
        return duiInterface != null ? duiInterface.getDataFromSharedPrefs(str, "") : "__failed";
    }

    @JavascriptInterface
    public String getResourceByName(String str) {
        DuiInterface duiInterface = this.duiInterface;
        return duiInterface != null ? duiInterface.getResourceByName(str) : "__failed";
    }

    @JavascriptInterface
    public String getSessionAttribute(String str) {
        DuiInterface duiInterface = this.duiInterface;
        return duiInterface != null ? duiInterface.getSessionAttribute(str, "") : "__failed";
    }

    @JavascriptInterface
    public String getSessionInfo() {
        DuiInterface duiInterface = this.duiInterface;
        String sessionInfo = duiInterface != null ? duiInterface.getSessionInfo() : "";
        return sessionInfo.equals("") ? "__failed" : sessionInfo;
    }

    @JavascriptInterface
    public void invoke(String str, String str2, String str3) {
        if (isFunctionAllowedToInvoke(str)) {
            this.dui.addJsToWebView(android.support.v4.media.b.r(androidx.fragment.app.e.v("window[\"onEvent'\"]('", str, "',atob('", Base64.encodeToString(str2.getBytes(), 2), "'),'"), str3, "')"));
        }
    }

    @JavascriptInterface
    public boolean isOnline() {
        DuiInterface duiInterface = this.duiInterface;
        if (duiInterface != null) {
            return duiInterface.isOnline();
        }
        return true;
    }

    @JavascriptInterface
    public void invoke(String str, String str2) {
        if (isFunctionAllowedToInvoke(str)) {
            this.dui.addJsToWebView(android.support.v4.media.b.m("window[\"onEvent'\"]('", str, "',atob('", Base64.encodeToString(str2.getBytes(), 2), "'))"));
        }
    }
}
