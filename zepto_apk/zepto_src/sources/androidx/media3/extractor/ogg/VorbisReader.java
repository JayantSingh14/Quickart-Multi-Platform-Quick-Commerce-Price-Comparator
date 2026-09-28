package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.VorbisBitArray;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.ogg.StreamReader;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class VorbisReader extends StreamReader {
    public VorbisSetup n;
    public int o;
    public boolean p;
    public VorbisUtil.VorbisIdHeader q;
    public VorbisUtil.CommentHeader r;

    public static final class VorbisSetup {

        /* renamed from: a, reason: collision with root package name */
        public final VorbisUtil.VorbisIdHeader f9149a;

        /* renamed from: b, reason: collision with root package name */
        public final VorbisUtil.CommentHeader f9150b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f9151c;

        /* renamed from: d, reason: collision with root package name */
        public final VorbisUtil.Mode[] f9152d;

        /* renamed from: e, reason: collision with root package name */
        public final int f9153e;

        public VorbisSetup(VorbisUtil.VorbisIdHeader vorbisIdHeader, VorbisUtil.CommentHeader commentHeader, byte[] bArr, VorbisUtil.Mode[] modeArr, int i2) {
            this.f9149a = vorbisIdHeader;
            this.f9150b = commentHeader;
            this.f9151c = bArr;
            this.f9152d = modeArr;
            this.f9153e = i2;
        }
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final void a(long j2) {
        this.f9140g = j2;
        this.p = j2 != 0;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.q;
        this.o = vorbisIdHeader != null ? vorbisIdHeader.f8635e : 0;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final long b(ParsableByteArray parsableByteArray) {
        byte b2 = parsableByteArray.f5723a[0];
        if ((b2 & 1) == 1) {
            return -1L;
        }
        VorbisSetup vorbisSetup = this.n;
        Assertions.h(vorbisSetup);
        boolean z = vorbisSetup.f9152d[(b2 >> 1) & (255 >>> (8 - vorbisSetup.f9153e))].f8630a;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = vorbisSetup.f9149a;
        int i2 = !z ? vorbisIdHeader.f8635e : vorbisIdHeader.f8636f;
        long j2 = this.p ? (this.o + i2) / 4 : 0;
        byte[] bArr = parsableByteArray.f5723a;
        int length = bArr.length;
        int i3 = parsableByteArray.f5725c + 4;
        if (length < i3) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
            parsableByteArray.H(bArrCopyOf.length, bArrCopyOf);
        } else {
            parsableByteArray.I(i3);
        }
        byte[] bArr2 = parsableByteArray.f5723a;
        int i4 = parsableByteArray.f5725c;
        bArr2[i4 - 4] = (byte) (j2 & 255);
        bArr2[i4 - 3] = (byte) ((j2 >>> 8) & 255);
        bArr2[i4 - 2] = (byte) ((j2 >>> 16) & 255);
        bArr2[i4 - 1] = (byte) ((j2 >>> 24) & 255);
        this.p = true;
        this.o = i2;
        return j2;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final boolean c(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) throws ParserException {
        VorbisSetup vorbisSetup;
        int i2;
        if (this.n != null) {
            setupData.f9147a.getClass();
            return false;
        }
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.q;
        int i3 = 1;
        int i4 = 4;
        if (vorbisIdHeader == null) {
            VorbisUtil.d(1, parsableByteArray, false);
            parsableByteArray.p();
            int iX = parsableByteArray.x();
            int iP = parsableByteArray.p();
            int iL = parsableByteArray.l();
            int i5 = iL <= 0 ? -1 : iL;
            int iL2 = parsableByteArray.l();
            int i6 = iL2 <= 0 ? -1 : iL2;
            parsableByteArray.l();
            int iX2 = parsableByteArray.x();
            int iPow = (int) Math.pow(2.0d, iX2 & 15);
            int iPow2 = (int) Math.pow(2.0d, (iX2 & 240) >> 4);
            parsableByteArray.x();
            this.q = new VorbisUtil.VorbisIdHeader(Arrays.copyOf(parsableByteArray.f5723a, parsableByteArray.f5725c), iX, iP, i5, i6, iPow, iPow2);
        } else {
            VorbisUtil.CommentHeader commentHeader = this.r;
            if (commentHeader == null) {
                this.r = VorbisUtil.c(parsableByteArray, true, true);
            } else {
                int i7 = parsableByteArray.f5725c;
                byte[] bArr = new byte[i7];
                System.arraycopy(parsableByteArray.f5723a, 0, bArr, 0, i7);
                int i8 = 5;
                VorbisUtil.d(5, parsableByteArray, false);
                int iX3 = parsableByteArray.x() + 1;
                VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.f5723a);
                int i9 = 8;
                vorbisBitArray.c(parsableByteArray.f5724b * 8);
                int i10 = 0;
                while (true) {
                    int i11 = 2;
                    int i12 = 16;
                    if (i10 < iX3) {
                        int i13 = i9;
                        if (vorbisBitArray.b(24) != 5653314) {
                            throw ParserException.a(null, "expected code book to start with [0x56, 0x43, 0x42] at " + ((vorbisBitArray.f8627c * 8) + vorbisBitArray.f8628d));
                        }
                        int iB = vorbisBitArray.b(16);
                        int iB2 = vorbisBitArray.b(24);
                        if (vorbisBitArray.a()) {
                            vorbisBitArray.c(5);
                            for (int iB3 = 0; iB3 < iB2; iB3 += vorbisBitArray.b(VorbisUtil.a(iB2 - iB3))) {
                            }
                        } else {
                            boolean zA = vorbisBitArray.a();
                            for (int i14 = 0; i14 < iB2; i14++) {
                                if (!zA) {
                                    vorbisBitArray.c(5);
                                } else if (vorbisBitArray.a()) {
                                    vorbisBitArray.c(5);
                                }
                            }
                        }
                        int iB4 = vorbisBitArray.b(4);
                        if (iB4 > 2) {
                            throw ParserException.a(null, "lookup type greater than 2 not decodable: " + iB4);
                        }
                        if (iB4 == 1 || iB4 == 2) {
                            vorbisBitArray.c(32);
                            vorbisBitArray.c(32);
                            int iB5 = vorbisBitArray.b(4) + 1;
                            vorbisBitArray.c(1);
                            vorbisBitArray.c((int) ((iB4 == 1 ? iB != 0 ? (long) Math.floor(Math.pow(iB2, 1.0d / iB)) : 0L : iB * iB2) * iB5));
                        }
                        i10++;
                        i9 = i13;
                    } else {
                        int i15 = i9;
                        int i16 = 6;
                        int iB6 = vorbisBitArray.b(6) + 1;
                        for (int i17 = 0; i17 < iB6; i17++) {
                            if (vorbisBitArray.b(16) != 0) {
                                throw ParserException.a(null, "placeholder of time domain transforms not zeroed out");
                            }
                        }
                        int iB7 = vorbisBitArray.b(6) + 1;
                        int i18 = 0;
                        while (true) {
                            int i19 = 3;
                            if (i18 < iB7) {
                                int iB8 = vorbisBitArray.b(i12);
                                if (iB8 == 0) {
                                    int i20 = i15;
                                    i2 = i3;
                                    vorbisBitArray.c(i20);
                                    vorbisBitArray.c(16);
                                    vorbisBitArray.c(16);
                                    vorbisBitArray.c(6);
                                    vorbisBitArray.c(i20);
                                    int iB9 = vorbisBitArray.b(4) + 1;
                                    int i21 = 0;
                                    while (i21 < iB9) {
                                        vorbisBitArray.c(i20);
                                        i21++;
                                        i20 = 8;
                                    }
                                } else {
                                    if (iB8 != i3) {
                                        throw ParserException.a(null, "floor type greater than 1 not decodable: " + iB8);
                                    }
                                    int iB10 = vorbisBitArray.b(i8);
                                    i2 = i3;
                                    int[] iArr = new int[iB10];
                                    int i22 = -1;
                                    for (int i23 = 0; i23 < iB10; i23++) {
                                        int iB11 = vorbisBitArray.b(i4);
                                        iArr[i23] = iB11;
                                        if (iB11 > i22) {
                                            i22 = iB11;
                                        }
                                    }
                                    int i24 = i22 + 1;
                                    int[] iArr2 = new int[i24];
                                    int i25 = 0;
                                    while (i25 < i24) {
                                        iArr2[i25] = vorbisBitArray.b(i19) + 1;
                                        int iB12 = vorbisBitArray.b(i11);
                                        int i26 = i15;
                                        if (iB12 > 0) {
                                            vorbisBitArray.c(i26);
                                        }
                                        int i27 = 0;
                                        while (i27 < (i2 << iB12)) {
                                            vorbisBitArray.c(i26);
                                            i27++;
                                            i26 = 8;
                                        }
                                        i25++;
                                        i15 = 8;
                                        i11 = 2;
                                        i19 = 3;
                                    }
                                    vorbisBitArray.c(i11);
                                    int iB13 = vorbisBitArray.b(4);
                                    int i28 = 0;
                                    int i29 = 0;
                                    for (int i30 = 0; i30 < iB10; i30++) {
                                        i28 += iArr2[iArr[i30]];
                                        while (i29 < i28) {
                                            vorbisBitArray.c(iB13);
                                            i29++;
                                        }
                                    }
                                }
                                i18++;
                                i3 = i2;
                                i15 = 8;
                                i16 = 6;
                                i11 = 2;
                                i4 = 4;
                                i12 = 16;
                                i8 = 5;
                            } else {
                                int i31 = i3;
                                int iB14 = vorbisBitArray.b(i16) + 1;
                                int i32 = 0;
                                while (i32 < iB14) {
                                    if (vorbisBitArray.b(16) > 2) {
                                        throw ParserException.a(null, "residueType greater than 2 is not decodable");
                                    }
                                    vorbisBitArray.c(24);
                                    vorbisBitArray.c(24);
                                    vorbisBitArray.c(24);
                                    int iB15 = vorbisBitArray.b(i16) + 1;
                                    int i33 = 8;
                                    vorbisBitArray.c(8);
                                    int[] iArr3 = new int[iB15];
                                    for (int i34 = 0; i34 < iB15; i34++) {
                                        iArr3[i34] = ((vorbisBitArray.a() ? vorbisBitArray.b(5) : 0) * 8) + vorbisBitArray.b(3);
                                    }
                                    int i35 = 0;
                                    while (i35 < iB15) {
                                        int i36 = 0;
                                        while (i36 < i33) {
                                            if ((iArr3[i35] & (i31 << i36)) != 0) {
                                                vorbisBitArray.c(i33);
                                            }
                                            i36++;
                                            i33 = 8;
                                        }
                                        i35++;
                                        i33 = 8;
                                    }
                                    i32++;
                                    i16 = 6;
                                }
                                int iB16 = vorbisBitArray.b(i16) + 1;
                                int i37 = 0;
                                while (i37 < iB16) {
                                    int iB17 = vorbisBitArray.b(16);
                                    if (iB17 != 0) {
                                        Log.d("VorbisUtil", "mapping type other than 0 not supported: " + iB17);
                                    } else {
                                        int iB18 = vorbisBitArray.a() ? vorbisBitArray.b(4) + 1 : i31;
                                        boolean zA2 = vorbisBitArray.a();
                                        int i38 = vorbisIdHeader.f8631a;
                                        if (zA2) {
                                            int iB19 = vorbisBitArray.b(8) + 1;
                                            for (int i39 = 0; i39 < iB19; i39++) {
                                                int i40 = i38 - 1;
                                                vorbisBitArray.c(VorbisUtil.a(i40));
                                                vorbisBitArray.c(VorbisUtil.a(i40));
                                            }
                                        }
                                        if (vorbisBitArray.b(2) != 0) {
                                            throw ParserException.a(null, "to reserved bits must be zero after mapping coupling steps");
                                        }
                                        if (iB18 > i31) {
                                            for (int i41 = 0; i41 < i38; i41++) {
                                                vorbisBitArray.c(4);
                                            }
                                        }
                                        for (int i42 = 0; i42 < iB18; i42++) {
                                            vorbisBitArray.c(8);
                                            vorbisBitArray.c(8);
                                            vorbisBitArray.c(8);
                                        }
                                    }
                                    i37++;
                                    i31 = 1;
                                }
                                int iB20 = vorbisBitArray.b(6);
                                int i43 = iB20 + 1;
                                VorbisUtil.Mode[] modeArr = new VorbisUtil.Mode[i43];
                                for (int i44 = 0; i44 < i43; i44++) {
                                    boolean zA3 = vorbisBitArray.a();
                                    vorbisBitArray.b(16);
                                    vorbisBitArray.b(16);
                                    vorbisBitArray.b(8);
                                    modeArr[i44] = new VorbisUtil.Mode(zA3);
                                }
                                if (!vorbisBitArray.a()) {
                                    throw ParserException.a(null, "framing bit after modes not set as expected");
                                }
                                vorbisSetup = new VorbisSetup(vorbisIdHeader, commentHeader, bArr, modeArr, VorbisUtil.a(iB20));
                            }
                        }
                    }
                }
            }
        }
        vorbisSetup = null;
        this.n = vorbisSetup;
        if (vorbisSetup == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        VorbisUtil.VorbisIdHeader vorbisIdHeader2 = vorbisSetup.f9149a;
        arrayList.add(vorbisIdHeader2.f8637g);
        arrayList.add(vorbisSetup.f9151c);
        Metadata metadataB = VorbisUtil.b(ImmutableList.p(vorbisSetup.f9150b.f8629a));
        Format.Builder builder = new Format.Builder();
        builder.f5237l = MimeTypes.p("audio/vorbis");
        builder.f5232g = vorbisIdHeader2.f8634d;
        builder.f5233h = vorbisIdHeader2.f8633c;
        builder.z = vorbisIdHeader2.f8631a;
        builder.A = vorbisIdHeader2.f8632b;
        builder.o = arrayList;
        builder.f5235j = metadataB;
        setupData.f9147a = new Format(builder);
        return true;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final void d(boolean z) {
        super.d(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }
}
