package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes3.dex */
public final class ViewKt$doOnPreDraw$1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1<View, Unit> f3114a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f3115b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f3114a.invoke(this.f3115b);
    }
}
