package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* loaded from: classes3.dex */
class ConnectionRequest {

    /* renamed from: f, reason: collision with root package name */
    public static final String f9896f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f9897g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f9898h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f9899i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f9900j;

    /* renamed from: a, reason: collision with root package name */
    public final int f9901a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9902b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9903c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9904d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f9905e;

    static {
        int i2 = Util.f5744a;
        f9896f = Integer.toString(0, 36);
        f9897g = Integer.toString(1, 36);
        f9898h = Integer.toString(2, 36);
        f9899i = Integer.toString(3, 36);
        f9900j = Integer.toString(4, 36);
    }

    public ConnectionRequest(String str, int i2, Bundle bundle) {
        this(1004001300, 6, str, i2, new Bundle(bundle));
    }

    public static ConnectionRequest a(Bundle bundle) {
        int i2 = bundle.getInt(f9896f, 0);
        int i3 = bundle.getInt(f9900j, 0);
        String string = bundle.getString(f9897g);
        string.getClass();
        String str = f9898h;
        Assertions.a(bundle.containsKey(str));
        int i4 = bundle.getInt(str);
        Bundle bundle2 = bundle.getBundle(f9899i);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        return new ConnectionRequest(i2, i3, string, i4, bundle2);
    }

    public final Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f9896f, this.f9901a);
        bundle.putString(f9897g, this.f9903c);
        bundle.putInt(f9898h, this.f9904d);
        bundle.putBundle(f9899i, this.f9905e);
        bundle.putInt(f9900j, this.f9902b);
        return bundle;
    }

    public ConnectionRequest(int i2, int i3, String str, int i4, Bundle bundle) {
        this.f9901a = i2;
        this.f9902b = i3;
        this.f9903c = str;
        this.f9904d = i4;
        this.f9905e = bundle;
    }
}
