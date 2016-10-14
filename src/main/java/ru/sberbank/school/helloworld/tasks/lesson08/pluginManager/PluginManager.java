package ru.sberbank.school.helloworld.tasks.lesson08.pluginManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class PluginManager extends ClassLoader {

    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    public Class<?> load(String pluginName, String pluginClassName) throws ClassNotFoundException {

        String path = pluginName + "." + pluginClassName;
        Class<?> result = findPlugin(path);
        return result;
    }

    public Class<?> findPlugin(String name) throws ClassNotFoundException {
        Class result;

        File f = findFile(name.replace('.', File.separatorChar));

        if (f == null) {
            return findClass(name);
        }


        try {
            byte[] classBytes = loadFileAsBytes(f);
            result = defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException("Format of class file incorrect for class " + name + ": " + e);
        }

        return result;
    }

    private File findFile(String name) {
        File f = new File(pluginRootDirectory + File.separatorChar + name.replace('/', File.separatorChar) + ".class");
        if (f.exists()) {
            return f;
        } else {
            return null;
        }
    }

    public static byte[] loadFileAsBytes(File file) throws IOException {
        byte[] result = new byte[(int) file.length()];
        FileInputStream f = new FileInputStream(file);
        try {
            f.read(result, 0, result.length);
        } finally {
            try {
                f.close();
            } catch (Exception e) {
            }
        }
        return result;
    }

}