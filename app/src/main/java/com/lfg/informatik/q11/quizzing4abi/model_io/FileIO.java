package com.lfg.informatik.q11.quizzing4abi.model_io;

import android.content.Context;

import com.lfg.informatik.q11.quizzing4abi.MainActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Chris on 11.07.2015.
 * Provides reading and writing access to the internal storage of the app.
 * Is is also possible to read raw resources.
 */

public class FileIO
{
    private static MainActivity mainActivity = null;

    public static void setMainActivity(MainActivity mainActivity)
    {
        FileIO.mainActivity = mainActivity;
    }

    // TODO
    public static boolean checkFileExistence(String filename)
    {
        File file = mainActivity.getFileStreamPath(filename);
        return !(file == null || !file.exists());
    }

    /**
     * Opens a file from the internal storage of the app.
     * @param filename name of the file + file extension (e.g. "test.xml")
     * @return the InputStream balonging to the file.
     * @throws FileNotFoundException
     */
    public static InputStream openInputFile(String filename) throws FileNotFoundException
    {
        return mainActivity.openFileInput(filename);
    }

    // TODO
    public static OutputStream openOutputFile(String filename) throws FileNotFoundException
    {
        return mainActivity.openFileOutput(filename, Context.MODE_PRIVATE);
    }

    // TODO
    public static InputStream openRawResource(int rawID)
    {
        return mainActivity.getResources().openRawResource(rawID);
    }

    // TODO
    public static void inputToOutput(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;

        while((read = in.read(buffer)) != -1)
            out.write(buffer, 0, read);
    }
}
