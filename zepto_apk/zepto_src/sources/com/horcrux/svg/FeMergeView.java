package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.react.bridge.ReadableArray;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class FeMergeView extends FilterPrimitiveView {

    /* renamed from: c, reason: collision with root package name */
    public ReadableArray f45683c;

    @Override // com.horcrux.svg.FilterPrimitiveView
    public final Bitmap j(HashMap map, Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int size = this.f45683c.size();
        for (int i2 = 0; i2 < size; i2++) {
            String string = this.f45683c.getString(i2);
            Bitmap bitmap2 = string.isEmpty() ? bitmap : (Bitmap) map.get(string);
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, new Paint());
            }
        }
        return bitmapCreateBitmap;
    }
}
