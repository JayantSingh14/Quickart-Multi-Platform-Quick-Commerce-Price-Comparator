package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CoroutineExceptionHandlerImplKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Collection f55066a = SequencesKt.q(SequencesKt.c(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));
}
