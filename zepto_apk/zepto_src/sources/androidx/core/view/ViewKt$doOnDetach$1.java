package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes3.dex */
public final class ViewKt$doOnDetach$1 implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f3111a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1<View, Unit> f3112b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f3111a.removeOnAttachStateChangeListener(this);
        this.f3112b.invoke(view);
    }
}
