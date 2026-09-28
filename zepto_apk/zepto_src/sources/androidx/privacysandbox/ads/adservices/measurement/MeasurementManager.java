package androidx.privacysandbox.ads.adservices.measurement;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import androidx.privacysandbox.ads.adservices.internal.BackCompatManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public abstract class MeasurementManager {

    @Metadata
    public static final class Companion {
        public static MeasurementManager a(final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Log.d("MeasurementManager", "AdServicesInfo.version=" + AdServicesInfo.a());
            if (AdServicesInfo.a() < 5) {
                if (AdServicesInfo.b() >= 9) {
                    return (MeasurementManager) BackCompatManager.a(context, "MeasurementManager", new Function1<Context, MeasurementManagerApi31Ext9Impl>() { // from class: androidx.privacysandbox.ads.adservices.measurement.MeasurementManager$Companion$obtain$1
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
                            android.adservices.measurement.MeasurementManager measurementManager = android.adservices.measurement.MeasurementManager.get(context2);
                            Intrinsics.checkNotNullExpressionValue(measurementManager, "get(context)");
                            return new MeasurementManagerApi31Ext9Impl(measurementManager);
                        }
                    });
                }
                return null;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService((Class<Object>) c.b());
            Intrinsics.checkNotNullExpressionValue(systemService, "context.getSystemService…ementManager::class.java)");
            return new MeasurementManagerApi33Ext5Impl(c.a(systemService));
        }
    }

    public abstract Object a(DeletionRequest deletionRequest, Continuation continuation);

    public abstract Object b(Continuation continuation);

    public abstract Object c(Uri uri, InputEvent inputEvent, Continuation continuation);

    public abstract Object d(SourceRegistrationRequest sourceRegistrationRequest, Continuation continuation);

    public abstract Object e(Uri uri, Continuation continuation);

    public abstract Object f(WebSourceRegistrationRequest webSourceRegistrationRequest, Continuation continuation);

    public abstract Object g(WebTriggerRegistrationRequest webTriggerRegistrationRequest, Continuation continuation);
}
