package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public interface ExtractorOutput {
    public static final ExtractorOutput g0 = new AnonymousClass1();

    /* renamed from: androidx.media3.extractor.ExtractorOutput$1, reason: invalid class name */
    public class AnonymousClass1 implements ExtractorOutput {
        @Override // androidx.media3.extractor.ExtractorOutput
        public final void c(SeekMap seekMap) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public final void m() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public final TrackOutput n(int i2, int i3) {
            throw new UnsupportedOperationException();
        }
    }

    void c(SeekMap seekMap);

    void m();

    TrackOutput n(int i2, int i3);
}
