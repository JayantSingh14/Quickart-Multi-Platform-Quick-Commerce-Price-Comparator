package io.ktor.utils.io.internal;

import android.support.v4.media.b;
import io.ktor.utils.io.LookAheadSuspendSession;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TerminatedLookAhead implements LookAheadSuspendSession {

    /* renamed from: b, reason: collision with root package name */
    public static final TerminatedLookAhead f51286b = new TerminatedLookAhead();

    @Override // io.ktor.utils.io.LookAheadSession
    public final void B(int i2) {
        if (i2 > 0) {
            throw new IllegalStateException(b.g(i2, "Unable to mark ", " bytes consumed for already terminated channel"));
        }
    }

    @Override // io.ktor.utils.io.LookAheadSuspendSession
    public final Object b(int i2, ContinuationImpl continuationImpl) {
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "atLeast parameter shouldn't be negative: ").toString());
        }
        if (i2 <= 4088) {
            return Boolean.FALSE;
        }
        throw new IllegalArgumentException(b.f(i2, "atLeast parameter shouldn't be larger than max buffer size of 4088: ").toString());
    }

    @Override // io.ktor.utils.io.LookAheadSession
    public final ByteBuffer c(int i2, int i3) {
        return null;
    }
}
