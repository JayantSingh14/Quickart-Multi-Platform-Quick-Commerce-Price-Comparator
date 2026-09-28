package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes3.dex */
public final class SessionResult {

    /* renamed from: e, reason: collision with root package name */
    public static final String f10259e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f10260f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f10261g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f10262h;

    /* renamed from: a, reason: collision with root package name */
    public final int f10263a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f10264b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10265c;

    /* renamed from: d, reason: collision with root package name */
    public final SessionError f10266d;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {
    }

    static {
        int i2 = Util.f5744a;
        f10259e = Integer.toString(0, 36);
        f10260f = Integer.toString(1, 36);
        f10261g = Integer.toString(2, 36);
        f10262h = Integer.toString(3, 36);
    }

    public SessionResult(int i2) {
        this(i2, Bundle.EMPTY);
    }

    public static SessionResult a(Bundle bundle) {
        int i2 = bundle.getInt(f10259e, -1);
        Bundle bundle2 = bundle.getBundle(f10260f);
        long j2 = bundle.getLong(f10261g, SystemClock.elapsedRealtime());
        Bundle bundle3 = bundle.getBundle(f10262h);
        SessionError sessionErrorA = bundle3 != null ? SessionError.a(bundle3) : i2 != 0 ? new SessionError(i2) : null;
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new SessionResult(i2, bundle2, j2, sessionErrorA);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f10259e, this.f10263a);
        bundle.putBundle(f10260f, this.f10264b);
        bundle.putLong(f10261g, this.f10265c);
        SessionError sessionError = this.f10266d;
        if (sessionError != null) {
            bundle.putBundle(f10262h, sessionError.b());
        }
        return bundle;
    }

    public SessionResult(int i2, Bundle bundle) {
        this(i2, bundle, SystemClock.elapsedRealtime(), null);
    }

    public SessionResult(int i2, Bundle bundle, long j2, SessionError sessionError) {
        Assertions.a(sessionError == null || i2 < 0);
        this.f10263a = i2;
        this.f10264b = new Bundle(bundle);
        this.f10265c = j2;
        if (sessionError == null && i2 < 0) {
            sessionError = new SessionError(i2);
        }
        this.f10266d = sessionError;
    }
}
