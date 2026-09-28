package androidx.media3.extractor.mkv;

import android.support.v4.media.b;
import android.util.SparseArray;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.LongArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.google.common.base.Charsets;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.xbill.DNS.TTL;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

@UnstableApi
/* loaded from: classes3.dex */
public class MatroskaExtractor implements Extractor {
    public static final byte[] e0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] f0;
    public static final byte[] g0;
    public static final byte[] h0;
    public static final UUID i0;
    public static final Map j0;
    public boolean A;
    public long B;
    public long C;
    public long D;
    public LongArray E;
    public LongArray F;
    public boolean G;
    public boolean H;
    public int I;
    public long J;
    public long K;
    public int L;
    public int M;
    public int[] N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public long T;
    public int U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final DefaultEbmlReader f8903a;
    public int a0;

    /* renamed from: b, reason: collision with root package name */
    public final VarintReader f8904b;
    public byte b0;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f8905c;
    public boolean c0;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8906d;
    public ExtractorOutput d0;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f8907e;

    /* renamed from: f, reason: collision with root package name */
    public final SubtitleParser.Factory f8908f;

    /* renamed from: g, reason: collision with root package name */
    public final ParsableByteArray f8909g;

    /* renamed from: h, reason: collision with root package name */
    public final ParsableByteArray f8910h;

    /* renamed from: i, reason: collision with root package name */
    public final ParsableByteArray f8911i;

    /* renamed from: j, reason: collision with root package name */
    public final ParsableByteArray f8912j;

    /* renamed from: k, reason: collision with root package name */
    public final ParsableByteArray f8913k;

    /* renamed from: l, reason: collision with root package name */
    public final ParsableByteArray f8914l;

    /* renamed from: m, reason: collision with root package name */
    public final ParsableByteArray f8915m;
    public final ParsableByteArray n;
    public final ParsableByteArray o;
    public final ParsableByteArray p;
    public ByteBuffer q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public Track w;
    public boolean x;
    public int y;
    public long z;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public final class InnerEbmlProcessor implements EbmlProcessor {
        public InnerEbmlProcessor() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(int i2, int i3, DefaultExtractorInput defaultExtractorInput) throws ParserException, EOFException, InterruptedIOException {
            int i4;
            int i5;
            int i6;
            long j2;
            int i7;
            int i8;
            int i9;
            int i10;
            MatroskaExtractor matroskaExtractor = MatroskaExtractor.this;
            SparseArray sparseArray = matroskaExtractor.f8905c;
            int i11 = 0;
            int i12 = 1;
            if (i2 != 161 && i2 != 163) {
                if (i2 == 165) {
                    if (matroskaExtractor.I != 2) {
                        return;
                    }
                    Track track = (Track) sparseArray.get(matroskaExtractor.O);
                    if (matroskaExtractor.R != 4 || !"V_VP9".equals(track.f8918b)) {
                        defaultExtractorInput.i(i3);
                        return;
                    }
                    ParsableByteArray parsableByteArray = matroskaExtractor.p;
                    parsableByteArray.G(i3);
                    defaultExtractorInput.e(parsableByteArray.f5723a, 0, i3, false);
                    return;
                }
                if (i2 == 16877) {
                    matroskaExtractor.d(i2);
                    Track track2 = matroskaExtractor.w;
                    int i13 = track2.f8923g;
                    if (i13 != 1685485123 && i13 != 1685480259) {
                        defaultExtractorInput.i(i3);
                        return;
                    }
                    byte[] bArr = new byte[i3];
                    track2.O = bArr;
                    defaultExtractorInput.e(bArr, 0, i3, false);
                    return;
                }
                if (i2 == 16981) {
                    matroskaExtractor.d(i2);
                    Track track3 = matroskaExtractor.w;
                    byte[] bArr2 = new byte[i3];
                    track3.f8925i = bArr2;
                    defaultExtractorInput.e(bArr2, 0, i3, false);
                    return;
                }
                if (i2 == 18402) {
                    byte[] bArr3 = new byte[i3];
                    defaultExtractorInput.e(bArr3, 0, i3, false);
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.f8926j = new TrackOutput.CryptoData(1, 0, bArr3, 0);
                    return;
                }
                if (i2 == 21419) {
                    ParsableByteArray parsableByteArray2 = matroskaExtractor.f8913k;
                    Arrays.fill(parsableByteArray2.f5723a, (byte) 0);
                    defaultExtractorInput.e(parsableByteArray2.f5723a, 4 - i3, i3, false);
                    parsableByteArray2.J(0);
                    matroskaExtractor.y = (int) parsableByteArray2.z();
                    return;
                }
                if (i2 == 25506) {
                    matroskaExtractor.d(i2);
                    Track track4 = matroskaExtractor.w;
                    byte[] bArr4 = new byte[i3];
                    track4.f8927k = bArr4;
                    defaultExtractorInput.e(bArr4, 0, i3, false);
                    return;
                }
                if (i2 != 30322) {
                    throw ParserException.a(null, "Unexpected id: " + i2);
                }
                matroskaExtractor.d(i2);
                Track track5 = matroskaExtractor.w;
                byte[] bArr5 = new byte[i3];
                track5.w = bArr5;
                defaultExtractorInput.e(bArr5, 0, i3, false);
                return;
            }
            int i14 = matroskaExtractor.I;
            ParsableByteArray parsableByteArray3 = matroskaExtractor.f8911i;
            if (i14 == 0) {
                VarintReader varintReader = matroskaExtractor.f8904b;
                matroskaExtractor.O = (int) varintReader.c(defaultExtractorInput, false, true, 8);
                matroskaExtractor.P = varintReader.f8935c;
                matroskaExtractor.K = -9223372036854775807L;
                matroskaExtractor.I = 1;
                parsableByteArray3.G(0);
            }
            Track track6 = (Track) sparseArray.get(matroskaExtractor.O);
            if (track6 == null) {
                defaultExtractorInput.i(i3 - matroskaExtractor.P);
                matroskaExtractor.I = 0;
                return;
            }
            track6.Y.getClass();
            if (matroskaExtractor.I == 1) {
                matroskaExtractor.k(defaultExtractorInput, 3);
                int i15 = (parsableByteArray3.f5723a[2] & 6) >> 1;
                int i16 = 255;
                if (i15 == 0) {
                    matroskaExtractor.M = 1;
                    int[] iArr = matroskaExtractor.N;
                    if (iArr == null) {
                        iArr = new int[1];
                    } else if (iArr.length < 1) {
                        iArr = new int[Math.max(iArr.length * 2, 1)];
                    }
                    matroskaExtractor.N = iArr;
                    iArr[0] = (i3 - matroskaExtractor.P) - 3;
                } else {
                    matroskaExtractor.k(defaultExtractorInput, 4);
                    int i17 = (parsableByteArray3.f5723a[3] & 255) + 1;
                    matroskaExtractor.M = i17;
                    int[] iArr2 = matroskaExtractor.N;
                    if (iArr2 == null) {
                        iArr2 = new int[i17];
                    } else if (iArr2.length < i17) {
                        iArr2 = new int[Math.max(iArr2.length * 2, i17)];
                    }
                    matroskaExtractor.N = iArr2;
                    if (i15 == 2) {
                        int i18 = (i3 - matroskaExtractor.P) - 4;
                        int i19 = matroskaExtractor.M;
                        Arrays.fill(iArr2, 0, i19, i18 / i19);
                    } else {
                        if (i15 != 1) {
                            if (i15 != 3) {
                                throw ParserException.a(null, "Unexpected lacing value: " + i15);
                            }
                            int i20 = 0;
                            int i21 = 0;
                            int i22 = 4;
                            while (true) {
                                int i23 = matroskaExtractor.M - i12;
                                if (i20 >= i23) {
                                    i5 = i11;
                                    i4 = i12;
                                    matroskaExtractor.N[i23] = ((i3 - matroskaExtractor.P) - i22) - i21;
                                    break;
                                }
                                matroskaExtractor.N[i20] = i11;
                                int i24 = i22 + 1;
                                matroskaExtractor.k(defaultExtractorInput, i24);
                                if (parsableByteArray3.f5723a[i22] == 0) {
                                    throw ParserException.a(null, "No valid varint length mask found");
                                }
                                int i25 = i12;
                                int i26 = i11;
                                while (true) {
                                    if (i26 >= 8) {
                                        i6 = i11;
                                        j2 = 0;
                                        i7 = i24;
                                        break;
                                    }
                                    int i27 = i25 << (7 - i26);
                                    i6 = i11;
                                    if ((parsableByteArray3.f5723a[i22] & i27) != 0) {
                                        int i28 = i24 + i26;
                                        matroskaExtractor.k(defaultExtractorInput, i28);
                                        j2 = parsableByteArray3.f5723a[i22] & i16 & (~i27);
                                        while (i24 < i28) {
                                            j2 = (j2 << 8) | (parsableByteArray3.f5723a[i24] & i16);
                                            i24++;
                                            i28 = i28;
                                            i16 = 255;
                                        }
                                        i7 = i28;
                                        if (i20 > 0) {
                                            j2 -= (1 << ((i26 * 7) + 6)) - 1;
                                        }
                                    } else {
                                        i26++;
                                        i11 = i6;
                                        i16 = 255;
                                    }
                                }
                                if (j2 < -2147483648L || j2 > TTL.MAX_VALUE) {
                                    break;
                                }
                                int i29 = (int) j2;
                                int[] iArr3 = matroskaExtractor.N;
                                if (i20 != 0) {
                                    i29 += iArr3[i20 - 1];
                                }
                                iArr3[i20] = i29;
                                i21 += i29;
                                i20++;
                                i12 = i25;
                                i11 = i6;
                                i22 = i7;
                                i16 = 255;
                            }
                            throw ParserException.a(null, "EBML lacing sample size out of range.");
                        }
                        int i30 = 0;
                        int i31 = 0;
                        int i32 = 4;
                        while (true) {
                            i8 = matroskaExtractor.M - 1;
                            if (i30 >= i8) {
                                break;
                            }
                            matroskaExtractor.N[i30] = 0;
                            while (true) {
                                i9 = i32 + 1;
                                matroskaExtractor.k(defaultExtractorInput, i9);
                                int i33 = parsableByteArray3.f5723a[i32] & 255;
                                int[] iArr4 = matroskaExtractor.N;
                                i10 = iArr4[i30] + i33;
                                iArr4[i30] = i10;
                                if (i33 != 255) {
                                    break;
                                } else {
                                    i32 = i9;
                                }
                            }
                            i31 += i10;
                            i30++;
                            i32 = i9;
                        }
                        matroskaExtractor.N[i8] = ((i3 - matroskaExtractor.P) - i32) - i31;
                    }
                }
                i5 = 0;
                i4 = 1;
                byte[] bArr6 = parsableByteArray3.f5723a;
                matroskaExtractor.J = matroskaExtractor.m((bArr6[i4] & 255) | (bArr6[i5] << 8)) + matroskaExtractor.D;
                matroskaExtractor.Q = (track6.f8920d == 2 || (i2 == 163 && (parsableByteArray3.f5723a[2] & 128) == 128)) ? i4 : i5;
                matroskaExtractor.I = 2;
                matroskaExtractor.L = i5;
            } else {
                i4 = 1;
            }
            if (i2 == 163) {
                while (true) {
                    int i34 = matroskaExtractor.L;
                    if (i34 >= matroskaExtractor.M) {
                        matroskaExtractor.I = 0;
                        return;
                    } else {
                        matroskaExtractor.f(track6, ((matroskaExtractor.L * track6.f8921e) / 1000) + matroskaExtractor.J, matroskaExtractor.Q, matroskaExtractor.n(defaultExtractorInput, track6, matroskaExtractor.N[i34], false), 0);
                        matroskaExtractor.L++;
                    }
                }
            } else {
                while (true) {
                    int i35 = matroskaExtractor.L;
                    if (i35 >= matroskaExtractor.M) {
                        return;
                    }
                    int[] iArr5 = matroskaExtractor.N;
                    boolean z = i4;
                    iArr5[i35] = matroskaExtractor.n(defaultExtractorInput, track6, iArr5[i35], z);
                    matroskaExtractor.L += z ? 1 : 0;
                }
            }
        }

        public final void b(int i2, long j2) throws ParserException {
            MatroskaExtractor matroskaExtractor = MatroskaExtractor.this;
            matroskaExtractor.getClass();
            if (i2 == 20529) {
                if (j2 == 0) {
                    return;
                }
                throw ParserException.a(null, "ContentEncodingOrder " + j2 + " not supported");
            }
            if (i2 == 20530) {
                if (j2 == 1) {
                    return;
                }
                throw ParserException.a(null, "ContentEncodingScope " + j2 + " not supported");
            }
            switch (i2) {
                case WKSRecord.Service.CISCO_TNA /* 131 */:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.f8920d = (int) j2;
                    return;
                case WKSRecord.Service.PROFILE /* 136 */:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.W = j2 == 1;
                    return;
                case 155:
                    matroskaExtractor.K = matroskaExtractor.m(j2);
                    return;
                case 159:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.P = (int) j2;
                    return;
                case 176:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.f8929m = (int) j2;
                    return;
                case 179:
                    matroskaExtractor.b(i2);
                    matroskaExtractor.E.a(matroskaExtractor.m(j2));
                    return;
                case 186:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.n = (int) j2;
                    return;
                case 215:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.f8919c = (int) j2;
                    return;
                case 231:
                    matroskaExtractor.D = matroskaExtractor.m(j2);
                    return;
                case 238:
                    matroskaExtractor.R = (int) j2;
                    return;
                case 241:
                    if (matroskaExtractor.G) {
                        return;
                    }
                    matroskaExtractor.b(i2);
                    matroskaExtractor.F.a(j2);
                    matroskaExtractor.G = true;
                    return;
                case Type.IXFR /* 251 */:
                    matroskaExtractor.S = true;
                    return;
                case 16871:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.f8923g = (int) j2;
                    return;
                case 16980:
                    if (j2 == 3) {
                        return;
                    }
                    throw ParserException.a(null, "ContentCompAlgo " + j2 + " not supported");
                case 17029:
                    if (j2 < 1 || j2 > 2) {
                        throw ParserException.a(null, "DocTypeReadVersion " + j2 + " not supported");
                    }
                    return;
                case 17143:
                    if (j2 == 1) {
                        return;
                    }
                    throw ParserException.a(null, "EBMLReadVersion " + j2 + " not supported");
                case 18401:
                    if (j2 == 5) {
                        return;
                    }
                    throw ParserException.a(null, "ContentEncAlgo " + j2 + " not supported");
                case 18408:
                    if (j2 == 1) {
                        return;
                    }
                    throw ParserException.a(null, "AESSettingsCipherMode " + j2 + " not supported");
                case 21420:
                    matroskaExtractor.z = j2 + matroskaExtractor.s;
                    return;
                case 21432:
                    int i3 = (int) j2;
                    matroskaExtractor.d(i2);
                    if (i3 == 0) {
                        matroskaExtractor.w.x = 0;
                        return;
                    }
                    if (i3 == 1) {
                        matroskaExtractor.w.x = 2;
                        return;
                    } else if (i3 == 3) {
                        matroskaExtractor.w.x = 1;
                        return;
                    } else {
                        if (i3 != 15) {
                            return;
                        }
                        matroskaExtractor.w.x = 3;
                        return;
                    }
                case 21680:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.p = (int) j2;
                    return;
                case 21682:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.r = (int) j2;
                    return;
                case 21690:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.q = (int) j2;
                    return;
                case 21930:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.V = j2 == 1;
                    return;
                case 21938:
                    matroskaExtractor.d(i2);
                    Track track = matroskaExtractor.w;
                    track.y = true;
                    track.o = (int) j2;
                    return;
                case 21998:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.f8922f = (int) j2;
                    return;
                case 22186:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.S = j2;
                    return;
                case 22203:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.T = j2;
                    return;
                case 25188:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.Q = (int) j2;
                    return;
                case 30114:
                    matroskaExtractor.T = j2;
                    return;
                case 30321:
                    matroskaExtractor.d(i2);
                    int i4 = (int) j2;
                    if (i4 == 0) {
                        matroskaExtractor.w.s = 0;
                        return;
                    }
                    if (i4 == 1) {
                        matroskaExtractor.w.s = 1;
                        return;
                    } else if (i4 == 2) {
                        matroskaExtractor.w.s = 2;
                        return;
                    } else {
                        if (i4 != 3) {
                            return;
                        }
                        matroskaExtractor.w.s = 3;
                        return;
                    }
                case 2352003:
                    matroskaExtractor.d(i2);
                    matroskaExtractor.w.f8921e = (int) j2;
                    return;
                case 2807729:
                    matroskaExtractor.t = j2;
                    return;
                default:
                    switch (i2) {
                        case 21945:
                            matroskaExtractor.d(i2);
                            int i5 = (int) j2;
                            if (i5 == 1) {
                                matroskaExtractor.w.B = 2;
                                return;
                            } else {
                                if (i5 != 2) {
                                    return;
                                }
                                matroskaExtractor.w.B = 1;
                                return;
                            }
                        case 21946:
                            matroskaExtractor.d(i2);
                            int iG = ColorInfo.g((int) j2);
                            if (iG != -1) {
                                matroskaExtractor.w.A = iG;
                                return;
                            }
                            return;
                        case 21947:
                            matroskaExtractor.d(i2);
                            matroskaExtractor.w.y = true;
                            int iF = ColorInfo.f((int) j2);
                            if (iF != -1) {
                                matroskaExtractor.w.z = iF;
                                return;
                            }
                            return;
                        case 21948:
                            matroskaExtractor.d(i2);
                            matroskaExtractor.w.C = (int) j2;
                            return;
                        case 21949:
                            matroskaExtractor.d(i2);
                            matroskaExtractor.w.D = (int) j2;
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    public static final class Track {
        public int A;
        public int B;
        public int C;
        public int D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public float L;
        public float M;
        public float N;
        public byte[] O;
        public int P;
        public int Q;
        public int R;
        public long S;
        public long T;
        public TrueHdSampleRechunker U;
        public boolean V;
        public boolean W;
        public String X;
        public TrackOutput Y;
        public int Z;

        /* renamed from: a, reason: collision with root package name */
        public String f8917a;

        /* renamed from: b, reason: collision with root package name */
        public String f8918b;

        /* renamed from: c, reason: collision with root package name */
        public int f8919c;

        /* renamed from: d, reason: collision with root package name */
        public int f8920d;

        /* renamed from: e, reason: collision with root package name */
        public int f8921e;

        /* renamed from: f, reason: collision with root package name */
        public int f8922f;

        /* renamed from: g, reason: collision with root package name */
        public int f8923g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f8924h;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f8925i;

        /* renamed from: j, reason: collision with root package name */
        public TrackOutput.CryptoData f8926j;

        /* renamed from: k, reason: collision with root package name */
        public byte[] f8927k;

        /* renamed from: l, reason: collision with root package name */
        public DrmInitData f8928l;

        /* renamed from: m, reason: collision with root package name */
        public int f8929m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public float t;
        public float u;
        public float v;
        public byte[] w;
        public int x;
        public boolean y;
        public int z;

        public final byte[] a(String str) throws ParserException {
            byte[] bArr = this.f8927k;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.a(null, "Missing CodecPrivate for codec " + str);
        }
    }

    static {
        int i2 = Util.f5744a;
        f0 = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(Charsets.f42260c);
        g0 = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        h0 = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        i0 = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        b.z(0, map, "htc_video_rotA-000", 90, "htc_video_rotA-090");
        b.z(180, map, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        j0 = Collections.unmodifiableMap(map);
    }

    @Deprecated
    public MatroskaExtractor() {
        this(new DefaultEbmlReader(), 2, SubtitleParser.Factory.f9179a);
    }

    public static byte[] g(long j2, long j3, String str) {
        Assertions.a(j2 != -9223372036854775807L);
        int i2 = (int) (j2 / 3600000000L);
        long j4 = j2 - (i2 * 3600000000L);
        int i3 = (int) (j4 / 60000000);
        long j5 = j4 - (i3 * 60000000);
        int i4 = (int) (j5 / 1000000);
        String str2 = String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j5 - (i4 * 1000000)) / j3)));
        int i5 = Util.f5744a;
        return str2.getBytes(Charsets.f42260c);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.D = -9223372036854775807L;
        this.I = 0;
        DefaultEbmlReader defaultEbmlReader = this.f8903a;
        defaultEbmlReader.f8898e = 0;
        defaultEbmlReader.f8895b.clear();
        VarintReader varintReader = defaultEbmlReader.f8896c;
        varintReader.f8934b = 0;
        varintReader.f8935c = 0;
        VarintReader varintReader2 = this.f8904b;
        varintReader2.f8934b = 0;
        varintReader2.f8935c = 0;
        l();
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.f8905c;
            if (i2 >= sparseArray.size()) {
                return;
            }
            TrueHdSampleRechunker trueHdSampleRechunker = ((Track) sparseArray.valueAt(i2)).U;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.f8619b = false;
                trueHdSampleRechunker.f8620c = 0;
            }
            i2++;
        }
    }

    public final void b(int i2) throws ParserException {
        if (this.E == null || this.F == null) {
            throw ParserException.a(null, "Element " + i2 + " must be in a Cues");
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.d0 = extractorOutput;
        if (this.f8907e) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f8908f);
        }
        this.d0 = extractorOutput;
    }

    public final void d(int i2) throws ParserException {
        if (this.w != null) {
            return;
        }
        throw ParserException.a(null, "Element " + i2 + " must be in a TrackEntry");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(androidx.media3.extractor.mkv.MatroskaExtractor.Track r24, long r25, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mkv.MatroskaExtractor.f(androidx.media3.extractor.mkv.MatroskaExtractor$Track, long, int, int, int):void");
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) throws EOFException, InterruptedIOException {
        Sniffer sniffer = new Sniffer();
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        long j2 = defaultExtractorInput.f8518c;
        long j3 = 1024;
        if (j2 != -1 && j2 <= 1024) {
            j3 = j2;
        }
        int i2 = (int) j3;
        ParsableByteArray parsableByteArray = sniffer.f8930a;
        defaultExtractorInput.b(parsableByteArray.f5723a, 0, 4, false);
        long jZ = parsableByteArray.z();
        sniffer.f8931b = 4;
        while (true) {
            if (jZ != 440786851) {
                int i3 = sniffer.f8931b + 1;
                sniffer.f8931b = i3;
                if (i3 == i2) {
                    break;
                }
                defaultExtractorInput.b(parsableByteArray.f5723a, 0, 1, false);
                jZ = ((jZ << 8) & (-256)) | (parsableByteArray.f5723a[0] & 255);
            } else {
                long jA = sniffer.a(defaultExtractorInput);
                long j4 = sniffer.f8931b;
                if (jA != Long.MIN_VALUE && (j2 == -1 || j4 + jA < j2)) {
                    while (true) {
                        long j5 = sniffer.f8931b;
                        long j6 = j4 + jA;
                        if (j5 < j6) {
                            if (sniffer.a(defaultExtractorInput) == Long.MIN_VALUE) {
                                break;
                            }
                            long jA2 = sniffer.a(defaultExtractorInput);
                            if (jA2 < 0 || jA2 > TTL.MAX_VALUE) {
                                break;
                            }
                            if (jA2 != 0) {
                                int i4 = (int) jA2;
                                defaultExtractorInput.l(i4, false);
                                sniffer.f8931b += i4;
                            }
                        } else if (j5 == j6) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int i2 = 0;
        this.H = false;
        boolean z = true;
        while (z && !this.H) {
            DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
            boolean zA = this.f8903a.a(defaultExtractorInput);
            if (zA) {
                long j2 = defaultExtractorInput.f8519d;
                if (this.A) {
                    this.C = j2;
                    positionHolder.f8599a = this.B;
                    this.A = false;
                    return 1;
                }
                if (this.x) {
                    long j3 = this.C;
                    if (j3 != -1) {
                        positionHolder.f8599a = j3;
                        this.C = -1L;
                        return 1;
                    }
                } else {
                    continue;
                }
            }
            z = zA;
        }
        if (z) {
            return 0;
        }
        while (true) {
            SparseArray sparseArray = this.f8905c;
            if (i2 >= sparseArray.size()) {
                return -1;
            }
            Track track = (Track) sparseArray.valueAt(i2);
            track.Y.getClass();
            TrueHdSampleRechunker trueHdSampleRechunker = track.U;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.a(track.Y, track.f8926j);
            }
            i2++;
        }
    }

    public final void k(DefaultExtractorInput defaultExtractorInput, int i2) throws EOFException, InterruptedIOException {
        ParsableByteArray parsableByteArray = this.f8911i;
        if (parsableByteArray.f5725c >= i2) {
            return;
        }
        byte[] bArr = parsableByteArray.f5723a;
        if (bArr.length < i2) {
            parsableByteArray.c(Math.max(bArr.length * 2, i2));
        }
        byte[] bArr2 = parsableByteArray.f5723a;
        int i3 = parsableByteArray.f5725c;
        defaultExtractorInput.e(bArr2, i3, i2 - i3, false);
        parsableByteArray.I(i2);
    }

    public final void l() {
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.a0 = 0;
        this.b0 = (byte) 0;
        this.c0 = false;
        this.f8914l.G(0);
    }

    public final long m(long j2) throws ParserException {
        long j3 = this.t;
        if (j3 == -9223372036854775807L) {
            throw ParserException.a(null, "Can't scale timecode prior to timecodeScale being set.");
        }
        int i2 = Util.f5744a;
        return Util.b0(j2, j3, 1000L, RoundingMode.FLOOR);
    }

    public final int n(DefaultExtractorInput defaultExtractorInput, Track track, int i2, boolean z) throws ParserException, EOFException, InterruptedIOException {
        int iC;
        int iC2;
        int i3;
        if ("S_TEXT/UTF8".equals(track.f8918b)) {
            o(defaultExtractorInput, e0, i2);
            int i4 = this.V;
            l();
            return i4;
        }
        if ("S_TEXT/ASS".equals(track.f8918b)) {
            o(defaultExtractorInput, g0, i2);
            int i5 = this.V;
            l();
            return i5;
        }
        if ("S_TEXT/WEBVTT".equals(track.f8918b)) {
            o(defaultExtractorInput, h0, i2);
            int i6 = this.V;
            l();
            return i6;
        }
        TrackOutput trackOutput = track.Y;
        boolean z2 = this.X;
        ParsableByteArray parsableByteArray = this.f8914l;
        if (!z2) {
            boolean z3 = track.f8924h;
            ParsableByteArray parsableByteArray2 = this.f8911i;
            if (z3) {
                this.Q &= -1073741825;
                if (!this.Y) {
                    defaultExtractorInput.e(parsableByteArray2.f5723a, 0, 1, false);
                    this.U++;
                    byte b2 = parsableByteArray2.f5723a[0];
                    if ((b2 & 128) == 128) {
                        throw ParserException.a(null, "Extension bit is set in signal byte");
                    }
                    this.b0 = b2;
                    this.Y = true;
                }
                byte b3 = this.b0;
                if ((b3 & 1) == 1) {
                    boolean z4 = (b3 & 2) == 2;
                    this.Q |= 1073741824;
                    if (!this.c0) {
                        ParsableByteArray parsableByteArray3 = this.n;
                        defaultExtractorInput.e(parsableByteArray3.f5723a, 0, 8, false);
                        this.U += 8;
                        this.c0 = true;
                        parsableByteArray2.f5723a[0] = (byte) ((z4 ? 128 : 0) | 8);
                        parsableByteArray2.J(0);
                        trackOutput.a(parsableByteArray2, 1, 1);
                        this.V++;
                        parsableByteArray3.J(0);
                        trackOutput.a(parsableByteArray3, 8, 1);
                        this.V += 8;
                    }
                    if (z4) {
                        if (!this.Z) {
                            defaultExtractorInput.e(parsableByteArray2.f5723a, 0, 1, false);
                            this.U++;
                            parsableByteArray2.J(0);
                            this.a0 = parsableByteArray2.x();
                            this.Z = true;
                        }
                        int i7 = this.a0 * 4;
                        parsableByteArray2.G(i7);
                        defaultExtractorInput.e(parsableByteArray2.f5723a, 0, i7, false);
                        this.U += i7;
                        short s = (short) ((this.a0 / 2) + 1);
                        int i8 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.q;
                        if (byteBuffer == null || byteBuffer.capacity() < i8) {
                            this.q = ByteBuffer.allocate(i8);
                        }
                        this.q.position(0);
                        this.q.putShort(s);
                        int i9 = 0;
                        int i10 = 0;
                        while (true) {
                            i3 = this.a0;
                            if (i9 >= i3) {
                                break;
                            }
                            int iB = parsableByteArray2.B();
                            if (i9 % 2 == 0) {
                                this.q.putShort((short) (iB - i10));
                            } else {
                                this.q.putInt(iB - i10);
                            }
                            i9++;
                            i10 = iB;
                        }
                        int i11 = (i2 - this.U) - i10;
                        if (i3 % 2 == 1) {
                            this.q.putInt(i11);
                        } else {
                            this.q.putShort((short) i11);
                            this.q.putInt(0);
                        }
                        byte[] bArrArray = this.q.array();
                        ParsableByteArray parsableByteArray4 = this.o;
                        parsableByteArray4.H(i8, bArrArray);
                        trackOutput.a(parsableByteArray4, i8, 1);
                        this.V += i8;
                    }
                }
            } else {
                byte[] bArr = track.f8925i;
                if (bArr != null) {
                    parsableByteArray.H(bArr.length, bArr);
                }
            }
            if ("A_OPUS".equals(track.f8918b) ? z : track.f8922f > 0) {
                this.Q |= 268435456;
                this.p.G(0);
                int i12 = (parsableByteArray.f5725c + i2) - this.U;
                parsableByteArray2.G(4);
                byte[] bArr2 = parsableByteArray2.f5723a;
                bArr2[0] = (byte) ((i12 >> 24) & 255);
                bArr2[1] = (byte) ((i12 >> 16) & 255);
                bArr2[2] = (byte) ((i12 >> 8) & 255);
                bArr2[3] = (byte) (i12 & 255);
                trackOutput.a(parsableByteArray2, 4, 2);
                this.V += 4;
            }
            this.X = true;
        }
        int i13 = i2 + parsableByteArray.f5725c;
        if (!"V_MPEG4/ISO/AVC".equals(track.f8918b) && !"V_MPEGH/ISO/HEVC".equals(track.f8918b)) {
            if (track.U != null) {
                Assertions.g(parsableByteArray.f5725c == 0);
                track.U.c(defaultExtractorInput);
            }
            while (true) {
                int i14 = this.U;
                if (i14 >= i13) {
                    break;
                }
                int i15 = i13 - i14;
                int iA = parsableByteArray.a();
                if (iA > 0) {
                    iC2 = Math.min(i15, iA);
                    trackOutput.e(iC2, parsableByteArray);
                } else {
                    iC2 = trackOutput.c(defaultExtractorInput, i15, false);
                }
                this.U += iC2;
                this.V += iC2;
            }
        } else {
            ParsableByteArray parsableByteArray5 = this.f8910h;
            byte[] bArr3 = parsableByteArray5.f5723a;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i16 = track.Z;
            int i17 = 4 - i16;
            while (this.U < i13) {
                int i18 = this.W;
                if (i18 == 0) {
                    int iMin = Math.min(i16, parsableByteArray.a());
                    defaultExtractorInput.e(bArr3, i17 + iMin, i16 - iMin, false);
                    if (iMin > 0) {
                        parsableByteArray.h(i17, bArr3, iMin);
                    }
                    this.U += i16;
                    parsableByteArray5.J(0);
                    this.W = parsableByteArray5.B();
                    ParsableByteArray parsableByteArray6 = this.f8909g;
                    parsableByteArray6.J(0);
                    trackOutput.e(4, parsableByteArray6);
                    this.V += 4;
                } else {
                    int iA2 = parsableByteArray.a();
                    if (iA2 > 0) {
                        iC = Math.min(i18, iA2);
                        trackOutput.e(iC, parsableByteArray);
                    } else {
                        iC = trackOutput.c(defaultExtractorInput, i18, false);
                    }
                    this.U += iC;
                    this.V += iC;
                    this.W -= iC;
                }
            }
        }
        if ("A_VORBIS".equals(track.f8918b)) {
            ParsableByteArray parsableByteArray7 = this.f8912j;
            parsableByteArray7.J(0);
            trackOutput.e(4, parsableByteArray7);
            this.V += 4;
        }
        int i19 = this.V;
        l();
        return i19;
    }

    public final void o(DefaultExtractorInput defaultExtractorInput, byte[] bArr, int i2) throws EOFException, InterruptedIOException {
        int length = bArr.length + i2;
        ParsableByteArray parsableByteArray = this.f8915m;
        byte[] bArr2 = parsableByteArray.f5723a;
        if (bArr2.length < length) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, length + i2);
            parsableByteArray.H(bArrCopyOf.length, bArrCopyOf);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        defaultExtractorInput.e(parsableByteArray.f5723a, bArr.length, i2, false);
        parsableByteArray.J(0);
        parsableByteArray.I(length);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }

    public MatroskaExtractor(int i2, SubtitleParser.Factory factory) {
        this(new DefaultEbmlReader(), i2, factory);
    }

    public MatroskaExtractor(DefaultEbmlReader defaultEbmlReader, int i2, SubtitleParser.Factory factory) {
        this.s = -1L;
        this.t = -9223372036854775807L;
        this.u = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.B = -1L;
        this.C = -1L;
        this.D = -9223372036854775807L;
        this.f8903a = defaultEbmlReader;
        defaultEbmlReader.f8897d = new InnerEbmlProcessor();
        this.f8908f = factory;
        this.f8906d = (i2 & 1) == 0;
        this.f8907e = (i2 & 2) == 0;
        this.f8904b = new VarintReader();
        this.f8905c = new SparseArray();
        this.f8911i = new ParsableByteArray(4);
        this.f8912j = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.f8913k = new ParsableByteArray(4);
        this.f8909g = new ParsableByteArray(NalUnitUtil.f5779a);
        this.f8910h = new ParsableByteArray(4);
        this.f8914l = new ParsableByteArray();
        this.f8915m = new ParsableByteArray();
        this.n = new ParsableByteArray(8);
        this.o = new ParsableByteArray();
        this.p = new ParsableByteArray();
        this.N = new int[1];
    }
}
