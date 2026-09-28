package androidx.privacysandbox.ads.adservices.topics;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public abstract class TopicsManager {

    @Metadata
    public static final class Companion {
        public static TopicsManager a(final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AdServicesInfo.a() >= 11) {
                Intrinsics.checkNotNullParameter(context, "context");
                Object systemService = context.getSystemService((Class<Object>) androidx.privacysandbox.ads.adservices.customaudience.a.p());
                Intrinsics.checkNotNullExpressionValue(systemService, "context.getSystemService…opicsManager::class.java)");
                return new TopicsManagerApi33Ext11Impl(androidx.privacysandbox.ads.adservices.customaudience.a.o(systemService));
            }
            if (AdServicesInfo.a() >= 5) {
                Intrinsics.checkNotNullParameter(context, "context");
                Object systemService2 = context.getSystemService((Class<Object>) androidx.privacysandbox.ads.adservices.customaudience.a.p());
                Intrinsics.checkNotNullExpressionValue(systemService2, "context.getSystemService…opicsManager::class.java)");
                return new TopicsManagerApi33Ext5Impl(androidx.privacysandbox.ads.adservices.customaudience.a.o(systemService2));
            }
            if (AdServicesInfo.a() == 4) {
                Intrinsics.checkNotNullParameter(context, "context");
                Object systemService3 = context.getSystemService((Class<Object>) androidx.privacysandbox.ads.adservices.customaudience.a.p());
                Intrinsics.checkNotNullExpressionValue(systemService3, "context.getSystemService…opicsManager::class.java)");
                return new TopicsManagerApi33Ext4Impl(androidx.privacysandbox.ads.adservices.customaudience.a.o(systemService3));
            }
            if (AdServicesInfo.b() >= 11) {
                return (TopicsManager) BackCompatManager.a(context, "TopicsManager", new Function1<Context, TopicsManagerApi31Ext11Impl>() { // from class: androidx.privacysandbox.ads.adservices.topics.TopicsManager$Companion$obtain$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Context it = (Context) obj;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Context context2 = context;
                        Intrinsics.checkNotNullParameter(context2, "context");
                        android.adservices.topics.TopicsManager topicsManager = android.adservices.topics.TopicsManager.get(context2);
                        Intrinsics.checkNotNullExpressionValue(topicsManager, "get(context)");
                        return new TopicsManagerApi31Ext11Impl(topicsManager);
                    }
                });
            }
            if (AdServicesInfo.b() >= 9) {
                return (TopicsManager) BackCompatManager.a(context, "TopicsManager", new Function1<Context, TopicsManagerApi31Ext9Impl>() { // from class: androidx.privacysandbox.ads.adservices.topics.TopicsManager$Companion$obtain$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Context it = (Context) obj;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Context context2 = context;
                        Intrinsics.checkNotNullParameter(context2, "context");
                        android.adservices.topics.TopicsManager topicsManager = android.adservices.topics.TopicsManager.get(context2);
                        Intrinsics.checkNotNullExpressionValue(topicsManager, "get(context)");
                        return new TopicsManagerApi31Ext9Impl(topicsManager);
                    }
                });
            }
            return null;
        }
    }

    public abstract Object a(GetTopicsRequest getTopicsRequest, Continuation continuation);
}
