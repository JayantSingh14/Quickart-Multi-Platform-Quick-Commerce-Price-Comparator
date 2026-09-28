package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.xbill.DNS.WKSRecord;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class FeFloodView extends FilterPrimitiveView {

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f45677e = Pattern.compile("[0-9.-]+");

    /* renamed from: c, reason: collision with root package name */
    public ReadableArray f45678c;

    /* renamed from: d, reason: collision with root package name */
    public float f45679d;

    @Override // com.horcrux.svg.FilterPrimitiveView
    public final Bitmap j(HashMap map, Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setFlags(WKSRecord.Service.PWDGEN);
        paint.setStyle(Paint.Style.FILL);
        float f2 = this.f45679d;
        ReadableArray readableArray = this.f45678c;
        if (readableArray.getInt(0) == 0) {
            if (readableArray.size() == 2) {
                paint.setColor((Math.round((r2 >>> 24) * f2) << 24) | ((readableArray.getType(1) == ReadableType.Map ? ColorPropConverter.getColor(readableArray.getMap(1), getContext()).intValue() : readableArray.getInt(1)) & 16777215));
            } else {
                paint.setARGB((int) (readableArray.size() > 4 ? readableArray.getDouble(4) * f2 * 255.0d : f2 * 255.0f), (int) (readableArray.getDouble(1) * 255.0d), (int) (readableArray.getDouble(2) * 255.0d), (int) (readableArray.getDouble(3) * 255.0d));
            }
        }
        canvas.drawPaint(paint);
        return bitmapCreateBitmap;
    }

    public final void l(ReadableMap readableMap) {
        if (readableMap == null) {
            this.f45678c = null;
            invalidate();
            return;
        }
        int i2 = readableMap.getInt("type");
        if (i2 == 0) {
            ReadableType type = readableMap.getType(PaymentConstants.PAYLOAD);
            if (type.equals(ReadableType.Number)) {
                this.f45678c = JavaOnlyArray.of(0, Integer.valueOf(readableMap.getInt(PaymentConstants.PAYLOAD)));
            } else if (type.equals(ReadableType.Map)) {
                this.f45678c = JavaOnlyArray.of(0, readableMap.getMap(PaymentConstants.PAYLOAD));
            }
        } else if (i2 == 1) {
            this.f45678c = JavaOnlyArray.of(1, readableMap.getString("brushRef"));
        } else {
            this.f45678c = JavaOnlyArray.of(Integer.valueOf(i2));
        }
        invalidate();
    }
}
