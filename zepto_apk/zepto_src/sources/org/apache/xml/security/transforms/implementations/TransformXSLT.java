package org.apache.xml.security.transforms.implementations;

import com.google.android.gms.internal.pal.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class TransformXSLT extends TransformSpi {

    /* renamed from: b, reason: collision with root package name */
    static Log f57298b;

    /* renamed from: c, reason: collision with root package name */
    static Class f57299c;

    /* renamed from: d, reason: collision with root package name */
    static Class f57300d;

    /* renamed from: e, reason: collision with root package name */
    private static Class f57301e;

    static {
        try {
            f57301e = Class.forName("javax.xml.XMLConstants");
        } catch (Exception unused) {
        }
        Class clsA = f57299c;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.transforms.implementations.TransformXSLT");
            f57299c = clsA;
        }
        f57298b = LogFactory.getLog(clsA.getName());
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    @Override // org.apache.xml.security.transforms.TransformSpi
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream, Transform transform) throws Throwable {
        if (f57301e == null) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{"SECURE_PROCESSING_FEATURE not supported"});
        }
        try {
            Element elementA = XMLUtils.a(transform.k().getFirstChild(), "http://www.w3.org/1999/XSL/Transform", "stylesheet", 0);
            if (elementA == null) {
                throw new TransformationException("xml.WrongContent", new Object[]{"xslt:stylesheet", "Transform"});
            }
            TransformerFactory transformerFactoryNewInstance = TransformerFactory.newInstance();
            Class<?> cls = transformerFactoryNewInstance.getClass();
            Class clsA = f57300d;
            if (clsA == null) {
                clsA = a("java.lang.String");
                f57300d = clsA;
            }
            cls.getMethod("setFeature", clsA, Boolean.TYPE).invoke(transformerFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", Boolean.TRUE);
            StreamSource streamSource = new StreamSource(new ByteArrayInputStream(xMLSignatureInput.e()));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            transformerFactoryNewInstance.newTransformer().transform(new DOMSource(elementA), new StreamResult(byteArrayOutputStream));
            Transformer transformerNewTransformer = transformerFactoryNewInstance.newTransformer(new StreamSource(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
            try {
                transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xalan}line-separator", StringUtils.LF);
            } catch (Exception e2) {
                Log log = f57298b;
                StringBuffer stringBuffer = new StringBuffer("Unable to set Xalan line-separator property: ");
                stringBuffer.append(e2.getMessage());
                log.warn(stringBuffer.toString());
            }
            if (outputStream == null) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                transformerNewTransformer.transform(streamSource, new StreamResult(byteArrayOutputStream2));
                return new XMLSignatureInput(byteArrayOutputStream2.toByteArray());
            }
            transformerNewTransformer.transform(streamSource, new StreamResult(outputStream));
            XMLSignatureInput xMLSignatureInput2 = new XMLSignatureInput((byte[]) null);
            xMLSignatureInput2.b(outputStream);
            return xMLSignatureInput2;
        } catch (IllegalAccessException e3) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e3.getMessage()}, e3);
        } catch (NoSuchMethodException e4) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e4.getMessage()}, e4);
        } catch (InvocationTargetException e5) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e5.getMessage()}, e5);
        } catch (TransformerConfigurationException e6) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e6.getMessage()}, e6);
        } catch (TransformerException e7) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e7.getMessage()}, e7);
        } catch (XMLSecurityException e8) {
            throw new TransformationException("generic.EmptyMessage", new Object[]{e8.getMessage()}, e8);
        }
    }

    @Override // org.apache.xml.security.transforms.TransformSpi
    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        return a(xMLSignatureInput, null, transform);
    }
}
