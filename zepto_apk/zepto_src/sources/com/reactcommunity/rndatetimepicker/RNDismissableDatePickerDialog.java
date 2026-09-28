package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.DatePicker;
import androidx.fragment.app.FragmentActivity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class RNDismissableDatePickerDialog extends DatePickerDialog {
    public final void a(FragmentActivity fragmentActivity, int i2, int i3, int i4, RNDatePickerDisplay rNDatePickerDisplay) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        int i5 = Build.VERSION.SDK_INT;
        RNDatePickerDisplay rNDatePickerDisplay2 = RNDatePickerDisplay.f46151a;
        if (i5 == 24 && rNDatePickerDisplay == rNDatePickerDisplay2) {
            try {
                fragmentActivity.obtainStyledAttributes(null, (int[]) Class.forName("com.android.internal.R$styleable").getField("DatePicker").get(null), android.R.attr.datePickerStyle, 0).recycle();
                DatePicker datePicker = (DatePicker) ReflectionHelper.a(DatePickerDialog.class, "mDatePicker", DatePicker.class).get(this);
                Field fieldA = ReflectionHelper.a(DatePicker.class, "mDelegate", Class.forName("android.widget.DatePickerSpinnerDelegate"));
                Object obj = fieldA.get(datePicker);
                if (obj.getClass() != Class.forName("android.widget.DatePickerSpinnerDelegate")) {
                    fieldA.set(datePicker, null);
                    datePicker.removeAllViews();
                    Class cls = Integer.TYPE;
                    Method declaredMethod = DatePicker.class.getDeclaredMethod("createSpinnerUIDelegate", Context.class, AttributeSet.class, cls, cls);
                    declaredMethod.setAccessible(true);
                    fieldA.set(datePicker, declaredMethod.invoke(datePicker, fragmentActivity, null, Integer.valueOf(android.R.attr.datePickerStyle), 0));
                    datePicker.setCalendarViewShown(false);
                    datePicker.init(i2, i3, i4, this);
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        if (rNDatePickerDisplay != rNDatePickerDisplay2 || getDatePicker() == null) {
            return;
        }
        getDatePicker().setCalendarViewShown(false);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
    }
}
