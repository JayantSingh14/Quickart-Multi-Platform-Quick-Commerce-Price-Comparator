package androidx.webkit;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* loaded from: classes3.dex */
public class WebMessageCompat {

    /* renamed from: a, reason: collision with root package name */
    public final String f12424a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12425b;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface Type {
    }

    public WebMessageCompat(String str, WebMessagePortCompat[] webMessagePortCompatArr) {
        this.f12424a = str;
        this.f12425b = 0;
    }

    public WebMessageCompat(byte[] bArr, WebMessagePortCompat[] webMessagePortCompatArr) {
        Objects.requireNonNull(bArr);
        this.f12424a = null;
        this.f12425b = 1;
    }
}
