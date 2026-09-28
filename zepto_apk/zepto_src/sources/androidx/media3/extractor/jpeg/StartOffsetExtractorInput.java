package androidx.media3.extractor.jpeg;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.ForwardingExtractorInput;

/* loaded from: classes3.dex */
final class StartOffsetExtractorInput extends ForwardingExtractorInput {

    /* renamed from: b, reason: collision with root package name */
    public final long f8757b;

    public StartOffsetExtractorInput(DefaultExtractorInput defaultExtractorInput, long j2) {
        super(defaultExtractorInput);
        Assertions.a(defaultExtractorInput.f8519d >= j2);
        this.f8757b = j2;
    }

    @Override // androidx.media3.extractor.ForwardingExtractorInput, androidx.media3.extractor.ExtractorInput
    public final long g() {
        return super.g() - this.f8757b;
    }

    @Override // androidx.media3.extractor.ForwardingExtractorInput, androidx.media3.extractor.ExtractorInput
    public final long getLength() {
        return super.getLength() - this.f8757b;
    }

    @Override // androidx.media3.extractor.ForwardingExtractorInput, androidx.media3.extractor.ExtractorInput
    public final long getPosition() {
        return super.getPosition() - this.f8757b;
    }
}
