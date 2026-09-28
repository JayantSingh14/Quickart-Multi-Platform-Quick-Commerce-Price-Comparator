package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;

@SinceKotlin
@Metadata
/* loaded from: classes.dex */
public interface CoroutineStackFrame {
    CoroutineStackFrame getCallerFrame();
}
