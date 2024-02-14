package aula5.strategy.tests.core;

public class TestCaseExecutionReport {

    private final boolean success;
    private final String className;

    private final String methodName;

    private String message;

    public TestCaseExecutionReport(boolean success, String className, String methodName) {
        this.success = success;
        this.className = className;
        this.methodName = methodName;
    }

    public TestCaseExecutionReport(boolean success, String className, String methodName, String message) {
        this.success = success;
        this.className = className;
        this.methodName = methodName;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "TestCaseExecutionReport{" +
                "success=" + success +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
