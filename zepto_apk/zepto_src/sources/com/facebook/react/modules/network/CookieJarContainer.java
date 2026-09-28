package com.facebook.react.modules.network;

import kotlin.Metadata;
import okhttp3.CookieJar;
import okhttp3.JavaNetCookieJar;

@Metadata
/* loaded from: classes.dex */
public interface CookieJarContainer extends CookieJar {
    void a();

    void c(JavaNetCookieJar javaNetCookieJar);
}
