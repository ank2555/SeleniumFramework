package org.selenium.pom.utils;

import net.sourceforge.tess4j.*;

import java.io.*;

public class TextImage {

    public String getImgText(File imageLocation) {
        ITesseract iT = new Tesseract();
        try {
            String imgText = iT.doOCR(imageLocation);
            return imgText;
        } catch (TesseractException e) {
            e.getMessage();
            return "Error Retruning while image";
        }
    }

}
