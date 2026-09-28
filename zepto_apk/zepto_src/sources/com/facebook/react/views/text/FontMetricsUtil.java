package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FontMetricsUtil {
    public static final WritableArray a(CharSequence text, Layout layout, TextPaint paint, Context context) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize(textPaint.getTextSize() * 100.0f);
        int i2 = 0;
        int i3 = 1;
        textPaint.getTextBounds("T", 0, 1, new Rect());
        float fHeight = (r2.height() / 100.0f) / displayMetrics.density;
        textPaint.getTextBounds("x", 0, 1, new Rect());
        float fHeight2 = (r8.height() / 100.0f) / displayMetrics.density;
        int lineCount = layout.getLineCount();
        while (i2 < lineCount) {
            float lineWidth = (text.length() <= 0 || text.charAt(layout.getLineEnd(i2) - i3) != '\n') ? layout.getLineWidth(i2) : layout.getLineMax(i2);
            layout.getLineBounds(i2, new Rect());
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("x", layout.getLineLeft(i2) / displayMetrics.density);
            writableMapCreateMap.putDouble("y", r12.top / displayMetrics.density);
            writableMapCreateMap.putDouble(Snapshot.WIDTH, lineWidth / displayMetrics.density);
            writableMapCreateMap.putDouble(Snapshot.HEIGHT, r12.height() / displayMetrics.density);
            writableMapCreateMap.putDouble("descender", layout.getLineDescent(i2) / displayMetrics.density);
            writableMapCreateMap.putDouble("ascender", (-layout.getLineAscent(i2)) / displayMetrics.density);
            writableMapCreateMap.putDouble("baseline", layout.getLineBaseline(i2) / displayMetrics.density);
            writableMapCreateMap.putDouble("capHeight", fHeight);
            writableMapCreateMap.putDouble("xHeight", fHeight2);
            writableMapCreateMap.putString("text", text.subSequence(layout.getLineStart(i2), layout.getLineEnd(i2)).toString());
            writableArrayCreateArray.pushMap(writableMapCreateMap);
            i2++;
            i3 = 1;
        }
        Intrinsics.c(writableArrayCreateArray);
        return writableArrayCreateArray;
    }
}
