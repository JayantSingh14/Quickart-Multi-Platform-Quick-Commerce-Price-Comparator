package com.ReactNativeBlobUtil;

import android.net.Uri;
import android.support.v4.media.b;
import android.util.Base64;
import androidx.fragment.app.e;
import coil3.network.internal.UtilsKt;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
class ReactNativeBlobUtilBody extends RequestBody {

    /* renamed from: b, reason: collision with root package name */
    public ReadableArray f13890b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13891c;

    /* renamed from: d, reason: collision with root package name */
    public String f13892d;

    /* renamed from: e, reason: collision with root package name */
    public ReactNativeBlobUtilReq.RequestType f13893e;

    /* renamed from: f, reason: collision with root package name */
    public MediaType f13894f;

    /* renamed from: g, reason: collision with root package name */
    public File f13895g;

    /* renamed from: a, reason: collision with root package name */
    public long f13889a = 0;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f13896h = Boolean.FALSE;

    /* renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilBody$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13897a;

        static {
            int[] iArr = new int[ReactNativeBlobUtilReq.RequestType.values().length];
            f13897a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13897a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13897a[4] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class FormField {

        /* renamed from: a, reason: collision with root package name */
        public String f13898a;

        /* renamed from: b, reason: collision with root package name */
        public String f13899b;

        /* renamed from: c, reason: collision with root package name */
        public String f13900c;

        /* renamed from: d, reason: collision with root package name */
        public String f13901d;
    }

    public ReactNativeBlobUtilBody(String str) {
        this.f13891c = str;
    }

    public static void d(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[10240];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 <= 0) {
                inputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, i2);
        }
    }

    public final File a() {
        InputStream inputStream;
        InputStream inputStreamOpenInputStream;
        int length;
        InputStream inputStreamOpenInputStream2;
        String str = "ReactNativeBlobUtil-" + this.f13891c;
        File fileCreateTempFile = File.createTempFile("rnfb-form-tmp", "", ReactNativeBlobUtilImpl.f13918b.getCacheDir());
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        ArrayList arrayList = new ArrayList();
        ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.f13918b;
        long jAvailable = 0;
        int i2 = 0;
        while (i2 < this.f13890b.size()) {
            ReadableMap map = this.f13890b.getMap(i2);
            FormField formField = new FormField();
            File file = fileCreateTempFile;
            if (map.hasKey(CLConstants.FIELD_PAY_INFO_NAME)) {
                formField.f13898a = map.getString(CLConstants.FIELD_PAY_INFO_NAME);
            }
            if (map.hasKey("filename")) {
                formField.f13899b = map.getString("filename");
            }
            if (map.hasKey("type")) {
                formField.f13900c = map.getString("type");
            } else {
                formField.f13900c = formField.f13899b == null ? UtilsKt.MIME_TYPE_TEXT_PLAIN : "application/octet-stream";
            }
            if (map.hasKey("data")) {
                formField.f13901d = map.getString("data");
            }
            arrayList.add(formField);
            String str2 = formField.f13901d;
            if (str2 == null) {
                ReactNativeBlobUtilUtils.a("ReactNativeBlobUtil multipart request builder has found a field without `data` property, the field `" + formField.f13898a + "` will be removed implicitly.");
            } else {
                if (formField.f13899b == null) {
                    length = str2.getBytes().length;
                } else if (str2.startsWith("ReactNativeBlobUtil-file://")) {
                    String strC = ReactNativeBlobUtilUtils.c(str2.substring(27));
                    if (strC == null || !strC.startsWith("bundle-assets://")) {
                        jAvailable += new File(ReactNativeBlobUtilUtils.c(strC)).length();
                    } else {
                        try {
                            length = reactApplicationContext.getAssets().open(strC.replace("bundle-assets://", "")).available();
                        } catch (IOException e2) {
                            ReactNativeBlobUtilUtils.a(e2.getLocalizedMessage());
                        }
                    }
                } else if (str2.startsWith("ReactNativeBlobUtil-content://")) {
                    String strSubstring = str2.substring(30);
                    try {
                        inputStreamOpenInputStream2 = reactApplicationContext.getContentResolver().openInputStream(Uri.parse(strSubstring));
                        try {
                            try {
                                jAvailable += inputStreamOpenInputStream2.available();
                            } catch (Exception e3) {
                                e = e3;
                                ReactNativeBlobUtilUtils.a("Failed to estimate form data length from content URI:" + strSubstring + ", " + e.getLocalizedMessage());
                                if (inputStreamOpenInputStream2 != null) {
                                    inputStreamOpenInputStream2.close();
                                }
                                i2++;
                                fileCreateTempFile = file;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (inputStreamOpenInputStream2 != null) {
                                inputStreamOpenInputStream2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        inputStreamOpenInputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamOpenInputStream2 = null;
                    }
                    inputStreamOpenInputStream2.close();
                } else {
                    length = Base64.decode(str2, 0).length;
                }
                jAvailable += length;
            }
            i2++;
            fileCreateTempFile = file;
        }
        File file2 = fileCreateTempFile;
        this.f13889a = jAvailable;
        ReactApplicationContext reactApplicationContext2 = ReactNativeBlobUtilImpl.f13918b;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FormField formField2 = (FormField) it.next();
            String str3 = formField2.f13901d;
            String str4 = formField2.f13898a;
            if (str4 != null && str3 != null) {
                String strD = b.D("--", str, "\r\n");
                String str5 = formField2.f13900c;
                String str6 = formField2.f13899b;
                ReactApplicationContext reactApplicationContext3 = reactApplicationContext2;
                Iterator it2 = it;
                String str7 = str;
                if (str6 != null) {
                    fileOutputStream.write(((strD + "Content-Disposition: form-data; name=\"" + str4 + "\"; filename=\"" + str6 + "\"\r\n") + "Content-Type: " + str5 + "\r\n\r\n").getBytes());
                    if (str3.startsWith("ReactNativeBlobUtil-file://")) {
                        String strC2 = ReactNativeBlobUtilUtils.c(str3.substring(27));
                        if (strC2 == null || !strC2.startsWith("bundle-assets://")) {
                            File file3 = new File(ReactNativeBlobUtilUtils.c(strC2));
                            if (file3.exists()) {
                                d(new FileInputStream(file3), fileOutputStream);
                            } else {
                                ReactNativeBlobUtilUtils.a("Failed to create form data from path :" + strC2 + ", file not exists.");
                            }
                        } else {
                            try {
                                d(reactApplicationContext3.getAssets().open(strC2.replace("bundle-assets://", "")), fileOutputStream);
                            } catch (IOException e5) {
                                StringBuilder sbY = b.y("Failed to create form data asset :", strC2, ", ");
                                sbY.append(e5.getLocalizedMessage());
                                ReactNativeBlobUtilUtils.a(sbY.toString());
                            }
                        }
                    } else if (str3.startsWith("ReactNativeBlobUtil-content://")) {
                        String strSubstring2 = str3.substring(30);
                        try {
                            inputStreamOpenInputStream = reactApplicationContext3.getContentResolver().openInputStream(Uri.parse(strSubstring2));
                            try {
                                try {
                                    d(inputStreamOpenInputStream, fileOutputStream);
                                } catch (Exception e6) {
                                    e = e6;
                                    ReactNativeBlobUtilUtils.a("Failed to create form data from content URI:" + strSubstring2 + ", " + e.getLocalizedMessage());
                                    if (inputStreamOpenInputStream != null) {
                                        inputStreamOpenInputStream.close();
                                    }
                                    fileOutputStream.write("\r\n".getBytes());
                                    reactApplicationContext2 = reactApplicationContext3;
                                    it = it2;
                                    str = str7;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = inputStreamOpenInputStream;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            inputStreamOpenInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = null;
                        }
                        inputStreamOpenInputStream.close();
                    } else {
                        fileOutputStream.write(Base64.decode(str3, 0));
                    }
                } else {
                    fileOutputStream.write((e.D(strD, "Content-Disposition: form-data; name=\"", str4, "\"\r\n") + "Content-Type: " + str5 + "\r\n\r\n").getBytes());
                    fileOutputStream.write(formField2.f13901d.getBytes());
                }
                fileOutputStream.write("\r\n".getBytes());
                reactApplicationContext2 = reactApplicationContext3;
                it = it2;
                str = str7;
            }
        }
        fileOutputStream.write(("--" + str + "--\r\n").getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        return file2;
    }

    public final InputStream b() {
        try {
            if (this.f13890b != null) {
                return new FileInputStream(this.f13895g);
            }
            int iOrdinal = this.f13893e.ordinal();
            if (iOrdinal == 1) {
                return c();
            }
            if (iOrdinal == 2) {
                return new ByteArrayInputStream(this.f13892d.getBytes());
            }
            if (iOrdinal != 4) {
                return null;
            }
            ReactNativeBlobUtilUtils.a("ReactNativeBlobUtil could not create input stream for request type others");
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            ReactNativeBlobUtilUtils.a("ReactNativeBlobUtil failed to create input stream for request:" + e2.getLocalizedMessage());
            return null;
        }
    }

    public final InputStream c() throws Exception {
        if (!this.f13892d.startsWith("ReactNativeBlobUtil-file://")) {
            if (this.f13892d.startsWith("ReactNativeBlobUtil-content://")) {
                String strSubstring = this.f13892d.substring(30);
                try {
                    return ReactNativeBlobUtilImpl.f13918b.getContentResolver().openInputStream(Uri.parse(strSubstring));
                } catch (Exception e2) {
                    throw new Exception(b.C("error when getting request stream for content URI: ", strSubstring), e2);
                }
            }
            try {
                return new ByteArrayInputStream(Base64.decode(this.f13892d, 0));
            } catch (Exception e3) {
                throw new Exception("error when getting request stream: " + e3.getLocalizedMessage());
            }
        }
        String strC = ReactNativeBlobUtilUtils.c(this.f13892d.substring(27));
        if (strC != null && strC.startsWith("bundle-assets://")) {
            try {
                return ReactNativeBlobUtilImpl.f13918b.getAssets().open(strC.replace("bundle-assets://", ""));
            } catch (Exception e4) {
                throw new Exception("error when getting request stream from asset : " + e4.getLocalizedMessage());
            }
        }
        File file = new File(ReactNativeBlobUtilUtils.c(strC));
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return new FileInputStream(file);
        } catch (Exception e5) {
            throw new Exception("error when getting request stream: " + e5.getLocalizedMessage());
        }
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        if (this.f13896h.booleanValue()) {
            return -1L;
        }
        return this.f13889a;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.f13894f;
    }

    public final void e(InputStream inputStream, BufferedSink bufferedSink) throws IOException {
        byte[] bArr = new byte[10240];
        long j2 = 0;
        while (true) {
            int i2 = inputStream.read(bArr, 0, 10240);
            if (i2 <= 0) {
                inputStream.close();
                return;
            }
            bufferedSink.x0(0, bArr, i2);
            j2 += i2;
            HashMap map = ReactNativeBlobUtilReq.z;
            String str = this.f13891c;
            ReactNativeBlobUtilProgressConfig reactNativeBlobUtilProgressConfig = !map.containsKey(str) ? null : (ReactNativeBlobUtilProgressConfig) map.get(str);
            if (reactNativeBlobUtilProgressConfig != null) {
                long j3 = this.f13889a;
                if (j3 != 0 && reactNativeBlobUtilProgressConfig.a(j2 / j3)) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putString("taskId", str);
                    writableMapCreateMap.putString("written", String.valueOf(j2));
                    writableMapCreateMap.putString("total", String.valueOf(this.f13889a));
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.f13918b.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("ReactNativeBlobUtilProgress-upload", writableMapCreateMap);
                }
            }
        }
    }

    public final void f(String str) {
        this.f13892d = str;
        if (str == null) {
            this.f13892d = "";
            this.f13893e = ReactNativeBlobUtilReq.RequestType.f13993c;
        }
        try {
            int iOrdinal = this.f13893e.ordinal();
            if (iOrdinal == 1) {
                this.f13889a = c().available();
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                this.f13889a = this.f13892d.getBytes().length;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            ReactNativeBlobUtilUtils.a("ReactNativeBlobUtil failed to create single content request body :" + e2.getLocalizedMessage() + "\r\n");
        }
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) {
        try {
            e(b(), bufferedSink);
        } catch (Exception e2) {
            ReactNativeBlobUtilUtils.a(e2.getLocalizedMessage());
            e2.printStackTrace();
        }
    }
}
