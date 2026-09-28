package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzfhs {

    /* renamed from: a, reason: collision with root package name */
    public final int f31162a;

    /* renamed from: b, reason: collision with root package name */
    public final int f31163b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f31164c;

    public zzfhs(int i2, int i3, boolean z) {
        this.f31162a = i2;
        this.f31163b = i3;
        this.f31164c = z;
    }

    public static ArrayList a(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int iNextInt = 0;
            int iNextInt2 = 0;
            boolean zNextBoolean = false;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (Snapshot.WIDTH.equals(strNextName)) {
                    iNextInt = jsonReader.nextInt();
                } else if (Snapshot.HEIGHT.equals(strNextName)) {
                    iNextInt2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(strNextName)) {
                    zNextBoolean = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzfhs(iNextInt, iNextInt2, zNextBoolean));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
