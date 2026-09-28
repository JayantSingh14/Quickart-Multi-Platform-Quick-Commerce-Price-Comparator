package in.juspay.widget.qrscanner.com.google.zxing.common;

import java.util.List;

/* loaded from: classes4.dex */
public final class DecoderResult {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f48877a;

    /* renamed from: b, reason: collision with root package name */
    private int f48878b;

    /* renamed from: c, reason: collision with root package name */
    private final String f48879c;

    /* renamed from: d, reason: collision with root package name */
    private final List<byte[]> f48880d;

    /* renamed from: e, reason: collision with root package name */
    private final String f48881e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f48882f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f48883g;

    /* renamed from: h, reason: collision with root package name */
    private Object f48884h;

    /* renamed from: i, reason: collision with root package name */
    private final int f48885i;

    /* renamed from: j, reason: collision with root package name */
    private final int f48886j;

    /* renamed from: k, reason: collision with root package name */
    private final int f48887k;

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1, 0);
    }

    public List<byte[]> getByteSegments() {
        return this.f48880d;
    }

    public String getECLevel() {
        return this.f48881e;
    }

    public Integer getErasures() {
        return this.f48883g;
    }

    public Integer getErrorsCorrected() {
        return this.f48882f;
    }

    public int getNumBits() {
        return this.f48878b;
    }

    public Object getOther() {
        return this.f48884h;
    }

    public byte[] getRawBytes() {
        return this.f48877a;
    }

    public int getStructuredAppendParity() {
        return this.f48885i;
    }

    public int getStructuredAppendSequenceNumber() {
        return this.f48886j;
    }

    public int getSymbologyModifier() {
        return this.f48887k;
    }

    public String getText() {
        return this.f48879c;
    }

    public boolean hasStructuredAppend() {
        return this.f48885i >= 0 && this.f48886j >= 0;
    }

    public void setErasures(Integer num) {
        this.f48883g = num;
    }

    public void setErrorsCorrected(Integer num) {
        this.f48882f = num;
    }

    public void setNumBits(int i2) {
        this.f48878b = i2;
    }

    public void setOther(Object obj) {
        this.f48884h = obj;
    }

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i2) {
        this(bArr, str, list, str2, -1, -1, i2);
    }

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        this(bArr, str, list, str2, i2, i3, 0);
    }

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3, int i4) {
        this.f48877a = bArr;
        this.f48878b = bArr == null ? 0 : bArr.length * 8;
        this.f48879c = str;
        this.f48880d = list;
        this.f48881e = str2;
        this.f48885i = i3;
        this.f48886j = i2;
        this.f48887k = i4;
    }
}
