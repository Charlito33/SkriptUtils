package fr.charlito33.skriptutils.httputils.utils;

public class HTTPRequestSaver {
    private static int responseCode;
    private static String responseContent;

    public static void saveResponseContent(String content) {
        HTTPRequestSaver.responseContent = content;
    }

    public static void saveResponseCode(int responseCode) {
        HTTPRequestSaver.responseCode = responseCode;
    }

    public static String getResponseContent() {
        return responseContent;
    }

    public static int getResponseCode() {
        return responseCode;
    }
}
