package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes4.dex */
public interface DateSelector<S> extends Parcelable {
    static void i5(EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        c cVar = new c(editTextArr, 0);
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(cVar);
        }
        EditText editText2 = editTextArr[0];
        editText2.postDelayed(new androidx.constraintlayout.helper.widget.a(editText2, 21), 100L);
    }

    Object R6();

    ArrayList d4();

    String j1(Context context);

    View j7(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, OnSelectionChangedListener onSelectionChangedListener);

    ArrayList p6();

    int w1(Context context);

    void w8(long j2);

    String y3(Context context);

    boolean y5();
}
