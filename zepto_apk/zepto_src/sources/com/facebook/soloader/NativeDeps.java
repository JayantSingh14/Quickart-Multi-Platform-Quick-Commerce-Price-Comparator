package com.facebook.soloader;

import android.os.StrictMode;
import android.os.Trace;
import android.support.v4.media.b;
import android.util.Log;
import com.facebook.soloader.MinElf;
import com.facebook.soloader.observer.Observer;
import com.facebook.soloader.observer.ObserverHolder;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class NativeDeps {

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f20281b = false;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f20282c = false;

    /* renamed from: e, reason: collision with root package name */
    public static final HashSet f20284e;

    /* renamed from: a, reason: collision with root package name */
    public static final int f20280a = 3 + 3;

    /* renamed from: d, reason: collision with root package name */
    public static final ReentrantReadWriteLock f20283d = new ReentrantReadWriteLock();

    /* renamed from: com.facebook.soloader.NativeDeps$1, reason: invalid class name */
    public class AnonymousClass1 extends HashSet<String> {
    }

    /* renamed from: com.facebook.soloader.NativeDeps$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            NativeDeps.f20283d.writeLock().lock();
            NativeDeps.f20282c = true;
            try {
                try {
                    NativeDeps.d();
                    throw null;
                } catch (IOException unused) {
                    Log.w("NativeDeps", "Failed to extract native deps from APK, falling back to using MinElf to get library dependencies.");
                    ReentrantReadWriteLock reentrantReadWriteLock = NativeDeps.f20283d;
                    int readLockCount = reentrantReadWriteLock.getReadLockCount();
                    if (readLockCount >= 3) {
                        Log.w("NativeDeps", "NativeDeps initialization finished with " + Integer.toString(readLockCount) + " threads waiting.");
                    }
                    reentrantReadWriteLock.writeLock().unlock();
                    NativeDeps.f20282c = false;
                }
            } catch (Throwable th) {
                ReentrantReadWriteLock reentrantReadWriteLock2 = NativeDeps.f20283d;
                int readLockCount2 = reentrantReadWriteLock2.getReadLockCount();
                if (readLockCount2 >= 3) {
                    Log.w("NativeDeps", "NativeDeps initialization finished with " + Integer.toString(readLockCount2) + " threads waiting.");
                }
                reentrantReadWriteLock2.writeLock().unlock();
                NativeDeps.f20282c = false;
                throw th;
            }
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        anonymousClass1.add("libEGL.so");
        anonymousClass1.add("libGLESv2.so");
        anonymousClass1.add("libGLESv3.so");
        anonymousClass1.add("libOpenSLES.so");
        anonymousClass1.add("libandroid.so");
        anonymousClass1.add("libc.so");
        anonymousClass1.add("libdl.so");
        anonymousClass1.add("libjnigraphics.so");
        anonymousClass1.add("liblog.so");
        anonymousClass1.add("libm.so");
        anonymousClass1.add("libstdc++.so");
        anonymousClass1.add("libz.so");
        f20284e = anonymousClass1;
    }

    public static String[] a(String str) {
        if (f20281b) {
            return f(str);
        }
        if (!f20282c) {
            return null;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f20283d;
        reentrantReadWriteLock.readLock().lock();
        try {
            String[] strArrF = f(str);
            reentrantReadWriteLock.readLock().unlock();
            return strArrF;
        } catch (Throwable th) {
            f20283d.readLock().unlock();
            throw th;
        }
    }

    public static String[] b(String str, ElfByteChannel elfByteChannel) {
        if (SoLoader.f20285a) {
            Api18TraceUtils.a("soloader.NativeDeps.getDependencies[", str, "]");
        }
        Observer[] observerArr = (Observer[]) ObserverHolder.f20309a.get();
        if (observerArr != null) {
            for (Observer observer : observerArr) {
                observer.g();
            }
        }
        try {
            try {
                try {
                    String[] strArrA = a(str);
                    if (strArrA != null) {
                        return strArrA;
                    }
                    String[] strArrA2 = MinElf.a(elfByteChannel);
                    ObserverHolder.a(null);
                    if (SoLoader.f20285a) {
                        Trace.endSection();
                    }
                    return strArrA2;
                } catch (MinElf.ElfError e2) {
                    throw SoLoaderULErrorFactory.a(str, e2);
                }
            } catch (Error | RuntimeException e3) {
                throw e3;
            }
        } finally {
            ObserverHolder.a(null);
            if (SoLoader.f20285a) {
                Trace.endSection();
            }
        }
    }

    public static String c(int i2) {
        throw null;
    }

    public static boolean d() {
        if (f20281b) {
            synchronized (NativeDeps.class) {
                try {
                    if (f20281b) {
                        throw new IllegalStateException("Trying to initialize NativeDeps but it was already initialized");
                    }
                } finally {
                }
            }
        }
        NativeDepsUnpacker.a();
        throw null;
    }

    public static void e(String str, ElfFileChannel elfFileChannel, int i2, StrictMode.ThreadPolicy threadPolicy) {
        String[] strArrB = b(str, elfFileChannel);
        StringBuilder sbY = b.y("Loading ", str, "'s dependencies: ");
        sbY.append(Arrays.toString(strArrB));
        LogUtil.a(sbY.toString());
        for (String str2 : strArrB) {
            if (!str2.startsWith("/") && !f20284e.contains(str2)) {
                SoLoader.l(str2, i2, threadPolicy);
            }
        }
    }

    public static String[] f(String str) {
        if (!f20281b || str.length() <= f20280a) {
            return null;
        }
        for (int i2 = 3; i2 < str.length() - 3; i2++) {
            str.codePointAt(i2);
        }
        throw null;
    }
}
