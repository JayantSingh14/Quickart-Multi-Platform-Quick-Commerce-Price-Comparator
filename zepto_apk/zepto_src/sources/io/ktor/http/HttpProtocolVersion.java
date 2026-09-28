package io.ktor.http;

import android.support.v4.media.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes.dex */
public final class HttpProtocolVersion {

    /* renamed from: d, reason: collision with root package name */
    public static final Companion f50210d = new Companion();

    /* renamed from: e, reason: collision with root package name */
    public static final HttpProtocolVersion f50211e = new HttpProtocolVersion("HTTP", 2, 0);

    /* renamed from: f, reason: collision with root package name */
    public static final HttpProtocolVersion f50212f = new HttpProtocolVersion("HTTP", 1, 1);

    /* renamed from: g, reason: collision with root package name */
    public static final HttpProtocolVersion f50213g = new HttpProtocolVersion("HTTP", 1, 0);

    /* renamed from: h, reason: collision with root package name */
    public static final HttpProtocolVersion f50214h = new HttpProtocolVersion("SPDY", 3, 0);

    /* renamed from: i, reason: collision with root package name */
    public static final HttpProtocolVersion f50215i = new HttpProtocolVersion("QUIC", 1, 0);

    /* renamed from: a, reason: collision with root package name */
    public final String f50216a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50217b;

    /* renamed from: c, reason: collision with root package name */
    public final int f50218c;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    public HttpProtocolVersion(String name, int i2, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f50216a = name;
        this.f50217b = i2;
        this.f50218c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpProtocolVersion)) {
            return false;
        }
        HttpProtocolVersion httpProtocolVersion = (HttpProtocolVersion) obj;
        return Intrinsics.b(this.f50216a, httpProtocolVersion.f50216a) && this.f50217b == httpProtocolVersion.f50217b && this.f50218c == httpProtocolVersion.f50218c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f50218c) + a.b(this.f50217b, this.f50216a.hashCode() * 31, 31);
    }

    public final String toString() {
        return this.f50216a + '/' + this.f50217b + ClassUtils.PACKAGE_SEPARATOR_CHAR + this.f50218c;
    }
}
