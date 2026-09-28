package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Entity
@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public final class Dependency {

    /* renamed from: a, reason: collision with root package name */
    public final String f12878a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12879b;

    public Dependency(String workSpecId, String prerequisiteId) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        Intrinsics.checkNotNullParameter(prerequisiteId, "prerequisiteId");
        this.f12878a = workSpecId;
        this.f12879b = prerequisiteId;
    }

    public final String a() {
        return this.f12879b;
    }

    public final String b() {
        return this.f12878a;
    }
}
