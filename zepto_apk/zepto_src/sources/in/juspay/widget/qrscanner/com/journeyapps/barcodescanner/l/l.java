package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.l;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f49162a = "l";

    public class a implements Comparator<in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i f49163a;

        public a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar) {
            this.f49163a = iVar;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar2) {
            return Float.compare(l.this.a(iVar2, this.f49163a), l.this.a(iVar, this.f49163a));
        }
    }

    public abstract float a(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar2);

    public List<in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i> a(List<in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i> list, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar) {
        if (iVar == null) {
            return list;
        }
        Collections.sort(list, new a(iVar));
        return list;
    }

    public abstract Rect b(in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar2);

    public in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i b(List<in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i> list, in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i iVar) {
        List<in.juspay.widget.qrscanner.com.journeyapps.barcodescanner.i> listA = a(list, iVar);
        String str = f49162a;
        Log.i(str, "Viewfinder size: " + iVar);
        Log.i(str, "Preview in order of preference: " + listA);
        return listA.get(0);
    }
}
