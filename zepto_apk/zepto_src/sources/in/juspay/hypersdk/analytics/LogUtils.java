package in.juspay.hypersdk.analytics;

import android.app.ActivityManager;
import android.content.Context;
import in.juspay.airborne.services.Workspace;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hypersdk.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LogUtils {
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static int getFromSharedPreference(String str, Workspace workspace) {
        return Integer.parseInt(workspace.getFromSharedPreference(str, "-1"));
    }

    public static Queue<JSONObject> getLogsFromFile(File file) {
        LinkedList linkedList = new LinkedList();
        byte[] bArr = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            for (String str : new String(bArr, StandardCharsets.UTF_8).split(LogConstants.LOG_DELIMITER)) {
                try {
                    linkedList.add(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
        return linkedList;
    }

    public static byte[] getLogsFromFileExp(File file) {
        byte[] bArr = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
        } catch (Exception unused) {
        }
        return bArr;
    }

    public static boolean isFileEligibleToPush(File file, LogConfig logConfig) {
        if (file != null) {
            if (((System.currentTimeMillis() - file.lastModified()) / 1000) / 3600 < logConfig.dontPushIfFileIsLastModifiedBeforeInHours) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isMinMemoryAvailable(LogConfig logConfig) {
        Context applicationContext = JuspayCoreLib.getApplicationContext();
        if (applicationContext != null) {
            try {
                ActivityManager.MemoryInfo memoryInfo = Utils.getMemoryInfo(applicationContext);
                if (memoryInfo != null) {
                    return Boolean.valueOf(memoryInfo.availMem >= logConfig.minMemoryRequired);
                }
            } catch (Exception unused) {
            }
        }
        return Boolean.TRUE;
    }

    public static Map<String, String> toMap(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject.getString(next));
        }
        return map;
    }

    public static void writeLogToFileExp(JSONObject jSONObject, File file) {
        if (file != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                try {
                    byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                    fileOutputStream.write(ByteBuffer.allocate(4).putInt(bytes.length).array());
                    fileOutputStream.write(bytes);
                    fileOutputStream.close();
                } finally {
                }
            } catch (Exception unused) {
            }
        }
    }
}
