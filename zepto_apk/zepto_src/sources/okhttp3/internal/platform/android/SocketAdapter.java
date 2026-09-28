package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface SocketAdapter {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    boolean a();

    boolean b(SSLSocket sSLSocket);

    String c(SSLSocket sSLSocket);

    void d(SSLSocket sSLSocket, String str, List list);
}
