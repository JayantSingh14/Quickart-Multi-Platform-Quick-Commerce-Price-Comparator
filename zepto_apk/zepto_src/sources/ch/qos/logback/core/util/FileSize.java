package ch.qos.logback.core.util;

import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class FileSize {

    /* renamed from: a, reason: collision with root package name */
    public final long f13808a;

    static {
        Pattern.compile("([0-9]+)\\s*(|kb|mb|gb)s?", 2);
    }

    public FileSize(long j2) {
        this.f13808a = j2;
    }

    public final String toString() {
        long j2 = this.f13808a;
        long j3 = j2 / 1024;
        if (j3 == 0) {
            return j2 + " Bytes";
        }
        long j4 = j2 / 1048576;
        if (j4 == 0) {
            return j3 + " KB";
        }
        long j5 = j2 / 1073741824;
        if (j5 == 0) {
            return j4 + " MB";
        }
        return j5 + " GB";
    }
}
