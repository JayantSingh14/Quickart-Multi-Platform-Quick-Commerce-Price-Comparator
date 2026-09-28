package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.ViewUtils;
import com.swmansion.rnscreens.SearchBarView;
import com.swmansion.rnscreens.events.SearchBarBlurEvent;
import com.swmansion.rnscreens.events.SearchBarFocusEvent;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f40391a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f40392b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f40391a = i2;
        this.f40392b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.f40391a) {
            case 0:
                for (EditText editText : (EditText[]) this.f40392b) {
                    if (editText.hasFocus()) {
                        break;
                    }
                }
                ViewUtils.g(view, false);
                break;
            default:
                SearchBarView searchBarView = (SearchBarView) this.f40392b;
                int i2 = searchBarView.f47067m;
                searchBarView.q(z ? new SearchBarFocusEvent(i2, searchBarView.getId()) : new SearchBarBlurEvent(i2, searchBarView.getId()));
                break;
        }
    }
}
