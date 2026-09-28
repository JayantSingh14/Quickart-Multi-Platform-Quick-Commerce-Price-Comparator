package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes3.dex */
public final class ViewKt$doOnNextLayout$1 implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1<View, Unit> f3113a;

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        view.removeOnLayoutChangeListener(this);
        this.f3113a.invoke(view);
    }
}
