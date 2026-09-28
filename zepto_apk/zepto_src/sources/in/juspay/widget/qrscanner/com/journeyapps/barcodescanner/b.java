package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import in.juspay.widget.qrscanner.com.google.zxing.BinaryBitmap;
import in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource;
import in.juspay.widget.qrscanner.com.google.zxing.MultiFormatReader;
import in.juspay.widget.qrscanner.com.google.zxing.Reader;
import in.juspay.widget.qrscanner.com.google.zxing.Result;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPointCallback;
import in.juspay.widget.qrscanner.com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements ResultPointCallback {

    /* renamed from: a, reason: collision with root package name */
    private Reader f49054a;

    /* renamed from: b, reason: collision with root package name */
    private List<ResultPoint> f49055b = new ArrayList();

    public b(Reader reader) {
        this.f49054a = reader;
    }

    public Result a(BinaryBitmap binaryBitmap) {
        this.f49055b.clear();
        try {
            Reader reader = this.f49054a;
            if (reader instanceof MultiFormatReader) {
                Result resultDecodeWithState = ((MultiFormatReader) reader).decodeWithState(binaryBitmap);
                this.f49054a.reset();
                return resultDecodeWithState;
            }
            Result resultDecode = reader.decode(binaryBitmap);
            this.f49054a.reset();
            return resultDecode;
        } catch (Exception unused) {
            this.f49054a.reset();
            return null;
        } catch (Throwable th) {
            this.f49054a.reset();
            throw th;
        }
    }

    public BinaryBitmap b(LuminanceSource luminanceSource) {
        return new BinaryBitmap(new HybridBinarizer(luminanceSource));
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.f49055b.add(resultPoint);
    }

    public Result a(LuminanceSource luminanceSource) {
        return a(b(luminanceSource));
    }

    public List<ResultPoint> a() {
        return new ArrayList(this.f49055b);
    }
}
