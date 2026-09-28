package androidx.privacysandbox.ads.adservices.common;

import android.annotation.SuppressLint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes3.dex */
public final class AdSelectionSignals {
    public AdSelectionSignals() {
        Intrinsics.checkNotNullParameter("", "signals");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionSignals)) {
            return false;
        }
        ((AdSelectionSignals) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "AdSelectionSignals: ";
    }
}
