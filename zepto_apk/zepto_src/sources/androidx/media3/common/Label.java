package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public class Label {

    /* renamed from: c, reason: collision with root package name */
    public static final String f5246c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f5247d;

    /* renamed from: a, reason: collision with root package name */
    public final String f5248a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5249b;

    static {
        int i2 = Util.f5744a;
        f5246c = Integer.toString(0, 36);
        f5247d = Integer.toString(1, 36);
    }

    public Label(String str, String str2) {
        this.f5248a = Util.U(str);
        this.f5249b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Label label = (Label) obj;
            if (Util.a(this.f5248a, label.f5248a) && Util.a(this.f5249b, label.f5249b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f5249b.hashCode() * 31;
        String str = this.f5248a;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
