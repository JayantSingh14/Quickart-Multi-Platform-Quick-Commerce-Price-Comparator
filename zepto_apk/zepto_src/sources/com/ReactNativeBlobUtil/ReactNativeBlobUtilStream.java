package com.ReactNativeBlobUtil;

import android.support.v4.media.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes3.dex */
public class ReactNativeBlobUtilStream {

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f14003d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final DeviceEventManagerModule.RCTDeviceEventEmitter f14004a;

    /* renamed from: b, reason: collision with root package name */
    public String f14005b = "base64";

    /* renamed from: c, reason: collision with root package name */
    public FileOutputStream f14006c = null;

    public ReactNativeBlobUtilStream(ReactApplicationContext reactApplicationContext) {
        this.f14004a = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    public static void a(String str, Callback callback) throws IOException {
        try {
            HashMap map = f14003d;
            FileOutputStream fileOutputStream = ((ReactNativeBlobUtilStream) map.get(str)).f14006c;
            map.remove(str);
            fileOutputStream.close();
            callback.invoke(new Object[0]);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage());
        }
    }

    public static void e(String str, ReadableArray readableArray, Callback callback) throws IOException {
        try {
            FileOutputStream fileOutputStream = ((ReactNativeBlobUtilStream) f14003d.get(str)).f14006c;
            byte[] bArr = new byte[readableArray.size()];
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                bArr[i2] = (byte) readableArray.getInt(i2);
            }
            fileOutputStream.write(bArr);
            callback.invoke(new Object[0]);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage());
        }
    }

    public static void f(String str, String str2, Callback callback) throws IOException {
        ReactNativeBlobUtilStream reactNativeBlobUtilStream = (ReactNativeBlobUtilStream) f14003d.get(str);
        try {
            reactNativeBlobUtilStream.f14006c.write(ReactNativeBlobUtilUtils.d(str2, reactNativeBlobUtilStream.f14005b));
            callback.invoke(new Object[0]);
        } catch (Exception e2) {
            callback.invoke(e2.getLocalizedMessage());
        }
    }

    public final void b(String str, WritableArray writableArray) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("event", "data");
        writableMapCreateMap.putArray("detail", writableArray);
        writableMapCreateMap.putString("streamId", str);
        this.f14004a.emit("ReactNativeBlobUtilFilesystem", writableMapCreateMap);
    }

    public final void c(String str, String str2, String str3) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("event", str2);
        writableMapCreateMap.putString("detail", str3);
        writableMapCreateMap.putString("streamId", str);
        this.f14004a.emit("ReactNativeBlobUtilFilesystem", writableMapCreateMap);
    }

    public final void d(String str, String str2, String str3) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("event", "error");
        writableMapCreateMap.putString("code", str2);
        writableMapCreateMap.putString("detail", str3);
        writableMapCreateMap.putString("streamId", str);
        this.f14004a.emit("ReactNativeBlobUtilFilesystem", writableMapCreateMap);
    }

    public final void g(String str, String str2, boolean z, Callback callback) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (file.exists()) {
                if (file.isDirectory()) {
                    callback.invoke("EISDIR", "Expecting a file but '" + str + "' is a directory");
                    return;
                }
            } else {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    callback.invoke("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                }
                if (!file.createNewFile()) {
                    callback.invoke("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str, z);
            this.f14005b = str2;
            String string = UUID.randomUUID().toString();
            f14003d.put(string, this);
            this.f14006c = fileOutputStream;
            callback.invoke(null, null, string);
        } catch (Exception e2) {
            StringBuilder sbY = b.y("Failed to create write stream at path `", str, "`; ");
            sbY.append(e2.getLocalizedMessage());
            callback.invoke("EUNSPECIFIED", sbY.toString());
        }
    }
}
