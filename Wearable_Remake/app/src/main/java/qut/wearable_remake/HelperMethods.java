package qut.wearable_remake;

import android.app.Activity;
import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;

class HelperMethods {


    /**
     * TODO Check if previous install
     * Checks to see if there is an existing instance of the application.
     *
     * @return True is installed, otherwise false.
     */
    public static boolean isInstalled() {
        return false;
    }

//    /**
//     * Converts the contents of an input stream to a string.
//     *
//     * @param stream The input stream to be converted.
//     * @return The contents of the input stream as a string.
//     * @throws IOException
//     */
//    private static String streamToString(InputStream stream) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//        StringBuilder sb = new StringBuilder();
//        @SuppressWarnings("UnusedAssignment")
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//            sb.append(line).append("\n");
//        }
//        reader.close();
//        return sb.toString();
//    } // end streamToString()
//
//    /**
//     * Reads a given file and returns its contents as a string.
//     *
//     * @param filePath The filepath of the file to be read.
//     * @return The string contents of the file.
//     * @throws IOException
//     */
//    public static String getStrFromFile(String filePath) throws IOException {
//        File file = new File(filePath);
//        FileInputStream stream = new FileInputStream(file);
//        String str = streamToString(stream);
//
//        stream.close();
//        return str;
//    } // end getStrFromFile()

    /**
     * Writes a given string to a given file.
     *
     * @param filename The filepath of the file to be edited.
     * @param content The string that will be written.
     * @param activity The activity used to obtain the filepath.
     */
    public static void writeToFile(String filename, String content, Activity activity) {
        try {
            FileOutputStream fos = activity.openFileOutput(filename, Context.MODE_APPEND);
            fos.write(content.getBytes());
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    } // end writeToFile()
}