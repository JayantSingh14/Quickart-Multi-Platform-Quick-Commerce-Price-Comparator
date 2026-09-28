package okio;

import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class JvmFileHandle extends FileHandle {

    /* renamed from: e, reason: collision with root package name */
    public final RandomAccessFile f56963e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmFileHandle(boolean z, RandomAccessFile randomAccessFile) {
        super(z);
        Intrinsics.checkNotNullParameter(randomAccessFile, "randomAccessFile");
        this.f56963e = randomAccessFile;
    }

    @Override // okio.FileHandle
    public final synchronized void a() {
        this.f56963e.close();
    }

    @Override // okio.FileHandle
    public final synchronized void b() {
        this.f56963e.getFD().sync();
    }

    @Override // okio.FileHandle
    public final synchronized int c(long j2, byte[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f56963e.seek(j2);
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int i5 = this.f56963e.read(array, i2, i3 - i4);
            if (i5 != -1) {
                i4 += i5;
            } else if (i4 == 0) {
                return -1;
            }
        }
        return i4;
    }

    @Override // okio.FileHandle
    public final synchronized long e() {
        return this.f56963e.length();
    }

    @Override // okio.FileHandle
    public final synchronized void l(long j2, byte[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f56963e.seek(j2);
        this.f56963e.write(array, i2, i3);
    }
}
