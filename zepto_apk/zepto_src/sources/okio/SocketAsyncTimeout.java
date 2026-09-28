package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
final class SocketAsyncTimeout extends AsyncTimeout {

    /* renamed from: m, reason: collision with root package name */
    public final Socket f57000m;

    public SocketAsyncTimeout(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.f57000m = socket;
    }

    @Override // okio.AsyncTimeout
    public final IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    public final void l() throws IOException {
        Socket socket = this.f57000m;
        try {
            socket.close();
        } catch (AssertionError e2) {
            if (!Okio.e(e2)) {
                throw e2;
            }
            Okio__JvmOkioKt.f56966a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
        } catch (Exception e3) {
            Okio__JvmOkioKt.f56966a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e3);
        }
    }
}
