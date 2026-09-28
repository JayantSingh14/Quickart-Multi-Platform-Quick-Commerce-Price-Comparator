package androidx.media3.extractor.avi;

import androidx.media3.common.Format;

/* loaded from: classes3.dex */
final class StreamFormatChunk implements AviChunk {

    /* renamed from: a, reason: collision with root package name */
    public final Format f8691a;

    public StreamFormatChunk(Format format) {
        this.f8691a = format;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public final int getType() {
        return 1718776947;
    }
}
