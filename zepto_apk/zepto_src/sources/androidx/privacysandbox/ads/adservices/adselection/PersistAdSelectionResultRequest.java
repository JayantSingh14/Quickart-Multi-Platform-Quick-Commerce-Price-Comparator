package androidx.privacysandbox.ads.adservices.adselection;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.Metadata;

@ExperimentalFeatures.Ext10OptIn
@Metadata
/* loaded from: classes3.dex */
public final class PersistAdSelectionResultRequest {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersistAdSelectionResultRequest)) {
            return false;
        }
        PersistAdSelectionResultRequest persistAdSelectionResultRequest = (PersistAdSelectionResultRequest) obj;
        persistAdSelectionResultRequest.getClass();
        persistAdSelectionResultRequest.getClass();
        persistAdSelectionResultRequest.getClass();
        return Arrays.equals((byte[]) null, (byte[]) null);
    }

    public final int hashCode() {
        return Long.hashCode(0L) * 961;
    }

    public final String toString() {
        return "PersistAdSelectionResultRequest: adSelectionId=0, seller=null, adSelectionResult=null";
    }
}
