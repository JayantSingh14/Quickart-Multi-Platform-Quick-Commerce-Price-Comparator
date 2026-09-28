package androidx.webkit;

import android.webkit.WebSettings;
import androidx.annotation.RequiresOptIn;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: classes3.dex */
public class WebSettingsCompat {

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
    @RequiresOptIn
    @Retention(RetentionPolicy.CLASS)
    public @interface ExperimentalBackForwardCache {
    }

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
    @RequiresOptIn
    @Retention(RetentionPolicy.CLASS)
    public @interface ExperimentalSpeculativeLoading {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ForceDark {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ForceDarkStrategy {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface MenuItemFlags {
    }

    public static void a(WebSettings webSettings, int i2) {
        ApiFeature.Q q = WebViewFeatureInternal.f12455i;
        if (q.c()) {
            webSettings.setForceDark(i2);
        } else {
            if (!q.d()) {
                throw WebViewFeatureInternal.a();
            }
            ((WebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebSettingsBoundaryInterface.class, WebViewGlueCommunicator.b().f12468a.convertSettings(webSettings))).setForceDark(i2);
        }
    }

    public static void b(WebSettings webSettings) {
        if (!WebViewFeatureInternal.f12456j.d()) {
            throw WebViewFeatureInternal.a();
        }
        ((WebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebSettingsBoundaryInterface.class, WebViewGlueCommunicator.b().f12468a.convertSettings(webSettings))).setForceDarkBehavior(2);
    }
}
