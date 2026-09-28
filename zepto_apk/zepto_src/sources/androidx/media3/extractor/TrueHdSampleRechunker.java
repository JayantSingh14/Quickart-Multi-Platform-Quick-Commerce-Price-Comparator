package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.TrackOutput;

@UnstableApi
/* loaded from: classes3.dex */
public final class TrueHdSampleRechunker {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8618a = new byte[10];

    /* renamed from: b, reason: collision with root package name */
    public boolean f8619b;

    /* renamed from: c, reason: collision with root package name */
    public int f8620c;

    /* renamed from: d, reason: collision with root package name */
    public long f8621d;

    /* renamed from: e, reason: collision with root package name */
    public int f8622e;

    /* renamed from: f, reason: collision with root package name */
    public int f8623f;

    /* renamed from: g, reason: collision with root package name */
    public int f8624g;

    public final void a(TrackOutput trackOutput, TrackOutput.CryptoData cryptoData) {
        if (this.f8620c > 0) {
            trackOutput.f(this.f8621d, this.f8622e, this.f8623f, this.f8624g, cryptoData);
            this.f8620c = 0;
        }
    }

    public final void b(TrackOutput trackOutput, long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
        Assertions.f("TrueHD chunk samples must be contiguous in the sample queue.", this.f8624g <= i3 + i4);
        if (this.f8619b) {
            int i5 = this.f8620c;
            int i6 = i5 + 1;
            this.f8620c = i6;
            if (i5 == 0) {
                this.f8621d = j2;
                this.f8622e = i2;
                this.f8623f = 0;
            }
            this.f8623f += i3;
            this.f8624g = i4;
            if (i6 >= 16) {
                a(trackOutput, cryptoData);
            }
        }
    }

    public final void c(ExtractorInput extractorInput) {
        if (this.f8619b) {
            return;
        }
        byte[] bArr = this.f8618a;
        int i2 = 0;
        extractorInput.f(0, bArr, 10);
        extractorInput.d();
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b2 = bArr[7];
            if ((b2 & 254) == 186) {
                i2 = 40 << ((bArr[(b2 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        if (i2 == 0) {
            return;
        }
        this.f8619b = true;
    }
}
