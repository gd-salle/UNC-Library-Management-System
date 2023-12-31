package org.unc.lms.codes.components;

//QRCodeGenerator.java
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class QRCodeGenerator {

 // Generate a QR code image from a text
 public byte[] generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {
     QRCodeWriter qrCodeWriter = new QRCodeWriter();
     BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

     // Customize the QR code colors
     int foregroundColor = 0xFF000000; // black
     int backgroundColor = 0xFFFFFFFF; // white
     Map<EncodeHintType, Object> hints = new HashMap<>();
     hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
     bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

     // Convert the BitMatrix to a BufferedImage
     BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
     bufferedImage.createGraphics();

     Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
     graphics.setColor(Color.WHITE);
     graphics.fillRect(0, 0, width, height);
     graphics.setColor(Color.BLACK);

     for (int i = 0; i < width; i++) {
         for (int j = 0; j < height; j++) {
             if (bitMatrix.get(i, j)) {
                 graphics.fillRect(i, j, 1, 1);
             }
         }
     }

     // Convert the BufferedImage to a byte array
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     ImageIO.write(bufferedImage, "png", baos);
     return baos.toByteArray();
 }
}

