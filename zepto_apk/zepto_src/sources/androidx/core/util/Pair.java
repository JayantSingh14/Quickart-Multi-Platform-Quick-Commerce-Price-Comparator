package androidx.core.util;

import android.graphics.drawable.Drawable;
import android.support.v4.media.b;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class Pair<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public final F f2989a;

    /* renamed from: b, reason: collision with root package name */
    public final S f2990b;

    /* JADX WARN: Multi-variable type inference failed */
    public Pair(Object obj, Object obj2) {
        this.f2989a = obj;
        this.f2990b = obj2;
    }

    public static Pair a(CharSequence charSequence, Drawable drawable) {
        return new Pair(charSequence, drawable);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return Objects.equals(pair.f2989a, this.f2989a) && Objects.equals(pair.f2990b, this.f2990b);
    }

    public final int hashCode() {
        F f2 = this.f2989a;
        int iHashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f2990b;
        return iHashCode ^ (s != null ? s.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Pair{");
        sb.append(this.f2989a);
        sb.append(StringUtils.SPACE);
        return b.q(sb, this.f2990b, "}");
    }
}
