package androidx.privacysandbox.ads.adservices.adselection;

import android.content.Context;
import in.juspay.hyper.constants.LogCategory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class AdSelectionManager$Companion$obtain$1 extends Lambda implements Function1<Context, AdSelectionManagerApi31Ext9Impl> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Context it = (Context) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(null, LogCategory.CONTEXT);
        android.adservices.adselection.AdSelectionManager adSelectionManager = android.adservices.adselection.AdSelectionManager.get(null);
        Intrinsics.checkNotNullExpressionValue(adSelectionManager, "get(context)");
        return new AdSelectionManagerApi31Ext9Impl(adSelectionManager);
    }
}
