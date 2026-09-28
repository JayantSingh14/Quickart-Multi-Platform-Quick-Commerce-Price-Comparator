package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {101}, m = "withTimeoutOrNull")
/* loaded from: classes3.dex */
final class TimeoutKt$withTimeoutOrNull$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Function2 f54166a;

    /* renamed from: b, reason: collision with root package name */
    public Ref.ObjectRef f54167b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f54168c;

    /* renamed from: d, reason: collision with root package name */
    public int f54169d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54168c = obj;
        this.f54169d |= Integer.MIN_VALUE;
        return TimeoutKt.b(0L, null, this);
    }
}
