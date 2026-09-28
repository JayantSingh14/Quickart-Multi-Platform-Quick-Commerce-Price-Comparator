package okhttp3.internal.concurrent;

import android.support.v4.media.b;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class TaskLoggerKt {
    public static final void a(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.f56474i;
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.f56466b);
        sb.append(' ');
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(task.f56461a);
        logger.fine(sb.toString());
    }

    public static final String b(long j2) {
        String str = String.format("%6s", Arrays.copyOf(new Object[]{j2 <= -999500000 ? b.p(new StringBuilder(), (j2 - 500000000) / 1000000000, " s ") : j2 <= -999500 ? b.p(new StringBuilder(), (j2 - 500000) / 1000000, " ms") : j2 <= 0 ? b.p(new StringBuilder(), (j2 - 500) / 1000, " µs") : j2 < 999500 ? b.p(new StringBuilder(), (j2 + 500) / 1000, " µs") : j2 < 999500000 ? b.p(new StringBuilder(), (j2 + 500000) / 1000000, " ms") : b.p(new StringBuilder(), (j2 + 500000000) / 1000000000, " s ")}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }
}
