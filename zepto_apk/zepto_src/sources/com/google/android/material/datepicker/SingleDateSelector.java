package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import java.util.ArrayList;
import java.util.Locale;

@RestrictTo
/* loaded from: classes4.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new AnonymousClass2();

    /* renamed from: a, reason: collision with root package name */
    public Long f40379a;

    /* renamed from: com.google.android.material.datepicker.SingleDateSelector$2, reason: invalid class name */
    public class AnonymousClass2 implements Parcelable.Creator<SingleDateSelector> {
        @Override // android.os.Parcelable.Creator
        public final SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f40379a = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        public final SingleDateSelector[] newArray(int i2) {
            return new SingleDateSelector[i2];
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Object R6() {
        return this.f40379a;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList d4() {
        return new ArrayList();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String j1(Context context) {
        Resources resources = context.getResources();
        Long l2 = this.f40379a;
        return resources.getString(R.string.mtrl_picker_announce_current_selection, l2 == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : DateStrings.d(l2.longValue(), Locale.getDefault()));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    @Override // com.google.android.material.datepicker.DateSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View j7(android.view.LayoutInflater r9, android.view.ViewGroup r10, com.google.android.material.datepicker.CalendarConstraints r11, final com.google.android.material.datepicker.OnSelectionChangedListener r12) throws android.content.res.Resources.NotFoundException {
        /*
            r8 = this;
            int r0 = com.google.android.material.R.layout.mtrl_picker_text_input_date
            r1 = 0
            android.view.View r9 = r9.inflate(r0, r10, r1)
            int r10 = com.google.android.material.R.id.mtrl_picker_text_input_date
            android.view.View r10 = r9.findViewById(r10)
            r4 = r10
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            android.widget.EditText r10 = r4.getEditText()
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r1 = ""
            if (r0 == 0) goto L21
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r2 = r0.toLowerCase(r2)
            goto L22
        L21:
            r2 = r1
        L22:
            java.lang.String r3 = "lge"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L3a
            if (r0 == 0) goto L32
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r0.toLowerCase(r1)
        L32:
            java.lang.String r0 = "samsung"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3f
        L3a:
            r0 = 17
            r10.setInputType(r0)
        L3f:
            java.text.SimpleDateFormat r3 = com.google.android.material.datepicker.UtcDates.d()
            android.content.res.Resources r0 = r9.getResources()
            java.lang.String r2 = com.google.android.material.datepicker.UtcDates.e(r0, r3)
            r4.setPlaceholderText(r2)
            java.lang.Long r0 = r8.f40379a
            if (r0 == 0) goto L59
            java.lang.String r0 = r3.format(r0)
            r10.setText(r0)
        L59:
            com.google.android.material.datepicker.SingleDateSelector$1 r0 = new com.google.android.material.datepicker.SingleDateSelector$1
            r7 = r4
            r1 = r8
            r5 = r11
            r6 = r12
            r0.<init>(r2, r3, r4, r5)
            r10.addTextChangedListener(r0)
            android.widget.EditText[] r10 = new android.widget.EditText[]{r10}
            com.google.android.material.datepicker.DateSelector.i5(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.SingleDateSelector.j7(android.view.LayoutInflater, android.view.ViewGroup, com.google.android.material.datepicker.CalendarConstraints, com.google.android.material.datepicker.OnSelectionChangedListener):android.view.View");
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList p6() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.f40379a;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int w1(Context context) {
        return MaterialAttributes.c(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName()).data;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void w8(long j2) {
        this.f40379a = Long.valueOf(j2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f40379a);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String y3(Context context) {
        Resources resources = context.getResources();
        Long l2 = this.f40379a;
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, DateStrings.d(l2.longValue(), Locale.getDefault()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean y5() {
        return this.f40379a != null;
    }
}
