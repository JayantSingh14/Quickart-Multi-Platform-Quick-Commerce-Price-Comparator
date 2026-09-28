package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class PathView extends RenderableView {

    /* renamed from: a, reason: collision with root package name */
    public Path f45808a;

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final Path getPath(Canvas canvas, Paint paint) {
        return this.f45808a;
    }
}
