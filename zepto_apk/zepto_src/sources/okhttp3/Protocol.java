package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: a, reason: collision with root package name */
    public final String f56330a;

    @Metadata
    public static final class Companion {
        public static Protocol a(String protocol) throws IOException {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            if (protocol.equals("http/1.0")) {
                return Protocol.HTTP_1_0;
            }
            if (protocol.equals("http/1.1")) {
                return Protocol.HTTP_1_1;
            }
            if (protocol.equals("h2_prior_knowledge")) {
                return Protocol.H2_PRIOR_KNOWLEDGE;
            }
            if (protocol.equals("h2")) {
                return Protocol.HTTP_2;
            }
            if (protocol.equals("spdy/3.1")) {
                return Protocol.SPDY_3;
            }
            if (protocol.equals("quic")) {
                return Protocol.QUIC;
            }
            throw new IOException("Unexpected protocol: ".concat(protocol));
        }
    }

    Protocol(String str) {
        this.f56330a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f56330a;
    }
}
