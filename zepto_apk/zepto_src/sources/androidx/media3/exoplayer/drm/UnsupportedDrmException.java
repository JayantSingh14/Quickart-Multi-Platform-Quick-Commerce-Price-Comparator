package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class UnsupportedDrmException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f6948a;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Reason {
    }

    public UnsupportedDrmException() {
        this.f6948a = 1;
    }

    public UnsupportedDrmException(int i2, Exception exc) {
        super(exc);
        this.f6948a = i2;
    }
}
