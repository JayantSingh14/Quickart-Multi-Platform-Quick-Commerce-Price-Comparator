package androidx.customview.poolingcontainer;

import android.view.View;
import androidx.core.view.ViewGroupKt$children$1;
import androidx.core.view.ViewGroupKt$iterator$1;
import androidx.core.view.ViewKt;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata
@JvmName
/* loaded from: classes3.dex */
public final class PoolingContainer {

    /* renamed from: a, reason: collision with root package name */
    public static final int f3317a = R.id.pooling_container_listener_holder_tag;

    /* renamed from: b, reason: collision with root package name */
    public static final int f3318b = R.id.is_pooling_container_tag;

    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.coroutines.jvm.internal.RestrictedSuspendLambda, kotlin.jvm.functions.Function2] */
    public static final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Iterator itL = SequencesKt.l(ViewKt.a(view).f53924a);
        while (itL.hasNext()) {
            View view2 = (View) itL.next();
            int i2 = f3317a;
            PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view2.getTag(i2);
            if (poolingContainerListenerHolder == null) {
                poolingContainerListenerHolder = new PoolingContainerListenerHolder();
                view2.setTag(i2, poolingContainerListenerHolder);
            }
            ArrayList arrayList = poolingContainerListenerHolder.f3319a;
            for (int iB = CollectionsKt.B(arrayList); -1 < iB; iB--) {
                ((PoolingContainerListener) arrayList.get(iB)).a();
            }
        }
    }

    public static final void b(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Iterator it = new ViewGroupKt$children$1(recyclerView).iterator();
        while (true) {
            ViewGroupKt$iterator$1 viewGroupKt$iterator$1 = (ViewGroupKt$iterator$1) it;
            if (!viewGroupKt$iterator$1.hasNext()) {
                return;
            }
            View view = (View) viewGroupKt$iterator$1.next();
            int i2 = f3317a;
            PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i2);
            if (poolingContainerListenerHolder == null) {
                poolingContainerListenerHolder = new PoolingContainerListenerHolder();
                view.setTag(i2, poolingContainerListenerHolder);
            }
            ArrayList arrayList = poolingContainerListenerHolder.f3319a;
            for (int iB = CollectionsKt.B(arrayList); -1 < iB; iB--) {
                ((PoolingContainerListener) arrayList.get(iB)).a();
            }
        }
    }
}
