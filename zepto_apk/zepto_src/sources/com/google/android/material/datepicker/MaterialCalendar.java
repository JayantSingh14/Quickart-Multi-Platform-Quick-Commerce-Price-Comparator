package com.google.android.material.datepicker;

import android.R;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

@RestrictTo
/* loaded from: classes4.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    public DayViewDecorator A0;
    public Month B0;
    public CalendarSelector C0;
    public CalendarStyle D0;
    public RecyclerView E0;
    public RecyclerView F0;
    public View G0;
    public View H0;
    public View I0;
    public View J0;
    public int X;
    public DateSelector Y;
    public CalendarConstraints Z;

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$1, reason: invalid class name */
    class AnonymousClass1 extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.o(null);
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$3, reason: invalid class name */
    class AnonymousClass3 implements OnDayClickListener {
        public AnonymousClass3() {
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$4, reason: invalid class name */
    class AnonymousClass4 extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.u(false);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class CalendarSelector {

        /* renamed from: a, reason: collision with root package name */
        public static final CalendarSelector f40332a;

        /* renamed from: b, reason: collision with root package name */
        public static final CalendarSelector f40333b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ CalendarSelector[] f40334c;

        static {
            CalendarSelector calendarSelector = new CalendarSelector("DAY", 0);
            f40332a = calendarSelector;
            CalendarSelector calendarSelector2 = new CalendarSelector("YEAR", 1);
            f40333b = calendarSelector2;
            f40334c = new CalendarSelector[]{calendarSelector, calendarSelector2};
        }

        public static CalendarSelector valueOf(String str) {
            return (CalendarSelector) Enum.valueOf(CalendarSelector.class, str);
        }

        public static CalendarSelector[] values() {
            return (CalendarSelector[]) f40334c.clone();
        }
    }

    public interface OnDayClickListener {
    }

    public final void A(CalendarSelector calendarSelector) {
        this.C0 = calendarSelector;
        if (calendarSelector == CalendarSelector.f40333b) {
            this.E0.getLayoutManager().u0(this.B0.f40346c - ((YearGridAdapter) this.E0.getAdapter()).f40384d.Z.f40275a.f40346c);
            this.I0.setVisibility(0);
            this.J0.setVisibility(8);
            this.G0.setVisibility(8);
            this.H0.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.f40332a) {
            this.I0.setVisibility(8);
            this.J0.setVisibility(0);
            this.G0.setVisibility(0);
            this.H0.setVisibility(0);
            z(this.B0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.X = bundle.getInt("THEME_RES_ID_KEY");
        this.Y = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.Z = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.A0 = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.B0 = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        int i2;
        final int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.X);
        this.D0 = new CalendarStyle(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.Z.f40275a;
        if (MaterialDatePicker.B(R.attr.windowFullscreen, contextThemeWrapper)) {
            i2 = com.google.android.material.R.layout.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = com.google.android.material.R.layout.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i2, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_days_of_week_height);
        int i4 = MonthAdapter.f40351g;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_vertical_padding) * (i4 - 1)) + (resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_height) * i4) + resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(com.google.android.material.R.id.mtrl_calendar_days_of_week);
        ViewCompat.z(gridView, new AnonymousClass1());
        int i5 = this.Z.f40279e;
        gridView.setAdapter((ListAdapter) (i5 > 0 ? new DaysOfWeekAdapter(i5) : new DaysOfWeekAdapter()));
        gridView.setNumColumns(month.f40347d);
        gridView.setEnabled(false);
        this.F0 = (RecyclerView) viewInflate.findViewById(com.google.android.material.R.id.mtrl_calendar_months);
        getContext();
        this.F0.setLayoutManager(new SmoothCalendarLayoutManager(i3) { // from class: com.google.android.material.datepicker.MaterialCalendar.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            public final void H0(RecyclerView.State state, int[] iArr) {
                int i6 = i3;
                MaterialCalendar materialCalendar = MaterialCalendar.this;
                if (i6 == 0) {
                    iArr[0] = materialCalendar.F0.getWidth();
                    iArr[1] = materialCalendar.F0.getWidth();
                } else {
                    iArr[0] = materialCalendar.F0.getHeight();
                    iArr[1] = materialCalendar.F0.getHeight();
                }
            }
        });
        this.F0.setTag("MONTHS_VIEW_GROUP_TAG");
        final MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.Y, this.Z, this.A0, new AnonymousClass3());
        this.F0.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(com.google.android.material.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(com.google.android.material.R.id.mtrl_calendar_year_selector_frame);
        this.E0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.E0.setLayoutManager(new GridLayoutManager(integer));
            this.E0.setAdapter(new YearGridAdapter(this));
            this.E0.i(new RecyclerView.ItemDecoration() { // from class: com.google.android.material.datepicker.MaterialCalendar.5

                /* renamed from: a, reason: collision with root package name */
                public final Calendar f40322a = UtcDates.g(null);

                /* renamed from: b, reason: collision with root package name */
                public final Calendar f40323b = UtcDates.g(null);

                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public final void g(Canvas canvas, RecyclerView recyclerView2) {
                    if ((recyclerView2.getAdapter() instanceof YearGridAdapter) && (recyclerView2.getLayoutManager() instanceof GridLayoutManager)) {
                        YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView2.getAdapter();
                        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView2.getLayoutManager();
                        MaterialCalendar materialCalendar = MaterialCalendar.this;
                        Iterator it = materialCalendar.Y.d4().iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            F f2 = pair.f2989a;
                            if (f2 != 0 && pair.f2990b != null) {
                                long jLongValue = ((Long) f2).longValue();
                                Calendar calendar = this.f40322a;
                                calendar.setTimeInMillis(jLongValue);
                                long jLongValue2 = ((Long) pair.f2990b).longValue();
                                Calendar calendar2 = this.f40323b;
                                calendar2.setTimeInMillis(jLongValue2);
                                int i6 = calendar.get(1) - yearGridAdapter.f40384d.Z.f40275a.f40346c;
                                int i7 = calendar2.get(1) - yearGridAdapter.f40384d.Z.f40275a.f40346c;
                                View viewQ = gridLayoutManager.q(i6);
                                View viewQ2 = gridLayoutManager.q(i7);
                                int i8 = gridLayoutManager.F;
                                int i9 = i6 / i8;
                                int i10 = i7 / i8;
                                for (int i11 = i9; i11 <= i10; i11++) {
                                    View viewQ3 = gridLayoutManager.q(gridLayoutManager.F * i11);
                                    if (viewQ3 != null) {
                                        int top = viewQ3.getTop() + materialCalendar.D0.f40294d.f40285a.top;
                                        int bottom = viewQ3.getBottom() - materialCalendar.D0.f40294d.f40285a.bottom;
                                        canvas.drawRect((i11 != i9 || viewQ == null) ? 0 : (viewQ.getWidth() / 2) + viewQ.getLeft(), top, (i11 != i10 || viewQ2 == null) ? recyclerView2.getWidth() : (viewQ2.getWidth() / 2) + viewQ2.getLeft(), bottom, materialCalendar.D0.f40298h);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
        if (viewInflate.findViewById(com.google.android.material.R.id.month_navigation_fragment_toggle) != null) {
            final MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(com.google.android.material.R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.z(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendar.6
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    accessibilityNodeInfoCompat.s(materialCalendar.J0.getVisibility() == 0 ? materialCalendar.getString(com.google.android.material.R.string.mtrl_picker_toggle_to_year_selection) : materialCalendar.getString(com.google.android.material.R.string.mtrl_picker_toggle_to_day_selection));
                }
            });
            View viewFindViewById = viewInflate.findViewById(com.google.android.material.R.id.month_navigation_previous);
            this.G0 = viewFindViewById;
            viewFindViewById.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById2 = viewInflate.findViewById(com.google.android.material.R.id.month_navigation_next);
            this.H0 = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.I0 = viewInflate.findViewById(com.google.android.material.R.id.mtrl_calendar_year_selector_frame);
            this.J0 = viewInflate.findViewById(com.google.android.material.R.id.mtrl_calendar_day_selector_frame);
            A(CalendarSelector.f40332a);
            materialButton.setText(this.B0.c());
            this.F0.k(new RecyclerView.OnScrollListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.7
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void a(int i6, RecyclerView recyclerView2) {
                    if (i6 == 0) {
                        recyclerView2.announceForAccessibility(materialButton.getText());
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void b(RecyclerView recyclerView2, int i6, int i7) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    int iR0 = i6 < 0 ? ((LinearLayoutManager) materialCalendar.F0.getLayoutManager()).R0() : ((LinearLayoutManager) materialCalendar.F0.getLayoutManager()).S0();
                    CalendarConstraints calendarConstraints = monthsPagerAdapter.f40359d;
                    Calendar calendarC = UtcDates.c(calendarConstraints.f40275a.f40344a);
                    calendarC.add(2, iR0);
                    materialCalendar.B0 = new Month(calendarC);
                    Calendar calendarC2 = UtcDates.c(calendarConstraints.f40275a.f40344a);
                    calendarC2.add(2, iR0);
                    materialButton.setText(new Month(calendarC2).c());
                }
            });
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    CalendarSelector calendarSelector = materialCalendar.C0;
                    CalendarSelector calendarSelector2 = CalendarSelector.f40333b;
                    CalendarSelector calendarSelector3 = CalendarSelector.f40332a;
                    if (calendarSelector == calendarSelector2) {
                        materialCalendar.A(calendarSelector3);
                    } else if (calendarSelector == calendarSelector3) {
                        materialCalendar.A(calendarSelector2);
                    }
                }
            });
            this.H0.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    int iR0 = ((LinearLayoutManager) materialCalendar.F0.getLayoutManager()).R0() + 1;
                    if (iR0 < materialCalendar.F0.getAdapter().d()) {
                        Calendar calendarC = UtcDates.c(monthsPagerAdapter.f40359d.f40275a.f40344a);
                        calendarC.add(2, iR0);
                        materialCalendar.z(new Month(calendarC));
                    }
                }
            });
            this.G0.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    int iS0 = ((LinearLayoutManager) materialCalendar.F0.getLayoutManager()).S0() - 1;
                    if (iS0 >= 0) {
                        Calendar calendarC = UtcDates.c(monthsPagerAdapter.f40359d.f40275a.f40344a);
                        calendarC.add(2, iS0);
                        materialCalendar.z(new Month(calendarC));
                    }
                }
            });
        }
        if (!MaterialDatePicker.B(R.attr.windowFullscreen, contextThemeWrapper)) {
            new PagerSnapHelper().b(this.F0);
        }
        this.F0.j0(monthsPagerAdapter.f40359d.f40275a.d(this.B0));
        ViewCompat.z(this.F0, new AnonymousClass4());
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.X);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.Y);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Z);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.A0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.B0);
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public final void y(OnSelectionChangedListener onSelectionChangedListener) {
        this.Q.add(onSelectionChangedListener);
    }

    public final void z(Month month) {
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.F0.getAdapter();
        final int iD = monthsPagerAdapter.f40359d.f40275a.d(month);
        int iD2 = iD - monthsPagerAdapter.f40359d.f40275a.d(this.B0);
        boolean z = Math.abs(iD2) > 3;
        boolean z2 = iD2 > 0;
        this.B0 = month;
        if (z && z2) {
            this.F0.j0(iD - 3);
            this.F0.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.11
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialCalendar.this.F0.m0(iD);
                }
            });
        } else if (!z) {
            this.F0.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.11
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialCalendar.this.F0.m0(iD);
                }
            });
        } else {
            this.F0.j0(iD + 3);
            this.F0.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.11
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialCalendar.this.F0.m0(iD);
                }
            });
        }
    }
}
