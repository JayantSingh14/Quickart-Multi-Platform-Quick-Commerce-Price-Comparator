package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public interface Authenticator {

    /* renamed from: a, reason: collision with root package name */
    public static final Authenticator f56143a = new Companion.AuthenticatorNone();

    /* renamed from: b, reason: collision with root package name */
    public static final okhttp3.internal.authenticator.JavaNetAuthenticator f56144b = new okhttp3.internal.authenticator.JavaNetAuthenticator(0);

    @Metadata
    public static final class Companion {

        @Metadata
        public static final class AuthenticatorNone implements Authenticator {
            @Override // okhttp3.Authenticator
            public final Request a(Route route, Response response) {
                Intrinsics.checkNotNullParameter(response, "response");
                return null;
            }
        }
    }

    Request a(Route route, Response response);
}
