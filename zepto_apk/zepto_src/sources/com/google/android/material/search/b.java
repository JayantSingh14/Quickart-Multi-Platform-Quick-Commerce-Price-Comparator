package com.google.android.material.search;

import android.view.View;
import com.google.android.material.search.SearchView;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f40939a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f40940b;

    public /* synthetic */ b(SearchView searchView, int i2) {
        this.f40939a = i2;
        this.f40940b = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SearchView searchView = this.f40940b;
        switch (this.f40939a) {
            case 0:
                int i2 = SearchView.D;
                if (!searchView.B.equals(SearchView.TransitionState.f40915b) && !searchView.B.equals(SearchView.TransitionState.f40914a)) {
                    searchView.o.j();
                    break;
                }
                break;
            case 1:
                searchView.f40907j.setText("");
                searchView.k();
                break;
            default:
                int i3 = SearchView.D;
                searchView.m();
                break;
        }
    }
}
