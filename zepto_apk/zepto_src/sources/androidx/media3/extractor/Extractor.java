package androidx.media3.extractor;

import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public interface Extractor {

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReadResult {
    }

    void a(long j2, long j3);

    void c(ExtractorOutput extractorOutput);

    default Extractor e() {
        return this;
    }

    boolean h(ExtractorInput extractorInput);

    default List i() {
        return ImmutableList.r();
    }

    int j(ExtractorInput extractorInput, PositionHolder positionHolder);

    void release();
}
