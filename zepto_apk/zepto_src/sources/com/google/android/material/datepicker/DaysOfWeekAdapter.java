package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes4.dex */
class DaysOfWeekAdapter extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    public static final int f40313d;

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f40314a;

    /* renamed from: b, reason: collision with root package name */
    public final int f40315b;

    /* renamed from: c, reason: collision with root package name */
    public final int f40316c;

    static {
        f40313d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public DaysOfWeekAdapter() {
        Calendar calendarG = UtcDates.g(null);
        this.f40314a = calendarG;
        this.f40315b = calendarG.getMaximum(7);
        this.f40316c = calendarG.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f40315b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        int i3 = this.f40315b;
        if (i2 >= i3) {
            return null;
        }
        int i4 = i2 + this.f40316c;
        if (i4 > i3) {
            i4 -= i3;
        }
        return Integer.valueOf(i4);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i3 = i2 + this.f40316c;
        int i4 = this.f40315b;
        if (i3 > i4) {
            i3 -= i4;
        }
        Calendar calendar = this.f40314a;
        calendar.set(7, i3);
        textView.setText(calendar.getDisplayName(7, f40313d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public DaysOfWeekAdapter(int i2) {
        Calendar calendarG = UtcDates.g(null);
        this.f40314a = calendarG;
        this.f40315b = calendarG.getMaximum(7);
        this.f40316c = i2;
    }
}
