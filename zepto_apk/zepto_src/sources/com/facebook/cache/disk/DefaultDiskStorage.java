package com.facebook.cache.disk;

import android.os.Environment;
import android.support.v4.media.b;
import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.analytics.d;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.SystemClock;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Nullsafe
/* loaded from: classes3.dex */
public class DefaultDiskStorage implements DiskStorage {

    /* renamed from: f, reason: collision with root package name */
    public static final long f16994f = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f16995g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final File f16996a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16997b;

    /* renamed from: c, reason: collision with root package name */
    public final File f16998c;

    /* renamed from: d, reason: collision with root package name */
    public final NoOpCacheErrorLogger f16999d;

    /* renamed from: e, reason: collision with root package name */
    public final SystemClock f17000e;

    public class EntriesCollector implements FileTreeVisitor {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f17001a = new ArrayList();

        public EntriesCollector() {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void a(File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void b(File file) {
            FileInfo fileInfoI = DefaultDiskStorage.i(DefaultDiskStorage.this, file);
            if (fileInfoI == null || fileInfoI.f17007a != ".cnt") {
                return;
            }
            this.f17001a.add(new EntryImpl(file, fileInfoI.f17008b));
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void c(File file) {
        }
    }

    @VisibleForTesting
    public static class EntryImpl implements DiskStorage.Entry {

        /* renamed from: a, reason: collision with root package name */
        public final String f17003a;

        /* renamed from: b, reason: collision with root package name */
        public final FileBinaryResource f17004b;

        /* renamed from: c, reason: collision with root package name */
        public long f17005c;

        /* renamed from: d, reason: collision with root package name */
        public long f17006d;

        public EntryImpl(File file, String str) {
            str.getClass();
            this.f17003a = str;
            Intrinsics.checkNotNullParameter(file, "file");
            this.f17004b = new FileBinaryResource(file);
            this.f17005c = -1L;
            this.f17006d = -1L;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public final String getId() {
            return this.f17003a;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public final long getSize() {
            if (this.f17005c < 0) {
                this.f17005c = this.f17004b.f16987a.length();
            }
            return this.f17005c;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public final long getTimestamp() {
            if (this.f17006d < 0) {
                this.f17006d = this.f17004b.f16987a.lastModified();
            }
            return this.f17006d;
        }
    }

    public static class FileInfo {

        /* renamed from: a, reason: collision with root package name */
        public final String f17007a;

        /* renamed from: b, reason: collision with root package name */
        public final String f17008b;

        public FileInfo(String str, String str2) {
            this.f17007a = str;
            this.f17008b = str2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f17007a);
            sb.append("(");
            return b.r(sb, this.f17008b, ")");
        }
    }

    public @interface FileType {
    }

    public static class IncompleteFileException extends IOException {
    }

    @VisibleForTesting
    public class InserterImpl implements DiskStorage.Inserter {

        /* renamed from: a, reason: collision with root package name */
        public final String f17009a;

        /* renamed from: b, reason: collision with root package name */
        public final File f17010b;

        public InserterImpl(String str, File file) {
            this.f17009a = str;
            this.f17010b = file;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public final void a(d dVar) throws IOException {
            File file = this.f17010b;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    CountingOutputStream os = new CountingOutputStream(fileOutputStream);
                    os.f17076a = 0L;
                    BufferedDiskCache this$0 = (BufferedDiskCache) dVar.f6452c;
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    Intrinsics.checkNotNullParameter(os, "os");
                    EncodedImage encodedImage = (EncodedImage) dVar.f6451b;
                    Intrinsics.c(encodedImage);
                    InputStream inputStreamS = encodedImage.s();
                    if (inputStreamS == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    this$0.f17732c.a(inputStreamS, os);
                    os.flush();
                    long j2 = os.f17076a;
                    fileOutputStream.close();
                    if (file.length() == j2) {
                        return;
                    }
                    long length = file.length();
                    StringBuilder sbV = b.v(j2, "File was not written completely. Expected: ", ", found: ");
                    sbV.append(length);
                    throw new IncompleteFileException(sbV.toString());
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                NoOpCacheErrorLogger noOpCacheErrorLogger = DefaultDiskStorage.this.f16999d;
                int i2 = DefaultDiskStorage.f16995g;
                noOpCacheErrorLogger.getClass();
                throw e2;
            }
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public final FileBinaryResource commit() throws FileUtils.RenameException {
            DefaultDiskStorage defaultDiskStorage = DefaultDiskStorage.this;
            defaultDiskStorage.f17000e.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            File file = defaultDiskStorage.j(this.f17009a);
            try {
                FileUtils.b(this.f17010b, file);
                if (file.exists()) {
                    file.setLastModified(jCurrentTimeMillis);
                }
                Intrinsics.checkNotNullParameter(file, "file");
                return new FileBinaryResource(file);
            } catch (FileUtils.RenameException e2) {
                Throwable cause = e2.getCause();
                if (cause != null && !(cause instanceof FileUtils.ParentDirNotFoundException)) {
                    boolean z = cause instanceof FileNotFoundException;
                }
                int i2 = DefaultDiskStorage.f16995g;
                defaultDiskStorage.f16999d.getClass();
                throw e2;
            }
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public final boolean f() {
            File file = this.f17010b;
            return !file.exists() || file.delete();
        }
    }

    public class PurgingVisitor implements FileTreeVisitor {

        /* renamed from: a, reason: collision with root package name */
        public boolean f17012a;

        public PurgingVisitor() {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void a(File file) {
            DefaultDiskStorage defaultDiskStorage = DefaultDiskStorage.this;
            if (!defaultDiskStorage.f16996a.equals(file) && !this.f17012a) {
                file.delete();
            }
            if (this.f17012a && file.equals(defaultDiskStorage.f16998c)) {
                this.f17012a = false;
            }
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void b(File file) {
            DefaultDiskStorage defaultDiskStorage;
            FileInfo fileInfoI;
            if (this.f17012a && (fileInfoI = DefaultDiskStorage.i((defaultDiskStorage = DefaultDiskStorage.this), file)) != null) {
                String str = fileInfoI.f17007a;
                if (str != ".tmp") {
                    Preconditions.e(str == ".cnt");
                    return;
                }
                long jLastModified = file.lastModified();
                defaultDiskStorage.f17000e.getClass();
                if (jLastModified > System.currentTimeMillis() - DefaultDiskStorage.f16994f) {
                    return;
                }
            }
            file.delete();
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void c(File file) {
            if (this.f17012a || !file.equals(DefaultDiskStorage.this.f16998c)) {
                return;
            }
            this.f17012a = true;
        }
    }

    public DefaultDiskStorage(File file, int i2, NoOpCacheErrorLogger noOpCacheErrorLogger) {
        this.f16996a = file;
        boolean zContains = false;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                try {
                    zContains = file.getCanonicalPath().contains(externalStorageDirectory.toString());
                } catch (IOException unused) {
                    noOpCacheErrorLogger.getClass();
                }
            }
        } catch (Exception unused2) {
            noOpCacheErrorLogger.getClass();
        }
        this.f16997b = zContains;
        File file2 = new File(this.f16996a, b.f(i2, "v2.ols100."));
        this.f16998c = file2;
        this.f16999d = noOpCacheErrorLogger;
        File file3 = this.f16996a;
        if (!file3.exists()) {
            FileUtils.a(file2);
        } else if (!file2.exists()) {
            FileTree.a(file3);
            try {
                FileUtils.a(file2);
            } catch (FileUtils.CreateDirectoryException unused3) {
                file2.toString();
                this.f16999d.getClass();
            }
        }
        this.f17000e = SystemClock.f17138a;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.cache.disk.DefaultDiskStorage.FileInfo i(com.facebook.cache.disk.DefaultDiskStorage r8, java.io.File r9) {
        /*
            r8.getClass()
            java.lang.String r0 = r9.getName()
            r1 = 46
            int r2 = r0.lastIndexOf(r1)
            r3 = 0
            if (r2 > 0) goto L12
        L10:
            r1 = r3
            goto L48
        L12:
            java.lang.String r4 = r0.substring(r2)
            java.lang.String r5 = ".cnt"
            boolean r6 = r5.equals(r4)
            java.lang.String r7 = ".tmp"
            if (r6 == 0) goto L21
            goto L2a
        L21:
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L29
            r5 = r7
            goto L2a
        L29:
            r5 = r3
        L2a:
            if (r5 != 0) goto L2d
            goto L10
        L2d:
            r4 = 0
            java.lang.String r0 = r0.substring(r4, r2)
            boolean r2 = r5.equals(r7)
            if (r2 == 0) goto L43
            int r1 = r0.lastIndexOf(r1)
            if (r1 > 0) goto L3f
            goto L10
        L3f:
            java.lang.String r0 = r0.substring(r4, r1)
        L43:
            com.facebook.cache.disk.DefaultDiskStorage$FileInfo r1 = new com.facebook.cache.disk.DefaultDiskStorage$FileInfo
            r1.<init>(r5, r0)
        L48:
            if (r1 != 0) goto L4b
            goto L61
        L4b:
            java.io.File r0 = new java.io.File
            java.lang.String r2 = r1.f17008b
            java.lang.String r8 = r8.k(r2)
            r0.<init>(r8)
            java.io.File r8 = r9.getParentFile()
            boolean r8 = r0.equals(r8)
            if (r8 == 0) goto L61
            return r1
        L61:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DefaultDiskStorage.i(com.facebook.cache.disk.DefaultDiskStorage, java.io.File):com.facebook.cache.disk.DefaultDiskStorage$FileInfo");
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final void a() {
        File[] fileArrListFiles = this.f16996a.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                FileTree.a(file);
            }
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final void b() {
        FileTree.b(this.f16996a, new PurgingVisitor());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final DiskStorage.Inserter c(String str, CacheKey cacheKey) throws IOException {
        File file = new File(k(str));
        boolean zExists = file.exists();
        NoOpCacheErrorLogger noOpCacheErrorLogger = this.f16999d;
        if (!zExists) {
            try {
                FileUtils.a(file);
            } catch (FileUtils.CreateDirectoryException e2) {
                noOpCacheErrorLogger.getClass();
                throw e2;
            }
        }
        try {
            return new InserterImpl(str, File.createTempFile(str.concat(CLConstants.DOT_SALT_DELIMETER), ".tmp", file));
        } catch (IOException e3) {
            noOpCacheErrorLogger.getClass();
            throw e3;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final boolean d(String str, CacheKey cacheKey) {
        File fileJ = j(str);
        boolean zExists = fileJ.exists();
        if (zExists) {
            this.f17000e.getClass();
            fileJ.setLastModified(System.currentTimeMillis());
        }
        return zExists;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final long e(DiskStorage.Entry entry) {
        File file = ((EntryImpl) entry).f17004b.f16987a;
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1L;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final BinaryResource f(String str, CacheKey cacheKey) {
        File fileJ = j(str);
        if (!fileJ.exists()) {
            return null;
        }
        this.f17000e.getClass();
        fileJ.setLastModified(System.currentTimeMillis());
        return new FileBinaryResource(fileJ);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final Collection g() {
        EntriesCollector entriesCollector = new EntriesCollector();
        FileTree.b(this.f16998c, entriesCollector);
        return Collections.unmodifiableList(entriesCollector.f17001a);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final boolean h(String str, CacheKey cacheKey) {
        return j(str).exists();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final boolean isExternal() {
        return this.f16997b;
    }

    public final File j(String str) {
        return new File(b.s(b.w(k(str)), File.separator, str, ".cnt"));
    }

    public final String k(String str) {
        String strValueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f16998c);
        return b.r(sb, File.separator, strValueOf);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final long remove(String str) {
        File fileJ = j(str);
        if (!fileJ.exists()) {
            return 0L;
        }
        long length = fileJ.length();
        if (fileJ.delete()) {
            return length;
        }
        return -1L;
    }
}
