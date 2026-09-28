package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ProfileVerifier {

    /* renamed from: a, reason: collision with root package name */
    public static final ResolvableFuture f11317a = new ResolvableFuture();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f11318b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static CompilationStatus f11319c = null;

    @RequiresApi
    public static class Api33Impl {
        public static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    @RestrictTo
    public static class Cache {

        /* renamed from: a, reason: collision with root package name */
        public final int f11320a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11321b;

        /* renamed from: c, reason: collision with root package name */
        public final long f11322c;

        /* renamed from: d, reason: collision with root package name */
        public final long f11323d;

        public Cache(int i2, int i3, long j2, long j3) {
            this.f11320a = i2;
            this.f11321b = i3;
            this.f11322c = j2;
            this.f11323d = j3;
        }

        public static Cache a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return cache;
            } finally {
            }
        }

        public final void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f11320a);
                dataOutputStream.writeInt(this.f11321b);
                dataOutputStream.writeLong(this.f11322c);
                dataOutputStream.writeLong(this.f11323d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Cache)) {
                Cache cache = (Cache) obj;
                if (this.f11321b == cache.f11321b && this.f11322c == cache.f11322c && this.f11320a == cache.f11320a && this.f11323d == cache.f11323d) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.f11321b), Long.valueOf(this.f11322c), Integer.valueOf(this.f11320a), Long.valueOf(this.f11323d));
        }
    }

    /* loaded from: classes3.dex */
    public static class CompilationStatus {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo
        public @interface ResultCode {
        }
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static CompilationStatus b() {
        CompilationStatus compilationStatus = new CompilationStatus();
        f11319c = compilationStatus;
        f11317a.l(compilationStatus);
        return f11319c;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.content.Context r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.ProfileVerifier.c(android.content.Context, boolean):void");
    }
}
