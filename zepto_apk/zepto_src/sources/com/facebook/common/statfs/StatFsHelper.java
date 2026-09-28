package com.facebook.common.statfs;

import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.Throwables;
import com.facebook.infer.annotation.Nullsafe;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class StatFsHelper {

    /* renamed from: h, reason: collision with root package name */
    public static StatFsHelper f17120h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f17121i = TimeUnit.MINUTES.toMillis(2);

    /* renamed from: b, reason: collision with root package name */
    public volatile File f17123b;

    /* renamed from: d, reason: collision with root package name */
    public volatile File f17125d;

    /* renamed from: e, reason: collision with root package name */
    public long f17126e;

    /* renamed from: a, reason: collision with root package name */
    public volatile StatFs f17122a = null;

    /* renamed from: c, reason: collision with root package name */
    public volatile StatFs f17124c = null;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f17128g = false;

    /* renamed from: f, reason: collision with root package name */
    public final ReentrantLock f17127f = new ReentrantLock();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class StorageType {

        /* renamed from: a, reason: collision with root package name */
        public static final StorageType f17129a;

        /* renamed from: b, reason: collision with root package name */
        public static final StorageType f17130b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ StorageType[] f17131c;

        static {
            StorageType storageType = new StorageType("INTERNAL", 0);
            f17129a = storageType;
            StorageType storageType2 = new StorageType("EXTERNAL", 1);
            f17130b = storageType2;
            f17131c = new StorageType[]{storageType, storageType2};
        }

        public static StorageType valueOf(String str) {
            return (StorageType) Enum.valueOf(StorageType.class, str);
        }

        public static StorageType[] values() {
            return (StorageType[]) f17131c.clone();
        }
    }

    public static StatFs b(StatFs statFs, File file) throws Throwable {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            if (statFs == null) {
                return new StatFs(file.getAbsolutePath());
            }
            statFs.restat(file.getAbsolutePath());
            return statFs;
        } catch (IllegalArgumentException unused) {
            return null;
        } catch (Throwable th) {
            Throwables.b(th);
            throw new RuntimeException(th);
        }
    }

    public final void a() {
        if (this.f17128g) {
            return;
        }
        this.f17127f.lock();
        try {
            if (!this.f17128g) {
                this.f17123b = Environment.getDataDirectory();
                this.f17125d = Environment.getExternalStorageDirectory();
                this.f17122a = b(this.f17122a, this.f17123b);
                this.f17124c = b(this.f17124c, this.f17125d);
                this.f17126e = SystemClock.uptimeMillis();
                this.f17128g = true;
            }
        } finally {
            this.f17127f.unlock();
        }
    }
}
