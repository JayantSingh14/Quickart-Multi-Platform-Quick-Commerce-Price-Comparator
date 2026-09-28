package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Entity
@Metadata
@RestrictTo
/* loaded from: classes.dex */
public final class Preference {

    /* renamed from: a, reason: collision with root package name */
    public final String f12882a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f12883b;

    public Preference(String key, Long l2) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f12882a = key;
        this.f12883b = l2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return Intrinsics.b(this.f12882a, preference.f12882a) && Intrinsics.b(this.f12883b, preference.f12883b);
    }

    public final int hashCode() {
        int iHashCode = this.f12882a.hashCode() * 31;
        Long l2 = this.f12883b;
        return iHashCode + (l2 == null ? 0 : l2.hashCode());
    }

    public final String toString() {
        return "Preference(key=" + this.f12882a + ", value=" + this.f12883b + ')';
    }
}
