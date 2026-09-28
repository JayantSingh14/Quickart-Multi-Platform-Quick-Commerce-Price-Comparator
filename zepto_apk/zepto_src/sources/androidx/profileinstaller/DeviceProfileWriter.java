package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.activity.g;
import androidx.annotation.RestrictTo;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

@RestrictTo
/* loaded from: classes3.dex */
public class DeviceProfileWriter {

    /* renamed from: a, reason: collision with root package name */
    public final AssetManager f11289a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f11290b;

    /* renamed from: c, reason: collision with root package name */
    public final ProfileInstaller.DiagnosticsCallback f11291c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f11292d;

    /* renamed from: e, reason: collision with root package name */
    public final File f11293e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11294f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11295g = false;

    /* renamed from: h, reason: collision with root package name */
    public DexProfileData[] f11296h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f11297i;

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String str, File file) {
        byte[] bArr;
        this.f11289a = assetManager;
        this.f11290b = executor;
        this.f11291c = diagnosticsCallback;
        this.f11294f = str;
        this.f11293e = file;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 31) {
            switch (i2) {
                case 24:
                case 25:
                    bArr = ProfileVersion.f11328e;
                    break;
                case 26:
                    bArr = ProfileVersion.f11327d;
                    break;
                case 27:
                    bArr = ProfileVersion.f11326c;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = ProfileVersion.f11325b;
                    break;
                default:
                    bArr = null;
                    break;
            }
        } else {
            bArr = ProfileVersion.f11324a;
        }
        this.f11292d = bArr;
    }

    public final boolean a() {
        if (this.f11292d == null) {
            d(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        File file = this.f11293e;
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    d(4, null);
                    return false;
                }
            } catch (IOException unused) {
                d(4, null);
                return false;
            }
        } else if (!file.canWrite()) {
            d(4, null);
            return false;
        }
        this.f11295g = true;
        return true;
    }

    public final FileInputStream b(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e2) {
            String message = e2.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f11291c.b();
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:7|(2:102|8)|17|91|(3:94|19|(4:21|96|22|42)(2:32|33))|48|(4:104|58|(3:95|60|(3:62|63|64)(2:73|74))(1:(1:81))|(1:87))) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005e, code lost:
    
        r1.a(7, r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00da A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.profileinstaller.DeviceProfileWriter c() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.DeviceProfileWriter.c():androidx.profileinstaller.DeviceProfileWriter");
    }

    public final void d(int i2, Serializable serializable) {
        this.f11290b.execute(new g(this, i2, serializable, 3));
    }

    public final void e() throws IOException {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        ProfileInstaller.DiagnosticsCallback diagnosticsCallback = this.f11291c;
        DexProfileData[] dexProfileDataArr = this.f11296h;
        if (dexProfileDataArr == null || (bArr = this.f11292d) == null) {
            return;
        }
        if (!this.f11295g) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(ProfileTranscoder.f11315a);
                byteArrayOutputStream.write(bArr);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e2) {
            diagnosticsCallback.a(7, e2);
        } catch (IllegalStateException e3) {
            diagnosticsCallback.a(8, e3);
        }
        if (ProfileTranscoder.i(byteArrayOutputStream, bArr, dexProfileDataArr)) {
            this.f11297i = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f11296h = null;
        } else {
            diagnosticsCallback.a(5, null);
            this.f11296h = null;
            byteArrayOutputStream.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean f() {
        byte[] bArr = this.f11297i;
        if (bArr != null) {
            if (!this.f11295g) {
                throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
            }
            try {
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f11293e);
                        try {
                            FileChannel channel = fileOutputStream.getChannel();
                            try {
                                FileLock fileLockTryLock = channel.tryLock();
                                if (fileLockTryLock != null) {
                                    try {
                                        if (fileLockTryLock.isValid()) {
                                            byte[] bArr2 = new byte[512];
                                            while (true) {
                                                int i2 = byteArrayInputStream.read(bArr2);
                                                if (i2 <= 0) {
                                                    d(1, null);
                                                    fileLockTryLock.close();
                                                    channel.close();
                                                    fileOutputStream.close();
                                                    byteArrayInputStream.close();
                                                    return true;
                                                }
                                                fileOutputStream.write(bArr2, 0, i2);
                                            }
                                        }
                                    } finally {
                                    }
                                }
                                throw new IOException("Unable to acquire a lock on the underlying file channel.");
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    d(6, e2);
                    return false;
                } catch (IOException e3) {
                    d(7, e3);
                    return false;
                }
            } finally {
                this.f11297i = null;
                this.f11296h = null;
            }
        }
        return false;
    }
}
