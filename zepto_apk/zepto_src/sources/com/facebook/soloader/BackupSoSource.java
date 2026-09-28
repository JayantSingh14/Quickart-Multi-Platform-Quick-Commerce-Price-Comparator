package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.StrictMode;
import android.support.v4.media.b;
import android.util.Log;
import com.facebook.soloader.ExtractFromZipSoSource;
import com.facebook.soloader.ExtractFromZipSoSource.ZipUnpacker;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class BackupSoSource extends UnpackingSoSource implements RecoverableSoSource {

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f20245e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20246f;

    public class ApkUnpacker extends UnpackingSoSource.Unpacker {
        public ApkUnpacker() {
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final UnpackingSoSource.Dso[] b() throws IOException {
            ArrayList arrayList = new ArrayList();
            Iterator it = BackupSoSource.this.f20245e.iterator();
            while (it.hasNext()) {
                ExtractFromZipSoSource extractFromZipSoSource = (ExtractFromZipSoSource) it.next();
                extractFromZipSoSource.getClass();
                ExtractFromZipSoSource.ZipUnpacker zipUnpacker = extractFromZipSoSource.new ZipUnpacker(extractFromZipSoSource);
                try {
                    ExtractFromZipSoSource.ZipDso[] zipDsoArrE = zipUnpacker.f20272a;
                    if (zipDsoArrE == null) {
                        zipDsoArrE = zipUnpacker.e();
                        zipUnpacker.f20272a = zipDsoArrE;
                    }
                    arrayList.addAll(Arrays.asList(zipDsoArrE));
                    zipUnpacker.close();
                } catch (Throwable th) {
                    try {
                        zipUnpacker.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            return (UnpackingSoSource.Dso[]) arrayList.toArray(new UnpackingSoSource.Dso[arrayList.size()]);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public final void c(File file) throws IOException {
            Iterator it = BackupSoSource.this.f20245e.iterator();
            while (it.hasNext()) {
                ExtractFromZipSoSource extractFromZipSoSource = (ExtractFromZipSoSource) it.next();
                extractFromZipSoSource.getClass();
                ExtractFromZipSoSource.ZipUnpacker zipUnpacker = extractFromZipSoSource.new ZipUnpacker(extractFromZipSoSource);
                try {
                    zipUnpacker.c(file);
                    zipUnpacker.close();
                } catch (Throwable th) {
                    try {
                        zipUnpacker.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }
    }

    public BackupSoSource(Context context, String str, boolean z) {
        super(context, str, z);
        ArrayList arrayList = new ArrayList();
        this.f20245e = arrayList;
        this.f20246f = false;
        arrayList.add(new ExtractFromZipSoSource(context, str, new File(context.getApplicationInfo().sourceDir)));
        if (context.getApplicationInfo().splitSourceDirs == null) {
            return;
        }
        try {
            for (String str2 : context.getApplicationInfo().splitSourceDirs) {
                ExtractFromZipSoSource extractFromZipSoSource = new ExtractFromZipSoSource(context, str, new File(str2));
                ExtractFromZipSoSource.ZipUnpacker zipUnpacker = extractFromZipSoSource.new ZipUnpacker(extractFromZipSoSource);
                try {
                    boolean z2 = zipUnpacker.e().length != 0;
                    zipUnpacker.close();
                    if (z2) {
                        Log.w("BackupSoSource", "adding backup source from split: " + extractFromZipSoSource.toString());
                        this.f20245e.add(extractFromZipSoSource);
                    }
                } catch (Throwable th) {
                    try {
                        zipUnpacker.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (IOException e2) {
            Log.w("BackupSoSource", "failed to read split apks", e2);
        }
    }

    @Override // com.facebook.soloader.RecoverableSoSource
    public final SoSource b(Context context) {
        BackupSoSource backupSoSource = new BackupSoSource(context, this.f20254a.getName(), true);
        try {
            backupSoSource.e(0);
            return backupSoSource;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public final String c() {
        return "BackupSoSource";
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public final int d(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        if (this.f20246f) {
            return super.d(str, i2, threadPolicy);
        }
        return 0;
    }

    @Override // com.facebook.soloader.UnpackingSoSource, com.facebook.soloader.SoSource
    public final void e(int i2) throws IOException {
        if ((i2 & 8) != 0) {
            return;
        }
        super.e(i2);
        this.f20246f = true;
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public final byte[] f() {
        Context context = this.f20299d;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeByte((byte) 3);
            PackageManager packageManager = context.getPackageManager();
            int i2 = 0;
            if (packageManager != null) {
                try {
                    i2 = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
                }
            }
            parcelObtain.writeInt(i2);
            ArrayList arrayList = this.f20245e;
            parcelObtain.writeInt(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                parcelObtain.writeByteArray(((ExtractFromZipSoSource) it.next()).f());
            }
            String str = context.getApplicationInfo().sourceDir;
            if (str == null) {
                parcelObtain.writeByte((byte) 1);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                return bArrMarshall;
            }
            File canonicalFile = new File(str).getCanonicalFile();
            if (!canonicalFile.exists()) {
                parcelObtain.writeByte((byte) 1);
                byte[] bArrMarshall2 = parcelObtain.marshall();
                parcelObtain.recycle();
                return bArrMarshall2;
            }
            parcelObtain.writeByte((byte) 2);
            parcelObtain.writeString(canonicalFile.getPath());
            parcelObtain.writeLong(canonicalFile.lastModified());
            byte[] bArrMarshall3 = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall3;
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public final UnpackingSoSource.Dso[] g() throws IOException {
        ExtractFromZipSoSource extractFromZipSoSource = (ExtractFromZipSoSource) this.f20245e.get(0);
        extractFromZipSoSource.getClass();
        ExtractFromZipSoSource.ZipUnpacker zipUnpacker = extractFromZipSoSource.new ZipUnpacker(extractFromZipSoSource);
        try {
            ExtractFromZipSoSource.ZipDso[] zipDsoArrE = zipUnpacker.f20272a;
            if (zipDsoArrE == null) {
                zipDsoArrE = zipUnpacker.e();
                zipUnpacker.f20272a = zipDsoArrE;
            }
            zipUnpacker.close();
            return zipDsoArrE;
        } catch (Throwable th) {
            try {
                zipUnpacker.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public final UnpackingSoSource.Unpacker h() {
        return new ApkUnpacker();
    }

    public final boolean k(String str) throws IOException {
        for (UnpackingSoSource.Dso dso : new ApkUnpacker().b()) {
            if (dso.f20304a.equals(str)) {
                Log.e("SoLoader", "Found " + str + " in BackupSoSource");
                Log.e("SoLoader", "Preparing BackupSoSource");
                e(0);
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public final String toString() {
        String name;
        File file = this.f20254a;
        try {
            name = String.valueOf(file.getCanonicalPath());
        } catch (IOException unused) {
            name = file.getName();
        }
        StringBuilder sbY = b.y("BackupSoSource[root = ", name, " flags = ");
        sbY.append(this.f20255b);
        sbY.append(" apks = ");
        sbY.append(this.f20245e.toString());
        sbY.append("]");
        return sbY.toString();
    }
}
