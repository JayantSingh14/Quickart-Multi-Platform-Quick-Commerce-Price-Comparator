package androidx.media3.exoplayer.hls;

import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import androidx.media3.extractor.text.webvtt.WebvttCueParser;
import androidx.media3.extractor.text.webvtt.WebvttParserUtil;
import com.google.common.base.Charsets;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UnstableApi
/* loaded from: classes3.dex */
public final class WebvttExtractor implements Extractor {

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f7079i = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f7080j = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a, reason: collision with root package name */
    public final String f7081a;

    /* renamed from: b, reason: collision with root package name */
    public final TimestampAdjuster f7082b;

    /* renamed from: d, reason: collision with root package name */
    public final SubtitleParser.Factory f7084d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7085e;

    /* renamed from: f, reason: collision with root package name */
    public ExtractorOutput f7086f;

    /* renamed from: h, reason: collision with root package name */
    public int f7088h;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f7083c = new ParsableByteArray();

    /* renamed from: g, reason: collision with root package name */
    public byte[] f7087g = new byte[1024];

    public WebvttExtractor(String str, TimestampAdjuster timestampAdjuster, SubtitleParser.Factory factory, boolean z) {
        this.f7081a = str;
        this.f7082b = timestampAdjuster;
        this.f7084d = factory;
        this.f7085e = z;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        throw new IllegalStateException();
    }

    public final TrackOutput b(long j2) {
        TrackOutput trackOutputN = this.f7086f.n(0, 3);
        Format.Builder builder = new Format.Builder();
        builder.f5237l = MimeTypes.p("text/vtt");
        builder.f5229d = this.f7081a;
        builder.q = j2;
        android.support.v4.media.a.s(builder, trackOutputN);
        this.f7086f.m();
        return trackOutputN;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f7086f = this.f7085e ? new SubtitleTranscodingExtractorOutput(extractorOutput, this.f7084d) : extractorOutput;
        extractorOutput.c(new SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        DefaultExtractorInput defaultExtractorInput = (DefaultExtractorInput) extractorInput;
        defaultExtractorInput.b(this.f7087g, 0, 6, false);
        byte[] bArr = this.f7087g;
        ParsableByteArray parsableByteArray = this.f7083c;
        parsableByteArray.H(6, bArr);
        if (WebvttParserUtil.a(parsableByteArray)) {
            return true;
        }
        defaultExtractorInput.b(this.f7087g, 6, 3, false);
        parsableByteArray.H(9, this.f7087g);
        return WebvttParserUtil.a(parsableByteArray);
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException, EOFException, InterruptedIOException {
        String strK;
        this.f7086f.getClass();
        int i2 = (int) ((DefaultExtractorInput) extractorInput).f8518c;
        int i3 = this.f7088h;
        byte[] bArr = this.f7087g;
        int i4 = -1;
        if (i3 == bArr.length) {
            this.f7087g = Arrays.copyOf(bArr, ((i2 != -1 ? i2 : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f7087g;
        int i5 = this.f7088h;
        int i6 = ((DefaultExtractorInput) extractorInput).read(bArr2, i5, bArr2.length - i5);
        if (i6 != -1) {
            int i7 = this.f7088h + i6;
            this.f7088h = i7;
            if (i2 == -1 || i7 != i2) {
                return 0;
            }
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.f7087g);
        WebvttParserUtil.d(parsableByteArray);
        String strK2 = parsableByteArray.k(Charsets.f42260c);
        long j2 = 0;
        long jC = 0;
        while (true) {
            int i8 = i4;
            Matcher matcher = null;
            if (TextUtils.isEmpty(strK2)) {
                while (true) {
                    String strK3 = parsableByteArray.k(Charsets.f42260c);
                    if (strK3 == null) {
                        break;
                    }
                    if (WebvttParserUtil.f9479a.matcher(strK3).matches()) {
                        do {
                            strK = parsableByteArray.k(Charsets.f42260c);
                            if (strK != null) {
                            }
                        } while (!strK.isEmpty());
                    } else {
                        Matcher matcher2 = WebvttCueParser.f9453a.matcher(strK3);
                        if (matcher2.matches()) {
                            matcher = matcher2;
                            break;
                        }
                    }
                }
                if (matcher == null) {
                    b(0L);
                    return i8;
                }
                String strGroup = matcher.group(1);
                strGroup.getClass();
                long jC2 = WebvttParserUtil.c(strGroup);
                long jB = this.f7082b.b(((((j2 + jC2) - jC) * 90000) / 1000000) % 8589934592L);
                TrackOutput trackOutputB = b(jB - jC2);
                byte[] bArr3 = this.f7087g;
                int i9 = this.f7088h;
                ParsableByteArray parsableByteArray2 = this.f7083c;
                parsableByteArray2.H(i9, bArr3);
                trackOutputB.e(this.f7088h, parsableByteArray2);
                trackOutputB.f(jB, 1, this.f7088h, 0, null);
                return i8;
            }
            if (strK2.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher3 = f7079i.matcher(strK2);
                if (!matcher3.find()) {
                    throw ParserException.a(null, "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(strK2));
                }
                Matcher matcher4 = f7080j.matcher(strK2);
                if (!matcher4.find()) {
                    throw ParserException.a(null, "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(strK2));
                }
                String strGroup2 = matcher3.group(1);
                strGroup2.getClass();
                jC = WebvttParserUtil.c(strGroup2);
                String strGroup3 = matcher4.group(1);
                strGroup3.getClass();
                j2 = (Long.parseLong(strGroup3) * 1000000) / 90000;
            }
            strK2 = parsableByteArray.k(Charsets.f42260c);
            i4 = i8;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
