package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class ProhibitParking implements Parking<Thread> {

    /* renamed from: a, reason: collision with root package name */
    public static final ProhibitParking f51330a = new ProhibitParking();

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final void a(long j2) {
        throw new UnsupportedOperationException("Parking is prohibited on this thread. Most likely you are using blocking operation on the wrong thread/dispatcher that doesn't allow blocking. Consider wrapping you blocking code withContext(Dispatchers.IO) {...}.");
    }

    @Override // io.ktor.utils.io.jvm.javaio.Parking
    public final void b(Object obj) {
        Thread token = (Thread) obj;
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(token, "token");
        LockSupport.unpark(token);
    }
}
