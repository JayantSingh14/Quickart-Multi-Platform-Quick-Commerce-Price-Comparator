package io.sentry.android.core.internal.gestures;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.internal.gestures.GestureTargetLocator;
import io.sentry.internal.gestures.UiElement;
import java.util.Iterator;
import java.util.LinkedList;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class ViewUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f52280a = new int[2];

    public static UiElement a(SentryAndroidOptions sentryAndroidOptions, View view, float f2, float f3, UiElement.Type type) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        UiElement uiElement = null;
        while (linkedList.size() > 0) {
            View view2 = (View) linkedList.poll();
            if (view2 != null) {
                int[] iArr = f52280a;
                view2.getLocationOnScreen(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                int width = view2.getWidth();
                int height = view2.getHeight();
                if (f2 >= i2 && f2 <= i2 + width && f3 >= i3 && f3 <= i3 + height) {
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                            linkedList.add(viewGroup.getChildAt(i4));
                        }
                    }
                    Iterator<GestureTargetLocator> it = sentryAndroidOptions.getGestureTargetLocators().iterator();
                    while (it.hasNext()) {
                        UiElement uiElementA = it.next().a(view2, type);
                        if (uiElementA != null) {
                            if (type == UiElement.Type.CLICKABLE) {
                                uiElement = uiElementA;
                            } else if (type == UiElement.Type.SCROLLABLE) {
                                return uiElementA;
                            }
                        }
                    }
                }
            }
        }
        return uiElement;
    }

    public static String b(View view) {
        int id = view.getId();
        if (id == -1 || (((-16777216) & id) == 0 && (16777215 & id) != 0)) {
            throw new Resources.NotFoundException();
        }
        Resources resources = view.getContext().getResources();
        return resources != null ? resources.getResourceEntryName(id) : "";
    }
}
