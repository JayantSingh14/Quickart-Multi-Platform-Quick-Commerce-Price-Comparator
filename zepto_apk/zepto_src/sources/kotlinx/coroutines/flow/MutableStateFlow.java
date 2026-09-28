package kotlinx.coroutines.flow;

import androidx.datastore.core.State;
import kotlin.Metadata;
import kotlin.SubclassOptInRequired;

@Metadata
@SubclassOptInRequired
/* loaded from: classes.dex */
public interface MutableStateFlow<T> extends StateFlow<T>, MutableSharedFlow<T> {
    boolean e(Object obj, State state);

    @Override // kotlinx.coroutines.flow.StateFlow
    Object getValue();

    void setValue(Object obj);
}
