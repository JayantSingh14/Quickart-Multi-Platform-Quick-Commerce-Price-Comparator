package okhttp3.internal.connection;

import android.support.v4.media.b;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Address;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealConnectionPool {

    /* renamed from: a, reason: collision with root package name */
    public final long f56553a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskQueue f56554b;

    /* renamed from: c, reason: collision with root package name */
    public final RealConnectionPool$cleanupTask$1 f56555c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentLinkedQueue f56556d;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.f56553a = timeUnit.toNanos(5L);
        this.f56554b = taskRunner.e();
        final String strR = b.r(new StringBuilder(), Util.f56400g, " ConnectionPool");
        this.f56555c = new Task(strR) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public final long a() {
                RealConnectionPool realConnectionPool = this.f56557e;
                long jNanoTime = System.nanoTime();
                Iterator it = realConnectionPool.f56556d.iterator();
                int i2 = 0;
                long j2 = Long.MIN_VALUE;
                RealConnection realConnection = null;
                int i3 = 0;
                while (it.hasNext()) {
                    RealConnection connection = (RealConnection) it.next();
                    Intrinsics.checkNotNullExpressionValue(connection, "connection");
                    synchronized (connection) {
                        if (realConnectionPool.b(connection, jNanoTime) > 0) {
                            i3++;
                        } else {
                            i2++;
                            long j3 = jNanoTime - connection.q;
                            if (j3 > j2) {
                                realConnection = connection;
                                j2 = j3;
                            }
                            Unit unit = Unit.f53572a;
                        }
                    }
                }
                long j4 = realConnectionPool.f56553a;
                if (j2 < j4 && i2 <= 5) {
                    if (i2 > 0) {
                        return j4 - j2;
                    }
                    if (i3 > 0) {
                        return j4;
                    }
                    return -1L;
                }
                Intrinsics.c(realConnection);
                synchronized (realConnection) {
                    if (!realConnection.p.isEmpty()) {
                        return 0L;
                    }
                    if (realConnection.q + j2 != jNanoTime) {
                        return 0L;
                    }
                    realConnection.f56543j = true;
                    realConnectionPool.f56556d.remove(realConnection);
                    Socket socket = realConnection.f56537d;
                    Intrinsics.c(socket);
                    Util.d(socket);
                    if (realConnectionPool.f56556d.isEmpty()) {
                        realConnectionPool.f56554b.a();
                    }
                    return 0L;
                }
            }
        };
        this.f56556d = new ConcurrentLinkedQueue();
    }

    public final boolean a(Address address, RealCall call, ArrayList arrayList, boolean z) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Iterator it = this.f56556d.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            RealConnection connection = (RealConnection) it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (z) {
                    if (connection.f56540g != null) {
                    }
                    Unit unit = Unit.f53572a;
                }
                if (connection.h(address, arrayList)) {
                    call.b(connection);
                    return true;
                }
                Unit unit2 = Unit.f53572a;
            }
        }
    }

    public final int b(RealConnection realConnection, long j2) {
        byte[] bArr = Util.f56394a;
        ArrayList arrayList = realConnection.p;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                String str = "A connection to " + realConnection.f56535b.f56384a.f56140i + " was leaked. Did you forget to close a response body?";
                Platform platform = Platform.f56791a;
                Platform.f56791a.k(((RealCall.CallReference) reference).f56533a, str);
                arrayList.remove(i2);
                realConnection.f56543j = true;
                if (arrayList.isEmpty()) {
                    realConnection.q = j2 - this.f56553a;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
