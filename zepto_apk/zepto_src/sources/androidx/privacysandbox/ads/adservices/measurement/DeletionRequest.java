package androidx.privacysandbox.ads.adservices.measurement;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@RequiresApi
@Metadata
/* loaded from: classes3.dex */
public final class DeletionRequest {

    @Metadata
    @RequiresApi
    @SourceDebugExtension
    public static final class Builder {
    }

    @Metadata
    public static final class Companion {

        @Metadata
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention
        @RestrictTo
        public @interface DeletionMode {
        }

        @Metadata
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention
        @RestrictTo
        public @interface MatchBehavior {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeletionRequest)) {
            return false;
        }
        DeletionRequest deletionRequest = (DeletionRequest) obj;
        deletionRequest.getClass();
        HashSet hashSet = new HashSet((Collection) null);
        deletionRequest.getClass();
        if (hashSet.equals(new HashSet((Collection) null))) {
            HashSet hashSet2 = new HashSet((Collection) null);
            deletionRequest.getClass();
            if (hashSet2.equals(new HashSet((Collection) null))) {
                deletionRequest.getClass();
                deletionRequest.getClass();
                deletionRequest.getClass();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer.hashCode(0);
        throw null;
    }

    public final String toString() {
        return android.support.v4.media.b.m("DeletionRequest { DeletionMode=", "DELETION_MODE_ALL", ", MatchBehavior=", "MATCH_BEHAVIOR_DELETE", ", Start=null, End=null, DomainUris=null, OriginUris=null }");
    }
}
