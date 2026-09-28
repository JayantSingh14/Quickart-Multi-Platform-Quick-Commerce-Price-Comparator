package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.bottomappbar.BottomAppBar;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3211a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3212b;

    public /* synthetic */ d(int i2, View view) {
        this.f3211a = i2;
        this.f3212b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.f3212b;
        switch (this.f3211a) {
            case 0:
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                break;
            case 1:
                int i2 = BottomAppBar.d1;
                view.requestLayout();
                break;
            default:
                ((InputMethodManager) view.getContext().getSystemService(InputMethodManager.class)).showSoftInput(view, 1);
                break;
        }
    }
}
