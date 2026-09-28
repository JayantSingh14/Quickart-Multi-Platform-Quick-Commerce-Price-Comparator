package com.facebook.react.modules.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.JavaNetCookieJar;

@Metadata
/* loaded from: classes.dex */
public final class ReactCookieJarContainer implements CookieJarContainer {

    /* renamed from: b, reason: collision with root package name */
    public JavaNetCookieJar f19156b;

    @Override // com.facebook.react.modules.network.CookieJarContainer
    public final void a() {
        this.f19156b = null;
    }

    @Override // okhttp3.CookieJar
    public final List b(HttpUrl url) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        JavaNetCookieJar javaNetCookieJar = this.f19156b;
        if (javaNetCookieJar == null) {
            return EmptyList.f53609a;
        }
        List<Cookie> listB = javaNetCookieJar.b(url);
        ArrayList arrayList = new ArrayList();
        for (Cookie cookie : listB) {
            try {
                new Headers.Builder().a(cookie.f56225a, cookie.f56226b);
                arrayList.add(cookie);
            } catch (IllegalArgumentException unused) {
            }
        }
        return arrayList;
    }

    @Override // com.facebook.react.modules.network.CookieJarContainer
    public final void c(JavaNetCookieJar cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.f19156b = cookieJar;
    }

    @Override // okhttp3.CookieJar
    public final void d(HttpUrl url, List cookies) throws IOException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        JavaNetCookieJar javaNetCookieJar = this.f19156b;
        if (javaNetCookieJar != null) {
            javaNetCookieJar.d(url, cookies);
        }
    }
}
