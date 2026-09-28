package androidx.tracing;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes.dex */
final class TraceApi29Impl {
    public static void a(int i2, String str) {
        android.os.Trace.beginAsyncSection(str, i2);
    }

    public static void b(int i2, String str) {
        android.os.Trace.endAsyncSection(str, i2);
    }

    @DoNotInline
    public static boolean c() {
        return android.os.Trace.isEnabled();
    }

    public static void d(int i2, String str) {
        android.os.Trace.setCounter(str, i2);
    }
}
