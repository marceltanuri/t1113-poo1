import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestsExecutor {

    private static final List<TestCaseExecutionReport> testCaseExecutionReports = new ArrayList<>();

    public static void execute(String testsPackage) {
        List<Class<?>> classes = findClassesInPackage(testsPackage);

        for (Class<?> clazz : classes) {
            if (isRunnableTestClass(clazz)) {
                List<TestCaseExecutionReport> reports = executeRunMethod(clazz);
                if (reports != null) {
                    testCaseExecutionReports.addAll(reports);
                }
            }
        }

        testCaseExecutionReports.forEach(System.out::println);
        long totalTests = testCaseExecutionReports.size();
        long successCount = testCaseExecutionReports.stream().filter(TestCaseExecutionReport::isSuccess).count();
        long failureCount = totalTests - successCount;

        double successPercentage = (double) successCount / totalTests * 100;
        double failurePercentage = (double) failureCount / totalTests * 100;

        System.out.printf("Testes executados: %d\n", totalTests);
        System.out.printf("Testes com sucesso: %d (%.2f%%)\n", successCount, successPercentage);
        System.out.printf("Testes com falha: %d (%.2f%%)\n", failureCount, failurePercentage);
    }

    private static List<Class<?>> findClassesInPackage(String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        // Nome do seu pacote
        String path = packageName.replace('.', File.separatorChar);
        try {
            String[] classpathEntries = System.getProperty("java.class.path").split(File.pathSeparator);
            for (String classpathEntry : classpathEntries) {
                File file = new File(classpathEntry, path);
                if (file.exists()) {
                    classes.addAll(findClassesInDirectory(file, packageName));
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classes;
    }

    private static List<Class<?>> findClassesInDirectory(File directory, String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    classes.addAll(findClassesInDirectory(file, packageName + "." + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    String className = getClassNameFromFile(file, packageName);
                    classes.add(Class.forName(className));
                }
            }
        }
        return classes;
    }

    private static String getClassNameFromFile(File file, String packageName) {
        String fileName = file.getName();
        return packageName + '.' + fileName.substring(0, fileName.lastIndexOf('.'));
    }

    private static boolean isRunnableTestClass(Class<?> clazz) {
        return TestClass.class.isAssignableFrom(clazz) && !clazz.isInterface() && !clazz.isAnnotation() && !clazz.isEnum() && !Modifier.isAbstract(clazz.getModifiers());
    }

    @SuppressWarnings("unchecked")
    private static List<TestCaseExecutionReport> executeRunMethod(Class<?> clazz) {
        try {
            Method runMethod = clazz.getMethod("run");
            Object instance = clazz.getDeclaredConstructor().newInstance();
            System.out.println("Método 'run' da classe '" + clazz.getName() + "' executado.");
            return (List<TestCaseExecutionReport>) runMethod.invoke(instance);
        } catch (ReflectiveOperationException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }
}
