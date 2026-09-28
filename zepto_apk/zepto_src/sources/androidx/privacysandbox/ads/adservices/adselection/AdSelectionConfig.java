package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes3.dex */
public final class AdSelectionConfig {

    /* renamed from: f, reason: collision with root package name */
    public static final AdSelectionConfig f11158f;

    /* renamed from: a, reason: collision with root package name */
    public final AdTechIdentifier f11159a;

    /* renamed from: b, reason: collision with root package name */
    public final EmptyList f11160b;

    /* renamed from: c, reason: collision with root package name */
    public final AdSelectionSignals f11161c;

    /* renamed from: d, reason: collision with root package name */
    public final AdSelectionSignals f11162d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f11163e;

    @Metadata
    @RestrictTo
    public static final class Companion {
    }

    static {
        Intrinsics.checkNotNullParameter("", "identifier");
        AdTechIdentifier adTechIdentifier = new AdTechIdentifier();
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        EmptyList emptyList = EmptyList.f53609a;
        AdSelectionSignals adSelectionSignals = new AdSelectionSignals();
        AdSelectionSignals adSelectionSignals2 = new AdSelectionSignals();
        Map mapC = MapsKt.c();
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        f11158f = new AdSelectionConfig(adTechIdentifier, emptyList, adSelectionSignals, adSelectionSignals2, mapC);
    }

    public AdSelectionConfig(AdTechIdentifier seller, EmptyList customAudienceBuyers, AdSelectionSignals adSelectionSignals, AdSelectionSignals sellerSignals, Map perBuyerSignals) {
        Uri trustedScoringSignalsUri = Uri.EMPTY;
        Intrinsics.checkNotNullParameter(seller, "seller");
        Intrinsics.checkNotNullParameter(trustedScoringSignalsUri, "decisionLogicUri");
        Intrinsics.checkNotNullParameter(customAudienceBuyers, "customAudienceBuyers");
        Intrinsics.checkNotNullParameter(adSelectionSignals, "adSelectionSignals");
        Intrinsics.checkNotNullParameter(sellerSignals, "sellerSignals");
        Intrinsics.checkNotNullParameter(perBuyerSignals, "perBuyerSignals");
        Intrinsics.checkNotNullParameter(trustedScoringSignalsUri, "trustedScoringSignalsUri");
        this.f11159a = seller;
        this.f11160b = customAudienceBuyers;
        this.f11161c = adSelectionSignals;
        this.f11162d = sellerSignals;
        this.f11163e = perBuyerSignals;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionConfig)) {
            return false;
        }
        AdSelectionConfig adSelectionConfig = (AdSelectionConfig) obj;
        if (!this.f11159a.equals(adSelectionConfig.f11159a)) {
            return false;
        }
        Uri uri = Uri.EMPTY;
        return Intrinsics.b(uri, uri) && Intrinsics.b(this.f11160b, adSelectionConfig.f11160b) && this.f11161c.equals(adSelectionConfig.f11161c) && this.f11162d.equals(adSelectionConfig.f11162d) && this.f11163e.equals(adSelectionConfig.f11163e) && Intrinsics.b(uri, uri);
    }

    public final int hashCode() {
        Uri uri = Uri.EMPTY;
        int iHashCode = uri.hashCode() * 31;
        this.f11160b.getClass();
        return uri.hashCode() + ((1 + iHashCode) * 923521);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdSelectionConfig: seller=");
        sb.append(this.f11159a);
        sb.append(", decisionLogicUri='");
        Uri uri = Uri.EMPTY;
        sb.append(uri);
        sb.append("', customAudienceBuyers=");
        sb.append(this.f11160b);
        sb.append(", adSelectionSignals=");
        sb.append(this.f11161c);
        sb.append(", sellerSignals=");
        sb.append(this.f11162d);
        sb.append(", perBuyerSignals=");
        sb.append(this.f11163e);
        sb.append(", trustedScoringSignalsUri=");
        sb.append(uri);
        return sb.toString();
    }
}
