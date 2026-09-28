package io.ktor.http;

import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class ContentDisposition extends HeaderValueWithParameters {

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    @Metadata
    public static final class Parameters {
    }

    static {
        new ContentDisposition(UtilsKt.SCHEME_FILE);
        new ContentDisposition("mixed");
        new ContentDisposition("attachment");
        new ContentDisposition("inline");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ContentDisposition(String disposition) {
        EmptyList parameters = EmptyList.f53609a;
        Intrinsics.checkNotNullParameter(disposition, "disposition");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        super(disposition, parameters);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ContentDisposition)) {
            return false;
        }
        ContentDisposition contentDisposition = (ContentDisposition) obj;
        if (Intrinsics.b(this.f50197a, contentDisposition.f50197a)) {
            return Intrinsics.b(this.f50198b, contentDisposition.f50198b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f50198b.hashCode() + (this.f50197a.hashCode() * 31);
    }
}
