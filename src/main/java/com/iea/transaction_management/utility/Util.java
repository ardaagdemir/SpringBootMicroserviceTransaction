package com.iea.transaction_management.utility;

public final class Util
{
    private Util() {}

    public static void showGeneralExceptionMessage(Exception e)
    {
        System.err.println(e.getClass().getSimpleName() + " has been occured. " +
                "Exception message: " + e.getMessage());
    }
}
