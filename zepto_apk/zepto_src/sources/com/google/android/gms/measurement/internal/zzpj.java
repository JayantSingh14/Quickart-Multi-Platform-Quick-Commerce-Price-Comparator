package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.text.TextUtils;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzqu;
import com.google.android.gms.internal.pal.a;
import in.juspay.airborne.ota.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class zzpj extends zzor {
    public static boolean H(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean I(com.google.android.gms.internal.measurement.zzmm zzmmVar, int i2) {
        if (i2 < zzmmVar.size() * 64) {
            return ((1 << (i2 % 64)) & ((Long) zzmmVar.get(i2 / 64)).longValue()) != 0;
        }
        return false;
    }

    public static ArrayList J(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            long j2 = 0;
            for (int i3 = 0; i3 < 64; i3++) {
                int i4 = (i2 * 64) + i3;
                if (i4 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i4)) {
                    j2 |= 1 << i3;
                }
            }
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    public static com.google.android.gms.internal.measurement.zznk O(com.google.android.gms.internal.measurement.zzma zzmaVar, byte[] bArr) throws com.google.android.gms.internal.measurement.zzmq {
        com.google.android.gms.internal.measurement.zzlq zzlqVarA = com.google.android.gms.internal.measurement.zzlq.a();
        if (zzlqVarA != null) {
            zzmaVar.getClass();
            zzmaVar.n(bArr, bArr.length, zzlqVarA);
            return zzmaVar;
        }
        zzmaVar.getClass();
        zzmaVar.h(bArr.length, bArr);
        return zzmaVar;
    }

    public static int P(com.google.android.gms.internal.measurement.zzic zzicVar, String str) {
        for (int i2 = 0; i2 < ((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).Z1(); i2++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).a2(i2).u())) {
                return i2;
            }
        }
        return -1;
    }

    public static Bundle[] Q(com.google.android.gms.internal.measurement.zzmn zzmnVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = zzmnVar.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            if (zzhwVar != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar2 : zzhwVar.C()) {
                    if (zzhwVar2.u()) {
                        bundle.putString(zzhwVar2.t(), zzhwVar2.v());
                    } else if (zzhwVar2.w()) {
                        bundle.putLong(zzhwVar2.t(), zzhwVar2.x());
                    } else if (zzhwVar2.A()) {
                        bundle.putDouble(zzhwVar2.t(), zzhwVar2.B());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static HashMap R(Bundle bundle, boolean z) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z2 = obj instanceof Parcelable[];
            if (z2 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    if (z2) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(R((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            Object obj2 = arrayList2.get(i2);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(R((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(R((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public static zzbg k(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        Object obj;
        Bundle bundleL = l(zzaaVar.c(), true);
        String string = (!bundleL.containsKey("_o") || (obj = bundleL.get("_o")) == null) ? Constants.APP_DIR : obj.toString();
        String strB = zzls.b(zzaaVar.b(), zzjl.f39201a, zzjl.f39203c);
        if (strB == null) {
            strB = zzaaVar.b();
        }
        return new zzbg(strB, new zzbe(bundleL), string, zzaaVar.a());
    }

    public static Bundle l(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList2.add(l((Map) arrayList.get(i2), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public static final void m(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str, Long l2) {
        List listO = zzhrVar.o();
        int i2 = 0;
        while (true) {
            if (i2 >= listO.size()) {
                i2 = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhw) listO.get(i2)).t())) {
                break;
            } else {
                i2++;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzhvVarE = com.google.android.gms.internal.measurement.zzhw.E();
        zzhvVarE.o(str);
        zzhvVarE.q(l2.longValue());
        if (i2 < 0) {
            zzhrVar.t(zzhvVarE);
        } else {
            zzhrVar.i();
            ((com.google.android.gms.internal.measurement.zzhs) zzhrVar.f37107b).D(i2, (com.google.android.gms.internal.measurement.zzhw) zzhvVarE.l());
        }
    }

    public static final Bundle n(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            String strT = zzhwVar.t();
            if (zzhwVar.A()) {
                bundle.putDouble(strT, zzhwVar.B());
            } else if (zzhwVar.y()) {
                bundle.putFloat(strT, zzhwVar.z());
            } else if (zzhwVar.u()) {
                bundle.putString(strT, zzhwVar.v());
            } else if (zzhwVar.w()) {
                bundle.putLong(strT, zzhwVar.x());
            }
        }
        return bundle;
    }

    public static final com.google.android.gms.internal.measurement.zzhw o(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.s()) {
            if (zzhwVar.t().equals(str)) {
                return zzhwVar;
            }
        }
        return null;
    }

    public static final Serializable p(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        com.google.android.gms.internal.measurement.zzhw zzhwVarO = o(zzhsVar, str);
        if (zzhwVarO == null) {
            return null;
        }
        return v(zzhwVarO);
    }

    public static final void s(int i2, StringBuilder sb) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
    }

    public static final void t(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public static final String u(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Bundle[], java.io.Serializable] */
    public static final Serializable v(com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        if (zzhwVar.u()) {
            return zzhwVar.v();
        }
        if (zzhwVar.w()) {
            return Long.valueOf(zzhwVar.x());
        }
        if (zzhwVar.A()) {
            return Double.valueOf(zzhwVar.B());
        }
        if (zzhwVar.D() > 0) {
            return Q((com.google.android.gms.internal.measurement.zzmn) zzhwVar.C());
        }
        return null;
    }

    public static final void w(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                t(builder, str3, string, set);
            }
        }
    }

    public static final void x(StringBuilder sb, String str, com.google.android.gms.internal.measurement.zzii zziiVar) {
        if (zziiVar == null) {
            return;
        }
        s(3, sb);
        sb.append(str);
        sb.append(" {\n");
        if (zziiVar.v() != 0) {
            s(4, sb);
            sb.append("results: ");
            int i2 = 0;
            for (Long l2 : zziiVar.u()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (zziiVar.t() != 0) {
            s(4, sb);
            sb.append("status: ");
            int i4 = 0;
            for (Long l3 : zziiVar.s()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l3);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (zziiVar.x() != 0) {
            s(4, sb);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zziiVar.w()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(zzhqVar.s() ? Integer.valueOf(zzhqVar.t()) : null);
                sb.append(":");
                sb.append(zzhqVar.u() ? Long.valueOf(zzhqVar.v()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (zziiVar.z() != 0) {
            s(4, sb);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (com.google.android.gms.internal.measurement.zzik zzikVar : zziiVar.y()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(zzikVar.s() ? Integer.valueOf(zzikVar.t()) : null);
                sb.append(": [");
                Iterator it = zzikVar.u().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        s(3, sb);
        sb.append("}\n");
    }

    public static final void y(StringBuilder sb, int i2, String str, Object obj) {
        if (obj == null) {
            return;
        }
        s(i2 + 1, sb);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public static final void z(StringBuilder sb, int i2, String str, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        if (zzflVar == null) {
            return;
        }
        s(i2, sb);
        sb.append(str);
        sb.append(" {\n");
        if (zzflVar.s()) {
            int iC = zzflVar.C();
            y(sb, i2, "comparison_type", iC != 1 ? iC != 2 ? iC != 3 ? iC != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (zzflVar.t()) {
            y(sb, i2, "match_as_float", Boolean.valueOf(zzflVar.u()));
        }
        if (zzflVar.v()) {
            y(sb, i2, "comparison_value", zzflVar.w());
        }
        if (zzflVar.x()) {
            y(sb, i2, "min_comparison_value", zzflVar.y());
        }
        if (zzflVar.z()) {
            y(sb, i2, "max_comparison_value", zzflVar.A());
        }
        s(i2, sb);
        sb.append("}\n");
    }

    public final void A(com.google.android.gms.internal.measurement.zzit zzitVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzitVar.i();
        ((com.google.android.gms.internal.measurement.zziu) zzitVar.f37107b).H();
        zzitVar.i();
        ((com.google.android.gms.internal.measurement.zziu) zzitVar.f37107b).J();
        zzitVar.i();
        ((com.google.android.gms.internal.measurement.zziu) zzitVar.f37107b).L();
        if (obj instanceof String) {
            zzitVar.i();
            ((com.google.android.gms.internal.measurement.zziu) zzitVar.f37107b).G((String) obj);
        } else if (obj instanceof Long) {
            long jLongValue = ((Long) obj).longValue();
            zzitVar.i();
            ((com.google.android.gms.internal.measurement.zziu) zzitVar.f37107b).I(jLongValue);
        } else if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            zzitVar.i();
            ((com.google.android.gms.internal.measurement.zziu) zzitVar.f37107b).K(dDoubleValue);
        } else {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(obj, "Ignoring invalid (type) user attribute value");
        }
    }

    public final void B(com.google.android.gms.internal.measurement.zzhv zzhvVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzhvVar.i();
        ((com.google.android.gms.internal.measurement.zzhw) zzhvVar.f37107b).H();
        zzhvVar.i();
        ((com.google.android.gms.internal.measurement.zzhw) zzhvVar.f37107b).J();
        zzhvVar.i();
        ((com.google.android.gms.internal.measurement.zzhw) zzhvVar.f37107b).L();
        zzhvVar.i();
        ((com.google.android.gms.internal.measurement.zzhw) zzhvVar.f37107b).O();
        if (obj instanceof String) {
            zzhvVar.p((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzhvVar.q(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            zzhvVar.i();
            ((com.google.android.gms.internal.measurement.zzhw) zzhvVar.f37107b).K(dDoubleValue);
            return;
        }
        if (!(obj instanceof Bundle[])) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(obj, "Ignoring invalid (type) event param value");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                com.google.android.gms.internal.measurement.zzhv zzhvVarE = com.google.android.gms.internal.measurement.zzhw.E();
                for (String str : bundle.keySet()) {
                    com.google.android.gms.internal.measurement.zzhv zzhvVarE2 = com.google.android.gms.internal.measurement.zzhw.E();
                    zzhvVarE2.o(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        zzhvVarE2.q(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        zzhvVarE2.p((String) obj2);
                    } else if (obj2 instanceof Double) {
                        double dDoubleValue2 = ((Double) obj2).doubleValue();
                        zzhvVarE2.i();
                        ((com.google.android.gms.internal.measurement.zzhw) zzhvVarE2.f37107b).K(dDoubleValue2);
                    }
                    zzhvVarE.i();
                    ((com.google.android.gms.internal.measurement.zzhw) zzhvVarE.f37107b).M((com.google.android.gms.internal.measurement.zzhw) zzhvVarE2.l());
                }
                if (((com.google.android.gms.internal.measurement.zzhw) zzhvVarE.f37107b).D() > 0) {
                    arrayList.add((com.google.android.gms.internal.measurement.zzhw) zzhvVarE.l());
                }
            }
        }
        zzhvVar.i();
        ((com.google.android.gms.internal.measurement.zzhw) zzhvVar.f37107b).N(arrayList);
    }

    public final zzog C(String str, com.google.android.gms.internal.measurement.zzic zzicVar, com.google.android.gms.internal.measurement.zzhr zzhrVar, String str2) {
        int iIndexOf;
        zzql.a();
        zzib zzibVar = this.f39180a;
        if (!zzibVar.f39087d.q(str, zzfx.P0)) {
            return null;
        }
        long jCurrentTimeMillis = zzibVar.f39094k.currentTimeMillis();
        zzfw zzfwVar = zzfx.u0;
        zzal zzalVar = zzibVar.f39087d;
        Set setI = a.i(zzalVar.m(str, zzfwVar).split(","));
        zzpf zzpfVar = this.f39551b;
        zzot zzotVar = zzpfVar.f39603j;
        zzhs zzhsVar = zzotVar.f39551b.f39594a;
        zzpf.S(zzhsVar);
        String strT = zzhsVar.t(str);
        Uri.Builder builder = new Uri.Builder();
        zzib zzibVar2 = zzotVar.f39180a;
        builder.scheme(zzibVar2.f39087d.m(str, zzfx.n0));
        boolean zIsEmpty = TextUtils.isEmpty(strT);
        zzal zzalVar2 = zzibVar2.f39087d;
        if (zIsEmpty) {
            builder.authority(zzalVar2.m(str, zzfx.o0));
        } else {
            String strM = zzalVar2.m(str, zzfx.o0);
            StringBuilder sb = new StringBuilder(e.g(1, strT) + String.valueOf(strM).length());
            sb.append(strT);
            sb.append(CLConstants.DOT_SALT_DELIMETER);
            sb.append(strM);
            builder.authority(sb.toString());
        }
        builder.path(zzalVar2.m(str, zzfx.p0));
        t(builder, "gmp_app_id", ((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).H(), setI);
        zzalVar.l();
        t(builder, "gmp_version", String.valueOf(130000L), setI);
        String strB = ((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).B();
        zzfw zzfwVar2 = zzfx.S0;
        boolean zQ = zzalVar.q(str, zzfwVar2);
        zzhs zzhsVar2 = zzpfVar.f39594a;
        if (zQ) {
            zzpf.S(zzhsVar2);
            if (zzhsVar2.z(str)) {
                strB = "";
            }
        }
        t(builder, "app_instance_id", strB, setI);
        t(builder, "rdid", ((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).y(), setI);
        t(builder, "bundle_id", zzicVar.x(), setI);
        String strU = zzhrVar.u();
        String strB2 = zzls.b(strU, zzjl.f39203c, zzjl.f39201a);
        if (true != TextUtils.isEmpty(strB2)) {
            strU = strB2;
        }
        t(builder, "app_event_name", strU, setI);
        t(builder, "app_version", String.valueOf(((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).N()), setI);
        String strM2 = ((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).m2();
        if (zzalVar.q(str, zzfwVar2)) {
            zzpf.S(zzhsVar2);
            if (zzhsVar2.y(str) && !TextUtils.isEmpty(strM2) && (iIndexOf = strM2.indexOf(CLConstants.DOT_SALT_DELIMETER)) != -1) {
                strM2 = strM2.substring(0, iIndexOf);
            }
        }
        t(builder, "os_version", strM2, setI);
        t(builder, "timestamp", String.valueOf(zzhrVar.v()), setI);
        if (((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).A()) {
            t(builder, "lat", "1", setI);
        }
        t(builder, "privacy_sandbox_version", String.valueOf(((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).K0()), setI);
        t(builder, "trigger_uri_source", "1", setI);
        t(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setI);
        t(builder, "request_uuid", str2, setI);
        List<com.google.android.gms.internal.measurement.zzhw> listO = zzhrVar.o();
        Bundle bundle = new Bundle();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : listO) {
            String strT2 = zzhwVar.t();
            if (zzhwVar.A()) {
                bundle.putString(strT2, String.valueOf(zzhwVar.B()));
            } else if (zzhwVar.y()) {
                bundle.putString(strT2, String.valueOf(zzhwVar.z()));
            } else if (zzhwVar.u()) {
                bundle.putString(strT2, zzhwVar.v());
            } else if (zzhwVar.w()) {
                bundle.putString(strT2, String.valueOf(zzhwVar.x()));
            }
        }
        w(builder, zzalVar.m(str, zzfx.t0).split(CLConstants.DELIMITER_REGEX), bundle, setI);
        List<com.google.android.gms.internal.measurement.zziu> listUnmodifiableList = Collections.unmodifiableList(((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).Y1());
        Bundle bundle2 = new Bundle();
        for (com.google.android.gms.internal.measurement.zziu zziuVar : listUnmodifiableList) {
            String strU2 = zziuVar.u();
            if (zziuVar.B()) {
                bundle2.putString(strU2, String.valueOf(zziuVar.C()));
            } else if (zziuVar.z()) {
                bundle2.putString(strU2, String.valueOf(zziuVar.A()));
            } else if (zziuVar.v()) {
                bundle2.putString(strU2, zziuVar.w());
            } else if (zziuVar.x()) {
                bundle2.putString(strU2, String.valueOf(zziuVar.y()));
            }
        }
        w(builder, zzalVar.m(str, zzfx.s0).split(CLConstants.DELIMITER_REGEX), bundle2, setI);
        t(builder, "dma", true != ((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).H0() ? "0" : "1", setI);
        if (!((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).J0().isEmpty()) {
            t(builder, "dma_cps", ((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).J0(), setI);
        }
        if (((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).P0()) {
            com.google.android.gms.internal.measurement.zzha zzhaVarQ0 = ((com.google.android.gms.internal.measurement.zzid) zzicVar.f37107b).Q0();
            if (!zzhaVarQ0.D().isEmpty()) {
                t(builder, "dl_gclid", zzhaVarQ0.D(), setI);
            }
            if (!zzhaVarQ0.F().isEmpty()) {
                t(builder, "dl_gbraid", zzhaVarQ0.F(), setI);
            }
            if (!zzhaVarQ0.H().isEmpty()) {
                t(builder, "dl_gs", zzhaVarQ0.H(), setI);
            }
            if (zzhaVarQ0.J() > 0) {
                t(builder, "dl_ss_ts", String.valueOf(zzhaVarQ0.J()), setI);
            }
            if (!zzhaVarQ0.L().isEmpty()) {
                t(builder, "mr_gclid", zzhaVarQ0.L(), setI);
            }
            if (!zzhaVarQ0.N().isEmpty()) {
                t(builder, "mr_gbraid", zzhaVarQ0.N(), setI);
            }
            if (!zzhaVarQ0.P().isEmpty()) {
                t(builder, "mr_gs", zzhaVarQ0.P(), setI);
            }
            if (zzhaVarQ0.R() > 0) {
                t(builder, "mr_click_ts", String.valueOf(zzhaVarQ0.R()), setI);
            }
        }
        return new zzog(1, jCurrentTimeMillis, builder.build().toString());
    }

    public final com.google.android.gms.internal.measurement.zzhs D(zzbb zzbbVar) {
        Bundle bundle;
        com.google.android.gms.internal.measurement.zzhr zzhrVarC = com.google.android.gms.internal.measurement.zzhs.C();
        zzhrVarC.i();
        ((com.google.android.gms.internal.measurement.zzhs) zzhrVarC.f37107b).K(zzbbVar.f38754e);
        zzbe zzbeVar = zzbbVar.f38755f;
        zzbd zzbdVar = new zzbd(zzbeVar);
        while (true) {
            Iterator it = zzbdVar.f38767a;
            boolean zHasNext = it.hasNext();
            bundle = zzbeVar.f38768a;
            if (!zHasNext) {
                break;
            }
            String str = (String) it.next();
            com.google.android.gms.internal.measurement.zzhv zzhvVarE = com.google.android.gms.internal.measurement.zzhw.E();
            zzhvVarE.o(str);
            Object obj = bundle.get(str);
            Preconditions.checkNotNull(obj);
            B(zzhvVarE, obj);
            zzhrVarC.t(zzhvVarE);
        }
        String str2 = zzbbVar.f38752c;
        if (!TextUtils.isEmpty(str2) && bundle.get("_o") == null) {
            com.google.android.gms.internal.measurement.zzhv zzhvVarE2 = com.google.android.gms.internal.measurement.zzhw.E();
            zzhvVarE2.o("_o");
            zzhvVarE2.p(str2);
            zzhrVarC.q((com.google.android.gms.internal.measurement.zzhw) zzhvVarE2.l());
        }
        return (com.google.android.gms.internal.measurement.zzhs) zzhrVarC.l();
    }

    public final String E(com.google.android.gms.internal.measurement.zzib zzibVar) {
        com.google.android.gms.internal.measurement.zzhe zzheVarM0;
        StringBuilder sbW = b.w("\nbatch {\n");
        if (zzibVar.x()) {
            y(sbW, 0, "upload_subdomain", zzibVar.y());
        }
        if (zzibVar.v()) {
            y(sbW, 0, "sgtm_join_id", zzibVar.w());
        }
        for (com.google.android.gms.internal.measurement.zzid zzidVar : zzibVar.s()) {
            if (zzidVar != null) {
                s(1, sbW);
                sbW.append("bundle {\n");
                if (zzidVar.S()) {
                    y(sbW, 1, "protocol_version", Integer.valueOf(zzidVar.T0()));
                }
                zzqu.a();
                zzib zzibVar2 = this.f39180a;
                if (zzibVar2.f39087d.q(zzidVar.s(), zzfx.M0) && zzidVar.z0()) {
                    y(sbW, 1, "session_stitching_token", zzidVar.A0());
                }
                y(sbW, 1, "platform", zzidVar.l2());
                if (zzidVar.u()) {
                    y(sbW, 1, "gmp_version", Long.valueOf(zzidVar.v()));
                }
                if (zzidVar.w()) {
                    y(sbW, 1, "uploading_gmp_version", Long.valueOf(zzidVar.x()));
                }
                if (zzidVar.u0()) {
                    y(sbW, 1, "dynamite_version", Long.valueOf(zzidVar.v0()));
                }
                if (zzidVar.O()) {
                    y(sbW, 1, "config_version", Long.valueOf(zzidVar.P()));
                }
                y(sbW, 1, "gmp_app_id", zzidVar.H());
                y(sbW, 1, "app_id", zzidVar.s());
                y(sbW, 1, "app_version", zzidVar.t());
                if (zzidVar.M()) {
                    y(sbW, 1, "app_version_major", Integer.valueOf(zzidVar.N()));
                }
                y(sbW, 1, "firebase_instance_id", zzidVar.L());
                if (zzidVar.C()) {
                    y(sbW, 1, "dev_cert_hash", Long.valueOf(zzidVar.D()));
                }
                y(sbW, 1, "app_store", zzidVar.r2());
                if (zzidVar.b2()) {
                    y(sbW, 1, "upload_timestamp_millis", Long.valueOf(zzidVar.c2()));
                }
                if (zzidVar.d2()) {
                    y(sbW, 1, "start_timestamp_millis", Long.valueOf(zzidVar.e2()));
                }
                if (zzidVar.f2()) {
                    y(sbW, 1, "end_timestamp_millis", Long.valueOf(zzidVar.g2()));
                }
                if (zzidVar.h2()) {
                    y(sbW, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzidVar.i2()));
                }
                if (zzidVar.j2()) {
                    y(sbW, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzidVar.k2()));
                }
                y(sbW, 1, "app_instance_id", zzidVar.B());
                y(sbW, 1, "resettable_device_id", zzidVar.y());
                y(sbW, 1, "ds_id", zzidVar.R());
                if (zzidVar.z()) {
                    y(sbW, 1, "limited_ad_tracking", Boolean.valueOf(zzidVar.A()));
                }
                y(sbW, 1, "os_version", zzidVar.m2());
                y(sbW, 1, "device_model", zzidVar.n2());
                y(sbW, 1, "user_default_language", zzidVar.o2());
                if (zzidVar.p2()) {
                    y(sbW, 1, "time_zone_offset_minutes", Integer.valueOf(zzidVar.q2()));
                }
                if (zzidVar.E()) {
                    y(sbW, 1, "bundle_sequential_index", Integer.valueOf(zzidVar.F()));
                }
                if (zzidVar.N0()) {
                    y(sbW, 1, "delivery_index", Integer.valueOf(zzidVar.O0()));
                }
                if (zzidVar.I()) {
                    y(sbW, 1, "service_upload", Boolean.valueOf(zzidVar.J()));
                }
                y(sbW, 1, "health_monitor", zzidVar.G());
                if (zzidVar.s0()) {
                    y(sbW, 1, "retry_counter", Integer.valueOf(zzidVar.t0()));
                }
                if (zzidVar.w0()) {
                    y(sbW, 1, "consent_signals", zzidVar.x0());
                }
                if (zzidVar.G0()) {
                    y(sbW, 1, "is_dma_region", Boolean.valueOf(zzidVar.H0()));
                }
                if (zzidVar.I0()) {
                    y(sbW, 1, "core_platform_services", zzidVar.J0());
                }
                if (zzidVar.E0()) {
                    y(sbW, 1, "consent_diagnostics", zzidVar.F0());
                }
                if (zzidVar.B0()) {
                    y(sbW, 1, "target_os_version", Long.valueOf(zzidVar.C0()));
                }
                zzql.a();
                if (zzibVar2.f39087d.q(zzidVar.s(), zzfx.P0)) {
                    y(sbW, 1, "ad_services_version", Integer.valueOf(zzidVar.K0()));
                    if (zzidVar.L0() && (zzheVarM0 = zzidVar.M0()) != null) {
                        s(2, sbW);
                        sbW.append("attribution_eligibility_status {\n");
                        y(sbW, 2, "eligible", Boolean.valueOf(zzheVarM0.s()));
                        y(sbW, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzheVarM0.t()));
                        y(sbW, 2, "pre_r", Boolean.valueOf(zzheVarM0.u()));
                        y(sbW, 2, "r_extensions_too_old", Boolean.valueOf(zzheVarM0.v()));
                        y(sbW, 2, "adservices_extension_too_old", Boolean.valueOf(zzheVarM0.w()));
                        y(sbW, 2, "ad_storage_not_allowed", Boolean.valueOf(zzheVarM0.x()));
                        y(sbW, 2, "measurement_manager_disabled", Boolean.valueOf(zzheVarM0.y()));
                        s(2, sbW);
                        sbW.append("}\n");
                    }
                }
                if (zzidVar.P0()) {
                    com.google.android.gms.internal.measurement.zzha zzhaVarQ0 = zzidVar.Q0();
                    s(2, sbW);
                    sbW.append("ad_campaign_info {\n");
                    if (zzhaVarQ0.C()) {
                        y(sbW, 2, "deep_link_gclid", zzhaVarQ0.D());
                    }
                    if (zzhaVarQ0.E()) {
                        y(sbW, 2, "deep_link_gbraid", zzhaVarQ0.F());
                    }
                    if (zzhaVarQ0.G()) {
                        y(sbW, 2, "deep_link_gad_source", zzhaVarQ0.H());
                    }
                    if (zzhaVarQ0.I()) {
                        y(sbW, 2, "deep_link_session_millis", Long.valueOf(zzhaVarQ0.J()));
                    }
                    if (zzhaVarQ0.K()) {
                        y(sbW, 2, "market_referrer_gclid", zzhaVarQ0.L());
                    }
                    if (zzhaVarQ0.M()) {
                        y(sbW, 2, "market_referrer_gbraid", zzhaVarQ0.N());
                    }
                    if (zzhaVarQ0.O()) {
                        y(sbW, 2, "market_referrer_gad_source", zzhaVarQ0.P());
                    }
                    if (zzhaVarQ0.Q()) {
                        y(sbW, 2, "market_referrer_click_millis", Long.valueOf(zzhaVarQ0.R()));
                    }
                    s(2, sbW);
                    sbW.append("}\n");
                }
                if (zzidVar.T()) {
                    y(sbW, 1, "batching_timestamp_millis", Long.valueOf(zzidVar.U()));
                }
                if (zzidVar.R0()) {
                    com.google.android.gms.internal.measurement.zzis zzisVarS0 = zzidVar.S0();
                    s(2, sbW);
                    sbW.append("sgtm_diagnostics {\n");
                    int iX = zzisVarS0.x();
                    y(sbW, 2, "upload_type", iX != 1 ? iX != 2 ? iX != 3 ? iX != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    y(sbW, 2, "client_upload_eligibility", zzisVarS0.s().name());
                    int iY = zzisVarS0.y();
                    y(sbW, 2, "service_upload_eligibility", iY != 1 ? iY != 2 ? iY != 3 ? iY != 4 ? iY != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    s(2, sbW);
                    sbW.append("}\n");
                }
                if (zzidVar.V()) {
                    com.google.android.gms.internal.measurement.zzho zzhoVarW = zzidVar.W();
                    s(2, sbW);
                    sbW.append("consent_info_extra {\n");
                    for (com.google.android.gms.internal.measurement.zzhl zzhlVar : zzhoVarW.s()) {
                        s(3, sbW);
                        sbW.append("limited_data_modes {\n");
                        int iT = zzhlVar.t();
                        y(sbW, 3, "type", iT != 1 ? iT != 2 ? iT != 3 ? iT != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE" : "CONSENT_TYPE_UNSPECIFIED");
                        int iU = zzhlVar.u();
                        y(sbW, 3, "mode", iU != 1 ? iU != 2 ? "NO_DATA_MODE" : "LIMITED_MODE" : "NOT_LIMITED");
                        s(3, sbW);
                        sbW.append("}\n");
                    }
                    s(2, sbW);
                    sbW.append("}\n");
                }
                com.google.android.gms.internal.measurement.zzmn<com.google.android.gms.internal.measurement.zziu> zzmnVarY1 = zzidVar.Y1();
                zzgm zzgmVar = zzibVar2.f39093j;
                if (zzmnVarY1 != null) {
                    for (com.google.android.gms.internal.measurement.zziu zziuVar : zzmnVarY1) {
                        if (zziuVar != null) {
                            s(2, sbW);
                            sbW.append("user_property {\n");
                            y(sbW, 2, "set_timestamp_millis", zziuVar.s() ? Long.valueOf(zziuVar.t()) : null);
                            y(sbW, 2, CLConstants.FIELD_PAY_INFO_NAME, zzgmVar.c(zziuVar.u()));
                            y(sbW, 2, "string_value", zziuVar.w());
                            y(sbW, 2, "int_value", zziuVar.x() ? Long.valueOf(zziuVar.y()) : null);
                            y(sbW, 2, "double_value", zziuVar.B() ? Double.valueOf(zziuVar.C()) : null);
                            s(2, sbW);
                            sbW.append("}\n");
                        }
                    }
                }
                com.google.android.gms.internal.measurement.zzmn<com.google.android.gms.internal.measurement.zzhg> zzmnVarK = zzidVar.K();
                if (zzmnVarK != null) {
                    for (com.google.android.gms.internal.measurement.zzhg zzhgVar : zzmnVarK) {
                        if (zzhgVar != null) {
                            s(2, sbW);
                            sbW.append("audience_membership {\n");
                            if (zzhgVar.s()) {
                                y(sbW, 2, "audience_id", Integer.valueOf(zzhgVar.t()));
                            }
                            if (zzhgVar.x()) {
                                y(sbW, 2, "new_audience", Boolean.valueOf(zzhgVar.y()));
                            }
                            x(sbW, "current_data", zzhgVar.u());
                            if (zzhgVar.v()) {
                                x(sbW, "previous_data", zzhgVar.w());
                            }
                            s(2, sbW);
                            sbW.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhs> listT1 = zzidVar.T1();
                if (listT1 != null) {
                    for (com.google.android.gms.internal.measurement.zzhs zzhsVar : listT1) {
                        if (zzhsVar != null) {
                            s(2, sbW);
                            sbW.append("event {\n");
                            y(sbW, 2, CLConstants.FIELD_PAY_INFO_NAME, zzgmVar.a(zzhsVar.v()));
                            if (zzhsVar.w()) {
                                y(sbW, 2, "timestamp_millis", Long.valueOf(zzhsVar.x()));
                            }
                            if (zzhsVar.y()) {
                                y(sbW, 2, "previous_timestamp_millis", Long.valueOf(zzhsVar.z()));
                            }
                            if (zzhsVar.A()) {
                                y(sbW, 2, "count", Integer.valueOf(zzhsVar.B()));
                            }
                            if (zzhsVar.t() != 0) {
                                q(sbW, 2, (com.google.android.gms.internal.measurement.zzmn) zzhsVar.s());
                            }
                            s(2, sbW);
                            sbW.append("}\n");
                        }
                    }
                }
                s(1, sbW);
                sbW.append("}\n");
            }
        }
        sbW.append("} // End-of-batch\n");
        return sbW.toString();
    }

    public final String F(com.google.android.gms.internal.measurement.zzfn zzfnVar) {
        StringBuilder sbW = b.w("\nproperty_filter {\n");
        if (zzfnVar.s()) {
            y(sbW, 0, "filter_id", Integer.valueOf(zzfnVar.t()));
        }
        y(sbW, 0, "property_name", this.f39180a.f39093j.c(zzfnVar.u()));
        String strU = u(zzfnVar.w(), zzfnVar.x(), zzfnVar.z());
        if (!strU.isEmpty()) {
            y(sbW, 0, "filter_type", strU);
        }
        r(sbW, 1, zzfnVar.v());
        sbW.append("}\n");
        return sbW.toString();
    }

    public final Parcelable G(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(parcelObtain);
            } catch (SafeParcelReader.ParseException unused) {
                zzgt zzgtVar = this.f39180a.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38958f.a("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            parcelObtain.recycle();
        }
    }

    public final List K(com.google.android.gms.internal.measurement.zzmm zzmmVar, List list) {
        int i2;
        ArrayList arrayList = new ArrayList(zzmmVar);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int iIntValue = num.intValue();
            zzib zzibVar = this.f39180a;
            if (iIntValue < 0) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.f38961i.b(num, "Ignoring negative bit index to be cleared");
            } else {
                int iIntValue2 = num.intValue() / 64;
                if (iIntValue2 >= arrayList.size()) {
                    zzgt zzgtVar2 = zzibVar.f39089f;
                    zzib.l(zzgtVar2);
                    zzgtVar2.f38961i.c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue2, Long.valueOf(((Long) arrayList.get(iIntValue2)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i3 = size2;
            i2 = size;
            size = i3;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i2);
    }

    public final boolean L(long j2, long j3) {
        return j2 == 0 || j3 <= 0 || Math.abs(this.f39180a.f39094k.currentTimeMillis() - j2) > j3;
    }

    public final long M(byte[] bArr) throws NoSuchAlgorithmException {
        Preconditions.checkNotNull(bArr);
        zzib zzibVar = this.f39180a;
        zzpo zzpoVar = zzibVar.f39092i;
        zzib.j(zzpoVar);
        zzpoVar.g();
        MessageDigest messageDigestX = zzpo.x();
        if (messageDigestX != null) {
            return zzpo.y(messageDigestX.digest(bArr));
        }
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38958f.a("Failed to get MD5");
        return 0L;
    }

    public final byte[] N(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(e2, "Failed to gzip content");
            throw e2;
        }
    }

    public final void q(StringBuilder sb, int i2, com.google.android.gms.internal.measurement.zzmn zzmnVar) {
        if (zzmnVar == null) {
            return;
        }
        int i3 = i2 + 1;
        Iterator it = zzmnVar.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            if (zzhwVar != null) {
                s(i3, sb);
                sb.append("param {\n");
                y(sb, i3, CLConstants.FIELD_PAY_INFO_NAME, zzhwVar.s() ? this.f39180a.f39093j.b(zzhwVar.t()) : null);
                y(sb, i3, "string_value", zzhwVar.u() ? zzhwVar.v() : null);
                y(sb, i3, "int_value", zzhwVar.w() ? Long.valueOf(zzhwVar.x()) : null);
                y(sb, i3, "double_value", zzhwVar.A() ? Double.valueOf(zzhwVar.B()) : null);
                if (zzhwVar.D() > 0) {
                    q(sb, i3, (com.google.android.gms.internal.measurement.zzmn) zzhwVar.C());
                }
                s(i3, sb);
                sb.append("}\n");
            }
        }
    }

    public final void r(StringBuilder sb, int i2, com.google.android.gms.internal.measurement.zzfh zzfhVar) {
        String str;
        if (zzfhVar == null) {
            return;
        }
        s(i2, sb);
        sb.append("filter {\n");
        if (zzfhVar.w()) {
            y(sb, i2, "complement", Boolean.valueOf(zzfhVar.x()));
        }
        if (zzfhVar.y()) {
            y(sb, i2, "param_name", this.f39180a.f39093j.b(zzfhVar.z()));
        }
        if (zzfhVar.s()) {
            int i3 = i2 + 1;
            com.google.android.gms.internal.measurement.zzfr zzfrVarT = zzfhVar.t();
            if (zzfrVarT != null) {
                s(i3, sb);
                sb.append("string_filter {\n");
                if (zzfrVarT.s()) {
                    switch (zzfrVarT.A()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    y(sb, i3, "match_type", str);
                }
                if (zzfrVarT.t()) {
                    y(sb, i3, "expression", zzfrVarT.u());
                }
                if (zzfrVarT.v()) {
                    y(sb, i3, "case_sensitive", Boolean.valueOf(zzfrVarT.w()));
                }
                if (zzfrVarT.y() > 0) {
                    s(i2 + 2, sb);
                    sb.append("expression_list {\n");
                    for (String str2 : zzfrVarT.x()) {
                        s(i2 + 3, sb);
                        sb.append(str2);
                        sb.append(StringUtils.LF);
                    }
                    sb.append("}\n");
                }
                s(i3, sb);
                sb.append("}\n");
            }
        }
        if (zzfhVar.u()) {
            z(sb, i2 + 1, "number_filter", zzfhVar.v());
        }
        s(i2, sb);
        sb.append("}\n");
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    public final void j() {
    }
}
