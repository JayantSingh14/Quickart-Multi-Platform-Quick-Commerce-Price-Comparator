package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Entity
@Metadata
@RestrictTo
/* loaded from: classes.dex */
public final class WorkTag {

    /* renamed from: a, reason: collision with root package name */
    public final String f12952a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12953b;

    public WorkTag(String tag, String workSpecId) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f12952a = tag;
        this.f12953b = workSpecId;
    }
}
