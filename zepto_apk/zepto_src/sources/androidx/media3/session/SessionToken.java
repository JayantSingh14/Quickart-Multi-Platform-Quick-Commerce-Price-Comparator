package androidx.media3.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes3.dex */
public final class SessionToken {

    /* renamed from: b, reason: collision with root package name */
    public static final String f10267b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f10268c;

    /* renamed from: a, reason: collision with root package name */
    public final SessionTokenImpl f10269a;

    /* renamed from: androidx.media3.session.SessionToken$1, reason: invalid class name */
    class AnonymousClass1 extends ResultReceiver {
        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i2, Bundle bundle) {
            throw null;
        }
    }

    public interface SessionTokenImpl {
        String V();

        int a();

        Object b();

        String c();

        int d();

        Bundle e();

        ComponentName f();

        boolean g();

        Bundle getExtras();

        int getType();
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TokenType {
    }

    static {
        MediaLibraryInfo.a("media3.session");
        int i2 = Util.f5744a;
        f10267b = Integer.toString(0, 36);
        f10268c = Integer.toString(1, 36);
    }

    public SessionToken(int i2, int i3, int i4, String str, IMediaSession iMediaSession, Bundle bundle) {
        str.getClass();
        IBinder iBinderAsBinder = iMediaSession.asBinder();
        bundle.getClass();
        this.f10269a = new SessionTokenImplBase(i2, 0, i3, i4, str, "", null, iBinderAsBinder, bundle);
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        SessionTokenImpl sessionTokenImpl = this.f10269a;
        boolean z = sessionTokenImpl instanceof SessionTokenImplBase;
        String str = f10267b;
        if (z) {
            bundle.putInt(str, 0);
        } else {
            bundle.putInt(str, 1);
        }
        bundle.putBundle(f10268c, sessionTokenImpl.e());
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof SessionToken) {
            return this.f10269a.equals(((SessionToken) obj).f10269a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10269a.hashCode();
    }

    public final String toString() {
        return this.f10269a.toString();
    }
}
