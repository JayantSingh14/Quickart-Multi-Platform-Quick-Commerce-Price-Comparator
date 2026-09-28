package io.sentry.android.replay.viewhierarchy;

import android.annotation.TargetApi;
import android.view.View;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import io.sentry.SentryOptions;
import io.sentry.android.replay.SentryReplayModifiers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@TargetApi(26)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ComposeViewHierarchyNode {

    /* renamed from: a, reason: collision with root package name */
    public static WeakReference f52654a;

    /* JADX WARN: Removed duplicated region for block: B:83:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static io.sentry.android.replay.viewhierarchy.ViewHierarchyNode a(androidx.compose.ui.node.LayoutNode r15, io.sentry.android.replay.viewhierarchy.ViewHierarchyNode r16, int r17, boolean r18, io.sentry.SentryOptions r19) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.viewhierarchy.ComposeViewHierarchyNode.a(androidx.compose.ui.node.LayoutNode, io.sentry.android.replay.viewhierarchy.ViewHierarchyNode, int, boolean, io.sentry.SentryOptions):io.sentry.android.replay.viewhierarchy.ViewHierarchyNode");
    }

    public static boolean b(View view, ViewHierarchyNode viewHierarchyNode, SentryOptions options) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(options, "options");
        String name = view.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "view::class.java.name");
        StringsKt.n(name, "AndroidComposeView", false);
        return false;
    }

    public static String c(LayoutNode layoutNode, boolean z) {
        if (z) {
            return "android.widget.ImageView";
        }
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.contains(SemanticsProperties.INSTANCE.getText())) {
            return "android.widget.TextView";
        }
        SemanticsConfiguration collapsedSemantics$ui_release2 = layoutNode.getCollapsedSemantics$ui_release();
        return (collapsedSemantics$ui_release2 == null || !collapsedSemantics$ui_release2.contains(SemanticsActions.INSTANCE.getSetText())) ? "android.view.View" : "android.widget.TextView";
    }

    public static boolean d(LayoutNode layoutNode, boolean z, SentryOptions sentryOptions) {
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        String str = collapsedSemantics$ui_release != null ? (String) SemanticsConfigurationKt.getOrNull(collapsedSemantics$ui_release, SentryReplayModifiers.f52491a) : null;
        if (Intrinsics.b(str, "unmask")) {
            return false;
        }
        if (Intrinsics.b(str, "mask")) {
            return true;
        }
        String strC = c(layoutNode, z);
        if (sentryOptions.getSessionReplay().f51860d.contains(strC)) {
            return false;
        }
        return sentryOptions.getSessionReplay().f51859c.contains(strC);
    }

    public static void e(LayoutNode layoutNode, ViewHierarchyNode viewHierarchyNode, boolean z, SentryOptions sentryOptions) {
        List children$ui_release = layoutNode.getChildren$ui_release();
        if (children$ui_release.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(children$ui_release.size());
        int size = children$ui_release.size();
        for (int i2 = 0; i2 < size; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) children$ui_release.get(i2);
            ViewHierarchyNode viewHierarchyNodeA = a(layoutNode2, viewHierarchyNode, i2, z, sentryOptions);
            if (viewHierarchyNodeA != null) {
                arrayList.add(viewHierarchyNodeA);
                e(layoutNode2, viewHierarchyNodeA, false, sentryOptions);
            }
        }
        viewHierarchyNode.f52660f = arrayList;
    }
}
