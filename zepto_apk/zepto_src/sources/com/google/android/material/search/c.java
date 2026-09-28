package com.google.android.material.search;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.android.material.internal.ViewUtils;

/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f40941a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f40942b;

    public /* synthetic */ c(SearchView searchView, int i2) {
        this.f40941a = i2;
        this.f40942b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowInsetsControllerCompat windowInsetsControllerCompatP;
        switch (this.f40941a) {
            case 0:
                SearchView searchView = this.f40942b;
                EditText editText = searchView.f40907j;
                editText.clearFocus();
                SearchBar searchBar = searchView.t;
                if (searchBar != null) {
                    searchBar.requestFocus();
                }
                ViewUtils.g(editText, searchView.z);
                break;
            case 1:
                SearchView searchView2 = this.f40942b;
                EditText editText2 = searchView2.f40907j;
                if (editText2.requestFocus()) {
                    editText2.sendAccessibilityEvent(8);
                }
                if (searchView2.z && (windowInsetsControllerCompatP = ViewCompat.p(editText2)) != null) {
                    windowInsetsControllerCompatP.g(8);
                    break;
                } else {
                    ((InputMethodManager) editText2.getContext().getSystemService(InputMethodManager.class)).showSoftInput(editText2, 1);
                    break;
                }
                break;
            case 2:
                this.f40942b.m();
                break;
            default:
                this.f40942b.k();
                break;
        }
    }
}
