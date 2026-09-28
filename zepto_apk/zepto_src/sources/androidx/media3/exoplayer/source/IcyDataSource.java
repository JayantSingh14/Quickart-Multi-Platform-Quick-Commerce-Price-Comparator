package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.ProgressiveMediaPeriod;
import androidx.media3.extractor.TrackOutput;
import java.util.Map;

/* loaded from: classes3.dex */
final class IcyDataSource implements DataSource {

    /* renamed from: a, reason: collision with root package name */
    public final DataSource f7573a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7574b;

    /* renamed from: c, reason: collision with root package name */
    public final Listener f7575c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f7576d;

    /* renamed from: e, reason: collision with root package name */
    public int f7577e;

    public interface Listener {
    }

    public IcyDataSource(DataSource dataSource, int i2, Listener listener) {
        Assertions.a(i2 > 0);
        this.f7573a = dataSource;
        this.f7574b = i2;
        this.f7575c = listener;
        this.f7576d = new byte[1];
        this.f7577e = i2;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void a(TransferListener transferListener) {
        transferListener.getClass();
        this.f7573a.a(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map c() {
        return this.f7573a.c();
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.datasource.DataSource
    public final long j(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri k() {
        return this.f7573a.k();
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i2, int i3) {
        long jMax;
        int i4 = this.f7577e;
        DataSource dataSource = this.f7573a;
        if (i4 == 0) {
            byte[] bArr2 = this.f7576d;
            int i5 = 0;
            if (dataSource.read(bArr2, 0, 1) != -1) {
                int i6 = (bArr2[0] & 255) << 4;
                if (i6 != 0) {
                    byte[] bArr3 = new byte[i6];
                    int i7 = i6;
                    while (i7 > 0) {
                        int i8 = dataSource.read(bArr3, i5, i7);
                        if (i8 != -1) {
                            i5 += i8;
                            i7 -= i8;
                        }
                    }
                    while (i6 > 0 && bArr3[i6 - 1] == 0) {
                        i6--;
                    }
                    if (i6 > 0) {
                        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr3, i6);
                        ProgressiveMediaPeriod.ExtractingLoadable extractingLoadable = (ProgressiveMediaPeriod.ExtractingLoadable) this.f7575c;
                        if (extractingLoadable.f7660m) {
                            Map map = ProgressiveMediaPeriod.X;
                            jMax = Math.max(ProgressiveMediaPeriod.this.v(true), extractingLoadable.f7657j);
                        } else {
                            jMax = extractingLoadable.f7657j;
                        }
                        long j2 = jMax;
                        int iA = parsableByteArray.a();
                        TrackOutput trackOutput = extractingLoadable.f7659l;
                        trackOutput.getClass();
                        trackOutput.e(iA, parsableByteArray);
                        trackOutput.f(j2, 1, iA, 0, null);
                        extractingLoadable.f7660m = true;
                    }
                }
                this.f7577e = this.f7574b;
            }
            return -1;
        }
        int i9 = dataSource.read(bArr, i2, Math.min(this.f7577e, i3));
        if (i9 != -1) {
            this.f7577e -= i9;
        }
        return i9;
    }
}
