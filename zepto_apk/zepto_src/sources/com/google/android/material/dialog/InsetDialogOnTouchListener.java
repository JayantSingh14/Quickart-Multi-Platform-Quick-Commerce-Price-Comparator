package com.google.android.material.dialog;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public class InsetDialogOnTouchListener implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final Dialog f40395a;

    /* renamed from: b, reason: collision with root package name */
    public final int f40396b;

    /* renamed from: c, reason: collision with root package name */
    public final int f40397c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40398d;

    public InsetDialogOnTouchListener(Dialog dialog, Rect rect) {
        this.f40395a = dialog;
        this.f40396b = rect.left;
        this.f40397c = rect.top;
        this.f40398d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = viewFindViewById.getLeft() + this.f40396b;
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, viewFindViewById.getTop() + this.f40397c, width, viewFindViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i2 = this.f40398d;
            motionEventObtain.setLocation((-i2) - 1, (-i2) - 1);
        }
        view.performClick();
        return this.f40395a.onTouchEvent(motionEventObtain);
    }
}
