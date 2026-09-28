package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.SubclassOptInRequired;

@Metadata
@SubclassOptInRequired
/* loaded from: classes.dex */
public interface CompletableJob extends Job {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    boolean c(Throwable th);

    boolean complete();
}
