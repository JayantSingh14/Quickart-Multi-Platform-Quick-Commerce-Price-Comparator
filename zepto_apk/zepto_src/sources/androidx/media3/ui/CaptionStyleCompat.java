package androidx.media3.ui;

import android.graphics.Typeface;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class CaptionStyleCompat {

    /* renamed from: g, reason: collision with root package name */
    public static final CaptionStyleCompat f10829g = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, null);

    /* renamed from: a, reason: collision with root package name */
    public final int f10830a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10831b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10832c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10833d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10834e;

    /* renamed from: f, reason: collision with root package name */
    public final Typeface f10835f;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface EdgeType {
    }

    public CaptionStyleCompat(int i2, int i3, int i4, int i5, int i6, Typeface typeface) {
        this.f10830a = i2;
        this.f10831b = i3;
        this.f10832c = i4;
        this.f10833d = i5;
        this.f10834e = i6;
        this.f10835f = typeface;
    }
}
