package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* loaded from: classes3.dex */
public final class FileLocker implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final FileOutputStream f20276a;

    /* renamed from: b, reason: collision with root package name */
    public final FileLock f20277b;

    public FileLocker(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.f20276a = fileOutputStream;
        try {
            FileLock fileLockLock = fileOutputStream.getChannel().lock();
            if (fileLockLock == null) {
                fileOutputStream.close();
            }
            this.f20277b = fileLockLock;
        } catch (Throwable th) {
            this.f20276a.close();
            throw th;
        }
    }

    public static FileLocker a(File file) {
        return new FileLocker(file);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        FileOutputStream fileOutputStream = this.f20276a;
        try {
            FileLock fileLock = this.f20277b;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            fileOutputStream.close();
        }
    }
}
