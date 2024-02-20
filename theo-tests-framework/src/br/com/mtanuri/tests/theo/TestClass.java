import exception.TestException;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TestClass {

    public List<TestCaseExecutionReport> run() {
        List<TestCaseExecutionReport> testCaseExecutionReports = new ArrayList<>(10);
        Class<?> clazz = this.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (!Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                try {
                    if (throwsTestException(method)) {
                        method.setAccessible(true); // Tornar método acessível se necessário
                        method.invoke(this);
                        testCaseExecutionReports.add(new TestCaseExecutionReport(true, clazz.getName(), method.getName()));
                    }
                } catch (Exception e) {
                    testCaseExecutionReports.add(new TestCaseExecutionReport(false, clazz.getName(), method.getName(), e.getCause().getMessage()));
                }
            }
        }
        return testCaseExecutionReports;
    }

    private boolean throwsTestException(Method method) {
        return Arrays.stream(method.getExceptionTypes()).anyMatch(e -> e.equals(TestException.class));
    }

}
