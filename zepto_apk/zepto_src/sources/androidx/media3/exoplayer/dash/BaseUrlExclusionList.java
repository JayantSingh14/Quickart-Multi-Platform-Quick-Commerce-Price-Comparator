package androidx.media3.exoplayer.dash;

import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.dash.manifest.BaseUrl;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@UnstableApi
/* loaded from: classes3.dex */
public final class BaseUrlExclusionList {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6673a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f6674b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6675c;

    /* renamed from: d, reason: collision with root package name */
    public final Random f6676d;

    public BaseUrlExclusionList() {
        Random random = new Random();
        this.f6675c = new HashMap();
        this.f6676d = random;
        this.f6673a = new HashMap();
        this.f6674b = new HashMap();
    }

    public static void b(long j2, HashMap map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Long) entry.getValue()).longValue() <= j2) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            map.remove(arrayList.get(i2));
        }
    }

    public final ArrayList a(List list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map = this.f6673a;
        b(jElapsedRealtime, map);
        HashMap map2 = this.f6674b;
        b(jElapsedRealtime, map2);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            BaseUrl baseUrl = (BaseUrl) list.get(i2);
            if (!map.containsKey(baseUrl.f6786b) && !map2.containsKey(Integer.valueOf(baseUrl.f6787c))) {
                arrayList.add(baseUrl);
            }
        }
        return arrayList;
    }

    public final BaseUrl c(List list) {
        BaseUrl baseUrl;
        ArrayList arrayListA = a(list);
        if (arrayListA.size() < 2) {
            return (BaseUrl) Iterators.i(arrayListA.iterator(), null);
        }
        Collections.sort(arrayListA, new a());
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = ((BaseUrl) arrayListA.get(0)).f6787c;
        int i4 = 0;
        while (true) {
            if (i4 >= arrayListA.size()) {
                break;
            }
            BaseUrl baseUrl2 = (BaseUrl) arrayListA.get(i4);
            if (i3 == baseUrl2.f6787c) {
                arrayList.add(new Pair(baseUrl2.f6786b, Integer.valueOf(baseUrl2.f6788d)));
                i4++;
            } else if (arrayList.size() == 1) {
                return (BaseUrl) arrayListA.get(0);
            }
        }
        HashMap map = this.f6675c;
        BaseUrl baseUrl3 = (BaseUrl) map.get(arrayList);
        if (baseUrl3 != null) {
            return baseUrl3;
        }
        List listSubList = arrayListA.subList(0, arrayList.size());
        int i5 = 0;
        for (int i6 = 0; i6 < listSubList.size(); i6++) {
            i5 += ((BaseUrl) listSubList.get(i6)).f6788d;
        }
        int iNextInt = this.f6676d.nextInt(i5);
        int i7 = 0;
        while (true) {
            if (i2 >= listSubList.size()) {
                baseUrl = (BaseUrl) Iterables.c(listSubList);
                break;
            }
            baseUrl = (BaseUrl) listSubList.get(i2);
            i7 += baseUrl.f6788d;
            if (iNextInt < i7) {
                break;
            }
            i2++;
        }
        map.put(arrayList, baseUrl);
        return baseUrl;
    }
}
