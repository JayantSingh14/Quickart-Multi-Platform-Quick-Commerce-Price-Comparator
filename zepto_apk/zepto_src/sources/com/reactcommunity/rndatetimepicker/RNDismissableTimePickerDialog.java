package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TimePicker;
import androidx.fragment.app.FragmentActivity;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class RNDismissableTimePickerDialog extends MinuteIntervalSnappableTimePickerDialog {
    public final void c(FragmentActivity fragmentActivity, int i2, int i3, boolean z, RNTimePickerDisplay rNTimePickerDisplay) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT == 24 && rNTimePickerDisplay == RNTimePickerDisplay.f46154a) {
            try {
                fragmentActivity.obtainStyledAttributes(null, (int[]) Class.forName("com.android.internal.R$styleable").getField("TimePicker").get(null), android.R.attr.timePickerStyle, 0).recycle();
                TimePicker timePicker = (TimePicker) ReflectionHelper.a(TimePickerDialog.class, "mTimePicker", TimePicker.class).get(this);
                Field fieldA = ReflectionHelper.a(TimePicker.class, "mDelegate", Class.forName("android.widget.TimePicker$TimePickerDelegate"));
                Object obj = fieldA.get(timePicker);
                Class<?> cls = Class.forName("android.widget.TimePickerSpinnerDelegate");
                if (obj.getClass() != cls) {
                    fieldA.set(timePicker, null);
                    timePicker.removeAllViews();
                    Class cls2 = Integer.TYPE;
                    Constructor<?> constructor = cls.getConstructor(TimePicker.class, Context.class, AttributeSet.class, cls2, cls2);
                    constructor.setAccessible(true);
                    fieldA.set(timePicker, constructor.newInstance(timePicker, fragmentActivity, null, Integer.valueOf(android.R.attr.timePickerStyle), 0));
                    timePicker.setIs24HourView(Boolean.valueOf(z));
                    timePicker.setCurrentHour(Integer.valueOf(i2));
                    timePicker.setCurrentMinute(Integer.valueOf(i3));
                    timePicker.setOnTimeChangedListener(this);
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
    }
}
