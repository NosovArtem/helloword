package ru.sberbank.school.helloworld.tasks.lesson08_Classloader.pluginManager;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;


public class PluginLoader extends ClassLoader {

    private final String pluginRootDirectory;

    public PluginLoader(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
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
            byte[] classBytes = Files.readAllBytes(f.toPath());
            result = defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException("Format of class file incorrect for class " + name + ": " + e);
        }

        return result;
    }

    private File findFile(String name) {
        File f = new File(pluginRootDirectory + File.separatorChar + name + ".class");
        if (f.exists()) {
            return f;
        } else {
            return null;
        }
    }

}