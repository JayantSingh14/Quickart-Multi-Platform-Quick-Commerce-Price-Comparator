package kotlinx.coroutines.flow;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", l = {ModuleDescriptor.MODULE_VERSION}, m = "catchImpl")
/* loaded from: classes3.dex */
final class FlowKt__ErrorsKt$catchImpl$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54658a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54659b;

    /* renamed from: c, reason: collision with root package name */
    public int f54660c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54659b = obj;
        this.f54660c |= Integer.MIN_VALUE;
        return FlowKt__ErrorsKt.b(this, null, null);
    }
}
