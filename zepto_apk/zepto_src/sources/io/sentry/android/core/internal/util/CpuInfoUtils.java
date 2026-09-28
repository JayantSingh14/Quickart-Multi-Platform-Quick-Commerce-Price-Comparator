package io.sentry.android.core.internal.util;

import io.sentry.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class CpuInfoUtils {

    /* renamed from: b, reason: collision with root package name */
    public static final CpuInfoUtils f52309b = new CpuInfoUtils();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f52310a = new ArrayList();

    public final synchronized ArrayList a() {
        if (!this.f52310a.isEmpty()) {
            return this.f52310a;
        }
        File[] fileArrListFiles = new File("/sys/devices/system/cpu").listFiles();
        if (fileArrListFiles == null) {
            return new ArrayList();
        }
        for (File file : fileArrListFiles) {
            if (file.getName().matches("cpu[0-9]+")) {
                File file2 = new File(file, "cpufreq/cpuinfo_max_freq");
                if (file2.exists() && file2.canRead()) {
                    try {
                        String strC = FileUtils.c(file2);
                        if (strC != null) {
                            this.f52310a.add(Integer.valueOf((int) (Long.parseLong(strC.trim()) / 1000)));
                        }
                    } catch (IOException | NumberFormatException unused) {
                    }
                }
            }
        }
        return this.f52310a;
    }
}
