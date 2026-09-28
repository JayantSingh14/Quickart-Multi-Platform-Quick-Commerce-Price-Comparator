package com.reactnativecommunity.webview;

import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class RNCWebViewWrapper extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final RNCWebView f46311a;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNCWebViewWrapper(ThemedReactContext context, RNCWebView webView) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        webView.setBackgroundColor(0);
        addView(webView);
        View childAt = getChildAt(0);
        Intrinsics.d(childAt, "null cannot be cast to non-null type com.reactnativecommunity.webview.RNCWebView");
        this.f46311a = (RNCWebView) childAt;
    }

    public static final int a(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Object parent = webView.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            return view.getId();
        }
        return -1;
    }

    @NotNull
    public final RNCWebView getWebView() {
        return this.f46311a;
    }
}
