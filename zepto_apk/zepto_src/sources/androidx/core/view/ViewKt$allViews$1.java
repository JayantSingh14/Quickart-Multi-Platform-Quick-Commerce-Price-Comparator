package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

@Metadata
@DebugMetadata(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {410, 412}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super View>, Continuation<? super Unit>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f3106b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3107c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ View f3108d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, Continuation continuation) {
        super(2, continuation);
        this.f3108d = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.f3108d, continuation);
        viewKt$allViews$1.f3107c = obj;
        return viewKt$allViews$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ViewKt$allViews$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f3106b;
        if (i2 == 0) {
            ResultKt.b(obj);
            SequenceScope sequenceScope = (SequenceScope) this.f3107c;
            View view = this.f3108d;
            this.f3107c = sequenceScope;
            this.f3106b = 1;
            sequenceScope.a(view, this);
            return coroutineSingletons;
        }
        if (i2 == 1) {
            SequenceScope sequenceScope2 = (SequenceScope) this.f3107c;
            ResultKt.b(obj);
            View view2 = this.f3108d;
            if (view2 instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup) view2;
                Sequence<View> sequence = new Sequence<View>() { // from class: androidx.core.view.ViewGroupKt$special$$inlined$Sequence$1
                    @Override // kotlin.sequences.Sequence
                    public final Iterator iterator() {
                        return new TreeIterator(new ViewGroupKt$children$1(viewGroup).iterator());
                    }
                };
                this.f3107c = null;
                this.f3106b = 2;
                sequenceScope2.getClass();
                Object objB = sequenceScope2.b(sequence.iterator(), this);
                if (objB != coroutineSingletons) {
                    objB = Unit.f53572a;
                }
                if (objB == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
