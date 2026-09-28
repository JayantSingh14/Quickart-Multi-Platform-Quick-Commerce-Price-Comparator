package ch.qos.logback.core.net;

import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class HardenedObjectInputStream extends ObjectInputStream {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f13602b = {"java.lang", "java.util"};

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13603a;

    public HardenedObjectInputStream(InputStream inputStream, ArrayList arrayList) {
        super(inputStream);
        ArrayList arrayList2 = new ArrayList();
        this.f13603a = arrayList2;
        arrayList2.addAll(arrayList);
    }

    @Override // java.io.ObjectInputStream
    public final Class resolveClass(ObjectStreamClass objectStreamClass) throws InvalidClassException {
        String name = objectStreamClass.getName();
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                Iterator it = this.f13603a.iterator();
                while (it.hasNext()) {
                    if (name.equals((String) it.next())) {
                    }
                }
                throw new InvalidClassException("Unauthorized deserialization attempt", objectStreamClass.getName());
            }
            if (name.startsWith(f13602b[i2])) {
                break;
            }
            i2++;
        }
        return super.resolveClass(objectStreamClass);
    }
}
