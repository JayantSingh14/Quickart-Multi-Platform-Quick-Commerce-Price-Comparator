package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes3.dex */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1<Animator, Unit> f2585a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1<Animator, Unit> f2586b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1<Animator, Unit> f2587c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1<Animator, Unit> f2588d;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f2587c.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f2586b.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        this.f2585a.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f2588d.invoke(animator);
    }
}
