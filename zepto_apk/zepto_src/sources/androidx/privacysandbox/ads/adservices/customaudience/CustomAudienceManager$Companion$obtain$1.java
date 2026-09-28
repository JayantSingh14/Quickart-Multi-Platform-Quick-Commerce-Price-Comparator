package androidx.privacysandbox.ads.adservices.customaudience;

import android.content.Context;
import in.juspay.hyper.constants.LogCategory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class CustomAudienceManager$Companion$obtain$1 extends Lambda implements Function1<Context, CustomAudienceManagerApi31Ext9Impl> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Context it = (Context) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(null, LogCategory.CONTEXT);
        android.adservices.customaudience.CustomAudienceManager customAudienceManager = android.adservices.customaudience.CustomAudienceManager.get(null);
        Intrinsics.checkNotNullExpressionValue(customAudienceManager, "get(context)");
        return new CustomAudienceManagerApi31Ext9Impl(customAudienceManager);
    }
}
