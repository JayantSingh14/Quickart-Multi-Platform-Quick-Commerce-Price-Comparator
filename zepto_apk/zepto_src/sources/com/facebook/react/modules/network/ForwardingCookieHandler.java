package com.facebook.react.modules.network;

import android.webkit.CookieManager;
import com.facebook.react.bridge.ReactContext;
import java.net.CookieHandler;
import java.net.URI;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class ForwardingCookieHandler extends CookieHandler {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f19129b = 0;

    /* renamed from: a, reason: collision with root package name */
    public CookieManager f19130a;

    @Metadata
    public static final class Companion {
    }

    public ForwardingCookieHandler() {
    }

    public final CookieManager a() {
        if (this.f19130a == null) {
            try {
                this.f19130a = CookieManager.getInstance();
            } catch (IllegalArgumentException | Exception unused) {
                return null;
            }
        }
        return this.f19130a;
    }

    @Override // java.net.CookieHandler
    public final Map get(URI uri, Map headers) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(headers, "headers");
        CookieManager cookieManagerA = a();
        String cookie = cookieManagerA != null ? cookieManagerA.getCookie(uri.toString()) : null;
        return (cookie == null || cookie.length() == 0) ? MapsKt.c() : MapsKt.g(new Pair("Cookie", CollectionsKt.H(cookie)));
    }

    @Override // java.net.CookieHandler
    public final void put(URI uri, Map headers) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(headers, "headers");
        String url = uri.toString();
        Intrinsics.checkNotNullExpressionValue(url, "toString(...)");
        for (Map.Entry entry : headers.entrySet()) {
            String str = (String) entry.getKey();
            List<String> cookies = (List) entry.getValue();
            if (StringsKt.t(str, "Set-cookie", true) || StringsKt.t(str, "Set-cookie2", true)) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(cookies, "cookies");
                for (String str2 : cookies) {
                    CookieManager cookieManagerA = a();
                    if (cookieManagerA != null) {
                        cookieManagerA.setCookie(url, str2, null);
                    }
                }
                CookieManager cookieManagerA2 = a();
                if (cookieManagerA2 != null) {
                    cookieManagerA2.flush();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForwardingCookieHandler(ReactContext reactContext) {
        this();
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }
}
