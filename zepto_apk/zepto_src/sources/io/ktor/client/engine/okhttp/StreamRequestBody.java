package io.ktor.client.engine.okhttp;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class StreamRequestBody extends RequestBody {

    /* renamed from: a, reason: collision with root package name */
    public final Long f49438a;

    /* renamed from: b, reason: collision with root package name */
    public final Lambda f49439b;

    /* JADX WARN: Multi-variable type inference failed */
    public StreamRequestBody(Long l2, Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.f49438a = l2;
        this.f49439b = (Lambda) block;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        Long l2 = this.f49438a;
        if (l2 != null) {
            return l2.longValue();
        }
        return -1L;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return null;
    }

    @Override // okhttp3.RequestBody
    public final boolean isOneShot() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink sink) throws IOException {
        Long lValueOf;
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            Throwable th = null;
            Source sourceM = Okio.m(BlockingKt.a((ByteReadChannel) this.f49439b.invoke(), null));
            try {
                lValueOf = Long.valueOf(sink.g0(sourceM));
                try {
                    sourceM.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    sourceM.close();
                } catch (Throwable th4) {
                    ExceptionsKt.a(th3, th4);
                }
                th = th3;
                lValueOf = null;
            }
            if (th != null) {
                throw th;
            }
            Intrinsics.c(lValueOf);
        } catch (IOException e2) {
            throw e2;
        } catch (Throwable cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            throw new StreamAdapterIOException(cause);
        }
    }
}
