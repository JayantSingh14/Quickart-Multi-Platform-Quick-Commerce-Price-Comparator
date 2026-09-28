package okhttp3;

import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;

@Metadata
/* loaded from: classes.dex */
public final class ConnectionPool {

    /* renamed from: a, reason: collision with root package name */
    public final RealConnectionPool f56210a;

    public ConnectionPool() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        RealConnectionPool delegate = new RealConnectionPool(TaskRunner.f56473h);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f56210a = delegate;
    }

    public final void a() {
        Socket socket;
        RealConnectionPool realConnectionPool = this.f56210a;
        Iterator it = realConnectionPool.f56556d.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection connection = (RealConnection) it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (connection.p.isEmpty()) {
                    it.remove();
                    connection.f56543j = true;
                    socket = connection.f56537d;
                    Intrinsics.c(socket);
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                Util.d(socket);
            }
        }
        if (realConnectionPool.f56556d.isEmpty()) {
            realConnectionPool.f56554b.a();
        }
    }
}
