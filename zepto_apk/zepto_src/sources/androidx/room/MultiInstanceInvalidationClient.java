package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class MultiInstanceInvalidationClient {

    /* renamed from: a, reason: collision with root package name */
    public IMultiInstanceInvalidationService f11788a;

    @Metadata
    @SourceDebugExtension
    /* renamed from: androidx.room.MultiInstanceInvalidationClient$1, reason: invalid class name */
    public final class AnonymousClass1 extends InvalidationTracker.Observer {
        @Override // androidx.room.InvalidationTracker.Observer
        public final void b(Set tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            throw null;
        }
    }
}
