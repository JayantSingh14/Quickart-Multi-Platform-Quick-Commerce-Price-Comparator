package com.reactnativedocumentpicker;

import android.net.Uri;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class DocumentMetadataBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f46331a;

    /* renamed from: b, reason: collision with root package name */
    public String f46332b;

    /* renamed from: c, reason: collision with root package name */
    public Long f46333c;

    /* renamed from: d, reason: collision with root package name */
    public String f46334d;

    /* renamed from: e, reason: collision with root package name */
    public String f46335e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f46336f;

    /* renamed from: g, reason: collision with root package name */
    public String f46337g;

    /* renamed from: h, reason: collision with root package name */
    public String f46338h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f46339i;

    public DocumentMetadataBuilder(Uri forUri) {
        Intrinsics.checkNotNullParameter(forUri, "forUri");
        this.f46331a = forUri;
    }

    public final WritableMap a() {
        String lowerCase;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(CLConstants.FIELD_PAY_INFO_NAME, this.f46332b);
        writableMapCreateMap.putString("uri", this.f46331a.toString());
        if (this.f46333c != null) {
            writableMapCreateMap.putDouble("size", r1.longValue());
        } else {
            writableMapCreateMap.putNull("size");
        }
        String str = this.f46334d;
        String lowerCase2 = null;
        if (str != null) {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        writableMapCreateMap.putString("type", lowerCase);
        String str2 = this.f46334d;
        if (str2 != null) {
            lowerCase2 = str2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        }
        writableMapCreateMap.putString("nativeType", lowerCase2);
        String[] strArr = this.f46336f;
        if (strArr != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (String str3 : strArr) {
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                writableMapCreateMap2.putString("mimeType", str3);
                writableMapCreateMap2.putString("extension", extensionFromMimeType);
                writableArrayCreateArray.pushMap(writableMapCreateMap2);
            }
            writableMapCreateMap.putArray("convertibleToMimeTypes", writableArrayCreateArray);
        } else {
            writableMapCreateMap.putNull("convertibleToMimeTypes");
        }
        writableMapCreateMap.putString("error", this.f46335e);
        Boolean bool = this.f46339i;
        if (bool != null) {
            writableMapCreateMap.putBoolean("isVirtual", bool.booleanValue());
        } else {
            writableMapCreateMap.putNull("isVirtual");
        }
        String str4 = this.f46337g;
        if (str4 == null) {
            String str5 = this.f46338h;
            if (str5 != null) {
                writableMapCreateMap.putString("bookmarkStatus", "error");
                writableMapCreateMap.putString("bookmarkError", str5);
            }
            return writableMapCreateMap;
        }
        byte[] bytes = str4.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(bytes, 0);
        writableMapCreateMap.putString("bookmarkStatus", APayConstants.SUCCESS);
        writableMapCreateMap.putString("bookmark", strEncodeToString);
        return writableMapCreateMap;
    }
}
