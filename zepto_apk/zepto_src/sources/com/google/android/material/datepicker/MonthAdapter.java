package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes4.dex */
class MonthAdapter extends BaseAdapter {

    /* renamed from: g, reason: collision with root package name */
    public static final int f40351g = UtcDates.g(null).getMaximum(4);

    /* renamed from: h, reason: collision with root package name */
    public static final int f40352h = (UtcDates.g(null).getMaximum(7) + UtcDates.g(null).getMaximum(5)) - 1;

    /* renamed from: a, reason: collision with root package name */
    public final Month f40353a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector f40354b;

    /* renamed from: c, reason: collision with root package name */
    public Collection f40355c;

    /* renamed from: d, reason: collision with root package name */
    public CalendarStyle f40356d;

    /* renamed from: e, reason: collision with root package name */
    public final CalendarConstraints f40357e;

    /* renamed from: f, reason: collision with root package name */
    public final DayViewDecorator f40358f;

    public MonthAdapter(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f40353a = month;
        this.f40354b = dateSelector;
        this.f40357e = calendarConstraints;
        this.f40358f = dayViewDecorator;
        this.f40355c = dateSelector.p6();
    }

    public final int a() {
        int firstDayOfWeek = this.f40357e.f40279e;
        Month month = this.f40353a;
        Calendar calendar = month.f40344a;
        int i2 = calendar.get(7);
        if (firstDayOfWeek <= 0) {
            firstDayOfWeek = calendar.getFirstDayOfWeek();
        }
        int i3 = i2 - firstDayOfWeek;
        return i3 < 0 ? i3 + month.f40347d : i3;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i2) {
        if (i2 < a() || i2 > d()) {
            return null;
        }
        int iA = (i2 - a()) + 1;
        Calendar calendarC = UtcDates.c(this.f40353a.f40344a);
        calendarC.set(5, iA);
        return Long.valueOf(calendarC.getTimeInMillis());
    }

    public final int d() {
        return (a() + this.f40353a.f40348e) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(TextView textView, long j2, int i2) {
        boolean z;
        boolean z2;
        CalendarItemStyle calendarItemStyle;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        boolean z3 = false;
        boolean z4 = UtcDates.f().getTimeInMillis() == j2;
        DateSelector dateSelector = this.f40354b;
        Iterator it = dateSelector.d4().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            F f2 = ((Pair) it.next()).f2989a;
            if (f2 != 0 && ((Long) f2).longValue() == j2) {
                z = true;
                break;
            }
        }
        Iterator it2 = dateSelector.d4().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z2 = false;
                break;
            }
            S s = ((Pair) it2.next()).f2990b;
            if (s != 0 && ((Long) s).longValue() == j2) {
                z2 = true;
                break;
            }
        }
        Calendar calendarF = UtcDates.f();
        Calendar calendarG = UtcDates.g(null);
        calendarG.setTimeInMillis(j2);
        String str = calendarF.get(1) == calendarG.get(1) ? UtcDates.b("MMMMEEEEd", Locale.getDefault()).format(new Date(j2)) : UtcDates.b("yMMMMEEEEd", Locale.getDefault()).format(new Date(j2));
        if (z4) {
            str = String.format(context.getString(R.string.mtrl_picker_today_description), str);
        }
        if (z) {
            str = String.format(context.getString(R.string.mtrl_picker_start_date_description), str);
        } else if (z2) {
            str = String.format(context.getString(R.string.mtrl_picker_end_date_description), str);
        }
        textView.setContentDescription(str);
        if (this.f40357e.f40277c.V2(j2)) {
            textView.setEnabled(true);
            Iterator it3 = dateSelector.p6().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                if (UtcDates.a(j2) == UtcDates.a(((Long) it3.next()).longValue())) {
                    z3 = true;
                    break;
                }
            }
            textView.setSelected(z3);
            calendarItemStyle = z3 ? this.f40356d.f40292b : UtcDates.f().getTimeInMillis() == j2 ? this.f40356d.f40293c : this.f40356d.f40291a;
        } else {
            textView.setEnabled(false);
            calendarItemStyle = this.f40356d.f40297g;
        }
        if (this.f40358f == null || i2 == -1) {
            calendarItemStyle.b(textView);
            return;
        }
        int i3 = this.f40353a.f40346c;
        calendarItemStyle.b(textView);
        textView.setCompoundDrawables(null, null, null, null);
        textView.setContentDescription(str);
    }

    public final void f(MaterialCalendarGridView materialCalendarGridView, long j2) {
        Month monthB = Month.b(j2);
        Month month = this.f40353a;
        if (monthB.equals(month)) {
            Calendar calendarC = UtcDates.c(month.f40344a);
            calendarC.setTimeInMillis(j2);
            int i2 = calendarC.get(5);
            e((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.a().a() + (i2 - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j2, i2);
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f40352h;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2 / this.f40353a.f40347d;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            com.google.android.material.datepicker.CalendarStyle r1 = r5.f40356d
            if (r1 != 0) goto Lf
            com.google.android.material.datepicker.CalendarStyle r1 = new com.google.android.material.datepicker.CalendarStyle
            r1.<init>(r0)
            r5.f40356d = r1
        Lf:
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L26
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L26:
            int r7 = r5.a()
            int r7 = r6 - r7
            if (r7 < 0) goto L5c
            com.google.android.material.datepicker.Month r8 = r5.f40353a
            int r2 = r8.f40348e
            if (r7 < r2) goto L35
            goto L5c
        L35:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L65
        L5c:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L65:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L6c
            return r0
        L6c:
            long r1 = r6.longValue()
            r5.e(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
