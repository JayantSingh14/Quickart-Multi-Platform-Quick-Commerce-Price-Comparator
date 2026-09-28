package androidx.privacysandbox.ads.adservices.adid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class AdId {

    /* renamed from: a, reason: collision with root package name */
    public final String f11151a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11152b;

    public AdId(String adId, boolean z) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        this.f11151a = adId;
        this.f11152b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdId)) {
            return false;
        }
        AdId adId = (AdId) obj;
        return Intrinsics.b(this.f11151a, adId.f11151a) && this.f11152b == adId.f11152b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11152b) + (this.f11151a.hashCode() * 31);
    }

    public final String toString() {
        return "AdId: adId=" + this.f11151a + ", isLimitAdTrackingEnabled=" + this.f11152b;
    }
}
