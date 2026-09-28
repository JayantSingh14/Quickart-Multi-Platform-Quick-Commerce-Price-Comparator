package androidx.media3.exoplayer;

import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class DecoderReuseEvaluation {

    /* renamed from: a, reason: collision with root package name */
    public final String f6137a;

    /* renamed from: b, reason: collision with root package name */
    public final Format f6138b;

    /* renamed from: c, reason: collision with root package name */
    public final Format f6139c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6140d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6141e;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderDiscardReasons {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderReuseResult {
    }

    public DecoderReuseEvaluation(String str, Format format, Format format2, int i2, int i3) {
        Assertions.a(i2 == 0 || i3 == 0);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.f6137a = str;
        format.getClass();
        this.f6138b = format;
        format2.getClass();
        this.f6139c = format2;
        this.f6140d = i2;
        this.f6141e = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DecoderReuseEvaluation.class == obj.getClass()) {
            DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation) obj;
            if (this.f6140d == decoderReuseEvaluation.f6140d && this.f6141e == decoderReuseEvaluation.f6141e && this.f6137a.equals(decoderReuseEvaluation.f6137a) && this.f6138b.equals(decoderReuseEvaluation.f6138b) && this.f6139c.equals(decoderReuseEvaluation.f6139c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f6139c.hashCode() + ((this.f6138b.hashCode() + androidx.fragment.app.e.e((((527 + this.f6140d) * 31) + this.f6141e) * 31, 31, this.f6137a)) * 31);
    }
}
