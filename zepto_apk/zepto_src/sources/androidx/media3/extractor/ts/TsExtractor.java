package androidx.media3.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import androidx.media3.extractor.ts.TsBinarySearchSeeker;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class TsExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final int f9784a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9785b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9786c;

    /* renamed from: d, reason: collision with root package name */
    public final List f9787d;

    /* renamed from: e, reason: collision with root package name */
    public final ParsableByteArray f9788e;

    /* renamed from: f, reason: collision with root package name */
    public final SparseIntArray f9789f;

    /* renamed from: g, reason: collision with root package name */
    public final DefaultTsPayloadReaderFactory f9790g;

    /* renamed from: h, reason: collision with root package name */
    public final SubtitleParser.Factory f9791h;

    /* renamed from: i, reason: collision with root package name */
    public final SparseArray f9792i;

    /* renamed from: j, reason: collision with root package name */
    public final SparseBooleanArray f9793j;

    /* renamed from: k, reason: collision with root package name */
    public final SparseBooleanArray f9794k;

    /* renamed from: l, reason: collision with root package name */
    public final TsDurationReader f9795l;

    /* renamed from: m, reason: collision with root package name */
    public TsBinarySearchSeeker f9796m;
    public ExtractorOutput n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public TsPayloadReader s;
    public int t;
    public int u;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public class PatReader implements SectionPayloadReader {

        /* renamed from: a, reason: collision with root package name */
        public final ParsableBitArray f9797a = new ParsableBitArray(new byte[4], 4);

        public PatReader() {
        }

        @Override // androidx.media3.extractor.ts.SectionPayloadReader
        public final void a(ParsableByteArray parsableByteArray) {
            TsExtractor tsExtractor;
            if (parsableByteArray.x() == 0 && (parsableByteArray.x() & 128) != 0) {
                parsableByteArray.K(6);
                int iA = parsableByteArray.a() / 4;
                int i2 = 0;
                while (true) {
                    tsExtractor = TsExtractor.this;
                    if (i2 >= iA) {
                        break;
                    }
                    ParsableBitArray parsableBitArray = this.f9797a;
                    parsableByteArray.h(0, parsableBitArray.f5716a, 4);
                    parsableBitArray.m(0);
                    int iG = parsableBitArray.g(16);
                    parsableBitArray.o(3);
                    if (iG == 0) {
                        parsableBitArray.o(13);
                    } else {
                        int iG2 = parsableBitArray.g(13);
                        if (tsExtractor.f9792i.get(iG2) == null) {
                            tsExtractor.f9792i.put(iG2, new SectionReader(tsExtractor.new PmtReader(iG2)));
                            tsExtractor.o++;
                        }
                    }
                    i2++;
                }
                if (tsExtractor.f9784a != 2) {
                    tsExtractor.f9792i.remove(0);
                }
            }
        }

        @Override // androidx.media3.extractor.ts.SectionPayloadReader
        public final void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    public class PmtReader implements SectionPayloadReader {

        /* renamed from: a, reason: collision with root package name */
        public final ParsableBitArray f9799a = new ParsableBitArray(new byte[5], 5);

        /* renamed from: b, reason: collision with root package name */
        public final SparseArray f9800b = new SparseArray();

        /* renamed from: c, reason: collision with root package name */
        public final SparseIntArray f9801c = new SparseIntArray();

        /* renamed from: d, reason: collision with root package name */
        public final int f9802d;

        public PmtReader(int i2) {
            this.f9802d = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x0130  */
        @Override // androidx.media3.extractor.ts.SectionPayloadReader
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(androidx.media3.common.util.ParsableByteArray r36) {
            /*
                Method dump skipped, instructions count: 730
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.TsExtractor.PmtReader.a(androidx.media3.common.util.ParsableByteArray):void");
        }

        @Override // androidx.media3.extractor.ts.SectionPayloadReader
        public final void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    @Deprecated
    public TsExtractor() {
        this(1, 1, SubtitleParser.Factory.f9179a, new TimestampAdjuster(0L), new DefaultTsPayloadReaderFactory(0));
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        TsBinarySearchSeeker tsBinarySearchSeeker;
        long j4;
        Assertions.g(this.f9784a != 2);
        List list = this.f9787d;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            TimestampAdjuster timestampAdjuster = (TimestampAdjuster) list.get(i2);
            synchronized (timestampAdjuster) {
                j4 = timestampAdjuster.f5741b;
            }
            boolean z = j4 == -9223372036854775807L;
            if (!z) {
                long jD = timestampAdjuster.d();
                z = (jD == -9223372036854775807L || jD == 0 || jD == j3) ? false : true;
            }
            if (z) {
                timestampAdjuster.f(j3);
            }
        }
        if (j3 != 0 && (tsBinarySearchSeeker = this.f9796m) != null) {
            tsBinarySearchSeeker.c(j3);
        }
        this.f9788e.G(0);
        this.f9789f.clear();
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.f9792i;
            if (i3 >= sparseArray.size()) {
                this.t = 0;
                return;
            } else {
                ((TsPayloadReader) sparseArray.valueAt(i3)).c();
                i3++;
            }
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        if ((this.f9785b & 1) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f9791h);
        }
        this.n = extractorOutput;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        r2 = r2 + 1;
     */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(androidx.media3.extractor.ExtractorInput r7) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r6 = this;
            androidx.media3.common.util.ParsableByteArray r0 = r6.f9788e
            byte[] r0 = r0.f5723a
            androidx.media3.extractor.DefaultExtractorInput r7 = (androidx.media3.extractor.DefaultExtractorInput) r7
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.b(r0, r1, r2, r1)
            r2 = r1
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r2 >= r3) goto L29
            r3 = r1
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r2
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r2 = r2 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.i(r2)
            r7 = 1
            return r7
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.TsExtractor.h(androidx.media3.extractor.ExtractorInput):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException, EOFException, InterruptedIOException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long jA;
        long j2;
        long j3 = ((DefaultExtractorInput) extractorInput).f8518c;
        int i7 = this.f9784a;
        boolean z = i7 == 2;
        if (this.p) {
            TsDurationReader tsDurationReader = this.f9795l;
            if (j3 != -1 && !z && !tsDurationReader.f9778c) {
                int i8 = this.u;
                if (i8 <= 0) {
                    tsDurationReader.a((DefaultExtractorInput) extractorInput);
                    return 0;
                }
                boolean z2 = tsDurationReader.f9780e;
                ParsableByteArray parsableByteArray = tsDurationReader.f9777b;
                if (z2) {
                    if (tsDurationReader.f9782g == -9223372036854775807L) {
                        tsDurationReader.a((DefaultExtractorInput) extractorInput);
                        return 0;
                    }
                    if (tsDurationReader.f9779d) {
                        long j4 = tsDurationReader.f9781f;
                        if (j4 == -9223372036854775807L) {
                            tsDurationReader.a((DefaultExtractorInput) extractorInput);
                            return 0;
                        }
                        TimestampAdjuster timestampAdjuster = tsDurationReader.f9776a;
                        tsDurationReader.f9783h = timestampAdjuster.c(tsDurationReader.f9782g) - timestampAdjuster.b(j4);
                        tsDurationReader.a((DefaultExtractorInput) extractorInput);
                        return 0;
                    }
                    DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
                    int iMin = (int) Math.min(112800, defaultExtractorInput.f8518c);
                    long j5 = 0;
                    if (defaultExtractorInput.f8519d != j5) {
                        positionHolder.f8599a = j5;
                        return 1;
                    }
                    parsableByteArray.G(iMin);
                    defaultExtractorInput.f8521f = 0;
                    defaultExtractorInput.b(parsableByteArray.f5723a, 0, iMin, false);
                    int i9 = parsableByteArray.f5724b;
                    int i10 = parsableByteArray.f5725c;
                    while (true) {
                        if (i9 >= i10) {
                            jA = -9223372036854775807L;
                            break;
                        }
                        if (parsableByteArray.f5723a[i9] == 71) {
                            jA = TsUtil.a(parsableByteArray, i9, i8);
                            if (jA != -9223372036854775807L) {
                                break;
                            }
                        }
                        i9++;
                    }
                    tsDurationReader.f9781f = jA;
                    tsDurationReader.f9779d = true;
                    return 0;
                }
                DefaultExtractorInput defaultExtractorInput2 = (DefaultExtractorInput) extractorInput;
                long j6 = defaultExtractorInput2.f8518c;
                int iMin2 = (int) Math.min(112800, j6);
                long j7 = j6 - iMin2;
                if (defaultExtractorInput2.f8519d != j7) {
                    positionHolder.f8599a = j7;
                    return 1;
                }
                parsableByteArray.G(iMin2);
                defaultExtractorInput2.f8521f = 0;
                defaultExtractorInput2.b(parsableByteArray.f5723a, 0, iMin2, false);
                int i11 = parsableByteArray.f5724b;
                int i12 = parsableByteArray.f5725c;
                int i13 = i12 - 188;
                while (true) {
                    if (i13 < i11) {
                        j2 = -9223372036854775807L;
                        break;
                    }
                    byte[] bArr = parsableByteArray.f5723a;
                    int i14 = -4;
                    int i15 = 0;
                    while (true) {
                        if (i14 > 4) {
                            break;
                        }
                        int i16 = (i14 * 188) + i13;
                        if (i16 < i11 || i16 >= i12 || bArr[i16] != 71) {
                            i15 = 0;
                        } else {
                            i15++;
                            if (i15 == 5) {
                                long jA2 = TsUtil.a(parsableByteArray, i13, i8);
                                if (jA2 != -9223372036854775807L) {
                                    j2 = jA2;
                                    break;
                                }
                            }
                        }
                        i14++;
                    }
                    i13--;
                }
                tsDurationReader.f9782g = j2;
                tsDurationReader.f9780e = true;
                return 0;
            }
            if (this.q) {
                i3 = i7;
            } else {
                this.q = true;
                long j8 = tsDurationReader.f9783h;
                if (j8 != -9223372036854775807L) {
                    i3 = i7;
                    TsBinarySearchSeeker tsBinarySearchSeeker = new TsBinarySearchSeeker(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new TsBinarySearchSeeker.TsPcrSeeker(this.u, tsDurationReader.f9776a, this.f9786c), j8, 1 + j8, 0L, j3, 188L, 940);
                    this.f9796m = tsBinarySearchSeeker;
                    this.n.c(tsBinarySearchSeeker.f8481a);
                } else {
                    i3 = i7;
                    this.n.c(new SeekMap.Unseekable(j8));
                }
            }
            if (this.r) {
                this.r = false;
                a(0L, 0L);
                if (((DefaultExtractorInput) extractorInput).f8519d != 0) {
                    positionHolder.f8599a = 0L;
                    return 1;
                }
            }
            i2 = 1;
            TsBinarySearchSeeker tsBinarySearchSeeker2 = this.f9796m;
            if (tsBinarySearchSeeker2 != null && tsBinarySearchSeeker2.f8483c != null) {
                return tsBinarySearchSeeker2.a((DefaultExtractorInput) extractorInput, positionHolder);
            }
        } else {
            i2 = 1;
            i3 = i7;
        }
        ParsableByteArray parsableByteArray2 = this.f9788e;
        byte[] bArr2 = parsableByteArray2.f5723a;
        if (9400 - parsableByteArray2.f5724b < 188) {
            int iA = parsableByteArray2.a();
            if (iA > 0) {
                System.arraycopy(bArr2, parsableByteArray2.f5724b, bArr2, 0, iA);
            }
            parsableByteArray2.H(iA, bArr2);
        }
        while (true) {
            int iA2 = parsableByteArray2.a();
            SparseArray sparseArray = this.f9792i;
            if (iA2 >= 188) {
                int i17 = parsableByteArray2.f5724b;
                int i18 = parsableByteArray2.f5725c;
                byte[] bArr3 = parsableByteArray2.f5723a;
                int i19 = i17;
                while (i19 < i18 && bArr3[i19] != 71) {
                    i19++;
                }
                parsableByteArray2.J(i19);
                int i20 = i19 + 188;
                if (i20 > i18) {
                    int i21 = (i19 - i17) + this.t;
                    this.t = i21;
                    i4 = i3;
                    i5 = 2;
                    if (i4 == 2 && i21 > 376) {
                        throw ParserException.a(null, "Cannot find sync byte. Most likely not a Transport Stream.");
                    }
                } else {
                    i4 = i3;
                    i5 = 2;
                    this.t = 0;
                }
                int i22 = parsableByteArray2.f5725c;
                if (i20 > i22) {
                    return 0;
                }
                int iJ = parsableByteArray2.j();
                if ((8388608 & iJ) != 0) {
                    parsableByteArray2.J(i20);
                    return 0;
                }
                int i23 = (4194304 & iJ) != 0 ? i2 : 0;
                int i24 = (2096896 & iJ) >> 8;
                int i25 = (iJ & 32) != 0 ? i2 : 0;
                TsPayloadReader tsPayloadReader = (iJ & 16) != 0 ? (TsPayloadReader) sparseArray.get(i24) : null;
                if (tsPayloadReader == null) {
                    parsableByteArray2.J(i20);
                    return 0;
                }
                if (i4 != i5) {
                    int i26 = iJ & 15;
                    SparseIntArray sparseIntArray = this.f9789f;
                    i6 = i2;
                    int i27 = sparseIntArray.get(i24, i26 - 1);
                    sparseIntArray.put(i24, i26);
                    if (i27 == i26) {
                        parsableByteArray2.J(i20);
                        return 0;
                    }
                    if (i26 != ((i27 + 1) & 15)) {
                        tsPayloadReader.c();
                    }
                } else {
                    i6 = i2;
                }
                if (i25 != 0) {
                    int iX = parsableByteArray2.x();
                    i23 |= (parsableByteArray2.x() & 64) != 0 ? i5 : 0;
                    parsableByteArray2.K(iX - 1);
                }
                boolean z3 = this.p;
                if (i4 == i5 || z3 || !this.f9794k.get(i24, false)) {
                    parsableByteArray2.I(i20);
                    tsPayloadReader.a(i23, parsableByteArray2);
                    parsableByteArray2.I(i22);
                }
                if (i4 != i5 && !z3 && this.p && j3 != -1) {
                    this.r = i6;
                }
                parsableByteArray2.J(i20);
                return 0;
            }
            int i28 = parsableByteArray2.f5725c;
            int i29 = ((DefaultExtractorInput) extractorInput).read(bArr2, i28, 9400 - i28);
            if (i29 == -1) {
                for (int i30 = 0; i30 < sparseArray.size(); i30++) {
                    TsPayloadReader tsPayloadReader2 = (TsPayloadReader) sparseArray.valueAt(i30);
                    if (tsPayloadReader2 instanceof PesReader) {
                        PesReader pesReader = (PesReader) tsPayloadReader2;
                        if (pesReader.f9726c == 3 && pesReader.f9733j == -1 && (!z || !(pesReader.f9724a instanceof H262Reader))) {
                            pesReader.a(i2, new ParsableByteArray());
                        }
                    }
                }
                return -1;
            }
            parsableByteArray2.I(i28 + i29);
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }

    public TsExtractor(int i2, int i3, SubtitleParser.Factory factory, TimestampAdjuster timestampAdjuster, DefaultTsPayloadReaderFactory defaultTsPayloadReaderFactory) {
        this.f9790g = defaultTsPayloadReaderFactory;
        this.f9786c = 112800;
        this.f9784a = i2;
        this.f9785b = i3;
        this.f9791h = factory;
        if (i2 == 1 || i2 == 2) {
            this.f9787d = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f9787d = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.f9788e = new ParsableByteArray(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.f9793j = sparseBooleanArray;
        this.f9794k = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.f9792i = sparseArray;
        this.f9789f = new SparseIntArray();
        this.f9795l = new TsDurationReader();
        this.n = ExtractorOutput.g0;
        this.u = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i4 = 0; i4 < size; i4++) {
            sparseArray.put(sparseArray2.keyAt(i4), (TsPayloadReader) sparseArray2.valueAt(i4));
        }
        sparseArray.put(0, new SectionReader(new PatReader()));
        this.s = null;
    }
}
