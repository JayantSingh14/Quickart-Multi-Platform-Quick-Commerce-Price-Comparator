package io.ktor.client.statement;

import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class HttpResponseContainer {

    /* renamed from: a, reason: collision with root package name */
    public final TypeInfo f50062a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f50063b;

    public HttpResponseContainer(TypeInfo expectedType, Object response) {
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        Intrinsics.checkNotNullParameter(response, "response");
        this.f50062a = expectedType;
        this.f50063b = response;
    }

    public final TypeInfo a() {
        return this.f50062a;
    }

    public final Object b() {
        return this.f50063b;
    }

    public final Object c() {
        return this.f50063b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponseContainer)) {
            return false;
        }
        HttpResponseContainer httpResponseContainer = (HttpResponseContainer) obj;
        return Intrinsics.b(this.f50062a, httpResponseContainer.f50062a) && Intrinsics.b(this.f50063b, httpResponseContainer.f50063b);
    }

    public final int hashCode() {
        return this.f50063b.hashCode() + (this.f50062a.hashCode() * 31);
    }

    public final String toString() {
        return "HttpResponseContainer(expectedType=" + this.f50062a + ", response=" + this.f50063b + ')';
    }
}
