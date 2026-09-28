package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes4.dex */
class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: d, reason: collision with root package name */
    public final CalendarConstraints f40359d;

    /* renamed from: e, reason: collision with root package name */
    public final DateSelector f40360e;

    /* renamed from: f, reason: collision with root package name */
    public final DayViewDecorator f40361f;

    /* renamed from: g, reason: collision with root package name */
    public final MaterialCalendar.AnonymousClass3 f40362g;

    /* renamed from: h, reason: collision with root package name */
    public final int f40363h;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView u;
        public final MaterialCalendarGridView v;

        public ViewHolder(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.u = textView;
            ViewCompat.A(textView, true);
            this.v = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public MonthsPagerAdapter(ContextThemeWrapper contextThemeWrapper, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.AnonymousClass3 anonymousClass3) {
        Month month = calendarConstraints.f40275a;
        Month month2 = calendarConstraints.f40278d;
        if (month.f40344a.compareTo(month2.f40344a) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (month2.f40344a.compareTo(calendarConstraints.f40276b.f40344a) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f40363h = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * MonthAdapter.f40351g) + (MaterialDatePicker.B(android.R.attr.windowFullscreen, contextThemeWrapper) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.f40359d = calendarConstraints;
        this.f40360e = dateSelector;
        this.f40361f = dayViewDecorator;
        this.f40362g = anonymousClass3;
        w(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int d() {
        return this.f40359d.f40281g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long e(int i2) {
        Calendar calendarC = UtcDates.c(this.f40359d.f40275a.f40344a);
        calendarC.add(2, i2);
        return new Month(calendarC).f40344a.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void o(RecyclerView.ViewHolder viewHolder, int i2) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        CalendarConstraints calendarConstraints = this.f40359d;
        Calendar calendarC = UtcDates.c(calendarConstraints.f40275a.f40344a);
        calendarC.add(2, i2);
        Month month = new Month(calendarC);
        viewHolder2.u.setText(month.c());
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder2.v.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !month.equals(materialCalendarGridView.a().f40353a)) {
            MonthAdapter monthAdapter = new MonthAdapter(month, this.f40360e, calendarConstraints, this.f40361f);
            materialCalendarGridView.setNumColumns(month.f40347d);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            MonthAdapter monthAdapterA = materialCalendarGridView.a();
            Iterator it = monthAdapterA.f40355c.iterator();
            while (it.hasNext()) {
                monthAdapterA.f(materialCalendarGridView, ((Long) it.next()).longValue());
            }
            DateSelector dateSelector = monthAdapterA.f40354b;
            if (dateSelector != null) {
                Iterator it2 = dateSelector.p6().iterator();
                while (it2.hasNext()) {
                    monthAdapterA.f(materialCalendarGridView, ((Long) it2.next()).longValue());
                }
                monthAdapterA.f40355c = dateSelector.p6();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.datepicker.MonthsPagerAdapter.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
                MaterialCalendarGridView materialCalendarGridView2 = materialCalendarGridView;
                MonthAdapter monthAdapterA2 = materialCalendarGridView2.a();
                if (i3 < monthAdapterA2.a() || i3 > monthAdapterA2.d()) {
                    return;
                }
                MaterialCalendar.AnonymousClass3 anonymousClass3 = MonthsPagerAdapter.this.f40362g;
                long jLongValue = materialCalendarGridView2.a().getItem(i3).longValue();
                MaterialCalendar materialCalendar = MaterialCalendar.this;
                if (materialCalendar.Z.f40277c.V2(jLongValue)) {
                    materialCalendar.Y.w8(jLongValue);
                    Iterator it3 = materialCalendar.Q.iterator();
                    while (it3.hasNext()) {
                        ((OnSelectionChangedListener) it3.next()).b(materialCalendar.Y.R6());
                    }
                    materialCalendar.F0.getAdapter().g();
                    RecyclerView recyclerView = materialCalendar.E0;
                    if (recyclerView != null) {
                        recyclerView.getAdapter().g();
                    }
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder p(ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.B(android.R.attr.windowFullscreen, viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f40363h));
        return new ViewHolder(linearLayout, true);
    }
}
