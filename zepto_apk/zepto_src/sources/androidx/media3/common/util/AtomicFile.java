package androidx.media3.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@UnstableApi
/* loaded from: classes3.dex */
public final class AtomicFile {

    /* renamed from: a, reason: collision with root package name */
    public final File f5658a;

    /* renamed from: b, reason: collision with root package name */
    public final File f5659b;

    public static final class AtomicFileOutputStream extends OutputStream implements AutoCloseable {

        /* renamed from: a, reason: collision with root package name */
        public final FileOutputStream f5660a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5661b = false;

        public AtomicFileOutputStream(File file) {
            this.f5660a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            FileOutputStream fileOutputStream = this.f5660a;
            if (this.f5661b) {
                return;
            }
            this.f5661b = true;
            flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e2) {
                Log.i("AtomicFile", "Failed to sync file descriptor:", e2);
            }
            fileOutputStream.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() throws IOException {
            this.f5660a.flush();
        }

        @Override // java.io.OutputStream
        public final void write(int i2) throws IOException {
            this.f5660a.write(i2);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            this.f5660a.write(bArr);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i2, int i3) throws IOException {
            this.f5660a.write(bArr, i2, i3);
        }
    }

    public AtomicFile(File file) {
        this.f5658a = file;
        this.f5659b = new File(file.getPath() + ".bak");
    }

    public final OutputStream a() throws IOException {
        File file = this.f5658a;
        if (file.exists()) {
            File file2 = this.f5659b;
            if (file2.exists()) {
                file.delete();
            } else if (!file.renameTo(file2)) {
                Log.h("AtomicFile", "Couldn't rename file " + file + " to backup file " + file2);
            }
        }
        try {
            return new AtomicFileOutputStream(file);
        } catch (FileNotFoundException e2) {
            File parentFile = file.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + file, e2);
            }
            try {
                return new AtomicFileOutputStream(file);
            } catch (FileNotFoundException e3) {
                throw new IOException("Couldn't create " + file, e3);
            }
        }
    }
}
