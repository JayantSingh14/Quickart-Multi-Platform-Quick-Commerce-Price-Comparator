package androidx.media3.extractor.flv;

import androidx.media3.common.ParserException;
import androidx.media3.extractor.TrackOutput;

/* loaded from: classes3.dex */
abstract class TagPayloadReader {

    /* renamed from: a, reason: collision with root package name */
    public final TrackOutput f8732a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(TrackOutput trackOutput) {
        this.f8732a = trackOutput;
    }
}
