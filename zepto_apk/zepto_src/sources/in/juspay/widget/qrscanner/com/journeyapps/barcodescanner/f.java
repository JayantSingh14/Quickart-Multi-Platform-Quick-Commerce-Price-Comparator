package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import in.juspay.widget.qrscanner.com.google.zxing.BarcodeFormat;
import in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.MultiFormatReader;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name */
    private Collection<BarcodeFormat> f49070a;

    /* renamed from: b, reason: collision with root package name */
    private Map<DecodeHintType, ?> f49071b;

    /* renamed from: c, reason: collision with root package name */
    private String f49072c;

    public f() {
    }

    @Override // in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.c
    public b a(Map<DecodeHintType, ?> map) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map<DecodeHintType, ?> map2 = this.f49071b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection<BarcodeFormat> collection = this.f49070a;
        if (collection != null) {
            enumMap.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, (DecodeHintType) collection);
        }
        String str = this.f49072c;
        if (str != null) {
            enumMap.put((EnumMap) DecodeHintType.CHARACTER_SET, (DecodeHintType) str);
        }
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        multiFormatReader.setHints(enumMap);
        return new b(multiFormatReader);
    }

    public f(Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str) {
        this.f49070a = collection;
        this.f49071b = map;
        this.f49072c = str;
    }
}
