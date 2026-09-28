package io.ktor.utils.io;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ByteBufferChannelKt {
    public static final void a(Throwable th) throws Throwable {
        Throwable thB;
        try {
            thB = ExceptionUtilsJvmKt.b(th, th);
        } catch (Throwable unused) {
            thB = null;
        }
        if (thB != null) {
            throw thB;
        }
    }
}
