package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class RefCountCloseableReference<T> extends CloseableReference<T> {
    @Override // com.facebook.common.references.CloseableReference
    /* renamed from: a */
    public final CloseableReference clone() {
        Preconditions.e(x());
        return new RefCountCloseableReference(this.f17110b, this.f17111c, this.f17112d);
    }
}
