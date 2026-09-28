package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CachedSettingsIo {

    /* renamed from: a, reason: collision with root package name */
    public final File f44419a;

    public CachedSettingsIo(FileStore fileStore) {
        this.f44419a = new File(fileStore.f44386c, "com.crashlytics.settings.json");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0023: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:36), block:B:9:0x0023 */
    public final JSONObject a() throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        JSONObject jSONObject;
        Logger logger = Logger.f43705a;
        FileInputStream fileInputStream3 = null;
        logger.b("Checking for cached settings...", null);
        try {
            try {
                File file = this.f44419a;
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(CommonUtils.j(fileInputStream));
                        fileInputStream3 = fileInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        logger.c("Failed to fetch cached settings", e);
                        CommonUtils.b(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    logger.e("Settings file does not exist.");
                    jSONObject = null;
                }
                CommonUtils.b(fileInputStream3, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th) {
                th = th;
                fileInputStream3 = fileInputStream2;
                CommonUtils.b(fileInputStream3, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.b(fileInputStream3, "Error while closing settings cache file.");
            throw th;
        }
    }
}
