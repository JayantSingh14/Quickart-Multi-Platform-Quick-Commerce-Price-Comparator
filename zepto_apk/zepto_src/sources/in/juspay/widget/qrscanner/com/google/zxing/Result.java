package in.juspay.widget.qrscanner.com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class Result {

    /* renamed from: a, reason: collision with root package name */
    private final String f48824a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f48825b;

    /* renamed from: c, reason: collision with root package name */
    private final int f48826c;

    /* renamed from: d, reason: collision with root package name */
    private ResultPoint[] f48827d;

    /* renamed from: e, reason: collision with root package name */
    private final BarcodeFormat f48828e;

    /* renamed from: f, reason: collision with root package name */
    private Map<ResultMetadataType, Object> f48829f;

    /* renamed from: g, reason: collision with root package name */
    private final long f48830g;

    public Result(String str, byte[] bArr, int i2, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j2) {
        this.f48824a = str;
        this.f48825b = bArr;
        this.f48826c = i2;
        this.f48827d = resultPointArr;
        this.f48828e = barcodeFormat;
        this.f48829f = null;
        this.f48830g = j2;
    }

    public void addResultPoints(ResultPoint[] resultPointArr) {
        ResultPoint[] resultPointArr2 = this.f48827d;
        if (resultPointArr2 == null) {
            this.f48827d = resultPointArr;
            return;
        }
        if (resultPointArr == null || resultPointArr.length <= 0) {
            return;
        }
        ResultPoint[] resultPointArr3 = new ResultPoint[resultPointArr2.length + resultPointArr.length];
        System.arraycopy(resultPointArr2, 0, resultPointArr3, 0, resultPointArr2.length);
        System.arraycopy(resultPointArr, 0, resultPointArr3, resultPointArr2.length, resultPointArr.length);
        this.f48827d = resultPointArr3;
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.f48828e;
    }

    public int getNumBits() {
        return this.f48826c;
    }

    public byte[] getRawBytes() {
        return this.f48825b;
    }

    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.f48829f;
    }

    public ResultPoint[] getResultPoints() {
        return this.f48827d;
    }

    public String getText() {
        return this.f48824a;
    }

    public long getTimestamp() {
        return this.f48830g;
    }

    public void putAllMetadata(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f48829f;
            if (map2 == null) {
                this.f48829f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void putMetadata(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f48829f == null) {
            this.f48829f = new EnumMap(ResultMetadataType.class);
        }
        this.f48829f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f48824a;
    }

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, resultPointArr, barcodeFormat, System.currentTimeMillis());
    }

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j2) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, resultPointArr, barcodeFormat, j2);
    }
}
