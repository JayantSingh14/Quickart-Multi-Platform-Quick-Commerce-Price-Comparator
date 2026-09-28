package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzaa {

    /* renamed from: d, reason: collision with root package name */
    public static final ImmutableSet f36745d = ImmutableSet.n(3, "_syn", "_err", "_el");

    /* renamed from: a, reason: collision with root package name */
    public String f36746a;

    /* renamed from: b, reason: collision with root package name */
    public final long f36747b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f36748c;

    public zzaa(String str, long j2, HashMap map) {
        this.f36746a = str;
        this.f36747b = j2;
        HashMap map2 = new HashMap();
        this.f36748c = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public static Object e(String str, Object obj, Object obj2) {
        if (f36745d.contains(str) && (obj2 instanceof Double)) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        if (str.startsWith(Attributes.PREDEFINED_ATTRIBUTE_PREFIX)) {
            if (!(obj instanceof String) && obj != null) {
                return obj;
            }
        } else if (!(obj instanceof Double)) {
            if (obj instanceof Long) {
                return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
            }
            if (obj instanceof String) {
                return obj2.toString();
            }
        }
        return obj2;
    }

    public final long a() {
        return this.f36747b;
    }

    public final String b() {
        return this.f36746a;
    }

    public final HashMap c() {
        return this.f36748c;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final zzaa clone() {
        return new zzaa(this.f36746a, this.f36747b, new HashMap(this.f36748c));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaa)) {
            return false;
        }
        zzaa zzaaVar = (zzaa) obj;
        if (this.f36747b == zzaaVar.f36747b && this.f36746a.equals(zzaaVar.f36746a)) {
            return this.f36748c.equals(zzaaVar.f36748c);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f36746a.hashCode() * 31;
        HashMap map = this.f36748c;
        long j2 = this.f36747b;
        return map.hashCode() + ((iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        String str = this.f36746a;
        String string = this.f36748c.toString();
        int length = String.valueOf(str).length();
        long j2 = this.f36747b;
        StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(j2).length() + 9 + string.length() + 1);
        a.u(sb, "Event{name='", str, "', timestamp=");
        sb.append(j2);
        sb.append(", params=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
