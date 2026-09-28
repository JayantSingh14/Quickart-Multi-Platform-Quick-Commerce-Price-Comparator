package com.google.android.play.core.splitinstall.testing;

import android.support.v4.media.b;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes4.dex */
public final class zzaa {

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.android.play.core.splitinstall.internal.zzu f42025c = new com.google.android.play.core.splitinstall.internal.zzu("LocalTestingConfigParser");

    /* renamed from: a, reason: collision with root package name */
    public final XmlPullParser f42026a;

    /* renamed from: b, reason: collision with root package name */
    public final zza f42027b;

    public zzaa(XmlPullParser xmlPullParser) {
        this.f42026a = xmlPullParser;
        zzv zzvVar = zzv.f42068a;
        zza zzaVar = new zza();
        zzaVar.f42024b = new HashMap();
        this.f42027b = zzaVar;
    }

    public static zzv a(File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        File file2 = new File(file, "local_testing_config.xml");
        if (!file2.exists()) {
            return zzv.f42068a;
        }
        try {
            FileReader fileReader = new FileReader(file2);
            try {
                XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                xmlPullParserNewPullParser.setInput(fileReader);
                final zzaa zzaaVar = new zzaa(xmlPullParserNewPullParser);
                zzaaVar.b("local-testing-config", new zzz() { // from class: com.google.android.play.core.splitinstall.testing.zzy
                    @Override // com.google.android.play.core.splitinstall.testing.zzz
                    public final void zza() throws XmlPullParserException, IOException {
                        final zzaa zzaaVar2 = this.f42071a;
                        zzaaVar2.b("split-install-errors", new zzz() { // from class: com.google.android.play.core.splitinstall.testing.zzx
                            @Override // com.google.android.play.core.splitinstall.testing.zzz
                            public final void zza() throws XmlPullParserException, IOException {
                                int i2 = 0;
                                while (true) {
                                    final zzaa zzaaVar3 = zzaaVar2;
                                    XmlPullParser xmlPullParser = zzaaVar3.f42026a;
                                    if (i2 >= xmlPullParser.getAttributeCount()) {
                                        zzaaVar3.b("split-install-error", new zzz() { // from class: com.google.android.play.core.splitinstall.testing.zzw
                                            @Override // com.google.android.play.core.splitinstall.testing.zzz
                                            public final void zza() throws XmlPullParserException {
                                                zzaa zzaaVar4;
                                                XmlPullParser xmlPullParser2;
                                                int i3 = 0;
                                                String attributeValue = null;
                                                String attributeValue2 = null;
                                                while (true) {
                                                    zzaaVar4 = zzaaVar3;
                                                    xmlPullParser2 = zzaaVar4.f42026a;
                                                    if (i3 >= xmlPullParser2.getAttributeCount()) {
                                                        break;
                                                    }
                                                    if ("module".equals(xmlPullParser2.getAttributeName(i3))) {
                                                        attributeValue = xmlPullParser2.getAttributeValue(i3);
                                                    }
                                                    if (CLConstants.FIELD_ERROR_CODE.equals(xmlPullParser2.getAttributeName(i3))) {
                                                        attributeValue2 = xmlPullParser2.getAttributeValue(i3);
                                                    }
                                                    i3++;
                                                }
                                                if (attributeValue == null || attributeValue2 == null) {
                                                    throw new XmlPullParserException("'split-install-error' element does not contain 'module'/'errorCode' attributes.", xmlPullParser2, null);
                                                }
                                                Integer num = (Integer) com.google.android.play.core.splitinstall.model.zza.f42009c.get(attributeValue2);
                                                if (num == null) {
                                                    throw new IllegalArgumentException(attributeValue2.concat(" is unknown error."));
                                                }
                                                zzaaVar4.f42027b.b().put(attributeValue, num);
                                                while (xmlPullParser2.next() != 3) {
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    if ("defaultErrorCode".equals(xmlPullParser.getAttributeName(i2))) {
                                        String attributeValue = xmlPullParser.getAttributeValue(i2);
                                        Integer num = (Integer) com.google.android.play.core.splitinstall.model.zza.f42009c.get(attributeValue);
                                        if (num == null) {
                                            throw new IllegalArgumentException(String.valueOf(attributeValue).concat(" is unknown error."));
                                        }
                                        zzaaVar3.f42027b.f42023a = num;
                                    }
                                    i2++;
                                }
                            }
                        });
                    }
                });
                zza zzaVar = zzaaVar.f42027b;
                zzaVar.a(Collections.unmodifiableMap(zzaVar.b()));
                if (zzaVar.f42024b == null) {
                    throw new IllegalStateException("Missing required properties: splitInstallErrorCodeByModule");
                }
                zzc zzcVar = new zzc(zzaVar.f42023a, zzaVar.f42024b);
                fileReader.close();
                return zzcVar;
            } catch (Throwable th) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (IOException | RuntimeException | XmlPullParserException e2) {
            f42025c.e("%s can not be parsed, using default. Error: %s", "local_testing_config.xml", e2.getMessage());
            return zzv.f42068a;
        }
    }

    public final void b(String str, zzz zzzVar) throws XmlPullParserException, IOException {
        while (true) {
            XmlPullParser xmlPullParser = this.f42026a;
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                if (!xmlPullParser.getName().equals(str)) {
                    throw new XmlPullParserException(b.m("Expected '", str, "' tag but found '", xmlPullParser.getName(), "'."), xmlPullParser, null);
                }
                zzzVar.zza();
            }
        }
    }
}
