package com.lfg.informatik.q11.quizzing4abi.model_io;

import android.content.Context;

import com.lfg.informatik.q11.quizzing4abi.ExceptionHandler;
import com.lfg.informatik.q11.quizzing4abi.MainActivity;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Chris on 11.07.2015.
 * Provides reading and writing access to the internal storage of the app.
 * It is also possible to read raw resources or to use the utility stream functions.
 * Note: Before usage the MainActivity has to be set!
 */

public class FileIO
{
    private static MainActivity mainActivity = null;

    /**
     * Sets the context that holds the internal storage and the resources.
     * @param mainActivity a valid MainActivity
     */
    public static void setMainActivity(MainActivity mainActivity)
    {
        FileIO.mainActivity = mainActivity;
    }

    /**
     * Checks if a file exists in the internal storage of the app.
     * @param filename the filename + file extensions
     * @return true if the file exists
     */
    public static boolean checkFileExistence(String filename)
    {
        File file = mainActivity.getFileStreamPath(filename);
        return !(file == null || !file.exists());
    }

    /**
     * Opens a file from the internal storage of the app.
     * @param filename name of the file + file extension (e.g. "test.xml")
     * @return the InputStream belonging to the file. Don´t forget to close it after use!
     * @throws FileNotFoundException
     */
    public static InputStream openInputFile(String filename) throws FileNotFoundException
    {
        return mainActivity.openFileInput(filename);
    }

    /**
     * Opens a file from the internal storage of the app.
     * @param filename name of the file + file extension (e.g. "test.xml")
     * @return the OutputStream belonging to the file. Don´t forget to close it after use!
     * @throws FileNotFoundException
     */
    public static OutputStream openOutputFile(String filename) throws FileNotFoundException
    {
        return mainActivity.openFileOutput(filename, Context.MODE_PRIVATE);
    }

    /**
     * Opens a raw resource.
     * @param rawID the id of the raw resource
     * @return the InputStream belonging to the resource. Don´t forget to close it after use!
     */
    public static InputStream openRawResource(int rawID)
    {
        return mainActivity.getResources().openRawResource(rawID);
    }

    /**
     * Converts an InputStream to an OutputStream.
     * (writes the input stream into the output stream)
     * @param in a valid InputStream
     * @param out a valid OutputStream
     * @throws IOException
     */
    public static void inputToOutput(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;

        while((read = in.read(buffer)) != -1)
            out.write(buffer, 0, read);
    }

    /**
     * Closes a stream if isn´t null.
     * @param stream an Input- / or OutputStream
     * @return true if the stream has been closed
     */
    public static boolean closeStream(Closeable stream)
    {
        if(stream != null)
        {
            try
            {
                stream.close();
                return true;
            }
            catch (IOException e)
            {
                ExceptionHandler.showAlertDialog("Closing stream failed. Error: "
                        + e.getMessage());
                return false;
            }
        }

        return false;
    }
}
