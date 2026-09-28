package in.juspay.hypersdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import in.juspay.hypersdk.core.JuspayServices;
import java.util.Map;

/* loaded from: classes4.dex */
public final class KeyValueStore {
    private KeyValueStore() {
    }

    public static boolean contains(JuspayServices juspayServices, String str) {
        return contains(juspayServices.getContext(), juspayServices.getSdkInfo().getSdkName(), str);
    }

    public static Map<String, ?> getAll(JuspayServices juspayServices) {
        return getAll(juspayServices.getContext(), juspayServices.getSdkInfo().getSdkName());
    }

    public static String read(JuspayServices juspayServices, String str, String str2) {
        return read(juspayServices.getContext(), juspayServices.getSdkInfo().getSdkName(), str, str2);
    }

    public static void remove(JuspayServices juspayServices, String str) {
        remove(juspayServices.getContext(), juspayServices.getSdkInfo().getSdkName(), str);
    }

    public static void write(JuspayServices juspayServices, String str, String str2) {
        write(juspayServices.getContext(), juspayServices.getSdkInfo().getSdkName(), str, str2);
    }

    public static boolean contains(@NonNull Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).contains(str2);
    }

    public static Map<String, ?> getAll(@NonNull Context context, String str) {
        return context.getSharedPreferences(str, 0).getAll();
    }

    public static String read(@NonNull Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void remove(@NonNull Context context, String str, String str2, boolean z) {
        if (contains(context, str, str2)) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.remove(str2);
            if (z) {
                editorEdit.commit();
            } else {
                editorEdit.apply();
            }
        }
    }

    public static void write(@NonNull Context context, String str, String str2, String str3, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putString(str2, str3);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static void write(@NonNull Context context, String str, String str2, String str3) {
        write(context, str, str2, str3, false);
    }

    public static void remove(@NonNull Context context, String str, String str2) {
        remove(context, str, str2, false);
    }
}
