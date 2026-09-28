package g;

import coil3.network.internal.UtilsKt;
import g.r;
import java.net.ProtocolException;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes4.dex */
public abstract class d<T extends r> extends e<T> {
    @Override // g.e, com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final void h(HttpsURLConnection httpsURLConnection) throws ProtocolException {
        httpsURLConnection.setRequestMethod(UtilsKt.HTTP_METHOD_GET);
    }

    @Override // g.e, com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final void j(HttpsURLConnection httpsURLConnection) {
    }
}
