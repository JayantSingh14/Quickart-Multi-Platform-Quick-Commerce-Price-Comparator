package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class MetaDataStore {

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f43903b = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final FileStore f43904a;

    public MetaDataStore(FileStore fileStore) {
        this.f43904a = fileStore;
    }

    public static HashMap a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = null;
            if (!jSONObject.isNull(next)) {
                strOptString = jSONObject.optString(next, null);
            }
            map.put(next, strOptString);
        }
        return map;
    }

    public static ArrayList b(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String string = jSONArray.getString(i2);
            try {
                arrayList.add(RolloutAssignment.a(string));
            } catch (Exception e2) {
                Logger.f43705a.f("Failed de-serializing rollouts state. " + string, e2);
            }
        }
        return arrayList;
    }

    public static String e(List list) {
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                jSONArray.put(new JSONObject(RolloutAssignment.f43927a.encode(list.get(i2))));
            } catch (JSONException e2) {
                Logger.f43705a.f("Exception parsing rollout assignment!", e2);
            }
        }
        map.put("rolloutsState", jSONArray);
        return new JSONObject(map).toString();
    }

    public static void f(File file) {
        if (file.exists() && file.delete()) {
            Logger.f43705a.d("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    public static void g(File file, String str) {
        if (file.exists() && file.delete()) {
            Logger.f43705a.d("Deleted corrupt file: " + file.getAbsolutePath() + "\nReason: " + str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    public final Map c(String str, boolean z) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e2;
        FileStore fileStore = this.f43904a;
        File fileC = z ? fileStore.c(str, "internal-keys") : fileStore.c(str, "keys");
        if (!fileC.exists() || fileC.length() == 0) {
            g(fileC, android.support.v4.media.b.C("The file has a length of zero for session: ", str));
            return Collections.EMPTY_MAP;
        }
        try {
            try {
                fileInputStream = new FileInputStream(fileC);
                try {
                    HashMap mapA = a(CommonUtils.j(fileInputStream));
                    CommonUtils.b(fileInputStream, "Failed to close user metadata file.");
                    return mapA;
                } catch (Exception e3) {
                    e2 = e3;
                    Logger.f43705a.f("Error deserializing user metadata.", e2);
                    f(fileC);
                    CommonUtils.b(fileInputStream, "Failed to close user metadata file.");
                    return Collections.EMPTY_MAP;
                }
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.b(, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e4) {
            fileInputStream = null;
            e2 = e4;
        } catch (Throwable th3) {
            ?? r1 = 0;
            th = th3;
            CommonUtils.b(r1, "Failed to close user metadata file.");
            throw th;
        }
    }

    public final String d(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileC = this.f43904a.c(str, "user-data");
        boolean zExists = fileC.exists();
        Logger logger = Logger.f43705a;
        FileInputStream fileInputStream2 = null;
        if (!zExists || fileC.length() == 0) {
            logger.b("No userId set for session " + str, null);
            f(fileC);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileC);
            try {
                try {
                    JSONObject jSONObject = new JSONObject(CommonUtils.j(fileInputStream));
                    String strOptString = !jSONObject.isNull("userId") ? jSONObject.optString("userId", null) : null;
                    logger.b("Loaded userId " + strOptString + " for session " + str, null);
                    CommonUtils.b(fileInputStream, "Failed to close user metadata file.");
                    return strOptString;
                } catch (Exception e2) {
                    e = e2;
                    logger.f("Error deserializing user metadata.", e);
                    f(fileC);
                    CommonUtils.b(fileInputStream, "Failed to close user metadata file.");
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                CommonUtils.b(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.b(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public final void h(String str, Map map, boolean z) throws Throwable {
        String string;
        BufferedWriter bufferedWriter;
        FileStore fileStore = this.f43904a;
        File fileC = z ? fileStore.c(str, "internal-keys") : fileStore.c(str, "keys");
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                string = new JSONObject(map).toString();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileC), f43903b));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(string);
            bufferedWriter.flush();
            CommonUtils.b(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Exception e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            Logger.f43705a.f("Error serializing key/value metadata.", e);
            f(fileC);
            CommonUtils.b(bufferedWriter2, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            CommonUtils.b(bufferedWriter2, "Failed to close key/value metadata file.");
            throw th;
        }
    }

    public final void i(String str, String str2) throws Throwable {
        String string;
        BufferedWriter bufferedWriter;
        File fileC = this.f43904a.c(str, "user-data");
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                string = new JSONObject(str2) { // from class: com.google.firebase.crashlytics.internal.metadata.MetaDataStore.1
                    {
                        put("userId", str2);
                    }
                }.toString();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileC), f43903b));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            bufferedWriter.write(string);
            bufferedWriter.flush();
            CommonUtils.b(bufferedWriter, "Failed to close user metadata file.");
        } catch (Exception e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            Logger.f43705a.f("Error serializing user metadata.", e);
            CommonUtils.b(bufferedWriter2, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            CommonUtils.b(bufferedWriter2, "Failed to close user metadata file.");
            throw th;
        }
    }
}
