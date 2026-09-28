package com.google.android.gms.internal.pal;

import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzaeh {
    public static final void a(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i2, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i2, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            zzaby zzabyVar = zzaby.f37363b;
            sb.append(zzafg.a(new zzabv(((String) obj).getBytes(zzadg.f37410a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzaby) {
            sb.append(": \"");
            sb.append(zzafg.a((zzaby) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzacz) {
            sb.append(" {");
            c((zzacz) obj, sb, i2 + 2);
            sb.append(StringUtils.LF);
            while (i3 < i2) {
                sb.append(' ');
                i3++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i5 = i2 + 2;
        a(sb, i5, "key", entry.getKey());
        a(sb, i5, CLConstants.FIELD_PAY_INFO_VALUE, entry.getValue());
        sb.append(StringUtils.LF);
        while (i3 < i2) {
            sb.append(' ');
            i3++;
        }
        sb.append("}");
    }

    public static final String b(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt)) {
                sb.append(Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    public static void c(zzacz zzaczVar, StringBuilder sb, int i2) {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (Method method : zzaczVar.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String strSubstring = str.startsWith("get") ? str.substring(3) : str;
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List")) {
                String strConcat = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1, strSubstring.length() - 4)));
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    a(sb, i2, b(strConcat), zzacz.f(method2, zzaczVar, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String strConcat2 = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1, strSubstring.length() - 3)));
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    a(sb, i2, b(strConcat2), zzacz.f(method3, zzaczVar, new Object[0]));
                }
            }
            if (((Method) map2.get("set".concat(strSubstring))) != null && (!strSubstring.endsWith("Bytes") || !map.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                String strConcat3 = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1)));
                Method method4 = (Method) map.get("get".concat(strSubstring));
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objF = zzacz.f(method4, zzaczVar, new Object[0]);
                    if (method5 == null) {
                        if (objF instanceof Boolean) {
                            if (((Boolean) objF).booleanValue()) {
                                a(sb, i2, b(strConcat3), objF);
                            }
                        } else if (objF instanceof Integer) {
                            if (((Integer) objF).intValue() != 0) {
                                a(sb, i2, b(strConcat3), objF);
                            }
                        } else if (objF instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objF).floatValue()) != 0) {
                                a(sb, i2, b(strConcat3), objF);
                            }
                        } else if (!(objF instanceof Double)) {
                            if (objF instanceof String) {
                                zEquals = objF.equals("");
                            } else if (objF instanceof zzaby) {
                                zEquals = objF.equals(zzaby.f37363b);
                            } else if (objF instanceof zzaef) {
                                if (objF != ((zzaef) objF).g()) {
                                    a(sb, i2, b(strConcat3), objF);
                                }
                            } else if (!(objF instanceof Enum) || ((Enum) objF).ordinal() != 0) {
                                a(sb, i2, b(strConcat3), objF);
                            }
                            if (!zEquals) {
                                a(sb, i2, b(strConcat3), objF);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objF).doubleValue()) != 0) {
                            a(sb, i2, b(strConcat3), objF);
                        }
                    } else if (((Boolean) zzacz.f(method5, zzaczVar, new Object[0])).booleanValue()) {
                        a(sb, i2, b(strConcat3), objF);
                    }
                }
            }
        }
        if (zzaczVar instanceof zzacw) {
            throw null;
        }
        zzafj zzafjVar = zzaczVar.zzc;
        if (zzafjVar != null) {
            for (int i3 = 0; i3 < zzafjVar.f37489a; i3++) {
                a(sb, i2, String.valueOf(zzafjVar.f37490b[i3] >>> 3), zzafjVar.f37491c[i3]);
            }
        }
    }
}
