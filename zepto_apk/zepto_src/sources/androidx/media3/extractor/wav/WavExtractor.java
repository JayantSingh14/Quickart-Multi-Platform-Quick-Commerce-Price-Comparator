package androidx.media3.extractor.wav;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import java.math.RoundingMode;
import org.xbill.DNS.WKSRecord;

@UnstableApi
/* loaded from: classes3.dex */
public final class WavExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public ExtractorOutput f9817a;

    /* renamed from: b, reason: collision with root package name */
    public TrackOutput f9818b;

    /* renamed from: e, reason: collision with root package name */
    public OutputWriter f9821e;

    /* renamed from: c, reason: collision with root package name */
    public int f9819c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f9820d = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f9822f = -1;

    /* renamed from: g, reason: collision with root package name */
    public long f9823g = -1;

    public static final class ImaAdPcmOutputWriter implements OutputWriter {

        /* renamed from: m, reason: collision with root package name */
        public static final int[] f9824m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        public static final int[] n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, WKSRecord.Service.CISCO_FNA, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: a, reason: collision with root package name */
        public final ExtractorOutput f9825a;

        /* renamed from: b, reason: collision with root package name */
        public final TrackOutput f9826b;

        /* renamed from: c, reason: collision with root package name */
        public final WavFormat f9827c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9828d;

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f9829e;

        /* renamed from: f, reason: collision with root package name */
        public final ParsableByteArray f9830f;

        /* renamed from: g, reason: collision with root package name */
        public final int f9831g;

        /* renamed from: h, reason: collision with root package name */
        public final Format f9832h;

        /* renamed from: i, reason: collision with root package name */
        public int f9833i;

        /* renamed from: j, reason: collision with root package name */
        public long f9834j;

        /* renamed from: k, reason: collision with root package name */
        public int f9835k;

        /* renamed from: l, reason: collision with root package name */
        public long f9836l;

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat) throws ParserException {
            this.f9825a = extractorOutput;
            this.f9826b = trackOutput;
            this.f9827c = wavFormat;
            int i2 = wavFormat.f9846b;
            int iMax = Math.max(1, i2 / 10);
            this.f9831g = iMax;
            ParsableByteArray parsableByteArray = new ParsableByteArray(wavFormat.f9849e);
            parsableByteArray.q();
            int iQ = parsableByteArray.q();
            this.f9828d = iQ;
            int i3 = wavFormat.f9845a;
            int i4 = wavFormat.f9847c;
            int i5 = (((i4 - (i3 * 4)) * 8) / (wavFormat.f9848d * i3)) + 1;
            if (iQ != i5) {
                throw ParserException.a(null, "Expected frames per block: " + i5 + "; got: " + iQ);
            }
            int iG = Util.g(iMax, iQ);
            this.f9829e = new byte[iG * i4];
            this.f9830f = new ParsableByteArray(iQ * 2 * i3 * iG);
            int i6 = ((i4 * i2) * 8) / iQ;
            Format.Builder builder = new Format.Builder();
            builder.f5237l = MimeTypes.p("audio/raw");
            builder.f5232g = i6;
            builder.f5233h = i6;
            builder.f5238m = iMax * 2 * i3;
            builder.z = i3;
            builder.A = i2;
            builder.B = 2;
            this.f9832h = new Format(builder);
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final void a(int i2, long j2) {
            this.f9825a.c(new WavSeekMap(this.f9827c, this.f9828d, i2, j2));
            this.f9826b.b(this.f9832h);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0045 A[ADDED_TO_REGION, EDGE_INSN: B:43:0x0045->B:14:0x0045 BREAK  A[LOOP:0: B:6:0x0023->B:13:0x003f], REMOVE, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003c -> B:4:0x0020). Please report as a decompilation issue!!! */
        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean b(androidx.media3.extractor.DefaultExtractorInput r25, long r26) {
            /*
                Method dump skipped, instructions count: 327
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.wav.WavExtractor.ImaAdPcmOutputWriter.b(androidx.media3.extractor.DefaultExtractorInput, long):boolean");
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final void c(long j2) {
            this.f9833i = 0;
            this.f9834j = j2;
            this.f9835k = 0;
            this.f9836l = 0L;
        }

        public final void d(int i2) {
            long j2 = this.f9834j;
            long j3 = this.f9836l;
            WavFormat wavFormat = this.f9827c;
            long j4 = wavFormat.f9846b;
            int i3 = Util.f5744a;
            long jB0 = j2 + Util.b0(j3, 1000000L, j4, RoundingMode.FLOOR);
            int i4 = i2 * 2 * wavFormat.f9845a;
            this.f9826b.f(jB0, 1, i4, this.f9835k - i4, null);
            this.f9836l += i2;
            this.f9835k -= i4;
        }
    }

    public interface OutputWriter {
        void a(int i2, long j2);

        boolean b(DefaultExtractorInput defaultExtractorInput, long j2);

        void c(long j2);
    }

    public static final class PassthroughOutputWriter implements OutputWriter {

        /* renamed from: a, reason: collision with root package name */
        public final ExtractorOutput f9837a;

        /* renamed from: b, reason: collision with root package name */
        public final TrackOutput f9838b;

        /* renamed from: c, reason: collision with root package name */
        public final WavFormat f9839c;

        /* renamed from: d, reason: collision with root package name */
        public final Format f9840d;

        /* renamed from: e, reason: collision with root package name */
        public final int f9841e;

        /* renamed from: f, reason: collision with root package name */
        public long f9842f;

        /* renamed from: g, reason: collision with root package name */
        public int f9843g;

        /* renamed from: h, reason: collision with root package name */
        public long f9844h;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat, String str, int i2) throws ParserException {
            this.f9837a = extractorOutput;
            this.f9838b = trackOutput;
            this.f9839c = wavFormat;
            int i3 = wavFormat.f9848d;
            int i4 = wavFormat.f9845a;
            int i5 = (i3 * i4) / 8;
            int i6 = wavFormat.f9847c;
            if (i6 != i5) {
                throw ParserException.a(null, "Expected block size: " + i5 + "; got: " + i6);
            }
            int i7 = wavFormat.f9846b;
            int i8 = i7 * i5;
            int i9 = i8 * 8;
            int iMax = Math.max(i5, i8 / 10);
            this.f9841e = iMax;
            Format.Builder builder = new Format.Builder();
            builder.f5237l = MimeTypes.p(str);
            builder.f5232g = i9;
            builder.f5233h = i9;
            builder.f5238m = iMax;
            builder.z = i4;
            builder.A = i7;
            builder.B = i2;
            this.f9840d = new Format(builder);
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final void a(int i2, long j2) {
            this.f9837a.c(new WavSeekMap(this.f9839c, 1, i2, j2));
            this.f9838b.b(this.f9840d);
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final boolean b(DefaultExtractorInput defaultExtractorInput, long j2) {
            int i2;
            int i3;
            long j3 = j2;
            while (j3 > 0 && (i2 = this.f9843g) < (i3 = this.f9841e)) {
                int iC = this.f9838b.c(defaultExtractorInput, (int) Math.min(i3 - i2, j3), true);
                if (iC == -1) {
                    j3 = 0;
                } else {
                    this.f9843g += iC;
                    j3 -= iC;
                }
            }
            WavFormat wavFormat = this.f9839c;
            int i4 = this.f9843g;
            int i5 = wavFormat.f9847c;
            int i6 = i4 / i5;
            if (i6 > 0) {
                long j4 = this.f9842f;
                long j5 = this.f9844h;
                long j6 = wavFormat.f9846b;
                int i7 = Util.f5744a;
                long jB0 = j4 + Util.b0(j5, 1000000L, j6, RoundingMode.FLOOR);
                int i8 = i6 * i5;
                int i9 = this.f9843g - i8;
                this.f9838b.f(jB0, 1, i8, i9, null);
                this.f9844h += i6;
                this.f9843g = i9;
            }
            return j3 <= 0;
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final void c(long j2) {
            this.f9842f = j2;
            this.f9843g = 0;
            this.f9844h = 0L;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f9819c = j2 == 0 ? 0 : 4;
        OutputWriter outputWriter = this.f9821e;
        if (outputWriter != null) {
            outputWriter.c(j3);
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f9817a = extractorOutput;
        this.f9818b = extractorOutput.n(0, 1);
        extractorOutput.m();
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        return WavHeaderReader.a((DefaultExtractorInput) extractorInput);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x018b, code lost:
    
        if (r12 != 65534) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b4  */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.media3.extractor.ExtractorInput r25, androidx.media3.extractor.PositionHolder r26) throws androidx.media3.common.ParserException, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.wav.WavExtractor.j(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
