package io.ktor.client.plugins.observer;

import io.ktor.client.plugins.observer.ResponseObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ResponseObserverKt$ResponseObserver$1 extends Lambda implements Function1<ResponseObserver.Config, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ResponseObserver.Config install = (ResponseObserver.Config) obj;
        Intrinsics.checkNotNullParameter(install, "$this$install");
        install.getClass();
        Intrinsics.checkNotNullParameter(null, "<set-?>");
        install.f49953a = null;
        return Unit.f53572a;
    }
}
