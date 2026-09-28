package androidx.media3.extractor.jpeg;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SingleSampleExtractor;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class JpegExtractor implements Extractor {

    /* renamed from: a, reason: collision with root package name */
    public final Extractor f8741a;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public JpegExtractor() {
        this(0);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f8741a.a(j2, j3);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        this.f8741a.c(extractorOutput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        return this.f8741a.h(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        return this.f8741a.j(extractorInput, positionHolder);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
        this.f8741a.release();
    }

    public JpegExtractor(int i2) {
        if ((i2 & 1) != 0) {
            this.f8741a = new SingleSampleExtractor(65496, 2, "image/jpeg");
        } else {
            this.f8741a = new JpegMotionPhotoExtractor();
        }
    }
}
