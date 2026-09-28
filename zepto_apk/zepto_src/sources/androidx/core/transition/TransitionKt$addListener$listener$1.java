package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes3.dex */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f2974a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f2975b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f2976c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f2977d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f2978e;

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
        this.f2977d.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        this.f2974a.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
        this.f2976c.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
        this.f2975b.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        this.f2978e.invoke(transition);
    }
}
