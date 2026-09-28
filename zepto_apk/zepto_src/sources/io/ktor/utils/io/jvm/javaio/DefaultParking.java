package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class DefaultParking implements Parking<Thread> {

    /* renamed from: a, reason: collision with root package name */
    public static final DefaultParking f51311a = new DefaultParking();

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final void a(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        LockSupport.parkNanos(j2);
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final void b(Object obj) {
        Thread token = (Thread) obj;
        Intrinsics.checkNotNullParameter(token, "token");
        LockSupport.unpark(token);
    }
}
