package io.ktor.http;

import android.support.v4.media.b;
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
public final class URLProtocol {

    /* renamed from: c, reason: collision with root package name */
    public static final URLProtocol f50253c;

    /* renamed from: d, reason: collision with root package name */
    public static final URLProtocol f50254d;

    /* renamed from: e, reason: collision with root package name */
    public static final URLProtocol f50255e;

    /* renamed from: f, reason: collision with root package name */
    public static final LinkedHashMap f50256f;

    /* renamed from: a, reason: collision with root package name */
    public final String f50257a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50258b;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    static {
        URLProtocol uRLProtocol = new URLProtocol("http", 80);
        f50253c = uRLProtocol;
        URLProtocol uRLProtocol2 = new URLProtocol("https", 443);
        URLProtocol uRLProtocol3 = new URLProtocol("ws", 80);
        f50254d = uRLProtocol3;
        URLProtocol uRLProtocol4 = new URLProtocol("wss", 443);
        f50255e = uRLProtocol4;
        List listI = CollectionsKt.I(uRLProtocol, uRLProtocol2, uRLProtocol3, uRLProtocol4, new URLProtocol("socks", 1080));
        int iF = MapsKt.f(CollectionsKt.r(listI, 10));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
        for (Object obj : listI) {
            linkedHashMap.put(((URLProtocol) obj).f50257a, obj);
        }
        f50256f = linkedHashMap;
    }

    public URLProtocol(String name, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f50257a = name;
        this.f50258b = i2;
        for (int i3 = 0; i3 < name.length(); i3++) {
            char cCharAt = name.charAt(i3);
            if (Character.toLowerCase(cCharAt) != cCharAt) {
                throw new IllegalArgumentException("All characters should be lower case");
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof URLProtocol)) {
            return false;
        }
        URLProtocol uRLProtocol = (URLProtocol) obj;
        return Intrinsics.b(this.f50257a, uRLProtocol.f50257a) && this.f50258b == uRLProtocol.f50258b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f50258b) + (this.f50257a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("URLProtocol(name=");
        sb.append(this.f50257a);
        sb.append(", defaultPort=");
        return b.n(sb, this.f50258b, ')');
    }
}
