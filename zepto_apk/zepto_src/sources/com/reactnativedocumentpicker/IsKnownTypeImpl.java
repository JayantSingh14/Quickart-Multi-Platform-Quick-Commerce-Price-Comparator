package com.reactnativedocumentpicker;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class IsKnownTypeImpl {

    @Metadata
    public static final class Companion {
        public static WritableMap a(String str, String str2, boolean z) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putNull("UTType");
            writableMapCreateMap.putBoolean("isKnown", z);
            writableMapCreateMap.putString("preferredFilenameExtension", str);
            writableMapCreateMap.putString("mimeType", str2);
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
            return writableMapCreateMap;
        }
    }
}
