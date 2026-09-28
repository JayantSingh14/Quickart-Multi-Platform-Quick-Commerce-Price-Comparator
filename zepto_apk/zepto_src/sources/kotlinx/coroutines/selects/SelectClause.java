package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.InternalCoroutinesApi;

@InternalCoroutinesApi
@Metadata
/* loaded from: classes.dex */
public interface SelectClause {
    Function3 a();

    Function3 b();

    Function3 c();

    Object d();
}
