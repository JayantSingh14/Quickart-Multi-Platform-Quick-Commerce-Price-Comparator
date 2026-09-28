package androidx.media3.extractor.mp3;

import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.Id3Peeker;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.TrackOutput;
import java.io.EOFException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class Mp3Extractor implements Extractor {
    public static final /* synthetic */ int t = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f8942a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f8943b;

    /* renamed from: c, reason: collision with root package name */
    public final MpegAudioUtil.Header f8944c;

    /* renamed from: d, reason: collision with root package name */
    public final GaplessInfoHolder f8945d;

    /* renamed from: e, reason: collision with root package name */
    public final Id3Peeker f8946e;

    /* renamed from: f, reason: collision with root package name */
    public final DiscardingTrackOutput f8947f;

    /* renamed from: g, reason: collision with root package name */
    public ExtractorOutput f8948g;

    /* renamed from: h, reason: collision with root package name */
    public TrackOutput f8949h;

    /* renamed from: i, reason: collision with root package name */
    public TrackOutput f8950i;

    /* renamed from: j, reason: collision with root package name */
    public int f8951j;

    /* renamed from: k, reason: collision with root package name */
    public Metadata f8952k;

    /* renamed from: l, reason: collision with root package name */
    public long f8953l;

    /* renamed from: m, reason: collision with root package name */
    public long f8954m;
    public long n;
    public int o;
    public Seeker p;
    public boolean q;
    public boolean r;
    public long s;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public Mp3Extractor() {
        this(0);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f8951j = 0;
        this.f8953l = -9223372036854775807L;
        this.f8954m = 0L;
        this.o = 0;
        this.s = j3;
        Seeker seeker = this.p;
        if (!(seeker instanceof IndexSeeker) || ((IndexSeeker) seeker).a(j3)) {
            return;
        }
        this.r = true;
        this.f8950i = this.f8947f;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(androidx.media3.extractor.DefaultExtractorInput r9) {
        /*
            r8 = this;
            androidx.media3.extractor.mp3.Seeker r0 = r8.p
            r1 = 1
            if (r0 == 0) goto L1b
            long r2 = r0.f()
            r4 = -1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L1b
            long r4 = r9.g()
            r6 = 4
            long r2 = r2 - r6
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L1b
            goto L27
        L1b:
            androidx.media3.common.util.ParsableByteArray r0 = r8.f8943b     // Catch: java.io.EOFException -> L27
            byte[] r0 = r0.f5723a     // Catch: java.io.EOFException -> L27
            r2 = 0
            r3 = 4
            boolean r9 = r9.b(r0, r2, r3, r1)     // Catch: java.io.EOFException -> L27
            r9 = r9 ^ r1
            return r9
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp3.Mp3Extractor.b(androidx.media3.extractor.DefaultExtractorInput):boolean");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f8948g = extractorOutput;
        TrackOutput trackOutputN = extractorOutput.n(0, 1);
        this.f8949h = trackOutputN;
        this.f8950i = trackOutputN;
        this.f8948g.m();
    }

    public final boolean d(DefaultExtractorInput defaultExtractorInput, boolean z) throws Throwable {
        int iG;
        int i2;
        int iA;
        int i3 = z ? 32768 : 131072;
        defaultExtractorInput.f8521f = 0;
        if (defaultExtractorInput.f8519d == 0) {
            Metadata metadataA = this.f8946e.a(defaultExtractorInput, null);
            this.f8952k = metadataA;
            if (metadataA != null) {
                this.f8945d.b(metadataA);
            }
            iG = (int) defaultExtractorInput.g();
            if (!z) {
                defaultExtractorInput.i(iG);
            }
            i2 = 0;
        } else {
            iG = 0;
            i2 = 0;
        }
        int i4 = i2;
        int i5 = i4;
        while (true) {
            if (!b(defaultExtractorInput)) {
                ParsableByteArray parsableByteArray = this.f8943b;
                parsableByteArray.J(0);
                int iJ = parsableByteArray.j();
                if ((i2 == 0 || ((-128000) & iJ) == (i2 & (-128000))) && (iA = MpegAudioUtil.a(iJ)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.f8944c.a(iJ);
                        i2 = iJ;
                    }
                    defaultExtractorInput.l(iA - 4, false);
                } else {
                    int i6 = i5 + 1;
                    if (i5 == i3) {
                        if (z) {
                            return false;
                        }
                        throw ParserException.a(null, "Searched too many bytes.");
                    }
                    if (z) {
                        defaultExtractorInput.f8521f = 0;
                        defaultExtractorInput.l(iG + i6, false);
                    } else {
                        defaultExtractorInput.i(1);
                    }
                    i4 = 0;
                    i5 = i6;
                    i2 = 0;
                }
            } else if (i4 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            defaultExtractorInput.i(iG + i5);
        } else {
            defaultExtractorInput.f8521f = 0;
        }
        this.f8951j = i2;
        return true;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        return d((DefaultExtractorInput) extractorInput, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0340 A[LOOP:2: B:149:0x033e->B:150:0x0340, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.media3.extractor.ExtractorInput r63, androidx.media3.extractor.PositionHolder r64) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp3.Mp3Extractor.j(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }

    public Mp3Extractor(int i2) {
        this(-9223372036854775807L);
    }

    public Mp3Extractor(long j2) {
        this.f8942a = j2;
        this.f8943b = new ParsableByteArray(10);
        this.f8944c = new MpegAudioUtil.Header();
        this.f8945d = new GaplessInfoHolder();
        this.f8953l = -9223372036854775807L;
        this.f8946e = new Id3Peeker();
        DiscardingTrackOutput discardingTrackOutput = new DiscardingTrackOutput();
        this.f8947f = discardingTrackOutput;
        this.f8950i = discardingTrackOutput;
    }
}
