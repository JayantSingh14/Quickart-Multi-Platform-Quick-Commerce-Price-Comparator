package androidx.privacysandbox.ads.adservices.adselection;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Metadata
@ExperimentalFeatures.Ext8OptIn
/* loaded from: classes3.dex */
public final class ReportEventRequest {

    @Metadata
    public static final class Companion {
    }

    @RequiresExtension.Container
    @Metadata
    public static final class Ext10Impl {

        @Metadata
        public static final class Companion {
        }
    }

    @RequiresExtension.Container
    @Metadata
    public static final class Ext8Impl {

        @Metadata
        public static final class Companion {
        }
    }

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    @RestrictTo
    public @interface ReportingDestination {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportEventRequest)) {
            return false;
        }
        ReportEventRequest reportEventRequest = (ReportEventRequest) obj;
        reportEventRequest.getClass();
        reportEventRequest.getClass();
        reportEventRequest.getClass();
        reportEventRequest.getClass();
        reportEventRequest.getClass();
        return true;
    }

    public final int hashCode() {
        Long.hashCode(0L);
        throw null;
    }

    public final String toString() {
        return "ReportEventRequest: adSelectionId=0, eventKey=null, eventData=null, reportingDestinations=0inputEvent=null";
    }
}
