package com.facebook.react.views.debuggingoverlay;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.UiThread;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class DebuggingOverlay extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f19926a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f19927b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f19928c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f19929d;

    /* renamed from: e, reason: collision with root package name */
    public List f19930e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebuggingOverlay(ThemedReactContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.f19926a = paint;
        this.f19927b = new HashMap();
        this.f19928c = new HashMap();
        Paint paint2 = new Paint();
        this.f19929d = paint2;
        this.f19930e = new ArrayList();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6.0f);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-859248897);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        for (Object obj : this.f19927b.values()) {
            Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
            TraceUpdate traceUpdate = (TraceUpdate) obj;
            Paint paint = this.f19926a;
            paint.setColor(traceUpdate.f19933c);
            canvas.drawRect(traceUpdate.f19932b, paint);
            int i2 = traceUpdate.f19931a;
            b bVar = new b(i2, 1, this);
            HashMap map = this.f19928c;
            if (!map.containsKey(Integer.valueOf(i2))) {
                map.put(Integer.valueOf(i2), bVar);
                UiThreadUtil.runOnUiThread(bVar, 2000L);
            }
        }
        Iterator it = this.f19930e.iterator();
        while (it.hasNext()) {
            canvas.drawRect((RectF) it.next(), this.f19929d);
        }
    }

    @UiThread
    public final void setHighlightedElementsRectangles(@NotNull List<RectF> elementsRectangles) {
        Intrinsics.checkNotNullParameter(elementsRectangles, "elementsRectangles");
        this.f19930e = elementsRectangles;
        invalidate();
    }

    @UiThread
    public final void setTraceUpdates(@NotNull List<TraceUpdate> traceUpdates) {
        Intrinsics.checkNotNullParameter(traceUpdates, "traceUpdates");
        for (TraceUpdate traceUpdate : traceUpdates) {
            int i2 = traceUpdate.f19931a;
            HashMap map = this.f19928c;
            if (map.containsKey(Integer.valueOf(i2))) {
                UiThreadUtil.removeOnUiThread((Runnable) map.get(Integer.valueOf(i2)));
                map.remove(Integer.valueOf(i2));
            }
            this.f19927b.put(Integer.valueOf(i2), traceUpdate);
        }
        invalidate();
    }
}
