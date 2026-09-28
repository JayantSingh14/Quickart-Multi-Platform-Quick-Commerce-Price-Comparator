package net.jpountz.util;

import android.support.v4.media.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.lang3.ClassUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public enum Native {
    ;

    private static boolean loaded = false;

    /* loaded from: classes3.dex */
    public enum OS {
        WINDOWS("win32", "so"),
        LINUX("linux", "so"),
        MAC("darwin", "dylib"),
        SOLARIS("solaris", "so");

        public final String libExtension;
        public final String name;

        OS(String str, String str2) {
            this.name = str;
            this.libExtension = str2;
        }
    }

    private static String arch() {
        return System.getProperty("os.arch");
    }

    private static void cleanupOldTempLibs() {
        File[] fileArrListFiles = new File(new File(System.getProperty("java.io.tmpdir")).getAbsolutePath()).listFiles(new FilenameFilter() { // from class: net.jpountz.util.Native.1
            private final String searchPattern = "liblz4-java-";

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("liblz4-java-") && !str.endsWith(".lck");
            }
        });
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (!new File(file.getAbsolutePath() + ".lck").exists()) {
                    try {
                        file.delete();
                    } catch (SecurityException e2) {
                        System.err.println("Failed to delete old temp lib" + e2.getMessage());
                    }
                }
            }
        }
    }

    public static synchronized boolean isLoaded() {
        return loaded;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v6 */
    public static synchronized void load() {
        Throwable th;
        IOException e2;
        File fileCreateTempFile = CLConstants.DOT_SALT_DELIMETER;
        synchronized (Native.class) {
            if (loaded) {
                return;
            }
            cleanupOldTempLibs();
            try {
                System.loadLibrary("lz4-java");
                loaded = true;
            } catch (UnsatisfiedLinkError unused) {
                File fileResourceName = resourceName();
                InputStream resourceAsStream = Native.class.getResourceAsStream(fileResourceName);
                if (resourceAsStream == null) {
                    throw new UnsupportedOperationException("Unsupported OS/arch, cannot find " + ((String) fileResourceName) + ". Please try building from source.");
                }
                try {
                    try {
                        fileCreateTempFile = File.createTempFile("liblz4-java-", CLConstants.DOT_SALT_DELIMETER + os().libExtension + ".lck");
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        File file = new File(fileCreateTempFile.getAbsolutePath().replaceFirst(".lck$", ""));
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i2 = resourceAsStream.read(bArr);
                                    if (i2 == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, i2);
                                    }
                                }
                                fileOutputStream.close();
                                System.load(file.getAbsolutePath());
                                loaded = true;
                                String str = System.getenv("LZ4JAVA_KEEP_TEMP_JNI_LIB");
                                String property = System.getProperty("lz4java.jnilib.temp.keep");
                                if ((str == null || !str.equals("true")) && (property == null || !property.equals("true"))) {
                                    file.deleteOnExit();
                                }
                                fileCreateTempFile.deleteOnExit();
                            } finally {
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            throw new ExceptionInInitializerError("Cannot unpack liblz4-java: " + e2);
                        }
                    } catch (IOException e4) {
                        e2 = e4;
                    } catch (Throwable th3) {
                        fileResourceName = 0;
                        th = th3;
                        if (loaded) {
                            String str2 = System.getenv("LZ4JAVA_KEEP_TEMP_JNI_LIB");
                            String property2 = System.getProperty("lz4java.jnilib.temp.keep");
                            if ((str2 == null || !str2.equals("true")) && (property2 == null || !property2.equals("true"))) {
                                fileResourceName.deleteOnExit();
                            }
                            fileCreateTempFile.deleteOnExit();
                        } else {
                            if (fileResourceName != 0 && fileResourceName.exists() && !fileResourceName.delete()) {
                                throw new ExceptionInInitializerError("Cannot unpack liblz4-java / cannot delete a temporary native library " + fileResourceName);
                            }
                            if (fileCreateTempFile != 0 && fileCreateTempFile.exists() && !fileCreateTempFile.delete()) {
                                throw new ExceptionInInitializerError("Cannot unpack liblz4-java / cannot delete a temporary lock file " + fileCreateTempFile);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e2 = e5;
                } catch (Throwable th4) {
                    fileResourceName = 0;
                    th = th4;
                    fileCreateTempFile = 0;
                }
            }
        }
    }

    private static OS os() {
        String property = System.getProperty("os.name");
        if (property.contains("Linux")) {
            return OS.LINUX;
        }
        if (property.contains("Mac")) {
            return OS.MAC;
        }
        if (property.contains("Windows")) {
            return OS.WINDOWS;
        }
        if (property.contains("Solaris") || property.contains("SunOS")) {
            return OS.SOLARIS;
        }
        throw new UnsupportedOperationException("Unsupported operating system: ".concat(property));
    }

    private static String resourceName() {
        OS os = os();
        StringBuilder sbY = b.y("/", Native.class.getPackage().getName().replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/'), "/");
        sbY.append(os.name);
        sbY.append("/");
        sbY.append(arch());
        sbY.append("/liblz4-java.");
        sbY.append(os.libExtension);
        return sbY.toString();
    }
}
