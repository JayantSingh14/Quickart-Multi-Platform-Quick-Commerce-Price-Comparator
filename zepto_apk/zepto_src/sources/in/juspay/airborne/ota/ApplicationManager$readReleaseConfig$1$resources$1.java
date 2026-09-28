package in.juspay.airborne.ota;

import in.juspay.airborne.ota.ReleaseConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes4.dex */
public /* synthetic */ class ApplicationManager$readReleaseConfig$1$resources$1 extends FunctionReferenceImpl implements Function1<String, Result<? extends ReleaseConfig.ResourceManifest>> {
    public ApplicationManager$readReleaseConfig$1$resources$1(Object obj) {
        super(1, obj, ReleaseConfig.Companion.class, "deSerializeResources", "deSerializeResources-IoAF18A(Ljava/lang/String;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Object obj) {
        return new Result(m60invokeIoAF18A((String) obj));
    }

    @NotNull
    /* renamed from: invoke-IoAF18A, reason: not valid java name */
    public final Object m60invokeIoAF18A(@NotNull String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((ReleaseConfig.Companion) this.receiver).m64deSerializeResourcesIoAF18A(p0);
    }
}
