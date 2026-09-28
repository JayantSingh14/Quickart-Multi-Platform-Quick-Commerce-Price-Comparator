package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

@Metadata
/* loaded from: classes.dex */
public final class Header {

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f56627d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f56628e;

    /* renamed from: f, reason: collision with root package name */
    public static final ByteString f56629f;

    /* renamed from: g, reason: collision with root package name */
    public static final ByteString f56630g;

    /* renamed from: h, reason: collision with root package name */
    public static final ByteString f56631h;

    /* renamed from: i, reason: collision with root package name */
    public static final ByteString f56632i;

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f56633a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteString f56634b;

    /* renamed from: c, reason: collision with root package name */
    public final int f56635c;

    @Metadata
    public static final class Companion {
    }

    static {
        ByteString byteString = ByteString.f56924d;
        f56627d = ByteString.Companion.c(":");
        f56628e = ByteString.Companion.c(":status");
        f56629f = ByteString.Companion.c(":method");
        f56630g = ByteString.Companion.c(":path");
        f56631h = ByteString.Companion.c(":scheme");
        f56632i = ByteString.Companion.c(":authority");
    }

    public Header(ByteString name, ByteString value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f56633a = name;
        this.f56634b = value;
        this.f56635c = value.d() + name.d() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.b(this.f56633a, header.f56633a) && Intrinsics.b(this.f56634b, header.f56634b);
    }

    public final int hashCode() {
        return this.f56634b.hashCode() + (this.f56633a.hashCode() * 31);
    }

    public final String toString() {
        return this.f56633a.z() + ": " + this.f56634b.z();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String name, String value) {
        this(ByteString.Companion.c(name), ByteString.Companion.c(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ByteString byteString = ByteString.f56924d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(ByteString name, String value) {
        this(name, ByteString.Companion.c(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ByteString byteString = ByteString.f56924d;
    }
}
