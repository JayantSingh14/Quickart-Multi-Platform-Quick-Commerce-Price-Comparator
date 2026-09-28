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
public final class TopicsManagerApi31Ext9Impl extends TopicsManagerImplCommon {
    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon
    public final android.adservices.topics.GetTopicsRequest b(GetTopicsRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return GetTopicsRequestHelper.a(request);
    }
}
