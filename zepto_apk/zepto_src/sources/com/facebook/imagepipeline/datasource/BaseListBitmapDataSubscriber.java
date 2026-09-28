package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>> {
    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void f(DataSource dataSource) {
        if (dataSource.b()) {
            List<CloseableReference> list = (List) dataSource.a();
            if (list == null) {
                g();
                return;
            }
            try {
                ArrayList arrayList = new ArrayList(list.size());
                for (CloseableReference closeableReference : list) {
                    if (closeableReference == null || !(closeableReference.l() instanceof CloseableBitmap)) {
                        arrayList.add(null);
                    } else {
                        arrayList.add(((CloseableBitmap) closeableReference.l()).v1());
                    }
                }
                g();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    CloseableReference.e((CloseableReference) it.next());
                }
            } catch (Throwable th) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    CloseableReference.e((CloseableReference) it2.next());
                }
                throw th;
            }
        }
    }

    public abstract void g();
}
