package com.google.android.exoplayer2.upstream.vocabimate_stream;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesEncryptionUtil {
	public static byte[] encrypt(String key, String initVector, byte[] value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value);
//			System.out.println(encrypted);
			String fileInString = new String(android.util.Base64.encode(encrypted, android.util.Base64.DEFAULT));
//      String fileInString = Base64.encodeBase64String(encrypted);
//			System.out.println("encrypted string: " + fileInString);
			byte[] fileInBytes = fileInString.getBytes();

			return fileInBytes;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

    public static  byte[] decrypt(String key, String initVector, byte[] encodedfileInBytes) {
        try {
        	String encodedfileInString=new String(encodedfileInBytes);
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
          byte[] decodeFileInBytes=  android.util.Base64.decode(encodedfileInString, android.util.Base64.DEFAULT);
            byte[] originalFile = cipher.doFinal(decodeFileInBytes);

            return originalFile;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    
//  public static void main(String[] args) {
//
//	  File file = new File("D:\\crypt0.key");
//	  //init array with file length
//	  byte[] bytesArray = new byte[(int) file.length()];
//	  try {
//	  FileInputStream fis = new FileInputStream(file);
//
//		fis.read(bytesArray);
//		  fis.close();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} //read file into bytes[]
//
//
//
//    byte[] c=  encrypt("Bar12345Bar12345", "pppppppppppppppp",bytesArray);
//
//    File fileIntermediate = new File("D:\\crypt0_interm.key");
//    try {
//		  FileOutputStream fisIntrim = new FileOutputStream(fileIntermediate);
//
//		  fisIntrim.write(c);
//		  fisIntrim.close();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} //read file into bytes[]
//
//
//
//    byte[] d=	decrypt("Bar12345Bar12345", "pppppppppppppppp",c);
//
//    File file2 = new File("D:\\crypt0_decryted.key");
//	  //init array with file length
////	  byte[] bytesArray2 = new byte[(int) bytesArray.length];
//	  try {
//		  FileOutputStream fis2 = new FileOutputStream(file2);
//
//		fis2.write(d);
//		  fis2.close();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} //read file into bytes[]
//
//
//    System.out.println(new String(d));
//}
    
    
    
}
