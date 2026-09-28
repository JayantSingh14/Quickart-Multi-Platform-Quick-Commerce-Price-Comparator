package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated
@InternalCoroutinesApi
@Metadata
/* loaded from: classes.dex */
public interface ParentJob extends Job {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    CancellationException v0();
}
