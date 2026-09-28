package androidx.privacysandbox.ads.adservices.appsetid;

import android.content.Context;
import in.juspay.hyper.constants.LogCategory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class AppSetIdManager$Companion$obtain$1 extends Lambda implements Function1<Context, AppSetIdManagerApi31Ext9Impl> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Context it = (Context) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(null, LogCategory.CONTEXT);
        android.adservices.appsetid.AppSetIdManager appSetIdManager = android.adservices.appsetid.AppSetIdManager.get(null);
        Intrinsics.checkNotNullExpressionValue(appSetIdManager, "get(context)");
        return new AppSetIdManagerApi31Ext9Impl(appSetIdManager);
    }
}
