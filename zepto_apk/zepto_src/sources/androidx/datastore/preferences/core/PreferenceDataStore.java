package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata
/* loaded from: classes.dex */
public final class PreferenceDataStore implements DataStore<Preferences> {

    /* renamed from: a, reason: collision with root package name */
    public final DataStore f3720a;

    public PreferenceDataStore(DataStore delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f3720a = delegate;
    }

    @Override // androidx.datastore.core.DataStore
    public final Object a(Function2 function2, ContinuationImpl continuationImpl) {
        return this.f3720a.a(new PreferenceDataStore$updateData$2(function2, null), continuationImpl);
    }

    @Override // androidx.datastore.core.DataStore
    public final Flow getData() {
        return this.f3720a.getData();
    }
}
