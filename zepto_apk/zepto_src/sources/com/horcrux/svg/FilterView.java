package com.horcrux.svg;

import android.annotation.SuppressLint;
import com.facebook.react.uimanager.ThemedReactContext;
import com.horcrux.svg.FilterProperties;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class FilterView extends DefinitionView {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f45708a;

    /* renamed from: b, reason: collision with root package name */
    public FilterProperties.Units f45709b;

    /* renamed from: c, reason: collision with root package name */
    public FilterProperties.Units f45710c;

    /* renamed from: d, reason: collision with root package name */
    public final FilterRegion f45711d;

    public FilterView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f45708a = new HashMap();
        this.f45711d = new FilterRegion();
    }

    @Override // com.horcrux.svg.VirtualView
    public final void saveDefinition() {
        SvgView svgView;
        if (this.mName == null || (svgView = getSvgView()) == null) {
            return;
        }
        svgView.defineFilter(this, this.mName);
    }
}
