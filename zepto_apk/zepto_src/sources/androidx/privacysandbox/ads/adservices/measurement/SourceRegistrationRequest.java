package androidx.privacysandbox.ads.adservices.measurement;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@ExperimentalFeatures.RegisterSourceOptIn
/* loaded from: classes3.dex */
public final class SourceRegistrationRequest {

    @Metadata
    @SourceDebugExtension
    public static final class Builder {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceRegistrationRequest)) {
            return false;
        }
        SourceRegistrationRequest sourceRegistrationRequest = (SourceRegistrationRequest) obj;
        sourceRegistrationRequest.getClass();
        sourceRegistrationRequest.getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "AppSourcesRegistrationRequest { RegistrationUris=[null], InputEvent=null }";
    }
}
