package com.facebook.react.uimanager;

import android.graphics.Color;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.views.debuggingoverlay.DebuggingOverlay;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19624a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19625b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19626c;

    public /* synthetic */ b(int i2, int i3, Object obj) {
        this.f19624a = i3;
        this.f19626c = obj;
        this.f19625b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19624a) {
            case 0:
                Iterator it = ((ArrayList) this.f19626c).iterator();
                while (it.hasNext()) {
                    ((ViewManager) it.next()).onSurfaceStopped(this.f19625b);
                }
                break;
            case 1:
                DebuggingOverlay debuggingOverlay = (DebuggingOverlay) this.f19626c;
                HashMap map = debuggingOverlay.f19927b;
                int i2 = this.f19625b;
                map.remove(Integer.valueOf(i2));
                debuggingOverlay.f19928c.remove(Integer.valueOf(i2));
                debuggingOverlay.invalidate();
                break;
            case 2:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f19626c;
                View view = (View) sideSheetBehavior.p.get();
                if (view != null) {
                    sideSheetBehavior.A(this.f19625b, view, false);
                    break;
                }
                break;
            default:
                Window window = (Window) this.f19626c;
                WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
                int i3 = this.f19625b;
                windowInsetsControllerCompat.d(((double) 1) - (((((double) Color.blue(i3)) * 0.114d) + ((((double) Color.green(i3)) * 0.587d) + (((double) Color.red(i3)) * 0.299d))) / ((double) 255)) < 0.5d);
                break;
        }
    }
}
