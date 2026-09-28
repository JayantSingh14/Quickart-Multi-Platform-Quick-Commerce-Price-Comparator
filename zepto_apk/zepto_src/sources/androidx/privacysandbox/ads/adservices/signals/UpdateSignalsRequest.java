package androidx.privacysandbox.ads.adservices.signals;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;

@Metadata
@ExperimentalFeatures.Ext12OptIn
/* loaded from: classes3.dex */
public final class UpdateSignalsRequest {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateSignalsRequest)) {
            return false;
        }
        ((UpdateSignalsRequest) obj).getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "UpdateSignalsRequest: updateUri=null";
    }
}
