package kotlin.io;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata
@JvmName
/* loaded from: classes.dex */
public final class CloseableKt {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                kotlin.ExceptionsKt.a(th, th2);
            }
        }
    }
}
