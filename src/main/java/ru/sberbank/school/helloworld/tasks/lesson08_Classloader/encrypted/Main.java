package ru.sberbank.school.helloworld.tasks.lesson08_Classloader.encrypted;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static byte[] encrypt(File f, String keyWord) throws IOException {
        byte[] arr = Files.readAllBytes(f.toPath());
        byte[] keyarr = keyWord.getBytes();
        byte[] result = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (byte) (arr[i] + keyarr.length);
        }
        return result;
    }

    public static void main(String[] args) throws IOException, IllegalAccessException,
            InstantiationException, ClassNotFoundException {

        final String rootDirectory = "C:\\SBTJavaSchool\\projectHelloWorld\\helloworld\\target\\classes";
        final String className = "ru\\sberbank\\school\\helloworld\\tasks\\lesson08_Classloader\\encrypted\\plugin\\MyPlugin";
        final String key = "KEY";

        String fileRead = rootDirectory + "\\" + className + ".class";
        File file = new File(fileRead);
        byte[] test = Files.readAllBytes(file.toPath());
        byte[] encryptByte = encrypt(file, key);
        String fileEncryptWrite = rootDirectory + "\\" + className + "Encrypt.class";
        Files.write(Paths.get(fileEncryptWrite), encryptByte);

        //+ "Encrypt"
        EncryptedLoader pluginManager = new EncryptedLoader(rootDirectory, key);
        Plugin plugin1 = (Plugin) pluginManager.load(className + "Encrypt").newInstance();
        plugin1.doUseful();


    }
}