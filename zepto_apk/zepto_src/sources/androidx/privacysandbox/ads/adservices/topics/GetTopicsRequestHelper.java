package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo
/* loaded from: classes3.dex */
public final class GetTopicsRequestHelper {
    public static android.adservices.topics.GetTopicsRequest a(GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        android.adservices.topics.GetTopicsRequest getTopicsRequestBuild = androidx.privacysandbox.ads.adservices.customaudience.a.h().setAdsSdkName(request.f11275a).setShouldRecordObservation(request.f11276b).build();
        Intrinsics.checkNotNullExpressionValue(getTopicsRequestBuild, "Builder()\n            .s…ion)\n            .build()");
        return getTopicsRequestBuild;
    }
}
