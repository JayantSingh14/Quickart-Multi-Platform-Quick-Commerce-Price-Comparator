package androidx.work.impl.model;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class WorkGenerationalId {

    /* renamed from: a, reason: collision with root package name */
    public final String f12893a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12894b;

    public WorkGenerationalId(String workSpecId, int i2) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f12893a = workSpecId;
        this.f12894b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkGenerationalId)) {
            return false;
        }
        WorkGenerationalId workGenerationalId = (WorkGenerationalId) obj;
        return Intrinsics.b(this.f12893a, workGenerationalId.f12893a) && this.f12894b == workGenerationalId.f12894b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f12894b) + (this.f12893a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("WorkGenerationalId(workSpecId=");
        sb.append(this.f12893a);
        sb.append(", generation=");
        return b.n(sb, this.f12894b, ')');
    }
}
