package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
@Deprecated
/* loaded from: classes3.dex */
public final class DummyTrackOutput implements TrackOutput {

    /* renamed from: a, reason: collision with root package name */
    public final DiscardingTrackOutput f8546a = new DiscardingTrackOutput();

    @Override // androidx.media3.extractor.TrackOutput
    public final void a(ParsableByteArray parsableByteArray, int i2, int i3) {
        this.f8546a.getClass();
        parsableByteArray.K(i2);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void b(Format format) {
        this.f8546a.getClass();
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final int c(DataReader dataReader, int i2, boolean z) {
        return this.f8546a.d(dataReader, i2, z);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final int d(DataReader dataReader, int i2, boolean z) {
        return this.f8546a.d(dataReader, i2, z);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void e(int i2, ParsableByteArray parsableByteArray) {
        this.f8546a.getClass();
        parsableByteArray.K(i2);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
        this.f8546a.getClass();
    }
}
