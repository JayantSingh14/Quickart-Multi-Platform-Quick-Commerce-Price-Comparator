package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
abstract class DateFormatTextWatcher extends TextWatcherAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f40303a;

    /* renamed from: b, reason: collision with root package name */
    public final String f40304b;

    /* renamed from: c, reason: collision with root package name */
    public final SimpleDateFormat f40305c;

    /* renamed from: d, reason: collision with root package name */
    public final CalendarConstraints f40306d;

    /* renamed from: e, reason: collision with root package name */
    public final String f40307e;

    /* renamed from: f, reason: collision with root package name */
    public final a f40308f;

    /* renamed from: g, reason: collision with root package name */
    public b f40309g;

    /* renamed from: h, reason: collision with root package name */
    public int f40310h = 0;

    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.android.material.datepicker.a] */
    public DateFormatTextWatcher(final String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f40304b = str;
        this.f40305c = simpleDateFormat;
        this.f40303a = textInputLayout;
        this.f40306d = calendarConstraints;
        this.f40307e = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f40308f = new Runnable() { // from class: com.google.android.material.datepicker.a
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                DateFormatTextWatcher dateFormatTextWatcher = this.f40387a;
                TextInputLayout textInputLayout2 = dateFormatTextWatcher.f40303a;
                Context context = textInputLayout2.getContext();
                textInputLayout2.setError(context.getString(R.string.mtrl_picker_invalid_format) + StringUtils.LF + String.format(context.getString(R.string.mtrl_picker_invalid_format_use), str.replace(' ', (char) 160)) + StringUtils.LF + String.format(context.getString(R.string.mtrl_picker_invalid_format_example), dateFormatTextWatcher.f40305c.format(new Date(UtcDates.f().getTimeInMillis())).replace(' ', (char) 160)));
                dateFormatTextWatcher.a();
            }
        };
    }

    public void a() {
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) || editable.length() == 0) {
            return;
        }
        int length = editable.length();
        String str = this.f40304b;
        if (length >= str.length() || editable.length() < this.f40310h) {
            return;
        }
        char cCharAt = str.charAt(editable.length());
        if (Character.isLetterOrDigit(cCharAt)) {
            return;
        }
        editable.append(cCharAt);
    }

    public abstract void b(Long l2);

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f40310h = charSequence.length();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [com.google.android.material.datepicker.b, java.lang.Runnable] */
    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) throws Resources.NotFoundException, ParseException {
        CalendarConstraints calendarConstraints = this.f40306d;
        TextInputLayout textInputLayout = this.f40303a;
        a aVar = this.f40308f;
        textInputLayout.removeCallbacks(aVar);
        textInputLayout.removeCallbacks(this.f40309g);
        textInputLayout.setError(null);
        b(null);
        if (TextUtils.isEmpty(charSequence) || charSequence.length() < this.f40304b.length()) {
            return;
        }
        try {
            Date date = this.f40305c.parse(charSequence.toString());
            textInputLayout.setError(null);
            final long time = date.getTime();
            if (calendarConstraints.f40277c.V2(time)) {
                Calendar calendarC = UtcDates.c(calendarConstraints.f40275a.f40344a);
                calendarC.set(5, 1);
                if (calendarC.getTimeInMillis() <= time) {
                    Month month = calendarConstraints.f40276b;
                    int i5 = month.f40348e;
                    Calendar calendarC2 = UtcDates.c(month.f40344a);
                    calendarC2.set(5, i5);
                    if (time <= calendarC2.getTimeInMillis()) {
                        b(Long.valueOf(date.getTime()));
                        return;
                    }
                }
            }
            ?? r7 = new Runnable() { // from class: com.google.android.material.datepicker.b
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    DateFormatTextWatcher dateFormatTextWatcher = this.f40389a;
                    dateFormatTextWatcher.f40303a.setError(String.format(dateFormatTextWatcher.f40307e, DateStrings.b(time).replace(' ', (char) 160)));
                    dateFormatTextWatcher.a();
                }
            };
            this.f40309g = r7;
            textInputLayout.post(r7);
        } catch (ParseException unused) {
            textInputLayout.post(aVar);
        }
    }
}
