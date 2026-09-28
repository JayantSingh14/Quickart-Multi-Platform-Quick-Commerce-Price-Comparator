package androidx.work.impl.model;

import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Entity
@Metadata
@RestrictTo
/* loaded from: classes.dex */
public final class SystemIdInfo {

    /* renamed from: a, reason: collision with root package name */
    public final String f12886a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12887b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12888c;

    public SystemIdInfo(String workSpecId, int i2, int i3) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f12886a = workSpecId;
        this.f12887b = i2;
        this.f12888c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        return Intrinsics.b(this.f12886a, systemIdInfo.f12886a) && this.f12887b == systemIdInfo.f12887b && this.f12888c == systemIdInfo.f12888c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f12888c) + android.support.v4.media.a.b(this.f12887b, this.f12886a.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SystemIdInfo(workSpecId=");
        sb.append(this.f12886a);
        sb.append(", generation=");
        sb.append(this.f12887b);
        sb.append(", systemId=");
        return b.n(sb, this.f12888c, ')');
    }
}
