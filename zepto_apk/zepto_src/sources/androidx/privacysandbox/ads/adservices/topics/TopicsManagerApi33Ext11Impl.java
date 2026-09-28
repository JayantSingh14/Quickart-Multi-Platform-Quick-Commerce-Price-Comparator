package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RequiresExtension
@RestrictTo
/* loaded from: classes3.dex */
public final class TopicsManagerApi33Ext11Impl extends TopicsManagerImplCommon {
    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon
    public final android.adservices.topics.GetTopicsRequest b(GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return GetTopicsRequestHelper.a(request);
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon
    public final GetTopicsResponse c(android.adservices.topics.GetTopicsResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return GetTopicsResponseHelper.a(response);
    }
}
