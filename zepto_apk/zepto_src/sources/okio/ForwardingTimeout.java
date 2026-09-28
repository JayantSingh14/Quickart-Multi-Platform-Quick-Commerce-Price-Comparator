package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class ForwardingTimeout extends Timeout {

    /* renamed from: e, reason: collision with root package name */
    public Timeout f56951e;

    public ForwardingTimeout(Timeout delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f56951e = delegate;
    }

    @Override // okio.Timeout
    public final Timeout a() {
        return this.f56951e.a();
    }

    @Override // okio.Timeout
    public final Timeout b() {
        return this.f56951e.b();
    }

    @Override // okio.Timeout
    public final long c() {
        return this.f56951e.c();
    }

    @Override // okio.Timeout
    public final Timeout d(long j2) {
        return this.f56951e.d(j2);
    }

    @Override // okio.Timeout
    public final boolean e() {
        return this.f56951e.e();
    }

    @Override // okio.Timeout
    public final void f() throws InterruptedIOException {
        this.f56951e.f();
    }

    @Override // okio.Timeout
    public final Timeout g(long j2, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.f56951e.g(j2, unit);
    }

    @Override // okio.Timeout
    public final long h() {
        return this.f56951e.h();
    }
}
