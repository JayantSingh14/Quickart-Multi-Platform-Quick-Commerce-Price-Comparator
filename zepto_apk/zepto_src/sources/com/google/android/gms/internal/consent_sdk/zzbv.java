package com.google.android.gms.internal.consent_sdk;

import android.webkit.WebView;
import androidx.annotation.UiThread;
import androidx.fragment.app.e;

@UiThread
/* loaded from: classes4.dex */
public final class zzbv extends WebView {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f36522b = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f36523a;

    public final void a(String str, String str2) {
        final String strD = e.D(str, "(", str2, ");");
        new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzbr
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue;
                zzbv zzbvVar = this.f36520a;
                String str3 = strD;
                synchronized (zzct.class) {
                    if (zzct.f36542a == null) {
                        try {
                            zzbvVar.evaluateJavascript("(function(){})()", null);
                            zzct.f36542a = Boolean.TRUE;
                        } catch (IllegalStateException unused) {
                            zzct.f36542a = Boolean.FALSE;
                        }
                        zBooleanValue = zzct.f36542a.booleanValue();
                    } else {
                        zBooleanValue = zzct.f36542a.booleanValue();
                    }
                }
                if (zBooleanValue) {
                    zzbvVar.evaluateJavascript(str3, null);
                } else {
                    zzbvVar.loadUrl("javascript:".concat(str3));
                }
            }
        };
        throw null;
    }
}
