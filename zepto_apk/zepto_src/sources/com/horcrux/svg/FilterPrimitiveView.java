package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class FilterPrimitiveView extends DefinitionView {

    /* renamed from: a, reason: collision with root package name */
    public String f45687a;

    /* renamed from: b, reason: collision with root package name */
    public final FilterRegion f45688b;

    public FilterPrimitiveView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f45688b = new FilterRegion();
    }

    public static Bitmap k(HashMap map, Bitmap bitmap, String str) {
        Bitmap bitmap2 = str != null ? (Bitmap) map.get(str) : null;
        return bitmap2 != null ? bitmap2 : bitmap;
    }

    public Bitmap j(HashMap map, Bitmap bitmap) {
        return null;
    }

    @Override // com.horcrux.svg.VirtualView
    public final void saveDefinition() {
    }
}
