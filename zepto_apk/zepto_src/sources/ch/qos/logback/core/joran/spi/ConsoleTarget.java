package ch.qos.logback.core.joran.spi;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public enum ConsoleTarget {
    SystemOut("System.out", new AnonymousClass1()),
    /* JADX INFO: Fake field, exist only in values array */
    SystemErr("System.err", new AnonymousClass2());


    /* renamed from: a, reason: collision with root package name */
    public final String f13553a;

    /* renamed from: b, reason: collision with root package name */
    public final OutputStream f13554b;

    /* renamed from: ch.qos.logback.core.joran.spi.ConsoleTarget$1, reason: invalid class name */
    public static class AnonymousClass1 extends OutputStream {
        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() {
            System.out.flush();
        }

        @Override // java.io.OutputStream
        public final void write(int i2) {
            System.out.write(i2);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            System.out.write(bArr);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i2, int i3) {
            System.out.write(bArr, i2, i3);
        }
    }

    /* renamed from: ch.qos.logback.core.joran.spi.ConsoleTarget$2, reason: invalid class name */
    public static class AnonymousClass2 extends OutputStream {
        @Override // java.io.OutputStream, java.io.Flushable
        public final void flush() {
            System.err.flush();
        }

        @Override // java.io.OutputStream
        public final void write(int i2) {
            System.err.write(i2);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            System.err.write(bArr);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i2, int i3) {
            System.err.write(bArr, i2, i3);
        }
    }

    ConsoleTarget(String str, OutputStream outputStream) {
        this.f13553a = str;
        this.f13554b = outputStream;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f13553a;
    }
}
