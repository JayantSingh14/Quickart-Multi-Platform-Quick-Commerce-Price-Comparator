package io.sentry.android.core.internal.gestures;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.ScrollingView;
import io.sentry.android.core.internal.util.ClassUtil;
import io.sentry.internal.gestures.GestureTargetLocator;
import io.sentry.internal.gestures.UiElement;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class AndroidViewGestureTargetLocator implements GestureTargetLocator {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f52262a;

    public AndroidViewGestureTargetLocator(boolean z) {
        this.f52262a = z;
    }

    @Override // io.sentry.internal.gestures.GestureTargetLocator
    public final UiElement a(View view, UiElement.Type type) {
        if (view != null) {
            if (type == UiElement.Type.CLICKABLE && view.isClickable() && view.getVisibility() == 0) {
                try {
                    return new UiElement(view, ClassUtil.a(view), ViewUtils.b(view));
                } catch (Resources.NotFoundException unused) {
                    return null;
                }
            }
            if (type == UiElement.Type.SCROLLABLE) {
                boolean z = false;
                if (((!this.f52262a ? false : ScrollingView.class.isAssignableFrom(view.getClass())) || AbsListView.class.isAssignableFrom(view.getClass()) || ScrollView.class.isAssignableFrom(view.getClass())) && view.getVisibility() == 0) {
                    z = true;
                }
                if (z) {
                    try {
                        return new UiElement(view, ClassUtil.a(view), ViewUtils.b(view));
                    } catch (Resources.NotFoundException unused2) {
                    }
                }
            }
        }
        return null;
    }
}
