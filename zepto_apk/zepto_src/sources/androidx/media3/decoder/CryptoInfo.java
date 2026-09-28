package androidx.media3.decoder;

import android.media.MediaCodec;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class CryptoInfo {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f6057a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f6058b;

    /* renamed from: c, reason: collision with root package name */
    public int f6059c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f6060d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f6061e;

    /* renamed from: f, reason: collision with root package name */
    public int f6062f;

    /* renamed from: g, reason: collision with root package name */
    public int f6063g;

    /* renamed from: h, reason: collision with root package name */
    public int f6064h;

    /* renamed from: i, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f6065i;

    /* renamed from: j, reason: collision with root package name */
    public final PatternHolderV24 f6066j;

    @RequiresApi
    public static final class PatternHolderV24 {

        /* renamed from: a, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f6067a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f6068b = new MediaCodec.CryptoInfo.Pattern(0, 0);

        public PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.f6067a = cryptoInfo;
        }
    }

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f6065i = cryptoInfo;
        this.f6066j = Util.f5744a >= 24 ? new PatternHolderV24(cryptoInfo) : null;
    }

    public final void a(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        this.f6062f = i2;
        this.f6060d = iArr;
        this.f6061e = iArr2;
        this.f6058b = bArr;
        this.f6057a = bArr2;
        this.f6059c = i3;
        this.f6063g = i4;
        this.f6064h = i5;
        MediaCodec.CryptoInfo cryptoInfo = this.f6065i;
        cryptoInfo.numSubSamples = i2;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i3;
        if (Util.f5744a >= 24) {
            PatternHolderV24 patternHolderV24 = this.f6066j;
            patternHolderV24.getClass();
            MediaCodec.CryptoInfo.Pattern pattern = patternHolderV24.f6068b;
            pattern.set(i4, i5);
            patternHolderV24.f6067a.setPattern(pattern);
        }
    }
}
