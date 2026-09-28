package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.support.v4.media.b;
import android.util.Log;
import com.facebook.soloader.SysUtil;
import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;

/* loaded from: classes3.dex */
public abstract class UnpackingSoSource extends DirectorySoSource implements AsyncInitSoSource {

    /* renamed from: d, reason: collision with root package name */
    public final Context f20299d;

    /* renamed from: com.facebook.soloader.UnpackingSoSource$1, reason: invalid class name */
    class AnonymousClass1 implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return (str.equals("dso_state") || str.equals("dso_lock") || str.equals("dso_deps")) ? false : true;
        }
    }

    public static class Dso {

        /* renamed from: a, reason: collision with root package name */
        public final String f20304a;

        /* renamed from: b, reason: collision with root package name */
        public final String f20305b;

        public Dso(String str, String str2) {
            this.f20304a = str;
            this.f20305b = str2;
        }
    }

    public static final class InputDso implements Closeable, AutoCloseable {

        /* renamed from: a, reason: collision with root package name */
        public final Dso f20306a;

        /* renamed from: b, reason: collision with root package name */
        public final InputStream f20307b;

        public InputDso(Dso dso, InputStream inputStream) {
            this.f20306a = dso;
            this.f20307b = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this.f20307b.close();
        }
    }

    public static abstract class Unpacker implements Closeable, AutoCloseable {
        public static void a(InputDso inputDso, byte[] bArr, File file) {
            RandomAccessFile randomAccessFile;
            int i2;
            StringBuilder sb = new StringBuilder("extracting DSO ");
            Dso dso = inputDso.f20306a;
            InputStream inputStream = inputDso.f20307b;
            sb.append(dso.f20304a);
            String string = sb.toString();
            if (LogUtil.b(4, "fb-UnpackingSoSource")) {
                Log.i("fb-UnpackingSoSource", string);
            }
            File file2 = new File(file, dso.f20304a);
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                    try {
                        int iAvailable = inputStream.available();
                        if (iAvailable > 1) {
                            randomAccessFile = randomAccessFile2;
                            try {
                                SysUtil.LollipopSysdeps.fallocateIfSupported(randomAccessFile2.getFD(), iAvailable);
                            } catch (Throwable th) {
                                th = th;
                                Throwable th2 = th;
                                try {
                                    randomAccessFile.close();
                                    throw th2;
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                    throw th2;
                                }
                            }
                        } else {
                            randomAccessFile = randomAccessFile2;
                        }
                        int i3 = 0;
                        while (i3 < Integer.MAX_VALUE && (i2 = inputStream.read(bArr, 0, Math.min(bArr.length, Api.BaseClientBuilder.API_PRIORITY_OTHER - i3))) != -1) {
                            randomAccessFile.write(bArr, 0, i2);
                            i3 += i2;
                        }
                        randomAccessFile.setLength(randomAccessFile.getFilePointer());
                        if (!file2.setExecutable(true, false)) {
                            throw new IOException("cannot make file executable: " + file2);
                        }
                        randomAccessFile.close();
                        if (!file2.exists() || file2.setWritable(false)) {
                            return;
                        }
                        Log.e("SoLoader", "Error removing " + file2 + " write permission from directory " + file + " (writable: " + file.canWrite() + ")");
                    } catch (Throwable th4) {
                        th = th4;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (IOException e2) {
                    Log.e("fb-UnpackingSoSource", "error extracting dso  " + file2 + " due to: " + e2);
                    SysUtil.b(file2);
                    throw e2;
                }
            } catch (Throwable th5) {
                if (file2.exists() && !file2.setWritable(false)) {
                    Log.e("SoLoader", "Error removing " + file2 + " write permission from directory " + file + " (writable: " + file.canWrite() + ")");
                }
                throw th5;
            }
        }

        public abstract Dso[] b();

        public abstract void c(File file);

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public UnpackingSoSource(Context context, String str, boolean z) {
        super(new File(b.s(new StringBuilder(), context.getApplicationInfo().dataDir, "/", str)), z ? 1 : 0);
        this.f20299d = context;
    }

    public static void j(File file, byte b2, boolean z) throws IOException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.seek(0L);
                randomAccessFile.write(b2);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (z) {
                    randomAccessFile.getFD().sync();
                }
                randomAccessFile.close();
            } finally {
            }
        } catch (SyncFailedException e2) {
            Log.w("fb-UnpackingSoSource", "state file sync failed", e2);
        }
    }

    @Override // com.facebook.soloader.AsyncInitSoSource
    public final void a() {
        File file = this.f20254a;
        try {
            SysUtil.d(file, new File(file, "dso_lock")).close();
        } catch (Exception e2) {
            Log.e("fb-UnpackingSoSource", "Encountered exception during wait for unpacking trying to acquire file lock for " + getClass().getName() + " (" + file + "): ", e2);
        }
    }

    @Override // com.facebook.soloader.SoSource
    public void e(int i2) throws IOException {
        File file = this.f20254a;
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("cannot mkdir: " + file);
        }
        if (!file.canWrite() && !file.setWritable(true)) {
            throw new IOException("error adding " + file.getCanonicalPath() + " write permission");
        }
        FileLocker fileLocker = null;
        try {
            try {
                FileLocker fileLockerD = SysUtil.d(file, new File(file, "dso_lock"));
                try {
                    LogUtil.c("fb-UnpackingSoSource", "locked dso store " + file);
                    if (!file.canWrite() && !file.setWritable(true)) {
                        throw new IOException("error adding " + file.getCanonicalPath() + " write permission");
                    }
                    if (!i(fileLockerD, i2)) {
                        String str = "dso store is up-to-date: " + file;
                        if (LogUtil.b(4, "fb-UnpackingSoSource")) {
                            Log.i("fb-UnpackingSoSource", str);
                        }
                        fileLocker = fileLockerD;
                    }
                    if (fileLocker != null) {
                        LogUtil.c("fb-UnpackingSoSource", "releasing dso store lock for " + file);
                        fileLocker.close();
                    } else {
                        LogUtil.c("fb-UnpackingSoSource", "not releasing dso store lock for " + file + " (syncer thread started)");
                    }
                    if (!file.canWrite() || file.setWritable(false)) {
                        return;
                    }
                    throw new IOException("error removing " + file.getCanonicalPath() + " write permission");
                } catch (Throwable th) {
                    th = th;
                    fileLocker = fileLockerD;
                    if (fileLocker != null) {
                        LogUtil.c("fb-UnpackingSoSource", "releasing dso store lock for " + file);
                        fileLocker.close();
                    } else {
                        LogUtil.c("fb-UnpackingSoSource", "not releasing dso store lock for " + file + " (syncer thread started)");
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (!file.canWrite() || file.setWritable(false)) {
                throw th3;
            }
            throw new IOException("error removing " + file.getCanonicalPath() + " write permission");
        }
    }

    public byte[] f() {
        Parcel parcelObtain = Parcel.obtain();
        Unpacker unpackerH = h();
        try {
            Dso[] dsoArrB = unpackerH.b();
            parcelObtain.writeInt(dsoArrB.length);
            for (Dso dso : dsoArrB) {
                parcelObtain.writeString(dso.f20304a);
                parcelObtain.writeString(dso.f20305b);
            }
            unpackerH.close();
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Throwable th) {
            try {
                unpackerH.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public Dso[] g() {
        Unpacker unpackerH = h();
        try {
            Dso[] dsoArrB = unpackerH.b();
            unpackerH.close();
            return dsoArrB;
        } catch (Throwable th) {
            try {
                unpackerH.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public abstract Unpacker h();

    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(final com.facebook.soloader.FileLocker r17, int r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.i(com.facebook.soloader.FileLocker, int):boolean");
    }
}
