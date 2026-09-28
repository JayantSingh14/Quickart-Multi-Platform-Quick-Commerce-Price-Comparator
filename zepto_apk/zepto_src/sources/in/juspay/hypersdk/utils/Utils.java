package in.juspay.hypersdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.PermissionChecker;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.core.JuspayServices;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class Utils {
    private static final String LOG_TAG = "Utils";

    public static boolean checkIfGranted(JuspayServices juspayServices, String str) {
        return PermissionChecker.a(juspayServices.getContext(), str) == 0;
    }

    public static boolean checkIfVPNConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return isVpnConnectedForLowerVersion(connectivityManager);
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        return networkCapabilities != null && networkCapabilities.hasTransport(4);
    }

    public static boolean contains(@NonNull JSONArray jSONArray, Object obj) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                if (jSONArray.get(i2).equals(obj)) {
                    return true;
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    public static JSONObject defaultNonNull(@Nullable JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    public static void deleteRecursive(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null) {
                    fileArrListFiles = new File[0];
                }
                for (File file2 : fileArrListFiles) {
                    deleteRecursive(file2);
                }
            }
            file.delete();
        }
    }

    public static String getIPAddress(JuspayServices juspayServices) {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress() != null) {
                        String upperCase = inetAddress.getHostAddress().toUpperCase(Locale.getDefault());
                        if (isIPv4Address(upperCase)) {
                            return upperCase;
                        }
                    }
                }
            }
            return "";
        } catch (Exception e2) {
            juspayServices.getSdkTracker().trackException("action", "system", Labels.System.UTIL, "Failed to Retreive IP address", e2);
            return "";
        }
    }

    public static String getLogLevelFromThrowable(Throwable th) {
        return th instanceof Error ? LogLevel.CRITICAL : th instanceof Exception ? "error" : "warning";
    }

    public static ActivityManager.MemoryInfo getMemoryInfo(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = context != null ? (ActivityManager) context.getSystemService("activity") : null;
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static byte[] gzipContent(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                JuspayLogger.d(LOG_TAG, "Gzipping complete");
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static <T> boolean includes(JSONArray jSONArray, T t) {
        if (jSONArray == null) {
            return false;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (t.equals(jSONArray.opt(i2))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIPv4Address(String str) throws NumberFormatException {
        int i2;
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length != 4) {
            return false;
        }
        for (String str2 : strArrSplit) {
            try {
                i2 = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
            }
            if (i2 < 0 || i2 > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVpnConnectedForLowerVersion(ConnectivityManager connectivityManager) {
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                return true;
            }
        }
        return false;
    }

    public static JSONArray optJSONArray(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        return jSONArrayOptJSONArray == null ? new JSONArray() : jSONArrayOptJSONArray;
    }

    public static JSONObject optJSONObject(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
    }

    public static JSONObject toJSON(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            try {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj == null) {
                        jSONObject.put(str, JSONObject.NULL);
                    } else if (obj instanceof ArrayList) {
                        jSONObject.put(str, toJSONArray((ArrayList) obj));
                    } else if (obj instanceof Bundle) {
                        jSONObject.put(str, toJSON((Bundle) obj));
                    } else {
                        jSONObject.put(str, String.valueOf(obj));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONArray toJSONArray(ArrayList<Object> arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Object> it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof ArrayList) {
                jSONArray.put(toJSONArray((ArrayList) next));
            } else if (next instanceof JSONObject) {
                jSONArray.put(next);
            } else {
                jSONArray.put(String.valueOf(next));
            }
        }
        return jSONArray;
    }

    public static JSONArray defaultNonNull(@Nullable JSONArray jSONArray) {
        return jSONArray == null ? new JSONArray() : jSONArray;
    }
}
