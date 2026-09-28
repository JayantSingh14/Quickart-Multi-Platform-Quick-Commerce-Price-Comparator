package in.juspay.widget.qrscanner.com.google.zxing;

import in.juspay.widget.qrscanner.com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes4.dex */
public final class MultiFormatReader implements Reader {

    /* renamed from: a, reason: collision with root package name */
    private Map<DecodeHintType, ?> f48809a;

    /* renamed from: b, reason: collision with root package name */
    private Reader[] f48810b;

    private Result a(BinaryBitmap binaryBitmap) throws NotFoundException {
        Reader[] readerArr = this.f48810b;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                if (Thread.currentThread().isInterrupted()) {
                    throw NotFoundException.getNotFoundInstance();
                }
                try {
                    return reader.decode(binaryBitmap, this.f48809a);
                } catch (ReaderException unused) {
                }
            }
            binaryBitmap.getBlackMatrix().flip();
            for (Reader reader2 : this.f48810b) {
                if (Thread.currentThread().isInterrupted()) {
                    throw NotFoundException.getNotFoundInstance();
                }
                try {
                    return reader2.decode(binaryBitmap, this.f48809a);
                } catch (ReaderException unused2) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) {
        setHints(null);
        return a(binaryBitmap);
    }

    public Result decodeWithState(BinaryBitmap binaryBitmap) {
        if (this.f48810b == null) {
            setHints(null);
        }
        return a(binaryBitmap);
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Reader
    public void reset() {
        Reader[] readerArr = this.f48810b;
        if (readerArr != null) {
            for (Reader reader : readerArr) {
                reader.reset();
            }
        }
    }

    public void setHints(Map<DecodeHintType, ?> map) {
        this.f48809a = map;
        if (map != null) {
            map.containsKey(DecodeHintType.TRY_HARDER);
        }
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null && !collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODABAR) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF) && !collection.contains(BarcodeFormat.RSS_14)) {
            collection.contains(BarcodeFormat.RSS_EXPANDED);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new QRCodeReader());
        }
        this.f48810b = (Reader[]) arrayList.toArray(new Reader[arrayList.size()]);
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        setHints(map);
        return a(binaryBitmap);
    }
}
