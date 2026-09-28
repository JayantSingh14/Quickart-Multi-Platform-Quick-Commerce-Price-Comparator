package io.ktor.http;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class CookieEncoding {

    /* renamed from: a, reason: collision with root package name */
    public static final CookieEncoding f50157a;

    /* renamed from: b, reason: collision with root package name */
    public static final CookieEncoding f50158b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ CookieEncoding[] f50159c;

    static {
        CookieEncoding cookieEncoding = new CookieEncoding("RAW", 0);
        f50157a = cookieEncoding;
        CookieEncoding cookieEncoding2 = new CookieEncoding("DQUOTES", 1);
        CookieEncoding cookieEncoding3 = new CookieEncoding("URI_ENCODING", 2);
        f50158b = cookieEncoding3;
        f50159c = new CookieEncoding[]{cookieEncoding, cookieEncoding2, cookieEncoding3, new CookieEncoding("BASE64_ENCODING", 3)};
    }

    public static CookieEncoding valueOf(String str) {
        return (CookieEncoding) Enum.valueOf(CookieEncoding.class, str);
    }

    public static CookieEncoding[] values() {
        return (CookieEncoding[]) f50159c.clone();
    }
}
