package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import org.apache.commons.lang3.StringUtils;

@RestrictTo
/* loaded from: classes3.dex */
public class MutablePair<T> {

    /* renamed from: a, reason: collision with root package name */
    public String f14474a;

    /* renamed from: b, reason: collision with root package name */
    public String f14475b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f2 = pair.f2989a;
        Object obj2 = this.f14474a;
        if (f2 != obj2 && (f2 == 0 || !f2.equals(obj2))) {
            return false;
        }
        S s = pair.f2990b;
        Object obj3 = this.f14475b;
        if (s != obj3) {
            return s != 0 && s.equals(obj3);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f14474a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f14475b;
        return iHashCode ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "Pair{" + ((Object) this.f14474a) + StringUtils.SPACE + ((Object) this.f14475b) + "}";
    }
}
