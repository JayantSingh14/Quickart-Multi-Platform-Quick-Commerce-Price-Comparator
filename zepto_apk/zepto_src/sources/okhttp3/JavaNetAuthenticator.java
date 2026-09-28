package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class JavaNetAuthenticator implements Authenticator {
    @Override // okhttp3.Authenticator
    public final Request a(Route route, Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return Authenticator.f56144b.a(route, response);
    }
}
