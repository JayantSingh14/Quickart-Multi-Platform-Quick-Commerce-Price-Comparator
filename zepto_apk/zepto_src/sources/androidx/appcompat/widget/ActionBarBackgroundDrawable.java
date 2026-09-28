package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f683a;

    @RequiresApi
    public static class Api21Impl {
    }

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f683a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f683a;
        if (actionBarContainer.f691h) {
            Drawable drawable = actionBarContainer.f690g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f688e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f689f;
        if (drawable3 == null || !actionBarContainer.f692i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f683a;
        if (actionBarContainer.f691h) {
            if (actionBarContainer.f690g != null) {
                actionBarContainer.f688e.getOutline(outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f688e;
            if (drawable != null) {
                drawable.getOutline(outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
