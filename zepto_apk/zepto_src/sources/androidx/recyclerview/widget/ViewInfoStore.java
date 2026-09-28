package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.LongSparseArrayKt;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
class ViewInfoStore {

    /* renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f11714a = new SimpleArrayMap();

    /* renamed from: b, reason: collision with root package name */
    public final LongSparseArray f11715b = new LongSparseArray();

    public static class InfoRecord {

        /* renamed from: d, reason: collision with root package name */
        public static final Pools.SimplePool f11716d = new Pools.SimplePool(20);

        /* renamed from: a, reason: collision with root package name */
        public int f11717a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.ItemAnimator.ItemHolderInfo f11718b;

        /* renamed from: c, reason: collision with root package name */
        public RecyclerView.ItemAnimator.ItemHolderInfo f11719c;

        public static InfoRecord a() {
            InfoRecord infoRecord = (InfoRecord) f11716d.b();
            return infoRecord == null ? new InfoRecord() : infoRecord;
        }
    }

    public interface ProcessCallback {
    }

    public final void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        SimpleArrayMap simpleArrayMap = this.f11714a;
        InfoRecord infoRecordA = (InfoRecord) simpleArrayMap.get(viewHolder);
        if (infoRecordA == null) {
            infoRecordA = InfoRecord.a();
            simpleArrayMap.put(viewHolder, infoRecordA);
        }
        infoRecordA.f11719c = itemHolderInfo;
        infoRecordA.f11717a |= 8;
    }

    public final RecyclerView.ItemAnimator.ItemHolderInfo b(RecyclerView.ViewHolder viewHolder, int i2) {
        InfoRecord infoRecord;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        SimpleArrayMap simpleArrayMap = this.f11714a;
        int iD = simpleArrayMap.d(viewHolder);
        if (iD >= 0 && (infoRecord = (InfoRecord) simpleArrayMap.j(iD)) != null) {
            int i3 = infoRecord.f11717a;
            if ((i3 & i2) != 0) {
                int i4 = i3 & (~i2);
                infoRecord.f11717a = i4;
                if (i2 == 4) {
                    itemHolderInfo = infoRecord.f11718b;
                } else {
                    if (i2 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    itemHolderInfo = infoRecord.f11719c;
                }
                if ((i4 & 12) == 0) {
                    simpleArrayMap.h(iD);
                    infoRecord.f11717a = 0;
                    infoRecord.f11718b = null;
                    infoRecord.f11719c = null;
                    InfoRecord.f11716d.a(infoRecord);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    public final void c(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = (InfoRecord) this.f11714a.get(viewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.f11717a &= -2;
    }

    public final void d(RecyclerView.ViewHolder viewHolder) {
        LongSparseArray longSparseArray = this.f11715b;
        int iH = longSparseArray.h() - 1;
        while (true) {
            if (iH < 0) {
                break;
            }
            if (viewHolder == longSparseArray.i(iH)) {
                Object[] objArr = longSparseArray.f1478c;
                Object obj = objArr[iH];
                Object obj2 = LongSparseArrayKt.f1480a;
                if (obj != obj2) {
                    objArr[iH] = obj2;
                    longSparseArray.f1476a = true;
                }
            } else {
                iH--;
            }
        }
        InfoRecord infoRecord = (InfoRecord) this.f11714a.remove(viewHolder);
        if (infoRecord != null) {
            infoRecord.f11717a = 0;
            infoRecord.f11718b = null;
            infoRecord.f11719c = null;
            InfoRecord.f11716d.a(infoRecord);
        }
    }
}
