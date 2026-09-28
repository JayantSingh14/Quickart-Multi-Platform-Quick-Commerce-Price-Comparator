package androidx.privacysandbox.ads.adservices.adid;

import android.content.Context;
import in.juspay.hyper.constants.LogCategory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class AdIdManager$Companion$obtain$1 extends Lambda implements Function1<Context, AdIdManagerApi31Ext9Impl> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Context it = (Context) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(null, LogCategory.CONTEXT);
        android.adservices.adid.AdIdManager adIdManager = android.adservices.adid.AdIdManager.get(null);
        Intrinsics.checkNotNullExpressionValue(adIdManager, "get(context)");
        return new AdIdManagerApi31Ext9Impl(adIdManager);
    }
}
