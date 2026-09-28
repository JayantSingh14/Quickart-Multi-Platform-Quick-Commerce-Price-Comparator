package androidx.privacysandbox.ads.adservices.adselection;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalFeatures.Ext10OptIn
@Metadata
/* loaded from: classes3.dex */
public final class GetAdSelectionDataOutcome {

    /* renamed from: a, reason: collision with root package name */
    public final long f11184a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f11185b;

    public GetAdSelectionDataOutcome(android.adservices.adselection.GetAdSelectionDataOutcome response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long adSelectionId = response.getAdSelectionId();
        byte[] adSelectionData = response.getAdSelectionData();
        this.f11184a = adSelectionId;
        this.f11185b = adSelectionData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataOutcome)) {
            return false;
        }
        GetAdSelectionDataOutcome getAdSelectionDataOutcome = (GetAdSelectionDataOutcome) obj;
        return this.f11184a == getAdSelectionDataOutcome.f11184a && Arrays.equals(this.f11185b, getAdSelectionDataOutcome.f11185b);
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(this.f11184a) * 31;
        byte[] bArr = this.f11185b;
        return iHashCode + (bArr != null ? bArr.hashCode() : 0);
    }

    public final String toString() {
        return "GetAdSelectionDataOutcome: adSelectionId=" + this.f11184a + ", adSelectionData=" + this.f11185b;
    }
}
