package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
class ActivityChooserModel extends DataSetObservable {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f736h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap f737i = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Object f738a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f739b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f740c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ActivitySorter f741d;

    /* renamed from: e, reason: collision with root package name */
    public final int f742e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f743f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f744g;

    public interface ActivityChooserModelClient {
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        @Override // java.lang.Comparable
        public final int compareTo(ActivityResolveInfo activityResolveInfo) {
            activityResolveInfo.getClass();
            return Float.floatToIntBits(0.0f) - Float.floatToIntBits(0.0f);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ActivityResolveInfo.class != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(0.0f) == Float.floatToIntBits(0.0f);
        }

        public final int hashCode() {
            return Float.floatToIntBits(0.0f) + 31;
        }

        public final String toString() {
            throw null;
        }
    }

    public interface ActivitySorter {
    }

    public static final class DefaultSorter implements ActivitySorter {
    }

    public static final class HistoricalRecord {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f745a;

        /* renamed from: b, reason: collision with root package name */
        public final long f746b;

        /* renamed from: c, reason: collision with root package name */
        public final float f747c;

        public HistoricalRecord(ComponentName componentName, long j2, float f2) {
            this.f745a = componentName;
            this.f746b = j2;
            this.f747c = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = historicalRecord.f745a;
            ComponentName componentName2 = this.f745a;
            if (componentName2 == null) {
                if (componentName != null) {
                    return false;
                }
            } else if (!componentName2.equals(componentName)) {
                return false;
            }
            return this.f746b == historicalRecord.f746b && Float.floatToIntBits(this.f747c) == Float.floatToIntBits(historicalRecord.f747c);
        }

        public final int hashCode() {
            ComponentName componentName = this.f745a;
            int iHashCode = componentName == null ? 0 : componentName.hashCode();
            long j2 = this.f746b;
            return Float.floatToIntBits(this.f747c) + ((((iHashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
        }

        public final String toString() {
            return "[; activity:" + this.f745a + "; time:" + this.f746b + "; weight:" + new BigDecimal(this.f747c) + "]";
        }
    }

    public interface OnChooseActivityListener {
    }

    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        @Override // android.os.AsyncTask
        public final Void doInBackground(Object[] objArr) {
            throw null;
        }
    }

    public ActivityChooserModel() {
        DefaultSorter defaultSorter = new DefaultSorter();
        new HashMap();
        this.f741d = defaultSorter;
        this.f742e = 50;
        this.f743f = true;
        this.f744g = true;
        throw null;
    }

    public static ActivityChooserModel b() {
        ActivityChooserModel activityChooserModel;
        synchronized (f736h) {
            try {
                activityChooserModel = (ActivityChooserModel) f737i.get(null);
                if (activityChooserModel == null) {
                    new ActivityChooserModel();
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityChooserModel;
    }

    public final void a() {
        if (this.f743f && this.f744g && !TextUtils.isEmpty(null)) {
            this.f743f = false;
            throw null;
        }
        ArrayList arrayList = this.f740c;
        int size = arrayList.size() - this.f742e;
        if (size <= 0) {
            return;
        }
        this.f744g = true;
        for (int i2 = 0; i2 < size; i2++) {
        }
    }

    public final int c() {
        int size;
        synchronized (this.f738a) {
            a();
            size = this.f739b.size();
        }
        return size;
    }

    public final ResolveInfo d() {
        synchronized (this.f738a) {
            try {
                a();
                if (!this.f739b.isEmpty()) {
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return null;
    }
}
