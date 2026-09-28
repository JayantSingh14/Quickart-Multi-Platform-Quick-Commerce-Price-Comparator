package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSourceUtil;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class DataChunk extends Chunk {

    /* renamed from: j, reason: collision with root package name */
    public byte[] f7884j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f7885k;

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void a() {
        try {
            this.f7863i.j(this.f7856b);
            int i2 = 0;
            int i3 = 0;
            while (i2 != -1 && !this.f7885k) {
                byte[] bArr = this.f7884j;
                if (bArr.length < i3 + 16384) {
                    this.f7884j = Arrays.copyOf(bArr, bArr.length + 16384);
                }
                i2 = this.f7863i.read(this.f7884j, i3, 16384);
                if (i2 != -1) {
                    i3 += i2;
                }
            }
            if (!this.f7885k) {
                c(i3, this.f7884j);
            }
            DataSourceUtil.a(this.f7863i);
        } catch (Throwable th) {
            DataSourceUtil.a(this.f7863i);
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.Loadable
    public final void b() {
        this.f7885k = true;
    }

    public abstract void c(int i2, byte[] bArr);
}
