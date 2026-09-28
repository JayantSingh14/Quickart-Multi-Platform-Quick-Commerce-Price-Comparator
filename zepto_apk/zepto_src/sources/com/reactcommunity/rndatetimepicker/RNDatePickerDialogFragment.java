package com.reactcommunity.rndatetimepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Calendar;
import java.util.Locale;

@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public class RNDatePickerDialogFragment extends DialogFragment {
    public RNDismissableDatePickerDialog Q;
    public DatePickerDialog.OnDateSetListener X;
    public DialogInterface.OnDismissListener Y;
    public DialogInterface.OnClickListener Z;

    /* JADX WARN: Type inference failed for: r0v10, types: [com.reactcommunity.rndatetimepicker.b] */
    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        RNDismissableDatePickerDialog rNDismissableDatePickerDialog;
        long timeInMillis;
        long timeInMillis2;
        final Bundle arguments = getArguments();
        FragmentActivity activity = getActivity();
        DatePickerDialog.OnDateSetListener onDateSetListener = this.X;
        RNDate rNDate = new RNDate(arguments);
        int i2 = rNDate.f46150a.get(1);
        int i3 = rNDate.f46150a.get(2);
        int i4 = rNDate.f46150a.get(5);
        RNDatePickerDisplay rNDatePickerDisplayValueOf = RNDatePickerDisplay.f46152b;
        RNDatePickerDisplay rNDatePickerDisplayValueOf2 = (arguments == null || arguments.getString("display", null) == null) ? rNDatePickerDisplayValueOf : RNDatePickerDisplay.valueOf(arguments.getString("display").toUpperCase(Locale.US));
        if (arguments != null && arguments.getString("display", null) != null) {
            rNDatePickerDisplayValueOf2 = RNDatePickerDisplay.valueOf(arguments.getString("display").toUpperCase(Locale.US));
        }
        RNDatePickerDisplay rNDatePickerDisplay = rNDatePickerDisplayValueOf2;
        RNDatePickerDisplay rNDatePickerDisplay2 = RNDatePickerDisplay.f46151a;
        if (rNDatePickerDisplay == rNDatePickerDisplay2) {
            rNDismissableDatePickerDialog = new RNDismissableDatePickerDialog(activity, R.style.SpinnerDatePickerDialog, onDateSetListener, i2, i3, i4);
            rNDismissableDatePickerDialog.a(activity, i2, i3, i4, rNDatePickerDisplay);
        } else {
            rNDismissableDatePickerDialog = new RNDismissableDatePickerDialog(activity, onDateSetListener, i2, i3, i4);
            rNDismissableDatePickerDialog.a(activity, i2, i3, i4, rNDatePickerDisplay);
        }
        RNDismissableDatePickerDialog rNDismissableDatePickerDialog2 = rNDismissableDatePickerDialog;
        if (arguments != null) {
            Common.d(arguments, rNDismissableDatePickerDialog2, this.Z);
            if (activity != null) {
                if (arguments.getString("display", null) != null) {
                    rNDatePickerDisplayValueOf = RNDatePickerDisplay.valueOf(arguments.getString("display").toUpperCase(Locale.US));
                }
                rNDismissableDatePickerDialog2.setOnShowListener(new a(rNDismissableDatePickerDialog2, activity, arguments, rNDatePickerDisplayValueOf == rNDatePickerDisplay2));
            }
        }
        final DatePicker datePicker = rNDismissableDatePickerDialog2.getDatePicker();
        if (arguments.containsKey("minimumDate")) {
            Calendar calendar = Calendar.getInstance(Common.c(arguments));
            calendar.setTimeInMillis(arguments.getLong("minimumDate"));
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            timeInMillis = calendar.getTimeInMillis();
        } else {
            timeInMillis = 0;
        }
        if (arguments.containsKey("maximumDate")) {
            Calendar calendar2 = Calendar.getInstance(Common.c(arguments));
            calendar2.setTimeInMillis(arguments.getLong("maximumDate"));
            calendar2.set(11, 23);
            calendar2.set(12, 59);
            calendar2.set(13, 59);
            calendar2.set(14, 999);
            timeInMillis2 = calendar2.getTimeInMillis();
        } else {
            timeInMillis2 = Long.MAX_VALUE;
        }
        final long j2 = timeInMillis2;
        if (arguments.containsKey("minimumDate")) {
            datePicker.setMinDate(timeInMillis);
        } else {
            datePicker.setMinDate(-2208988800001L);
        }
        if (arguments.containsKey("maximumDate")) {
            datePicker.setMaxDate(j2);
        }
        int i5 = Build.VERSION.SDK_INT;
        if (arguments.containsKey("firstDayOfWeek")) {
            datePicker.setFirstDayOfWeek(arguments.getInt("firstDayOfWeek"));
        }
        if (i5 >= 26 && (arguments.containsKey("maximumDate") || arguments.containsKey("minimumDate"))) {
            final long j3 = timeInMillis;
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() { // from class: com.reactcommunity.rndatetimepicker.b
                @Override // android.widget.DatePicker.OnDateChangedListener
                public final void onDateChanged(DatePicker datePicker2, int i6, int i7, int i8) {
                    Calendar calendar3 = Calendar.getInstance(Common.c(arguments));
                    calendar3.set(i6, i7, i8, 0, 0, 0);
                    calendar3.setTimeInMillis(Math.min(Math.max(calendar3.getTimeInMillis(), j3), j2));
                    DatePicker datePicker3 = datePicker;
                    if (datePicker3.getYear() == calendar3.get(1) && datePicker3.getMonth() == calendar3.get(2) && datePicker3.getDayOfMonth() == calendar3.get(5)) {
                        return;
                    }
                    datePicker3.updateDate(calendar3.get(1), calendar3.get(2), calendar3.get(5));
                }
            });
        }
        if (arguments.containsKey("testID")) {
            datePicker.setTag(arguments.getString("testID"));
        }
        this.Q = rNDismissableDatePickerDialog2;
        return rNDismissableDatePickerDialog2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.Y;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}
