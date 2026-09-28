package androidx.privacysandbox.ads.adservices.adselection;

import androidx.annotation.RequiresExtension;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;

@ExperimentalFeatures.Ext10OptIn
@Metadata
/* loaded from: classes3.dex */
public final class GetAdSelectionDataRequest {

    @RequiresExtension.Container
    @Metadata
    public static final class Ext10Impl {

        @Metadata
        public static final class Companion {
        }
    }

    @RequiresExtension.Container
    @Metadata
    public static final class Ext12Impl {

        @Metadata
        public static final class Companion {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataRequest)) {
            return false;
        }
        GetAdSelectionDataRequest getAdSelectionDataRequest = (GetAdSelectionDataRequest) obj;
        getAdSelectionDataRequest.getClass();
        getAdSelectionDataRequest.getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "GetAdSelectionDataRequest: seller=null, coordinatorOriginUri=null";
    }
}
