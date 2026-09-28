package ch.qos.logback.core.rolling.helper;

import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.File;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class TimeBasedArchiveRemover extends ContextAwareBase implements ArchiveRemover {

    /* renamed from: ch.qos.logback.core.rolling.helper.TimeBasedArchiveRemover$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        public final int compare(File file, File file2) {
            long jLastModified = file.lastModified();
            long jLastModified2 = file2.lastModified();
            if (jLastModified == jLastModified2) {
                return 0;
            }
            return jLastModified2 < jLastModified ? -1 : 1;
        }
    }

    public class ArhiveRemoverRunnable implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public final String toString() {
        return "c.q.l.core.rolling.helper.TimeBasedArchiveRemover";
    }
}
