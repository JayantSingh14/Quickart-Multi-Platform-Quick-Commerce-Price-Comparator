package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.SubclassOptInRequired;

@Metadata
@SubclassOptInRequired
/* loaded from: classes.dex */
public interface StateFlow<T> extends SharedFlow<T> {
    Object getValue();
}
