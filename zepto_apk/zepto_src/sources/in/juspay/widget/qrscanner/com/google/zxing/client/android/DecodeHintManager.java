package in.juspay.widget.qrscanner.com.google.zxing.client.android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class DecodeHintManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f48851a = "DecodeHintManager";

    static {
        Pattern.compile(",");
    }

    private DecodeHintManager() {
    }

    public static Map<DecodeHintType, Object> parseDecodeHints(Intent intent) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        for (DecodeHintType decodeHintType : DecodeHintType.values()) {
            if (decodeHintType != DecodeHintType.CHARACTER_SET && decodeHintType != DecodeHintType.NEED_RESULT_POINT_CALLBACK && decodeHintType != DecodeHintType.POSSIBLE_FORMATS) {
                String strName = decodeHintType.name();
                if (extras.containsKey(strName)) {
                    if (decodeHintType.getValueType().equals(Void.class)) {
                        obj = Boolean.TRUE;
                    } else {
                        obj = extras.get(strName);
                        if (!decodeHintType.getValueType().isInstance(obj)) {
                            Log.w(f48851a, "Ignoring hint " + decodeHintType + " because it is not assignable from " + obj);
                        }
                    }
                    enumMap.put((EnumMap) decodeHintType, (DecodeHintType) obj);
                }
            }
        }
        Log.i(f48851a, "Hints from the Intent: " + enumMap);
        return enumMap;
    }
}
