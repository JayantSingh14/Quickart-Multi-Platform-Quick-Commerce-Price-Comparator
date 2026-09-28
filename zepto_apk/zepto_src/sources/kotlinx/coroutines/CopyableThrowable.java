package kotlinx.coroutines;

import java.lang.Throwable;
import kotlin.Metadata;
import kotlinx.coroutines.CopyableThrowable;

@Metadata
@ExperimentalCoroutinesApi
/* loaded from: classes.dex */
public interface CopyableThrowable<T extends Throwable & CopyableThrowable<T>> {
    Throwable a();
}
