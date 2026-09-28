package bolts;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class AggregateException extends Exception {
    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        throw null;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        throw null;
    }
}
