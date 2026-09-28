package io.sentry.react;

import io.sentry.Breadcrumb;
import io.sentry.IScope;
import io.sentry.ScopeCallback;
import io.sentry.SentryOptions;
import io.sentry.android.core.AndroidLogger;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ScopeCallback, SentryOptions.BeforeBreadcrumbCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f53016a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f53017b;

    public /* synthetic */ a(String str, String str2) {
        this.f53016a = str;
        this.f53017b = str2;
    }

    @Override // io.sentry.SentryOptions.BeforeBreadcrumbCallback
    public Breadcrumb a(Breadcrumb breadcrumb) {
        String str;
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        Object obj = breadcrumb.f51559e.get("url");
        String str2 = obj instanceof String ? (String) obj : "";
        if (!"http".equals(breadcrumb.f51558d)) {
            return breadcrumb;
        }
        String str3 = this.f53016a;
        if ((str3 == null || !str2.startsWith(str3)) && ((str = this.f53017b) == null || !str2.startsWith(str))) {
            return breadcrumb;
        }
        return null;
    }

    @Override // io.sentry.ScopeCallback
    public void h(IScope iScope) {
        AndroidLogger androidLogger = RNSentryModuleImpl.f52986l;
        iScope.e(this.f53016a, this.f53017b);
    }
}
