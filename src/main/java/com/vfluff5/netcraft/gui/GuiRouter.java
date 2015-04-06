package com.vfluff5.netcraft.gui;

import com.vfluff5.netcraft.tileentities.TileEntityRouter;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.Console;

public class GuiRouter extends GuiScreen {
    private GuiTextField userCommandBox;
    private GuiTextField cliOutput;
    private EnumMode mode = EnumMode.UserEXEC;
    //private GuiButton exit;
    private String currentMode = "Mode: User EXEC";
    private String test = "Test";


    //Loading router data
    //TileEntityRouter routerEntity;
    public String fe01IP, fe01SubnetMask;
    public String fe02IP, fe02SubnetMask;
    public String fe03IP, fe03SubnetMask;
    public String fe04IP, fe04SubnetMask;
    private String Hostname;
    private String Username;
    private String Password;
    private  NBTTagCompound nbt;
    //


    private int ConsoleLength = 38;

    private int CurrentLine = 2;
    private GuiLabel line = new GuiLabel(fontRendererObj, width / 2 - 100, height / 2 - 100 ,1 ,1 ,1,0);
    private String lines[] = {"##Netcraft NOS v1.0 Dev##","##A Cisco IOS unoffocial interpreter##"," "," "," "," "," "," "," "," "," "," "," "," "," "," "};

    @SideOnly(Side.SERVER)
    public GuiRouter(TileEntityRouter router) {
        nbt = router.getTileData();
        Hostname = nbt.getString("Hostname");
        Username = nbt.getString("Username");
        Password = nbt.getString("Password");
        fe01IP = nbt.getString("IP fe01");
        fe02IP = nbt.getString("IP fe02");
        fe03IP = nbt.getString("IP fe03");
        fe04IP = nbt.getString("IP fe04");
        fe01SubnetMask = nbt.getString("SubnetMask fe01");
        fe02SubnetMask = nbt.getString("SubnetMask fe02");
        fe03SubnetMask = nbt.getString("SubnetMask fe03");
        fe04SubnetMask = nbt.getString("SubnetMask fe04");

    }
    @SideOnly(Side.CLIENT)
    @Override
    public void initGui() {


        //exit = (new GuiButton(0, this.width / 2 - 100, height / 2 + 100, 200, 20, "Exit"));
        userCommandBox = new GuiTextField(1, fontRendererObj, width / 2 - 100, height / 2 + 78, 200, 20);
        cliOutput = new GuiTextField(2, fontRendererObj, width / 2 - 100, height / 2 - 100, 200, 170);
        cliOutput.setText("");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void drawScreen(int par1, int par2, float par3) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "CLI", this.width / 2, 10, 16777215);
        cliOutput.drawTextBox();
        userCommandBox.drawTextBox();
        //exit.drawButton(mc, par1, par2);
        int formatting = 21;
        for(int i = 0; i < lines.length; i++) {
            line.drawCenteredString(fontRendererObj, lines[i], width / 2, formatting, 16777215);
            formatting += 10;
        }
        line.drawCenteredString(fontRendererObj, currentMode + " Hostname:" + (Hostname == "" ? "Router" : Hostname) + " Username:" + (Username == "" ? "Not Set" : Username), width / 2, 0, 16777215);
        super.drawScreen(par1, par2, par3);
    }
    private void FormatAndOutput(String string)
    {
        int linesToTake = 1;
        Console.out().println(string);
        int stringLength;
        for(stringLength = string.length(); (stringLength - ConsoleLength) > 0; stringLength -= ConsoleLength)
        {
            Console.out().print(stringLength);
            linesToTake++;
        }
        Console.out().println(string+":"+linesToTake);
        //Okay! Now that we know how many lines we need to allocate in the console
        //Now we can allocate the strings in the console properly..
        if(linesToTake+CurrentLine < lines.length)
        {
            //There are lines literally beggins for something to be in them...
            //That sounded far to sexual for coding.
            int charactersScanned = 0; //For the substrings
            int t = 0;
            for(int i = CurrentLine; i < linesToTake+CurrentLine; i++)
            {
                t = i + 1;
                if(t == linesToTake+CurrentLine)
                {
                    lines[i] = string.substring(charactersScanned, string.length());
                }
                else {
                    lines[i] = string.substring(charactersScanned, charactersScanned + ConsoleLength);
                    charactersScanned += ConsoleLength;
                }

            }
            CurrentLine += linesToTake;
        }
        else
        {
            //Lets say your console is all filled up. Oh no what to do?
            //Well this code down here will handle filled up consoles!


            //What do you do when you dont have enough lines? You make them of coarse... basically.
            int p = 0;
            for(int i = 0; i < lines.length - linesToTake; i++)
            {
                p = i+1;
                lines[i] = lines[p];
            }
            CurrentLine = lines.length - linesToTake;
            //There are lines literally beggins for something to be in them...
            //That sounded far to sexual for coding.
            int charactersScanned = 0; //For the substrings
            int t = 0;
            for(int i = CurrentLine; i < linesToTake+CurrentLine; i++)
            {
                t = i + 1;
                if(t == linesToTake+CurrentLine)
                {
                    lines[i] = string.substring(charactersScanned, string.length());
                }
                else {
                    lines[i] = string.substring(charactersScanned, charactersScanned + ConsoleLength);
                    charactersScanned += ConsoleLength;
                }

            }
            CurrentLine += linesToTake;
        }
    }
    @SideOnly(Side.SERVER)
    public void SetNBT(NBTTagCompound a, String name, String value)
    {
        a.setString(name, value);
    }
    @SideOnly(Side.CLIENT)
    @Override
    protected void keyTyped(char par1, int par2) {
        userCommandBox.textboxKeyTyped(par1, par2);
        if(par1 == 27)
        {
            this.mc.displayGuiScreen(null);
        }
        if (par1 == 13) {//enter pressed
            String temp[] = CLICommands.LaunchCommand(userCommandBox.getText(), mode);
            if(temp[1].toLowerCase().equals("epe")) {
                currentMode = "Mode: Privileged EXEC";
                mode = EnumMode.PrivilegedEXEC;
            }
            if(temp[1].toLowerCase().equals("egc")) {
                currentMode = "Mode: Global Conf";
                mode = EnumMode.GlobalConfiguration;
            }
            if(temp[1].toLowerCase().equals("eue")) {
                currentMode = "Mode: User EXEC";
                mode = EnumMode.UserEXEC;
            }
            if(temp[1].toLowerCase().contains("hostname"))
            {
                Hostname = temp[1].replace("hostname ","");
                SetNBT(nbt, "Hostname", temp[1].replace("hostname ",""));
            }

            //Lets check to see if the command is bigger than the alloted space in the console...

            FormatAndOutput(userCommandBox.getText());
            FormatAndOutput(temp[0]);
            userCommandBox.setText("");
            //actionPerformed((GuiButton)this.buttonList.get(1));
        }
    }
    @SideOnly(Side.CLIENT)
    @Override
    protected void mouseClicked(int par1, int par2, int par3) {
        userCommandBox.mouseClicked(par1, par2, par3);
        //exit.mousePressed(mc, par1, par2);
    }
    @SideOnly(Side.CLIENT)
    @Override
    protected void actionPerformed(GuiButton par1GuiButton) {
        if (par1GuiButton.id == 0) {
            this.mc.displayGuiScreen(null);
        }


    }
    @SideOnly(Side.CLIENT)
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}