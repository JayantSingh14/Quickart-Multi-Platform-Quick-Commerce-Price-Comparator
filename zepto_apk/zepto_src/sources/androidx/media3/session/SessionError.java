package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

@UnstableApi
/* loaded from: classes3.dex */
public final class SessionError {

    /* renamed from: d, reason: collision with root package name */
    public static final String f10240d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f10241e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f10242f;

    /* renamed from: a, reason: collision with root package name */
    public final int f10243a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10244b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f10245c;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {
    }

    static {
        int i2 = Util.f5744a;
        f10240d = Integer.toString(0, 36);
        f10241e = Integer.toString(1, 36);
        f10242f = Integer.toString(2, 36);
    }

    public SessionError(int i2) {
        this("no error message provided", i2, Bundle.EMPTY);
    }

    public static SessionError a(Bundle bundle) {
        int i2 = bundle.getInt(f10240d, 1000);
        String string = bundle.getString(f10241e, "");
        Bundle bundle2 = bundle.getBundle(f10242f);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new SessionError(string, i2, bundle2);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f10240d, this.f10243a);
        bundle.putString(f10241e, this.f10244b);
        Bundle bundle2 = this.f10245c;
        if (!bundle2.isEmpty()) {
            bundle.putBundle(f10242f, bundle2);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionError)) {
            return false;
        }
        SessionError sessionError = (SessionError) obj;
        return this.f10243a == sessionError.f10243a && Objects.equals(this.f10244b, sessionError.f10244b);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f10243a), this.f10244b);
    }

    public SessionError(String str, int i2, Bundle bundle) {
        boolean z = true;
        if (i2 >= 0 && i2 != 1) {
            z = false;
        }
        Assertions.a(z);
        this.f10243a = i2;
        this.f10244b = str;
        this.f10245c = bundle;
    }
}
