package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes3.dex */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1<Animator, Unit> f2589a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1<Animator, Unit> f2590b;

    @Override // android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.f2589a.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        this.f2590b.invoke(animator);
    }
}
