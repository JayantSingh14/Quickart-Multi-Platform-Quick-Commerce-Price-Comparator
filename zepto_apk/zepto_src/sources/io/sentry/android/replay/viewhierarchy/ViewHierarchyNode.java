package io.sentry.android.replay.viewhierarchy;

import android.annotation.TargetApi;
import android.graphics.Rect;
import androidx.compose.runtime.internal.StabilityInferred;
import io.sentry.android.replay.util.TextLayout;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@StabilityInferred(parameters = 0)
@Metadata
@TargetApi(26)
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class ViewHierarchyNode {

    /* renamed from: a, reason: collision with root package name */
    public final int f52655a;

    /* renamed from: b, reason: collision with root package name */
    public final int f52656b;

    /* renamed from: c, reason: collision with root package name */
    public final float f52657c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f52658d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f52659e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f52660f;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:135:0x0241  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x0244  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x0246  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0137  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0182  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0184  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static io.sentry.android.replay.viewhierarchy.ViewHierarchyNode a(android.view.View r13, io.sentry.android.replay.viewhierarchy.ViewHierarchyNode r14, int r15, io.sentry.SentryOptions r16) {
            /*
                Method dump skipped, instructions count: 627
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.viewhierarchy.ViewHierarchyNode.Companion.a(android.view.View, io.sentry.android.replay.viewhierarchy.ViewHierarchyNode, int, io.sentry.SentryOptions):io.sentry.android.replay.viewhierarchy.ViewHierarchyNode");
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata
    public static final class GenericViewHierarchyNode extends ViewHierarchyNode {
    }

    @StabilityInferred(parameters = 0)
    @Metadata
    public static final class ImageViewHierarchyNode extends ViewHierarchyNode {
    }

    @Metadata
    public static final class LCAResult {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LCAResult)) {
                return false;
            }
            ((LCAResult) obj).getClass();
            return Intrinsics.b(null, null) && Intrinsics.b(null, null) && Intrinsics.b(null, null);
        }

        public final int hashCode() {
            return (((0 * 31) + 0) * 31) + 0;
        }

        public final String toString() {
            return "LCAResult(lca=" + ((Object) null) + ", nodeSubtree=" + ((Object) null) + ", otherNodeSubtree=" + ((Object) null) + ')';
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata
    public static final class TextViewHierarchyNode extends ViewHierarchyNode {

        /* renamed from: g, reason: collision with root package name */
        public final TextLayout f52661g;

        /* renamed from: h, reason: collision with root package name */
        public final Integer f52662h;

        /* renamed from: i, reason: collision with root package name */
        public final int f52663i;

        /* renamed from: j, reason: collision with root package name */
        public final int f52664j;

        public TextViewHierarchyNode(TextLayout textLayout, Integer num, int i2, int i3, int i4, int i5, float f2, int i6, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, Rect rect) {
            super(i4, i5, f2, i6, viewHierarchyNode, z, true, z2, rect);
            this.f52661g = textLayout;
            this.f52662h = num;
            this.f52663i = i2;
            this.f52664j = i3;
        }
    }

    public ViewHierarchyNode(int i2, int i3, float f2, int i4, ViewHierarchyNode viewHierarchyNode, boolean z, boolean z2, boolean z3, Rect rect) {
        this.f52655a = i2;
        this.f52656b = i3;
        this.f52657c = f2;
        this.f52658d = z;
        this.f52659e = rect;
    }

    public final void a(Function1 callback) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!((Boolean) callback.invoke(this)).booleanValue() || (arrayList = this.f52660f) == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ViewHierarchyNode) it.next()).a(callback);
        }
    }
}
