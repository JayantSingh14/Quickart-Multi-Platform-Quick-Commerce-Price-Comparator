package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import coil3.util.UtilsKt;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.packagerconnection.JSPackagerClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

@Nullsafe
/* loaded from: classes3.dex */
public class FileIoHandler implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f19195a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f19196b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f19197c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f19198d;

    public static class TtlFileInputStream {

        /* renamed from: a, reason: collision with root package name */
        public final FileInputStream f19202a;

        /* renamed from: b, reason: collision with root package name */
        public long f19203b = System.currentTimeMillis() + 30000;

        public TtlFileInputStream(String str) {
            this.f19202a = new FileInputStream(str);
        }
    }

    public FileIoHandler() {
        HashMap map = new HashMap();
        this.f19198d = map;
        map.put("fopen", new RequestOnlyHandler() { // from class: com.facebook.react.packagerconnection.FileIoHandler.1
            @Override // com.facebook.react.packagerconnection.RequestHandler
            public final void b(Object obj, Responder responder) {
                JSONObject jSONObject;
                synchronized (FileIoHandler.this.f19197c) {
                    try {
                        try {
                            jSONObject = (JSONObject) obj;
                        } catch (Exception e2) {
                            ((JSPackagerClient.ResponderImpl) responder).a(e2.toString());
                        }
                        if (jSONObject == null) {
                            throw new Exception("params must be an object { mode: string, filename: string }");
                        }
                        String strOptString = jSONObject.optString("mode");
                        if (strOptString == null) {
                            throw new Exception("missing params.mode");
                        }
                        String strOptString2 = jSONObject.optString("filename");
                        if (strOptString2 == null) {
                            throw new Exception("missing params.filename");
                        }
                        if (!strOptString.equals("r")) {
                            throw new IllegalArgumentException("unsupported mode: ".concat(strOptString));
                        }
                        ((JSPackagerClient.ResponderImpl) responder).b(Integer.valueOf(FileIoHandler.a(FileIoHandler.this, strOptString2)));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        map.put("fclose", new RequestOnlyHandler() { // from class: com.facebook.react.packagerconnection.FileIoHandler.2
            @Override // com.facebook.react.packagerconnection.RequestHandler
            public final void b(Object obj, Responder responder) {
                synchronized (FileIoHandler.this.f19197c) {
                    try {
                        try {
                        } catch (Exception e2) {
                            ((JSPackagerClient.ResponderImpl) responder).a(e2.toString());
                        }
                        if (!(obj instanceof Number)) {
                            throw new Exception("params must be a file handle");
                        }
                        TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) FileIoHandler.this.f19197c.get(obj);
                        if (ttlFileInputStream == null) {
                            throw new Exception("invalid file handle, it might have timed out");
                        }
                        FileIoHandler.this.f19197c.remove(obj);
                        ttlFileInputStream.f19202a.close();
                        ((JSPackagerClient.ResponderImpl) responder).b("");
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        map.put("fread", new RequestOnlyHandler() { // from class: com.facebook.react.packagerconnection.FileIoHandler.3
            @Override // com.facebook.react.packagerconnection.RequestHandler
            public final void b(Object obj, Responder responder) {
                JSONObject jSONObject;
                synchronized (FileIoHandler.this.f19197c) {
                    try {
                        try {
                            jSONObject = (JSONObject) obj;
                        } catch (Exception e2) {
                            ((JSPackagerClient.ResponderImpl) responder).a(e2.toString());
                        }
                        if (jSONObject == null) {
                            throw new Exception("params must be an object { file: handle, size: number }");
                        }
                        int iOptInt = jSONObject.optInt(UtilsKt.SCHEME_FILE);
                        if (iOptInt == 0) {
                            throw new Exception("invalid or missing file handle");
                        }
                        int iOptInt2 = jSONObject.optInt("size");
                        if (iOptInt2 == 0) {
                            throw new Exception("invalid or missing read size");
                        }
                        TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) FileIoHandler.this.f19197c.get(Integer.valueOf(iOptInt));
                        if (ttlFileInputStream == null) {
                            throw new Exception("invalid file handle, it might have timed out");
                        }
                        ttlFileInputStream.f19203b = System.currentTimeMillis() + 30000;
                        byte[] bArr = new byte[iOptInt2];
                        ((JSPackagerClient.ResponderImpl) responder).b(Base64.encodeToString(bArr, 0, ttlFileInputStream.f19202a.read(bArr), 0));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    public static int a(FileIoHandler fileIoHandler, String str) {
        int i2 = fileIoHandler.f19195a;
        fileIoHandler.f19195a = i2 + 1;
        HashMap map = fileIoHandler.f19197c;
        map.put(Integer.valueOf(i2), new TtlFileInputStream(str));
        if (map.size() == 1) {
            fileIoHandler.f19196b.postDelayed(fileIoHandler, 30000L);
        }
        return i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f19197c) {
            try {
                Iterator it = this.f19197c.values().iterator();
                while (it.hasNext()) {
                    TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) it.next();
                    ttlFileInputStream.getClass();
                    if (System.currentTimeMillis() >= ttlFileInputStream.f19203b) {
                        it.remove();
                        try {
                            ttlFileInputStream.f19202a.close();
                        } catch (IOException e2) {
                            FLog.g("JSPackagerClient", "closing expired file failed: " + e2.toString());
                        }
                    }
                }
                if (!this.f19197c.isEmpty()) {
                    this.f19196b.postDelayed(this, 30000L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
