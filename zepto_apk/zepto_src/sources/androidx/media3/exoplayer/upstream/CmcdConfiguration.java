package androidx.media3.exoplayer.upstream;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.brentvatne.exoplayer.CMCDConfig$createCmcdConfiguration$1;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class CmcdConfiguration {

    /* renamed from: a, reason: collision with root package name */
    public final String f8065a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8066b;

    /* renamed from: c, reason: collision with root package name */
    public final CMCDConfig$createCmcdConfiguration$1 f8067c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8068d;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CmcdKey {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DataTransmissionMode {
    }

    public interface Factory {

        /* renamed from: androidx.media3.exoplayer.upstream.CmcdConfiguration$Factory$1, reason: invalid class name */
        public class AnonymousClass1 implements RequestConfig {
        }

        CmcdConfiguration b(MediaItem mediaItem);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HeaderKey {
    }

    public interface RequestConfig {
    }

    public CmcdConfiguration(String str, String str2, CMCDConfig$createCmcdConfiguration$1 cMCDConfig$createCmcdConfiguration$1, int i2) {
        boolean z = true;
        Assertions.a(str == null || str.length() <= 64);
        if (str2 != null && str2.length() > 64) {
            z = false;
        }
        Assertions.a(z);
        this.f8065a = str;
        this.f8066b = str2;
        this.f8067c = cMCDConfig$createCmcdConfiguration$1;
        this.f8068d = i2;
    }
}
