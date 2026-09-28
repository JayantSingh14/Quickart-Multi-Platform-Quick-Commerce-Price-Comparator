package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzoo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzoo(zza = zzad.class)
/* loaded from: classes3.dex */
public abstract class zzbt implements com.google.ads.interactivemedia.v3.api.zzb {
    public abstract String alternateText();

    public abstract int duration();

    public abstract List<zzbs> fallbackImages();

    public int getDuration() {
        return duration();
    }

    public int getHeight() {
        return height();
    }

    public List getIconClickFallbackImages() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzbs> it = fallbackImages().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // com.google.ads.interactivemedia.v3.api.zzb
    public int getId() {
        return id();
    }

    public int getOffset() {
        return offset();
    }

    public double getPixelRatio() {
        return pixelRatio();
    }

    public String getResourceUri() {
        return imageUrl();
    }

    public int getWidth() {
        return width();
    }

    public String getXPosition() {
        return xPosition();
    }

    public String getYPosition() {
        return yPosition();
    }

    public abstract int height();

    public abstract int id();

    public abstract String imageUrl();

    public abstract int offset();

    public abstract double pixelRatio();

    public abstract int width();

    public abstract String xPosition();

    public abstract String yPosition();
}
