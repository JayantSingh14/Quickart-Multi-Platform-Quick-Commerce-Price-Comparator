package coil3.util;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import coil3.util.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class FileDescriptorCounter {
    private static final int FILE_DESCRIPTOR_CHECK_INTERVAL_DECODES = 30;
    private static final int FILE_DESCRIPTOR_CHECK_INTERVAL_MILLIS = 30000;
    private static final int FILE_DESCRIPTOR_LIMIT = 800;

    @NotNull
    private static final String TAG = "FileDescriptorCounter";

    @NotNull
    public static final FileDescriptorCounter INSTANCE = new FileDescriptorCounter();

    @NotNull
    private static final File fileDescriptorList = new File("/proc/self/fd");
    private static int decodesSinceLastFileDescriptorCheck = 30;
    private static long lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();
    private static boolean hasAvailableFileDescriptors = true;

    private FileDescriptorCounter() {
    }

    private final boolean checkFileDescriptors() {
        int i2 = decodesSinceLastFileDescriptorCheck;
        decodesSinceLastFileDescriptorCheck = i2 + 1;
        return i2 >= 30 || SystemClock.uptimeMillis() > lastFileDescriptorCheckTimestamp + ((long) FILE_DESCRIPTOR_CHECK_INTERVAL_MILLIS);
    }

    @WorkerThread
    public final synchronized boolean hasAvailableFileDescriptors(@Nullable Logger logger) {
        try {
            if (checkFileDescriptors()) {
                decodesSinceLastFileDescriptorCheck = 0;
                lastFileDescriptorCheckTimestamp = SystemClock.uptimeMillis();
                String[] list = fileDescriptorList.list();
                if (list == null) {
                    list = new String[0];
                }
                int length = list.length;
                boolean z = length < FILE_DESCRIPTOR_LIMIT;
                hasAvailableFileDescriptors = z;
                if (!z && logger != null) {
                    Logger.Level level = Logger.Level.Warn;
                    if (logger.getMinLevel().compareTo(level) <= 0) {
                        logger.log(TAG, level, "Unable to allocate more hardware bitmaps. Number of used file descriptors: " + length, null);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return hasAvailableFileDescriptors;
    }
}
