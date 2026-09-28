package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Nullsafe
/* loaded from: classes.dex */
public class ViewGroupDrawingOrderHelper {

    /* renamed from: a, reason: collision with root package name */
    public final ReactViewGroup f19594a;

    /* renamed from: b, reason: collision with root package name */
    public int f19595b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int[] f19596c;

    /* renamed from: com.facebook.react.uimanager.ViewGroupDrawingOrderHelper$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View view, View view2) {
            View view3 = view2;
            Integer viewZIndex = ViewGroupManager.getViewZIndex(view);
            if (viewZIndex == null) {
                viewZIndex = num;
            }
            Integer viewZIndex2 = ViewGroupManager.getViewZIndex(view3);
            return viewZIndex.intValue() - (viewZIndex2 != null ? viewZIndex2 : 0).intValue();
        }
    }

    public ViewGroupDrawingOrderHelper(ReactViewGroup reactViewGroup) {
        this.f19594a = reactViewGroup;
    }

    public final int a(int i2, int i3) {
        ReactViewGroup reactViewGroup;
        int[] iArr = this.f19596c;
        if (iArr != null && (i3 >= iArr.length || iArr[i3] >= i2)) {
            FLog.s("ReactNative", "getChildDrawingOrder index out of bounds! Please check any custom view manipulations you may have done. childCount = %d, index = %d", Integer.valueOf(i2), Integer.valueOf(i3));
            b();
        }
        if (this.f19596c == null) {
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            while (true) {
                reactViewGroup = this.f19594a;
                if (i4 >= i2) {
                    break;
                }
                arrayList.add(reactViewGroup.getChildAt(i4));
                i4++;
            }
            Collections.sort(arrayList, new AnonymousClass1());
            this.f19596c = new int[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                this.f19596c[i5] = reactViewGroup.indexOfChild((View) arrayList.get(i5));
            }
        }
        return this.f19596c[i3];
    }

    public final void b() {
        int i2 = 0;
        this.f19595b = 0;
        while (true) {
            ReactViewGroup reactViewGroup = this.f19594a;
            if (i2 >= reactViewGroup.getChildCount()) {
                this.f19596c = null;
                return;
            } else {
                if (ViewGroupManager.getViewZIndex(reactViewGroup.getChildAt(i2)) != null) {
                    this.f19595b++;
                }
                i2++;
            }
        }
    }
}
