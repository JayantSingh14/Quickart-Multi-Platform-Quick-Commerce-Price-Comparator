package androidx.media3.extractor.text.ttml;

import com.google.common.collect.ImmutableSet;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* loaded from: classes3.dex */
final class TextEmphasis {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f9362d = Pattern.compile("\\s+");

    /* renamed from: e, reason: collision with root package name */
    public static final ImmutableSet f9363e = ImmutableSet.n(2, "auto", "none");

    /* renamed from: f, reason: collision with root package name */
    public static final ImmutableSet f9364f = ImmutableSet.n(3, "dot", "sesame", "circle");

    /* renamed from: g, reason: collision with root package name */
    public static final ImmutableSet f9365g = ImmutableSet.n(2, "filled", AbstractCircuitBreaker.PROPERTY_NAME);

    /* renamed from: h, reason: collision with root package name */
    public static final ImmutableSet f9366h = ImmutableSet.n(3, "after", "before", "outside");

    /* renamed from: a, reason: collision with root package name */
    public final int f9367a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9368b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9369c;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    public TextEmphasis(int i2, int i3, int i4) {
        this.f9367a = i2;
        this.f9368b = i3;
        this.f9369c = i4;
    }
}
