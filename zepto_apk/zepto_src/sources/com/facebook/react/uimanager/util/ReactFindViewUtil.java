package com.facebook.react.uimanager.util;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReactFindViewUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f19923a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f19924b = new HashMap();

    @Metadata
    public interface OnMultipleViewsFoundListener {
        void a();
    }

    @Metadata
    public interface OnViewFoundListener {
        void a();

        String b();
    }

    public static final View a(View root, String nativeId) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(nativeId, "nativeId");
        Object tag = root.getTag(R.id.view_tag_native_id);
        if (Intrinsics.b(tag instanceof String ? (String) tag : null, nativeId)) {
            return root;
        }
        if (root instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) root;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                View viewA = a(childAt, nativeId);
                if (viewA != null) {
                    return viewA;
                }
            }
        }
        return null;
    }

    public static final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag(R.id.view_tag_native_id);
        String str = tag instanceof String ? (String) tag : null;
        if (str == null) {
            return;
        }
        Iterator it = f19923a.iterator();
        while (it.hasNext()) {
            OnViewFoundListener onViewFoundListener = (OnViewFoundListener) it.next();
            if (str.equals(onViewFoundListener.b())) {
                onViewFoundListener.a();
                it.remove();
            }
        }
        for (Map.Entry entry : f19924b.entrySet()) {
            OnMultipleViewsFoundListener onMultipleViewsFoundListener = (OnMultipleViewsFoundListener) entry.getKey();
            if (((Set) entry.getValue()).contains(str)) {
                onMultipleViewsFoundListener.a();
            }
        }
    }
}
