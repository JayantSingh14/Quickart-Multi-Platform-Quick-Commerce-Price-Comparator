package androidx.media3.exoplayer.metadata;

import android.support.v4.media.b;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.metadata.emsg.EventMessageDecoder;
import androidx.media3.extractor.metadata.icy.IcyDecoder;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.metadata.scte35.SpliceInfoDecoder;

@UnstableApi
/* loaded from: classes3.dex */
public interface MetadataDecoderFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final MetadataDecoderFactory f7361a = new AnonymousClass1();

    /* renamed from: androidx.media3.exoplayer.metadata.MetadataDecoderFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements MetadataDecoderFactory {
        public final SimpleMetadataDecoder a(Format format) {
            String str = format.f5225m;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new AppInfoTableDecoder();
                    case "application/x-icy":
                        return new IcyDecoder();
                    case "application/id3":
                        return new Id3Decoder();
                    case "application/x-emsg":
                        return new EventMessageDecoder();
                    case "application/x-scte35":
                        return new SpliceInfoDecoder();
                }
            }
            throw new IllegalArgumentException(b.C("Attempted to create decoder for unsupported MIME type: ", str));
        }

        public final boolean b(Format format) {
            String str = format.f5225m;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }
    }
}
