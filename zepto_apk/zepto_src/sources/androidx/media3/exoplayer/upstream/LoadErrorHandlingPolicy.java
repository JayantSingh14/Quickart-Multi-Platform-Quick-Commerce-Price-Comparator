package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public interface LoadErrorHandlingPolicy {

    public static final class FallbackOptions {

        /* renamed from: a, reason: collision with root package name */
        public final int f8156a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8157b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8158c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8159d;

        public FallbackOptions(int i2, int i3, int i4, int i5) {
            this.f8156a = i2;
            this.f8157b = i3;
            this.f8158c = i4;
            this.f8159d = i5;
        }

        public final boolean a(int i2) {
            if (i2 == 1) {
                if (this.f8156a - this.f8157b <= 1) {
                    return false;
                }
            } else if (this.f8158c - this.f8159d <= 1) {
                return false;
            }
            return true;
        }
    }

    public static final class FallbackSelection {

        /* renamed from: a, reason: collision with root package name */
        public final int f8160a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8161b;

        public FallbackSelection(int i2, long j2) {
            Assertions.a(j2 >= 0);
            this.f8160a = i2;
            this.f8161b = j2;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FallbackType {
    }

    public static final class LoadErrorInfo {

        /* renamed from: a, reason: collision with root package name */
        public final IOException f8162a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8163b;

        public LoadErrorInfo(IOException iOException, int i2) {
            this.f8162a = iOException;
            this.f8163b = i2;
        }
    }

    long a(LoadErrorInfo loadErrorInfo);

    int b(int i2);

    FallbackSelection c(FallbackOptions fallbackOptions, LoadErrorInfo loadErrorInfo);
}
