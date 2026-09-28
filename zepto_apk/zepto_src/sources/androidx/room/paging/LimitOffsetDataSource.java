package androidx.room.paging;

import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import java.util.Set;

@RestrictTo
/* loaded from: classes3.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {

    /* renamed from: androidx.room.paging.LimitOffsetDataSource$1, reason: invalid class name */
    class AnonymousClass1 extends InvalidationTracker.Observer {
        @Override // androidx.room.InvalidationTracker.Observer
        public final void b(Set set) {
            LimitOffsetDataSource limitOffsetDataSource = null;
            limitOffsetDataSource.invalidate();
            throw null;
        }
    }
}
