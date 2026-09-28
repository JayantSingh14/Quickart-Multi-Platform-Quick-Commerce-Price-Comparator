package com.swmansion.rnscreens;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class SearchViewFormatter {

    /* renamed from: a, reason: collision with root package name */
    public final CustomSearchView f47081a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f47082b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f47083c;

    public SearchViewFormatter(CustomSearchView searchView) {
        Intrinsics.checkNotNullParameter(searchView, "searchView");
        this.f47081a = searchView;
    }

    public final EditText a() {
        View viewFindViewById = this.f47081a.findViewById(androidx.appcompat.R.id.search_src_text);
        if (viewFindViewById instanceof EditText) {
            return (EditText) viewFindViewById;
        }
        return null;
    }

    public final void b(Integer num) {
        if (num != null) {
            int iIntValue = num.intValue();
            int i2 = androidx.appcompat.R.id.search_button;
            CustomSearchView customSearchView = this.f47081a;
            ((ImageView) customSearchView.findViewById(i2)).setColorFilter(iIntValue);
            ((ImageView) customSearchView.findViewById(androidx.appcompat.R.id.search_close_btn)).setColorFilter(iIntValue);
        }
    }

    public final void c(Integer num) {
        if (num != null) {
            int iIntValue = num.intValue();
            EditText editTextA = a();
            if (editTextA != null) {
                editTextA.setHintTextColor(iIntValue);
            }
        }
    }

    public final void d(String placeholder, boolean z) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        if (z) {
            this.f47081a.setQueryHint(placeholder);
            return;
        }
        EditText editTextA = a();
        if (editTextA != null) {
            editTextA.setHint(placeholder);
        }
    }

    public final void e(Integer num) {
        EditText editTextA;
        ColorStateList textColors;
        Integer num2 = this.f47082b;
        if (num == null) {
            if (num2 == null || (editTextA = a()) == null) {
                return;
            }
            editTextA.setTextColor(num2.intValue());
            return;
        }
        if (num2 == null) {
            EditText editTextA2 = a();
            this.f47082b = (editTextA2 == null || (textColors = editTextA2.getTextColors()) == null) ? null : Integer.valueOf(textColors.getDefaultColor());
        }
        EditText editTextA3 = a();
        if (editTextA3 != null) {
            editTextA3.setTextColor(num.intValue());
        }
    }

    public final void f(Integer num) {
        Drawable drawable = this.f47083c;
        if (num != null) {
            if (drawable == null) {
                this.f47083c = this.f47081a.findViewById(androidx.appcompat.R.id.search_plate).getBackground();
            }
            this.f47081a.findViewById(androidx.appcompat.R.id.search_plate).setBackgroundColor(num.intValue());
        } else if (drawable != null) {
            this.f47081a.findViewById(androidx.appcompat.R.id.search_plate).setBackground(drawable);
        }
    }
}
