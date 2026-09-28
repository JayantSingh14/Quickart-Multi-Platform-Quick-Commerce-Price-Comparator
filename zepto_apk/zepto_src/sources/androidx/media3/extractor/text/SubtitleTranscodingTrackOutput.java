package androidx.media3.extractor.text;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;

/* loaded from: classes3.dex */
final class SubtitleTranscodingTrackOutput implements TrackOutput {

    /* renamed from: a, reason: collision with root package name */
    public final TrackOutput f9189a;

    /* renamed from: b, reason: collision with root package name */
    public final SubtitleParser.Factory f9190b;

    /* renamed from: h, reason: collision with root package name */
    public SubtitleParser f9196h;

    /* renamed from: i, reason: collision with root package name */
    public Format f9197i;

    /* renamed from: c, reason: collision with root package name */
    public final CueEncoder f9191c = new CueEncoder();

    /* renamed from: e, reason: collision with root package name */
    public int f9193e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f9194f = 0;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f9195g = Util.f5749f;

    /* renamed from: d, reason: collision with root package name */
    public final ParsableByteArray f9192d = new ParsableByteArray();

    public SubtitleTranscodingTrackOutput(TrackOutput trackOutput, SubtitleParser.Factory factory) {
        this.f9189a = trackOutput;
        this.f9190b = factory;
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void a(ParsableByteArray parsableByteArray, int i2, int i3) {
        if (this.f9196h == null) {
            this.f9189a.a(parsableByteArray, i2, i3);
            return;
        }
        g(i2);
        parsableByteArray.h(this.f9194f, this.f9195g, i2);
        this.f9194f += i2;
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void b(Format format) {
        format.f5225m.getClass();
        String str = format.f5225m;
        Assertions.a(MimeTypes.i(str) == 3);
        boolean zEquals = format.equals(this.f9197i);
        SubtitleParser.Factory factory = this.f9190b;
        if (!zEquals) {
            this.f9197i = format;
            this.f9196h = factory.b(format) ? factory.c(format) : null;
        }
        SubtitleParser subtitleParser = this.f9196h;
        TrackOutput trackOutput = this.f9189a;
        if (subtitleParser == null) {
            trackOutput.b(format);
            return;
        }
        Format.Builder builderA = format.a();
        builderA.f5237l = MimeTypes.p("application/x-media3-cues");
        builderA.f5234i = str;
        builderA.q = Long.MAX_VALUE;
        builderA.F = factory.a(format);
        android.support.v4.media.a.s(builderA, trackOutput);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final int d(DataReader dataReader, int i2, boolean z) throws EOFException {
        if (this.f9196h == null) {
            return this.f9189a.d(dataReader, i2, z);
        }
        g(i2);
        int i3 = dataReader.read(this.f9195g, this.f9194f, i2);
        if (i3 != -1) {
            this.f9194f += i3;
            return i3;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void f(final long j2, final int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
        if (this.f9196h == null) {
            this.f9189a.f(j2, i2, i3, i4, cryptoData);
            return;
        }
        Assertions.b(cryptoData == null, "DRM on subtitles is not supported");
        int i5 = (this.f9194f - i4) - i3;
        this.f9196h.b(this.f9195g, i5, i3, SubtitleParser.OutputOptions.f9180c, new Consumer() { // from class: androidx.media3.extractor.text.b
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                CuesWithTiming cuesWithTiming = (CuesWithTiming) obj;
                SubtitleTranscodingTrackOutput subtitleTranscodingTrackOutput = this.f9200a;
                Assertions.h(subtitleTranscodingTrackOutput.f9197i);
                ImmutableList immutableList = cuesWithTiming.f9155a;
                subtitleTranscodingTrackOutput.f9191c.getClass();
                byte[] bArrA = CueEncoder.a(immutableList, cuesWithTiming.f9157c);
                ParsableByteArray parsableByteArray = subtitleTranscodingTrackOutput.f9192d;
                parsableByteArray.getClass();
                parsableByteArray.H(bArrA.length, bArrA);
                subtitleTranscodingTrackOutput.f9189a.e(bArrA.length, parsableByteArray);
                long j3 = cuesWithTiming.f9156b;
                long j4 = j2;
                if (j3 == -9223372036854775807L) {
                    Assertions.g(subtitleTranscodingTrackOutput.f9197i.r == Long.MAX_VALUE);
                } else {
                    long j5 = subtitleTranscodingTrackOutput.f9197i.r;
                    j4 = j5 == Long.MAX_VALUE ? j4 + j3 : j3 + j5;
                }
                subtitleTranscodingTrackOutput.f9189a.f(j4, i2, bArrA.length, 0, null);
            }
        });
        int i6 = i5 + i3;
        this.f9193e = i6;
        if (i6 == this.f9194f) {
            this.f9193e = 0;
            this.f9194f = 0;
        }
    }

    public final void g(int i2) {
        int length = this.f9195g.length;
        int i3 = this.f9194f;
        if (length - i3 >= i2) {
            return;
        }
        int i4 = i3 - this.f9193e;
        int iMax = Math.max(i4 * 2, i2 + i4);
        byte[] bArr = this.f9195g;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.f9193e, bArr2, 0, i4);
        this.f9193e = 0;
        this.f9194f = i4;
        this.f9195g = bArr2;
    }
}
