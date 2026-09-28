package androidx.media3.session;

import android.content.ComponentName;
import android.os.Bundle;
import androidx.media3.common.util.Util;
import androidx.media3.session.SessionToken;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class SessionTokenImplLegacy implements SessionToken.SessionTokenImpl {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10283a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f10284b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f10285c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f10286d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f10287e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f10288f;

    static {
        int i2 = Util.f5744a;
        f10283a = Integer.toString(0, 36);
        f10284b = Integer.toString(1, 36);
        f10285c = Integer.toString(2, 36);
        f10286d = Integer.toString(3, 36);
        f10287e = Integer.toString(4, 36);
        f10288f = Integer.toString(5, 36);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final String V() {
        return null;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int a() {
        return 0;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Object b() {
        return null;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final String c() {
        return "";
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int d() {
        return 0;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBundle(f10283a, null);
        bundle.putInt(f10284b, 0);
        bundle.putInt(f10285c, 0);
        bundle.putParcelable(f10286d, null);
        bundle.putString(f10287e, null);
        bundle.putBundle(f10288f, null);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SessionTokenImplLegacy)) {
            return false;
        }
        ((SessionTokenImplLegacy) obj).getClass();
        return false;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final ComponentName f() {
        return null;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final boolean g() {
        return true;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Bundle getExtras() {
        return new Bundle((Bundle) null);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int getType() {
        return 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{0, null, null});
    }

    public final String toString() {
        return "SessionToken {legacyToken=" + ((Object) null) + "}";
    }
}
