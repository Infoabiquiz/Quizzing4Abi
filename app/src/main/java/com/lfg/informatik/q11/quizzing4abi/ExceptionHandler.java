package com.lfg.informatik.q11.quizzing4abi;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by Chris on 04.07.2015.
 * Global exception handler, which could log an exception or show an alert.
 * If no context is set, then the exception message will be printed to the console.
 * Usage example: Use this class to handle all subsystem specific exceptions at boundary classes.
 */

public class ExceptionHandler
{
    private static Context context = null;

    /**
     * Shows an alert dialog of an exception message, if context isn´t null.
     * Otherwise the exception message will be printed
     * to the console (used for debugging and testing purposes).
     * @param throwable exception
     */
    public static void handleException(Throwable throwable)
    {
        if(context == null)
        {
            throwable.printStackTrace();
        }
        else
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(throwable.getMessage());
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    /**
     * Shows an alert dialog, if a context is specified. Otherwise the message will be
     * printed to the console.
     * @param message the message text
     */
    public static void showAlertDialog(String message)
    {
        System.out.println(message);

        if (context != null)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(message);
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    /**
     * Sets the android context, on which the exception should be handled.
     * If you set a context, you won´t be able to switch back to the console.
     * @param context an android context
     */
    public static void setContext(Context context)
    {
        if(ExceptionHandler.context == null)
            ExceptionHandler.context = context;
    }
}
