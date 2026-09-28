package androidx.media3.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.media3.common.util.Util;
import androidx.media3.session.SessionToken;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class SessionTokenImplBase implements SessionToken.SessionTokenImpl {

    /* renamed from: j, reason: collision with root package name */
    public static final String f10270j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f10271k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f10272l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f10273m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;

    /* renamed from: a, reason: collision with root package name */
    public final int f10274a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10275b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10276c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10277d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10278e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10279f;

    /* renamed from: g, reason: collision with root package name */
    public final ComponentName f10280g;

    /* renamed from: h, reason: collision with root package name */
    public final IBinder f10281h;

    /* renamed from: i, reason: collision with root package name */
    public final Bundle f10282i;

    static {
        int i2 = Util.f5744a;
        f10270j = Integer.toString(0, 36);
        f10271k = Integer.toString(1, 36);
        f10272l = Integer.toString(2, 36);
        f10273m = Integer.toString(3, 36);
        n = Integer.toString(4, 36);
        o = Integer.toString(5, 36);
        p = Integer.toString(6, 36);
        q = Integer.toString(7, 36);
        r = Integer.toString(8, 36);
    }

    public SessionTokenImplBase(int i2, int i3, int i4, int i5, String str, String str2, ComponentName componentName, IBinder iBinder, Bundle bundle) {
        this.f10274a = i2;
        this.f10275b = i3;
        this.f10276c = i4;
        this.f10277d = i5;
        this.f10278e = str;
        this.f10279f = str2;
        this.f10280g = componentName;
        this.f10281h = iBinder;
        this.f10282i = bundle;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final String V() {
        return this.f10278e;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int a() {
        return this.f10274a;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Object b() {
        return this.f10281h;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final String c() {
        return this.f10279f;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int d() {
        return this.f10277d;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putInt(f10270j, this.f10274a);
        bundle.putInt(f10271k, this.f10275b);
        bundle.putInt(f10272l, this.f10276c);
        bundle.putString(f10273m, this.f10278e);
        bundle.putString(n, this.f10279f);
        bundle.putBinder(p, this.f10281h);
        bundle.putParcelable(o, this.f10280g);
        bundle.putBundle(q, this.f10282i);
        bundle.putInt(r, this.f10277d);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SessionTokenImplBase)) {
            return false;
        }
        SessionTokenImplBase sessionTokenImplBase = (SessionTokenImplBase) obj;
        return this.f10274a == sessionTokenImplBase.f10274a && this.f10275b == sessionTokenImplBase.f10275b && this.f10276c == sessionTokenImplBase.f10276c && this.f10277d == sessionTokenImplBase.f10277d && TextUtils.equals(this.f10278e, sessionTokenImplBase.f10278e) && TextUtils.equals(this.f10279f, sessionTokenImplBase.f10279f) && Util.a(this.f10280g, sessionTokenImplBase.f10280g) && Util.a(this.f10281h, sessionTokenImplBase.f10281h);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final ComponentName f() {
        return this.f10280g;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final boolean g() {
        return false;
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final Bundle getExtras() {
        return new Bundle(this.f10282i);
    }

    @Override // androidx.media3.session.SessionToken.SessionTokenImpl
    public final int getType() {
        return this.f10275b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10274a), Integer.valueOf(this.f10275b), Integer.valueOf(this.f10276c), Integer.valueOf(this.f10277d), this.f10278e, this.f10279f, this.f10280g, this.f10281h});
    }

    public final String toString() {
        return "SessionToken {pkg=" + this.f10278e + " type=" + this.f10275b + " libraryVersion=" + this.f10276c + " interfaceVersion=" + this.f10277d + " service=" + this.f10279f + " IMediaSession=" + this.f10281h + " extras=" + this.f10282i + "}";
    }
}
