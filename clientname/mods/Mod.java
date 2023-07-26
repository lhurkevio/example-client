package clientname.mods;

import clientname.Client;
import clientname.event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Mod {
    private boolean isEnable = true;

    protected final Minecraft mc;
    protected final FontRenderer font;
    protected final Client client;

    public Mod(){
        this.mc = Minecraft.getMinecraft();
        this.font = this.mc.fontRendererObj;
        this.client = Client.getInstance();

        setEnable(isEnable);
    }

    private void setEnable(boolean isEnable) {
        this.isEnable = isEnable;

        if(isEnable){
            EventManager.register(this);
        }
        else{
            EventManager.unregister(this);
        }
    }

    public boolean isEnable() {
        return isEnable;
    }
}
