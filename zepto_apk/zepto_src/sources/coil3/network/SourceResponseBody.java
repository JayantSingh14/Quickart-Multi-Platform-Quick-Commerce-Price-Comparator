package coil3.network;

import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.RealBufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@JvmInline
@SourceDebugExtension
/* loaded from: classes.dex */
final class SourceResponseBody implements NetworkResponseBody {

    @NotNull
    private final BufferedSource source;

    private /* synthetic */ SourceResponseBody(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SourceResponseBody m10boximpl(BufferedSource bufferedSource) {
        return new SourceResponseBody(bufferedSource);
    }

    /* renamed from: close-impl, reason: not valid java name */
    public static void m11closeimpl(BufferedSource bufferedSource) throws IOException {
        bufferedSource.close();
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static BufferedSource m12constructorimpl(@NotNull BufferedSource bufferedSource) {
        return bufferedSource;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m13equalsimpl(BufferedSource bufferedSource, Object obj) {
        return (obj instanceof SourceResponseBody) && Intrinsics.b(bufferedSource, ((SourceResponseBody) obj).m19unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m14equalsimpl0(BufferedSource bufferedSource, BufferedSource bufferedSource2) {
        return Intrinsics.b(bufferedSource, bufferedSource2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m15hashCodeimpl(BufferedSource bufferedSource) {
        return bufferedSource.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m16toStringimpl(BufferedSource bufferedSource) {
        return "SourceResponseBody(source=" + bufferedSource + ')';
    }

    @Nullable
    /* renamed from: writeTo-impl, reason: not valid java name */
    public static Object m17writeToimpl(BufferedSource bufferedSource, @NotNull BufferedSink bufferedSink, @NotNull Continuation<? super Unit> continuation) {
        bufferedSource.F1(bufferedSink);
        return Unit.f53572a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws IOException {
        m11closeimpl(this.source);
    }

    public boolean equals(Object obj) {
        return m13equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m15hashCodeimpl(this.source);
    }

    public String toString() {
        return m16toStringimpl(this.source);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ BufferedSource m19unboximpl() {
        return this.source;
    }

    @Override // coil3.network.NetworkResponseBody
    @Nullable
    public Object writeTo(@NotNull BufferedSink bufferedSink, @NotNull Continuation<? super Unit> continuation) {
        return m17writeToimpl(this.source, bufferedSink, continuation);
    }

    @Override // coil3.network.NetworkResponseBody
    @Nullable
    public Object writeTo(@NotNull FileSystem fileSystem, @NotNull Path path, @NotNull Continuation<? super Unit> continuation) {
        return m18writeToimpl(this.source, fileSystem, path, continuation);
    }

    @Nullable
    /* renamed from: writeTo-impl, reason: not valid java name */
    public static Object m18writeToimpl(BufferedSource bufferedSource, @NotNull FileSystem fileSystem, @NotNull Path path, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        RealBufferedSink realBufferedSinkC = Okio.c(fileSystem.sink(path, false));
        try {
            new Long(bufferedSource.F1(realBufferedSinkC));
            try {
                realBufferedSinkC.close();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                realBufferedSinkC.close();
            } catch (Throwable th3) {
                ExceptionsKt.a(th, th3);
            }
        }
        if (th == null) {
            return Unit.f53572a;
        }
        throw th;
    }
}
