package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public TypedValue f1000a;

    /* renamed from: b, reason: collision with root package name */
    public TypedValue f1001b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f1002c;

    /* renamed from: d, reason: collision with root package name */
    public TypedValue f1003d;

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f1004e;

    /* renamed from: f, reason: collision with root package name */
    public TypedValue f1005f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f1006g;

    /* renamed from: h, reason: collision with root package name */
    public OnAttachListener f1007h;

    public interface OnAttachListener {
        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1004e == null) {
            this.f1004e = new TypedValue();
        }
        return this.f1004e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1005f == null) {
            this.f1005f = new TypedValue();
        }
        return this.f1005f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1002c == null) {
            this.f1002c = new TypedValue();
        }
        return this.f1002c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1003d == null) {
            this.f1003d = new TypedValue();
        }
        return this.f1003d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1000a == null) {
            this.f1000a = new TypedValue();
        }
        return this.f1000a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1001b == null) {
            this.f1001b = new TypedValue();
        }
        return this.f1001b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.f1007h;
        if (onAttachListener != null) {
            onAttachListener.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.f1007h = onAttachListener;
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1006g = new Rect();
    }
}
