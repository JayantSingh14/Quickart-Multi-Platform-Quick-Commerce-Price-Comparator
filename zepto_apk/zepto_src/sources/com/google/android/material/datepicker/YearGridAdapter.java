package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes4.dex */
class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: d, reason: collision with root package name */
    public final MaterialCalendar f40384d;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView u;

        public ViewHolder(TextView textView) {
            super(textView);
            this.u = textView;
        }
    }

    public YearGridAdapter(MaterialCalendar materialCalendar) {
        this.f40384d = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int d() {
        return this.f40384d.Z.f40280f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void o(RecyclerView.ViewHolder viewHolder, int i2) {
        MaterialCalendar materialCalendar = this.f40384d;
        final int i3 = materialCalendar.Z.f40275a.f40346c + i2;
        String str = String.format(Locale.getDefault(), "%d", Integer.valueOf(i3));
        TextView textView = ((ViewHolder) viewHolder).u;
        textView.setText(str);
        Context context = textView.getContext();
        textView.setContentDescription(UtcDates.f().get(1) == i3 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i3)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i3)));
        CalendarStyle calendarStyle = materialCalendar.D0;
        Calendar calendarF = UtcDates.f();
        CalendarItemStyle calendarItemStyle = calendarF.get(1) == i3 ? calendarStyle.f40296f : calendarStyle.f40294d;
        Iterator it = materialCalendar.Y.p6().iterator();
        while (it.hasNext()) {
            calendarF.setTimeInMillis(((Long) it.next()).longValue());
            if (calendarF.get(1) == i3) {
                calendarItemStyle = calendarStyle.f40295e;
            }
        }
        calendarItemStyle.b(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.YearGridAdapter.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YearGridAdapter yearGridAdapter = YearGridAdapter.this;
                Month monthA = Month.a(i3, yearGridAdapter.f40384d.B0.f40345b);
                MaterialCalendar materialCalendar2 = yearGridAdapter.f40384d;
                CalendarConstraints calendarConstraints = materialCalendar2.Z;
                Month month = calendarConstraints.f40275a;
                Calendar calendar = month.f40344a;
                Calendar calendar2 = monthA.f40344a;
                if (calendar2.compareTo(calendar) < 0) {
                    monthA = month;
                } else {
                    Month month2 = calendarConstraints.f40276b;
                    if (calendar2.compareTo(month2.f40344a) > 0) {
                        monthA = month2;
                    }
                }
                materialCalendar2.z(monthA);
                materialCalendar2.A(MaterialCalendar.CalendarSelector.f40332a);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder p(ViewGroup viewGroup, int i2) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
