package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Debug;
import com.google.firebase.crashlytics.internal.Logger;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes.dex */
public class CommonUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f43741a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Architecture {

        /* renamed from: a, reason: collision with root package name */
        public static final Architecture f43742a;

        /* renamed from: b, reason: collision with root package name */
        public static final HashMap f43743b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Architecture[] f43744c;

        /* JADX INFO: Fake field, exist only in values array */
        Architecture EF0;

        static {
            Architecture architecture = new Architecture("X86_32", 0);
            Architecture architecture2 = new Architecture("X86_64", 1);
            Architecture architecture3 = new Architecture("ARM_UNKNOWN", 2);
            Architecture architecture4 = new Architecture("PPC", 3);
            Architecture architecture5 = new Architecture("PPC64", 4);
            Architecture architecture6 = new Architecture("ARMV6", 5);
            Architecture architecture7 = new Architecture("ARMV7", 6);
            Architecture architecture8 = new Architecture("UNKNOWN", 7);
            f43742a = architecture8;
            Architecture architecture9 = new Architecture("ARMV7S", 8);
            Architecture architecture10 = new Architecture("ARM64", 9);
            f43744c = new Architecture[]{architecture, architecture2, architecture3, architecture4, architecture5, architecture6, architecture7, architecture8, architecture9, architecture10};
            HashMap map = new HashMap(4);
            f43743b = map;
            map.put("armeabi-v7a", architecture7);
            map.put("armeabi", architecture6);
            map.put("arm64-v8a", architecture10);
            map.put("x86", architecture);
        }

        public static Architecture valueOf(String str) {
            return (Architecture) Enum.valueOf(Architecture.class, str);
        }

        public static Architecture[] values() {
            return (Architecture[]) f43744c.clone();
        }
    }

    public static synchronized long a(Context context) {
        ActivityManager.MemoryInfo memoryInfo;
        memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static void b(Closeable closeable, String str) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                Logger.f43705a.c(str, e2);
            }
        }
    }

    public static void c(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static int d() {
        boolean zG = g();
        ?? r0 = zG;
        if (h()) {
            r0 = (zG ? 1 : 0) | 2;
        }
        return (Debug.isDebuggerConnected() || Debug.waitingForDebugger()) ? r0 | 4 : r0;
    }

    public static int e(Context context, String str, String str2) throws Resources.NotFoundException {
        String packageName;
        Resources resources = context.getResources();
        int i2 = context.getApplicationContext().getApplicationInfo().icon;
        if (i2 > 0) {
            try {
                packageName = context.getResources().getResourcePackageName(i2);
                if (LogSubCategory.LifeCycle.ANDROID.equals(packageName)) {
                    packageName = context.getPackageName();
                }
            } catch (Resources.NotFoundException unused) {
                packageName = context.getPackageName();
            }
        } else {
            packageName = context.getPackageName();
        }
        return resources.getIdentifier(str, str2, packageName);
    }

    public static String f(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = f43741a;
            cArr[i3] = cArr2[(b2 & 255) >>> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static boolean g() {
        if (Build.PRODUCT.contains("sdk")) {
            return true;
        }
        String str = Build.HARDWARE;
        return str.contains("goldfish") || str.contains("ranchu");
    }

    public static boolean h() {
        boolean zG = g();
        String str = Build.TAGS;
        if ((zG || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !zG && new File("/system/xbin/su").exists();
        }
        return true;
    }

    public static String i(String str) throws NoSuchAlgorithmException {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            messageDigest.update(bytes);
            return f(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            Logger.f43705a.c("Could not create hashing algorithm: SHA-1, returning empty string.", e2);
            return "";
        }
    }

    public static String j(FileInputStream fileInputStream) {
        Scanner scannerUseDelimiter = new Scanner(fileInputStream).useDelimiter("\\A");
        try {
            String next = scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
            scannerUseDelimiter.close();
            return next;
        } catch (Throwable th) {
            if (scannerUseDelimiter != null) {
                try {
                    scannerUseDelimiter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
