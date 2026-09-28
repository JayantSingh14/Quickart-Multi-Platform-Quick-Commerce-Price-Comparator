package coil3.disk;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class FaultHidingSink implements Sink {

    @NotNull
    private final Sink delegate;
    private boolean hasErrors;

    @NotNull
    private final Function1<IOException, Unit> onException;

    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(@NotNull Sink sink, @NotNull Function1<? super IOException, Unit> function1) {
        this.delegate = sink;
        this.onException = function1;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.delegate.close();
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        try {
            this.delegate.flush();
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer buffer, long j2) {
        if (this.hasErrors) {
            buffer.j1(j2);
            return;
        }
        try {
            this.delegate.write(buffer, j2);
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }
}
