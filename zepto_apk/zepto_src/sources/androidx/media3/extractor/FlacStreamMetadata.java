package androidx.media3.extractor;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Collections;

@UnstableApi
/* loaded from: classes3.dex */
public final class FlacStreamMetadata {

    /* renamed from: a, reason: collision with root package name */
    public final int f8551a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8552b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8553c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8554d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8555e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8556f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8557g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8558h;

    /* renamed from: i, reason: collision with root package name */
    public final int f8559i;

    /* renamed from: j, reason: collision with root package name */
    public final long f8560j;

    /* renamed from: k, reason: collision with root package name */
    public final SeekTable f8561k;

    /* renamed from: l, reason: collision with root package name */
    public final Metadata f8562l;

    public static class SeekTable {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f8563a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f8564b;

        public SeekTable(long[] jArr, long[] jArr2) {
            this.f8563a = jArr;
            this.f8564b = jArr2;
        }
    }

    public FlacStreamMetadata(byte[] bArr, int i2) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, bArr.length);
        parsableBitArray.m(i2 * 8);
        this.f8551a = parsableBitArray.g(16);
        this.f8552b = parsableBitArray.g(16);
        this.f8553c = parsableBitArray.g(24);
        this.f8554d = parsableBitArray.g(24);
        int iG = parsableBitArray.g(20);
        this.f8555e = iG;
        this.f8556f = d(iG);
        this.f8557g = parsableBitArray.g(3) + 1;
        int iG2 = parsableBitArray.g(5) + 1;
        this.f8558h = iG2;
        this.f8559i = a(iG2);
        this.f8560j = parsableBitArray.i(36);
        this.f8561k = null;
        this.f8562l = null;
    }

    public static int a(int i2) {
        if (i2 == 8) {
            return 1;
        }
        if (i2 == 12) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 != 20) {
            return i2 != 24 ? -1 : 6;
        }
        return 5;
    }

    public static int d(int i2) {
        switch (i2) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long b() {
        long j2 = this.f8560j;
        if (j2 == 0) {
            return -9223372036854775807L;
        }
        return (j2 * 1000000) / this.f8555e;
    }

    public final Format c(byte[] bArr, Metadata metadata) {
        bArr[4] = -128;
        int i2 = this.f8554d;
        if (i2 <= 0) {
            i2 = -1;
        }
        Metadata metadata2 = this.f8562l;
        if (metadata2 != null) {
            metadata = metadata2.b(metadata);
        }
        Format.Builder builder = new Format.Builder();
        builder.f5237l = MimeTypes.p("audio/flac");
        builder.f5238m = i2;
        builder.z = this.f8557g;
        builder.A = this.f8555e;
        builder.B = Util.B(this.f8558h);
        builder.o = Collections.singletonList(bArr);
        builder.f5235j = metadata;
        return new Format(builder);
    }

    public FlacStreamMetadata(int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, SeekTable seekTable, Metadata metadata) {
        this.f8551a = i2;
        this.f8552b = i3;
        this.f8553c = i4;
        this.f8554d = i5;
        this.f8555e = i6;
        this.f8556f = d(i6);
        this.f8557g = i7;
        this.f8558h = i8;
        this.f8559i = a(i8);
        this.f8560j = j2;
        this.f8561k = seekTable;
        this.f8562l = metadata;
    }
}
