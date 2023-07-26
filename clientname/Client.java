package clientname;

import clientname.event.EventManager;
import clientname.event.EventTarget;
import clientname.event.impl.ClientTickEvent;
import clientname.gui.SplashProgress;
import clientname.gui.hud.HUDManager;
import clientname.mods.ModInstances;
import net.minecraft.client.Minecraft;

public class Client {
    private static final Client INSTANCE = new Client();

    public static final Client getInstance(){
        return INSTANCE;
    }

    private HUDManager hudManager;

    public void init(){

        SplashProgress.setProgress(1, "VatLog Client - INICIANDO!");
        EventManager.register(this);
    }
    public void start(){
        hudManager = HUDManager.getInstance();
        ModInstances.register(hudManager);
    }
    @EventTarget
    public void onTick(ClientTickEvent e){
        if(Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()){
            hudManager.openConfigScreen();
        }
    }
}
