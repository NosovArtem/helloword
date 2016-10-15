package ru.sberbank.school.helloworld.tasks.lesson08.encrypted;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class EncryptedLoader extends ClassLoader {

    private final String rootDirectory;

    private final String key;

    public EncryptedLoader(String rootDirectory, String key) {
        this.rootDirectory = rootDirectory;
        this.key = key;
    }

    public Class<?> load(String className) throws ClassNotFoundException {

        Class<?> result = findPlugin(className);

        return result;
    }

    public Class<?> findPlugin(String name) throws ClassNotFoundException {
        Class result;

        File f = findFile(name);

        if (f == null) {
            return findClass(name);
        }


        try {
           // byte[] classDecryptBytes = Files.readAllBytes(f.toPath());
             byte[] classDecryptBytes = decrypt(f, key);
            result = defineClass(name.replace("\\", "."), classDecryptBytes, 0, classDecryptBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException("Format of class file incorrect for class " + name + ": " + e);
        }
        return result;
    }

    private File findFile(String name) {
        File f = new File(rootDirectory.replace('/', File.separatorChar) + File.separatorChar + name.replace('/', File.separatorChar) + ".class");
        if (f.exists()) {
            return f;
        } else {
            return null;
        }
    }

    public byte[] decrypt(File file, String keyWord) throws IOException {
        byte[] classBytes = Files.readAllBytes(file.toPath());
        byte[] result = new byte[classBytes.length];
        byte[] keyarr = keyWord.getBytes();
        for (int i = 0; i < classBytes.length; i++) {
            result[i] = (byte) (classBytes[i] ^ keyarr[i % keyarr.length]);
        }
        return result;
    }

}