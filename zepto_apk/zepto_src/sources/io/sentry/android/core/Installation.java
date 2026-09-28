package io.sentry.android.core;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.UUID;

/* loaded from: classes.dex */
final class Installation {

    /* renamed from: a, reason: collision with root package name */
    public static String f52142a;

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f52143b = Charset.forName("UTF-8");

    public static synchronized String a(Context context) {
        try {
            if (f52142a == null) {
                File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            String string = UUID.randomUUID().toString();
                            fileOutputStream.write(string.getBytes(f52143b));
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            f52142a = string;
                            return string;
                        } finally {
                        }
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        byte[] bArr = new byte[(int) randomAccessFile.length()];
                        randomAccessFile.readFully(bArr);
                        String str = new String(bArr, f52143b);
                        randomAccessFile.close();
                        f52142a = str;
                    } finally {
                    }
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
            return f52142a;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
