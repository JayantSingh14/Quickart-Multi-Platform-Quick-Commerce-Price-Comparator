package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class TransitionValues {

    /* renamed from: b, reason: collision with root package name */
    public View f12164b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f12163a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f12165c = new ArrayList();

    @Deprecated
    public TransitionValues() {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.f12164b == transitionValues.f12164b && this.f12163a.equals(transitionValues.f12163a);
    }

    public final int hashCode() {
        return this.f12163a.hashCode() + (this.f12164b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sbX = android.support.v4.media.b.x("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbX.append(this.f12164b);
        sbX.append(StringUtils.LF);
        String strK = android.support.v4.media.b.k(sbX.toString(), "    values:");
        HashMap map = this.f12163a;
        for (String str : map.keySet()) {
            strK = strK + "    " + str + ": " + map.get(str) + StringUtils.LF;
        }
        return strK;
    }

    public TransitionValues(View view) {
        this.f12164b = view;
    }
}
