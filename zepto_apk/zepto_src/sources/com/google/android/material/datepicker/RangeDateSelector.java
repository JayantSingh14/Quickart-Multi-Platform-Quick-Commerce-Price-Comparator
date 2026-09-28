package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

@RestrictTo
/* loaded from: classes4.dex */
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new AnonymousClass3();

    /* renamed from: a, reason: collision with root package name */
    public String f40366a;

    /* renamed from: b, reason: collision with root package name */
    public Long f40367b = null;

    /* renamed from: c, reason: collision with root package name */
    public Long f40368c = null;

    /* renamed from: d, reason: collision with root package name */
    public Long f40369d = null;

    /* renamed from: e, reason: collision with root package name */
    public Long f40370e = null;

    /* renamed from: com.google.android.material.datepicker.RangeDateSelector$3, reason: invalid class name */
    public class AnonymousClass3 implements Parcelable.Creator<RangeDateSelector> {
        @Override // android.os.Parcelable.Creator
        public final RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f40367b = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f40368c = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        public final RangeDateSelector[] newArray(int i2) {
            return new RangeDateSelector[i2];
        }
    }

    public static void a(RangeDateSelector rangeDateSelector, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, OnSelectionChangedListener onSelectionChangedListener) throws Resources.NotFoundException {
        Long l2 = rangeDateSelector.f40369d;
        if (l2 == null || rangeDateSelector.f40370e == null) {
            if (textInputLayout.getError() != null && rangeDateSelector.f40366a.contentEquals(textInputLayout.getError())) {
                textInputLayout.setError(null);
            }
            if (textInputLayout2.getError() != null && StringUtils.SPACE.contentEquals(textInputLayout2.getError())) {
                textInputLayout2.setError(null);
            }
            onSelectionChangedListener.a();
        } else if (l2.longValue() <= rangeDateSelector.f40370e.longValue()) {
            Long l3 = rangeDateSelector.f40369d;
            rangeDateSelector.f40367b = l3;
            Long l4 = rangeDateSelector.f40370e;
            rangeDateSelector.f40368c = l4;
            onSelectionChangedListener.b(new Pair(l3, l4));
        } else {
            textInputLayout.setError(rangeDateSelector.f40366a);
            textInputLayout2.setError(StringUtils.SPACE);
            onSelectionChangedListener.a();
        }
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            textInputLayout.getError();
        } else {
            if (TextUtils.isEmpty(textInputLayout2.getError())) {
                return;
            }
            textInputLayout2.getError();
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Object R6() {
        return new Pair(this.f40367b, this.f40368c);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList d4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.f40367b, this.f40368c));
        return arrayList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.material.datepicker.DateSelector
    public final String j1(Context context) {
        Resources resources = context.getResources();
        Pair pairA = DateStrings.a(this.f40367b, this.f40368c);
        F f2 = pairA.f2989a;
        String string = f2 == 0 ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : (String) f2;
        S s = pairA.f2990b;
        return resources.getString(R.string.mtrl_picker_announce_current_range_selection, string, s == 0 ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : (String) s);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    @Override // com.google.android.material.datepicker.DateSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View j7(android.view.LayoutInflater r11, android.view.ViewGroup r12, com.google.android.material.datepicker.CalendarConstraints r13, final com.google.android.material.datepicker.OnSelectionChangedListener r14) throws android.content.res.Resources.NotFoundException {
        /*
            r10 = this;
            int r0 = com.google.android.material.R.layout.mtrl_picker_text_input_date_range
            r1 = 0
            android.view.View r11 = r11.inflate(r0, r12, r1)
            int r12 = com.google.android.material.R.id.mtrl_picker_text_input_range_start
            android.view.View r12 = r11.findViewById(r12)
            r4 = r12
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            int r12 = com.google.android.material.R.id.mtrl_picker_text_input_range_end
            android.view.View r12 = r11.findViewById(r12)
            r7 = r12
            com.google.android.material.textfield.TextInputLayout r7 = (com.google.android.material.textfield.TextInputLayout) r7
            android.widget.EditText r12 = r4.getEditText()
            android.widget.EditText r9 = r7.getEditText()
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = ""
            if (r0 == 0) goto L2e
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r2 = r0.toLowerCase(r2)
            goto L2f
        L2e:
            r2 = r1
        L2f:
            java.lang.String r3 = "lge"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L47
            if (r0 == 0) goto L3f
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r0.toLowerCase(r1)
        L3f:
            java.lang.String r0 = "samsung"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L4f
        L47:
            r0 = 17
            r12.setInputType(r0)
            r9.setInputType(r0)
        L4f:
            android.content.res.Resources r0 = r11.getResources()
            int r1 = com.google.android.material.R.string.mtrl_picker_invalid_range
            java.lang.String r0 = r0.getString(r1)
            r10.f40366a = r0
            java.text.SimpleDateFormat r3 = com.google.android.material.datepicker.UtcDates.d()
            java.lang.Long r0 = r10.f40367b
            if (r0 == 0) goto L6e
            java.lang.String r0 = r3.format(r0)
            r12.setText(r0)
            java.lang.Long r0 = r10.f40367b
            r10.f40369d = r0
        L6e:
            java.lang.Long r0 = r10.f40368c
            if (r0 == 0) goto L7d
            java.lang.String r0 = r3.format(r0)
            r9.setText(r0)
            java.lang.Long r0 = r10.f40368c
            r10.f40370e = r0
        L7d:
            android.content.res.Resources r0 = r11.getResources()
            java.lang.String r2 = com.google.android.material.datepicker.UtcDates.e(r0, r3)
            r4.setPlaceholderText(r2)
            r7.setPlaceholderText(r2)
            com.google.android.material.datepicker.RangeDateSelector$1 r0 = new com.google.android.material.datepicker.RangeDateSelector$1
            r6 = r4
            r1 = r10
            r5 = r13
            r8 = r14
            r0.<init>(r2, r3, r4, r5)
            r12.addTextChangedListener(r0)
            com.google.android.material.datepicker.RangeDateSelector$2 r0 = new com.google.android.material.datepicker.RangeDateSelector$2
            r4 = r7
            r0.<init>(r2, r3, r4, r5)
            r9.addTextChangedListener(r0)
            android.widget.EditText[] r12 = new android.widget.EditText[]{r12, r9}
            com.google.android.material.datepicker.DateSelector.i5(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.RangeDateSelector.j7(android.view.LayoutInflater, android.view.ViewGroup, com.google.android.material.datepicker.CalendarConstraints, com.google.android.material.datepicker.OnSelectionChangedListener):android.view.View");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList p6() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.f40367b;
        if (l2 != null) {
            arrayList.add(l2);
        }
        Long l3 = this.f40368c;
        if (l3 != null) {
            arrayList.add(l3);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int w1(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return MaterialAttributes.c(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName()).data;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void w8(long j2) {
        Long l2 = this.f40367b;
        if (l2 == null) {
            this.f40367b = Long.valueOf(j2);
        } else if (this.f40368c == null && l2.longValue() <= j2) {
            this.f40368c = Long.valueOf(j2);
        } else {
            this.f40368c = null;
            this.f40367b = Long.valueOf(j2);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f40367b);
        parcel.writeValue(this.f40368c);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String y3(Context context) {
        Resources resources = context.getResources();
        Long l2 = this.f40367b;
        if (l2 == null && this.f40368c == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l3 = this.f40368c;
        if (l3 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, DateStrings.b(l2.longValue()));
        }
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, DateStrings.b(l3.longValue()));
        }
        Pair pairA = DateStrings.a(l2, l3);
        return resources.getString(R.string.mtrl_picker_range_header_selected, pairA.f2989a, pairA.f2990b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean y5() {
        Long l2 = this.f40367b;
        return (l2 == null || this.f40368c == null || l2.longValue() > this.f40368c.longValue()) ? false : true;
    }
}
