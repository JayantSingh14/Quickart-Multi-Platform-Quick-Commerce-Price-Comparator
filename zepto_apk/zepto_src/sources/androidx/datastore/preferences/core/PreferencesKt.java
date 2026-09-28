package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: classes3.dex */
public final class PreferencesKt {
    public static final Object a(DataStore dataStore, Function2 function2, ContinuationImpl continuationImpl) {
        return dataStore.a(new PreferencesKt$edit$2(function2, null), continuationImpl);
    }
}
