package androidx.media3.extractor.text;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.dvb.DvbParser;
import androidx.media3.extractor.text.pgs.PgsParser;
import androidx.media3.extractor.text.ssa.SsaParser;
import androidx.media3.extractor.text.subrip.SubripParser;
import androidx.media3.extractor.text.ttml.TtmlParser;
import androidx.media3.extractor.text.tx3g.Tx3gParser;
import androidx.media3.extractor.text.webvtt.Mp4WebvttParser;
import androidx.media3.extractor.text.webvtt.WebvttParser;
import java.util.List;
import java.util.Objects;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultSubtitleParserFactory implements SubtitleParser.Factory {
    @Override // androidx.media3.extractor.text.SubtitleParser.Factory
    public final int a(Format format) {
        String str = format.f5225m;
        if (str != null) {
            switch (str) {
                case "application/dvbsubs":
                case "application/pgs":
                case "application/x-mp4-vtt":
                    return 2;
                case "text/vtt":
                    return 1;
                case "application/x-quicktime-tx3g":
                    return 2;
                case "text/x-ssa":
                case "application/x-subrip":
                case "application/ttml+xml":
                    return 1;
            }
        }
        throw new IllegalArgumentException(android.support.v4.media.b.C("Unsupported MIME type: ", str));
    }

    @Override // androidx.media3.extractor.text.SubtitleParser.Factory
    public final boolean b(Format format) {
        String str = format.f5225m;
        return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
    }

    @Override // androidx.media3.extractor.text.SubtitleParser.Factory
    public final SubtitleParser c(Format format) {
        List list;
        String str = format.f5225m;
        if (str != null) {
            list = format.p;
            switch (str) {
                case "application/dvbsubs":
                    return new DvbParser(list);
                case "application/pgs":
                    return new PgsParser();
                case "application/x-mp4-vtt":
                    return new Mp4WebvttParser();
                case "text/vtt":
                    return new WebvttParser();
                case "application/x-quicktime-tx3g":
                    return new Tx3gParser(list);
                case "text/x-ssa":
                    return new SsaParser(list);
                case "application/x-subrip":
                    return new SubripParser();
                case "application/ttml+xml":
                    return new TtmlParser();
            }
        }
        throw new IllegalArgumentException(android.support.v4.media.b.C("Unsupported MIME type: ", str));
    }
}
