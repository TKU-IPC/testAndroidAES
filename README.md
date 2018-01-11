# testAndroidAES
AES128 & AES 256 for Android
AES 128：
    String _plainText = "This is the text to be encrypted"; // 明文
    String _iv = "275d75495a3d196e";  // Vector
    String _key = "b16920894899c7780b5fc7161560a412"; // Key
    String _cypherText = ""; // 密文
    
    // 加密
    _cypherText = AES128Helper.AESEncrypt(_plainText, _key);
    // 解密
    AES128Helper.AESDecrypt(_cypherText, _key)
