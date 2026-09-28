package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes3.dex */
public final class AdSelectionOutcome {

    /* renamed from: a, reason: collision with root package name */
    public final long f11182a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f11183b;

    @ExperimentalFeatures.Ext10OptIn
    @Metadata
    public static final class Companion {
    }

    static {
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        new AdSelectionOutcome(0L, EMPTY);
    }

    public AdSelectionOutcome(long j2, Uri renderUri) {
        Intrinsics.checkNotNullParameter(renderUri, "renderUri");
        this.f11182a = j2;
        this.f11183b = renderUri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionOutcome)) {
            return false;
        }
        AdSelectionOutcome adSelectionOutcome = (AdSelectionOutcome) obj;
        return this.f11182a == adSelectionOutcome.f11182a && Intrinsics.b(this.f11183b, adSelectionOutcome.f11183b);
    }

    public final int hashCode() {
        return this.f11183b.hashCode() + (Long.hashCode(this.f11182a) * 31);
    }

    public final String toString() {
        return "AdSelectionOutcome: adSelectionId=" + this.f11182a + ", renderUri=" + this.f11183b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AdSelectionOutcome(android.adservices.adselection.AdSelectionOutcome response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long adSelectionId = response.getAdSelectionId();
        Uri renderUri = response.getRenderUri();
        Intrinsics.checkNotNullExpressionValue(renderUri, "response.renderUri");
        this(adSelectionId, renderUri);
    }
}
