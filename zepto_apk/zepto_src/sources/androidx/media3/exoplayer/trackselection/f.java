package androidx.media3.exoplayer.trackselection;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.source.TrackGroupArray;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        trackGroupArray.getClass();
        Bundle bundle = new Bundle();
        ImmutableList immutableList = trackGroupArray.f7772b;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(immutableList.size());
        Iterator<E> it = immutableList.iterator();
        while (it.hasNext()) {
            arrayList.add(((TrackGroup) it.next()).e());
        }
        bundle.putParcelableArrayList(TrackGroupArray.f7770e, arrayList);
        return bundle;
    }
}
