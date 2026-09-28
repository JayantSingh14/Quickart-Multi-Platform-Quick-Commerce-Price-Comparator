package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.support.v4.media.b;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class zze {

    /* renamed from: a, reason: collision with root package name */
    public final long f41908a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f41909b;

    /* renamed from: c, reason: collision with root package name */
    public File f41910c;

    public zze(Context context) {
        this.f41909b = context;
        this.f41908a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    public static void c(File file) throws IOException {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                c(file2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(b.D("Failed to delete '", file.getAbsolutePath(), "'"));
        }
    }

    public static File d(File file, String str) {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    public static void e(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IllegalArgumentException("File input must be directory when it exists.");
            }
        } else {
            file.mkdirs();
            if (!file.isDirectory()) {
                throw new IOException("Unable to create directory: ".concat(String.valueOf(file.getAbsolutePath())));
            }
        }
    }

    public final HashSet a() throws IOException {
        File file = new File(g(), "verified-splits");
        e(file);
        HashSet hashSet = new HashSet();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.getName().endsWith(".apk") && !file2.canWrite()) {
                    hashSet.add(new zzb(file2, file2.getName().substring(0, r5.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    public final void b() throws IOException {
        File fileF = f();
        String[] list = fileF.list();
        if (list != null) {
            for (String str : list) {
                long j2 = this.f41908a;
                if (!str.equals(Long.toString(j2))) {
                    File file = new File(fileF, str);
                    Log.d("SplitCompat", "FileStorage: removing directory for different version code (directory = " + file.toString() + ", current version code = " + j2 + ")");
                    c(file);
                }
            }
        }
    }

    public final File f() throws IOException {
        if (this.f41910c == null) {
            Context context = this.f41909b;
            if (context == null) {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
            this.f41910c = context.getFilesDir();
        }
        File file = new File(this.f41910c, "splitcompat");
        e(file);
        return file;
    }

    public final File g() throws IOException {
        File file = new File(f(), Long.toString(this.f41908a));
        e(file);
        return file;
    }
}
