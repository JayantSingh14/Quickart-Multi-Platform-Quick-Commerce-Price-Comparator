package androidx.databinding;

import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public class MergedDataBinderMapper extends DataBinderMapper {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f3362a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f3363b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f3364c = new CopyOnWriteArrayList();

    public final void b(DataBinderMapper dataBinderMapper) {
        if (this.f3362a.add(dataBinderMapper.getClass())) {
            this.f3363b.add(dataBinderMapper);
            Iterator it = dataBinderMapper.a().iterator();
            while (it.hasNext()) {
                b((DataBinderMapper) it.next());
            }
        }
    }
}
