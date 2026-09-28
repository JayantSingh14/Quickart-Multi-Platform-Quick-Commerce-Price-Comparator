package com.facebook.soloader;

import android.os.StrictMode;
import android.support.v4.media.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class DirectorySoSource extends SoSource {

    /* renamed from: a, reason: collision with root package name */
    public final File f20254a;

    /* renamed from: b, reason: collision with root package name */
    public int f20255b;

    /* renamed from: c, reason: collision with root package name */
    public final List f20256c = Arrays.asList(new String[0]);

    public DirectorySoSource(File file, int i2) {
        this.f20254a = file;
        this.f20255b = i2;
    }

    @Override // com.facebook.soloader.SoSource
    public String c() {
        return "DirectorySoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public int d(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.f20286b == null) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
        boolean zContains = this.f20256c.contains(str);
        File file = this.f20254a;
        if (zContains) {
            StringBuilder sbX = b.x(str, " is on the denyList, skip loading from ");
            sbX.append(file.getCanonicalPath());
            LogUtil.a(sbX.toString());
            return 0;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2 = null;
        }
        if (file2 == null) {
            StringBuilder sbX2 = b.x(str, " file not found on ");
            sbX2.append(file.getCanonicalPath());
            LogUtil.c("SoLoader", sbX2.toString());
            return 0;
        }
        String canonicalPath = file2.getCanonicalPath();
        LogUtil.a(str + " file found at " + canonicalPath);
        if ((i2 & 1) != 0 && (this.f20255b & 2) != 0) {
            LogUtil.a(str + " loaded implicitly");
            return 2;
        }
        if ((this.f20255b & 1) != 0) {
            ElfFileChannel elfFileChannel = new ElfFileChannel();
            elfFileChannel.f20257a = file2;
            FileInputStream fileInputStream = new FileInputStream(elfFileChannel.f20257a);
            elfFileChannel.f20258b = fileInputStream;
            elfFileChannel.f20259c = fileInputStream.getChannel();
            try {
                NativeDeps.e(str, elfFileChannel, i2, threadPolicy);
                elfFileChannel.close();
            } catch (Throwable th) {
                try {
                    elfFileChannel.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } else {
            LogUtil.a("Not resolving dependencies for " + str);
        }
        try {
            SoLoader.f20286b.a(i2, canonicalPath);
            return 1;
        } catch (UnsatisfiedLinkError e2) {
            throw SoLoaderULErrorFactory.a(str, e2);
        }
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        String name;
        File file = this.f20254a;
        try {
            name = String.valueOf(file.getCanonicalPath());
        } catch (IOException unused) {
            name = file.getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c());
        sb.append("[root = ");
        sb.append(name);
        sb.append(" flags = ");
        return b.n(sb, this.f20255b, ']');
    }
}
