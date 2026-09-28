package okio;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class NioFileSystemFileHandle extends FileHandle {

    /* renamed from: e, reason: collision with root package name */
    public final FileChannel f56964e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NioFileSystemFileHandle(boolean z, FileChannel fileChannel) {
        super(z);
        Intrinsics.checkNotNullParameter(fileChannel, "fileChannel");
        this.f56964e = fileChannel;
    }

    @Override // okio.FileHandle
    public final synchronized void a() {
        this.f56964e.close();
    }

    @Override // okio.FileHandle
    public final synchronized void b() {
        this.f56964e.force(true);
    }

    @Override // okio.FileHandle
    public final synchronized int c(long j2, byte[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f56964e.position(j2);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(array, i2, i3);
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int i5 = this.f56964e.read(byteBufferWrap);
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
        return this.f56964e.size();
    }

    @Override // okio.FileHandle
    public final synchronized void l(long j2, byte[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.f56964e.position(j2);
        this.f56964e.write(ByteBuffer.wrap(array, i2, i3));
    }
}
