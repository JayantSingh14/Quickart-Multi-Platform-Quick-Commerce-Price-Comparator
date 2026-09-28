package androidx.profileinstaller;

import android.content.pm.PackageInfo;
import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class ProfileInstaller {

    /* renamed from: a, reason: collision with root package name */
    public static final DiagnosticsCallback f11313a = new AnonymousClass1();

    /* renamed from: b, reason: collision with root package name */
    public static final DiagnosticsCallback f11314b = new AnonymousClass2();

    /* renamed from: androidx.profileinstaller.ProfileInstaller$2, reason: invalid class name */
    public class AnonymousClass2 implements DiagnosticsCallback {
        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void a(int i2, Serializable serializable) {
            String str;
            switch (i2) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i2 == 6 || i2 == 7 || i2 == 8) {
                Log.e("ProfileInstaller", str, (Throwable) serializable);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void b() {
            Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface DiagnosticCode {
    }

    public interface DiagnosticsCallback {
        void a(int i2, Serializable serializable);

        void b();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface ResultCode {
    }

    public static void a(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.content.Context r16, java.util.concurrent.Executor r17, androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback r18, boolean r19) {
        /*
            r1 = r16
            r5 = r18
            android.content.Context r0 = r1.getApplicationContext()
            java.lang.String r2 = r0.getPackageName()
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo()
            android.content.res.AssetManager r4 = r0.getAssets()
            java.io.File r0 = new java.io.File
            java.lang.String r3 = r3.sourceDir
            r0.<init>(r3)
            java.lang.String r6 = r0.getName()
            android.content.pm.PackageManager r0 = r1.getPackageManager()
            r8 = 0
            android.content.pm.PackageInfo r9 = r0.getPackageInfo(r2, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Ld5
            java.io.File r10 = r1.getFilesDir()
            java.lang.String r3 = "ProfileInstaller"
            r11 = 1
            if (r19 != 0) goto L89
            java.io.File r0 = new java.io.File
            java.lang.String r7 = "profileinstaller_profileWrittenFor_lastUpdateTime.dat"
            r0.<init>(r10, r7)
            boolean r7 = r0.exists()
            if (r7 != 0) goto L40
        L3e:
            r0 = r8
            goto L6d
        L40:
            java.io.DataInputStream r7 = new java.io.DataInputStream     // Catch: java.io.IOException -> L3e
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch: java.io.IOException -> L3e
            r12.<init>(r0)     // Catch: java.io.IOException -> L3e
            r7.<init>(r12)     // Catch: java.io.IOException -> L3e
            long r12 = r7.readLong()     // Catch: java.lang.Throwable -> L62
            r7.close()     // Catch: java.io.IOException -> L3e
            long r14 = r9.lastUpdateTime
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 != 0) goto L59
            r0 = r11
            goto L5a
        L59:
            r0 = r8
        L5a:
            if (r0 == 0) goto L6d
            r7 = 2
            r12 = 0
            r5.a(r7, r12)
            goto L6d
        L62:
            r0 = move-exception
            r12 = r0
            r7.close()     // Catch: java.lang.Throwable -> L68
            goto L6c
        L68:
            r0 = move-exception
            r12.addSuppressed(r0)     // Catch: java.io.IOException -> L3e
        L6c:
            throw r12     // Catch: java.io.IOException -> L3e
        L6d:
            if (r0 != 0) goto L70
            goto L89
        L70:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Skipping profile installation for "
            r0.<init>(r2)
            java.lang.String r2 = r1.getPackageName()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
            androidx.profileinstaller.ProfileVerifier.c(r1, r8)
            goto Ld4
        L89:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r7 = "Installing profile for "
            r0.<init>(r7)
            java.lang.String r7 = r1.getPackageName()
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
            java.io.File r7 = new java.io.File
            java.io.File r0 = new java.io.File
            java.lang.String r3 = "/data/misc/profiles/cur/0"
            r0.<init>(r3, r2)
            java.lang.String r2 = "primary.prof"
            r7.<init>(r0, r2)
            androidx.profileinstaller.DeviceProfileWriter r2 = new androidx.profileinstaller.DeviceProfileWriter
            r3 = r4
            r4 = r17
            r2.<init>(r3, r4, r5, r6, r7)
            boolean r0 = r2.a()
            if (r0 != 0) goto Lbc
            r0 = r8
            goto Lcc
        Lbc:
            androidx.profileinstaller.DeviceProfileWriter r0 = r2.c()
            r0.e()
            boolean r0 = r0.f()
            if (r0 == 0) goto Lcc
            a(r9, r10)
        Lcc:
            if (r0 == 0) goto Ld1
            if (r19 == 0) goto Ld1
            r8 = r11
        Ld1:
            androidx.profileinstaller.ProfileVerifier.c(r1, r8)
        Ld4:
            return
        Ld5:
            r0 = move-exception
            r2 = 7
            r5.a(r2, r0)
            androidx.profileinstaller.ProfileVerifier.c(r1, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.ProfileInstaller.b(android.content.Context, java.util.concurrent.Executor, androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback, boolean):void");
    }

    /* renamed from: androidx.profileinstaller.ProfileInstaller$1, reason: invalid class name */
    public class AnonymousClass1 implements DiagnosticsCallback {
        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void b() {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void a(int i2, Serializable serializable) {
        }
    }
}
