package com.google.firebase.crashlytics.ndk;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.ndk.SessionFiles;
import j$.util.Base64;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes.dex */
public class CrashpadController {

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f44464d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final Context f44465a;

    /* renamed from: b, reason: collision with root package name */
    public final JniNativeApi f44466b;

    /* renamed from: c, reason: collision with root package name */
    public final FileStore f44467c;

    public CrashpadController(Context context, JniNativeApi jniNativeApi, FileStore fileStore) {
        this.f44465a = context;
        this.f44466b = jniNativeApi;
        this.f44467c = fileStore;
    }

    public static String a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[KEYRecord.Flags.FLAG2];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                    try {
                        gZIPOutputStream.write(byteArray);
                        gZIPOutputStream.finish();
                        String strEncodeToString = Base64.getEncoder().encodeToString(byteArrayOutputStream2.toByteArray());
                        gZIPOutputStream.close();
                        byteArrayOutputStream2.close();
                        return strEncodeToString;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public static File c(File file, String str) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    public static void g(FileStore fileStore, String str, String str2, String str3) throws Throwable {
        File file = new File(fileStore.b(str), str3);
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), f44464d));
            try {
                bufferedWriter2.write(str2);
                CommonUtils.b(bufferedWriter2, "Failed to close " + file);
            } catch (IOException unused) {
                bufferedWriter = bufferedWriter2;
                CommonUtils.b(bufferedWriter, "Failed to close " + file);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                CommonUtils.b(bufferedWriter, "Failed to close " + file);
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final SessionFiles b(String str) {
        FileStore fileStore = this.f44467c;
        File fileB = fileStore.b(str);
        File file = new File(fileB, "pending");
        Logger logger = Logger.f43705a;
        logger.e("Minidump directory: " + file.getAbsolutePath());
        File fileC = c(file, ".dmp");
        logger.e("Minidump file ".concat((fileC == null || !fileC.exists()) ? "does not exist" : "exists"));
        SessionFiles.Builder builder = new SessionFiles.Builder();
        if (fileB.exists() && file.exists()) {
            File fileC2 = c(file, ".dmp");
            CrashlyticsReport.ApplicationExitInfo applicationExitInfoA = null;
            String strA = null;
            applicationExitInfoA = null;
            if (Build.VERSION.SDK_INT >= 31) {
                List historicalProcessExitReasons = ((ActivityManager) this.f44465a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                long jLastModified = fileStore.c(str, "start-time").lastModified();
                ArrayList arrayList = new ArrayList();
                Iterator it = historicalProcessExitReasons.iterator();
                while (it.hasNext()) {
                    ApplicationExitInfo applicationExitInfoD = androidx.activity.result.contract.a.d(it.next());
                    if (applicationExitInfoD.getReason() == 5 && applicationExitInfoD.getTimestamp() >= jLastModified) {
                        arrayList.add(applicationExitInfoD);
                    }
                }
                if (!arrayList.isEmpty()) {
                    ApplicationExitInfo applicationExitInfoD2 = androidx.activity.result.contract.a.d(arrayList.get(0));
                    CrashlyticsReport.ApplicationExitInfo.Builder builderA = CrashlyticsReport.ApplicationExitInfo.a();
                    builderA.c(applicationExitInfoD2.getImportance());
                    builderA.e(applicationExitInfoD2.getProcessName());
                    builderA.g(applicationExitInfoD2.getReason());
                    builderA.i(applicationExitInfoD2.getTimestamp());
                    builderA.d(applicationExitInfoD2.getPid());
                    builderA.f(applicationExitInfoD2.getPss());
                    builderA.h(applicationExitInfoD2.getRss());
                    try {
                        strA = a(applicationExitInfoD2.getTraceInputStream());
                    } catch (IOException unused) {
                        logger.f("Failed to get input stream from ApplicationExitInfo", null);
                    }
                    builderA.j(strA);
                    applicationExitInfoA = builderA.a();
                }
            }
            builder.e(new SessionFiles.NativeCore(fileC2, applicationExitInfoA));
            builder.d(c(fileB, ".device_info"));
            builder.g(new File(fileB, "session.json"));
            builder.a(new File(fileB, "app.json"));
            builder.c(new File(fileB, "device.json"));
            builder.f(new File(fileB, "os.json"));
        }
        return builder.b();
    }

    public final void d(long j2, String str) throws Throwable {
        HashMap map = new HashMap();
        map.put("session_id", str);
        map.put("generator", "Crashlytics Android SDK/19.4.4");
        map.put("started_at_seconds", Long.valueOf(j2));
        g(this.f44467c, str, new JSONObject(map).toString(), "session.json");
    }

    public final void e(String str, StaticSessionData.AppData appData) throws Throwable {
        String strA = appData.a();
        String strF = appData.f();
        String strG = appData.g();
        String strE = appData.e();
        int iC = appData.c();
        String strA2 = appData.d().a();
        String strB = appData.d().b();
        HashMap map = new HashMap();
        map.put("app_identifier", strA);
        map.put("version_code", strF);
        map.put("version_name", strG);
        map.put("install_uuid", strE);
        map.put("delivery_mechanism", Integer.valueOf(iC));
        if (strA2 == null) {
            strA2 = "";
        }
        map.put("development_platform", strA2);
        if (strB == null) {
            strB = "";
        }
        map.put("development_platform_version", strB);
        g(this.f44467c, str, new JSONObject(map).toString(), "app.json");
    }

    public final void f(String str, StaticSessionData.DeviceData deviceData) throws Throwable {
        int iA = deviceData.a();
        String strG = deviceData.g();
        int iB = deviceData.b();
        long j2 = deviceData.j();
        long jD = deviceData.d();
        boolean zE = deviceData.e();
        int i2 = deviceData.i();
        String strF = deviceData.f();
        String strH = deviceData.h();
        HashMap map = new HashMap();
        map.put("arch", Integer.valueOf(iA));
        map.put("build_model", strG);
        map.put("available_processors", Integer.valueOf(iB));
        map.put("total_ram", Long.valueOf(j2));
        map.put("disk_space", Long.valueOf(jD));
        map.put("is_emulator", Boolean.valueOf(zE));
        map.put("state", Integer.valueOf(i2));
        map.put("build_manufacturer", strF);
        map.put("build_product", strH);
        g(this.f44467c, str, new JSONObject(map).toString(), "device.json");
    }

    public final void h(String str, StaticSessionData.OsData osData) throws Throwable {
        String strD = osData.d();
        String strC = osData.c();
        boolean zB = osData.b();
        HashMap map = new HashMap();
        map.put("version", strD);
        map.put("build_version", strC);
        map.put("is_rooted", Boolean.valueOf(zB));
        g(this.f44467c, str, new JSONObject(map).toString(), "os.json");
    }
}
