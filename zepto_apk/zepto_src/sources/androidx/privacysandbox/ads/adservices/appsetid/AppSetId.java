package androidx.privacysandbox.ads.adservices.appsetid;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AppSetId {

    /* renamed from: a, reason: collision with root package name */
    public final String f11186a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11187b;

    @Metadata
    public static final class Companion {
    }

    public AppSetId(String id, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.f11186a = id;
        this.f11187b = i2;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("Scope undefined.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSetId)) {
            return false;
        }
        AppSetId appSetId = (AppSetId) obj;
        return Intrinsics.b(this.f11186a, appSetId.f11186a) && this.f11187b == appSetId.f11187b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f11187b) + (this.f11186a.hashCode() * 31);
    }

    public final String toString() {
        return b.s(new StringBuilder("AppSetId: id="), this.f11186a, ", scope=", this.f11187b == 1 ? "SCOPE_APP" : "SCOPE_DEVELOPER");
    }
}
