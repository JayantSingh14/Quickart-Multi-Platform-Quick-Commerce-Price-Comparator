package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* loaded from: classes4.dex */
class TimePickerView extends ConstraintLayout implements TimePickerControls {
    public static final /* synthetic */ int z = 0;
    public final Chip q;
    public final Chip r;
    public final ClockHandView s;
    public final ClockFaceView t;
    public final MaterialButtonToggleGroup u;
    public final View.OnClickListener v;
    public TimePickerClockPresenter w;
    public TimePickerClockPresenter x;
    public MaterialTimePicker y;

    public interface OnDoubleTapListener {
    }

    public interface OnPeriodChangeListener {
    }

    public interface OnSelectionChange {
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            this.r.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimePickerClockPresenter timePickerClockPresenter = TimePickerView.this.x;
                if (timePickerClockPresenter != null) {
                    timePickerClockPresenter.d(((Integer) view.getTag(R.id.selection_type)).intValue(), true);
                }
            }
        };
        this.v = onClickListener;
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.t = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.u = materialButtonToggleGroup;
        materialButtonToggleGroup.f40102c.add(new c(this, 1));
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        this.q = chip;
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.r = chip2;
        this.s = (ClockHandView) findViewById(R.id.material_clock_hand);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.google.android.material.timepicker.TimePickerView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                MaterialTimePicker materialTimePicker = TimePickerView.this.y;
                if (materialTimePicker == null) {
                    return false;
                }
                materialTimePicker.P0 = 1;
                materialTimePicker.z(materialTimePicker.N0);
                materialTimePicker.D0.d();
                return true;
            }
        });
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.google.android.material.timepicker.TimePickerView.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        chip.setOnTouchListener(onTouchListener);
        chip2.setOnTouchListener(onTouchListener);
        chip.setTag(R.id.selection_type, 12);
        chip2.setTag(R.id.selection_type, 10);
        chip.setOnClickListener(onClickListener);
        chip2.setOnClickListener(onClickListener);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }
}
