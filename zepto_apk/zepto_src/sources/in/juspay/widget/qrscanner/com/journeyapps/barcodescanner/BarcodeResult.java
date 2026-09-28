package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import in.juspay.widget.qrscanner.com.google.zxing.BarcodeFormat;
import in.juspay.widget.qrscanner.com.google.zxing.Result;
import in.juspay.widget.qrscanner.com.google.zxing.ResultMetadataType;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;
import java.util.Map;

/* loaded from: classes4.dex */
public class BarcodeResult {

    /* renamed from: a, reason: collision with root package name */
    protected Result f48989a;

    /* renamed from: b, reason: collision with root package name */
    protected j f48990b;

    public BarcodeResult(Result result, j jVar) {
        this.f48989a = result;
        this.f48990b = jVar;
    }

    private static void a(Canvas canvas, Paint paint, ResultPoint resultPoint, ResultPoint resultPoint2, int i2) {
        if (resultPoint == null || resultPoint2 == null) {
            return;
        }
        float f2 = i2;
        canvas.drawLine(resultPoint.getX() / f2, resultPoint.getY() / f2, resultPoint2.getX() / f2, resultPoint2.getY() / f2, paint);
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.f48989a.getBarcodeFormat();
    }

    public Bitmap getBitmap() {
        return this.f48990b.a(2);
    }

    public int getBitmapScaleFactor() {
        return 2;
    }

    public Bitmap getBitmapWithResultPoints(int i2) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        Bitmap bitmap = getBitmap();
        ResultPoint[] resultPoints = this.f48989a.getResultPoints();
        if (resultPoints == null || resultPoints.length <= 0 || bitmap == null) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(i2);
        if (resultPoints.length == 2) {
            paint.setStrokeWidth(4.0f);
            resultPoint = resultPoints[0];
            resultPoint2 = resultPoints[1];
        } else {
            if (resultPoints.length != 4 || (this.f48989a.getBarcodeFormat() != BarcodeFormat.UPC_A && this.f48989a.getBarcodeFormat() != BarcodeFormat.EAN_13)) {
                paint.setStrokeWidth(10.0f);
                for (ResultPoint resultPoint3 : resultPoints) {
                    if (resultPoint3 != null) {
                        canvas.drawPoint(resultPoint3.getX() / 2.0f, resultPoint3.getY() / 2.0f, paint);
                    }
                }
                return bitmapCreateBitmap;
            }
            a(canvas, paint, resultPoints[0], resultPoints[1], 2);
            resultPoint = resultPoints[2];
            resultPoint2 = resultPoints[3];
        }
        a(canvas, paint, resultPoint, resultPoint2, 2);
        return bitmapCreateBitmap;
    }

    public byte[] getRawBytes() {
        return this.f48989a.getRawBytes();
    }

    public Result getResult() {
        return this.f48989a;
    }

    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.f48989a.getResultMetadata();
    }

    public ResultPoint[] getResultPoints() {
        return this.f48989a.getResultPoints();
    }

    public String getText() {
        return this.f48989a.getText();
    }

    public long getTimestamp() {
        return this.f48989a.getTimestamp();
    }

    public String toString() {
        return this.f48989a.getText();
    }
}
