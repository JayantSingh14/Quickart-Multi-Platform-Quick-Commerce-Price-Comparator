package io.ktor.http;

import coil3.network.internal.UtilsKt;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HttpStatusCode implements Comparable<HttpStatusCode> {

    /* renamed from: c, reason: collision with root package name */
    public static final HttpStatusCode f50219c;

    /* renamed from: d, reason: collision with root package name */
    public static final HttpStatusCode f50220d;

    /* renamed from: e, reason: collision with root package name */
    public static final HttpStatusCode f50221e;

    /* renamed from: f, reason: collision with root package name */
    public static final HttpStatusCode f50222f;

    /* renamed from: g, reason: collision with root package name */
    public static final HttpStatusCode f50223g;

    /* renamed from: h, reason: collision with root package name */
    public static final HttpStatusCode f50224h;

    /* renamed from: i, reason: collision with root package name */
    public static final HttpStatusCode f50225i;

    /* renamed from: j, reason: collision with root package name */
    public static final HttpStatusCode f50226j;

    /* renamed from: k, reason: collision with root package name */
    public static final HttpStatusCode f50227k;

    /* renamed from: l, reason: collision with root package name */
    public static final List f50228l;

    /* renamed from: a, reason: collision with root package name */
    public final int f50229a;

    /* renamed from: b, reason: collision with root package name */
    public final String f50230b;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    static {
        HttpStatusCode httpStatusCode = new HttpStatusCode(100, "Continue");
        HttpStatusCode httpStatusCode2 = new HttpStatusCode(101, "Switching Protocols");
        f50219c = httpStatusCode2;
        HttpStatusCode httpStatusCode3 = new HttpStatusCode(102, "Processing");
        HttpStatusCode httpStatusCode4 = new HttpStatusCode(200, "OK");
        HttpStatusCode httpStatusCode5 = new HttpStatusCode(201, "Created");
        HttpStatusCode httpStatusCode6 = new HttpStatusCode(202, "Accepted");
        HttpStatusCode httpStatusCode7 = new HttpStatusCode(203, "Non-Authoritative Information");
        HttpStatusCode httpStatusCode8 = new HttpStatusCode(204, "No Content");
        HttpStatusCode httpStatusCode9 = new HttpStatusCode(205, "Reset Content");
        HttpStatusCode httpStatusCode10 = new HttpStatusCode(206, "Partial Content");
        HttpStatusCode httpStatusCode11 = new HttpStatusCode(207, "Multi-Status");
        HttpStatusCode httpStatusCode12 = new HttpStatusCode(300, "Multiple Choices");
        HttpStatusCode httpStatusCode13 = new HttpStatusCode(301, "Moved Permanently");
        f50220d = httpStatusCode13;
        HttpStatusCode httpStatusCode14 = new HttpStatusCode(302, "Found");
        f50221e = httpStatusCode14;
        HttpStatusCode httpStatusCode15 = new HttpStatusCode(303, "See Other");
        f50222f = httpStatusCode15;
        HttpStatusCode httpStatusCode16 = new HttpStatusCode(UtilsKt.HTTP_RESPONSE_NOT_MODIFIED, "Not Modified");
        f50223g = httpStatusCode16;
        HttpStatusCode httpStatusCode17 = new HttpStatusCode(305, "Use Proxy");
        HttpStatusCode httpStatusCode18 = new HttpStatusCode(306, "Switch Proxy");
        HttpStatusCode httpStatusCode19 = new HttpStatusCode(307, "Temporary Redirect");
        f50224h = httpStatusCode19;
        HttpStatusCode httpStatusCode20 = new HttpStatusCode(308, "Permanent Redirect");
        f50225i = httpStatusCode20;
        HttpStatusCode httpStatusCode21 = new HttpStatusCode(400, "Bad Request");
        f50226j = httpStatusCode21;
        HttpStatusCode httpStatusCode22 = new HttpStatusCode(401, "Unauthorized");
        HttpStatusCode httpStatusCode23 = new HttpStatusCode(402, "Payment Required");
        HttpStatusCode httpStatusCode24 = new HttpStatusCode(403, "Forbidden");
        HttpStatusCode httpStatusCode25 = new HttpStatusCode(404, "Not Found");
        HttpStatusCode httpStatusCode26 = new HttpStatusCode(405, "Method Not Allowed");
        HttpStatusCode httpStatusCode27 = new HttpStatusCode(406, "Not Acceptable");
        HttpStatusCode httpStatusCode28 = new HttpStatusCode(407, "Proxy Authentication Required");
        HttpStatusCode httpStatusCode29 = new HttpStatusCode(408, "Request Timeout");
        HttpStatusCode httpStatusCode30 = new HttpStatusCode(409, "Conflict");
        HttpStatusCode httpStatusCode31 = new HttpStatusCode(410, "Gone");
        HttpStatusCode httpStatusCode32 = new HttpStatusCode(411, "Length Required");
        HttpStatusCode httpStatusCode33 = new HttpStatusCode(412, "Precondition Failed");
        HttpStatusCode httpStatusCode34 = new HttpStatusCode(413, "Payload Too Large");
        HttpStatusCode httpStatusCode35 = new HttpStatusCode(414, "Request-URI Too Long");
        HttpStatusCode httpStatusCode36 = new HttpStatusCode(415, "Unsupported Media Type");
        HttpStatusCode httpStatusCode37 = new HttpStatusCode(416, "Requested Range Not Satisfiable");
        HttpStatusCode httpStatusCode38 = new HttpStatusCode(417, "Expectation Failed");
        HttpStatusCode httpStatusCode39 = new HttpStatusCode(422, "Unprocessable Entity");
        HttpStatusCode httpStatusCode40 = new HttpStatusCode(423, "Locked");
        HttpStatusCode httpStatusCode41 = new HttpStatusCode(424, "Failed Dependency");
        HttpStatusCode httpStatusCode42 = new HttpStatusCode(425, "Too Early");
        HttpStatusCode httpStatusCode43 = new HttpStatusCode(426, "Upgrade Required");
        HttpStatusCode httpStatusCode44 = new HttpStatusCode(429, "Too Many Requests");
        HttpStatusCode httpStatusCode45 = new HttpStatusCode(431, "Request Header Fields Too Large");
        HttpStatusCode httpStatusCode46 = new HttpStatusCode(500, "Internal Server Error");
        HttpStatusCode httpStatusCode47 = new HttpStatusCode(501, "Not Implemented");
        HttpStatusCode httpStatusCode48 = new HttpStatusCode(502, "Bad Gateway");
        HttpStatusCode httpStatusCode49 = new HttpStatusCode(503, "Service Unavailable");
        HttpStatusCode httpStatusCode50 = new HttpStatusCode(504, "Gateway Timeout");
        f50227k = httpStatusCode50;
        List listI = CollectionsKt.I(httpStatusCode, httpStatusCode2, httpStatusCode3, httpStatusCode4, httpStatusCode5, httpStatusCode6, httpStatusCode7, httpStatusCode8, httpStatusCode9, httpStatusCode10, httpStatusCode11, httpStatusCode12, httpStatusCode13, httpStatusCode14, httpStatusCode15, httpStatusCode16, httpStatusCode17, httpStatusCode18, httpStatusCode19, httpStatusCode20, httpStatusCode21, httpStatusCode22, httpStatusCode23, httpStatusCode24, httpStatusCode25, httpStatusCode26, httpStatusCode27, httpStatusCode28, httpStatusCode29, httpStatusCode30, httpStatusCode31, httpStatusCode32, httpStatusCode33, httpStatusCode34, httpStatusCode35, httpStatusCode36, httpStatusCode37, httpStatusCode38, httpStatusCode39, httpStatusCode40, httpStatusCode41, httpStatusCode42, httpStatusCode43, httpStatusCode44, httpStatusCode45, httpStatusCode46, httpStatusCode47, httpStatusCode48, httpStatusCode49, httpStatusCode50, new HttpStatusCode(505, "HTTP Version Not Supported"), new HttpStatusCode(506, "Variant Also Negotiates"), new HttpStatusCode(507, "Insufficient Storage"));
        f50228l = listI;
        List list = listI;
        int iF = MapsKt.f(CollectionsKt.r(list, 10));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
        for (Object obj : list) {
            linkedHashMap.put(Integer.valueOf(((HttpStatusCode) obj).f50229a), obj);
        }
    }

    public HttpStatusCode(int i2, String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.f50229a = i2;
        this.f50230b = description;
    }

    @Override // java.lang.Comparable
    public final int compareTo(HttpStatusCode httpStatusCode) {
        HttpStatusCode other = httpStatusCode;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f50229a - other.f50229a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HttpStatusCode) && ((HttpStatusCode) obj).f50229a == this.f50229a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f50229a);
    }

    public final String toString() {
        return this.f50229a + ' ' + this.f50230b;
    }
}
