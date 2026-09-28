package com.facebook.cache.disk;

import androidx.annotation.VisibleForTesting;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.infer.annotation.Nullsafe;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

@Nullsafe
/* loaded from: classes3.dex */
public class DynamicDefaultDiskStorage implements DiskStorage {

    /* renamed from: a, reason: collision with root package name */
    public final int f17050a;

    /* renamed from: b, reason: collision with root package name */
    public final Supplier f17051b;

    /* renamed from: c, reason: collision with root package name */
    public final String f17052c;

    /* renamed from: d, reason: collision with root package name */
    public final NoOpCacheErrorLogger f17053d;

    /* renamed from: e, reason: collision with root package name */
    public volatile State f17054e = new State(null, null);

    @VisibleForTesting
    public static class State {

        /* renamed from: a, reason: collision with root package name */
        public final DefaultDiskStorage f17055a;

        /* renamed from: b, reason: collision with root package name */
        public final File f17056b;

        public State(DefaultDiskStorage defaultDiskStorage, File file) {
            this.f17055a = defaultDiskStorage;
            this.f17056b = file;
        }
    }

    public DynamicDefaultDiskStorage(int i2, Supplier supplier, String str, NoOpCacheErrorLogger noOpCacheErrorLogger) {
        this.f17050a = i2;
        this.f17053d = noOpCacheErrorLogger;
        this.f17051b = supplier;
        this.f17052c = str;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final void a() {
        ((DefaultDiskStorage) j()).a();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final void b() {
        try {
            ((DefaultDiskStorage) j()).b();
        } catch (IOException e2) {
            FLog.f(DynamicDefaultDiskStorage.class, "purgeUnexpectedResources", e2);
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final DiskStorage.Inserter c(String str, CacheKey cacheKey) {
        return ((DefaultDiskStorage) j()).c(str, cacheKey);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final boolean d(String str, CacheKey cacheKey) {
        return ((DefaultDiskStorage) j()).d(str, cacheKey);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final long e(DiskStorage.Entry entry) {
        return ((DefaultDiskStorage) j()).e(entry);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final BinaryResource f(String str, CacheKey cacheKey) {
        return ((DefaultDiskStorage) j()).f(str, cacheKey);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final Collection g() {
        return ((DefaultDiskStorage) j()).g();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final boolean h(String str, CacheKey cacheKey) {
        return ((DefaultDiskStorage) j()).h(str, cacheKey);
    }

    public final void i() throws FileUtils.CreateDirectoryException {
        File file = new File((File) ((DiskCacheConfig.AnonymousClass1) this.f17051b).get(), this.f17052c);
        try {
            FileUtils.a(file);
            String absolutePath = file.getAbsolutePath();
            if (FLog.f17086a.a(3)) {
                FLogDefaultLoggingDelegate.b(3, "DynamicDefaultDiskStorage", "Created cache directory " + absolutePath);
            }
            this.f17054e = new State(new DefaultDiskStorage(file, this.f17050a, this.f17053d), file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.f17053d.getClass();
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final boolean isExternal() {
        try {
            return ((DefaultDiskStorage) j()).f16997b;
        } catch (IOException unused) {
            return false;
        }
    }

    public final synchronized DiskStorage j() {
        DefaultDiskStorage defaultDiskStorage;
        File file;
        State state = this.f17054e;
        if (state.f17055a == null || (file = state.f17056b) == null || !file.exists()) {
            if (this.f17054e.f17055a != null && this.f17054e.f17056b != null) {
                FileTree.a(this.f17054e.f17056b);
            }
            i();
        }
        defaultDiskStorage = this.f17054e.f17055a;
        defaultDiskStorage.getClass();
        return defaultDiskStorage;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public final long remove(String str) {
        return ((DefaultDiskStorage) j()).remove(str);
    }
}
