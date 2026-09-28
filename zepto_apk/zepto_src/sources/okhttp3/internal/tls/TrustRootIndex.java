package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface TrustRootIndex {
    X509Certificate a(X509Certificate x509Certificate);
}
