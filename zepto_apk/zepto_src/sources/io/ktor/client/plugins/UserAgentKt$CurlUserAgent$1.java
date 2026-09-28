package io.ktor.client.plugins;

import io.ktor.client.plugins.UserAgent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class UserAgentKt$CurlUserAgent$1 extends Lambda implements Function1<UserAgent.Config, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        UserAgent.Config install = (UserAgent.Config) obj;
        Intrinsics.checkNotNullParameter(install, "$this$install");
        install.getClass();
        Intrinsics.checkNotNullParameter("curl/7.61.0", "<set-?>");
        install.f49666a = "curl/7.61.0";
        return Unit.f53572a;
    }
}
