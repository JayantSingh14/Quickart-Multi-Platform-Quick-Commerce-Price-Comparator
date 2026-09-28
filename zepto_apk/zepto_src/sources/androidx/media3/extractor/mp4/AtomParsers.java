package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.mp4.Atom;
import com.google.common.base.Charsets;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
final class AtomParsers {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f8974a;

    public static final class ChunkIterator {

        /* renamed from: a, reason: collision with root package name */
        public final int f8975a;

        /* renamed from: b, reason: collision with root package name */
        public int f8976b;

        /* renamed from: c, reason: collision with root package name */
        public int f8977c;

        /* renamed from: d, reason: collision with root package name */
        public long f8978d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f8979e;

        /* renamed from: f, reason: collision with root package name */
        public final ParsableByteArray f8980f;

        /* renamed from: g, reason: collision with root package name */
        public final ParsableByteArray f8981g;

        /* renamed from: h, reason: collision with root package name */
        public int f8982h;

        /* renamed from: i, reason: collision with root package name */
        public int f8983i;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.f8981g = parsableByteArray;
            this.f8980f = parsableByteArray2;
            this.f8979e = z;
            parsableByteArray2.J(12);
            this.f8975a = parsableByteArray2.B();
            parsableByteArray.J(12);
            this.f8983i = parsableByteArray.B();
            ExtractorUtil.a("first_chunk must be 1", parsableByteArray.j() == 1);
            this.f8976b = -1;
        }

        public final boolean a() {
            int i2 = this.f8976b + 1;
            this.f8976b = i2;
            if (i2 == this.f8975a) {
                return false;
            }
            boolean z = this.f8979e;
            ParsableByteArray parsableByteArray = this.f8980f;
            this.f8978d = z ? parsableByteArray.C() : parsableByteArray.z();
            if (this.f8976b == this.f8982h) {
                ParsableByteArray parsableByteArray2 = this.f8981g;
                this.f8977c = parsableByteArray2.B();
                parsableByteArray2.K(4);
                int i3 = this.f8983i - 1;
                this.f8983i = i3;
                this.f8982h = i3 > 0 ? parsableByteArray2.B() - 1 : -1;
            }
            return true;
        }
    }

    public static final class EsdsData {

        /* renamed from: a, reason: collision with root package name */
        public final String f8984a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f8985b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8986c;

        /* renamed from: d, reason: collision with root package name */
        public final long f8987d;

        public EsdsData(String str, byte[] bArr, long j2, long j3) {
            this.f8984a = str;
            this.f8985b = bArr;
            this.f8986c = j2;
            this.f8987d = j3;
        }
    }

    public interface SampleSizeBox {
        int a();

        int b();

        int c();
    }

    public static final class StsdData {

        /* renamed from: a, reason: collision with root package name */
        public final TrackEncryptionBox[] f8988a;

        /* renamed from: b, reason: collision with root package name */
        public Format f8989b;

        /* renamed from: c, reason: collision with root package name */
        public int f8990c;

        /* renamed from: d, reason: collision with root package name */
        public int f8991d = 0;

        public StsdData(int i2) {
            this.f8988a = new TrackEncryptionBox[i2];
        }
    }

    public static final class StszSampleSizeBox implements SampleSizeBox {

        /* renamed from: a, reason: collision with root package name */
        public final int f8992a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8993b;

        /* renamed from: c, reason: collision with root package name */
        public final ParsableByteArray f8994c;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.f8973b;
            this.f8994c = parsableByteArray;
            parsableByteArray.J(12);
            int iB = parsableByteArray.B();
            if ("audio/raw".equals(format.f5225m)) {
                int iC = Util.C(format.C, format.A);
                if (iB == 0 || iB % iC != 0) {
                    Log.h("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iC + ", stsz sample size: " + iB);
                    iB = iC;
                }
            }
            this.f8992a = iB == 0 ? -1 : iB;
            this.f8993b = parsableByteArray.B();
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public final int a() {
            int i2 = this.f8992a;
            return i2 == -1 ? this.f8994c.B() : i2;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public final int b() {
            return this.f8992a;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public final int c() {
            return this.f8993b;
        }
    }

    public static final class Stz2SampleSizeBox implements SampleSizeBox {

        /* renamed from: a, reason: collision with root package name */
        public final ParsableByteArray f8995a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8996b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8997c;

        /* renamed from: d, reason: collision with root package name */
        public int f8998d;

        /* renamed from: e, reason: collision with root package name */
        public int f8999e;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.f8973b;
            this.f8995a = parsableByteArray;
            parsableByteArray.J(12);
            this.f8997c = parsableByteArray.B() & 255;
            this.f8996b = parsableByteArray.B();
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public final int a() {
            ParsableByteArray parsableByteArray = this.f8995a;
            int i2 = this.f8997c;
            if (i2 == 8) {
                return parsableByteArray.x();
            }
            if (i2 == 16) {
                return parsableByteArray.D();
            }
            int i3 = this.f8998d;
            this.f8998d = i3 + 1;
            if (i3 % 2 != 0) {
                return this.f8999e & 15;
            }
            int iX = parsableByteArray.x();
            this.f8999e = iX;
            return (iX & 240) >> 4;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public final int b() {
            return -1;
        }

        @Override // androidx.media3.extractor.mp4.AtomParsers.SampleSizeBox
        public final int c() {
            return this.f8996b;
        }
    }

    public static final class TkhdData {

        /* renamed from: a, reason: collision with root package name */
        public final int f9000a;

        public TkhdData(int i2, int i3, long j2) {
            this.f9000a = i2;
        }
    }

    static {
        int i2 = Util.f5744a;
        f8974a = "OpusHead".getBytes(Charsets.f42260c);
    }

    public static EsdsData a(int i2, ParsableByteArray parsableByteArray) {
        parsableByteArray.J(i2 + 12);
        parsableByteArray.K(1);
        b(parsableByteArray);
        parsableByteArray.K(2);
        int iX = parsableByteArray.x();
        if ((iX & 128) != 0) {
            parsableByteArray.K(2);
        }
        if ((iX & 64) != 0) {
            parsableByteArray.K(parsableByteArray.x());
        }
        if ((iX & 32) != 0) {
            parsableByteArray.K(2);
        }
        parsableByteArray.K(1);
        b(parsableByteArray);
        String strF = MimeTypes.f(parsableByteArray.x());
        if ("audio/mpeg".equals(strF) || "audio/vnd.dts".equals(strF) || "audio/vnd.dts.hd".equals(strF)) {
            return new EsdsData(strF, null, -1L, -1L);
        }
        parsableByteArray.K(4);
        long jZ = parsableByteArray.z();
        long jZ2 = parsableByteArray.z();
        parsableByteArray.K(1);
        int iB = b(parsableByteArray);
        long j2 = jZ2;
        byte[] bArr = new byte[iB];
        parsableByteArray.h(0, bArr, iB);
        if (j2 <= 0) {
            j2 = -1;
        }
        return new EsdsData(strF, bArr, j2, jZ > 0 ? jZ : -1L);
    }

    public static int b(ParsableByteArray parsableByteArray) {
        int iX = parsableByteArray.x();
        int i2 = iX & WKSRecord.Service.LOCUS_CON;
        while ((iX & 128) == 128) {
            iX = parsableByteArray.x();
            i2 = (i2 << 7) | (iX & WKSRecord.Service.LOCUS_CON);
        }
        return i2;
    }

    public static Mp4TimestampData c(ParsableByteArray parsableByteArray) {
        long jR;
        long jR2;
        parsableByteArray.J(8);
        if (Atom.b(parsableByteArray.j()) == 0) {
            jR = parsableByteArray.z();
            jR2 = parsableByteArray.z();
        } else {
            jR = parsableByteArray.r();
            jR2 = parsableByteArray.r();
        }
        return new Mp4TimestampData(jR, jR2, parsableByteArray.z());
    }

    public static Pair d(ParsableByteArray parsableByteArray, int i2, int i3) throws ParserException {
        Integer num;
        TrackEncryptionBox trackEncryptionBox;
        Pair pairCreate;
        int i4;
        int i5;
        Integer num2;
        boolean z;
        int i6 = parsableByteArray.f5724b;
        while (i6 - i2 < i3) {
            parsableByteArray.J(i6);
            int iJ = parsableByteArray.j();
            ExtractorUtil.a("childAtomSize must be positive", iJ > 0);
            if (parsableByteArray.j() == 1936289382) {
                int i7 = i6 + 8;
                int i8 = 0;
                int i9 = -1;
                Integer numValueOf = null;
                String strV = null;
                while (i7 - i6 < iJ) {
                    parsableByteArray.J(i7);
                    int iJ2 = parsableByteArray.j();
                    int iJ3 = parsableByteArray.j();
                    if (iJ3 == 1718775137) {
                        numValueOf = Integer.valueOf(parsableByteArray.j());
                    } else if (iJ3 == 1935894637) {
                        parsableByteArray.K(4);
                        strV = parsableByteArray.v(4, Charsets.f42260c);
                    } else if (iJ3 == 1935894633) {
                        i9 = i7;
                        i8 = iJ2;
                    }
                    i7 += iJ2;
                }
                byte[] bArr = null;
                if ("cenc".equals(strV) || "cbc1".equals(strV) || "cens".equals(strV) || "cbcs".equals(strV)) {
                    ExtractorUtil.a("frma atom is mandatory", numValueOf != null);
                    ExtractorUtil.a("schi atom is mandatory", i9 != -1);
                    int i10 = i9 + 8;
                    while (true) {
                        if (i10 - i9 >= i8) {
                            num = numValueOf;
                            trackEncryptionBox = null;
                            break;
                        }
                        parsableByteArray.J(i10);
                        int iJ4 = parsableByteArray.j();
                        if (parsableByteArray.j() == 1952804451) {
                            int iB = Atom.b(parsableByteArray.j());
                            parsableByteArray.K(1);
                            if (iB == 0) {
                                parsableByteArray.K(1);
                                i5 = 0;
                                i4 = 0;
                            } else {
                                int iX = parsableByteArray.x();
                                i4 = iX & 15;
                                i5 = (iX & 240) >> 4;
                            }
                            if (parsableByteArray.x() == 1) {
                                num2 = numValueOf;
                                z = true;
                            } else {
                                num2 = numValueOf;
                                z = false;
                            }
                            int iX2 = parsableByteArray.x();
                            byte[] bArr2 = new byte[16];
                            parsableByteArray.h(0, bArr2, 16);
                            if (z && iX2 == 0) {
                                int iX3 = parsableByteArray.x();
                                byte[] bArr3 = new byte[iX3];
                                parsableByteArray.h(0, bArr3, iX3);
                                bArr = bArr3;
                            }
                            num = num2;
                            trackEncryptionBox = new TrackEncryptionBox(z, strV, iX2, bArr2, i5, i4, bArr);
                        } else {
                            i10 += iJ4;
                        }
                    }
                    ExtractorUtil.a("tenc atom is mandatory", trackEncryptionBox != null);
                    int i11 = Util.f5744a;
                    pairCreate = Pair.create(num, trackEncryptionBox);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            i6 += iJ;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0aba  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0adc  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0af6  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x0c16  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0c18  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.extractor.mp4.AtomParsers.StsdData e(androidx.media3.common.util.ParsableByteArray r54, int r55, int r56, java.lang.String r57, androidx.media3.common.DrmInitData r58, boolean r59) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instructions count: 3792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.AtomParsers.e(androidx.media3.common.util.ParsableByteArray, int, int, java.lang.String, androidx.media3.common.DrmInitData, boolean):androidx.media3.extractor.mp4.AtomParsers$StsdData");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e2, code lost:
    
        r3 = -9223372036854775807L;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x088f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList f(androidx.media3.extractor.mp4.Atom.ContainerAtom r54, androidx.media3.extractor.GaplessInfoHolder r55, long r56, androidx.media3.common.DrmInitData r58, boolean r59, boolean r60, com.google.common.base.Function r61) {
        /*
            Method dump skipped, instructions count: 2201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.AtomParsers.f(androidx.media3.extractor.mp4.Atom$ContainerAtom, androidx.media3.extractor.GaplessInfoHolder, long, androidx.media3.common.DrmInitData, boolean, boolean, com.google.common.base.Function):java.util.ArrayList");
    }
}
