package androidx.sqlite.util;

import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@RestrictTo
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ProcessLock {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f11940e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11941a;

    /* renamed from: b, reason: collision with root package name */
    public final File f11942b;

    /* renamed from: c, reason: collision with root package name */
    public final Lock f11943c;

    /* renamed from: d, reason: collision with root package name */
    public FileChannel f11944d;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    public ProcessLock(String name, File file, boolean z) {
        Lock lock;
        Intrinsics.checkNotNullParameter(name, "name");
        this.f11941a = z;
        this.f11942b = file != null ? new File(file, b.k(name, ".lck")) : null;
        HashMap map = f11940e;
        synchronized (map) {
            try {
                Object reentrantLock = map.get(name);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(name, reentrantLock);
                }
                lock = (Lock) reentrantLock;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f11943c = lock;
    }

    public final void a(boolean z) throws IOException {
        this.f11943c.lock();
        if (z) {
            File file = this.f11942b;
            try {
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.f11944d = channel;
            } catch (IOException e2) {
                this.f11944d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e2);
            }
        }
    }

    public final void b() throws IOException {
        try {
            FileChannel fileChannel = this.f11944d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f11943c.unlock();
    }
}
