package androidx.media3.exoplayer.hls;

import android.media.MediaParser;
import android.media.MediaParser$SeekableInputReader;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.mediaparser.InputReaderAdapterV30;
import androidx.media3.exoplayer.source.mediaparser.MediaParserUtil;
import androidx.media3.exoplayer.source.mediaparser.OutputConsumerAdapterV30;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.InterruptedIOException;

@RequiresApi
@UnstableApi
/* loaded from: classes3.dex */
public final class MediaParserHlsMediaChunkExtractor implements HlsMediaChunkExtractor {

    /* renamed from: a, reason: collision with root package name */
    public final OutputConsumerAdapterV30 f7069a;

    /* renamed from: b, reason: collision with root package name */
    public final InputReaderAdapterV30 f7070b = new InputReaderAdapterV30();

    /* renamed from: c, reason: collision with root package name */
    public final MediaParser f7071c;

    /* renamed from: d, reason: collision with root package name */
    public final Format f7072d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f7073e;

    /* renamed from: f, reason: collision with root package name */
    public final ImmutableList f7074f;

    /* renamed from: g, reason: collision with root package name */
    public final PlayerId f7075g;

    /* renamed from: h, reason: collision with root package name */
    public int f7076h;

    public static final class PeekingInputReader implements MediaParser$SeekableInputReader {

        /* renamed from: a, reason: collision with root package name */
        public int f7077a;

        public final long getLength() {
            throw null;
        }

        public final long getPosition() {
            throw null;
        }

        public final int read(byte[] bArr, int i2, int i3) {
            throw null;
        }

        public final void seekToPosition(long j2) {
            throw new UnsupportedOperationException();
        }
    }

    public MediaParserHlsMediaChunkExtractor(MediaParser mediaParser, OutputConsumerAdapterV30 outputConsumerAdapterV30, Format format, boolean z, ImmutableList immutableList, int i2, PlayerId playerId) {
        this.f7071c = mediaParser;
        this.f7069a = outputConsumerAdapterV30;
        this.f7073e = z;
        this.f7074f = immutableList;
        this.f7072d = format;
        this.f7075g = playerId;
        this.f7076h = i2;
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final boolean a(DefaultExtractorInput defaultExtractorInput) throws EOFException, InterruptedIOException {
        defaultExtractorInput.i(this.f7076h);
        this.f7076h = 0;
        InputReaderAdapterV30 inputReaderAdapterV30 = this.f7070b;
        inputReaderAdapterV30.f7921a = defaultExtractorInput;
        inputReaderAdapterV30.f7922b = defaultExtractorInput.f8518c;
        inputReaderAdapterV30.f7924d = -1L;
        return this.f7071c.advance(inputReaderAdapterV30);
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f7069a.f7933i = extractorOutput;
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final void d() {
        MediaParser mediaParser = this.f7071c;
        MediaParser.SeekPoint unused = MediaParser.SeekPoint.START;
        mediaParser.seek(MediaParser.SeekPoint.START);
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final boolean e() {
        String parserName = this.f7071c.getParserName();
        return "android.media.mediaparser.FragmentedMp4Parser".equals(parserName) || "android.media.mediaparser.TsParser".equals(parserName);
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final boolean f() {
        String parserName = this.f7071c.getParserName();
        return "android.media.mediaparser.Ac3Parser".equals(parserName) || "android.media.mediaparser.Ac4Parser".equals(parserName) || "android.media.mediaparser.AdtsParser".equals(parserName) || "android.media.mediaparser.Mp3Parser".equals(parserName);
    }

    @Override // androidx.media3.exoplayer.hls.HlsMediaChunkExtractor
    public final HlsMediaChunkExtractor g() {
        Assertions.g(!e());
        String[] strArr = {this.f7071c.getParserName()};
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = this.f7069a;
        ImmutableList immutableList = this.f7074f;
        PlayerId playerId = this.f7075g;
        Format format = this.f7072d;
        boolean z = this.f7073e;
        MediaParser mediaParserCreateByName = strArr.length == 1 ? MediaParser.createByName(strArr[0], outputConsumerAdapterV30) : MediaParser.create(outputConsumerAdapterV30, strArr);
        mediaParserCreateByName.setParameter("android.media.mediaParser.exposeCaptionFormats", immutableList);
        mediaParserCreateByName.setParameter("android.media.mediaParser.overrideInBandCaptionDeclarations", Boolean.valueOf(z));
        mediaParserCreateByName.setParameter("android.media.mediaparser.inBandCryptoInfo", Boolean.TRUE);
        mediaParserCreateByName.setParameter("android.media.mediaparser.eagerlyExposeTrackType", Boolean.TRUE);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ignoreTimestampOffset", Boolean.TRUE);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreSpliceInfoStream", Boolean.TRUE);
        mediaParserCreateByName.setParameter("android.media.mediaparser.ts.mode", "hls");
        String str = format.f5222j;
        if (!TextUtils.isEmpty(str)) {
            if (!"audio/mp4a-latm".equals(MimeTypes.b(str))) {
                mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreAacStream", Boolean.TRUE);
            }
            if (!"video/avc".equals(MimeTypes.k(str))) {
                mediaParserCreateByName.setParameter("android.media.mediaparser.ts.ignoreAvcStream", Boolean.TRUE);
            }
        }
        if (Util.f5744a >= 31) {
            MediaParserUtil.a(mediaParserCreateByName, playerId);
        }
        return new MediaParserHlsMediaChunkExtractor(mediaParserCreateByName, outputConsumerAdapterV30, this.f7072d, this.f7073e, immutableList, 0, this.f7075g);
    }
}
