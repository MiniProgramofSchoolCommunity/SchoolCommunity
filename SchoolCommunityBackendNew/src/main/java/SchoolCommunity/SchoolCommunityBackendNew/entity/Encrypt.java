package SchoolCommunity.SchoolCommunityBackendNew.entity;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encrypt {
    public static String encrypt(String string) {
        if (string == null) {
            return null;
        } else {
            BigInteger sha = null;
            byte[] inputData = string.getBytes();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(inputData);
                sha = new BigInteger(messageDigest.digest());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (sha != null) {
                return sha.toString(32);
            } else {
                return null;
            }
        }
    }
}
