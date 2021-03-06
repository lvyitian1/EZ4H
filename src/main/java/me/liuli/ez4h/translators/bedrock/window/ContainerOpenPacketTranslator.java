package me.liuli.ez4h.translators.bedrock.window;

import com.github.steveice10.mc.protocol.data.game.window.WindowType;
import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.ContainerOpenPacket;
import me.liuli.ez4h.minecraft.Client;
import me.liuli.ez4h.minecraft.data.world.ChestData;
import me.liuli.ez4h.translators.BedrockTranslator;

public class ContainerOpenPacketTranslator implements BedrockTranslator {
    @Override
    public void translate(BedrockPacket inPacket, Client client) {
        ContainerOpenPacket packet = (ContainerOpenPacket) inPacket;
        if (packet.getId() == 0) return;
        switch (packet.getType()) {
            case CONTAINER: {
                //bedrock dont send slots data in this packet.slot count send to client in InventoryContentPacket
                client.getData().setQueueChest(new ChestData(packet.getId(), "", WindowType.CHEST));
                break;
            }
        }
    }

    @Override
    public Class<? extends BedrockPacket> getPacketClass() {
        return ContainerOpenPacket.class;
    }
}
