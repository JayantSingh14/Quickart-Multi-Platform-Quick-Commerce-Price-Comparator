package in.juspay.widget.qrscanner.com.google.zxing.client.android;

import android.content.Intent;
import in.juspay.widget.qrscanner.com.google.zxing.BarcodeFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class DecodeFormatManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f48845a = Pattern.compile(",");

    /* renamed from: b, reason: collision with root package name */
    static final Set<BarcodeFormat> f48846b;

    /* renamed from: c, reason: collision with root package name */
    static final Set<BarcodeFormat> f48847c;

    /* renamed from: d, reason: collision with root package name */
    private static final Set<BarcodeFormat> f48848d;

    /* renamed from: e, reason: collision with root package name */
    static final Set<BarcodeFormat> f48849e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, Set<BarcodeFormat>> f48850f;

    static {
        EnumSet enumSetOf = EnumSet.of(BarcodeFormat.QR_CODE);
        f48849e = enumSetOf;
        EnumSet.of(BarcodeFormat.DATA_MATRIX);
        EnumSet.of(BarcodeFormat.AZTEC);
        EnumSet.of(BarcodeFormat.PDF_417);
        EnumSet enumSetOf2 = EnumSet.of(BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED);
        f48846b = enumSetOf2;
        EnumSet enumSetOf3 = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        f48847c = enumSetOf3;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) enumSetOf2);
        f48848d = enumSetCopyOf;
        enumSetCopyOf.addAll(enumSetOf3);
        HashMap map = new HashMap();
        f48850f = map;
        map.put("QR_CODE_MODE", enumSetOf);
    }

    private DecodeFormatManager() {
    }

    private static Set<BarcodeFormat> a(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet enumSetNoneOf = EnumSet.noneOf(BarcodeFormat.class);
            try {
                Iterator<String> it = iterable.iterator();
                while (it.hasNext()) {
                    enumSetNoneOf.add(BarcodeFormat.valueOf(it.next()));
                }
                return enumSetNoneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f48850f.get(str);
        }
        return null;
    }

    public static Set<BarcodeFormat> parseDecodeFormats(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return a(stringExtra != null ? Arrays.asList(f48845a.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }
}
