package in.juspay.widget.qrscanner.com.google.zxing;

import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes4.dex */
public interface Writer {
    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3);

    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map);
}
