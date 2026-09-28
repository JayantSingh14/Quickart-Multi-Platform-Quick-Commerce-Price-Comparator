package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

@Metadata
/* loaded from: classes3.dex */
public class FaultHidingSink extends ForwardingSink {

    /* renamed from: b, reason: collision with root package name */
    public final Lambda f56459b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f56460c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(Sink delegate, Function1 onException) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(onException, "onException");
        this.f56459b = (Lambda) onException;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f56460c) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.f56460c = true;
            this.f56459b.invoke(e2);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public final void flush() {
        if (this.f56460c) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.f56460c = true;
            this.f56459b.invoke(e2);
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // okio.ForwardingSink, okio.Sink
    public final void write(Buffer source, long j2) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f56460c) {
            source.j1(j2);
            return;
        }
        try {
            super.write(source, j2);
        } catch (IOException e2) {
            this.f56460c = true;
            this.f56459b.invoke(e2);
        }
    }
}
