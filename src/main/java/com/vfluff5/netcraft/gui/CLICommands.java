package com.vfluff5.netcraft.gui;

import org.lwjgl.Sys;

/**
 * Created by Vincent on 4/3/2015.
 */
public class CLICommands {



    public static String[] LaunchCommand(String command, EnumMode mode)
    {
        //The first param is the message to be displayed to the user.
        //The second one is to be passed to the other class to tell it
        //What to do if there is any special instructions..
        String temp[] = {"Invalid Command", ""};


        ////////////////////////////////////////////////
        ////////////////////enable//////////////////////
        ////////////////////////////////////////////////
        if(command.toLowerCase().equals("enable") && mode.equals(EnumMode.UserEXEC))
        {
            temp[0] = "Entered Privileged EXEC Mode";
            temp[1] = "EPE";
            return temp;
        }


        ////////////////////////////////////////////////
        /////////////configure terminal/////////////////
        ////////////////////////////////////////////////
        if(command.toLowerCase().equals("configure terminal") && mode.equals(EnumMode.PrivilegedEXEC))
        {
            temp[0] = "Entered Global Configuration Mode";
            temp[1] = "EGC";
            return temp;
        }

        ////////////////////////////////////////////////
        //////////////////////exit//////////////////////
        ////////////////////////////////////////////////
        if(command.toLowerCase().equals("exit"))
        {
            if(mode.equals(EnumMode.PrivilegedEXEC))
            {
                temp[0] = "Entered User EXEC Mode";
                temp[1] = "EUE";
                return temp;
            }
            if(mode.equals(EnumMode.GlobalConfiguration))
            {
                temp[0] = "Entered Privileged EXEC Mode";
                temp[1] = "EPE";
                return temp;
            }
        }

        ////////////////////////////////////////////////
        ///////////////////hostname/////////////////////
        ////////////////////////////////////////////////

        if(command.toLowerCase().contains("hostname") && mode.equals(EnumMode.GlobalConfiguration))
        {
            System.out.println(command.length());
            if(command.length() > 9)
            {
                System.out.println(command.substring(0,8));
                if(command.substring(0,8).toLowerCase().equals("hostname")) {
                    temp[0] = "Set router hostname to " + command.substring(8, command.length()) + ".";
                    temp[1] = "hostname " + command.substring(8, command.length());
                    return temp;
                }
                else
                {
                    temp[0] = "Command: hostname <name>";
                    return temp;
                }
            }
            else
            {
                temp[0] = "Command: hostname <name>";
                return temp;
            }
        }

        ////////////////////////////////////////////////
        ///////////////enable password//////////////////
        ////////////////////////////////////////////////
        if(command.toLowerCase().contains("enable") && command.toLowerCase().contains("password") && mode.equals(EnumMode.GlobalConfiguration))
        {
            if(command.length() > 16)
                if(command.substring(0,6).toLowerCase().equals("enable"))
                    if(command.substring(8,16).toLowerCase().equals("password"))
                    {

                    }
        }

        return temp;
    }



}
