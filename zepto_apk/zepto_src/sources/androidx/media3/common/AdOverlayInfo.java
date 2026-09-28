package androidx.media3.common;

import android.view.View;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes3.dex */
public final class AdOverlayInfo {

    /* renamed from: a, reason: collision with root package name */
    public final View f5114a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5115b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5116c;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final View f5117a;

        public Builder(int i2, View view) {
            this.f5117a = view;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Purpose {
    }

    public AdOverlayInfo(View view, String str, int i2) {
        this.f5114a = view;
        this.f5115b = i2;
        this.f5116c = str;
    }
}
