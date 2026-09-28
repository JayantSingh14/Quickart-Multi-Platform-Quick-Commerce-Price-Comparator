package ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class FileFilterUtil {

    /* renamed from: ch.qos.logback.core.rolling.helper.FileFilterUtil$1, reason: invalid class name */
    final class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        public final int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* renamed from: ch.qos.logback.core.rolling.helper.FileFilterUtil$2, reason: invalid class name */
    final class AnonymousClass2 implements Comparator<File> {
        @Override // java.util.Comparator
        public final int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* renamed from: ch.qos.logback.core.rolling.helper.FileFilterUtil$3, reason: invalid class name */
    final class AnonymousClass3 implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.matches(null);
        }
    }
}
