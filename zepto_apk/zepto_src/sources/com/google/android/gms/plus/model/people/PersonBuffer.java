package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.plus.zzac;
import com.google.android.gms.internal.plus.zzr;

@VisibleForTesting
@Deprecated
/* loaded from: classes4.dex */
public final class PersonBuffer extends AbstractDataBuffer<Person> {

    /* renamed from: a, reason: collision with root package name */
    public final DataBufferSafeParcelable f39710a;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.getMetadata() == null || !dataHolder.getMetadata().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.f39710a = null;
        } else {
            this.f39710a = new DataBufferSafeParcelable(dataHolder, zzr.CREATOR);
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final Object get(int i2) {
        DataBufferSafeParcelable dataBufferSafeParcelable = this.f39710a;
        return dataBufferSafeParcelable != null ? (Person) dataBufferSafeParcelable.get(i2) : new zzac(this.mDataHolder, i2);
    }
}
