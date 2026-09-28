package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Entity
@Metadata
@RestrictTo
/* loaded from: classes.dex */
public final class WorkName {

    /* renamed from: a, reason: collision with root package name */
    public final String f12895a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12896b;

    public WorkName(String name, String workSpecId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f12895a = name;
        this.f12896b = workSpecId;
    }
}
