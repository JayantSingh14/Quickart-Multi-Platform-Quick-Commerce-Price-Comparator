package androidx.privacysandbox.ads.adservices.topics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class GetTopicsRequest {

    /* renamed from: a, reason: collision with root package name */
    public final String f11275a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11276b;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {
    }

    public GetTopicsRequest(String adsSdkName, boolean z) {
        Intrinsics.checkNotNullParameter(adsSdkName, "adsSdkName");
        this.f11275a = adsSdkName;
        this.f11276b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsRequest)) {
            return false;
        }
        GetTopicsRequest getTopicsRequest = (GetTopicsRequest) obj;
        return Intrinsics.b(this.f11275a, getTopicsRequest.f11275a) && this.f11276b == getTopicsRequest.f11276b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11276b) + (this.f11275a.hashCode() * 31);
    }

    public final String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.f11275a + ", shouldRecordObservation=" + this.f11276b;
    }

    public GetTopicsRequest() {
        this("", false);
    }
}
