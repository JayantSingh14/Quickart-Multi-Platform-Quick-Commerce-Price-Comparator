package io.ktor.client.plugins;

import io.ktor.client.plugins.UserAgent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class UserAgentKt$BrowserUserAgent$1 extends Lambda implements Function1<UserAgent.Config, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        UserAgent.Config install = (UserAgent.Config) obj;
        Intrinsics.checkNotNullParameter(install, "$this$install");
        install.getClass();
        Intrinsics.checkNotNullParameter("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/70.0.3538.77 Chrome/70.0.3538.77 Safari/537.36", "<set-?>");
        install.f49666a = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/70.0.3538.77 Chrome/70.0.3538.77 Safari/537.36";
        return Unit.f53572a;
    }
}
