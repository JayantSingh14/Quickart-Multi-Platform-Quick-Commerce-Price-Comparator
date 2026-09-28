package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;

/* loaded from: classes3.dex */
class AppCompatPopupWindow extends PopupWindow {
    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2);
    }

    public final void a(Context context, AttributeSet attributeSet, int i2) {
        TintTypedArray tintTypedArrayF = TintTypedArray.f(context, attributeSet, R.styleable.PopupWindow, i2);
        int i3 = R.styleable.PopupWindow_overlapAnchor;
        TypedArray typedArray = tintTypedArrayF.f1185b;
        if (typedArray.hasValue(i3)) {
            setOverlapAnchor(typedArray.getBoolean(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(tintTypedArrayF.b(R.styleable.PopupWindow_android_popupBackground));
        tintTypedArrayF.g();
    }
}
