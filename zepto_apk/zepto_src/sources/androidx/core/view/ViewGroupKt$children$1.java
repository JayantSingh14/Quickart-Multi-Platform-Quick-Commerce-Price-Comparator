package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: classes3.dex */
public final class ViewGroupKt$children$1 implements Sequence<View> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup f3101a;

    public ViewGroupKt$children$1(ViewGroup viewGroup) {
        this.f3101a = viewGroup;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new ViewGroupKt$iterator$1(this.f3101a);
    }
}
